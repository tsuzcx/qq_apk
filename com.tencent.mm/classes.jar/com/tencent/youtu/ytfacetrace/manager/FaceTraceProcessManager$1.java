package com.tencent.youtu.ytfacetrace.manager;

import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;
import java.util.concurrent.Callable;

class FaceTraceProcessManager$1
  implements Callable<YTFaceTraceJNIInterface.FaceStatus>
{
  FaceTraceProcessManager$1(FaceTraceProcessManager paramFaceTraceProcessManager, byte[] paramArrayOfByte) {}
  
  public YTFaceTraceJNIInterface.FaceStatus call()
  {
    return FaceTraceProcessManager.access$000(this.this$0, this.val$data, this.this$0.mDesiredPreviewWidth, this.this$0.mDesiredPreviewHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.youtu.ytfacetrace.manager.FaceTraceProcessManager.1
 * JD-Core Version:    0.7.0.1
 */