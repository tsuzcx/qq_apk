package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.os.Bundle;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.g;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ah$1
  implements Runnable
{
  ah$1(ah paramah, boolean paramBoolean, a.a parama, String paramString, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(6339);
    if (this.uTM)
    {
      ((com.tencent.mm.plugin.webview.luggage.e)this.njN.byE).byJ.un().i(this.val$url, this.cax);
      AppMethodBeat.o(6339);
      return;
    }
    ((com.tencent.mm.plugin.webview.luggage.e)this.njN.byE).byJ.un().h(this.val$url, this.cax);
    AppMethodBeat.o(6339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ah.1
 * JD-Core Version:    0.7.0.1
 */