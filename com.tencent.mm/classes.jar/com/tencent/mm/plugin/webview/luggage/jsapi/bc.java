package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.webview.luggage.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public class bc
  extends bi<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    AppMethodBeat.i(6383);
    ab.i("MicroMsg.JsApiShareTimeLine", "invoke");
    MMActivity localMMActivity = (MMActivity)((com.tencent.mm.plugin.webview.luggage.e)parama.byE).mContext;
    if ((localMMActivity == null) || (localMMActivity.isFinishing()))
    {
      ab.w("MicroMsg.JsApiShareTimeLine", "activity is null or finish");
      AppMethodBeat.o(6383);
      return;
    }
    Object localObject1 = parama.byF.bxK;
    String str1 = ((JSONObject)localObject1).optString("link");
    if (bo.isNullOrNil(str1))
    {
      ab.e("MicroMsg.JsApiShareTimeLine", "link is null");
      parama.a("invalid_params", null);
      AppMethodBeat.o(6383);
      return;
    }
    String str2 = ((JSONObject)localObject1).optString("desc");
    if (str2 != null)
    {
      if (!str2.startsWith("http://")) {
        break label535;
      }
      str2.substring(7);
    }
    for (;;)
    {
      str2 = ((JSONObject)localObject1).optString("appid");
      Object localObject2 = ((JSONObject)localObject1).optString("img_width");
      String str7 = ((JSONObject)localObject1).optString("img_height");
      ab.i("MicroMsg.JsApiShareTimeLine", "doTimeline, rawUrl:[%s], shareUrl:[%s]", new Object[] { str1, str1 });
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
        label248:
        break label248;
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Ksnsupload_width", i);
      ((Intent)localObject2).putExtra("Ksnsupload_height", i);
      ((Intent)localObject2).putExtra("Ksnsupload_link", str1);
      ((Intent)localObject2).putExtra("Ksnsupload_title", str4);
      ((Intent)localObject2).putExtra("Ksnsupload_imgurl", str5);
      if (t.nU(str6))
      {
        ((Intent)localObject2).putExtra("src_username", str6);
        ((Intent)localObject2).putExtra("src_displayname", (String)localObject1);
      }
      ((Intent)localObject2).putExtra("Ksnsupload_source", 1);
      ((Intent)localObject2).putExtra("Ksnsupload_type", 1);
      if ((!bo.isNullOrNil(str3)) && (str3.equals("music"))) {
        ((Intent)localObject2).putExtra("ksnsis_music", true);
      }
      if ((!bo.isNullOrNil(str3)) && (str3.equals("video"))) {
        ((Intent)localObject2).putExtra("ksnsis_video", true);
      }
      if ((str2 != null) && (str2.length() > 0)) {
        ((Intent)localObject2).putExtra("Ksnsupload_appid", str2);
      }
      ((Intent)localObject2).putExtra("ShareUrlOriginal", str1);
      ((Intent)localObject2).putExtra("ShareUrlOpen", ((com.tencent.mm.plugin.webview.luggage.e)parama.byE).getUrl());
      ((Intent)localObject2).putExtra("JsAppId", ((com.tencent.mm.plugin.webview.luggage.e)parama.byE).uRD.getAppId());
      ((Intent)localObject2).putExtra("need_result", true);
      ab.i("MicroMsg.JsApiShareTimeLine", "doTimeline, start activity");
      localMMActivity.mmSetOnActivityResultCallback(new bc.1(this, parama, localMMActivity));
      d.a(localMMActivity, "sns", ".ui.SnsUploadUI", (Intent)localObject2, hashCode() & 0xFFFF, false);
      AppMethodBeat.o(6383);
      return;
      label535:
      if (str2.startsWith("https://")) {
        str2.substring(8);
      }
    }
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "shareTimeline";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bc
 * JD-Core Version:    0.7.0.1
 */