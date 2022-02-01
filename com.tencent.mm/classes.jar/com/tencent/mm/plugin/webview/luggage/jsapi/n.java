package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.handoff.a.a;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.luggage.q;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import org.json.JSONObject;

public class n
  extends bs<com.tencent.mm.plugin.webview.luggage.g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<com.tencent.mm.plugin.webview.luggage.g>.a paramb)
  {
    AppMethodBeat.i(78546);
    Object localObject = paramb.ctb.csi;
    String str1 = ((JSONObject)localObject).optString("brandIcon");
    String str2 = ((JSONObject)localObject).optString("brandName");
    localObject = ((JSONObject)localObject).optString("title");
    Log.i("MicroMsg.JsApiCurrentMpInfo", "doCurrentMpInfo brandIcon:%s", new Object[] { str1 });
    if (!Util.isNullOrNil(str1))
    {
      ((com.tencent.mm.plugin.webview.luggage.g)paramb.cta).gbI().agS(str1);
      t localt = ((com.tencent.mm.plugin.webview.luggage.g)paramb.cta).gbJ();
      p.h(str1, "icon");
      localt.IVc = str1;
      localt.agS(str1);
    }
    if (!Util.isNullOrNil(str2)) {
      ((com.tencent.mm.plugin.webview.luggage.g)paramb.cta).gbJ().aGL(str2);
    }
    if (!Util.isNullOrNil((String)localObject))
    {
      ((com.tencent.mm.plugin.webview.luggage.g)paramb.cta).gbI().agT((String)localObject);
      ((com.tencent.mm.plugin.webview.luggage.g)paramb.cta).gbJ().aCM((String)localObject);
    }
    if (((com.tencent.mm.plugin.webview.luggage.g)paramb.cta).gbK() != null)
    {
      ((com.tencent.mm.plugin.webview.luggage.g)paramb.cta).gbK().setIcon(Util.nullAsNil(str1));
      if (!Util.isNullOrNil(str2)) {
        ((com.tencent.mm.plugin.webview.luggage.g)paramb.cta).gbK().setTitle(str2);
      }
      ((a)com.tencent.mm.kernel.g.af(a.class)).e(((com.tencent.mm.plugin.webview.luggage.g)paramb.cta).gbK());
    }
    paramb.c("", null);
    AppMethodBeat.o(78546);
  }
  
  public final int dTs()
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