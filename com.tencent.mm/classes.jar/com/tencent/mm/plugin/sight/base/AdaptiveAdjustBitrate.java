package com.tencent.mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;

public class AdaptiveAdjustBitrate
{
  public int gNU;
  public int gNV;
  public int gOb;
  public int gOc;
  public int hCL;
  public int hCM;
  public int hCN;
  public int hCO;
  public int hCP;
  public int hCQ;
  public int hCS;
  public int hCT;
  public int hCU;
  public int hCV;
  public String hbF;
  public int wpw;
  public int wpx;
  public int xCn;
  public int xCo;
  
  private static native int[] GetBitrate(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12);
  
  public static int[] a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    AppMethodBeat.i(195673);
    paramString = GetBitrate(q.k(paramString, false), paramInt1, paramInt2, paramInt3, paramInt4, paramFloat1, paramFloat2, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12);
    AppMethodBeat.o(195673);
    return paramString;
  }
  
  public final void dEr()
  {
    this.hCL = 0;
    this.hCM = 0;
    this.hCN = 0;
    this.hCO = 0;
    this.hCP = 0;
    this.hCQ = 0;
    this.xCo = 0;
    this.hCS = 0;
    this.hCT = 0;
    this.gOb = 0;
    this.gOc = 0;
    this.hCU = 0;
    this.hCV = 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(133593);
    String str = "[ sourceVideoPath " + this.hbF + " targetHeight " + this.gNV + " targetWidth " + this.gNU + " targetvideoBitrate " + this.xCn + " reMuxStartTimeMs " + this.wpw + " reMuxEndTimeMs " + this.wpx + " remuxScene " + this.hCV + " abaSwitch " + this.hCL + " qpSwitch " + this.hCM + " abaUpgear " + this.hCN + " abaDowngear " + this.hCO + " ceilingVideoBR " + this.hCP + " flooringVideoBR " + this.hCQ + " isEnableHEVC " + this.xCo + " isEnable720p " + this.hCS + " minQP " + this.gOb + " maxQP " + this.gOc + " takePhotosVideoBR " + this.hCU + " remuxScene " + this.hCV + "]";
    AppMethodBeat.o(133593);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate
 * JD-Core Version:    0.7.0.1
 */