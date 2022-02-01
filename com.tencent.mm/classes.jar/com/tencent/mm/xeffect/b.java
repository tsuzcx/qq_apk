package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public c YYE;
  public float YYF;
  public a YYG;
  public float[] YYH;
  public String krc;
  
  public b()
  {
    AppMethodBeat.i(194547);
    this.YYE = c.YZd;
    this.YYF = 0.0F;
    this.krc = "";
    this.YYG = a.YYI;
    this.YYH = new float[] { 0.0F };
    AppMethodBeat.o(194547);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(194535);
      YYI = new a("Unknown", 0);
      YYJ = new a("MeiweiLut", 1);
      YYK = new a("QingxinLut", 2);
      YYL = new a("XinxianLut", 3);
      YYM = new a("YouhuaLut", 4);
      YYN = new a("YuanqiLut", 5);
      YYO = new a[] { YYI, YYJ, YYK, YYL, YYM, YYN };
      AppMethodBeat.o(194535);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(194541);
      YYP = new b("SkinSmooth", 0);
      YYQ = new b("EyeMorph", 1);
      YYR = new b("FaceMorph", 2);
      YYS = new b("SkinBright", 3);
      YYT = new b("EyeBright", 4);
      YYU = new b("Unknown", 5);
      YYV = new b[] { YYP, YYQ, YYR, YYS, YYT, YYU };
      AppMethodBeat.o(194541);
    }
    
    private b() {}
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(194544);
      YYW = new c("ACES_FILTER", 0);
      YYX = new c("LUT_FILTER", 1);
      YYY = new c("LUT_FILTER_FROM_FILE", 2);
      YYZ = new c("BRIGHTEN_FILTER", 3);
      YZa = new c("AUTO_BALANCE_FILTER", 4);
      YZb = new c("HUE_SATURATION_FILTER", 5);
      YZc = new c("FACE_BEAUTY", 6);
      YZd = new c("Unknown", 7);
      YZe = new c[] { YYW, YYX, YYY, YYZ, YZa, YZb, YZc, YZd };
      AppMethodBeat.o(194544);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.b
 * JD-Core Version:    0.7.0.1
 */