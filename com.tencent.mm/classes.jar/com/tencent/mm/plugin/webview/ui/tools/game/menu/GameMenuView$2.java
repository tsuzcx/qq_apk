package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.m;

final class GameMenuView$2
  implements View.OnClickListener
{
  GameMenuView$2(GameMenuView paramGameMenuView) {}
  
  public final void onClick(View paramView)
  {
    if (GameMenuView.b(this.rxk) != null)
    {
      paramView = (m)paramView.getTag();
      GameMenuView.b(this.rxk).f(paramView);
    }
    if (GameMenuView.c(this.rxk) != null) {
      GameMenuView.c(this.rxk).onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuView.2
 * JD-Core Version:    0.7.0.1
 */