package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.webview.stub.d;

final class GameBaseWebViewUI$1
  extends c
{
  GameBaseWebViewUI$1(GameBaseWebViewUI paramGameBaseWebViewUI) {}
  
  protected final void A(Bundle paramBundle)
  {
    try
    {
      if ((GameBaseWebViewUI.a(this.rvR) != null) && (paramBundle != null)) {
        GameBaseWebViewUI.b(this.rvR).f(96, paramBundle);
      }
      return;
    }
    catch (RemoteException paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI.1
 * JD-Core Version:    0.7.0.1
 */