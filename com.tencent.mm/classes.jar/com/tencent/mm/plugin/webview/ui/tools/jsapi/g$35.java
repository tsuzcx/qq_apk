package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.y;

final class g$35
  implements b
{
  g$35(g paramg, i parami, JsapiPermissionWrapper paramJsapiPermissionWrapper) {}
  
  public final void hX(int paramInt)
  {
    if (paramInt == 0)
    {
      g.ea(this.rzi, this.rzk);
      return;
    }
    y.i("MicroMsg.MsgHandler", "EU user failed");
    g.a(this.rzi, this.rzk, "add_contact:fail  EU user failed", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.35
 * JD-Core Version:    0.7.0.1
 */