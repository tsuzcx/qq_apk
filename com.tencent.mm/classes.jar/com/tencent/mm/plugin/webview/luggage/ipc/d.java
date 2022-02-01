package com.tencent.mm.plugin.webview.luggage.ipc;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class d
  implements c
{
  public final void a(Context paramContext, Bundle paramBundle, final a parama)
  {
    AppMethodBeat.i(78494);
    String str = paramBundle.getString("jsapi_name");
    paramBundle = paramBundle.getString("data");
    if (str == null)
    {
      Log.e("MicroMsg.JsApiMMActivityTask", "jsapi is null");
      parama.v(new Bundle());
      AppMethodBeat.o(78494);
      return;
    }
    try
    {
      ((br)Class.forName(str).newInstance()).a(paramContext, paramBundle, new br.a()
      {
        public final void i(String paramAnonymousString, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(78493);
          Bundle localBundle = new Bundle();
          localBundle.putString("err_msg", paramAnonymousString);
          if (paramAnonymousJSONObject != null) {}
          for (paramAnonymousString = paramAnonymousJSONObject.toString();; paramAnonymousString = "")
          {
            localBundle.putString("data", paramAnonymousString);
            parama.v(localBundle);
            AppMethodBeat.o(78493);
            return;
          }
        }
      });
      AppMethodBeat.o(78494);
      return;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.JsApiMMActivityTask", paramContext, "", new Object[0]);
      parama.v(new Bundle());
      AppMethodBeat.o(78494);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.d
 * JD-Core Version:    0.7.0.1
 */