package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.mm.h.a.iw;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.webview.luggage.d.c;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class x
  extends ax<e>
{
  public final void a(Context paramContext, String paramString, final aw.a parama)
  {
    y.i("MicroMsg.JsApiLaunch3RdApp", "invokeInMM");
    Object localObject1 = c.tJ(paramString);
    if (localObject1 == null)
    {
      parama.e("invalid_data", null);
      return;
    }
    int i = ((JSONObject)localObject1).optInt("type");
    paramString = ((JSONObject)localObject1).optString("appID");
    Object localObject2;
    if (i == 0)
    {
      localObject1 = ((JSONObject)localObject1).optString("extInfo");
      y.i("MicroMsg.JsApiLaunch3RdApp", "appid:[%s], extinfo:[%s]", new Object[] { paramString, localObject1 });
      if (bk.bl(paramString))
      {
        y.e("MicroMsg.JsApiLaunch3RdApp", "appid is null or nil");
        parama.e("fail", null);
        return;
      }
      if (!com.tencent.mm.plugin.webview.a.a.eUS.o(ae.getContext(), paramString))
      {
        y.e("MicroMsg.JsApiLaunch3RdApp", "app is not installed, appid:[%s]", new Object[] { paramString });
        parama.e("fail", null);
        return;
      }
      localObject2 = new WXAppExtendObject();
      ((WXAppExtendObject)localObject2).extInfo = ((String)localObject1);
      localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
      ((WXMediaMessage)localObject2).sdkVer = 620824064;
      ((WXMediaMessage)localObject2).messageExt = ((String)localObject1);
      localObject1 = new iw();
      ((iw)localObject1).bRb.bRd = ((WXMediaMessage)localObject2);
      ((iw)localObject1).bRb.appId = paramString;
      ((iw)localObject1).bRb.context = paramContext;
      ((iw)localObject1).bRb.bRe = new am()
      {
        public final void cW(boolean paramAnonymousBoolean)
        {
          parama.e(null, null);
        }
      };
      com.tencent.mm.sdk.b.a.udP.m((b)localObject1);
      return;
    }
    if (i == 1)
    {
      String str = ((JSONObject)localObject1).optString("signature");
      localObject2 = ((JSONObject)localObject1).optString("packageName");
      paramString = ((JSONObject)localObject1).optString("param");
      y.i("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[] { str, localObject2, paramString });
      if ((bk.bl(str)) || (bk.bl((String)localObject2)))
      {
        y.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp invalid_args");
        parama.e("invalid_args", null);
        return;
      }
      if (!p.o(paramContext, (String)localObject2))
      {
        y.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp not_install");
        parama.e("not_install", null);
        return;
      }
      Object localObject3 = p.bj(paramContext, (String)localObject2);
      if ((localObject3 != null) && (localObject3[0] != null))
      {
        localObject3 = com.tencent.mm.a.g.o(localObject3[0].toByteArray());
        if ((localObject3 != null) && (((String)localObject3).equalsIgnoreCase(str)))
        {
          str = ((JSONObject)localObject1).optString("currentUrl");
          localObject1 = ((JSONObject)localObject1).optString("preVerifyAppId");
          try
          {
            localObject2 = paramContext.getPackageManager().getLaunchIntentForPackage((String)localObject2);
            if (localObject2 != null)
            {
              localObject3 = new Bundle();
              p.i((Bundle)localObject3, paramString);
              ((Intent)localObject2).putExtras((Bundle)localObject3);
              ((Intent)localObject2).addFlags(268435456);
              paramString = new Bundle();
              paramString.putString("current_page_url", str);
              paramString.putString("current_page_appid", (String)localObject1);
              com.tencent.mm.pluginsdk.model.app.g.a(paramContext, (Intent)localObject2, null, new x.2(this, parama), paramString);
              return;
            }
          }
          catch (Exception paramContext)
          {
            y.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp getLaunchIntentForPackage, %s", new Object[] { paramContext.getMessage() });
            parama.e("fail", null);
            return;
          }
        }
      }
      y.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp signature_mismatch");
      parama.e("signature_mismatch", null);
      return;
    }
    parama.e("invalid_type", null);
  }
  
  public final int aGj()
  {
    return 2;
  }
  
  public final void b(com.tencent.luggage.e.a<e>.a parama) {}
  
  public final String name()
  {
    return "launch3rdApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.x
 * JD-Core Version:    0.7.0.1
 */