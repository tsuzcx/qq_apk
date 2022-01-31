package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;

final class h$4
  implements MMActivity.a
{
  h$4(h paramh) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(6291);
    if (paramInt1 == (this.uTu.hashCode() & 0xFFFF)) {
      switch (paramInt2)
      {
      }
    }
    Object localObject1;
    for (;;)
    {
      h.a(this.uTu, "fail");
      AppMethodBeat.o(6291);
      return;
      h.a(this.uTu, "cancel");
      AppMethodBeat.o(6291);
      return;
      if (paramIntent == null)
      {
        ab.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA bundle is null,");
        h.a(this.uTu, "fail");
        AppMethodBeat.o(6291);
        return;
      }
      paramInt1 = paramIntent.getIntExtra("key_pick_local_media_callback_type", 0);
      if (paramInt1 != 1) {
        break;
      }
      localObject1 = paramIntent.getStringExtra("key_pick_local_media_local_id");
      paramIntent = paramIntent.getStringExtra("key_pick_local_media_thumb_local_id");
      ab.i("MicroMsg.JsApiChooseMedia", "video localId:%s", new Object[] { localObject1 });
      ab.i("MicroMsg.JsApiChooseMedia", "video thumbLocalId:%s", new Object[] { paramIntent });
      if (bo.isNullOrNil((String)localObject1))
      {
        ab.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA video localId is null");
        h.a(this.uTu, "fail");
        AppMethodBeat.o(6291);
        return;
      }
      Object localObject2 = b.agY((String)localObject1);
      if ((localObject2 != null) && ((localObject2 instanceof WebViewJSSDKVideoItem)))
      {
        localObject2 = (WebViewJSSDKVideoItem)localObject2;
        paramIntent = ar.b((String)localObject1, paramIntent, ((WebViewJSSDKVideoItem)localObject2).duration, ((WebViewJSSDKVideoItem)localObject2).height, ((WebViewJSSDKVideoItem)localObject2).width, ((WebViewJSSDKVideoItem)localObject2).size);
        ab.i("MicroMsg.JsApiChooseMedia", "after parse to json data : %s", new Object[] { paramIntent });
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("type", Integer.valueOf(1));
        ((HashMap)localObject1).put("localIds", paramIntent);
        h.a(this.uTu, (HashMap)localObject1);
        AppMethodBeat.o(6291);
        return;
      }
      ab.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA nor the videoitem");
    }
    if (paramInt1 == 2)
    {
      paramIntent = paramIntent.getStringExtra("key_pick_local_media_local_ids");
      ab.i("MicroMsg.JsApiChooseMedia", "chooseMedia localIds:%s", new Object[] { paramIntent });
      if (bo.isNullOrNil(paramIntent))
      {
        ab.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA image localIds is null");
        h.a(this.uTu, "fail");
        AppMethodBeat.o(6291);
        return;
      }
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("type", Integer.valueOf(2));
      ((HashMap)localObject1).put("localIds", paramIntent);
      h.a(this.uTu, (HashMap)localObject1);
      AppMethodBeat.o(6291);
      return;
    }
    ab.e("MicroMsg.JsApiChooseMedia", "type:%d is error", new Object[] { Integer.valueOf(paramInt1) });
    h.a(this.uTu, "fail");
    AppMethodBeat.o(6291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.h.4
 * JD-Core Version:    0.7.0.1
 */