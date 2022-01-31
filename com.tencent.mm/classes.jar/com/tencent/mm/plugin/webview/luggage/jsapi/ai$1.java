package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.os.Bundle;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.g;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ai$1
  implements Runnable
{
  ai$1(ai paramai, String paramString, a.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(6341);
    Bundle localBundle = new Bundle();
    localBundle.putString("rawUrl", this.val$url);
    ((com.tencent.mm.plugin.webview.luggage.e)this.njN.byE).byJ.un().h(this.val$url, localBundle);
    AppMethodBeat.o(6341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ai.1
 * JD-Core Version:    0.7.0.1
 */