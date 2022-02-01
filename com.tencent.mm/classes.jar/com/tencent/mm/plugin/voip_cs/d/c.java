package com.tencent.mm.plugin.voip_cs.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.aj;

public final class c
{
  public static final int tRK;
  public static final int tRL;
  public static final int tRM;
  public static final int tRN;
  public static final int tRP;
  public static final int tRS;
  public static final int tRU;
  public static final int tSa;
  public static final int tSc;
  public static final int tSf;
  private static int zDV;
  
  static
  {
    AppMethodBeat.i(125492);
    tRK = a.fromDPToPix(aj.getContext(), 3);
    tRL = a.fromDPToPix(aj.getContext(), 4);
    tRM = a.fromDPToPix(aj.getContext(), 8);
    tRN = a.fromDPToPix(aj.getContext(), 10);
    tRP = a.fromDPToPix(aj.getContext(), 14);
    tRS = a.fromDPToPix(aj.getContext(), 30);
    tRU = a.fromDPToPix(aj.getContext(), 32);
    tSc = a.fromDPToPix(aj.getContext(), 96);
    tSa = a.fromDPToPix(aj.getContext(), 76);
    tSf = a.fromDPToPix(aj.getContext(), 230);
    zDV = 0;
    AppMethodBeat.o(125492);
  }
  
  public static int gs(Context paramContext)
  {
    AppMethodBeat.i(125491);
    if (zDV == 0) {
      zDV = a.hW(paramContext);
    }
    int i = zDV;
    AppMethodBeat.o(125491);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.d.c
 * JD-Core Version:    0.7.0.1
 */