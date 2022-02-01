package com.tencent.mm.plugin.voip_cs.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ai;

public final class c
{
  private static int AWi;
  public static final int rTi;
  public static final int vaB;
  public static final int vaH;
  public static final int vaJ;
  public static final int vaM;
  public static final int vas;
  public static final int vat;
  public static final int vau;
  public static final int vaw;
  public static final int vaz;
  
  static
  {
    AppMethodBeat.i(125492);
    vas = a.fromDPToPix(ai.getContext(), 3);
    rTi = a.fromDPToPix(ai.getContext(), 4);
    vat = a.fromDPToPix(ai.getContext(), 8);
    vau = a.fromDPToPix(ai.getContext(), 10);
    vaw = a.fromDPToPix(ai.getContext(), 14);
    vaz = a.fromDPToPix(ai.getContext(), 30);
    vaB = a.fromDPToPix(ai.getContext(), 32);
    vaJ = a.fromDPToPix(ai.getContext(), 96);
    vaH = a.fromDPToPix(ai.getContext(), 76);
    vaM = a.fromDPToPix(ai.getContext(), 230);
    AWi = 0;
    AppMethodBeat.o(125492);
  }
  
  public static int gE(Context paramContext)
  {
    AppMethodBeat.i(125491);
    if (AWi == 0) {
      AWi = a.ih(paramContext);
    }
    int i = AWi;
    AppMethodBeat.o(125491);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.d.c
 * JD-Core Version:    0.7.0.1
 */