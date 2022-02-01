package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONObject;

public class bq
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    AppMethodBeat.i(78635);
    Log.i("MicroMsg.JsApiShareTimeLine", "invoke");
    final MMActivity localMMActivity = (MMActivity)((g)paramb.eiY).mContext;
    if ((localMMActivity == null) || (localMMActivity.isFinishing()))
    {
      Log.w("MicroMsg.JsApiShareTimeLine", "activity is null or finish");
      AppMethodBeat.o(78635);
      return;
    }
    Object localObject1 = paramb.eiZ.eif;
    String str1 = ((JSONObject)localObject1).optString("link");
    if (Util.isNullOrNil(str1))
    {
      Log.e("MicroMsg.JsApiShareTimeLine", "link is null");
      paramb.a("invalid_params", null);
      AppMethodBeat.o(78635);
      return;
    }
    String str2 = ((JSONObject)localObject1).optString("desc");
    if (str2 != null)
    {
      if (!str2.startsWith("http://")) {
        break label531;
      }
      str2.substring(7);
    }
    for (;;)
    {
      str2 = ((JSONObject)localObject1).optString("appid");
      Object localObject2 = ((JSONObject)localObject1).optString("img_width");
      String str7 = ((JSONObject)localObject1).optString("img_height");
      Log.i("MicroMsg.JsApiShareTimeLine", "doTimeline, rawUrl:[%s], shareUrl:[%s]", new Object[] { str1, str1 });
      String str3 = ((JSONObject)localObject1).optString("type");
      String str4 = ((JSONObject)localObject1).optString("title");
      String str5 = ((JSONObject)localObject1).optString("img_url");
      String str6 = ((JSONObject)localObject1).optString("src_username");
      localObject1 = ((JSONObject)localObject1).optString("src_displayname");
      int i = -1;
      try
      {
        int j = Integer.valueOf((String)localObject2).intValue();
        i = j;
        Integer.valueOf(str7);
        i = j;
      }
      catch (Exception localException)
      {
        label245:
        break label245;
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Ksnsupload_width", i);
      ((Intent)localObject2).putExtra("Ksnsupload_height", i);
      ((Intent)localObject2).putExtra("Ksnsupload_link", str1);
      ((Intent)localObject2).putExtra("Ksnsupload_title", str4);
      ((Intent)localObject2).putExtra("Ksnsupload_imgurl", str5);
      if (ab.IS(str6))
      {
        ((Intent)localObject2).putExtra("src_username", str6);
        ((Intent)localObject2).putExtra("src_displayname", (String)localObject1);
      }
      ((Intent)localObject2).putExtra("Ksnsupload_source", 1);
      ((Intent)localObject2).putExtra("Ksnsupload_type", 1);
      if ((!Util.isNullOrNil(str3)) && (str3.equals("music"))) {
        ((Intent)localObject2).putExtra("ksnsis_music", true);
      }
      if ((!Util.isNullOrNil(str3)) && (str3.equals("video"))) {
        ((Intent)localObject2).putExtra("ksnsis_video", true);
      }
      if ((str2 != null) && (str2.length() > 0)) {
        ((Intent)localObject2).putExtra("Ksnsupload_appid", str2);
      }
      ((Intent)localObject2).putExtra("ShareUrlOriginal", str1);
      ((Intent)localObject2).putExtra("ShareUrlOpen", ((g)paramb.eiY).getUrl());
      ((Intent)localObject2).putExtra("JsAppId", ((g)paramb.eiY).WGh.getAppId());
      ((Intent)localObject2).putExtra("need_result", true);
      Log.i("MicroMsg.JsApiShareTimeLine", "doTimeline, start activity");
      localMMActivity.mmSetOnActivityResultCallback(new MMActivity.a()
      {
        public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(78634);
          if (paramAnonymousInt1 == (bq.this.hashCode() & 0xFFFF))
          {
            if (paramAnonymousInt2 != -1) {
              break label48;
            }
            paramb.a("", null);
          }
          for (;;)
          {
            localMMActivity.mmSetOnActivityResultCallback(null);
            AppMethodBeat.o(78634);
            return;
            label48:
            paramb.a("cancel", null);
          }
        }
      });
      c.a(localMMActivity, "sns", ".ui.SnsUploadUI", (Intent)localObject2, hashCode() & 0xFFFF, false);
      AppMethodBeat.o(78635);
      return;
      label531:
      if (str2.startsWith("https://")) {
        str2.substring(8);
      }
    }
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "shareTimeline";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bq
 * JD-Core Version:    0.7.0.1
 */