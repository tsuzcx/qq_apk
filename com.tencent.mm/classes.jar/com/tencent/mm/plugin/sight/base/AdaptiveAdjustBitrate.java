package com.tencent.mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;

public class AdaptiveAdjustBitrate
{
  public int BNp;
  public int BNq;
  public int DlY;
  public int DlZ;
  public int iTg;
  public int iTh;
  public int iTi;
  public int iTj;
  public int iTk;
  public int iTl;
  public int iTn;
  public int iTo;
  public int iTp;
  public int iTq;
  public int idF;
  public int idG;
  public String iqd;
  public int targetHeight;
  public int targetWidth;
  
  public static native float GetAuQaLevel(String paramString, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native int[] GetBitrate(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, boolean paramBoolean);
  
  public static float a(String paramString, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(201783);
    paramFloat1 = GetAuQaLevel(q.k(paramString, false), paramFloat1, paramFloat2, paramInt, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(201783);
    return paramFloat1;
  }
  
  public static int[] a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, boolean paramBoolean)
  {
    AppMethodBeat.i(201782);
    paramString = GetBitrate(q.k(paramString, false), paramInt1, paramInt2, paramInt3, paramInt4, paramFloat1, paramFloat2, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramBoolean);
    AppMethodBeat.o(201782);
    return paramString;
  }
  
  public static int[] a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(201784);
    paramString = getVideoQuality(q.k(paramString, false), paramInt1, paramInt2, paramInt3, paramInt4, paramFloat, 0.0F, 4, paramInt5, paramInt6, paramInt7, paramInt8);
    AppMethodBeat.o(201784);
    return paramString;
  }
  
  public static native int getOrignalImageQuality(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat);
  
  public static native int getVideoImageQuality(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat);
  
  private static native int[] getVideoQuality(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9);
  
  public final void eVq()
  {
    this.iTg = 0;
    this.iTh = 0;
    this.iTi = 0;
    this.iTj = 0;
    this.iTk = 0;
    this.iTl = 0;
    this.DlZ = 0;
    this.iTn = 0;
    this.iTo = 0;
    this.idF = 0;
    this.idG = 0;
    this.iTp = 0;
    this.iTq = 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(133593);
    String str = "[ sourceVideoPath " + this.iqd + " targetHeight " + this.targetHeight + " targetWidth " + this.targetWidth + " targetvideoBitrate " + this.DlY + " reMuxStartTimeMs " + this.BNp + " reMuxEndTimeMs " + this.BNq + " remuxScene " + this.iTq + " abaSwitch " + this.iTg + " qpSwitch " + this.iTh + " abaUpgear " + this.iTi + " abaDowngear " + this.iTj + " ceilingVideoBR " + this.iTk + " flooringVideoBR " + this.iTl + " isEnableHEVC " + this.DlZ + " isEnable720p " + this.iTn + " minQP " + this.idF + " maxQP " + this.idG + " takePhotosVideoBR " + this.iTp + " remuxScene " + this.iTq + "]";
    AppMethodBeat.o(133593);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate
 * JD-Core Version:    0.7.0.1
 */