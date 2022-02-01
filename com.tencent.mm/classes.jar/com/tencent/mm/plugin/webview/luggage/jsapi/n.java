package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.handoff.a.a;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.r;
import com.tencent.mm.plugin.webview.luggage.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.s;
import org.json.JSONObject;

public class n
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78546);
    Object localObject = paramb.eiZ.eif;
    String str1 = ((JSONObject)localObject).optString("brandIcon");
    String str2 = ((JSONObject)localObject).optString("brandName");
    localObject = ((JSONObject)localObject).optString("title");
    Log.i("MicroMsg.JsApiCurrentMpInfo", "doCurrentMpInfo brandIcon:%s", new Object[] { str1 });
    if (!Util.isNullOrNil(str1))
    {
      ((g)paramb.eiY).ium().ahT(str1);
      u localu = ((g)paramb.eiY).iun();
      s.u(str1, "icon");
      localu.WHQ = str1;
      localu.ahT(str1);
    }
    if (!Util.isNullOrNil(str2)) {
      ((g)paramb.eiY).iun().aNR(str2);
    }
    if (!Util.isNullOrNil((String)localObject))
    {
      ((g)paramb.eiY).ium().ahU((String)localObject);
      ((g)paramb.eiY).iun().updateTitle((String)localObject);
    }
    if (((g)paramb.eiY).iuo() != null)
    {
      ((g)paramb.eiY).iuo().setIcon(Util.nullAsNil(str1));
      if (!Util.isNullOrNil(str2)) {
        ((g)paramb.eiY).iuo().setTitle(str2);
      }
      ((a)h.ax(a.class)).e(((g)paramb.eiY).iuo());
    }
    paramb.a("", null);
    AppMethodBeat.o(78546);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "currentMpInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.n
 * JD-Core Version:    0.7.0.1
 */