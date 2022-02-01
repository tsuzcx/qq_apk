package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public c agWP;
  public float agWQ;
  public a agWR;
  public float[] agWS;
  public String mUY;
  
  public b()
  {
    AppMethodBeat.i(234493);
    this.agWP = c.agXo;
    this.agWQ = 0.0F;
    this.mUY = "";
    this.agWR = a.agWT;
    this.agWS = new float[] { 0.0F };
    AppMethodBeat.o(234493);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(234521);
      agWT = new a("Unknown", 0);
      agWU = new a("MeiweiLut", 1);
      agWV = new a("QingxinLut", 2);
      agWW = new a("XinxianLut", 3);
      agWX = new a("YouhuaLut", 4);
      agWY = new a("YuanqiLut", 5);
      agWZ = new a[] { agWT, agWU, agWV, agWW, agWX, agWY };
      AppMethodBeat.o(234521);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(234523);
      agXa = new b("SkinSmooth", 0);
      agXb = new b("EyeMorph", 1);
      agXc = new b("FaceMorph", 2);
      agXd = new b("SkinBright", 3);
      agXe = new b("EyeBright", 4);
      agXf = new b("Unknown", 5);
      agXg = new b[] { agXa, agXb, agXc, agXd, agXe, agXf };
      AppMethodBeat.o(234523);
    }
    
    private b() {}
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(234524);
      agXh = new c("ACES_FILTER", 0);
      agXi = new c("LUT_FILTER", 1);
      agXj = new c("LUT_FILTER_FROM_FILE", 2);
      agXk = new c("BRIGHTEN_FILTER", 3);
      agXl = new c("AUTO_BALANCE_FILTER", 4);
      agXm = new c("HUE_SATURATION_FILTER", 5);
      agXn = new c("FACE_BEAUTY", 6);
      agXo = new c("Unknown", 7);
      agXp = new c[] { agXh, agXi, agXj, agXk, agXl, agXm, agXn, agXo };
      AppMethodBeat.o(234524);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.xeffect.b
 * JD-Core Version:    0.7.0.1
 */