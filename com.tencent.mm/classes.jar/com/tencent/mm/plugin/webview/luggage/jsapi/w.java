package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class w
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    AppMethodBeat.i(296038);
    String str = paramb.eiZ.eif.optString("localId");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.JsApiGetLocalImgData", "localId is nil");
      paramb.a("invaild_localid", null);
      AppMethodBeat.o(296038);
      return;
    }
    IPCString localIPCString = new IPCString();
    localIPCString.value = str;
    j.a(MainProcessIPCService.PROCESS_NAME, localIPCString, a.class, new f() {});
    AppMethodBeat.o(296038);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getLocalImgData";
  }
  
  static class a
    implements d<IPCString, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.w
 * JD-Core Version:    0.7.0.1
 */