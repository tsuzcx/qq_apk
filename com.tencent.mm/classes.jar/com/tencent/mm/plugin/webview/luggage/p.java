package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.bu;

public final class p
{
  public static void ae(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(78414);
    if (bu.isNullOrNil(paramIntent.getStringExtra("rawUrl")))
    {
      AppMethodBeat.o(78414);
      return;
    }
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
    AppMethodBeat.o(78414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.p
 * JD-Core Version:    0.7.0.1
 */