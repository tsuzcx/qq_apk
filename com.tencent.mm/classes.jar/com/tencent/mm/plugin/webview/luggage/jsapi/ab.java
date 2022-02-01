package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ab
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final com.tencent.luggage.d.b<g>.a paramb)
  {
    AppMethodBeat.i(78565);
    final JSONObject localJSONObject = paramb.ctb.csi;
    if (localJSONObject == null)
    {
      paramb.c("invalid_params", null);
      AppMethodBeat.o(78565);
      return;
    }
    Object localObject = localJSONObject.optJSONArray("urls");
    if ((localObject == null) || (((JSONArray)localObject).length() == 0))
    {
      Log.e("MicroMsg.JsApiImagePreview", "fail, urls is null");
      paramb.c("invalid_url", null);
      AppMethodBeat.o(78565);
      return;
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("current", localJSONObject.optString("current"));
    j.a((Map)localObject, ((g)paramb.cta).ITd);
    h.a(MainProcessIPCService.dkO, new IPCString(localJSONObject.toString()), a.class, new d() {});
    AppMethodBeat.o(78565);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "imagePreview";
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<IPCString, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ab
 * JD-Core Version:    0.7.0.1
 */