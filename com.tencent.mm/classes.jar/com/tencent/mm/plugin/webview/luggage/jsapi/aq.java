package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.vfs.i;
import org.json.JSONObject;

public class aq
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a<f>.a parama)
  {
    AppMethodBeat.i(78598);
    ac.i("MicroMsg.GameJsApiPreviewVideo", "invoke");
    if (bs.isNullOrNil(parama.bWS.bVY.optString("localId")))
    {
      ac.i("MicroMsg.GameJsApiPreviewVideo", "data is invalid");
      parama.a("invalid_data", null);
      AppMethodBeat.o(78598);
      return;
    }
    String str = parama.bWS.bVY.optString("localId");
    ac.i("MicroMsg.GameJsApiPreviewVideo", "localId:%s", new Object[] { str });
    final MMActivity localMMActivity = (MMActivity)((f)parama.bWR).mContext;
    localMMActivity.mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(78597);
        if (paramAnonymousInt1 == (aq.this.hashCode() & 0xFFFF)) {
          switch (paramAnonymousInt2)
          {
          default: 
            parama.a("fail", null);
          }
        }
        for (;;)
        {
          localMMActivity.mmSetOnActivityResultCallback(null);
          AppMethodBeat.o(78597);
          return;
          parama.a("cancel", null);
          continue;
          parama.a("", null);
        }
      }
    });
    Intent localIntent = new Intent();
    if (bs.nullAsNil(str).trim().startsWith("weixin://bgmixid/"))
    {
      localIntent.putExtra("game_bg_mix_fake_local_id", bs.nullAsNil(str).trim());
      d.b(localMMActivity, "game", ".media.background.GameFakeVideoUI", localIntent, hashCode() & 0xFFFF);
      AppMethodBeat.o(78598);
      return;
    }
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = b.aBI(str);
    if ((localWebViewJSSDKFileItem == null) || (TextUtils.isEmpty(localWebViewJSSDKFileItem.jAH)) || (!i.eA(localWebViewJSSDKFileItem.jAH)))
    {
      ac.e("MicroMsg.GameJsApiPreviewVideo", "the item is null or the File item not exist for localId: %s", new Object[] { str });
      parama.a("fail", null);
      AppMethodBeat.o(78598);
      return;
    }
    localIntent.putExtra("key_video_path", localWebViewJSSDKFileItem.jAH);
    d.b(localMMActivity, "card", ".ui.CardGiftVideoUI", localIntent, hashCode() & 0xFFFF);
    AppMethodBeat.o(78598);
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "previewVideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aq
 * JD-Core Version:    0.7.0.1
 */