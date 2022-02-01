package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class WeEffectRender
{
  static
  {
    AppMethodBeat.i(234630);
    f.load("xlabeffect");
    if (140 != nGetSdkVersion())
    {
      RuntimeException localRuntimeException = new RuntimeException("SDK version error in java 140");
      AppMethodBeat.o(234630);
      throw localRuntimeException;
    }
    AppMethodBeat.o(234630);
  }
  
  public static long b(Map<String, String> paramMap, int paramInt, String paramString)
  {
    AppMethodBeat.i(234525);
    long l = nInitWithMap(d.cX(paramMap), paramInt, paramString, false);
    AppMethodBeat.o(234525);
    return l;
  }
  
  public static native long nAddDeFaceWrinkle(long paramLong, String paramString);
  
  public static native long[] nAddEffectMaterialsFolder(long paramLong, String paramString);
  
  public static native long nAddFaceAutoSlimer(long paramLong, String paramString);
  
  public static native long nAddSharpenFilter(long paramLong, float paramFloat);
  
  public static native long nCreateFilter(long paramLong, String paramString, float paramFloat);
  
  public static native long nCreateFilterWithConfig(long paramLong, String paramString);
  
  public static native long nCreateMakeUp(long paramLong, int paramInt, String paramString);
  
  public static native long nCreateSticker(long paramLong, int paramInt, String paramString);
  
  public static native void nDestroy(long paramLong);
  
  public static native ArrayList<HashSet<Integer>> nExportAction(long paramLong);
  
  public static native int nFaceTrack(long paramLong1, Buffer paramBuffer, int paramInt1, int paramInt2, long paramLong2);
  
  public static native int nFaceTrackWithAngle(long paramLong1, Buffer paramBuffer, int paramInt1, int paramInt2, long paramLong2, int paramInt3);
  
  public static native int nGetImageLabel(long paramLong);
  
  private static native int nGetSdkVersion();
  
  public static native int nGetSegmentTexture(long paramLong);
  
  public static native long nInit(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
  
  public static native long nInitWithMap(String[] paramArrayOfString, int paramInt, String paramString, boolean paramBoolean);
  
  public static native void nRemoveFilter(long paramLong1, long paramLong2);
  
  public static native int nRemoveResource(long paramLong1, long paramLong2);
  
  public static native int nRenderToBuffer(long paramLong, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, boolean paramBoolean);
  
  public static native int nRenderToTexture(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2);
  
  public static native void nResetAnim(long paramLong1, long paramLong2);
  
  public static native void nSetAnim(long paramLong1, long paramLong2, int paramInt);
  
  public static native int nSetConfigFlags(long paramLong, String paramString, float paramFloat);
  
  public static native void nSetCustomSegmentSticker(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nSetDeFaceWrinkle(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2);
  
  public static native int nSetEffectLevel(long paramLong, int paramInt1, float paramFloat, int paramInt2);
  
  public static native void nSetFilterColorWeight(long paramLong1, long paramLong2, float paramFloat);
  
  public static native void nSetFocalLength(long paramLong, float paramFloat);
  
  public static native void nSetMakeUpAlpha(long paramLong1, long paramLong2, float paramFloat);
  
  public static native void nSetMouthMorph(long paramLong, float paramFloat);
  
  public static native void nSetNativeLog(long paramLong);
  
  public static native void nSetRenderTextureCropSize(long paramLong, float paramFloat);
  
  public static native void nSetSegment(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nSetSegmentBgBlur(long paramLong, boolean paramBoolean, float paramFloat, int paramInt);
  
  public static native int nSetSlimerRate(long paramLong1, long paramLong2, float paramFloat);
  
  public static native void nSetTeethBright(long paramLong, float paramFloat);
  
  public static native int nTrackImageLabel(long paramLong, Buffer paramBuffer, int paramInt1, int paramInt2);
  
  public static native void nUpdateAnim(long paramLong1, long paramLong2);
  
  public static native void nUpdateSticker(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.xeffect.WeEffectRender
 * JD-Core Version:    0.7.0.1
 */