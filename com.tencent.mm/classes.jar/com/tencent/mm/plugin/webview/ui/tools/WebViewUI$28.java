package com.tencent.mm.plugin.webview.ui.tools;

import android.os.RemoteException;
import com.tencent.mm.plugin.webview.modeltools.h.c;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$28
  implements h.c
{
  WebViewUI$28(WebViewUI paramWebViewUI) {}
  
  public final void uL(String paramString)
  {
    try
    {
      if (this.rpH.gGn != null)
      {
        this.rpH.gGn.a(paramString, null, WebViewUI.N(this.rpH), WebViewUI.O(this.rpH));
        return;
      }
      y.i("MicroMsg.WebViewUI", "viewCaptureCallback, invoker is null");
      return;
    }
    catch (RemoteException paramString)
    {
      y.e("MicroMsg.WebViewUI", "recog failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.28
 * JD-Core Version:    0.7.0.1
 */