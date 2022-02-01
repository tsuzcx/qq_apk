package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ap;

public final class b
{
  public static final int Bjf;
  public static final int Bjg;
  public static final int Bjh;
  public static final int Bji;
  public static final int Bjj;
  public static final float Bjk;
  public static final int Bjl;
  public static final int Bjm;
  public static final float Bjn;
  public static final int mFJ;
  public static int mFV;
  
  static
  {
    AppMethodBeat.i(80415);
    mFV = eb(aj.getContext());
    mFJ = ap.iX(aj.getContext());
    Bjf = aj.getContext().getResources().getDimensionPixelSize(2131165252);
    Bjg = aj.getContext().getResources().getDimensionPixelSize(2131167017);
    Bjh = aj.getContext().getResources().getDimensionPixelSize(2131167016);
    Bji = aj.getContext().getResources().getDimensionPixelSize(2131167014);
    int i = aj.getContext().getResources().getDimensionPixelSize(2131167013);
    Bjj = i;
    Bjk = i / Bji;
    Bjl = aj.getContext().getResources().getDimensionPixelSize(2131167010);
    i = aj.getContext().getResources().getDimensionPixelSize(2131167009);
    Bjm = i;
    Bjn = i / Bjl;
    AppMethodBeat.o(80415);
  }
  
  private static int eb(Context paramContext)
  {
    AppMethodBeat.i(80413);
    int i = ap.eb(paramContext);
    ad.i("MicroMsg.BagIndicatorController", "getNavigationBarHeight height:%d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(80413);
    return i;
  }
  
  public static void ec(Context paramContext)
  {
    AppMethodBeat.i(80414);
    mFV = eb(paramContext);
    AppMethodBeat.o(80414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.b
 * JD-Core Version:    0.7.0.1
 */