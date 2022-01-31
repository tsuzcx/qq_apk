package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

final class bc$1
  implements MMActivity.a
{
  bc$1(bc parambc, a.a parama, MMActivity paramMMActivity) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(6382);
    if (paramInt1 == (this.uTW.hashCode() & 0xFFFF))
    {
      if (paramInt2 != -1) {
        break label50;
      }
      this.njN.a("", null);
    }
    for (;;)
    {
      this.val$activity.mmSetOnActivityResultCallback(null);
      AppMethodBeat.o(6382);
      return;
      label50:
      this.njN.a("cancel", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bc.1
 * JD-Core Version:    0.7.0.1
 */