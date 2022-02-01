package com.tencent.mm.plugin.voip_cs.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ak;

public final class c
{
  private static int CNV;
  public static final int tbf;
  public static final int wve;
  public static final int wvf;
  public static final int wvg;
  public static final int wvi;
  public static final int wvl;
  public static final int wvn;
  public static final int wvt;
  public static final int wvv;
  public static final int wvy;
  
  static
  {
    AppMethodBeat.i(125492);
    wve = a.fromDPToPix(ak.getContext(), 3);
    tbf = a.fromDPToPix(ak.getContext(), 4);
    wvf = a.fromDPToPix(ak.getContext(), 8);
    wvg = a.fromDPToPix(ak.getContext(), 10);
    wvi = a.fromDPToPix(ak.getContext(), 14);
    wvl = a.fromDPToPix(ak.getContext(), 30);
    wvn = a.fromDPToPix(ak.getContext(), 32);
    wvv = a.fromDPToPix(ak.getContext(), 96);
    wvt = a.fromDPToPix(ak.getContext(), 76);
    wvy = a.fromDPToPix(ak.getContext(), 230);
    CNV = 0;
    AppMethodBeat.o(125492);
  }
  
  public static int gN(Context paramContext)
  {
    AppMethodBeat.i(125491);
    if (CNV == 0) {
      CNV = a.iv(paramContext);
    }
    int i = CNV;
    AppMethodBeat.o(125491);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.d.c
 * JD-Core Version:    0.7.0.1
 */