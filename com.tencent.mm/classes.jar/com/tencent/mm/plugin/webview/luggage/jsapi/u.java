package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.webview.luggage.b.l;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.y;

public class u
  extends ax<e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<e>.a parama)
  {
    y.i("MicroMsg.JsApiHideOptionMenu", "invoke");
    m localm = ((e)parama.big).rbE;
    if (localm == null)
    {
      y.e("MicroMsg.JsApiHideOptionMenu", "actionBar is null");
      parama.a("fail", null);
      return;
    }
    localm.getMenuHelp().cbD();
    parama.a("", null);
  }
  
  public final String name()
  {
    return "hideOptionMenu";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.u
 * JD-Core Version:    0.7.0.1
 */