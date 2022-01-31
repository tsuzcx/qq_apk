package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$ac$45
  implements Runnable
{
  WebViewUI$ac$45(WebViewUI.ac paramac, String paramString, int paramInt, Boolean paramBoolean) {}
  
  public final void run()
  {
    boolean bool2 = false;
    if ((this.rqr.rpH.rbk != null) && (this.rqr.rpH.gGo != null) && (this.rqr.rpH.gGo.cdI() != null))
    {
      this.rqr.rpH.gGo.cdI();
      JsapiPermissionWrapper.cpa();
      this.rqr.rpH.rbk.cU(this.rpN, this.fH);
      return;
    }
    if ((this.rqr.rpH.rbk != null) && (this.wuJ.booleanValue()))
    {
      this.rqr.rpH.rbk.cU(this.rpN, this.fH);
      return;
    }
    if (this.rqr.rpH.rbk == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.rqr.rpH.gGo == null) {
        bool2 = true;
      }
      y.w("MicroMsg.WebViewUI", "something null, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.ac.45
 * JD-Core Version:    0.7.0.1
 */