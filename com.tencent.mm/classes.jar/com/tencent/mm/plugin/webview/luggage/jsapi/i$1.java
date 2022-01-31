package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

final class i$1
  implements MMActivity.a
{
  i$1(a.a parama, MMActivity paramMMActivity) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(6301);
    Object localObject1;
    Object localObject2;
    if (paramInt1 == 45)
    {
      switch (paramInt2)
      {
      default: 
        this.njN.a("fail", null);
      }
      for (;;)
      {
        this.val$activity.mmSetOnActivityResultCallback(null);
        AppMethodBeat.o(6301);
        return;
        this.njN.a("cancel", null);
        continue;
        localObject1 = paramIntent.getStringExtra("key_pick_local_media_local_id");
        paramIntent = paramIntent.getStringExtra("key_pick_local_media_thumb_local_id");
        ab.i("MicroMsg.JsApiChooseVideo", "localId:%s", new Object[] { localObject1 });
        ab.i("MicroMsg.JsApiChooseVideo", "thumbLocalId:%s", new Object[] { paramIntent });
        if (bo.isNullOrNil((String)localObject1)) {
          break;
        }
        localObject2 = b.agY((String)localObject1);
        if ((localObject2 != null) && ((localObject2 instanceof WebViewJSSDKVideoItem)))
        {
          localObject2 = (WebViewJSSDKVideoItem)localObject2;
          HashMap localHashMap = new HashMap();
          localHashMap.put("localId", localObject1);
          localHashMap.put("duration", Integer.valueOf(((WebViewJSSDKVideoItem)localObject2).duration));
          localHashMap.put("height", Integer.valueOf(((WebViewJSSDKVideoItem)localObject2).height));
          localHashMap.put("size", Integer.valueOf(((WebViewJSSDKVideoItem)localObject2).size));
          localHashMap.put("width", Integer.valueOf(((WebViewJSSDKVideoItem)localObject2).width));
          localHashMap.put("thumbLocalId", paramIntent);
          this.njN.c("", localHashMap);
        }
        else
        {
          this.njN.a("fail", null);
        }
      }
    }
    if (paramInt1 == 32) {
      switch (paramInt2)
      {
      default: 
        this.njN.a("fail", null);
      }
    }
    for (;;)
    {
      this.val$activity.mmSetOnActivityResultCallback(null);
      AppMethodBeat.o(6301);
      return;
      this.njN.a("cancel", null);
      continue;
      paramIntent = paramIntent.getStringExtra("key_pick_local_media_local_id");
      if (bo.isNullOrNil(paramIntent)) {
        break;
      }
      localObject1 = b.agY(paramIntent);
      if ((localObject1 != null) && ((localObject1 instanceof WebViewJSSDKVideoItem)))
      {
        localObject1 = (WebViewJSSDKVideoItem)localObject1;
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("localId", paramIntent);
        ((HashMap)localObject2).put("duration", Integer.valueOf(((WebViewJSSDKVideoItem)localObject1).duration));
        ((HashMap)localObject2).put("height", Integer.valueOf(((WebViewJSSDKVideoItem)localObject1).height));
        ((HashMap)localObject2).put("size", Integer.valueOf(((WebViewJSSDKVideoItem)localObject1).size));
        ((HashMap)localObject2).put("width", Integer.valueOf(((WebViewJSSDKVideoItem)localObject1).width));
        this.njN.c("", (Map)localObject2);
      }
      else
      {
        this.njN.a("fail", null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.i.1
 * JD-Core Version:    0.7.0.1
 */