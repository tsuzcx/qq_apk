package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public class af
  extends br<com.tencent.mm.plugin.webview.luggage.g>
{
  public final void a(Context paramContext, String paramString, final bq.a parama)
  {
    AppMethodBeat.i(78573);
    ae.i("MicroMsg.JsApiLaunch3RdApp", "invokeInMM");
    Object localObject1 = com.tencent.mm.plugin.webview.luggage.c.b.PM(paramString);
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
      ae.i("MicroMsg.JsApiLaunch3RdApp", "appid:[%s], extinfo:[%s]", new Object[] { paramString, localObject1 });
      if (bu.isNullOrNil(paramString))
      {
        ae.e("MicroMsg.JsApiLaunch3RdApp", "appid is null or nil");
        parama.f("fail", null);
        AppMethodBeat.o(78573);
        return;
      }
      if (!com.tencent.mm.plugin.webview.a.a.iUA.s(ak.getContext(), paramString))
      {
        ae.e("MicroMsg.JsApiLaunch3RdApp", "app is not installed, appid:[%s]", new Object[] { paramString });
        parama.f("fail", null);
        AppMethodBeat.o(78573);
        return;
      }
      localObject2 = new WXAppExtendObject();
      ((WXAppExtendObject)localObject2).extInfo = ((String)localObject1);
      localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
      ((WXMediaMessage)localObject2).sdkVer = 637928960;
      ((WXMediaMessage)localObject2).messageExt = ((String)localObject1);
      localObject1 = new kz();
      ((kz)localObject1).dzg.dve = ((WXMediaMessage)localObject2);
      ((kz)localObject1).dzg.appId = paramString;
      ((kz)localObject1).dzg.context = paramContext;
      ((kz)localObject1).dzg.dzi = new al()
      {
        public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(198087);
          parama.f(null, null);
          AppMethodBeat.o(198087);
        }
      };
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      AppMethodBeat.o(78573);
      return;
    }
    if (i == 1)
    {
      String str = ((JSONObject)localObject1).optString("signature");
      localObject2 = ((JSONObject)localObject1).optString("packageName");
      paramString = ((JSONObject)localObject1).optString("param");
      ae.i("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[] { str, localObject2, paramString });
      if ((bu.isNullOrNil(str)) || (bu.isNullOrNil((String)localObject2)))
      {
        ae.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp invalid_args");
        parama.f("invalid_args", null);
        AppMethodBeat.o(78573);
        return;
      }
      if (!q.s(paramContext, (String)localObject2))
      {
        ae.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp not_install");
        parama.f("not_install", null);
        AppMethodBeat.o(78573);
        return;
      }
      Object localObject3 = q.bP(paramContext, (String)localObject2);
      if ((localObject3 != null) && (localObject3[0] != null))
      {
        localObject3 = com.tencent.mm.b.g.getMessageDigest(localObject3[0].toByteArray());
        if ((localObject3 != null) && (((String)localObject3).equalsIgnoreCase(str)))
        {
          str = ((JSONObject)localObject1).optString("currentUrl");
          localObject1 = ((JSONObject)localObject1).optString("preVerifyAppId");
          try
          {
            localObject2 = ak.getContext().getPackageManager().getLaunchIntentForPackage((String)localObject2);
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
                  AppMethodBeat.i(198088);
                  parama.f(null, null);
                  AppMethodBeat.o(198088);
                }
              }, paramString);
              AppMethodBeat.o(78573);
              return;
            }
          }
          catch (Exception paramContext)
          {
            ae.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp getLaunchIntentForPackage, %s", new Object[] { paramContext.getMessage() });
            parama.f("fail", null);
            AppMethodBeat.o(78573);
            return;
          }
        }
      }
      ae.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp signature_mismatch");
      parama.f("signature_mismatch", null);
      AppMethodBeat.o(78573);
      return;
    }
    parama.f("invalid_type", null);
    AppMethodBeat.o(78573);
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int ced()
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