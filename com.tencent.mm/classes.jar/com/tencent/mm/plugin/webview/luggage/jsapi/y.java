package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.h.a.iw;
import com.tencent.mm.h.a.iw.b;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.luggage.d.c;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.an.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.ara;
import com.tencent.mm.protocal.c.arb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public class y
  extends ax<e>
{
  public final void a(final Context paramContext, final String paramString, final aw.a parama)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiLaunchApplication", "invokeInMM");
    Object localObject1 = c.tJ(paramString);
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.JsApiLaunchApplication", "data is null");
      parama.e("fail", null);
      return;
    }
    paramString = ((JSONObject)localObject1).optString("appID");
    final String str1 = ((JSONObject)localObject1).optString("schemeUrl");
    final String str2 = ((JSONObject)localObject1).optString("parameter");
    int i = ((JSONObject)localObject1).optInt("alertType");
    final String str3 = ((JSONObject)localObject1).optString("extInfo");
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiLaunchApplication", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", new Object[] { paramString, str1, str3, str2 });
    if ((bk.bl(paramString)) && (bk.bl(str1)))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.JsApiLaunchApplication", "appid and scheme is null or nil");
      parama.e("fail", null);
      return;
    }
    String str4 = ((JSONObject)localObject1).optString("preVerifyAppId");
    localObject1 = ((JSONObject)localObject1).optString("currentUrl");
    final Bundle localBundle = new Bundle();
    try
    {
      localBundle.putString("current_page_url", URLEncoder.encode((String)localObject1, "UTF-8"));
      label178:
      localBundle.putString("current_page_appid", str4);
      Object localObject2 = new b.a();
      ((b.a)localObject2).ecH = new ara();
      ((b.a)localObject2).ecI = new arb();
      ((b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
      ((b.a)localObject2).ecG = 1125;
      localObject2 = ((b.a)localObject2).Kt();
      ara localara = (ara)((com.tencent.mm.ah.b)localObject2).ecE.ecN;
      localara.bOL = str4;
      localara.tmJ = paramString;
      localara.scene = 0;
      localara.url = ((String)localObject1);
      localara.tmK = str1;
      localara.iHt = i;
      localara.tmL = 0;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[] { str4, paramString, Integer.valueOf(localara.scene), localara.url, localara.tmK, Integer.valueOf(localara.iHt) });
      w.a((com.tencent.mm.ah.b)localObject2, new w.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.b paramAnonymousb, m paramAnonymousm)
        {
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.JsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            parama.e("check fail", null);
            return 0;
          }
          paramAnonymousm = (arb)paramAnonymousb.ecF.ecN;
          switch (paramAnonymousm.bLB)
          {
          case 1: 
          default: 
            parama.e("check fail", null);
            return 0;
          case 2: 
            parama.e("check fail forbidden scene", null);
            return 0;
          }
          paramAnonymousb = new an(new an.a()
          {
            public final void q(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2) });
              if (paramAnonymous2Boolean1)
              {
                y.1.this.iRN.e(null, null);
                return;
              }
              y.1.this.iRN.e("fail", null);
            }
          });
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(paramAnonymousm.tmN), Integer.valueOf(paramAnonymousm.bLB) });
          if (!bk.bl(str1))
          {
            localObject = new Intent("android.intent.action.VIEW", Uri.parse(str1));
            ((Intent)localObject).addFlags(268435456);
            paramAnonymousString = bk.A(paramContext, (Intent)localObject);
            if ((paramAnonymousString != null) && (!paramAnonymousString.isEmpty()))
            {
              if ((TextUtils.isEmpty(((Intent)localObject).getPackage())) && (paramAnonymousString.size() == 1)) {}
              for (paramAnonymousString = g.b((ResolveInfo)paramAnonymousString.get(0)); !bk.pm(ae.getPackageName()).equals(paramAnonymousString); paramAnonymousString = ((Intent)localObject).getPackage())
              {
                paramAnonymousb.cX(g.a(paramContext, (Intent)localObject, null, paramAnonymousm.tmN, paramAnonymousb, localBundle));
                return 0;
              }
            }
          }
          paramAnonymousString = new WXAppExtendObject();
          paramAnonymousString.extInfo = str3;
          paramAnonymousString = new WXMediaMessage(paramAnonymousString);
          paramAnonymousString.sdkVer = 620824064;
          paramAnonymousString.messageExt = str3;
          Object localObject = new iw();
          ((iw)localObject).bRb.bRd = paramAnonymousString;
          ((iw)localObject).bRb.appId = paramString;
          ((iw)localObject).bRb.showType = paramAnonymousm.tmN;
          ((iw)localObject).bRb.context = paramContext;
          ((iw)localObject).bRb.bIo = localBundle;
          ((iw)localObject).bRb.bRe = paramAnonymousb;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
          boolean bool = ((iw)localObject).bRc.bRf;
          if (!bool)
          {
            paramAnonymousString = paramString + "://" + str2;
            paramAnonymousm = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString));
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.JsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { paramAnonymousString });
            paramAnonymousm.addFlags(268435456);
            paramAnonymousString = bk.A(paramContext, paramAnonymousm);
            if ((paramAnonymousString != null) && (!paramAnonymousString.isEmpty())) {
              if ((TextUtils.isEmpty(paramAnonymousm.getPackage())) && (paramAnonymousString.size() == 1))
              {
                paramAnonymousString = g.b((ResolveInfo)paramAnonymousString.get(0));
                if (bk.pm(ae.getPackageName()).equals(paramAnonymousString)) {
                  break label651;
                }
                paramAnonymousb.edU = false;
                paramAnonymousb.ggq = false;
                paramAnonymousb.ggr = false;
                paramAnonymousb.bRf = false;
                bool = g.a(paramContext, paramAnonymousm, null, paramAnonymousb, localBundle);
              }
            }
          }
          label651:
          for (;;)
          {
            paramAnonymousb.cX(bool);
            return 0;
            paramAnonymousString = paramAnonymousm.getPackage();
            break;
          }
        }
      });
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label178;
    }
  }
  
  public final int aGj()
  {
    return 2;
  }
  
  public final void b(com.tencent.luggage.e.a<e>.a parama) {}
  
  public final String name()
  {
    return "launchApplication";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.y
 * JD-Core Version:    0.7.0.1
 */