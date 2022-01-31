package com.tencent.ttpic.thread;

import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GLSegSharedData;
import com.tencent.ttpic.gles.SegmentDataPipe;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.RetrieveDataManager;
import com.tencent.ttpic.util.RetrieveDataManager.DATA_TYPE;
import com.tencent.ttpic.util.youtu.GestureDetector;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetector;
import java.util.ArrayList;
import java.util.List;

class FaceGestureDetGLThread$3
  implements Runnable
{
  FaceGestureDetGLThread$3(FaceGestureDetGLThread paramFaceGestureDetGLThread, h paramh, double paramDouble, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {}
  
  public void run()
  {
    AppMethodBeat.i(83747);
    long l1 = 0L;
    if (BenchUtil.ENABLE_PERFORMANCE_RECORD) {
      l1 = System.currentTimeMillis();
    }
    if (FaceGestureDetGLThread.access$800(this.this$0) == null)
    {
      AppMethodBeat.o(83747);
      return;
    }
    SegmentDataPipe localSegmentDataPipe = FaceGestureDetGLThread.access$300(this.this$0).getFreeTexturePileMakeBusy();
    if (localSegmentDataPipe == null)
    {
      AppMethodBeat.o(83747);
      return;
    }
    localSegmentDataPipe.mTimestamp = System.currentTimeMillis();
    int i = (int)(this.val$inputFrame.width * this.val$faceDetScale);
    int j = (int)(this.val$inputFrame.height * this.val$faceDetScale);
    localSegmentDataPipe.mTexFrame = this.val$inputFrame;
    byte[] arrayOfByte = RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, this.val$inputFrame.texture[0], i, j);
    if (arrayOfByte != null) {}
    try
    {
      if ((localSegmentDataPipe.mData == null) || (localSegmentDataPipe.mData.length != arrayOfByte.length)) {
        localSegmentDataPipe.mData = new byte[arrayOfByte.length];
      }
      System.arraycopy(arrayOfByte, 0, localSegmentDataPipe.mData, 0, arrayOfByte.length);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label178:
      Object localObject1;
      break label178;
    }
    FaceGestureDetGLThread.access$500(this.this$0).clear();
    if (this.val$needFaceDetect)
    {
      FaceGestureDetGLThread.access$500(this.this$0).clearSavedTriggeredExpression();
      FaceGestureDetGLThread.access$500(this.this$0).init();
      if (this.val$isAlldetected) {
        FaceGestureDetGLThread.access$500(this.this$0).doDectectTrackByRGBA(localSegmentDataPipe.mData, i, j);
      }
    }
    else
    {
      if (this.val$needGestureDetect)
      {
        GestureDetector.getInstance().init();
        GestureDetector.getInstance().detectHand(localSegmentDataPipe.mData, i, j);
      }
      ??? = new ArrayList();
      localObject1 = ???;
      if (this.val$needDetectBody)
      {
        localObject1 = ???;
        if (!BodyDetector.getInstance().isInited()) {}
      }
    }
    for (;;)
    {
      long l2;
      synchronized (FaceGestureDetGLThread.access$900(this.this$0))
      {
        List localList;
        try
        {
          if (FaceGestureDetGLThread.access$1000(this.this$0) == null)
          {
            FaceGestureDetGLThread.access$900(this.this$0).wait();
            continue;
          }
          l2 = System.currentTimeMillis();
        }
        catch (InterruptedException localInterruptedException)
        {
          localList = FaceGestureDetGLThread.access$1000(this.this$0);
          FaceGestureDetGLThread.access$1002(this.this$0, null);
        }
        if (FaceGestureDetGLThread.access$1100(this.this$0) <= 0L)
        {
          FaceGestureDetGLThread.access$1102(this.this$0, l2 - 2000L + 2000L);
          localSegmentDataPipe.allFacePoints = FaceGestureDetGLThread.access$500(this.this$0).getAllFaces();
          localSegmentDataPipe.allIrisPoints = FaceGestureDetGLThread.access$500(this.this$0).getAllIris();
          localSegmentDataPipe.allFaceAngles = FaceGestureDetGLThread.access$500(this.this$0).getAllFaceAngles();
          localSegmentDataPipe.mTriggeredExpressionType = FaceGestureDetGLThread.access$500(this.this$0).getTriggeredExpression();
          localSegmentDataPipe.allHandPoints = FaceGestureDetGLThread.access$1300(this.this$0).getHandPoints();
          localSegmentDataPipe.allHandAngles = FaceGestureDetGLThread.access$1300(this.this$0).getHandAngles();
          localSegmentDataPipe.bodyDetectResults = localList;
          localSegmentDataPipe.faceStatus = FaceGestureDetGLThread.access$500(this.this$0).getFaceStatus3Ds();
          localSegmentDataPipe.brightnessAdjustmentCurve = FaceGestureDetGLThread.access$1400(this.this$0);
          localSegmentDataPipe.faceActionCounter = FaceGestureDetGLThread.access$500(this.this$0).getFaceActionCounter();
          localSegmentDataPipe.histogram = FaceGestureDetGLThread.access$1500(this.this$0, arrayOfByte, i, j);
          localSegmentDataPipe.makeDataReady();
          FaceGestureDetGLThread.access$300(this.this$0).makeBrotherTextureFree(localSegmentDataPipe);
          FaceGestureDetGLThread.access$800(this.this$0).onDataReady(localSegmentDataPipe);
          if (BenchUtil.ENABLE_PERFORMANCE_RECORD)
          {
            l2 = System.currentTimeMillis();
            new StringBuilder("人脸人体检测耗时： ").append(l2 - l1).append(" ms.");
          }
          AppMethodBeat.o(83747);
          return;
          FaceGestureDetGLThread.access$500(this.this$0).doTrackByRGBA(localSegmentDataPipe.mData, i, j);
        }
      }
      if (l2 - FaceGestureDetGLThread.access$1100(this.this$0) >= 2000L)
      {
        FaceGestureDetGLThread.access$1200(this.this$0, arrayOfByte, i, j);
        FaceGestureDetGLThread.access$1102(this.this$0, l2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.thread.FaceGestureDetGLThread.3
 * JD-Core Version:    0.7.0.1
 */