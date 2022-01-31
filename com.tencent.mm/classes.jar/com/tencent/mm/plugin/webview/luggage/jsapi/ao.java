package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.R.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class ao
  extends ax<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    y.i("MicroMsg.JsApiSetPageTitle", "invokeInOwn");
    String str = parama.bih.bhk.optString("title");
    if (!bk.bl(parama.bih.bhk.optString("color")))
    {
      int i = com.tencent.mm.plugin.webview.ui.tools.e.bb(parama.bih.bhk.optString("color"), ((com.tencent.mm.plugin.webview.luggage.e)parama.big).mContext.getResources().getColor(R.e.action_bar_tittle_color));
      ((com.tencent.mm.plugin.webview.luggage.e)parama.big).cN(str, i);
    }
    for (;;)
    {
      parama.a("", null);
      return;
      ((com.tencent.mm.plugin.webview.luggage.e)parama.big).cN(str, 0);
    }
  }
  
  public final String name()
  {
    return "setPageTitle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ao
 * JD-Core Version:    0.7.0.1
 */