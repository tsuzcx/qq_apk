package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import org.json.JSONObject;

final class e$1
  extends aw.a
{
  e$1(e parame, b paramb) {}
  
  public final void e(String paramString, JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("err_msg", paramString);
    if (paramJSONObject != null) {}
    for (paramString = paramJSONObject.toString();; paramString = "")
    {
      localBundle.putString("data", paramString);
      this.rcy.g(localBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.e.1
 * JD-Core Version:    0.7.0.1
 */