package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.b;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.R.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class an
  extends ax<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    y.i("MicroMsg.JsApiSetNavigationBarColor", "invoke");
    int i;
    if (parama.bih.bhk.optInt("actionCode") == 1) {
      i = 1;
    }
    for (;;)
    {
      int j = -1;
      try
      {
        k = Color.parseColor(parama.bih.bhk.optString("color"));
        k |= 0xFF000000;
        j = i;
        i = k;
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            bk.getFloat(parama.bih.bhk.optString("alpha"), 1.0F);
            if (j == 0) {
              break label165;
            }
            com.tencent.mm.plugin.webview.luggage.e locale1 = (com.tencent.mm.plugin.webview.luggage.e)parama.big;
            locale1.gTL = b.i(locale1.mContext, R.e.action_bar_color);
            locale1.gTN = "";
            locale1.aYB();
            parama.a("", null);
            return;
            i = 0;
            break;
            localException1 = localException1;
            y.e("MicroMsg.JsApiSetNavigationBarColor", localException1.getMessage());
            int k = 1;
            i = j;
            j = k;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            y.e("MicroMsg.JsApiSetNavigationBarColor", localException2.getMessage());
            continue;
            label165:
            com.tencent.mm.plugin.webview.luggage.e locale2 = (com.tencent.mm.plugin.webview.luggage.e)parama.big;
            locale2.rbV = true;
            locale2.gTL = i;
            locale2.aYB();
          }
        }
      }
    }
  }
  
  public final String name()
  {
    return "setNavigationBarColor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.an
 * JD-Core Version:    0.7.0.1
 */