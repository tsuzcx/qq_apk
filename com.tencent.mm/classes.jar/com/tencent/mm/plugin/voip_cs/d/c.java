package com.tencent.mm.plugin.voip_cs.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
{
  public static final int AOJ;
  public static final int FxF;
  public static final int FxG;
  public static final int FxH;
  public static final int FxJ;
  public static final int FxN;
  public static final int FxP;
  public static final int FxX;
  public static final int Fya;
  public static final int Fyf;
  private static int Okx;
  
  static
  {
    AppMethodBeat.i(125492);
    FxF = a.fromDPToPix(MMApplicationContext.getContext(), 3);
    AOJ = a.fromDPToPix(MMApplicationContext.getContext(), 4);
    FxG = a.fromDPToPix(MMApplicationContext.getContext(), 8);
    FxH = a.fromDPToPix(MMApplicationContext.getContext(), 10);
    FxJ = a.fromDPToPix(MMApplicationContext.getContext(), 14);
    FxN = a.fromDPToPix(MMApplicationContext.getContext(), 30);
    FxP = a.fromDPToPix(MMApplicationContext.getContext(), 32);
    Fya = a.fromDPToPix(MMApplicationContext.getContext(), 96);
    FxX = a.fromDPToPix(MMApplicationContext.getContext(), 76);
    Fyf = a.fromDPToPix(MMApplicationContext.getContext(), 230);
    Okx = 0;
    AppMethodBeat.o(125492);
  }
  
  public static int iM(Context paramContext)
  {
    AppMethodBeat.i(125491);
    if (Okx == 0) {
      Okx = a.ks(paramContext);
    }
    int i = Okx;
    AppMethodBeat.o(125491);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.d.c
 * JD-Core Version:    0.7.0.1
 */