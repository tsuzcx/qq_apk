package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.os.Bundle;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.n.a;
import com.tencent.mm.sdk.platformtools.y;

final class ab$1$1$1
  implements n.a
{
  ab$1$1$1(ab.1.1 param1) {}
  
  public final void e(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.JsApiLogin", "onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      y.i("MicroMsg.JsApiLogin", "press back button!");
      this.rdJ.rdI.kNj.a("auth_cancel", null);
    }
    do
    {
      return;
      ab.a(this.rdJ.rdI.rdG, this.rdJ.rdI.val$appId, paramBundle, this.rdJ.rdH, paramInt, this.rdJ.rdI.kNj);
    } while (paramInt != 2);
    y.e("MicroMsg.JsApiLogin", "fail auth deny!");
    this.rdJ.rdI.kNj.a("auth_deny", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ab.1.1.1
 * JD-Core Version:    0.7.0.1
 */