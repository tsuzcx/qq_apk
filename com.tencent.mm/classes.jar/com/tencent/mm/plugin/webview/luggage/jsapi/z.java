package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.l;
import com.tencent.mm.sdk.platformtools.ad;

public class z
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(78562);
    ad.i("MicroMsg.JsApiHideOptionMenu", "invoke");
    l locall = ((f)parama.bZU).ekS();
    if (locall == null)
    {
      ad.e("MicroMsg.JsApiHideOptionMenu", "actionBar is null");
      parama.a("fail", null);
      AppMethodBeat.o(78562);
      return;
    }
    locall.ell();
    parama.a("", null);
    AppMethodBeat.o(78562);
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "hideOptionMenu";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.z
 * JD-Core Version:    0.7.0.1
 */