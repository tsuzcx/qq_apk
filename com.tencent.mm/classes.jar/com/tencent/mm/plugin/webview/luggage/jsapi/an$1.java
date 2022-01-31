package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

final class an$1
  implements MMActivity.a
{
  an$1(an paraman, a.a parama, MMActivity paramMMActivity) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(6347);
    if (paramInt1 == (this.uTP.hashCode() & 0xFFFF)) {
      switch (paramInt2)
      {
      default: 
        this.njN.a("fail", null);
      }
    }
    for (;;)
    {
      this.val$activity.mmSetOnActivityResultCallback(null);
      AppMethodBeat.o(6347);
      return;
      this.njN.a("cancel", null);
      continue;
      this.njN.a("", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.an.1
 * JD-Core Version:    0.7.0.1
 */