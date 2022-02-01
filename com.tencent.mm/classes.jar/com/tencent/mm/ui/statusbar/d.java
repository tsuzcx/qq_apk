package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.ui.q;

public final class d
  extends q
{
  public static void b(Window paramWindow)
  {
    AppMethodBeat.i(133827);
    if (paramWindow == null)
    {
      AppMethodBeat.o(133827);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramWindow.clearFlags(67108864);
      paramWindow.addFlags(-2147483648);
      paramWindow.setStatusBarColor(0);
    }
    AppMethodBeat.o(133827);
  }
  
  public static boolean e(Window paramWindow)
  {
    AppMethodBeat.i(133826);
    if ((paramWindow == null) || (paramWindow.getDecorView() == null))
    {
      AppMethodBeat.o(133826);
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 23) && ((paramWindow.getDecorView().getSystemUiVisibility() & 0x2000) != 0))
    {
      AppMethodBeat.o(133826);
      return true;
    }
    AppMethodBeat.o(133826);
    return false;
  }
  
  public static Activity kA(Context paramContext)
  {
    AppMethodBeat.i(221635);
    paramContext = a.jq(paramContext);
    AppMethodBeat.o(221635);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.d
 * JD-Core Version:    0.7.0.1
 */