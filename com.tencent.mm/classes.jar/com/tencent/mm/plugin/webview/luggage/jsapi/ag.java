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
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.g.a.kz.b;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.am.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public class ag
  extends br<com.tencent.mm.plugin.webview.luggage.g>
{
  public final void a(final Context paramContext, final String paramString, final bq.a parama)
  {
    AppMethodBeat.i(78577);
    ae.i("MicroMsg.JsApiLaunchApplication", "invokeInMM");
    Object localObject1 = com.tencent.mm.plugin.webview.luggage.c.b.PM(paramString);
    if (localObject1 == null)
    {
      ae.e("MicroMsg.JsApiLaunchApplication", "data is null");
      parama.f("fail", null);
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
    ae.i("MicroMsg.JsApiLaunchApplication", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s, pkg:%s, signature:%s", new Object[] { paramString, str1, str5, str2, str3, str4 });
    if ((bu.isNullOrNil(paramString)) && (bu.isNullOrNil(str1)) && (bu.isNullOrNil(str3)))
    {
      ae.e("MicroMsg.JsApiLaunchApplication", "appid and scheme is null or nil");
      parama.f("fail", null);
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
      Object localObject2 = new b.a();
      ((b.a)localObject2).hQF = new brg();
      ((b.a)localObject2).hQG = new brh();
      ((b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
      ((b.a)localObject2).funcId = 1125;
      localObject2 = ((b.a)localObject2).aDS();
      brg localbrg = (brg)((com.tencent.mm.ak.b)localObject2).hQD.hQJ;
      localbrg.dwb = str6;
      localbrg.Heu = paramString;
      localbrg.scene = 0;
      localbrg.url = ((String)localObject1);
      localbrg.Hev = str1;
      localbrg.phg = i;
      localbrg.Hew = 0;
      localbrg.packageName = str3;
      ae.i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[] { str6, paramString, Integer.valueOf(localbrg.scene), localbrg.url, localbrg.Hev, Integer.valueOf(localbrg.phg) });
      x.a((com.tencent.mm.ak.b)localObject2, new x.a()
      {
        public final int a(final int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(78576);
          p.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78575);
              ae.d("MicroMsg.JsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
              {
                ag.1.this.pva.f("check fail", null);
                AppMethodBeat.o(78575);
                return;
              }
              Object localObject3 = (brh)paramAnonymousb.hQE.hQJ;
              switch (((brh)localObject3).drN)
              {
              case 1: 
              default: 
                ag.1.this.pva.f("check fail", null);
                AppMethodBeat.o(78575);
                return;
              case 2: 
                ag.1.this.pva.f("check fail forbidden scene", null);
                AppMethodBeat.o(78575);
                return;
              }
              am localam = new am(new am.a()
              {
                public final void u(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2)
                {
                  AppMethodBeat.i(78574);
                  ae.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous3Boolean1), Boolean.valueOf(paramAnonymous3Boolean2) });
                  if (paramAnonymous3Boolean1)
                  {
                    ag.1.this.pva.f(null, null);
                    AppMethodBeat.o(78574);
                    return;
                  }
                  ag.1.this.pva.f("fail", null);
                  AppMethodBeat.o(78574);
                }
              });
              ae.i("MicroMsg.JsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(((brh)localObject3).uoi), Integer.valueOf(((brh)localObject3).drN) });
              Object localObject1;
              if (!bu.isNullOrNil(ag.1.this.kvG))
              {
                localObject4 = new Intent("android.intent.action.VIEW", Uri.parse(ag.1.this.kvG));
                ((Intent)localObject4).addFlags(268435456);
                localObject1 = bu.ac(ag.1.this.val$context, (Intent)localObject4);
                if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
                {
                  if ((TextUtils.isEmpty(((Intent)localObject4).getPackage())) && (((List)localObject1).size() == 1)) {}
                  for (localObject1 = h.b((ResolveInfo)((List)localObject1).get(0)); !bu.nullAsNil(ak.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject4).getPackage())
                  {
                    localam.gm(h.a(ag.1.this.val$context, (Intent)localObject4, null, ((brh)localObject3).uoi, localam, ag.1.this.kvH));
                    AppMethodBeat.o(78575);
                    return;
                  }
                }
              }
              if ((!bu.isNullOrNil(ag.1.this.LI)) && (!bu.isNullOrNil(ag.1.this.kvI)))
              {
                localObject1 = q.bP(ag.1.this.val$context, ag.1.this.LI);
                if ((localObject1 != null) && (localObject1[0] != null))
                {
                  localObject1 = com.tencent.mm.b.g.getMessageDigest(localObject1[0].toByteArray());
                  if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(ag.1.this.kvI))) {
                    break label926;
                  }
                  try
                  {
                    localObject1 = ak.getContext().getPackageManager().getLaunchIntentForPackage(ag.1.this.LI);
                    if (localObject1 != null)
                    {
                      localObject4 = new Bundle();
                      q.j((Bundle)localObject4, ag.1.this.kvJ);
                      ((Intent)localObject1).putExtras((Bundle)localObject4);
                      ((Intent)localObject1).addFlags(268435456);
                      localam.gm(h.a(ag.1.this.val$context, (Intent)localObject1, null, localam, ag.1.this.kvH));
                      AppMethodBeat.o(78575);
                      return;
                    }
                  }
                  catch (Exception localException)
                  {
                    ae.e("MicroMsg.JsApiLaunchApplication", "launchApplication getLaunchIntentForPackage, %s", new Object[] { localException.getMessage() });
                  }
                }
              }
              Object localObject2 = new WXAppExtendObject();
              ((WXAppExtendObject)localObject2).extInfo = ag.1.this.kvK;
              localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
              ((WXMediaMessage)localObject2).sdkVer = 637928960;
              ((WXMediaMessage)localObject2).messageExt = ag.1.this.kvK;
              Object localObject4 = new kz();
              ((kz)localObject4).dzg.dve = ((WXMediaMessage)localObject2);
              ((kz)localObject4).dzg.appId = ag.1.this.jEl;
              ((kz)localObject4).dzg.dmr = ((brh)localObject3).uoi;
              ((kz)localObject4).dzg.context = ag.1.this.val$context;
              ((kz)localObject4).dzg.doz = ag.1.this.kvH;
              ((kz)localObject4).dzg.dzi = localam;
              a.IvT.l((com.tencent.mm.sdk.b.b)localObject4);
              boolean bool = ((kz)localObject4).dzh.dzj;
              if ((!bool) && (!bu.isNullOrNil(ag.1.this.jEl)) && (!bu.isNullOrNil(ag.1.this.kvJ)))
              {
                localObject2 = ag.1.this.jEl + "://" + ag.1.this.kvJ;
                localObject3 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject2));
                ae.i("MicroMsg.JsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { localObject2 });
                ((Intent)localObject3).addFlags(268435456);
                localObject2 = bu.ac(ag.1.this.val$context, (Intent)localObject3);
                if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
                  if ((TextUtils.isEmpty(((Intent)localObject3).getPackage())) && (((List)localObject2).size() == 1))
                  {
                    localObject2 = h.b((ResolveInfo)((List)localObject2).get(0));
                    label876:
                    if (bu.nullAsNil(ak.getPackageName()).equals(localObject2)) {
                      break label946;
                    }
                    localam.reset();
                    bool = h.a(ag.1.this.val$context, (Intent)localObject3, null, localam, ag.1.this.kvH);
                  }
                }
              }
              label926:
              label946:
              for (;;)
              {
                localam.gm(bool);
                AppMethodBeat.o(78575);
                return;
                ae.i("MicroMsg.JsApiLaunchApplication", "launchApplication signature not match");
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
  
  public final int ced()
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