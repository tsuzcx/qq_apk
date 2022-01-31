package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public static void a(e parame, Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", parame.value);
    com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
  }
  
  public static void a(e parame, Context paramContext, String paramString)
  {
    Object localObject1 = null;
    if (bk.bl(parame.value))
    {
      y.d("MicroMsg.NewBizInfoUtil", "jumpToWeApp serviceInfo.id:%s value is null", new Object[] { parame.id });
      return;
    }
    y.d("MicroMsg.NewBizInfoUtil", "jumpToWeApp value:%s", new Object[] { parame.value });
    try
    {
      Object localObject2 = new JSONObject(parame.value);
      parame = f.kX(paramString);
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1102;
      localAppBrandStatObject.bFv = paramString;
      paramString = (com.tencent.mm.plugin.appbrand.r.d)g.r(com.tencent.mm.plugin.appbrand.r.d.class);
      String str = ((JSONObject)localObject2).optString("userName");
      localObject2 = ((JSONObject)localObject2).optString("pagePath");
      if (parame == null) {}
      for (parame = localObject1;; parame = parame.field_appId)
      {
        paramString.a(paramContext, str, null, 0, 0, (String)localObject2, localAppBrandStatObject, parame);
        return;
      }
      return;
    }
    catch (JSONException parame) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.c
 * JD-Core Version:    0.7.0.1
 */