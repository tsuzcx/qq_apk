package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.nm;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class ah
  extends bw<com.tencent.mm.plugin.webview.luggage.g>
{
  public final void a(Context paramContext, String paramString, final bv.a parama)
  {
    AppMethodBeat.i(78573);
    Log.i("MicroMsg.JsApiLaunch3RdApp", "invokeInMM");
    Object localObject1 = c.ZL(paramString);
    if (localObject1 == null)
    {
      parama.j("invalid_data", null);
      AppMethodBeat.o(78573);
      return;
    }
    int i = ((JSONObject)localObject1).optInt("type");
    paramString = ((JSONObject)localObject1).optString("appID");
    Object localObject2;
    if (i == 0)
    {
      localObject1 = ((JSONObject)localObject1).optString("extInfo");
      Log.i("MicroMsg.JsApiLaunch3RdApp", "appid:[%s], extinfo:[%s]", new Object[] { paramString, localObject1 });
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.JsApiLaunch3RdApp", "appid is null or nil");
        parama.j("fail", null);
        AppMethodBeat.o(78573);
        return;
      }
      if (!a.pFo.y(MMApplicationContext.getContext(), paramString))
      {
        Log.e("MicroMsg.JsApiLaunch3RdApp", "app is not installed, appid:[%s]", new Object[] { paramString });
        parama.j("fail", null);
        AppMethodBeat.o(78573);
        return;
      }
      localObject2 = new WXAppExtendObject();
      ((WXAppExtendObject)localObject2).extInfo = ((String)localObject1);
      localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
      ((WXMediaMessage)localObject2).sdkVer = 638058496;
      ((WXMediaMessage)localObject2).messageExt = ((String)localObject1);
      localObject1 = new nm();
      ((nm)localObject1).hPP.hzF = ((WXMediaMessage)localObject2);
      ((nm)localObject1).hPP.appId = paramString;
      ((nm)localObject1).hPP.context = paramContext;
      ((nm)localObject1).hPP.hPR = new ap()
      {
        public final void onLaunchApp(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(296049);
          parama.j(null, null);
          AppMethodBeat.o(296049);
        }
      };
      ((nm)localObject1).publish();
      AppMethodBeat.o(78573);
      return;
    }
    if (i == 1)
    {
      String str = ((JSONObject)localObject1).optString("signature");
      localObject2 = ((JSONObject)localObject1).optString("packageName");
      paramString = ((JSONObject)localObject1).optString("param");
      Log.i("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[] { str, localObject2, paramString });
      if ((Util.isNullOrNil(str)) || (Util.isNullOrNil((String)localObject2)))
      {
        Log.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp invalid_args");
        parama.j("invalid_args", null);
        AppMethodBeat.o(78573);
        return;
      }
      if (!u.y(paramContext, (String)localObject2))
      {
        Log.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp not_install");
        parama.j("not_install", null);
        AppMethodBeat.o(78573);
        return;
      }
      Object localObject3 = u.cG(paramContext, (String)localObject2);
      if ((localObject3 != null) && (localObject3[0] != null))
      {
        localObject3 = com.tencent.mm.b.g.getMessageDigest(localObject3[0].toByteArray());
        if ((localObject3 != null) && (((String)localObject3).equalsIgnoreCase(str)))
        {
          str = ((JSONObject)localObject1).optString("currentUrl");
          localObject1 = ((JSONObject)localObject1).optString("preVerifyAppId");
          try
          {
            localObject2 = MMApplicationContext.getContext().getPackageManager().getLaunchIntentForPackage((String)localObject2);
            if (localObject2 != null)
            {
              localObject3 = new Bundle();
              u.l((Bundle)localObject3, paramString);
              ((Intent)localObject2).putExtras((Bundle)localObject3);
              ((Intent)localObject2).addFlags(268435456);
              paramString = new Bundle();
              paramString.putString("current_page_url", str);
              paramString.putString("current_page_appid", (String)localObject1);
              h.a(paramContext, (Intent)localObject2, null, new ap()
              {
                public final void onLaunchApp(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
                {
                  AppMethodBeat.i(296051);
                  parama.j(null, null);
                  AppMethodBeat.o(296051);
                }
              }, paramString);
              AppMethodBeat.o(78573);
              return;
            }
          }
          catch (Exception paramContext)
          {
            Log.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp getLaunchIntentForPackage, %s", new Object[] { paramContext.getMessage() });
            parama.j("fail", null);
            AppMethodBeat.o(78573);
            return;
          }
        }
      }
      Log.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp signature_mismatch");
      parama.j("signature_mismatch", null);
      AppMethodBeat.o(78573);
      return;
    }
    parama.j("invalid_type", null);
    AppMethodBeat.o(78573);
  }
  
  public final void b(b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "launch3rdApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ah
 * JD-Core Version:    0.7.0.1
 */