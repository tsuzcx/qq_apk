package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.e.15;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public class j
  extends ax<e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<e>.a parama)
  {
    y.i("MicroMsg.JsApiClearBounceBackground", "invokeInOwn");
    e locale = (e)parama.big;
    locale.mHandler.post(new e.15(locale));
    parama.a("", null);
  }
  
  public final String name()
  {
    return "clearBounceBackground";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.j
 * JD-Core Version:    0.7.0.1
 */