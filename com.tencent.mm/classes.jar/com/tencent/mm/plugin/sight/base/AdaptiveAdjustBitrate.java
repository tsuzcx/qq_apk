package com.tencent.mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;

public class AdaptiveAdjustBitrate
{
  public int hVA;
  public int hVq;
  public int hVr;
  public int hVs;
  public int hVt;
  public int hVu;
  public int hVv;
  public int hVx;
  public int hVy;
  public int hVz;
  public int hhV;
  public int hhW;
  public String htN;
  public int targetHeight;
  public int targetWidth;
  public int xxm;
  public int xxn;
  public int yQX;
  public int yQY;
  
  public static native float GetAuQaLevel(String paramString, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native int[] GetBitrate(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, boolean paramBoolean);
  
  public static int[] a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    AppMethodBeat.i(187800);
    paramString = GetBitrate(q.k(paramString, false), paramInt1, paramInt2, paramInt3, paramInt4, paramFloat1, paramFloat2, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, false);
    AppMethodBeat.o(187800);
    return paramString;
  }
  
  public static float b(String paramString, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(187801);
    paramFloat1 = GetAuQaLevel(q.k(paramString, false), paramFloat1, paramFloat2, paramInt, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(187801);
    return paramFloat1;
  }
  
  public static native int getOrignalImageQuality(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat);
  
  public static native int getVideoImageQuality(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat);
  
  public final void dPU()
  {
    this.hVq = 0;
    this.hVr = 0;
    this.hVs = 0;
    this.hVt = 0;
    this.hVu = 0;
    this.hVv = 0;
    this.yQY = 0;
    this.hVx = 0;
    this.hVy = 0;
    this.hhV = 0;
    this.hhW = 0;
    this.hVz = 0;
    this.hVA = 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(133593);
    String str = "[ sourceVideoPath " + this.htN + " targetHeight " + this.targetHeight + " targetWidth " + this.targetWidth + " targetvideoBitrate " + this.yQX + " reMuxStartTimeMs " + this.xxm + " reMuxEndTimeMs " + this.xxn + " remuxScene " + this.hVA + " abaSwitch " + this.hVq + " qpSwitch " + this.hVr + " abaUpgear " + this.hVs + " abaDowngear " + this.hVt + " ceilingVideoBR " + this.hVu + " flooringVideoBR " + this.hVv + " isEnableHEVC " + this.yQY + " isEnable720p " + this.hVx + " minQP " + this.hhV + " maxQP " + this.hhW + " takePhotosVideoBR " + this.hVz + " remuxScene " + this.hVA + "]";
    AppMethodBeat.o(133593);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate
 * JD-Core Version:    0.7.0.1
 */