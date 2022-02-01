package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class aa
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a<f>.a parama)
  {
    AppMethodBeat.i(78565);
    final JSONObject localJSONObject = parama.bWS.bVY;
    if (localJSONObject == null)
    {
      parama.a("invalid_params", null);
      AppMethodBeat.o(78565);
      return;
    }
    Object localObject = localJSONObject.optJSONArray("urls");
    if ((localObject == null) || (((JSONArray)localObject).length() == 0))
    {
      ac.e("MicroMsg.JsApiImagePreview", "fail, urls is null");
      parama.a("invalid_url", null);
      AppMethodBeat.o(78565);
      return;
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("current", localJSONObject.optString("current"));
    j.a((Map)localObject, ((f)parama.bWR).getWebView());
    h.a("com.tencent.mm", new IPCString(localJSONObject.toString()), a.class, new d() {});
    AppMethodBeat.o(78565);
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "imagePreview";
  }
  
  static class a
    implements b<IPCString, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aa
 * JD-Core Version:    0.7.0.1
 */