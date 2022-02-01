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
import com.tencent.mm.plugin.webview.luggage.q;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import org.json.JSONObject;

public class n
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78546);
    Object localObject = paramb.crh.cqn;
    String str1 = ((JSONObject)localObject).optString("brandIcon");
    String str2 = ((JSONObject)localObject).optString("brandName");
    localObject = ((JSONObject)localObject).optString("title");
    Log.i("MicroMsg.JsApiCurrentMpInfo", "doCurrentMpInfo brandIcon:%s", new Object[] { str1 });
    if (!Util.isNullOrNil(str1))
    {
      ((g)paramb.crg).gUD().aox(str1);
      t localt = ((g)paramb.crg).gUE();
      p.k(str1, "icon");
      localt.PRs = str1;
      localt.aox(str1);
    }
    if (!Util.isNullOrNil(str2)) {
      ((g)paramb.crg).gUE().aQZ(str2);
    }
    if (!Util.isNullOrNil((String)localObject))
    {
      ((g)paramb.crg).gUD().aoy((String)localObject);
      ((g)paramb.crg).gUE().aMT((String)localObject);
    }
    if (((g)paramb.crg).gUF() != null)
    {
      ((g)paramb.crg).gUF().setIcon(Util.nullAsNil(str1));
      if (!Util.isNullOrNil(str2)) {
        ((g)paramb.crg).gUF().setTitle(str2);
      }
      ((a)h.ae(a.class)).e(((g)paramb.crg).gUF());
    }
    paramb.a("", null);
    AppMethodBeat.o(78546);
  }
  
  public final int cDj()
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