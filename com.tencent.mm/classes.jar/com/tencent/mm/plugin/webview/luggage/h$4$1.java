package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.u.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class h$4$1
  implements u.a
{
  h$4$1(h.4 param4) {}
  
  public final void Dc(String paramString)
  {
    AppMethodBeat.i(6124);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.GameWebViewMenuListHelper", "share image to friend fail, imgPath is null");
      AppMethodBeat.o(6124);
      return;
    }
    h.a(this.uSf.uSc, paramString);
    AppMethodBeat.o(6124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.h.4.1
 * JD-Core Version:    0.7.0.1
 */