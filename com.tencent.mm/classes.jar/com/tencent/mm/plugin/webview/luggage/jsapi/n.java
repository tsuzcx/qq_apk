package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public class n
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(com.tencent.luggage.d.a<f>.a parama)
  {
    AppMethodBeat.i(78546);
    Object localObject = parama.bWS.bVY;
    String str = ((JSONObject)localObject).optString("brandIcon");
    localObject = ((JSONObject)localObject).optString("brandName");
    ac.i("MicroMsg.JsApiCurrentMpInfo", "doCurrentMpInfo brandIcon:%s", new Object[] { str });
    if (((f)parama.bWR).eAv() != null)
    {
      ((f)parama.bWR).eAv().SN(str);
      if (!bs.isNullOrNil((String)localObject)) {
        ((f)parama.bWR).eAv().SO((String)localObject);
      }
    }
    if (((f)parama.bWR).eAw() != null)
    {
      ((f)parama.bWR).eAw().setIcon(bs.nullAsNil(str));
      if (!bs.isNullOrNil((String)localObject)) {
        ((f)parama.bWR).eAw().setTitle((String)localObject);
      }
      ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(((f)parama.bWR).eAw());
    }
    parama.a("", null);
    AppMethodBeat.o(78546);
  }
  
  public final int bYk()
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