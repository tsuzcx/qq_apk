package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.sdk.platformtools.bt;

public final class o
{
  public static void O(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(78414);
    if (bt.isNullOrNil(paramIntent.getStringExtra("rawUrl")))
    {
      AppMethodBeat.o(78414);
      return;
    }
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
    AppMethodBeat.o(78414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.o
 * JD-Core Version:    0.7.0.1
 */