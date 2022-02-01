package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.v;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public class ba
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(78624);
    String str1 = parama.bWS.bVY.optString("title");
    String str2 = parama.bWS.bVY.optString("icon_url");
    String str3 = parama.bWS.bVY.optString("jump_url");
    v localv = new v();
    if (!bs.isNullOrNil(str1)) {
      localv.title = str1;
    }
    if (!bs.isNullOrNil(str2)) {
      localv.iconUrl = str2;
    }
    if (!bs.isNullOrNil(str3)) {
      localv.jumpUrl = str3;
    }
    parama.a("", null);
    AppMethodBeat.o(78624);
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setDesktopInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ba
 * JD-Core Version:    0.7.0.1
 */