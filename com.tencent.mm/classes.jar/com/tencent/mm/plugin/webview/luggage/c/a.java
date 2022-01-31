package com.tencent.mm.plugin.webview.luggage.c;

import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static int b(Window paramWindow, boolean paramBoolean)
  {
    AppMethodBeat.i(6496);
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
    for (;;)
    {
      AppMethodBeat.o(6496);
      return i;
      j = i & 0xFFFFFBFF & 0xFFFFFEFF;
      i = j;
      if (Build.VERSION.SDK_INT >= 20) {
        i = j & 0xFFFFFDFF & 0xFFFFFFFD;
      }
      j = i & 0xFFFFFFFB;
      i = j;
      if (Build.VERSION.SDK_INT >= 19) {
        i = j & 0xFFFFEFFF;
      }
    }
  }
  
  public static void c(Window paramWindow, boolean paramBoolean)
  {
    AppMethodBeat.i(6495);
    if (paramBoolean)
    {
      i = b(paramWindow, paramBoolean);
      paramWindow.getDecorView().setSystemUiVisibility(i);
      paramWindow.setFlags(1024, 1024);
      paramWindow.getDecorView().setOnSystemUiVisibilityChangeListener(new a.1(paramWindow, paramBoolean));
      AppMethodBeat.o(6495);
      return;
    }
    int i = b(paramWindow, paramBoolean);
    paramWindow.getDecorView().setSystemUiVisibility(i);
    paramWindow.clearFlags(1024);
    paramWindow.getDecorView().setOnSystemUiVisibilityChangeListener(null);
    AppMethodBeat.o(6495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.c.a
 * JD-Core Version:    0.7.0.1
 */