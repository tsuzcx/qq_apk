package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class v
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final com.tencent.luggage.d.b<g>.a paramb)
  {
    AppMethodBeat.i(207906);
    String str = paramb.chh.cgn.optString("localId");
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.JsApiGetLocalImgData", "localId is nil");
      paramb.a("invaild_localid", null);
      AppMethodBeat.o(207906);
      return;
    }
    IPCString localIPCString = new IPCString();
    localIPCString.value = str;
    h.a("com.tencent.mm", localIPCString, a.class, new d() {});
    AppMethodBeat.o(207906);
  }
  
  public final int ccO()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getLocalImgData";
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.v
 * JD-Core Version:    0.7.0.1
 */