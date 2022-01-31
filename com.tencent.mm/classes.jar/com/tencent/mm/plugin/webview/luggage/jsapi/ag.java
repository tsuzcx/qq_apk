package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.webview.luggage.d.c;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public class ag
  extends ax<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    y.i("MicroMsg.GameJsApiPreviewVideo", "invoke");
    if (bk.bl(parama.bih.bhk.optString("localId")))
    {
      y.i("MicroMsg.GameJsApiPreviewVideo", "data is invalid");
      parama.a("invalid_data", null);
      return;
    }
    Object localObject2 = parama.bih.bhk.optString("localId");
    Object localObject1 = c.Sc((String)localObject2);
    if ((localObject1 == null) || (TextUtils.isEmpty(((WebViewJSSDKFileItem)localObject1).fMZ)) || (!com.tencent.mm.a.e.bK(((WebViewJSSDKFileItem)localObject1).fMZ)))
    {
      y.e("MicroMsg.GameJsApiPreviewVideo", "the item is null or the File item not exist for localId: %s", new Object[] { localObject2 });
      parama.a("fail", null);
      return;
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("key_video_path", ((WebViewJSSDKFileItem)localObject1).fMZ);
    localObject1 = (MMActivity)((com.tencent.mm.plugin.webview.luggage.e)parama.big).mContext;
    ((MMActivity)localObject1).gJb = new ag.1(this, parama, (MMActivity)localObject1);
    d.b((Context)localObject1, "card", ".ui.CardGiftVideoUI", (Intent)localObject2, hashCode() & 0xFFFF);
  }
  
  public final String name()
  {
    return "previewVideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ag
 * JD-Core Version:    0.7.0.1
 */