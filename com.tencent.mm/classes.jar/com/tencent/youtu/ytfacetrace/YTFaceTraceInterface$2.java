package com.tencent.youtu.ytfacetrace;

import android.graphics.Rect;
import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;

final class YTFaceTraceInterface$2
  implements YTFaceTraceInterface.FaceTraceingNotice
{
  public final void onTracing(int paramInt, YTFaceTraceJNIInterface.FaceStatus paramFaceStatus, Rect paramRect, byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(117790);
    YTFaceTraceInterface.access$300(paramInt, paramFaceStatus, paramRect, paramArrayOfByte, paramCamera);
    AppMethodBeat.o(117790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.2
 * JD-Core Version:    0.7.0.1
 */