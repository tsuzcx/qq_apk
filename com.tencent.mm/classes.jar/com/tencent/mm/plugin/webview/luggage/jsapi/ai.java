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
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.autogen.a.nm;
import com.tencent.mm.autogen.a.nm.b;
import com.tencent.mm.ipcinvoker.s;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.aq;
import com.tencent.mm.pluginsdk.model.app.aq.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.ddi;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public class ai
  extends bw<com.tencent.mm.plugin.webview.luggage.g>
{
  public final void a(final Context paramContext, final String paramString, final bv.a parama)
  {
    AppMethodBeat.i(78577);
    Log.i("MicroMsg.JsApiLaunchApplication", "invokeInMM");
    Object localObject1 = com.tencent.mm.plugin.webview.luggage.c.c.ZL(paramString);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.JsApiLaunchApplication", "data is null");
      parama.j("fail", null);
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
      parama.j("fail", null);
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
      localObject2 = new c.a();
      ((c.a)localObject2).otE = new ddi();
      ((c.a)localObject2).otF = new ddj();
      ((c.a)localObject2).uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
      ((c.a)localObject2).funcId = 1125;
      localObject2 = ((c.a)localObject2).bEF();
      localObject3 = (ddi)c.b.b(((com.tencent.mm.am.c)localObject2).otB);
      ((ddi)localObject3).appid = str6;
      ((ddi)localObject3).aaIV = paramString;
      ((ddi)localObject3).scene = 0;
      ((ddi)localObject3).url = ((String)localObject1);
      ((ddi)localObject3).aaIW = str1;
      ((ddi)localObject3).wYK = i;
      ((ddi)localObject3).ZFJ = 0;
      ((ddi)localObject3).packageName = str3;
      Log.i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[] { str6, paramString, Integer.valueOf(((ddi)localObject3).scene), ((ddi)localObject3).url, ((ddi)localObject3).aaIW, Integer.valueOf(((ddi)localObject3).wYK) });
      z.a((com.tencent.mm.am.c)localObject2, new z.a()
      {
        public final int callback(final int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
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
                ai.1.this.Iuv.j("check fail", null);
                AppMethodBeat.o(78575);
                return;
              }
              Object localObject3 = (ddj)c.c.b(paramAnonymousc.otC);
              switch (((ddj)localObject3).hGE)
              {
              case 1: 
              default: 
                ai.1.this.Iuv.j("check fail", null);
                AppMethodBeat.o(78575);
                return;
              case 2: 
                ai.1.this.Iuv.j("check fail forbidden scene", null);
                AppMethodBeat.o(78575);
                return;
              }
              aq localaq = new aq(new aq.a()
              {
                public final void C(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2)
                {
                  AppMethodBeat.i(78574);
                  Log.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous3Boolean1), Boolean.valueOf(paramAnonymous3Boolean2) });
                  if (paramAnonymous3Boolean1)
                  {
                    ai.1.this.Iuv.j(null, null);
                    AppMethodBeat.o(78574);
                    return;
                  }
                  ai.1.this.Iuv.j("fail", null);
                  AppMethodBeat.o(78574);
                }
              });
              Log.i("MicroMsg.JsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(((ddj)localObject3).show_type), Integer.valueOf(((ddj)localObject3).hGE) });
              Object localObject1;
              if (!Util.isNullOrNil(ai.1.this.ryu))
              {
                localObject4 = new Intent("android.intent.action.VIEW", Uri.parse(ai.1.this.ryu));
                ((Intent)localObject4).addFlags(268435456);
                localObject1 = Util.queryIntentActivities(ai.1.this.val$context, (Intent)localObject4);
                if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
                {
                  if ((TextUtils.isEmpty(((Intent)localObject4).getPackage())) && (((List)localObject1).size() == 1)) {}
                  for (localObject1 = h.b((ResolveInfo)((List)localObject1).get(0)); !Util.nullAsNil(MMApplicationContext.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject4).getPackage())
                  {
                    localaq.iY(h.a(ai.1.this.val$context, (Intent)localObject4, null, ((ddj)localObject3).show_type, localaq, ai.1.this.ryv));
                    AppMethodBeat.o(78575);
                    return;
                  }
                }
              }
              if ((!Util.isNullOrNil(ai.1.this.bJT)) && (!Util.isNullOrNil(ai.1.this.ryw)))
              {
                localObject1 = u.cG(ai.1.this.val$context, ai.1.this.bJT);
                if ((localObject1 != null) && (localObject1[0] != null))
                {
                  localObject1 = com.tencent.mm.b.g.getMessageDigest(localObject1[0].toByteArray());
                  if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(ai.1.this.ryw))) {
                    break label923;
                  }
                  try
                  {
                    localObject1 = MMApplicationContext.getContext().getPackageManager().getLaunchIntentForPackage(ai.1.this.bJT);
                    if (localObject1 != null)
                    {
                      localObject4 = new Bundle();
                      u.l((Bundle)localObject4, ai.1.this.ryx);
                      ((Intent)localObject1).putExtras((Bundle)localObject4);
                      ((Intent)localObject1).addFlags(268435456);
                      localaq.iY(h.a(ai.1.this.val$context, (Intent)localObject1, null, localaq, ai.1.this.ryv));
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
              ((WXAppExtendObject)localObject2).extInfo = ai.1.this.ryy;
              localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
              ((WXMediaMessage)localObject2).sdkVer = 638058496;
              ((WXMediaMessage)localObject2).messageExt = ai.1.this.ryy;
              Object localObject4 = new nm();
              ((nm)localObject4).hPP.hzF = ((WXMediaMessage)localObject2);
              ((nm)localObject4).hPP.appId = ai.1.this.qyB;
              ((nm)localObject4).hPP.hAN = ((ddj)localObject3).show_type;
              ((nm)localObject4).hPP.context = ai.1.this.val$context;
              ((nm)localObject4).hPP.hDf = ai.1.this.ryv;
              ((nm)localObject4).hPP.hPR = localaq;
              ((nm)localObject4).publish();
              boolean bool = ((nm)localObject4).hPQ.hPS;
              if ((!bool) && (!Util.isNullOrNil(ai.1.this.qyB)) && (!Util.isNullOrNil(ai.1.this.ryx)))
              {
                localObject2 = ai.1.this.qyB + "://" + ai.1.this.ryx;
                localObject3 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject2));
                Log.i("MicroMsg.JsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { localObject2 });
                ((Intent)localObject3).addFlags(268435456);
                localObject2 = Util.queryIntentActivities(ai.1.this.val$context, (Intent)localObject3);
                if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
                  if ((TextUtils.isEmpty(((Intent)localObject3).getPackage())) && (((List)localObject2).size() == 1))
                  {
                    localObject2 = h.b((ResolveInfo)((List)localObject2).get(0));
                    label873:
                    if (Util.nullAsNil(MMApplicationContext.getPackageName()).equals(localObject2)) {
                      break label943;
                    }
                    localaq.reset();
                    bool = h.a(ai.1.this.val$context, (Intent)localObject3, null, localaq, ai.1.this.ryv);
                  }
                }
              }
              label923:
              label943:
              for (;;)
              {
                localaq.iY(bool);
                AppMethodBeat.o(78575);
                return;
                Log.i("MicroMsg.JsApiLaunchApplication", "launchApplication signature not match");
                break;
                localObject2 = ((Intent)localObject3).getPackage();
                break label873;
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
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "launchApplication";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ai
 * JD-Core Version:    0.7.0.1
 */