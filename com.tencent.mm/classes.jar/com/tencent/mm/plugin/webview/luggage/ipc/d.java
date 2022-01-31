package com.tencent.mm.plugin.webview.luggage.ipc;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh;
import com.tencent.mm.sdk.platformtools.ab;

public class d
  implements c
{
  public final void a(Context paramContext, Bundle paramBundle, a parama)
  {
    AppMethodBeat.i(6254);
    String str = paramBundle.getString("jsapi_name");
    paramBundle = paramBundle.getString("data");
    if (str == null)
    {
      ab.e("MicroMsg.JsApiMMActivityTask", "jsapi is null");
      parama.o(new Bundle());
      AppMethodBeat.o(6254);
      return;
    }
    try
    {
      ((bh)Class.forName(str).newInstance()).a(paramContext, paramBundle, new d.1(this, parama));
      AppMethodBeat.o(6254);
      return;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.JsApiMMActivityTask", paramContext, "", new Object[0]);
      parama.o(new Bundle());
      AppMethodBeat.o(6254);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.d
 * JD-Core Version:    0.7.0.1
 */