package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.view.View;
import android.view.View.OnClickListener;

final class e$1
  implements View.OnClickListener
{
  e$1(e parame) {}
  
  public final void onClick(View paramView)
  {
    if (this.rxl.isShowing()) {
      this.rxl.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.e.1
 * JD-Core Version:    0.7.0.1
 */