package com.tencent.mm.plugin.webview.luggage.d;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.statusbar.d;

public final class a
{
  public static int b(Window paramWindow, boolean paramBoolean)
  {
    int i = paramWindow.getDecorView().getSystemUiVisibility();
    int j;
    if (paramBoolean)
    {
      j = i | 0x400 | 0x100;
      i = j;
      if (Build.VERSION.SDK_INT >= 20) {
        i = j | 0x200 | 0x2;
      }
      j = i | 0x4;
      i = j;
      if (Build.VERSION.SDK_INT >= 19) {
        i = j | 0x1000;
      }
    }
    do
    {
      return i;
      j = i & 0xFFFFFBFF & 0xFFFFFEFF;
      i = j;
      if (Build.VERSION.SDK_INT >= 20) {
        i = j & 0xFFFFFDFF & 0xFFFFFFFD;
      }
      j = i & 0xFFFFFFFB;
      i = j;
    } while (Build.VERSION.SDK_INT < 19);
    return j & 0xFFFFEFFF;
  }
  
  public static boolean b(Context paramContext, int paramInt, String paramString)
  {
    return c(paramContext, paramInt, bk.pm(paramString).equals("black"));
  }
  
  public static void c(Window paramWindow, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      i = b(paramWindow, paramBoolean);
      paramWindow.getDecorView().setSystemUiVisibility(i);
      paramWindow.setFlags(1024, 1024);
      paramWindow.getDecorView().setOnSystemUiVisibilityChangeListener(new a.1(paramWindow, paramBoolean));
      return;
    }
    int i = b(paramWindow, paramBoolean);
    paramWindow.getDecorView().setSystemUiVisibility(i);
    paramWindow.clearFlags(1024);
    paramWindow.getDecorView().setOnSystemUiVisibilityChangeListener(null);
  }
  
  public static boolean c(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (!(paramContext instanceof Activity)) {}
    while (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    paramContext = ((Activity)paramContext).getWindow();
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      i = paramInt;
      if (d.a(paramContext, paramBoolean)) {}
    }
    else
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label67;
      }
      i = paramInt;
      if (paramBoolean) {
        i = ak.Cx(paramInt);
      }
    }
    paramContext.setStatusBarColor(i);
    label67:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d.a
 * JD-Core Version:    0.7.0.1
 */