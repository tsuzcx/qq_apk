package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.e.16;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class al
  extends ax<e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<e>.a parama)
  {
    y.i("MicroMsg.JsApiSetBounceBackground", "invokeInOwn");
    String str = parama.bih.bhk.optString("backgroundColor");
    if (bk.bl(str))
    {
      parama.a("invalid_data", null);
      return;
    }
    e locale = (e)parama.big;
    locale.mHandler.post(new e.16(locale, str));
    parama.a("", null);
  }
  
  public final String name()
  {
    return "setBounceBackground";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.al
 * JD-Core Version:    0.7.0.1
 */