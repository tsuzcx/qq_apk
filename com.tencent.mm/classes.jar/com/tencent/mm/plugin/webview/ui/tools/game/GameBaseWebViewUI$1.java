package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;

final class GameBaseWebViewUI$1
  extends c
{
  GameBaseWebViewUI$1(GameBaseWebViewUI paramGameBaseWebViewUI) {}
  
  protected final void R(Bundle paramBundle)
  {
    AppMethodBeat.i(8634);
    try
    {
      if ((this.vmh.igU != null) && (paramBundle != null)) {
        this.vmh.igU.i(96, paramBundle);
      }
      AppMethodBeat.o(8634);
      return;
    }
    catch (RemoteException paramBundle)
    {
      AppMethodBeat.o(8634);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI.1
 * JD-Core Version:    0.7.0.1
 */