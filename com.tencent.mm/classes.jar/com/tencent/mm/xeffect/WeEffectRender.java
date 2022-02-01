package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashSet;

public class WeEffectRender
{
  static
  {
    AppMethodBeat.i(194594);
    e.load("xlabeffect");
    AppMethodBeat.o(194594);
  }
  
  public static long b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(194585);
    long l = nInit(paramInt, paramString, paramString + "/OpenCLCNNLib.bin", paramBoolean1, paramBoolean2);
    AppMethodBeat.o(194585);
    return l;
  }
  
  public static native long nAddDeFaceWrinkle(long paramLong, String paramString);
  
  public static native long nAddFaceAutoSlimer(long paramLong, String paramString);
  
  public static native long nAddSharpenFilter(long paramLong, float paramFloat);
  
  public static native long nCreateFilter(long paramLong, String paramString, float paramFloat);
  
  public static native long nCreateFilterWithConfig(long paramLong, String paramString);
  
  public static native long nCreateMakeUp(long paramLong, int paramInt, String paramString);
  
  public static native long nCreateSticker(long paramLong, int paramInt, String paramString);
  
  public static native void nDestroy(long paramLong);
  
  public static native ArrayList<HashSet<Integer>> nExportAction(long paramLong);
  
  public static native int nFaceTrack(long paramLong1, Buffer paramBuffer, int paramInt1, int paramInt2, long paramLong2);
  
  public static native int nGetImageLabel(long paramLong);
  
  public static native int nGetSegmentTexture(long paramLong);
  
  public static native long nInit(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
  
  public static native void nRemoveFilter(long paramLong1, long paramLong2);
  
  public static native int nRemoveResource(long paramLong1, long paramLong2);
  
  public static native int nRenderToBuffer(long paramLong, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4, boolean paramBoolean);
  
  public static native int nRenderToTexture(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2);
  
  public static native void nResetAnim(long paramLong1, long paramLong2);
  
  public static native void nSetAnim(long paramLong1, long paramLong2, int paramInt);
  
  public static native int nSetConfigFlags(long paramLong, String paramString, float paramFloat);
  
  public static native void nSetDeFaceWrinkle(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2);
  
  public static native int nSetEffectLevel(long paramLong, int paramInt, float paramFloat);
  
  public static native void nSetFilterColorWeight(long paramLong1, long paramLong2, float paramFloat);
  
  public static native void nSetFocalLength(long paramLong, float paramFloat);
  
  public static native void nSetNativeLog(long paramLong);
  
  public static native void nSetRenderTextureCropSize(long paramLong, float paramFloat);
  
  public static native void nSetSegment(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3);
  
  public static native int nSetSlimerRate(long paramLong1, long paramLong2, float paramFloat);
  
  public static native void nSetTeethBright(long paramLong, float paramFloat);
  
  public static native int nTrackImageLabel(long paramLong, Buffer paramBuffer, int paramInt1, int paramInt2);
  
  public static native void nUpdateAnim(long paramLong1, long paramLong2);
  
  public static native void nUpdateSticker(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.WeEffectRender
 * JD-Core Version:    0.7.0.1
 */