package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONObject;

public class x
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(153122);
    AppMethodBeat.o(153122);
  }
  
  public final void b(a<e>.a parama)
  {
    AppMethodBeat.i(6317);
    JSONObject localJSONObject = parama.byF.bxK;
    if (localJSONObject == null)
    {
      parama.a("invalid_params", null);
      AppMethodBeat.o(6317);
      return;
    }
    JSONArray localJSONArray = localJSONObject.optJSONArray("urls");
    if ((localJSONArray == null) || (localJSONArray.length() == 0))
    {
      ab.e("MicroMsg.JsApiImagePreview", "fail, urls is null");
      parama.a("invalid_url", null);
      AppMethodBeat.o(6317);
      return;
    }
    f.a("com.tencent.mm", new IPCString(localJSONObject.toString()), x.a.class, new x.1(this, parama, localJSONObject));
    AppMethodBeat.o(6317);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "imagePreview";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.x
 * JD-Core Version:    0.7.0.1
 */