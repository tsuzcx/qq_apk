package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.am;

public final class b
{
  public static int vhn;
  public static final int vho;
  public static final int vhp;
  public static final int vhq;
  public static final int vhr;
  public static final int vhs;
  public static final int vht;
  public static final float vhu;
  public static final int vhv;
  public static final int vhw;
  public static final float vhx;
  
  static
  {
    AppMethodBeat.i(8149);
    vhn = fx(ah.getContext());
    vho = am.getStatusBarHeight(ah.getContext());
    vhp = ah.getContext().getResources().getDimensionPixelSize(2131427559);
    vhq = ah.getContext().getResources().getDimensionPixelSize(2131428837);
    vhr = ah.getContext().getResources().getDimensionPixelSize(2131428836);
    vhs = ah.getContext().getResources().getDimensionPixelSize(2131428834);
    int i = ah.getContext().getResources().getDimensionPixelSize(2131428833);
    vht = i;
    vhu = i / vhs;
    vhv = ah.getContext().getResources().getDimensionPixelSize(2131428830);
    i = ah.getContext().getResources().getDimensionPixelSize(2131428829);
    vhw = i;
    vhx = i / vhv;
    AppMethodBeat.o(8149);
  }
  
  private static int fx(Context paramContext)
  {
    AppMethodBeat.i(8147);
    int i = am.fx(paramContext);
    ab.i("MicroMsg.BagIndicatorController", "getNavigationBarHeight height:%d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(8147);
    return i;
  }
  
  public static void fy(Context paramContext)
  {
    AppMethodBeat.i(8148);
    vhn = fx(paramContext);
    AppMethodBeat.o(8148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.b
 * JD-Core Version:    0.7.0.1
 */