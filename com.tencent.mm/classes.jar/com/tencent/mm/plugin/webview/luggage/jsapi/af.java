package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class af
  extends br<com.tencent.mm.plugin.webview.luggage.g>
{
  public final void a(Context paramContext, String paramString, final bq.a parama)
  {
    AppMethodBeat.i(78573);
    ad.i("MicroMsg.JsApiLaunch3RdApp", "invokeInMM");
    Object localObject1 = com.tencent.mm.plugin.webview.luggage.c.b.Pe(paramString);
    if (localObject1 == null)
    {
      parama.f("invalid_data", null);
      AppMethodBeat.o(78573);
      return;
    }
    int i = ((JSONObject)localObject1).optInt("type");
    paramString = ((JSONObject)localObject1).optString("appID");
    Object localObject2;
    if (i == 0)
    {
      localObject1 = ((JSONObject)localObject1).optString("extInfo");
      ad.i("MicroMsg.JsApiLaunch3RdApp", "appid:[%s], extinfo:[%s]", new Object[] { paramString, localObject1 });
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.JsApiLaunch3RdApp", "appid is null or nil");
        parama.f("fail", null);
        AppMethodBeat.o(78573);
        return;
      }
      if (!com.tencent.mm.plugin.webview.a.a.iRH.s(aj.getContext(), paramString))
      {
        ad.e("MicroMsg.JsApiLaunch3RdApp", "app is not installed, appid:[%s]", new Object[] { paramString });
        parama.f("fail", null);
        AppMethodBeat.o(78573);
        return;
      }
      localObject2 = new WXAppExtendObject();
      ((WXAppExtendObject)localObject2).extInfo = ((String)localObject1);
      localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
      ((WXMediaMessage)localObject2).sdkVer = 637928960;
      ((WXMediaMessage)localObject2).messageExt = ((String)localObject1);
      localObject1 = new ky();
      ((ky)localObject1).dyb.dtZ = ((WXMediaMessage)localObject2);
      ((ky)localObject1).dyb.appId = paramString;
      ((ky)localObject1).dyb.context = paramContext;
      ((ky)localObject1).dyb.dyd = new al()
      {
        public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(207907);
          parama.f(null, null);
          AppMethodBeat.o(207907);
        }
      };
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      AppMethodBeat.o(78573);
      return;
    }
    if (i == 1)
    {
      String str = ((JSONObject)localObject1).optString("signature");
      localObject2 = ((JSONObject)localObject1).optString("packageName");
      paramString = ((JSONObject)localObject1).optString("param");
      ad.i("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[] { str, localObject2, paramString });
      if ((bt.isNullOrNil(str)) || (bt.isNullOrNil((String)localObject2)))
      {
        ad.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp invalid_args");
        parama.f("invalid_args", null);
        AppMethodBeat.o(78573);
        return;
      }
      if (!q.s(paramContext, (String)localObject2))
      {
        ad.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp not_install");
        parama.f("not_install", null);
        AppMethodBeat.o(78573);
        return;
      }
      Object localObject3 = q.bO(paramContext, (String)localObject2);
      if ((localObject3 != null) && (localObject3[0] != null))
      {
        localObject3 = com.tencent.mm.b.g.getMessageDigest(localObject3[0].toByteArray());
        if ((localObject3 != null) && (((String)localObject3).equalsIgnoreCase(str)))
        {
          str = ((JSONObject)localObject1).optString("currentUrl");
          localObject1 = ((JSONObject)localObject1).optString("preVerifyAppId");
          try
          {
            localObject2 = aj.getContext().getPackageManager().getLaunchIntentForPackage((String)localObject2);
            if (localObject2 != null)
            {
              localObject3 = new Bundle();
              q.j((Bundle)localObject3, paramString);
              ((Intent)localObject2).putExtras((Bundle)localObject3);
              ((Intent)localObject2).addFlags(268435456);
              paramString = new Bundle();
              paramString.putString("current_page_url", str);
              paramString.putString("current_page_appid", (String)localObject1);
              h.a(paramContext, (Intent)localObject2, null, new al()
              {
                public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
                {
                  AppMethodBeat.i(207908);
                  parama.f(null, null);
                  AppMethodBeat.o(207908);
                }
              }, paramString);
              AppMethodBeat.o(78573);
              return;
            }
          }
          catch (Exception paramContext)
          {
            ad.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp getLaunchIntentForPackage, %s", new Object[] { paramContext.getMessage() });
            parama.f("fail", null);
            AppMethodBeat.o(78573);
            return;
          }
        }
      }
      ad.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp signature_mismatch");
      parama.f("signature_mismatch", null);
      AppMethodBeat.o(78573);
      return;
    }
    parama.f("invalid_type", null);
    AppMethodBeat.o(78573);
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int ccO()
  {
    return 2;
  }
  
  public final String name()
  {
    return "launch3rdApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.af
 * JD-Core Version:    0.7.0.1
 */