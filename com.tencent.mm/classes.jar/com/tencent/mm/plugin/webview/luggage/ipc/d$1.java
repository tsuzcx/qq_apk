package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import org.json.JSONObject;

final class d$1
  extends bh.a
{
  d$1(d paramd, a parama) {}
  
  public final void c(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(6253);
    Bundle localBundle = new Bundle();
    localBundle.putString("err_msg", paramString);
    if (paramJSONObject != null) {}
    for (paramString = paramJSONObject.toString();; paramString = "")
    {
      localBundle.putString("data", paramString);
      this.uSk.o(localBundle);
      AppMethodBeat.o(6253);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.d.1
 * JD-Core Version:    0.7.0.1
 */