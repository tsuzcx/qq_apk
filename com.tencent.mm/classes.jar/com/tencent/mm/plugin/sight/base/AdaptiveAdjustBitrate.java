package com.tencent.mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;

public class AdaptiveAdjustBitrate
{
  public int HJX;
  public int HJY;
  public int JrA;
  public int JrB;
  public int kSl;
  public int kSm;
  public int lJA;
  public int lJB;
  public int lJC;
  public int lJD;
  public int lJE;
  public int lJG;
  public int lJH;
  public int lJI;
  public int lJJ;
  public int lJz;
  public String lfj;
  public int targetHeight;
  public int targetWidth;
  
  public static native float GetAuQaLevel(String paramString, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native int[] GetBitrate(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, boolean paramBoolean);
  
  public static float a(String paramString, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(213611);
    paramFloat1 = GetAuQaLevel(q.n(paramString, false), paramFloat1, paramFloat2, paramInt, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(213611);
    return paramFloat1;
  }
  
  public static int[] a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, boolean paramBoolean)
  {
    AppMethodBeat.i(213608);
    paramString = GetBitrate(q.n(paramString, false), paramInt1, paramInt2, paramInt3, paramInt4, paramFloat1, paramFloat2, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramBoolean);
    AppMethodBeat.o(213608);
    return paramString;
  }
  
  public static int[] a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(213615);
    paramString = getVideoQuality(q.n(paramString, false), paramInt1, paramInt2, paramInt3, paramInt4, paramFloat, 0.0F, 4, paramInt5, paramInt6, paramInt7, paramInt8);
    AppMethodBeat.o(213615);
    return paramString;
  }
  
  public static native int getOrignalImageQuality(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat);
  
  public static native int getVideoImageQuality(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat);
  
  private static native int[] getVideoQuality(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9);
  
  public final void fIs()
  {
    this.lJz = 0;
    this.lJA = 0;
    this.lJB = 0;
    this.lJC = 0;
    this.lJD = 0;
    this.lJE = 0;
    this.JrB = 0;
    this.lJG = 0;
    this.lJH = 0;
    this.kSl = 0;
    this.kSm = 0;
    this.lJI = 0;
    this.lJJ = 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(133593);
    String str = "[ sourceVideoPath " + this.lfj + " targetHeight " + this.targetHeight + " targetWidth " + this.targetWidth + " targetvideoBitrate " + this.JrA + " reMuxStartTimeMs " + this.HJX + " reMuxEndTimeMs " + this.HJY + " remuxScene " + this.lJJ + " abaSwitch " + this.lJz + " qpSwitch " + this.lJA + " abaUpgear " + this.lJB + " abaDowngear " + this.lJC + " ceilingVideoBR " + this.lJD + " flooringVideoBR " + this.lJE + " isEnableHEVC " + this.JrB + " isEnable720p " + this.lJG + " minQP " + this.kSl + " maxQP " + this.kSm + " takePhotosVideoBR " + this.lJI + " remuxScene " + this.lJJ + "]";
    AppMethodBeat.o(133593);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate
 * JD-Core Version:    0.7.0.1
 */