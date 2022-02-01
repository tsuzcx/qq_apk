package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Util;

public final class q
{
  public static void aJ(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(78414);
    if (Util.isNullOrNil(paramIntent.getStringExtra("rawUrl")))
    {
      AppMethodBeat.o(78414);
      return;
    }
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
    AppMethodBeat.o(78414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.q
 * JD-Core Version:    0.7.0.1
 */