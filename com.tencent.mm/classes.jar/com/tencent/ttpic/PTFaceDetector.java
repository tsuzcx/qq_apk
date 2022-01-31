package com.tencent.ttpic;

import android.graphics.PointF;
import android.opengl.EGL14;
import android.util.Pair;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.ApiHelper;
import com.tencent.ttpic.gles.SegmentDataPipe;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.RetrieveDataManager;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetectResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class PTFaceDetector
{
  private static final String TAG;
  public static AtomicInteger activeRefCount;
  private boolean firstDet;
  private volatile SegmentDataPipe mDetDataPipe;
  private FaceGestureDetGLThread mDetGLThread;
  private final Object mFaceDetLock;
  private VideoPreviewFaceOutlineDetector mFaceDetector;
  private h mLastInputFrame;
  private h mLastOriginLargeFrame;
  private BaseFilter mRotateFilter;
  private h mRotateFrame;
  
  static
  {
    AppMethodBeat.i(81587);
    TAG = PTFaceDetector.class.getSimpleName();
    activeRefCount = new AtomicInteger(0);
    AppMethodBeat.o(81587);
  }
  
  public PTFaceDetector()
  {
    AppMethodBeat.i(81575);
    this.mRotateFilter = new BaseFilter(GLSLRender.btg);
    this.mRotateFrame = new h();
    this.mFaceDetLock = new Object();
    AppMethodBeat.o(81575);
  }
  
  private void setDataPipe(SegmentDataPipe paramSegmentDataPipe)
  {
    AppMethodBeat.i(81578);
    synchronized (this.mFaceDetLock)
    {
      this.mDetDataPipe = paramSegmentDataPipe;
      this.mFaceDetLock.notifyAll();
      AppMethodBeat.o(81578);
      return;
    }
  }
  
  public void destroy()
  {
    AppMethodBeat.i(81579);
    if (this.mFaceDetector != null) {
      this.mDetGLThread.postFaceDetectorDestroy();
    }
    RetrieveDataManager.getInstance().clear();
    this.mRotateFilter.ClearGLSL();
    this.mRotateFrame.clear();
    if (this.mDetGLThread != null)
    {
      this.mDetGLThread.destroy();
      activeRefCount.getAndDecrement();
      this.mDetGLThread = null;
    }
    AppMethodBeat.o(81579);
  }
  
  public PTFaceAttr detectFrame(h paramh1, h paramh2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, double paramDouble)
  {
    AppMethodBeat.i(81580);
    paramh1 = detectFrame(paramh1, paramh2, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramDouble, false, false);
    AppMethodBeat.o(81580);
    return paramh1;
  }
  
  public PTFaceAttr detectFrame(h paramh1, h paramh2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, double paramDouble, boolean paramBoolean4)
  {
    AppMethodBeat.i(81581);
    paramh1 = detectFrame(paramh1, paramh2, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramDouble, paramBoolean4, false);
    AppMethodBeat.o(81581);
    return paramh1;
  }
  
  public PTFaceAttr detectFrame(h paramh1, h paramh2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, double paramDouble, boolean paramBoolean4, boolean paramBoolean5)
  {
    AppMethodBeat.i(81582);
    h localh2 = FrameUtil.rotateCorrect(paramh1, paramh1.width, paramh1.height, paramInt, this.mRotateFilter, this.mRotateFrame);
    int i = (int)(localh2.width * paramDouble);
    int j = (int)(localh2.height * paramDouble);
    Object localObject7 = new ArrayList();
    Object localObject8 = new ArrayList();
    Object localObject9 = new ArrayList();
    Object localObject10 = new ArrayList();
    Object localObject11 = new ArrayList();
    Object localObject12 = new ArrayList();
    Object localObject13 = new HashSet();
    ((Set)localObject13).add(Integer.valueOf(1));
    Object localObject4 = new ArrayList();
    byte[] arrayOfByte = new byte[0];
    Pair localPair = null;
    Object localObject14 = null;
    Object localObject6 = Pair.create(Integer.valueOf(255), null);
    Object localObject5 = new HashMap();
    if ((this.mDetGLThread != null) && (this.mDetGLThread.isInitReady()))
    {
      Object localObject1 = null;
      if (paramBoolean4)
      {
        this.firstDet = false;
        this.mDetGLThread.postFaceGestureDet(localh2, paramBoolean1, paramBoolean2, paramBoolean3, paramDouble, paramBoolean5);
      }
      if (this.firstDet) {}
    }
    for (;;)
    {
      synchronized (this.mFaceDetLock)
      {
        try
        {
          if (this.mDetDataPipe == null)
          {
            this.mFaceDetLock.wait();
            continue;
          }
          this.firstDet = false;
        }
        catch (InterruptedException localInterruptedException)
        {
          localObject2 = this.mDetDataPipe;
          this.mDetDataPipe = null;
        }
        if ((localObject2 == null) || (((SegmentDataPipe)localObject2).mTexFrame.width != localh2.width)) {
          break label638;
        }
        localObject7 = ((SegmentDataPipe)localObject2).allFacePoints;
        localObject8 = ((SegmentDataPipe)localObject2).allIrisPoints;
        localObject9 = ((SegmentDataPipe)localObject2).allFaceAngles;
        localObject13 = ((SegmentDataPipe)localObject2).mTriggeredExpressionType;
        localObject10 = ((SegmentDataPipe)localObject2).allHandPoints;
        localObject11 = ((SegmentDataPipe)localObject2).allHandAngles;
        localObject6 = ((SegmentDataPipe)localObject2).faceStatus;
        localObject12 = ((SegmentDataPipe)localObject2).bodyDetectResults;
        arrayOfByte = ((SegmentDataPipe)localObject2).mData;
        localObject4 = ((SegmentDataPipe)localObject2).brightnessAdjustmentCurve;
        localObject5 = ((SegmentDataPipe)localObject2).faceActionCounter;
        ??? = this.mLastInputFrame;
        localh1 = this.mLastOriginLargeFrame;
        localPair = ((SegmentDataPipe)localObject2).histogram;
        localObject2 = localObject6;
        localObject6 = localPair;
        if (!paramBoolean4) {
          this.mDetGLThread.postFaceGestureDet(localh2, paramBoolean1, paramBoolean2, paramBoolean3, paramDouble, paramBoolean5);
        }
        this.mLastInputFrame = paramh1;
        this.mLastOriginLargeFrame = paramh2;
        paramh1 = (h)localObject13;
        paramh2 = (h)localObject12;
        localObject12 = localObject10;
        localObject10 = localObject8;
        localObject8 = localObject12;
        localObject12 = localObject7;
        localObject7 = localObject11;
        localObject11 = AlgoUtils.rotatePointsForList((List)localObject12, i, j, paramInt);
        localObject10 = AlgoUtils.rotatePointsForList((List)localObject10, i, j, paramInt);
        localObject9 = AlgoUtils.rotateAngles((List)localObject9, -paramInt);
        localObject8 = AlgoUtils.rotatePoints((List)localObject8, i, j, paramInt);
        localObject12 = AlgoUtils.rotateAngles((List)localObject7, -paramInt);
        localObject2 = AlgoUtils.rotateFaceStatusFor3D((List)localObject2, i, j, paramInt);
        localObject7 = rotateBodyDetectResults(paramh2, i, j, paramInt);
        if ((localObject12 != null) && (((List)localObject12).size() > 0))
        {
          paramh2 = (float[])((List)localObject12).get(0);
          paramh1 = PTFaceAttr.genFaceAttr((List)localObject11, (List)localObject10, (List)localObject9, paramh1, (List)localObject8, paramh2, (List)localObject2, (List)localObject7, paramDouble, arrayOfByte, false, (h)???, localh1, localh2, paramInt, (int[])localObject4, (Map)localObject5, (Pair)localObject6, this.mFaceDetector);
          AppMethodBeat.o(81582);
          return paramh1;
        }
      }
      paramh2 = new float[] { 0.0F, 0.0F, 0.0F };
      continue;
      label638:
      h localh1 = paramh2;
      ??? = paramh1;
      Object localObject2 = localObject4;
      localObject4 = localObject14;
      continue;
      localh1 = paramh2;
      ??? = paramh1;
      localObject2 = localObject4;
      paramh1 = (h)localObject13;
      paramh2 = (h)localObject12;
      localObject4 = localObject10;
      localObject12 = localObject7;
      localObject7 = localObject11;
      localObject10 = localObject8;
      localObject8 = localObject4;
      localObject4 = localPair;
    }
  }
  
  public VideoPreviewFaceOutlineDetector getFaceDetector()
  {
    return this.mFaceDetector;
  }
  
  public String getHistogramInfo()
  {
    AppMethodBeat.i(81584);
    if (this.mDetGLThread != null)
    {
      String str = this.mDetGLThread.getHistogramInfo();
      AppMethodBeat.o(81584);
      return str;
    }
    AppMethodBeat.o(81584);
    return "";
  }
  
  public void init()
  {
    AppMethodBeat.i(81576);
    init(false);
    AppMethodBeat.o(81576);
  }
  
  public void init(boolean paramBoolean)
  {
    AppMethodBeat.i(81577);
    if ((ApiHelper.hasJellyBeanMR1()) && (this.mDetGLThread == null))
    {
      this.mDetGLThread = new FaceGestureDetGLThread(EGL14.eglGetCurrentContext());
      activeRefCount.getAndIncrement();
      this.mDetGLThread.setOnFaceDetListener(new PTFaceDetector.1(this));
      this.mFaceDetector = this.mDetGLThread.getDetector();
      if (!paramBoolean) {
        this.mFaceDetector.setDoTrackHandler(this.mDetGLThread.getHandler());
      }
    }
    this.mRotateFilter.ApplyGLSLFilter();
    this.firstDet = true;
    AppMethodBeat.o(81577);
  }
  
  public void resetBodyDetector()
  {
    AppMethodBeat.i(81585);
    if (this.mDetGLThread != null)
    {
      this.mDetGLThread.resetBodyDetector();
      if (this.mDetDataPipe != null) {
        this.mDetDataPipe.bodyDetectResults = new ArrayList();
      }
    }
    AppMethodBeat.o(81585);
  }
  
  public List<BodyDetectResult> rotateBodyDetectResults(List<BodyDetectResult> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(81583);
    if ((paramList == null) || (paramInt3 != 180))
    {
      AppMethodBeat.o(81583);
      return paramList;
    }
    int i = 0;
    while (i < paramList.size())
    {
      ArrayList localArrayList = new ArrayList();
      BodyDetectResult localBodyDetectResult = (BodyDetectResult)paramList.get(i);
      int j = 0;
      while (j < localBodyDetectResult.bodyPoints.size())
      {
        localArrayList.add(localBodyDetectResult.bodyPoints.get(j));
        j += 1;
      }
      AlgoUtils.rotatePoints(localArrayList, paramInt1, paramInt2, paramInt3);
      j = 0;
      while (j < localArrayList.size())
      {
        ((PointF)localBodyDetectResult.bodyPoints.get(j)).x = ((PointF)localArrayList.get(j)).x;
        ((PointF)localBodyDetectResult.bodyPoints.get(j)).y = ((PointF)localArrayList.get(j)).y;
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(81583);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.PTFaceDetector
 * JD-Core Version:    0.7.0.1
 */