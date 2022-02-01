package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.f.a.mg;
import com.tencent.mm.f.a.mg.b;
import com.tencent.mm.ipcinvoker.s;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.am.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.protocal.protobuf.cmv;
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
    Object localObject1 = c.agO(paramString);
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
    Object localObject2 = ((JSONObject)localObject1).optString("sourceInfo");
    Object localObject3 = ((JSONObject)localObject1).optString("bizInfo");
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
      label248:
      localBundle.putString("current_page_appid", str6);
      localBundle.putString("current_page_biz_info", (String)localObject3);
      localBundle.putString("current_page_source_info", (String)localObject2);
      localObject2 = new d.a();
      ((d.a)localObject2).lBU = new cmu();
      ((d.a)localObject2).lBV = new cmv();
      ((d.a)localObject2).uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
      ((d.a)localObject2).funcId = 1125;
      localObject2 = ((d.a)localObject2).bgN();
      localObject3 = (cmu)d.b.b(((d)localObject2).lBR);
      ((cmu)localObject3).appid = str6;
      ((cmu)localObject3).Tur = paramString;
      ((cmu)localObject3).scene = 0;
      ((cmu)localObject3).url = ((String)localObject1);
      ((cmu)localObject3).Tus = str1;
      ((cmu)localObject3).tVq = i;
      ((cmu)localObject3).SEl = 0;
      ((cmu)localObject3).packageName = str3;
      Log.i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[] { str6, paramString, Integer.valueOf(((cmu)localObject3).scene), ((cmu)localObject3).url, ((cmu)localObject3).Tus, Integer.valueOf(((cmu)localObject3).tVq) });
      aa.a((d)localObject2, new aa.a()
      {
        public final int a(final int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final d paramAnonymousd, com.tencent.mm.an.q paramAnonymousq)
        {
          AppMethodBeat.i(78576);
          s.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78575);
              Log.d("MicroMsg.JsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
              {
                ag.1.this.CAJ.i("check fail", null);
                AppMethodBeat.o(78575);
                return;
              }
              Object localObject3 = (cmv)d.c.b(paramAnonymousd.lBS);
              switch (((cmv)localObject3).fBP)
              {
              case 1: 
              default: 
                ag.1.this.CAJ.i("check fail", null);
                AppMethodBeat.o(78575);
                return;
              case 2: 
                ag.1.this.CAJ.i("check fail forbidden scene", null);
                AppMethodBeat.o(78575);
                return;
              }
              am localam = new am(new am.a()
              {
                public final void x(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2)
                {
                  AppMethodBeat.i(78574);
                  Log.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous3Boolean1), Boolean.valueOf(paramAnonymous3Boolean2) });
                  if (paramAnonymous3Boolean1)
                  {
                    ag.1.this.CAJ.i(null, null);
                    AppMethodBeat.o(78574);
                    return;
                  }
                  ag.1.this.CAJ.i("fail", null);
                  AppMethodBeat.o(78574);
                }
              });
              Log.i("MicroMsg.JsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(((cmv)localObject3).CKC), Integer.valueOf(((cmv)localObject3).fBP) });
              Object localObject1;
              if (!Util.isNullOrNil(ag.1.this.ova))
              {
                localObject4 = new Intent("android.intent.action.VIEW", Uri.parse(ag.1.this.ova));
                ((Intent)localObject4).addFlags(268435456);
                localObject1 = Util.queryIntentActivities(ag.1.this.val$context, (Intent)localObject4);
                if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
                {
                  if ((TextUtils.isEmpty(((Intent)localObject4).getPackage())) && (((List)localObject1).size() == 1)) {}
                  for (localObject1 = h.b((ResolveInfo)((List)localObject1).get(0)); !Util.nullAsNil(MMApplicationContext.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject4).getPackage())
                  {
                    localam.hZ(h.a(ag.1.this.val$context, (Intent)localObject4, null, ((cmv)localObject3).CKC, localam, ag.1.this.ovb));
                    AppMethodBeat.o(78575);
                    return;
                  }
                }
              }
              if ((!Util.isNullOrNil(ag.1.this.ack)) && (!Util.isNullOrNil(ag.1.this.ovc)))
              {
                localObject1 = com.tencent.mm.pluginsdk.model.app.q.cv(ag.1.this.val$context, ag.1.this.ack);
                if ((localObject1 != null) && (localObject1[0] != null))
                {
                  localObject1 = com.tencent.mm.b.g.getMessageDigest(localObject1[0].toByteArray());
                  if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(ag.1.this.ovc))) {
                    break label926;
                  }
                  try
                  {
                    localObject1 = MMApplicationContext.getContext().getPackageManager().getLaunchIntentForPackage(ag.1.this.ack);
                    if (localObject1 != null)
                    {
                      localObject4 = new Bundle();
                      com.tencent.mm.pluginsdk.model.app.q.l((Bundle)localObject4, ag.1.this.ovd);
                      ((Intent)localObject1).putExtras((Bundle)localObject4);
                      ((Intent)localObject1).addFlags(268435456);
                      localam.hZ(h.a(ag.1.this.val$context, (Intent)localObject1, null, localam, ag.1.this.ovb));
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
              ((WXAppExtendObject)localObject2).extInfo = ag.1.this.ove;
              localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
              ((WXMediaMessage)localObject2).sdkVer = 637992960;
              ((WXMediaMessage)localObject2).messageExt = ag.1.this.ove;
              Object localObject4 = new mg();
              ((mg)localObject4).fKj.fvl = ((WXMediaMessage)localObject2);
              ((mg)localObject4).fKj.appId = ag.1.this.nzB;
              ((mg)localObject4).fKj.fwp = ((cmv)localObject3).CKC;
              ((mg)localObject4).fKj.context = ag.1.this.val$context;
              ((mg)localObject4).fKj.fyw = ag.1.this.ovb;
              ((mg)localObject4).fKj.fKl = localam;
              EventCenter.instance.publish((IEvent)localObject4);
              boolean bool = ((mg)localObject4).fKk.fKm;
              if ((!bool) && (!Util.isNullOrNil(ag.1.this.nzB)) && (!Util.isNullOrNil(ag.1.this.ovd)))
              {
                localObject2 = ag.1.this.nzB + "://" + ag.1.this.ovd;
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
                    bool = h.a(ag.1.this.val$context, (Intent)localObject3, null, localam, ag.1.this.ovb);
                  }
                }
              }
              label926:
              label946:
              for (;;)
              {
                localam.hZ(bool);
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
      break label248;
    }
  }
  
  public final void b(b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int cDj()
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