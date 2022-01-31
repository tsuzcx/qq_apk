package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.webview.stub.d;

final class a$1
  extends c
{
  a$1(a parama) {}
  
  protected final void A(Bundle paramBundle)
  {
    try
    {
      if ((this.rwe.rsT != null) && (paramBundle != null)) {
        this.rwe.rsT.f(96, paramBundle);
      }
      return;
    }
    catch (RemoteException paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.a.1
 * JD-Core Version:    0.7.0.1
 */