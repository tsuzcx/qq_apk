package com.tencent.mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;

public class AdaptiveAdjustBitrate
{
  public int NGW;
  public int NGX;
  public int PEZ;
  public float PFa;
  public float PFb;
  public int isEnableHEVC;
  public String nJU;
  public int nxO;
  public int nxP;
  public int nxU;
  public int nxV;
  public int oCb;
  public int oCc;
  public int oCf;
  public int oCg;
  public int oCi;
  public int oCj;
  public int oCk;
  public int oCl;
  
  public static native float GetAuQaLevel(String paramString, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native ABAPrams GetBitrate(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, float paramFloat3, float paramFloat4, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, boolean paramBoolean);
  
  public static ABAPrams a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, float paramFloat3, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, boolean paramBoolean)
  {
    AppMethodBeat.i(291869);
    paramString = GetBitrate(q.n(paramString, false), paramInt1, paramInt2, paramInt3, paramInt4, paramFloat1, paramFloat2, paramInt5, paramFloat3, 0.0F, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramBoolean);
    AppMethodBeat.o(291869);
    return paramString;
  }
  
  public static ABAPrams a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(291879);
    paramString = getVideoQuality(q.n(paramString, false), paramInt1, paramInt2, paramInt3, paramInt4, paramFloat1, 0.0F, 4, paramFloat2, 0.0F, paramInt5, paramInt6);
    AppMethodBeat.o(291879);
    return paramString;
  }
  
  public static float b(String paramString, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(291874);
    paramFloat1 = GetAuQaLevel(q.n(paramString, false), paramFloat1, paramFloat2, paramInt, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(291874);
    return paramFloat1;
  }
  
  public static native int getOrignalImageQuality(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat);
  
  public static native int getVideoImageQuality(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat);
  
  private static native ABAPrams getVideoQuality(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, float paramFloat3, float paramFloat4, int paramInt6, int paramInt7);
  
  public final void gYm()
  {
    this.oCb = 0;
    this.oCc = 0;
    this.PFa = 0.0F;
    this.PFb = 0.0F;
    this.oCf = 0;
    this.oCg = 0;
    this.isEnableHEVC = 0;
    this.oCi = 0;
    this.oCj = 0;
    this.nxU = 0;
    this.nxV = 0;
    this.oCk = 0;
    this.oCl = 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(133593);
    String str = "[ sourceVideoPath " + this.nJU + " targetHeight " + this.nxP + " targetWidth " + this.nxO + " targetvideoBitrate " + this.PEZ + " reMuxStartTimeMs " + this.NGW + " reMuxEndTimeMs " + this.NGX + " remuxScene " + this.oCl + " abaSwitch " + this.oCb + " qpSwitch " + this.oCc + " swHEVCRatio " + this.PFa + " hwHEVCRatio " + this.PFb + " ceilingVideoBR " + this.oCf + " flooringVideoBR " + this.oCg + " isEnableHEVC " + this.isEnableHEVC + " isEnable1080p " + this.oCi + " minQP " + this.nxU + " maxQP " + this.nxV + " takePhotosVideoBR " + this.oCk + " remuxScene " + this.oCl + "]";
    AppMethodBeat.o(133593);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate
 * JD-Core Version:    0.7.0.1
 */