package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.CameraActItem;
import com.tencent.ttpic.model.CanvasItem;
import com.tencent.ttpic.model.CaptureActItem;
import com.tencent.ttpic.model.FaceExpression;
import com.tencent.ttpic.model.FrameSourceItem;
import com.tencent.ttpic.model.Rect;
import com.tencent.ttpic.model.SingleScoreActItem;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.model.StarActItem;
import com.tencent.ttpic.model.TotalScoreActItem;
import com.tencent.ttpic.model.VideoActItem;
import com.tencent.ttpic.util.ActUtil.FRAME_SOURCE_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.PlayerUtil;
import com.tencent.ttpic.util.PlayerUtil.Player;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoPrefsUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ActFilters
{
  private static final String TAG;
  private static Comparator<CanvasItem> actItemComparator;
  private String dataPath;
  private long duration;
  private FaceExpression faceExpression;
  private long lastUpdateIndex;
  private boolean mAudioPause;
  private h mCanvasFrame;
  private FrameBaseFilter mCopyFilter;
  private PlayerUtil.Player mPlayer;
  private FrameVideoFilter mVideoFilter;
  private Map<Integer, FrameSourceItem> sourceItems;
  private long startUpdateTime;
  
  static
  {
    AppMethodBeat.i(81947);
    TAG = ActFilters.class.getSimpleName();
    actItemComparator = new Comparator()
    {
      public final int compare(CanvasItem paramAnonymousCanvasItem1, CanvasItem paramAnonymousCanvasItem2)
      {
        return paramAnonymousCanvasItem1.zIndex - paramAnonymousCanvasItem2.zIndex;
      }
    };
    AppMethodBeat.o(81947);
  }
  
  public ActFilters(FaceExpression paramFaceExpression, String paramString)
  {
    AppMethodBeat.i(81935);
    this.mCopyFilter = new FrameBaseFilter();
    this.mVideoFilter = new FrameVideoFilter();
    this.startUpdateTime = -1L;
    this.mCanvasFrame = new h();
    this.lastUpdateIndex = 9223372036854775807L;
    this.faceExpression = paramFaceExpression;
    this.duration = (Math.max(paramFaceExpression.frameDuration * paramFaceExpression.frames, 1.0D));
    this.dataPath = paramString;
    initFrameSourceItems(paramFaceExpression);
    AppMethodBeat.o(81935);
  }
  
  private void createAudioPlayer()
  {
    AppMethodBeat.i(81944);
    String str = this.dataPath + File.separator + "expression" + File.separator + this.faceExpression.audioID;
    if ((!TextUtils.isEmpty(str)) && (this.mPlayer == null) && (!VideoPrefsUtil.getMaterialMute())) {
      this.mPlayer = PlayerUtil.createPlayer(VideoGlobalContext.getContext(), str, false);
    }
    AppMethodBeat.o(81944);
  }
  
  private List<CanvasItem> getCanvasItems(List<CanvasItem> paramList, long paramLong)
  {
    AppMethodBeat.i(81940);
    ArrayList localArrayList = new ArrayList();
    if (paramList == null)
    {
      AppMethodBeat.o(81940);
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CanvasItem localCanvasItem = (CanvasItem)paramList.next();
      if ((localCanvasItem.startTime <= paramLong) && (paramLong <= localCanvasItem.endTime)) {
        localArrayList.add(localCanvasItem);
      }
    }
    AppMethodBeat.o(81940);
    return localArrayList;
  }
  
  private void initFrameSourceItems(FaceExpression paramFaceExpression)
  {
    AppMethodBeat.i(81936);
    if (paramFaceExpression.canvasSize == null) {
      paramFaceExpression.canvasSize = new SizeI(720, 1280);
    }
    if (paramFaceExpression.canvasSize.width * paramFaceExpression.canvasSize.height <= 0) {
      paramFaceExpression.canvasSize = new SizeI(720, 1280);
    }
    this.sourceItems = new HashMap();
    this.sourceItems.put(Integer.valueOf(ActUtil.FRAME_SOURCE_TYPE.CAMERA.value), new CameraActItem(this.mCopyFilter));
    this.sourceItems.put(Integer.valueOf(ActUtil.FRAME_SOURCE_TYPE.VIDEO.value), new VideoActItem(this.dataPath + File.separator + "expression" + File.separator + paramFaceExpression.videoID, this.mVideoFilter));
    CaptureActItem localCaptureActItem = new CaptureActItem(paramFaceExpression.expressionList, this.dataPath, paramFaceExpression.scoreImageID, this.mCopyFilter);
    this.sourceItems.put(Integer.valueOf(ActUtil.FRAME_SOURCE_TYPE.CAPTURE.value), localCaptureActItem);
    this.sourceItems.put(Integer.valueOf(ActUtil.FRAME_SOURCE_TYPE.STAR_IMAGE.value), new StarActItem(paramFaceExpression.expressionList, this.dataPath, this.mCopyFilter));
    this.sourceItems.put(Integer.valueOf(ActUtil.FRAME_SOURCE_TYPE.TOTAL_SCORE.value), new TotalScoreActItem(localCaptureActItem, this.mCopyFilter));
    this.sourceItems.put(Integer.valueOf(ActUtil.FRAME_SOURCE_TYPE.SINGEL_SCORE.value), new SingleScoreActItem(localCaptureActItem, this.mCopyFilter));
    AppMethodBeat.o(81936);
  }
  
  private boolean needResize(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(81941);
    if ((Float.compare(paramArrayOfFloat1[0], -1.0F) == 0) && (Float.compare(paramArrayOfFloat1[1], -1.0F) == 0) && (Float.compare(paramArrayOfFloat2[0], 0.0F) == 0) && (Float.compare(paramArrayOfFloat2[1], 0.0F) == 0))
    {
      AppMethodBeat.o(81941);
      return false;
    }
    AppMethodBeat.o(81941);
    return true;
  }
  
  private void render(long paramLong)
  {
    AppMethodBeat.i(81938);
    List localList = getCanvasItems(this.faceExpression.canvasItemList, paramLong);
    Collections.sort(localList, actItemComparator);
    int i = 0;
    while (i < localList.size())
    {
      CanvasItem localCanvasItem = (CanvasItem)localList.get(i);
      ((FrameSourceItem)this.sourceItems.get(Integer.valueOf(localCanvasItem.type))).draw(this.mCanvasFrame, localCanvasItem, paramLong);
      i += 1;
    }
    AppMethodBeat.o(81938);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(81943);
    this.mCopyFilter.ApplyGLSLFilter();
    this.mVideoFilter.ApplyGLSLFilter();
    Iterator localIterator = this.sourceItems.values().iterator();
    while (localIterator.hasNext()) {
      ((FrameSourceItem)localIterator.next()).init();
    }
    this.mCanvasFrame.a(-1, this.faceExpression.canvasSize.width, this.faceExpression.canvasSize.height, 0.0D);
    AppMethodBeat.o(81943);
  }
  
  public void clear()
  {
    AppMethodBeat.i(81942);
    this.mCopyFilter.clearGLSLSelf();
    this.mVideoFilter.clearGLSLSelf();
    this.mCanvasFrame.clear();
    Iterator localIterator = this.sourceItems.values().iterator();
    while (localIterator.hasNext()) {
      ((FrameSourceItem)localIterator.next()).clear();
    }
    AppMethodBeat.o(81942);
  }
  
  public void destroyAudio()
  {
    AppMethodBeat.i(81945);
    PlayerUtil.destroyPlayer(this.mPlayer);
    this.mPlayer = null;
    AppMethodBeat.o(81945);
  }
  
  public Map<Integer, FrameSourceItem> getSourceItems()
  {
    return this.sourceItems;
  }
  
  public void reset()
  {
    this.startUpdateTime = -1L;
  }
  
  public void reset(long paramLong)
  {
    AppMethodBeat.i(81939);
    this.startUpdateTime = paramLong;
    this.lastUpdateIndex = 9223372036854775807L;
    Iterator localIterator = this.sourceItems.values().iterator();
    while (localIterator.hasNext()) {
      ((FrameSourceItem)localIterator.next()).reset();
    }
    createAudioPlayer();
    PlayerUtil.startPlayer(this.mPlayer, true);
    AppMethodBeat.o(81939);
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    this.mAudioPause = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(81946);
    this.mCopyFilter.setRenderMode(paramInt);
    this.mVideoFilter.setRenderMode(paramInt);
    AppMethodBeat.o(81946);
  }
  
  public void setSourceItems(Map<Integer, FrameSourceItem> paramMap)
  {
    this.sourceItems = paramMap;
  }
  
  public h updateAndRender(h paramh, long paramLong, List<List<PointF>> paramList, List<float[]> paramList1, int paramInt)
  {
    AppMethodBeat.i(81937);
    if (this.startUpdateTime <= 0L) {
      this.startUpdateTime = paramLong;
    }
    int i;
    if ((VideoPrefsUtil.getMaterialMute()) || (this.mAudioPause))
    {
      destroyAudio();
      i = (int)((paramLong - this.startUpdateTime) % this.duration / this.faceExpression.frameDuration);
      if (i >= this.lastUpdateIndex) {
        break label436;
      }
      reset(paramLong);
      i = 0;
    }
    label436:
    for (;;)
    {
      this.lastUpdateIndex = i;
      Iterator localIterator = this.sourceItems.values().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          ((FrameSourceItem)localIterator.next()).update(paramh, i, paramList, paramList1, paramInt);
          continue;
          if (this.mPlayer == null)
          {
            createAudioPlayer();
            PlayerUtil.seekPlayer(this.mPlayer, (int)((paramLong - this.startUpdateTime) % this.duration));
            break;
          }
          PlayerUtil.startPlayer(this.mPlayer, false);
          break;
        }
      }
      this.mCanvasFrame.a(-1, this.mCanvasFrame.width, this.mCanvasFrame.height, 0.0D);
      render(i);
      paramList = AlgoUtils.calPositions(new Rect(0, 0, paramh.width, paramh.height), this.mCanvasFrame.width, this.mCanvasFrame.height, paramh.width, paramh.height, this.faceExpression.canvasResizeMode);
      paramList1 = AlgoUtils.calTexCords(new Rect(0, 0, paramh.width, paramh.height), this.mCanvasFrame.width, this.mCanvasFrame.height, this.faceExpression.canvasResizeMode);
      if (needResize(paramList, paramList1))
      {
        BenchUtil.benchStart(TAG + "[resize]");
        this.mCopyFilter.setPositions(paramList);
        this.mCopyFilter.setTexCords(paramList1);
        this.mCopyFilter.RenderProcess(this.mCanvasFrame.texture[0], paramh.width, paramh.height, -1, 0.0D, paramh);
        BenchUtil.benchEnd(TAG + "[resize]");
        AppMethodBeat.o(81937);
        return paramh;
      }
      paramh = this.mCanvasFrame;
      AppMethodBeat.o(81937);
      return paramh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.ActFilters
 * JD-Core Version:    0.7.0.1
 */