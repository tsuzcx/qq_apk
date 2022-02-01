package com.tencent.mm.plugin.voip_cs.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.aj;

public final class c
{
  private static int Cwq;
  public static final int sPS;
  public static final int wfB;
  public static final int wfC;
  public static final int wfD;
  public static final int wfF;
  public static final int wfI;
  public static final int wfK;
  public static final int wfQ;
  public static final int wfS;
  public static final int wfV;
  
  static
  {
    AppMethodBeat.i(125492);
    wfB = a.fromDPToPix(aj.getContext(), 3);
    sPS = a.fromDPToPix(aj.getContext(), 4);
    wfC = a.fromDPToPix(aj.getContext(), 8);
    wfD = a.fromDPToPix(aj.getContext(), 10);
    wfF = a.fromDPToPix(aj.getContext(), 14);
    wfI = a.fromDPToPix(aj.getContext(), 30);
    wfK = a.fromDPToPix(aj.getContext(), 32);
    wfS = a.fromDPToPix(aj.getContext(), 96);
    wfQ = a.fromDPToPix(aj.getContext(), 76);
    wfV = a.fromDPToPix(aj.getContext(), 230);
    Cwq = 0;
    AppMethodBeat.o(125492);
  }
  
  public static int gI(Context paramContext)
  {
    AppMethodBeat.i(125491);
    if (Cwq == 0) {
      Cwq = a.iq(paramContext);
    }
    int i = Cwq;
    AppMethodBeat.o(125491);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.d.c
 * JD-Core Version:    0.7.0.1
 */