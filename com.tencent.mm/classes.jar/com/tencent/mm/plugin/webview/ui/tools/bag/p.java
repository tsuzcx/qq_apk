package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.g;
import com.tencent.mm.sdk.platformtools.ab;

public final class p
  implements h.a
{
  private final d viZ;
  
  public p(d paramd)
  {
    this.viZ = paramd;
  }
  
  public final Bundle ac(Bundle paramBundle)
  {
    AppMethodBeat.i(8274);
    if (this.viZ == null)
    {
      ab.e("MicroMsg.WebViewUIBagIPCDelegate", "doBagLogic mInvoker null");
      AppMethodBeat.o(8274);
      return null;
    }
    try
    {
      paramBundle = this.viZ.i(103, paramBundle);
      AppMethodBeat.o(8274);
      return paramBundle;
    }
    catch (RemoteException paramBundle)
    {
      ab.e("MicroMsg.WebViewUIBagIPCDelegate", "doBagLogic exp=%s", new Object[] { paramBundle.getLocalizedMessage() });
      AppMethodBeat.o(8274);
    }
    return null;
  }
  
  public final void z(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(8275);
    if (this.viZ != null) {
      g.a(this.viZ, 11576, paramArrayOfObject);
    }
    AppMethodBeat.o(8275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.p
 * JD-Core Version:    0.7.0.1
 */