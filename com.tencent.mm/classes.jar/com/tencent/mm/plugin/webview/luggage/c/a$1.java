package com.tencent.mm.plugin.webview.luggage.c;

import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  implements View.OnSystemUiVisibilityChangeListener
{
  a$1(Window paramWindow, boolean paramBoolean) {}
  
  public final void onSystemUiVisibilityChange(int paramInt)
  {
    AppMethodBeat.i(6494);
    if ((paramInt & 0x4) == 0) {
      this.ibc.getDecorView().setSystemUiVisibility(a.b(this.ibc, this.iyJ));
    }
    AppMethodBeat.o(6494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.c.a.1
 * JD-Core Version:    0.7.0.1
 */