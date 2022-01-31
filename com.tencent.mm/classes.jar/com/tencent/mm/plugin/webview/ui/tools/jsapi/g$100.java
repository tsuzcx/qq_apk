package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fr;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.h;

final class g$100
  implements Runnable
{
  g$100(g paramg, boolean paramBoolean, i parami, String paramString, WebViewJSSDKFileItem paramWebViewJSSDKFileItem) {}
  
  public final void run()
  {
    AppMethodBeat.i(9168);
    if (this.vrj)
    {
      localObject = this.vqm;
      Context localContext = g.j(this.vqm);
      g.j(this.vqm).getString(2131297087);
      g.a((g)localObject, h.b(localContext, g.j(this.vqm).getString(2131306044), true, new g.100.1(this)));
    }
    Object localObject = new fr();
    ((fr)localObject).ctT.ctV = this.nlv;
    ((fr)localObject).ctT.fileName = this.vrl.fileName;
    ((fr)localObject).ctT.ctW = 0;
    ((fr)localObject).ctT.scene = 8;
    ((fr)localObject).ctT.ctX = new g.100.2(this, (fr)localObject);
    a.ymk.l((b)localObject);
    AppMethodBeat.o(9168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.100
 * JD-Core Version:    0.7.0.1
 */