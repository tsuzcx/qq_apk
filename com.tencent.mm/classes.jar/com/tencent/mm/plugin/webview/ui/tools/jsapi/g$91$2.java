package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h.b;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ab;

final class g$91$2
  implements h.b
{
  g$91$2(g.91 param91) {}
  
  public final void onError()
  {
    AppMethodBeat.i(155011);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("playResult", "onVoicePlayEnd:fail");
      localBundle.putString("localId", this.vro.nlv);
      g.l(this.vro.vqm).e(2002, localBundle);
      AppMethodBeat.o(155011);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(155011);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.91.2
 * JD-Core Version:    0.7.0.1
 */