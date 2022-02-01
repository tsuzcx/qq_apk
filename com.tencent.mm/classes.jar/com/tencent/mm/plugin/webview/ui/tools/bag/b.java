package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ax;

public final class b
{
  public static final int QhO;
  public static final int QhP;
  public static final int QhQ;
  public static final int QhR;
  public static final int QhS;
  public static final float QhT;
  public static final int QhU;
  public static final int QhV;
  public static final float QhW;
  public static final int saJ;
  public static int saV;
  
  static
  {
    AppMethodBeat.i(80415);
    saV = aB(MMApplicationContext.getContext());
    saJ = ax.getStatusBarHeight(MMApplicationContext.getContext());
    QhO = MMApplicationContext.getContext().getResources().getDimensionPixelSize(c.d.DefaultActionbarHeightPort);
    QhP = MMApplicationContext.getContext().getResources().getDimensionPixelSize(c.d.webview_bag_size);
    QhQ = MMApplicationContext.getContext().getResources().getDimensionPixelSize(c.d.webview_bag_margin);
    QhR = MMApplicationContext.getContext().getResources().getDimensionPixelSize(c.d.webview_bag_indicator_size);
    int i = MMApplicationContext.getContext().getResources().getDimensionPixelSize(c.d.webview_bag_indicator_container_size);
    QhS = i;
    QhT = i / QhR;
    QhU = MMApplicationContext.getContext().getResources().getDimensionPixelSize(c.d.webview_bag_canceller_size);
    i = MMApplicationContext.getContext().getResources().getDimensionPixelSize(c.d.webview_bag_canceller_container_size);
    QhV = i;
    QhW = i / QhU;
    AppMethodBeat.o(80415);
  }
  
  private static int aB(Context paramContext)
  {
    AppMethodBeat.i(80413);
    int i = ax.aB(paramContext);
    Log.i("MicroMsg.BagIndicatorController", "getNavigationBarHeight height:%d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(80413);
    return i;
  }
  
  public static void eJ(Context paramContext)
  {
    AppMethodBeat.i(80414);
    saV = aB(paramContext);
    AppMethodBeat.o(80414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.b
 * JD-Core Version:    0.7.0.1
 */