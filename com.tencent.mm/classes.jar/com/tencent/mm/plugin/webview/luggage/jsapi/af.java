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
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.g.a.kh.b;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.an.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.bik;
import com.tencent.mm.protocal.protobuf.bil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public class af
  extends bo<f>
{
  public final void a(final Context paramContext, final String paramString, final bn.a parama)
  {
    AppMethodBeat.i(78577);
    ad.i("MicroMsg.JsApiLaunchApplication", "invokeInMM");
    Object localObject1 = com.tencent.mm.plugin.webview.luggage.c.b.HG(paramString);
    if (localObject1 == null)
    {
      ad.e("MicroMsg.JsApiLaunchApplication", "data is null");
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
    ad.i("MicroMsg.JsApiLaunchApplication", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s, pkg:%s, signature:%s", new Object[] { paramString, str1, str5, str2, str3, str4 });
    if ((bt.isNullOrNil(paramString)) && (bt.isNullOrNil(str1)) && (bt.isNullOrNil(str3)))
    {
      ad.e("MicroMsg.JsApiLaunchApplication", "appid and scheme is null or nil");
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
      ((b.a)localObject2).gUU = new bik();
      ((b.a)localObject2).gUV = new bil();
      ((b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
      ((b.a)localObject2).funcId = 1125;
      localObject2 = ((b.a)localObject2).atI();
      bik localbik = (bik)((com.tencent.mm.al.b)localObject2).gUS.gUX;
      localbik.dlB = str6;
      localbik.DGa = paramString;
      localbik.scene = 0;
      localbik.url = ((String)localObject1);
      localbik.DGb = str1;
      localbik.nTM = i;
      localbik.DGc = 0;
      localbik.packageName = str3;
      ad.i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[] { str6, paramString, Integer.valueOf(localbik.scene), localbik.url, localbik.DGb, Integer.valueOf(localbik.nTM) });
      x.a((com.tencent.mm.al.b)localObject2, new x.a()
      {
        public final int a(final int paramAnonymousInt1, final int paramAnonymousInt2, final String paramAnonymousString, final com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(78576);
          p.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78575);
              ad.d("MicroMsg.JsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
              {
                af.1.this.ohm.f("check fail", null);
                AppMethodBeat.o(78575);
                return;
              }
              Object localObject3 = (bil)paramAnonymousb.gUT.gUX;
              switch (((bil)localObject3).dhR)
              {
              case 1: 
              default: 
                af.1.this.ohm.f("check fail", null);
                AppMethodBeat.o(78575);
                return;
              case 2: 
                af.1.this.ohm.f("check fail forbidden scene", null);
                AppMethodBeat.o(78575);
                return;
              }
              an localan = new an(new an.a()
              {
                public final void t(boolean paramAnonymous3Boolean1, boolean paramAnonymous3Boolean2)
                {
                  AppMethodBeat.i(78574);
                  ad.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous3Boolean1), Boolean.valueOf(paramAnonymous3Boolean2) });
                  if (paramAnonymous3Boolean1)
                  {
                    af.1.this.ohm.f(null, null);
                    AppMethodBeat.o(78574);
                    return;
                  }
                  af.1.this.ohm.f("fail", null);
                  AppMethodBeat.o(78574);
                }
              });
              ad.i("MicroMsg.JsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(((bil)localObject3).rXs), Integer.valueOf(((bil)localObject3).dhR) });
              Object localObject1;
              if (!bt.isNullOrNil(af.1.this.jxy))
              {
                localObject4 = new Intent("android.intent.action.VIEW", Uri.parse(af.1.this.jxy));
                ((Intent)localObject4).addFlags(268435456);
                localObject1 = bt.M(af.1.this.val$context, (Intent)localObject4);
                if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
                {
                  if ((TextUtils.isEmpty(((Intent)localObject4).getPackage())) && (((List)localObject1).size() == 1)) {}
                  for (localObject1 = h.b((ResolveInfo)((List)localObject1).get(0)); !bt.nullAsNil(aj.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject4).getPackage())
                  {
                    localan.fN(h.a(af.1.this.val$context, (Intent)localObject4, null, ((bil)localObject3).rXs, localan, af.1.this.jxz));
                    AppMethodBeat.o(78575);
                    return;
                  }
                }
              }
              if ((!bt.isNullOrNil(af.1.this.IX)) && (!bt.isNullOrNil(af.1.this.jxA)))
              {
                localObject1 = q.bJ(af.1.this.val$context, af.1.this.IX);
                if ((localObject1 != null) && (localObject1[0] != null))
                {
                  localObject1 = g.getMessageDigest(localObject1[0].toByteArray());
                  if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(af.1.this.jxA))) {
                    break label942;
                  }
                  try
                  {
                    localObject1 = aj.getContext().getPackageManager().getLaunchIntentForPackage(af.1.this.IX);
                    if (localObject1 != null)
                    {
                      localObject4 = new Bundle();
                      q.j((Bundle)localObject4, af.1.this.jxB);
                      ((Intent)localObject1).putExtras((Bundle)localObject4);
                      ((Intent)localObject1).addFlags(268435456);
                      localan.fN(h.a(af.1.this.val$context, (Intent)localObject1, null, localan, af.1.this.jxz));
                      AppMethodBeat.o(78575);
                      return;
                    }
                  }
                  catch (Exception localException)
                  {
                    ad.e("MicroMsg.JsApiLaunchApplication", "launchApplication getLaunchIntentForPackage, %s", new Object[] { localException.getMessage() });
                  }
                }
              }
              Object localObject2 = new WXAppExtendObject();
              ((WXAppExtendObject)localObject2).extInfo = af.1.this.jxC;
              localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
              ((WXMediaMessage)localObject2).sdkVer = 637927424;
              ((WXMediaMessage)localObject2).messageExt = af.1.this.jxC;
              Object localObject4 = new kh();
              ((kh)localObject4).doE.doG = ((WXMediaMessage)localObject2);
              ((kh)localObject4).doE.appId = af.1.this.iHZ;
              ((kh)localObject4).doE.dcz = ((bil)localObject3).rXs;
              ((kh)localObject4).doE.context = af.1.this.val$context;
              ((kh)localObject4).doE.deG = af.1.this.jxz;
              ((kh)localObject4).doE.doH = localan;
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject4);
              boolean bool = ((kh)localObject4).doF.doI;
              if ((!bool) && (!bt.isNullOrNil(af.1.this.iHZ)) && (!bt.isNullOrNil(af.1.this.jxB)))
              {
                localObject2 = af.1.this.iHZ + "://" + af.1.this.jxB;
                localObject3 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject2));
                ad.i("MicroMsg.JsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { localObject2 });
                ((Intent)localObject3).addFlags(268435456);
                localObject2 = bt.M(af.1.this.val$context, (Intent)localObject3);
                if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
                  if ((TextUtils.isEmpty(((Intent)localObject3).getPackage())) && (((List)localObject2).size() == 1))
                  {
                    localObject2 = h.b((ResolveInfo)((List)localObject2).get(0));
                    label876:
                    if (bt.nullAsNil(aj.getPackageName()).equals(localObject2)) {
                      break label962;
                    }
                    localan.gWb = false;
                    localan.jxM = false;
                    localan.jxN = false;
                    localan.doI = false;
                    bool = h.a(af.1.this.val$context, (Intent)localObject3, null, localan, af.1.this.jxz);
                  }
                }
              }
              label942:
              label962:
              for (;;)
              {
                localan.fN(bool);
                AppMethodBeat.o(78575);
                return;
                ad.i("MicroMsg.JsApiLaunchApplication", "launchApplication signature not match");
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
  
  public final void b(com.tencent.luggage.d.a<f>.a parama) {}
  
  public final int bQV()
  {
    return 2;
  }
  
  public final String name()
  {
    return "launchApplication";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.af
 * JD-Core Version:    0.7.0.1
 */