package com.tencent.mm.plugin.voip_cs.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;

public final class c
{
  public static final int oVm;
  public static final int oVn;
  public static final int oVo;
  public static final int oVp;
  public static final int oVq;
  public static final int oVr;
  public static final int oVt;
  public static final int oVu;
  public static final int oVv;
  public static final int oVw;
  private static int tLR;
  
  static
  {
    AppMethodBeat.i(135441);
    oVm = a.fromDPToPix(ah.getContext(), 3);
    oVn = a.fromDPToPix(ah.getContext(), 4);
    oVo = a.fromDPToPix(ah.getContext(), 8);
    oVp = a.fromDPToPix(ah.getContext(), 10);
    oVq = a.fromDPToPix(ah.getContext(), 14);
    oVr = a.fromDPToPix(ah.getContext(), 30);
    oVt = a.fromDPToPix(ah.getContext(), 32);
    oVu = a.fromDPToPix(ah.getContext(), 96);
    oVv = a.fromDPToPix(ah.getContext(), 76);
    oVw = a.fromDPToPix(ah.getContext(), 230);
    tLR = 0;
    AppMethodBeat.o(135441);
  }
  
  public static int fp(Context paramContext)
  {
    AppMethodBeat.i(135440);
    if (tLR == 0) {
      tLR = a.gx(paramContext);
    }
    int i = tLR;
    AppMethodBeat.o(135440);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c
 * JD-Core Version:    0.7.0.1
 */