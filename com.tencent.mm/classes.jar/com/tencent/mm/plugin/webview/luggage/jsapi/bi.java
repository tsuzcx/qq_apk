package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.z;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class bi
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78624);
    String str1 = paramb.eiZ.eif.optString("title");
    String str2 = paramb.eiZ.eif.optString("icon_url");
    String str3 = paramb.eiZ.eif.optString("jump_url");
    z localz = new z();
    if (!Util.isNullOrNil(str1)) {
      localz.title = str1;
    }
    if (!Util.isNullOrNil(str2)) {
      localz.iconUrl = str2;
    }
    if (!Util.isNullOrNil(str3)) {
      localz.jumpUrl = str3;
    }
    paramb.a("", null);
    AppMethodBeat.o(78624);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setDesktopInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bi
 * JD-Core Version:    0.7.0.1
 */