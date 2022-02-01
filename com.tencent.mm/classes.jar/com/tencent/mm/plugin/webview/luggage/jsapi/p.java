package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.plugin.webview.luggage.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class p
  extends bs
  implements d<Bundle, Parcelable>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(78548);
    JSONObject localJSONObject = parama.crh.cqn;
    if ((localJSONObject != null) && (localJSONObject.has("liteAppInfo")))
    {
      boolean bool = MMApplicationContext.isProcessExist(MMApplicationContext.getLiteProcessName());
      Log.i("JsApiDispatchEvent", "dispatch liteapp  process exist:%b, data:%s", new Object[] { Boolean.valueOf(bool), localJSONObject.toString() });
      if (bool)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("data", localJSONObject.toString());
        j.a(MMApplicationContext.getLiteProcessName(), localBundle, getClass(), null);
      }
      parama.a("", null);
      AppMethodBeat.o(78548);
      return;
    }
    c.b(localJSONObject.optString("eventName"), localJSONObject.optJSONObject("data"));
    parama.a("", null);
    AppMethodBeat.o(78548);
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "dispatchEvent";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.p
 * JD-Core Version:    0.7.0.1
 */