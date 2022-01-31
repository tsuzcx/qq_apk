package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity.a;

final class z$1
  implements MMActivity.a
{
  z$1(z paramz, bh.a parama) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(6320);
    if (paramInt1 == (this.uTD.hashCode() & 0xFFFF)) {
      ab.i("MicroMsg.JsApiJumpToBizProfile", "request jumpToBizProfile, resultCode = ".concat(String.valueOf(paramInt2)));
    }
    switch (paramInt2)
    {
    case 1: 
    default: 
      this.lax.c("fail", null);
      ab.e("MicroMsg.JsApiJumpToBizProfile", "unknown resultCode");
      AppMethodBeat.o(6320);
      return;
    case -1: 
      this.lax.c(null, null);
      AppMethodBeat.o(6320);
      return;
    case 0: 
      this.lax.c("cancel", null);
      AppMethodBeat.o(6320);
      return;
    }
    this.lax.c("check_fail", null);
    AppMethodBeat.o(6320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.z.1
 * JD-Core Version:    0.7.0.1
 */