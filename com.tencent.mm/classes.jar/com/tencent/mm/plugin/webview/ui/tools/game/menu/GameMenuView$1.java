package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameMenuView$1
  extends DataSetObserver
{
  GameMenuView$1(GameMenuView paramGameMenuView) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(8828);
    GameMenuView.a(this.vod);
    AppMethodBeat.o(8828);
  }
  
  public final void onInvalidated()
  {
    AppMethodBeat.i(8827);
    GameMenuView.a(this.vod);
    AppMethodBeat.o(8827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuView.1
 * JD-Core Version:    0.7.0.1
 */