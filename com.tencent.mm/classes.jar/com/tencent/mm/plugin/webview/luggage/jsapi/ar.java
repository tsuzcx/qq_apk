package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.br.d;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.webview.luggage.r;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public class ar
  extends ax<com.tencent.mm.plugin.webview.luggage.e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<com.tencent.mm.plugin.webview.luggage.e>.a parama)
  {
    y.i("MicroMsg.JsApiShareTimeLine", "invoke");
    MMActivity localMMActivity = (MMActivity)((com.tencent.mm.plugin.webview.luggage.e)parama.big).mContext;
    if ((localMMActivity == null) || (localMMActivity.isFinishing()))
    {
      y.w("MicroMsg.JsApiShareTimeLine", "activity is null or finish");
      return;
    }
    Object localObject1 = parama.bih.bhk;
    String str1 = ((JSONObject)localObject1).optString("link");
    if (bk.bl(str1))
    {
      y.e("MicroMsg.JsApiShareTimeLine", "link is null");
      parama.a("invalid_params", null);
      return;
    }
    String str2 = ((JSONObject)localObject1).optString("desc");
    if (str2 != null)
    {
      if (!str2.startsWith("http://")) {
        break label511;
      }
      str2.substring(7);
    }
    for (;;)
    {
      str2 = ((JSONObject)localObject1).optString("appid");
      Object localObject2 = ((JSONObject)localObject1).optString("img_width");
      String str7 = ((JSONObject)localObject1).optString("img_height");
      y.i("MicroMsg.JsApiShareTimeLine", "doTimeline, rawUrl:[%s], shareUrl:[%s]", new Object[] { str1, str1 });
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
        label230:
        break label230;
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Ksnsupload_width", i);
      ((Intent)localObject2).putExtra("Ksnsupload_height", i);
      ((Intent)localObject2).putExtra("Ksnsupload_link", str1);
      ((Intent)localObject2).putExtra("Ksnsupload_title", str4);
      ((Intent)localObject2).putExtra("Ksnsupload_imgurl", str5);
      if (s.hl(str6))
      {
        ((Intent)localObject2).putExtra("src_username", str6);
        ((Intent)localObject2).putExtra("src_displayname", (String)localObject1);
      }
      ((Intent)localObject2).putExtra("Ksnsupload_source", 1);
      ((Intent)localObject2).putExtra("Ksnsupload_type", 1);
      if ((!bk.bl(str3)) && (str3.equals("music"))) {
        ((Intent)localObject2).putExtra("ksnsis_music", true);
      }
      if ((!bk.bl(str3)) && (str3.equals("video"))) {
        ((Intent)localObject2).putExtra("ksnsis_video", true);
      }
      if ((str2 != null) && (str2.length() > 0)) {
        ((Intent)localObject2).putExtra("Ksnsupload_appid", str2);
      }
      ((Intent)localObject2).putExtra("ShareUrlOriginal", str1);
      ((Intent)localObject2).putExtra("ShareUrlOpen", ((com.tencent.mm.plugin.webview.luggage.e)parama.big).getUrl());
      ((Intent)localObject2).putExtra("JsAppId", ((com.tencent.mm.plugin.webview.luggage.e)parama.big).rbS.getAppId());
      ((Intent)localObject2).putExtra("need_result", true);
      y.i("MicroMsg.JsApiShareTimeLine", "doTimeline, start activity");
      localMMActivity.gJb = new ar.1(this, parama, localMMActivity);
      d.a(localMMActivity, "sns", ".ui.SnsUploadUI", (Intent)localObject2, hashCode() & 0xFFFF, false);
      return;
      label511:
      if (str2.startsWith("https://")) {
        str2.substring(8);
      }
    }
  }
  
  public final String name()
  {
    return "shareTimeline";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ar
 * JD-Core Version:    0.7.0.1
 */