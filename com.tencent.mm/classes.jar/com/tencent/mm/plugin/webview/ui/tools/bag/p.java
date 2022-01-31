package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.sdk.platformtools.y;

public final class p
  implements h.a
{
  private final d rsT;
  
  public p(d paramd)
  {
    this.rsT = paramd;
  }
  
  public final Bundle L(Bundle paramBundle)
  {
    if (this.rsT == null)
    {
      y.e("MicroMsg.WebViewUIBagIPCDelegate", "doBagLogic mInvoker null");
      return null;
    }
    try
    {
      paramBundle = this.rsT.f(103, paramBundle);
      return paramBundle;
    }
    catch (RemoteException paramBundle)
    {
      y.e("MicroMsg.WebViewUIBagIPCDelegate", "doBagLogic exp=%s", new Object[] { paramBundle.getLocalizedMessage() });
    }
    return null;
  }
  
  public final void u(Object[] paramArrayOfObject)
  {
    if (this.rsT != null) {
      e.a(this.rsT, 11576, paramArrayOfObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.p
 * JD-Core Version:    0.7.0.1
 */