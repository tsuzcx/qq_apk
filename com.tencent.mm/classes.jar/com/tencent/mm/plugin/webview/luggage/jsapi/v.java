package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class v
  extends ax<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    y.i("MicroMsg.JsApiImagePreview", "invokeInOwn");
    Object localObject2 = parama.bih.bhk.optString("current");
    Object localObject4 = parama.bih.bhk.optJSONArray("urls");
    ArrayList localArrayList = new ArrayList();
    if ((localObject4 == null) || (((JSONArray)localObject4).length() == 0))
    {
      y.e("MicroMsg.JsApiImagePreview", "fail, urls is null");
      parama.a("invalid_url", null);
      return;
    }
    int i = 0;
    Object localObject1;
    if (i < ((JSONArray)localObject4).length())
    {
      localObject3 = ((JSONArray)localObject4).optString(i);
      if ((bk.bl((String)localObject3)) || (((String)localObject3).equalsIgnoreCase("null"))) {
        y.e("MicroMsg.JsApiImagePreview", "null url, i = %d", new Object[] { Integer.valueOf(i) });
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = localObject3;
        if (bk.pm((String)localObject3).startsWith("weixin://resourceid/"))
        {
          localObject1 = g.ccL().Sl((String)localObject3);
          if (localObject1 != null) {
            localObject1 = ((WebViewJSSDKFileItem)localObject1).fMZ;
          }
        }
        else
        {
          localArrayList.add(localObject1);
        }
      }
    }
    Object localObject3 = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    if (bk.bl((String)localObject2)) {
      localObject1 = localObject3[0];
    }
    for (;;)
    {
      localObject2 = new Intent();
      localObject4 = b.cSe().getCookie(((com.tencent.mm.plugin.webview.luggage.e)parama.big).getUrl());
      if (!bk.bl((String)localObject4)) {
        ((Intent)localObject2).putExtra("cookie", (String)localObject4);
      }
      ((Intent)localObject2).putExtra("nowUrl", (String)localObject1);
      ((Intent)localObject2).putExtra("urlList", (String[])localObject3);
      ((Intent)localObject2).putExtra("type", -255);
      ((Intent)localObject2).putExtra("isFromWebView", true);
      d.b(((com.tencent.mm.plugin.webview.luggage.e)parama.big).mContext, "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject2);
      parama.a("", null);
      return;
      if (((String)localObject2).startsWith("weixin://resourceid/"))
      {
        localObject1 = g.ccL().Sl((String)localObject2);
        if (localObject1 != null) {
          localObject1 = ((WebViewJSSDKFileItem)localObject1).fMZ;
        } else {
          localObject1 = "";
        }
      }
      else
      {
        localObject1 = localObject2;
      }
    }
  }
  
  public final String name()
  {
    return "imagePreview";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.v
 * JD-Core Version:    0.7.0.1
 */