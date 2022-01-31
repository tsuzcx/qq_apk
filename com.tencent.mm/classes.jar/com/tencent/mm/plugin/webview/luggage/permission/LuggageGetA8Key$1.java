package com.tencent.mm.plugin.webview.luggage.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class LuggageGetA8Key$1
  implements Runnable
{
  LuggageGetA8Key$1(LuggageGetA8Key paramLuggageGetA8Key, String paramString, int paramInt, LuggageGetA8Key.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(6458);
    ab.i("MicroMsg.LuggageGetA8Key", "callback: %s", new Object[] { this.val$url });
    if (LuggageGetA8Key.a(this.uUH) != null) {
      LuggageGetA8Key.a(this.uUH, this.val$url, this.uUF, LuggageGetA8Key.a(this.uUH).errType, LuggageGetA8Key.a(this.uUH).errCode, LuggageGetA8Key.a(this.uUH).errMsg, LuggageGetA8Key.a(this.uUH).uUI, this.uUG);
    }
    AppMethodBeat.o(6458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key.1
 * JD-Core Version:    0.7.0.1
 */