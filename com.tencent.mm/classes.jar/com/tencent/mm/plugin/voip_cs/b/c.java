package com.tencent.mm.plugin.voip_cs.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
{
  public static final int Grd;
  public static final int LtR;
  public static final int LtS;
  public static final int LtT;
  public static final int LtV;
  public static final int LtZ;
  public static final int Lub;
  public static final int Luj;
  public static final int Lum;
  public static final int Lur;
  private static int UYU;
  
  static
  {
    AppMethodBeat.i(125492);
    LtR = a.fromDPToPix(MMApplicationContext.getContext(), 3);
    Grd = a.fromDPToPix(MMApplicationContext.getContext(), 4);
    LtS = a.fromDPToPix(MMApplicationContext.getContext(), 8);
    LtT = a.fromDPToPix(MMApplicationContext.getContext(), 10);
    LtV = a.fromDPToPix(MMApplicationContext.getContext(), 14);
    LtZ = a.fromDPToPix(MMApplicationContext.getContext(), 30);
    Lub = a.fromDPToPix(MMApplicationContext.getContext(), 32);
    Lum = a.fromDPToPix(MMApplicationContext.getContext(), 96);
    Luj = a.fromDPToPix(MMApplicationContext.getContext(), 76);
    Lur = a.fromDPToPix(MMApplicationContext.getContext(), 230);
    UYU = 0;
    AppMethodBeat.o(125492);
  }
  
  public static int kD(Context paramContext)
  {
    AppMethodBeat.i(125491);
    if (UYU == 0) {
      UYU = a.mt(paramContext);
    }
    int i = UYU;
    AppMethodBeat.o(125491);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.c
 * JD-Core Version:    0.7.0.1
 */