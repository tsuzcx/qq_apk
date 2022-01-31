package com.tencent.mm.plugin.webview.luggage.ipc;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IpcProxyUI$1
  implements a
{
  IpcProxyUI$1(IpcProxyUI paramIpcProxyUI) {}
  
  public final void o(Bundle paramBundle)
  {
    AppMethodBeat.i(6249);
    Intent localIntent = new Intent();
    localIntent.putExtra("input_data", paramBundle);
    this.uTc.setResult(-1, localIntent);
    this.uTc.finish();
    AppMethodBeat.o(6249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.IpcProxyUI.1
 * JD-Core Version:    0.7.0.1
 */