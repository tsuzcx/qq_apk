package com.tencent.ttpic.filter;

import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.model.FabbyFaceActionCounter;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.PlayerUtil;
import com.tencent.ttpic.util.PlayerUtil.Player;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.youtu.GestureDetector;
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
  private List<FabbyMvFilter> fabbyMvFilters;
  private boolean mAudioPause;
  private List<Long> mBaseOffsetTimeList;
  private BaseFilter mCopyFilter;
  private int mLastRenderPartIndex;
  private long mLastTriggerTime;
  private int mMvPartIndex;
  private long mOffsetTimeFromTrigger;
  private PlayerUtil.Player mPlayer;
  private long mStartTime;
  private long mTransitionDeadLine;
  private h mTransitionFrame;
  private TransitionFilter transitionFilter;
  
  public FabbyFilters(List<FabbyMvFilter> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(82250);
    this.fabbyMvFilters = new ArrayList();
    this.transitionFilter = new TransitionFilter();
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    this.mTransitionFrame = new h();
    this.mBaseOffsetTimeList = new ArrayList();
    this.fabbyMvFilters = paramList;
    this.dataPath = paramString1;
    this.audioFile = paramString2;
    initBaseOffsetTime();
    AppMethodBeat.o(82250);
  }
  
  private void createAudioPlayer()
  {
    AppMethodBeat.i(82262);
    if ((!TextUtils.isEmpty(this.audioFile)) && (this.mPlayer == null) && (!VideoPrefsUtil.getMaterialMute())) {
      this.mPlayer = PlayerUtil.createPlayer(VideoGlobalContext.getContext(), this.dataPath + File.separator + this.audioFile, true);
    }
    AppMethodBeat.o(82262);
  }
  
  private void initBaseOffsetTime()
  {
    AppMethodBeat.i(82251);
    long l = 0L;
    int i = 0;
    while (i < this.fabbyMvFilters.size())
    {
      l += ((FabbyMvFilter)this.fabbyMvFilters.get(i)).mvPart.duration;
      this.mBaseOffsetTimeList.add(Long.valueOf(l));
      i += 1;
    }
    AppMethodBeat.o(82251);
  }
  
  private boolean isCurrentPartActionTrigger()
  {
    AppMethodBeat.i(82253);
    FabbyMvFilter localFabbyMvFilter = (FabbyMvFilter)this.fabbyMvFilters.get(this.mMvPartIndex);
    if ((localFabbyMvFilter.mvPart.transitionItem != null) && (localFabbyMvFilter.mvPart.transitionItem.triggerType > 1))
    {
      AppMethodBeat.o(82253);
      return true;
    }
    AppMethodBeat.o(82253);
    return false;
  }
  
  private void reset(long paramLong)
  {
    AppMethodBeat.i(82256);
    this.mStartTime = paramLong;
    this.mMvPartIndex = 0;
    this.mLastRenderPartIndex = 0;
    this.mOffsetTimeFromTrigger = 0L;
    createAudioPlayer();
    PlayerUtil.startPlayer(this.mPlayer, true);
    Iterator localIterator = this.fabbyMvFilters.iterator();
    while (localIterator.hasNext()) {
      ((FabbyMvFilter)localIterator.next()).reset();
    }
    AppMethodBeat.o(82256);
  }
  
  private void updateCurrentPartIndex(Set<Integer> paramSet, long paramLong)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(82254);
    if (isCurrentPartActionTrigger())
    {
      FabbyMvFilter localFabbyMvFilter = (FabbyMvFilter)this.fabbyMvFilters.get(this.mMvPartIndex);
      j = localFabbyMvFilter.mvPart.transitionItem.triggerType;
      if (VideoMaterialUtil.isFaceTriggerType(j))
      {
        if (!paramSet.contains(Integer.valueOf(j))) {
          break label195;
        }
        if (paramLong - this.mLastTriggerTime <= 1000L) {
          break label195;
        }
      }
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
        AppMethodBeat.o(82254);
        return;
        if (GestureDetector.getInstance().isGestureTriggered(j)) {
          break;
        }
        label195:
        i = 0;
      }
    }
    long l1 = this.mStartTime;
    long l2 = this.mOffsetTimeFromTrigger;
    i = 0;
    label216:
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
        break label216;
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
    AppMethodBeat.i(82252);
    FabbyMvFilter localFabbyMvFilter = (FabbyMvFilter)this.fabbyMvFilters.get(this.mLastRenderPartIndex);
    if ((localFabbyMvFilter != null) && (localFabbyMvFilter.mvPart != null) && (localFabbyMvFilter.getLastRenderFrame() != null))
    {
      BenchUtil.benchStart("[showPreview][FABBY] setTransitionParam");
      this.transitionFilter.setMvPart(((FabbyMvFilter)this.fabbyMvFilters.get(this.mLastRenderPartIndex)).mvPart);
      this.transitionFilter.setLastTex(((FabbyMvFilter)this.fabbyMvFilters.get(this.mLastRenderPartIndex)).getLastRenderFrame().texture[0]);
      BenchUtil.benchEnd("[showPreview][FABBY] setTransitionParam");
      this.mTransitionDeadLine = paramLong;
      AppMethodBeat.o(82252);
      return;
    }
    this.mTransitionDeadLine = 0L;
    AppMethodBeat.o(82252);
  }
  
  public void ApplyGLSLFilter(String paramString)
  {
    AppMethodBeat.i(82260);
    Iterator localIterator = this.fabbyMvFilters.iterator();
    while (localIterator.hasNext()) {
      ((FabbyMvFilter)localIterator.next()).ApplyGLSLFilter();
    }
    this.transitionFilter.ApplyGLSLFilter(paramString);
    this.mCopyFilter.ApplyGLSLFilter();
    AppMethodBeat.o(82260);
  }
  
  public void clear()
  {
    AppMethodBeat.i(82258);
    Iterator localIterator = this.fabbyMvFilters.iterator();
    while (localIterator.hasNext()) {
      ((FabbyMvFilter)localIterator.next()).clear();
    }
    this.mTransitionFrame.clear();
    this.transitionFilter.ClearGLSL();
    this.mCopyFilter.clearGLSLSelf();
    AppMethodBeat.o(82258);
  }
  
  public void destroyAudio()
  {
    AppMethodBeat.i(82259);
    PlayerUtil.destroyPlayer(this.mPlayer);
    this.mPlayer = null;
    AppMethodBeat.o(82259);
  }
  
  public void reset()
  {
    this.mStartTime = 0L;
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    this.mAudioPause = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(82261);
    Iterator localIterator = this.fabbyMvFilters.iterator();
    while (localIterator.hasNext()) {
      ((FabbyMvFilter)localIterator.next()).setRenderMode(paramInt);
    }
    this.transitionFilter.setRenderMode(paramInt);
    AppMethodBeat.o(82261);
  }
  
  public h updateAndRender(h paramh, Map<Integer, h> paramMap, Map<Integer, FaceActionCounter> paramMap1, Set<Integer> paramSet, long paramLong)
  {
    AppMethodBeat.i(82255);
    paramMap1 = (FabbyMvFilter)this.fabbyMvFilters.get(this.mMvPartIndex);
    if ((VideoPrefsUtil.getMaterialMute()) || (this.mAudioPause))
    {
      destroyAudio();
      paramh = paramMap1.updateAndRender(paramh, paramMap, paramLong);
      if ((paramLong > this.mTransitionDeadLine) || (!this.transitionFilter.needRender())) {
        break label164;
      }
      BenchUtil.benchStart("[showPreview][FABBY] transition");
      this.transitionFilter.updatePreview(paramLong);
      this.transitionFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.mTransitionFrame);
      paramh = this.mTransitionFrame;
      BenchUtil.benchEnd("[showPreview][FABBY] transition");
    }
    for (;;)
    {
      AppMethodBeat.o(82255);
      return paramh;
      if (this.mPlayer != null) {
        break;
      }
      createAudioPlayer();
      PlayerUtil.seekPlayer(this.mPlayer, (int)((paramLong - this.mStartTime) % 16843160L));
      break;
      label164:
      this.transitionFilter.reset();
      this.mTransitionDeadLine = 0L;
    }
  }
  
  public void updateTextureParam(Map<Integer, FaceActionCounter> paramMap, Set<Integer> paramSet, long paramLong)
  {
    AppMethodBeat.i(82263);
    if (this.mStartTime <= 0L) {
      reset(paramLong);
    }
    updateCurrentPartIndex(paramSet, paramLong);
    ((FabbyMvFilter)this.fabbyMvFilters.get(this.mMvPartIndex)).updateTextureParam(paramLong);
    paramSet = (FaceActionCounter)paramMap.get(Integer.valueOf(PTFaceAttr.PTExpression.MV_PART_INDEX.value));
    if (paramSet == null)
    {
      paramSet = new FabbyFaceActionCounter(this.mMvPartIndex, paramLong);
      paramSet.scaleMap = ((FabbyMvFilter)this.fabbyMvFilters.get(this.mMvPartIndex)).getGridScaleMap();
      paramMap.put(Integer.valueOf(PTFaceAttr.PTExpression.MV_PART_INDEX.value), paramSet);
      AppMethodBeat.o(82263);
      return;
    }
    if ((paramSet instanceof FabbyFaceActionCounter))
    {
      paramMap = (FabbyFaceActionCounter)paramSet;
      paramMap.count = this.mMvPartIndex;
      paramMap.updateTime = paramLong;
      paramMap.scaleMap = ((FabbyMvFilter)this.fabbyMvFilters.get(this.mMvPartIndex)).getGridScaleMap();
    }
    AppMethodBeat.o(82263);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(82257);
    Iterator localIterator = this.fabbyMvFilters.iterator();
    while (localIterator.hasNext()) {
      ((FabbyMvFilter)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    AppMethodBeat.o(82257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyFilters
 * JD-Core Version:    0.7.0.1
 */