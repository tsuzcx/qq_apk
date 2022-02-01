package com.tencent.mm.plugin.webview.luggage.c;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static int a(Window paramWindow, boolean paramBoolean)
  {
    AppMethodBeat.i(78762);
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
      AppMethodBeat.o(78762);
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
  
  public static void b(Window paramWindow, final boolean paramBoolean)
  {
    AppMethodBeat.i(78761);
    if (paramBoolean)
    {
      i = a(paramWindow, paramBoolean);
      paramWindow.getDecorView().setSystemUiVisibility(i);
      paramWindow.setFlags(1024, 1024);
      paramWindow.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
      {
        public final void onSystemUiVisibilityChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(78760);
          if ((paramAnonymousInt & 0x4) == 0) {
            b.this.getDecorView().setSystemUiVisibility(b.a(b.this, paramBoolean));
          }
          AppMethodBeat.o(78760);
        }
      });
      AppMethodBeat.o(78761);
      return;
    }
    int i = a(paramWindow, paramBoolean);
    paramWindow.getDecorView().setSystemUiVisibility(i);
    paramWindow.clearFlags(1024);
    paramWindow.getDecorView().setOnSystemUiVisibilityChangeListener(null);
    AppMethodBeat.o(78761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.c.b
 * JD-Core Version:    0.7.0.1
 */