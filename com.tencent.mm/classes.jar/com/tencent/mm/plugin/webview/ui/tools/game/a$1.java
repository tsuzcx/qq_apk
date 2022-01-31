package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;

final class a$1
  extends c
{
  a$1(a parama) {}
  
  protected final void R(Bundle paramBundle)
  {
    AppMethodBeat.i(8647);
    try
    {
      if ((this.vmw.viZ != null) && (paramBundle != null)) {
        this.vmw.viZ.i(96, paramBundle);
      }
      AppMethodBeat.o(8647);
      return;
    }
    catch (RemoteException paramBundle)
    {
      AppMethodBeat.o(8647);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.a.1
 * JD-Core Version:    0.7.0.1
 */