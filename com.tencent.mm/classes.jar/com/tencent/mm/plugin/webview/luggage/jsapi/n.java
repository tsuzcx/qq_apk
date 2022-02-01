package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class n
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(com.tencent.luggage.d.a<f>.a parama)
  {
    AppMethodBeat.i(78546);
    Object localObject = parama.bZV.bZb;
    String str = ((JSONObject)localObject).optString("brandIcon");
    localObject = ((JSONObject)localObject).optString("brandName");
    ad.i("MicroMsg.JsApiCurrentMpInfo", "doCurrentMpInfo brandIcon:%s", new Object[] { str });
    if (((f)parama.bZU).ekZ() != null)
    {
      ((f)parama.bZU).ekZ().OD(str);
      if (!bt.isNullOrNil((String)localObject)) {
        ((f)parama.bZU).ekZ().OE((String)localObject);
      }
    }
    if (((f)parama.bZU).ela() != null)
    {
      ((f)parama.bZU).ela().setIcon(bt.nullAsNil(str));
      if (!bt.isNullOrNil((String)localObject)) {
        ((f)parama.bZU).ela().setTitle((String)localObject);
      }
      ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(((f)parama.bZU).ela());
    }
    parama.a("", null);
    AppMethodBeat.o(78546);
  }
  
  public final int bQV()
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