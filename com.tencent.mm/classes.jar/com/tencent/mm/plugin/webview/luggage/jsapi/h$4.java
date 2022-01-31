package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Intent;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.webview.luggage.d.c;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class h$4
  implements MMActivity.a
{
  h$4(h paramh) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == (this.rdz.hashCode() & 0xFFFF)) {
      switch (paramInt2)
      {
      }
    }
    Object localObject1;
    for (;;)
    {
      h.b(this.rdz).a("fail", null);
      return;
      h.b(this.rdz).a("cancel", null);
      return;
      if (paramIntent == null)
      {
        y.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA bundle is null,");
        h.b(this.rdz).a("fail", null);
        return;
      }
      paramInt1 = paramIntent.getIntExtra("key_pick_local_media_callback_type", 0);
      if (paramInt1 != 1) {
        break;
      }
      localObject1 = paramIntent.getStringExtra("key_pick_local_media_local_id");
      paramIntent = paramIntent.getStringExtra("key_pick_local_media_thumb_local_id");
      y.i("MicroMsg.JsApiChooseMedia", "video localId:%s", new Object[] { localObject1 });
      y.i("MicroMsg.JsApiChooseMedia", "video thumbLocalId:%s", new Object[] { paramIntent });
      if (bk.bl((String)localObject1))
      {
        y.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA video localId is null");
        h.b(this.rdz).a("fail", null);
        return;
      }
      Object localObject2 = c.Sc((String)localObject1);
      if ((localObject2 != null) && ((localObject2 instanceof WebViewJSSDKVideoItem)))
      {
        localObject2 = (WebViewJSSDKVideoItem)localObject2;
        paramIntent = am.c((String)localObject1, paramIntent, ((WebViewJSSDKVideoItem)localObject2).duration, ((WebViewJSSDKVideoItem)localObject2).height, ((WebViewJSSDKVideoItem)localObject2).width, ((WebViewJSSDKVideoItem)localObject2).size);
        y.i("MicroMsg.JsApiChooseMedia", "after parse to json data : %s", new Object[] { paramIntent });
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("type", Integer.valueOf(1));
        ((HashMap)localObject1).put("localIds", paramIntent);
        h.b(this.rdz).c("", (Map)localObject1);
        return;
      }
      y.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA nor the videoitem");
    }
    if (paramInt1 == 2)
    {
      paramIntent = paramIntent.getStringExtra("key_pick_local_media_local_ids");
      y.i("MicroMsg.JsApiChooseMedia", "chooseMedia localIds:%s", new Object[] { paramIntent });
      if (bk.bl(paramIntent))
      {
        y.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA image localIds is null");
        h.b(this.rdz).a("fail", null);
        return;
      }
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("type", Integer.valueOf(2));
      ((HashMap)localObject1).put("localIds", paramIntent);
      h.b(this.rdz).c("", (Map)localObject1);
      return;
    }
    y.e("MicroMsg.JsApiChooseMedia", "type:%d is error", new Object[] { Integer.valueOf(paramInt1) });
    h.b(this.rdz).a("fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.h.4
 * JD-Core Version:    0.7.0.1
 */