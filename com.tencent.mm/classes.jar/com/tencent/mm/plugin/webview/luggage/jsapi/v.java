package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class v
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final com.tencent.luggage.d.b<g>.a paramb)
  {
    AppMethodBeat.i(210944);
    String str = paramb.ctb.csi.optString("localId");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.JsApiGetLocalImgData", "localId is nil");
      paramb.c("invaild_localid", null);
      AppMethodBeat.o(210944);
      return;
    }
    IPCString localIPCString = new IPCString();
    localIPCString.value = str;
    h.a(MainProcessIPCService.dkO, localIPCString, a.class, new d() {});
    AppMethodBeat.o(210944);
  }
  
  public final int dTs()
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