package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class ap
  extends ax<e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<e>.a parama)
  {
    int j = 1;
    y.i("MicroMsg.JsApiSetScreenOrientation", "invoke");
    String str = parama.bih.bhk.optString("orientation");
    if (bk.bl(str))
    {
      y.e("MicroMsg.JsApiSetScreenOrientation", "data is null");
      parama.a("invalid_data", null);
      return;
    }
    int i;
    if (str.equals("horizontal")) {
      i = 0;
    }
    for (;;)
    {
      ((e)parama.big).BV(i);
      parama.a("", null);
      return;
      i = j;
      if (!str.equals("vertical")) {
        if (str.equals("sensor"))
        {
          i = 4;
        }
        else if (str.equals("horizontal_unforced"))
        {
          i = 0;
        }
        else
        {
          i = j;
          if (!str.equals("vertical_unforced")) {
            i = -1;
          }
        }
      }
    }
  }
  
  public final String name()
  {
    return "setScreenOrientation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ap
 * JD-Core Version:    0.7.0.1
 */