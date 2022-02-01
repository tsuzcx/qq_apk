package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.ar;

public final class b
{
  public static final int Exd;
  public static final int Exe;
  public static final int Exf;
  public static final int Exg;
  public static final int Exh;
  public static final float Exi;
  public static final int Exj;
  public static final int Exk;
  public static final float Exl;
  public static final int nNN;
  public static int nNZ;
  
  static
  {
    AppMethodBeat.i(80415);
    nNZ = en(ak.getContext());
    nNN = ar.jN(ak.getContext());
    Exd = ak.getContext().getResources().getDimensionPixelSize(2131165252);
    Exe = ak.getContext().getResources().getDimensionPixelSize(2131167017);
    Exf = ak.getContext().getResources().getDimensionPixelSize(2131167016);
    Exg = ak.getContext().getResources().getDimensionPixelSize(2131167014);
    int i = ak.getContext().getResources().getDimensionPixelSize(2131167013);
    Exh = i;
    Exi = i / Exg;
    Exj = ak.getContext().getResources().getDimensionPixelSize(2131167010);
    i = ak.getContext().getResources().getDimensionPixelSize(2131167009);
    Exk = i;
    Exl = i / Exj;
    AppMethodBeat.o(80415);
  }
  
  private static int en(Context paramContext)
  {
    AppMethodBeat.i(80413);
    int i = ar.en(paramContext);
    ae.i("MicroMsg.BagIndicatorController", "getNavigationBarHeight height:%d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(80413);
    return i;
  }
  
  public static void eo(Context paramContext)
  {
    AppMethodBeat.i(80414);
    nNZ = en(paramContext);
    AppMethodBeat.o(80414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.b
 * JD-Core Version:    0.7.0.1
 */