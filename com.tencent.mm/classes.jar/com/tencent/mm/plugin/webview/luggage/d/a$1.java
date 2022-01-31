package com.tencent.mm.plugin.webview.luggage.d;

import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

final class a$1
  implements View.OnSystemUiVisibilityChangeListener
{
  a$1(Window paramWindow, boolean paramBoolean) {}
  
  public final void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0) {
      this.heE.getDecorView().setSystemUiVisibility(a.b(this.heE, this.rfc));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d.a.1
 * JD-Core Version:    0.7.0.1
 */