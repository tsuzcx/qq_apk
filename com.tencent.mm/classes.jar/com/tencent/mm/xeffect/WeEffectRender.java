package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;

public class WeEffectRender
{
  static
  {
    AppMethodBeat.i(221422);
    e.load("xlabeffect");
    AppMethodBeat.o(221422);
  }
  
  public static long gQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(220047);
    long l = nInit(paramInt, paramString + "/FaceDetectV2.0.0.21.xnet", paramString + "/FaceTrackV1.0.0.21.xnet", paramString + "/FaceAlignmentWeChatV1.0.0.21.xnet", paramString + "/model_sticker.xbin", paramString + "/Params_FaceSticker.json", paramString + "/SegmentationPortraitV1.0.0.21.xnet", paramString + "/GestureDetectV1.0.0.21.xnet", paramString + "/GestureClassifyV1.0.0.21.xnet");
    AppMethodBeat.o(220047);
    return l;
  }
  
  public static native long nCreateFilter(long paramLong, String paramString, float paramFloat);
  
  public static native long nCreateSticker(long paramLong, int paramInt, String paramString);
  
  public static native void nDestroy(long paramLong);
  
  public static native void nDisableFilter(long paramLong1, long paramLong2);
  
  public static native void nEnableFilter(long paramLong1, long paramLong2);
  
  public static native int nFaceTrack(long paramLong1, Buffer paramBuffer, int paramInt1, int paramInt2, long paramLong2);
  
  public static native int nGetSegmentTexture(long paramLong);
  
  public static native long nInit(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8);
  
  public static native void nRemoveFilter(long paramLong1, long paramLong2);
  
  public static native int nRemoveResource(long paramLong1, long paramLong2);
  
  public static native int nRenderToBuffer(long paramLong, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, boolean paramBoolean);
  
  public static native int nRenderToTexture(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2);
  
  public static native void nSetCurrentFilterWeight(long paramLong, float paramFloat);
  
  public static native int nSetEffectLevel(long paramLong, int paramInt, float paramFloat);
  
  public static native void nSetFocalLength(long paramLong, float paramFloat);
  
  public static native void nSetNativeLog(long paramLong);
  
  public static native void nSetSegment(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nUpdateSticker(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.xeffect.WeEffectRender
 * JD-Core Version:    0.7.0.1
 */