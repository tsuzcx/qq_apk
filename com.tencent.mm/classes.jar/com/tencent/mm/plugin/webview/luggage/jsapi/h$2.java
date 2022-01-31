package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.d;

final class h$2
  implements n.d
{
  h$2(h paramh, String paramString, Intent paramIntent) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(6289);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(6289);
      return;
      h.a(this.uTu, this.uTv, this.val$intent);
      AppMethodBeat.o(6289);
      return;
      h.a(this.uTu, this.val$intent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.h.2
 * JD-Core Version:    0.7.0.1
 */