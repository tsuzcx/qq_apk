package com.tencent.mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;

public class AdaptiveAdjustBitrate
{
  public String gBj;
  public int gnh;
  public int gni;
  public int gnp;
  public int gnq;
  public int hcj;
  public int hck;
  public int hcl;
  public int hcm;
  public int hcn;
  public int hco;
  public int hcq;
  public int hcr;
  public int hcs;
  public int vgK;
  public int vgL;
  public int wqW;
  public int wqX;
  
  private static native int[] GetBitrate(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11);
  
  public static int[] a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    AppMethodBeat.i(133592);
    paramString = GetBitrate(q.k(paramString, false), paramInt1, paramInt2, paramInt3, paramInt4, paramFloat1, paramFloat2, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11);
    AppMethodBeat.o(133592);
    return paramString;
  }
  
  public final void dqh()
  {
    this.hcj = 0;
    this.hck = 0;
    this.hcl = 0;
    this.hcm = 0;
    this.hcn = 0;
    this.hco = 0;
    this.wqX = 0;
    this.hcq = 0;
    this.gnp = 0;
    this.gnq = 0;
    this.hcr = 0;
    this.hcs = 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(133593);
    String str = "[ sourceVideoPath " + this.gBj + " targetHeight " + this.gni + " targetWidth " + this.gnh + " targetvideoBitrate " + this.wqW + " reMuxStartTimeMs " + this.vgK + " reMuxEndTimeMs " + this.vgL + " remuxScene " + this.hcs + " abaSwitch " + this.hcj + " qpSwitch " + this.hck + " abaUpgear " + this.hcl + " abaDowngear " + this.hcm + " abaIncreasesize " + this.hcn + " abaDecreasesize " + this.hco + " isEnableHEVC " + this.wqX + " minQP " + this.gnp + " maxQP " + this.gnq + " takePhotosVideoBR " + this.hcr + " remuxScene " + this.hcs + "]";
    AppMethodBeat.o(133593);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate
 * JD-Core Version:    0.7.0.1
 */