package com.tencent.ttpic.filter;

import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.ttpic.model.FabbyFaceActionCounter;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.AudioUtils;
import com.tencent.ttpic.util.AudioUtils.Player;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoPrefsUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FabbyFilters
{
  private final String audioFile;
  private final String dataPath;
  private List<FabbyMvFilter> fabbyMvFilters = new ArrayList();
  private List<Long> mBaseOffsetTimeList = new ArrayList();
  private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bcE);
  private int mLastRenderPartIndex;
  private long mLastTriggerTime;
  private int mMvPartIndex;
  private long mOffsetTimeFromTrigger;
  private AudioUtils.Player mPlayer;
  private long mStartTime;
  private long mTransitionDeadLine;
  private h mTransitionFrame = new h();
  private TransitionFilter transitionFilter = new TransitionFilter();
  
  public FabbyFilters(List<FabbyMvFilter> paramList, String paramString1, String paramString2)
  {
    this.fabbyMvFilters = paramList;
    this.dataPath = paramString1;
    this.audioFile = paramString2;
    initBaseOffsetTime();
  }
  
  private void createAudioPlayer()
  {
    if ((!TextUtils.isEmpty(this.audioFile)) && (this.mPlayer == null) && (!VideoPrefsUtil.getMaterialMute())) {
      this.mPlayer = AudioUtils.createPlayer(VideoGlobalContext.getContext(), this.dataPath + File.separator + this.audioFile, true);
    }
  }
  
  private void initBaseOffsetTime()
  {
    long l = 0L;
    int i = 0;
    while (i < this.fabbyMvFilters.size())
    {
      l += ((FabbyMvFilter)this.fabbyMvFilters.get(i)).mvPart.duration;
      this.mBaseOffsetTimeList.add(Long.valueOf(l));
      i += 1;
    }
  }
  
  private boolean isCurrentPartActionTrigger()
  {
    FabbyMvFilter localFabbyMvFilter = (FabbyMvFilter)this.fabbyMvFilters.get(this.mMvPartIndex);
    return (localFabbyMvFilter.mvPart.transitionItem != null) && (localFabbyMvFilter.mvPart.transitionItem.triggerType > 1);
  }
  
  private void reset(long paramLong)
  {
    this.mStartTime = paramLong;
    this.mMvPartIndex = 0;
    this.mLastRenderPartIndex = 0;
    this.mOffsetTimeFromTrigger = 0L;
    createAudioPlayer();
    AudioUtils.startPlayer(this.mPlayer, true);
    Iterator localIterator = this.fabbyMvFilters.iterator();
    while (localIterator.hasNext()) {
      ((FabbyMvFilter)localIterator.next()).reset();
    }
  }
  
  private void updateCurrentPartIndex(Set<Integer> paramSet, long paramLong)
  {
    int i = 1;
    int j = 0;
    if (isCurrentPartActionTrigger())
    {
      FabbyMvFilter localFabbyMvFilter = (FabbyMvFilter)this.fabbyMvFilters.get(this.mMvPartIndex);
      j = localFabbyMvFilter.mvPart.transitionItem.triggerType;
      if ((VideoMaterialUtil.isFaceTriggerType(j)) && (paramSet.contains(Integer.valueOf(j))) && (paramLong - this.mLastTriggerTime > 1000L)) {}
      for (;;)
      {
        if (i != 0)
        {
          this.mLastTriggerTime = paramLong;
          this.mOffsetTimeFromTrigger = (paramLong - (((Long)this.mBaseOffsetTimeList.get(this.mMvPartIndex)).longValue() + this.mStartTime));
          updateTransitionParam(localFabbyMvFilter.mvPart.transitionDuration + paramLong);
          this.mMvPartIndex = ((this.mMvPartIndex + 1) % this.fabbyMvFilters.size());
          if (this.mMvPartIndex == 0) {
            reset(paramLong);
          }
        }
        this.mLastRenderPartIndex = this.mMvPartIndex;
        return;
        i = 0;
      }
    }
    long l1 = this.mStartTime;
    long l2 = this.mOffsetTimeFromTrigger;
    i = 0;
    label195:
    if (i < this.fabbyMvFilters.size()) {
      if (((Long)this.mBaseOffsetTimeList.get(i)).longValue() >= paramLong - l1 - l2) {
        this.mMvPartIndex = i;
      }
    }
    for (i = j;; i = 1)
    {
      if (i != 0)
      {
        reset(paramLong);
        break;
        i += 1;
        break label195;
      }
      if (this.mMvPartIndex == this.mLastRenderPartIndex) {
        break;
      }
      paramLong = this.mStartTime;
      l1 = ((Long)this.mBaseOffsetTimeList.get(this.mLastRenderPartIndex)).longValue();
      updateTransitionParam(((FabbyMvFilter)this.fabbyMvFilters.get(this.mLastRenderPartIndex)).mvPart.transitionDuration + (paramLong + l1) + this.mOffsetTimeFromTrigger);
      break;
    }
  }
  
  private void updateTransitionParam(long paramLong)
  {
    FabbyMvFilter localFabbyMvFilter = (FabbyMvFilter)this.fabbyMvFilters.get(this.mLastRenderPartIndex);
    if ((localFabbyMvFilter != null) && (localFabbyMvFilter.mvPart != null) && (localFabbyMvFilter.getLastRenderFrame() != null))
    {
      BenchUtil.benchStart("[showPreview][FABBY] setTransitionParam");
      this.transitionFilter.setMvPart(((FabbyMvFilter)this.fabbyMvFilters.get(this.mLastRenderPartIndex)).mvPart);
      this.transitionFilter.setLastTex(((FabbyMvFilter)this.fabbyMvFilters.get(this.mLastRenderPartIndex)).getLastRenderFrame().texture[0]);
      BenchUtil.benchEnd("[showPreview][FABBY] setTransitionParam");
      this.mTransitionDeadLine = paramLong;
      return;
    }
    this.mTransitionDeadLine = 0L;
  }
  
  public void ApplyGLSLFilter(String paramString)
  {
    Iterator localIterator = this.fabbyMvFilters.iterator();
    while (localIterator.hasNext()) {
      ((FabbyMvFilter)localIterator.next()).ApplyGLSLFilter();
    }
    this.transitionFilter.ApplyGLSLFilter(paramString);
    this.mCopyFilter.ApplyGLSLFilter();
  }
  
  public void clear()
  {
    Iterator localIterator = this.fabbyMvFilters.iterator();
    while (localIterator.hasNext()) {
      ((FabbyMvFilter)localIterator.next()).clear();
    }
    this.mTransitionFrame.clear();
    this.transitionFilter.ClearGLSL();
    this.mCopyFilter.clearGLSLSelf();
  }
  
  public void destroyAudio()
  {
    AudioUtils.destroyPlayer(this.mPlayer);
    this.mPlayer = null;
  }
  
  public void setRenderMode(int paramInt)
  {
    Iterator localIterator = this.fabbyMvFilters.iterator();
    while (localIterator.hasNext()) {
      ((FabbyMvFilter)localIterator.next()).setRenderMode(paramInt);
    }
    this.transitionFilter.setRenderMode(paramInt);
  }
  
  public h updateAndRender(h paramh, Map<Integer, h> paramMap, Map<Integer, FaceActionCounter> paramMap1, Set<Integer> paramSet, long paramLong)
  {
    paramMap1 = (FabbyMvFilter)this.fabbyMvFilters.get(this.mMvPartIndex);
    if (VideoPrefsUtil.getMaterialMute()) {
      destroyAudio();
    }
    for (;;)
    {
      paramh = paramMap1.updateAndRender(paramh, paramMap, paramLong);
      if ((paramLong > this.mTransitionDeadLine) || (!this.transitionFilter.needRender())) {
        break;
      }
      BenchUtil.benchStart("[showPreview][FABBY] transition");
      this.transitionFilter.updatePreview(paramLong);
      this.transitionFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mTransitionFrame);
      paramh = this.mTransitionFrame;
      BenchUtil.benchEnd("[showPreview][FABBY] transition");
      return paramh;
      if (this.mPlayer == null)
      {
        createAudioPlayer();
        AudioUtils.seekPlayer(this.mPlayer, (int)((paramLong - this.mStartTime) % 16843160L));
      }
    }
    this.transitionFilter.reset();
    this.mTransitionDeadLine = 0L;
    return paramh;
  }
  
  public void updateTextureParam(Map<Integer, FaceActionCounter> paramMap, Set<Integer> paramSet, long paramLong)
  {
    if (this.mStartTime <= 0L) {
      reset(paramLong);
    }
    updateCurrentPartIndex(paramSet, paramLong);
    ((FabbyMvFilter)this.fabbyMvFilters.get(this.mMvPartIndex)).updateTextureParam(paramLong);
    paramSet = (FaceActionCounter)paramMap.get(Integer.valueOf(VideoMaterialUtil.TRIGGER_TYPE.MV_PART_INDEX.value));
    if (paramSet == null)
    {
      paramSet = new FabbyFaceActionCounter(this.mMvPartIndex, paramLong);
      paramSet.scaleMap = ((FabbyMvFilter)this.fabbyMvFilters.get(this.mMvPartIndex)).getGridScaleMap();
      paramMap.put(Integer.valueOf(VideoMaterialUtil.TRIGGER_TYPE.MV_PART_INDEX.value), paramSet);
    }
    while (!(paramSet instanceof FabbyFaceActionCounter)) {
      return;
    }
    paramMap = (FabbyFaceActionCounter)paramSet;
    paramMap.count = this.mMvPartIndex;
    paramMap.updateTime = paramLong;
    paramMap.scaleMap = ((FabbyMvFilter)this.fabbyMvFilters.get(this.mMvPartIndex)).getGridScaleMap();
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    Iterator localIterator = this.fabbyMvFilters.iterator();
    while (localIterator.hasNext()) {
      ((FabbyMvFilter)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyFilters
 * JD-Core Version:    0.7.0.1
 */