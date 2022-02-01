package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.vfs.u;
import org.json.JSONObject;

public class as
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    AppMethodBeat.i(78598);
    Log.i("MicroMsg.GameJsApiPreviewVideo", "invoke");
    if (Util.isNullOrNil(paramb.crh.cqn.optString("localId")))
    {
      Log.i("MicroMsg.GameJsApiPreviewVideo", "data is invalid");
      paramb.a("invalid_data", null);
      AppMethodBeat.o(78598);
      return;
    }
    String str = paramb.crh.cqn.optString("localId");
    Log.i("MicroMsg.GameJsApiPreviewVideo", "localId:%s", new Object[] { str });
    final MMActivity localMMActivity = (MMActivity)((g)paramb.crg).mContext;
    localMMActivity.mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(78597);
        if (paramAnonymousInt1 == (as.this.hashCode() & 0xFFFF)) {
          switch (paramAnonymousInt2)
          {
          default: 
            paramb.a("fail", null);
          }
        }
        for (;;)
        {
          localMMActivity.mmSetOnActivityResultCallback(null);
          AppMethodBeat.o(78597);
          return;
          paramb.a("cancel", null);
          continue;
          paramb.a("", null);
        }
      }
    });
    Intent localIntent = new Intent();
    if (Util.nullAsNil(str).trim().startsWith("weixin://bgmixid/"))
    {
      localIntent.putExtra("game_bg_mix_fake_local_id", Util.nullAsNil(str).trim());
      com.tencent.mm.by.c.b(localMMActivity, "game", ".media.background.GameFakeVideoUI", localIntent, hashCode() & 0xFFFF);
      AppMethodBeat.o(78598);
      return;
    }
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.luggage.c.c.bkw(str);
    if ((localWebViewJSSDKFileItem == null) || (TextUtils.isEmpty(localWebViewJSSDKFileItem.nVa)) || (!u.agG(localWebViewJSSDKFileItem.nVa)))
    {
      Log.e("MicroMsg.GameJsApiPreviewVideo", "the item is null or the File item not exist for localId: %s", new Object[] { str });
      paramb.a("fail", null);
      AppMethodBeat.o(78598);
      return;
    }
    localIntent.putExtra("key_video_path", localWebViewJSSDKFileItem.nVa);
    com.tencent.mm.by.c.b(localMMActivity, "card", ".ui.CardGiftVideoUI", localIntent, hashCode() & 0xFFFF);
    AppMethodBeat.o(78598);
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "previewVideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.as
 * JD-Core Version:    0.7.0.1
 */