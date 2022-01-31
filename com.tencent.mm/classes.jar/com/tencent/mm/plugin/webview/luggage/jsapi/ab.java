package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jf;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class ab
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(6325);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.JsApiLaunch3RdApp", "invokeInMM");
    Object localObject1 = com.tencent.mm.plugin.webview.luggage.c.b.BJ(paramString);
    if (localObject1 == null)
    {
      parama.c("invalid_data", null);
      AppMethodBeat.o(6325);
      return;
    }
    int i = ((JSONObject)localObject1).optInt("type");
    paramString = ((JSONObject)localObject1).optString("appID");
    Object localObject2;
    if (i == 0)
    {
      localObject1 = ((JSONObject)localObject1).optString("extInfo");
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.JsApiLaunch3RdApp", "appid:[%s], extinfo:[%s]", new Object[] { paramString, localObject1 });
      if (bo.isNullOrNil(paramString))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.JsApiLaunch3RdApp", "appid is null or nil");
        parama.c("fail", null);
        AppMethodBeat.o(6325);
        return;
      }
      if (!com.tencent.mm.plugin.webview.a.a.gmP.u(ah.getContext(), paramString))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.JsApiLaunch3RdApp", "app is not installed, appid:[%s]", new Object[] { paramString });
        parama.c("fail", null);
        AppMethodBeat.o(6325);
        return;
      }
      localObject2 = new WXAppExtendObject();
      ((WXAppExtendObject)localObject2).extInfo = ((String)localObject1);
      localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
      ((WXMediaMessage)localObject2).sdkVer = 620954624;
      ((WXMediaMessage)localObject2).messageExt = ((String)localObject1);
      localObject1 = new jf();
      ((jf)localObject1).cyD.cyF = ((WXMediaMessage)localObject2);
      ((jf)localObject1).cyD.appId = paramString;
      ((jf)localObject1).cyD.context = paramContext;
      ((jf)localObject1).cyD.cyG = new ab.1(this, parama);
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      AppMethodBeat.o(6325);
      return;
    }
    if (i == 1)
    {
      String str = ((JSONObject)localObject1).optString("signature");
      localObject2 = ((JSONObject)localObject1).optString("packageName");
      paramString = ((JSONObject)localObject1).optString("param");
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[] { str, localObject2, paramString });
      if ((bo.isNullOrNil(str)) || (bo.isNullOrNil((String)localObject2)))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp invalid_args");
        parama.c("invalid_args", null);
        AppMethodBeat.o(6325);
        return;
      }
      if (!p.u(paramContext, (String)localObject2))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp not_install");
        parama.c("not_install", null);
        AppMethodBeat.o(6325);
        return;
      }
      Object localObject3 = p.bv(paramContext, (String)localObject2);
      if ((localObject3 != null) && (localObject3[0] != null))
      {
        localObject3 = com.tencent.mm.a.g.w(localObject3[0].toByteArray());
        if ((localObject3 != null) && (((String)localObject3).equalsIgnoreCase(str)))
        {
          str = ((JSONObject)localObject1).optString("currentUrl");
          localObject1 = ((JSONObject)localObject1).optString("preVerifyAppId");
          try
          {
            localObject2 = ah.getContext().getPackageManager().getLaunchIntentForPackage((String)localObject2);
            if (localObject2 != null)
            {
              localObject3 = new Bundle();
              p.j((Bundle)localObject3, paramString);
              ((Intent)localObject2).putExtras((Bundle)localObject3);
              ((Intent)localObject2).addFlags(268435456);
              paramString = new Bundle();
              paramString.putString("current_page_url", str);
              paramString.putString("current_page_appid", (String)localObject1);
              com.tencent.mm.pluginsdk.model.app.g.a(paramContext, (Intent)localObject2, null, new ab.2(this, parama), paramString);
              AppMethodBeat.o(6325);
              return;
            }
          }
          catch (Exception paramContext)
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp getLaunchIntentForPackage, %s", new Object[] { paramContext.getMessage() });
            parama.c("fail", null);
            AppMethodBeat.o(6325);
            return;
          }
        }
      }
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp signature_mismatch");
      parama.c("signature_mismatch", null);
      AppMethodBeat.o(6325);
      return;
    }
    parama.c("invalid_type", null);
    AppMethodBeat.o(6325);
  }
  
  public final void b(com.tencent.luggage.d.a<e>.a parama) {}
  
  public final int bjL()
  {
    return 2;
  }
  
  public final String name()
  {
    return "launch3rdApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ab
 * JD-Core Version:    0.7.0.1
 */