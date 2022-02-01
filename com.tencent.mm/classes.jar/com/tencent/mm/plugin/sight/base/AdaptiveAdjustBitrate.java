package com.tencent.mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;

public class AdaptiveAdjustBitrate
{
  public int hYi;
  public int hYj;
  public int hYk;
  public int hYl;
  public int hYm;
  public int hYn;
  public int hYp;
  public int hYq;
  public int hYr;
  public int hYs;
  public int hkJ;
  public int hkK;
  public String hwB;
  public int targetHeight;
  public int targetWidth;
  public int xNj;
  public int xNk;
  public int zhh;
  public int zhi;
  
  public static native float GetAuQaLevel(String paramString, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native int[] GetBitrate(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, boolean paramBoolean);
  
  public static int[] a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, boolean paramBoolean)
  {
    AppMethodBeat.i(221728);
    paramString = GetBitrate(q.k(paramString, false), paramInt1, paramInt2, paramInt3, paramInt4, paramFloat1, paramFloat2, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramBoolean);
    AppMethodBeat.o(221728);
    return paramString;
  }
  
  public static float b(String paramString, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(221729);
    paramFloat1 = GetAuQaLevel(q.k(paramString, false), paramFloat1, paramFloat2, paramInt, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(221729);
    return paramFloat1;
  }
  
  public static native int getOrignalImageQuality(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat);
  
  public static native int getVideoImageQuality(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat);
  
  public final void dTr()
  {
    this.hYi = 0;
    this.hYj = 0;
    this.hYk = 0;
    this.hYl = 0;
    this.hYm = 0;
    this.hYn = 0;
    this.zhi = 0;
    this.hYp = 0;
    this.hYq = 0;
    this.hkJ = 0;
    this.hkK = 0;
    this.hYr = 0;
    this.hYs = 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(133593);
    String str = "[ sourceVideoPath " + this.hwB + " targetHeight " + this.targetHeight + " targetWidth " + this.targetWidth + " targetvideoBitrate " + this.zhh + " reMuxStartTimeMs " + this.xNj + " reMuxEndTimeMs " + this.xNk + " remuxScene " + this.hYs + " abaSwitch " + this.hYi + " qpSwitch " + this.hYj + " abaUpgear " + this.hYk + " abaDowngear " + this.hYl + " ceilingVideoBR " + this.hYm + " flooringVideoBR " + this.hYn + " isEnableHEVC " + this.zhi + " isEnable720p " + this.hYp + " minQP " + this.hkJ + " maxQP " + this.hkK + " takePhotosVideoBR " + this.hYr + " remuxScene " + this.hYs + "]";
    AppMethodBeat.o(133593);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate
 * JD-Core Version:    0.7.0.1
 */