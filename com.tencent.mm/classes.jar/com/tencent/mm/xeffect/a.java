package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public c Rxf;
  public float Rxg;
  public a Rxh;
  public float[] Rxi;
  public String hDj;
  
  public a()
  {
    AppMethodBeat.i(236750);
    this.Rxf = c.RxE;
    this.Rxg = 0.0F;
    this.hDj = "";
    this.Rxh = a.Rxj;
    this.Rxi = new float[] { 0.0F };
    AppMethodBeat.o(236750);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(236743);
      Rxj = new a("Unknown", 0);
      Rxk = new a("MeiweiLut", 1);
      Rxl = new a("QingxinLut", 2);
      Rxm = new a("XinxianLut", 3);
      Rxn = new a("YouhuaLut", 4);
      Rxo = new a("YuanqiLut", 5);
      Rxp = new a[] { Rxj, Rxk, Rxl, Rxm, Rxn, Rxo };
      AppMethodBeat.o(236743);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(236746);
      Rxq = new b("SkinSmooth", 0);
      Rxr = new b("EyeMorph", 1);
      Rxs = new b("FaceMorph", 2);
      Rxt = new b("SkinBright", 3);
      Rxu = new b("EyeBright", 4);
      Rxv = new b("Unknown", 5);
      Rxw = new b[] { Rxq, Rxr, Rxs, Rxt, Rxu, Rxv };
      AppMethodBeat.o(236746);
    }
    
    private b() {}
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(236749);
      Rxx = new c("ACES_FILTER", 0);
      Rxy = new c("LUT_FILTER", 1);
      Rxz = new c("LUT_FILTER_FROM_FILE", 2);
      RxA = new c("BRIGHTEN_FILTER", 3);
      RxB = new c("AUTO_BALANCE_FILTER", 4);
      RxC = new c("HUE_SATURATION_FILTER", 5);
      RxD = new c("FACE_BEAUTY", 6);
      RxE = new c("Unknown", 7);
      RxF = new c[] { Rxx, Rxy, Rxz, RxA, RxB, RxC, RxD, RxE };
      AppMethodBeat.o(236749);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.a
 * JD-Core Version:    0.7.0.1
 */