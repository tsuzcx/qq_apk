package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.handoff.a.a;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.luggage.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class n
  extends br<com.tencent.mm.plugin.webview.luggage.g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<com.tencent.mm.plugin.webview.luggage.g>.a paramb)
  {
    AppMethodBeat.i(78546);
    Object localObject = paramb.chh.cgn;
    String str = ((JSONObject)localObject).optString("brandIcon");
    localObject = ((JSONObject)localObject).optString("brandName");
    ad.i("MicroMsg.JsApiCurrentMpInfo", "doCurrentMpInfo brandIcon:%s", new Object[] { str });
    if (((com.tencent.mm.plugin.webview.luggage.g)paramb.chg).ePl() != null)
    {
      ((com.tencent.mm.plugin.webview.luggage.g)paramb.chg).ePl().Wl(str);
      if (!bt.isNullOrNil((String)localObject)) {
        ((com.tencent.mm.plugin.webview.luggage.g)paramb.chg).ePl().Wm((String)localObject);
      }
    }
    if (((com.tencent.mm.plugin.webview.luggage.g)paramb.chg).ePm() != null)
    {
      ((com.tencent.mm.plugin.webview.luggage.g)paramb.chg).ePm().setIcon(bt.nullAsNil(str));
      if (!bt.isNullOrNil((String)localObject)) {
        ((com.tencent.mm.plugin.webview.luggage.g)paramb.chg).ePm().setTitle((String)localObject);
      }
      ((a)com.tencent.mm.kernel.g.ab(a.class)).e(((com.tencent.mm.plugin.webview.luggage.g)paramb.chg).ePm());
    }
    paramb.a("", null);
    AppMethodBeat.o(78546);
  }
  
  public final int ccO()
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