package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameMenuImageButton$1
  implements View.OnClickListener
{
  GameMenuImageButton$1(GameMenuImageButton paramGameMenuImageButton, GameMenuImageButton.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(8805);
    if (this.vnB != null) {
      this.vnB.bFE();
    }
    AppMethodBeat.o(8805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton.1
 * JD-Core Version:    0.7.0.1
 */