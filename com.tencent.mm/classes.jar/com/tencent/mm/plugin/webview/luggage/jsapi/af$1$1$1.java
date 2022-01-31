package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.os.Bundle;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.n.a;
import com.tencent.mm.sdk.platformtools.ab;

final class af$1$1$1
  implements n.a
{
  af$1$1$1(af.1.1 param1) {}
  
  public final void h(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(6332);
    ab.i("MicroMsg.JsApiLogin", "onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      ab.i("MicroMsg.JsApiLogin", "press back button!");
      this.uTL.uTK.njN.a("auth_cancel", null);
    }
    do
    {
      AppMethodBeat.o(6332);
      return;
      af.a(this.uTL.uTK.uTI, this.uTL.uTK.val$appId, paramBundle, this.uTL.uTJ, paramInt, this.uTL.uTK.njN);
    } while (paramInt != 2);
    ab.e("MicroMsg.JsApiLogin", "fail auth deny!");
    this.uTL.uTK.njN.a("auth_deny", null);
    AppMethodBeat.o(6332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.af.1.1.1
 * JD-Core Version:    0.7.0.1
 */