package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;

public final class b
{
  public static final int JkA;
  public static final float JkB;
  public static final int JkC;
  public static final int JkD;
  public static final float JkE;
  public static final int Jkw;
  public static final int Jkx;
  public static final int Jky;
  public static final int Jkz;
  public static final int oYI;
  public static int oYU;
  
  static
  {
    AppMethodBeat.i(80415);
    oYU = aD(MMApplicationContext.getContext());
    oYI = au.getStatusBarHeight(MMApplicationContext.getContext());
    Jkw = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131165256);
    Jkx = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131167152);
    Jky = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131167151);
    Jkz = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131167149);
    int i = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131167148);
    JkA = i;
    JkB = i / Jkz;
    JkC = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131167145);
    i = MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131167144);
    JkD = i;
    JkE = i / JkC;
    AppMethodBeat.o(80415);
  }
  
  private static int aD(Context paramContext)
  {
    AppMethodBeat.i(80413);
    int i = au.aD(paramContext);
    Log.i("MicroMsg.BagIndicatorController", "getNavigationBarHeight height:%d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(80413);
    return i;
  }
  
  public static void eG(Context paramContext)
  {
    AppMethodBeat.i(80414);
    oYU = aD(paramContext);
    AppMethodBeat.o(80414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.b
 * JD-Core Version:    0.7.0.1
 */