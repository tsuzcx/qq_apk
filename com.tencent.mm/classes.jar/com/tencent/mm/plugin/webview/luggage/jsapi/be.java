package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.y;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class be
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78624);
    String str1 = paramb.crh.cqn.optString("title");
    String str2 = paramb.crh.cqn.optString("icon_url");
    String str3 = paramb.crh.cqn.optString("jump_url");
    y localy = new y();
    if (!Util.isNullOrNil(str1)) {
      localy.title = str1;
    }
    if (!Util.isNullOrNil(str2)) {
      localy.iconUrl = str2;
    }
    if (!Util.isNullOrNil(str3)) {
      localy.jumpUrl = str3;
    }
    paramb.a("", null);
    AppMethodBeat.o(78624);
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setDesktopInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.be
 * JD-Core Version:    0.7.0.1
 */