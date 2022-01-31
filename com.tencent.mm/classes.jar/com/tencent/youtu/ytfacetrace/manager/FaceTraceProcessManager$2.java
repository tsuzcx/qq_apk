package com.tencent.youtu.ytfacetrace.manager;

import android.hardware.Camera;
import com.tencent.youtu.ytcommon.tools.YTThreadOperate.UiThreadCallback;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;

class FaceTraceProcessManager$2
  implements YTThreadOperate.UiThreadCallback<YTFaceTraceJNIInterface.FaceStatus>
{
  FaceTraceProcessManager$2(FaceTraceProcessManager paramFaceTraceProcessManager, byte[] paramArrayOfByte, Camera paramCamera) {}
  
  public void callback(YTFaceTraceJNIInterface.FaceStatus paramFaceStatus)
  {
    FaceTraceProcessManager.access$100(this.this$0, this.val$data, this.val$camera);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.youtu.ytfacetrace.manager.FaceTraceProcessManager.2
 * JD-Core Version:    0.7.0.1
 */