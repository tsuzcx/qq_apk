package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.sdk.g.b;

public final class d
{
  public static void a(Window paramWindow)
  {
    if (paramWindow == null) {}
    while ((Build.VERSION.SDK_INT < 21) || (((paramWindow.getAttributes().flags & 0x80000000) != 0) && (paramWindow.getStatusBarColor() == 0))) {
      return;
    }
    paramWindow.addFlags(-2147483648);
    paramWindow.setStatusBarColor(0);
  }
  
  public static boolean a(Window paramWindow, boolean paramBoolean)
  {
    if ((paramWindow == null) || (paramWindow.getDecorView() == null)) {}
    while ((Build.VERSION.SDK_INT < 23) || (b.zL())) {
      return false;
    }
    paramWindow = paramWindow.getDecorView();
    int i = paramWindow.getSystemUiVisibility();
    if (paramBoolean) {
      i |= 0x2000;
    }
    for (;;)
    {
      paramWindow.setSystemUiVisibility(i);
      return true;
      i &= 0xFFFFDFFF;
    }
  }
  
  public static boolean c(Window paramWindow)
  {
    if ((paramWindow == null) || (paramWindow.getDecorView() == null)) {}
    while ((Build.VERSION.SDK_INT < 23) || ((paramWindow.getDecorView().getSystemUiVisibility() & 0x2000) == 0)) {
      return false;
    }
    return true;
  }
  
  public static Activity cx(Context paramContext)
  {
    if ((paramContext != null) && ((paramContext instanceof ContextWrapper)) && (!(paramContext instanceof Activity))) {
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    }
    for (;;)
    {
      if ((paramContext instanceof Activity)) {
        return (Activity)paramContext;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.d
 * JD-Core Version:    0.7.0.1
 */