package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;

public final class b
{
  public static final int WZS;
  public static final int WZT;
  public static final int WZU;
  public static final int WZV;
  public static final int WZW;
  public static final float WZX;
  public static final int WZY;
  public static final int WZZ;
  public static final float Xaa;
  public static final int vmb;
  public static int vmn;
  
  static
  {
    AppMethodBeat.i(80415);
    vmn = bk(MMApplicationContext.getContext());
    vmb = bf.getStatusBarHeight(MMApplicationContext.getContext());
    WZS = MMApplicationContext.getContext().getResources().getDimensionPixelSize(c.d.DefaultActionbarHeightPort);
    WZT = MMApplicationContext.getContext().getResources().getDimensionPixelSize(c.d.webview_bag_size);
    WZU = MMApplicationContext.getContext().getResources().getDimensionPixelSize(c.d.webview_bag_margin);
    WZV = MMApplicationContext.getContext().getResources().getDimensionPixelSize(c.d.webview_bag_indicator_size);
    int i = MMApplicationContext.getContext().getResources().getDimensionPixelSize(c.d.webview_bag_indicator_container_size);
    WZW = i;
    WZX = i / WZV;
    WZY = MMApplicationContext.getContext().getResources().getDimensionPixelSize(c.d.webview_bag_canceller_size);
    i = MMApplicationContext.getContext().getResources().getDimensionPixelSize(c.d.webview_bag_canceller_container_size);
    WZZ = i;
    Xaa = i / WZY;
    AppMethodBeat.o(80415);
  }
  
  private static int bk(Context paramContext)
  {
    AppMethodBeat.i(80413);
    int i = bf.bk(paramContext);
    Log.i("MicroMsg.BagIndicatorController", "getNavigationBarHeight height:%d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(80413);
    return i;
  }
  
  public static void fE(Context paramContext)
  {
    AppMethodBeat.i(80414);
    vmn = bk(paramContext);
    AppMethodBeat.o(80414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.b
 * JD-Core Version:    0.7.0.1
 */