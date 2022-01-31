package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.bo;

public final class p
{
  public static void C(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(6223);
    if (bo.isNullOrNil(paramIntent.getStringExtra("rawUrl")))
    {
      AppMethodBeat.o(6223);
      return;
    }
    d.b(paramContext, "game", ".luggage.LuggageGameWebViewUI", paramIntent);
    AppMethodBeat.o(6223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.p
 * JD-Core Version:    0.7.0.1
 */