package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public class an
  extends bi<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    AppMethodBeat.i(6348);
    ab.i("MicroMsg.GameJsApiPreviewVideo", "invoke");
    if (bo.isNullOrNil(parama.byF.bxK.optString("localId")))
    {
      ab.i("MicroMsg.GameJsApiPreviewVideo", "data is invalid");
      parama.a("invalid_data", null);
      AppMethodBeat.o(6348);
      return;
    }
    Object localObject2 = parama.byF.bxK.optString("localId");
    Object localObject1 = b.agY((String)localObject2);
    if ((localObject1 == null) || (TextUtils.isEmpty(((WebViewJSSDKFileItem)localObject1).hgj)) || (!com.tencent.mm.a.e.cN(((WebViewJSSDKFileItem)localObject1).hgj)))
    {
      ab.e("MicroMsg.GameJsApiPreviewVideo", "the item is null or the File item not exist for localId: %s", new Object[] { localObject2 });
      parama.a("fail", null);
      AppMethodBeat.o(6348);
      return;
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("key_video_path", ((WebViewJSSDKFileItem)localObject1).hgj);
    localObject1 = (MMActivity)((com.tencent.mm.plugin.webview.luggage.e)parama.byE).mContext;
    ((MMActivity)localObject1).mmSetOnActivityResultCallback(new an.1(this, parama, (MMActivity)localObject1));
    d.b((Context)localObject1, "card", ".ui.CardGiftVideoUI", (Intent)localObject2, hashCode() & 0xFFFF);
    AppMethodBeat.o(6348);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "previewVideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.an
 * JD-Core Version:    0.7.0.1
 */