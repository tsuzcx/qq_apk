package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.ap;

public final class b
{
  public static final float CBA;
  public static final int CBs;
  public static final int CBt;
  public static final int CBu;
  public static final int CBv;
  public static final int CBw;
  public static final float CBx;
  public static final int CBy;
  public static final int CBz;
  public static final int nhO;
  public static int nia;
  
  static
  {
    AppMethodBeat.i(80415);
    nia = ej(ai.getContext());
    nhO = ap.ji(ai.getContext());
    CBs = ai.getContext().getResources().getDimensionPixelSize(2131165252);
    CBt = ai.getContext().getResources().getDimensionPixelSize(2131167017);
    CBu = ai.getContext().getResources().getDimensionPixelSize(2131167016);
    CBv = ai.getContext().getResources().getDimensionPixelSize(2131167014);
    int i = ai.getContext().getResources().getDimensionPixelSize(2131167013);
    CBw = i;
    CBx = i / CBv;
    CBy = ai.getContext().getResources().getDimensionPixelSize(2131167010);
    i = ai.getContext().getResources().getDimensionPixelSize(2131167009);
    CBz = i;
    CBA = i / CBy;
    AppMethodBeat.o(80415);
  }
  
  private static int ej(Context paramContext)
  {
    AppMethodBeat.i(80413);
    int i = ap.ej(paramContext);
    ac.i("MicroMsg.BagIndicatorController", "getNavigationBarHeight height:%d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(80413);
    return i;
  }
  
  public static void ek(Context paramContext)
  {
    AppMethodBeat.i(80414);
    nia = ej(paramContext);
    AppMethodBeat.o(80414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.b
 * JD-Core Version:    0.7.0.1
 */