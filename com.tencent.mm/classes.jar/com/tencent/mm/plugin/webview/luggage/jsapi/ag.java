package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.g.a.lp.b;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.am.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.ceb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public class ag
  extends bs<com.tencent.mm.plugin.webview.luggage.g>
{
  public final void a(final Context paramContext, final String paramString, final br.a parama)
  {
    AppMethodBeat.i(78577);
    Log.i("MicroMsg.JsApiLaunchApplication", "invokeInMM");
    Object localObject1 = com.tencent.mm.plugin.webview.luggage.c.b.Zc(paramString);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.JsApiLaunchApplication", "data is null");
      parama.i("fail", null);
      AppMethodBeat.o(78577);
      return;
    }
    paramString = ((JSONObject)localObject1).optString("appID");
    final String str1 = ((JSONObject)localObject1).optString("schemeUrl");
    final String str2 = ((JSONObject)localObject1).optString("parameter");
    final String str3 = ((JSONObject)localObject1).optString("packageName");
    final String str4 = ((JSONObject)localObject1).optString("signature");
    int i = ((JSONObject)localObject1).optInt("alertType");
    final String str5 = ((JSONObject)localObject1).optString("extInfo");
    Log.i("MicroMsg.JsApiLaunchApplication", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s, pkg:%s, signature:%s", new Object[] { paramString, str1, str5, str2, str3, str4 });
    if ((Util.isNullOrNil(paramString)) && (Util.isNullOrNil(str1)) && (Util.isNullOrNil(str3)))
    {
      Log.e("MicroMsg.JsApiLaunchApplication", "appid and scheme is null or nil");
      parama.i("fail", null);
      AppMethodBeat.o(78577);
      return;
    }
    String str6 = ((JSONObject)localObject1).optString("preVerifyAppId");
    localObject1 = ((JSONObject)localObject1).optString("currentUrl");
    final Bundle localBundle = new Bundle();
    try
    {
      localBundle.putString("current_page_url", URLEncoder.encode((String)localObject1, "UTF-8"));
      label230:
      localBundle.putString("current_page_appid", str6);
      Object localObject2 = new d.a();
      ((d.a)localObject2).iLN = new cea();
      ((d.a)localObject2).iLO = new ceb();
      ((d.a)localObject2).uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
      ((d.a)localObject2).funcId = 1125;
      localObject2 = ((d.a)localObject2).aXF();
      cea localcea = (cea)((d)localObject2).iLK.iLR;
      localcea.dNI = str6;
      localcea.MjD = paramString;
      localcea.scene = 0;
      localcea.url = ((String)localObject1);
      localcea.MjE = str1;
      localcea.qwp = i;
      localcea.LEg = 0;
      localcea.packageName = str3;
      Log.i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[] { str6, paramString, Integer.valueOf(localcea.scene), localcea.url, localcea.MjE, Integer.valueOf(localcea.qwp) });
      aa.a((d)localObject2, new aa.a()
      {
        public final int a(final int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final d paramAnonymousd, com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(78576);
          p.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78575);
              Log.d("MicroMsg.JsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
              {
                ag.1.this.xwB.i("check fail", null);
                AppMethodBeat.o(78575);
                return;
              }
              Object localObject3 = (ceb)paramAnonymousd.iLL.iLR;
              switch (((ceb)localObject3).dIZ)
              {
              case 1: 
              default: 
                ag.1.this.xwB.i("check fail", null);
                AppMethodBeat.o(78575);
                return;
              case 2: 
                ag.1.this.xwB.i("check fail forbidden scene", null);
                AppMethodBeat.o(78575);
                return;
              }
              am localam = new am(new am.a()
              {
                public final void u(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2)
                {
                  AppMethodBeat.i(78574);
                  Log.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous3Boolean1), Boolean.valueOf(paramAnonymous3Boolean2) });
                  if (paramAnonymous3Boolean1)
                  {
                    ag.1.this.xwB.i(null, null);
                    AppMethodBeat.o(78574);
                    return;
                  }
                  ag.1.this.xwB.i("fail", null);
                  AppMethodBeat.o(78574);
                }
              });
              Log.i("MicroMsg.JsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(((ceb)localObject3).xGz), Integer.valueOf(((ceb)localObject3).dIZ) });
              Object localObject1;
              if (!Util.isNullOrNil(ag.1.this.lzK))
              {
                localObject4 = new Intent("android.intent.action.VIEW", Uri.parse(ag.1.this.lzK));
                ((Intent)localObject4).addFlags(268435456);
                localObject1 = Util.queryIntentActivities(ag.1.this.val$context, (Intent)localObject4);
                if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
                {
                  if ((TextUtils.isEmpty(((Intent)localObject4).getPackage())) && (((List)localObject1).size() == 1)) {}
                  for (localObject1 = h.b((ResolveInfo)((List)localObject1).get(0)); !Util.nullAsNil(MMApplicationContext.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject4).getPackage())
                  {
                    localam.hj(h.a(ag.1.this.val$context, (Intent)localObject4, null, ((ceb)localObject3).xGz, localam, ag.1.this.lzL));
                    AppMethodBeat.o(78575);
                    return;
                  }
                }
              }
              if ((!Util.isNullOrNil(ag.1.this.LS)) && (!Util.isNullOrNil(ag.1.this.lzM)))
              {
                localObject1 = com.tencent.mm.pluginsdk.model.app.q.cj(ag.1.this.val$context, ag.1.this.LS);
                if ((localObject1 != null) && (localObject1[0] != null))
                {
                  localObject1 = com.tencent.mm.b.g.getMessageDigest(localObject1[0].toByteArray());
                  if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(ag.1.this.lzM))) {
                    break label926;
                  }
                  try
                  {
                    localObject1 = MMApplicationContext.getContext().getPackageManager().getLaunchIntentForPackage(ag.1.this.LS);
                    if (localObject1 != null)
                    {
                      localObject4 = new Bundle();
                      com.tencent.mm.pluginsdk.model.app.q.k((Bundle)localObject4, ag.1.this.lzN);
                      ((Intent)localObject1).putExtras((Bundle)localObject4);
                      ((Intent)localObject1).addFlags(268435456);
                      localam.hj(h.a(ag.1.this.val$context, (Intent)localObject1, null, localam, ag.1.this.lzL));
                      AppMethodBeat.o(78575);
                      return;
                    }
                  }
                  catch (Exception localException)
                  {
                    Log.e("MicroMsg.JsApiLaunchApplication", "launchApplication getLaunchIntentForPackage, %s", new Object[] { localException.getMessage() });
                  }
                }
              }
              Object localObject2 = new WXAppExtendObject();
              ((WXAppExtendObject)localObject2).extInfo = ag.1.this.lzO;
              localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
              ((WXMediaMessage)localObject2).sdkVer = 637928960;
              ((WXMediaMessage)localObject2).messageExt = ag.1.this.lzO;
              Object localObject4 = new lp();
              ((lp)localObject4).dQT.dCE = ((WXMediaMessage)localObject2);
              ((lp)localObject4).dQT.appId = ag.1.this.kFU;
              ((lp)localObject4).dQT.dDG = ((ceb)localObject3).xGz;
              ((lp)localObject4).dQT.context = ag.1.this.val$context;
              ((lp)localObject4).dQT.dFP = ag.1.this.lzL;
              ((lp)localObject4).dQT.dQV = localam;
              EventCenter.instance.publish((IEvent)localObject4);
              boolean bool = ((lp)localObject4).dQU.dQW;
              if ((!bool) && (!Util.isNullOrNil(ag.1.this.kFU)) && (!Util.isNullOrNil(ag.1.this.lzN)))
              {
                localObject2 = ag.1.this.kFU + "://" + ag.1.this.lzN;
                localObject3 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject2));
                Log.i("MicroMsg.JsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { localObject2 });
                ((Intent)localObject3).addFlags(268435456);
                localObject2 = Util.queryIntentActivities(ag.1.this.val$context, (Intent)localObject3);
                if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
                  if ((TextUtils.isEmpty(((Intent)localObject3).getPackage())) && (((List)localObject2).size() == 1))
                  {
                    localObject2 = h.b((ResolveInfo)((List)localObject2).get(0));
                    label876:
                    if (Util.nullAsNil(MMApplicationContext.getPackageName()).equals(localObject2)) {
                      break label946;
                    }
                    localam.reset();
                    bool = h.a(ag.1.this.val$context, (Intent)localObject3, null, localam, ag.1.this.lzL);
                  }
                }
              }
              label926:
              label946:
              for (;;)
              {
                localam.hj(bool);
                AppMethodBeat.o(78575);
                return;
                Log.i("MicroMsg.JsApiLaunchApplication", "launchApplication signature not match");
                break;
                localObject2 = ((Intent)localObject3).getPackage();
                break label876;
              }
            }
          });
          AppMethodBeat.o(78576);
          return 0;
        }
      });
      AppMethodBeat.o(78577);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label230;
    }
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int dTs()
  {
    return 2;
  }
  
  public final String name()
  {
    return "launchApplication";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ag
 * JD-Core Version:    0.7.0.1
 */