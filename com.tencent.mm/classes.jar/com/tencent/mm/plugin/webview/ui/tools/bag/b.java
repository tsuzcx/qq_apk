package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ar;

public final class b
{
  public static final int Efa;
  public static final int Efb;
  public static final int Efc;
  public static final int Efd;
  public static final int Efe;
  public static final float Eff;
  public static final int Efg;
  public static final int Efh;
  public static final float Efi;
  public static final int nIk;
  public static int nIw;
  
  static
  {
    AppMethodBeat.i(80415);
    nIw = ej(aj.getContext());
    nIk = ar.jG(aj.getContext());
    Efa = aj.getContext().getResources().getDimensionPixelSize(2131165252);
    Efb = aj.getContext().getResources().getDimensionPixelSize(2131167017);
    Efc = aj.getContext().getResources().getDimensionPixelSize(2131167016);
    Efd = aj.getContext().getResources().getDimensionPixelSize(2131167014);
    int i = aj.getContext().getResources().getDimensionPixelSize(2131167013);
    Efe = i;
    Eff = i / Efd;
    Efg = aj.getContext().getResources().getDimensionPixelSize(2131167010);
    i = aj.getContext().getResources().getDimensionPixelSize(2131167009);
    Efh = i;
    Efi = i / Efg;
    AppMethodBeat.o(80415);
  }
  
  private static int ej(Context paramContext)
  {
    AppMethodBeat.i(80413);
    int i = ar.ej(paramContext);
    ad.i("MicroMsg.BagIndicatorController", "getNavigationBarHeight height:%d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(80413);
    return i;
  }
  
  public static void ek(Context paramContext)
  {
    AppMethodBeat.i(80414);
    nIw = ej(paramContext);
    AppMethodBeat.o(80414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.b
 * JD-Core Version:    0.7.0.1
 */