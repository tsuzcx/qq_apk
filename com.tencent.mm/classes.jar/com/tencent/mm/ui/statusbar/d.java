package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.h.b;

public final class d
{
  public static void a(Window paramWindow)
  {
    AppMethodBeat.i(67852);
    if (paramWindow == null)
    {
      AppMethodBeat.o(67852);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 21) && (((paramWindow.getAttributes().flags & 0x80000000) == 0) || (paramWindow.getStatusBarColor() != 0)))
    {
      paramWindow.addFlags(-2147483648);
      paramWindow.setStatusBarColor(0);
    }
    AppMethodBeat.o(67852);
  }
  
  public static boolean a(Window paramWindow, boolean paramBoolean)
  {
    AppMethodBeat.i(67853);
    if ((paramWindow == null) || (paramWindow.getDecorView() == null))
    {
      AppMethodBeat.o(67853);
      return false;
    }
    if (dNu())
    {
      paramWindow = paramWindow.getDecorView();
      int i = paramWindow.getSystemUiVisibility();
      if (paramBoolean) {
        i |= 0x2000;
      }
      for (;;)
      {
        paramWindow.setSystemUiVisibility(i);
        AppMethodBeat.o(67853);
        return true;
        i &= 0xFFFFDFFF;
      }
    }
    AppMethodBeat.o(67853);
    return false;
  }
  
  public static boolean b(Window paramWindow)
  {
    AppMethodBeat.i(67851);
    if ((paramWindow == null) || (paramWindow.getDecorView() == null))
    {
      AppMethodBeat.o(67851);
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 23) && ((paramWindow.getDecorView().getSystemUiVisibility() & 0x2000) != 0))
    {
      AppMethodBeat.o(67851);
      return true;
    }
    AppMethodBeat.o(67851);
    return false;
  }
  
  public static boolean dNu()
  {
    AppMethodBeat.i(67854);
    if ((Build.VERSION.SDK_INT >= 23) && (!b.Mo()))
    {
      AppMethodBeat.o(67854);
      return true;
    }
    AppMethodBeat.o(67854);
    return false;
  }
  
  public static Activity iB(Context paramContext)
  {
    AppMethodBeat.i(156802);
    paramContext = a.hr(paramContext);
    AppMethodBeat.o(156802);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.d
 * JD-Core Version:    0.7.0.1
 */