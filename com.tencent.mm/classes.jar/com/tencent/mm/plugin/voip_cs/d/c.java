package com.tencent.mm.plugin.voip_cs.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
{
  private static int HsM;
  public static final int wfQ;
  public static final int zSD;
  public static final int zSd;
  public static final int zSe;
  public static final int zSf;
  public static final int zSh;
  public static final int zSl;
  public static final int zSn;
  public static final int zSv;
  public static final int zSy;
  
  static
  {
    AppMethodBeat.i(125492);
    zSd = a.fromDPToPix(MMApplicationContext.getContext(), 3);
    wfQ = a.fromDPToPix(MMApplicationContext.getContext(), 4);
    zSe = a.fromDPToPix(MMApplicationContext.getContext(), 8);
    zSf = a.fromDPToPix(MMApplicationContext.getContext(), 10);
    zSh = a.fromDPToPix(MMApplicationContext.getContext(), 14);
    zSl = a.fromDPToPix(MMApplicationContext.getContext(), 30);
    zSn = a.fromDPToPix(MMApplicationContext.getContext(), 32);
    zSy = a.fromDPToPix(MMApplicationContext.getContext(), 96);
    zSv = a.fromDPToPix(MMApplicationContext.getContext(), 76);
    zSD = a.fromDPToPix(MMApplicationContext.getContext(), 230);
    HsM = 0;
    AppMethodBeat.o(125492);
  }
  
  public static int hI(Context paramContext)
  {
    AppMethodBeat.i(125491);
    if (HsM == 0) {
      HsM = a.jo(paramContext);
    }
    int i = HsM;
    AppMethodBeat.o(125491);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.d.c
 * JD-Core Version:    0.7.0.1
 */