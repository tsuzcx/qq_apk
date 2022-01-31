package com.tencent.ttpic.util;

import com.tencent.filter.BaseFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoLibUtil
{
  public static float[] estimateRigidTransform(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    AppMethodBeat.i(84042);
    paramArrayOfFloat1 = nativeRigidTransform(paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3);
    AppMethodBeat.o(84042);
    return paramArrayOfFloat1;
  }
  
  public static int getFaceDetectLibVersion()
  {
    AppMethodBeat.i(84040);
    int i = nativeGetFaceDetectLibVersion();
    AppMethodBeat.o(84040);
    return i;
  }
  
  public static int getFilterLibVersion()
  {
    AppMethodBeat.i(84041);
    int i = BaseFilter.getVersionCode();
    AppMethodBeat.o(84041);
    return i;
  }
  
  private static native int nativeGetFaceDetectLibVersion();
  
  private static native float[] nativeRigidTransform(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoLibUtil
 * JD-Core Version:    0.7.0.1
 */