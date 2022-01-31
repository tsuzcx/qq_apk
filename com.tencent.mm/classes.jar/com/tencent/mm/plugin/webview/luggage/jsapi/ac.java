package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public class ac
  extends bi<e>
{
  public final void a(final Context paramContext, final String paramString, final bh.a parama)
  {
    AppMethodBeat.i(6329);
    ab.i("MicroMsg.JsApiLaunchApplication", "invokeInMM");
    Object localObject1 = com.tencent.mm.plugin.webview.luggage.c.b.BJ(paramString);
    if (localObject1 == null)
    {
      ab.e("MicroMsg.JsApiLaunchApplication", "data is null");
      parama.c("fail", null);
      AppMethodBeat.o(6329);
      return;
    }
    paramString = ((JSONObject)localObject1).optString("appID");
    final String str1 = ((JSONObject)localObject1).optString("schemeUrl");
    final String str2 = ((JSONObject)localObject1).optString("parameter");
    final String str3 = ((JSONObject)localObject1).optString("packageName");
    final String str4 = ((JSONObject)localObject1).optString("signature");
    int i = ((JSONObject)localObject1).optInt("alertType");
    final String str5 = ((JSONObject)localObject1).optString("extInfo");
    ab.i("MicroMsg.JsApiLaunchApplication", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s, pkg:%s, signature:%s", new Object[] { paramString, str1, str5, str2, str3, str4 });
    if ((bo.isNullOrNil(paramString)) && (bo.isNullOrNil(str1)) && (bo.isNullOrNil(str3)))
    {
      ab.e("MicroMsg.JsApiLaunchApplication", "appid and scheme is null or nil");
      parama.c("fail", null);
      AppMethodBeat.o(6329);
      return;
    }
    String str6 = ((JSONObject)localObject1).optString("preVerifyAppId");
    localObject1 = ((JSONObject)localObject1).optString("currentUrl");
    final Bundle localBundle = new Bundle();
    try
    {
      localBundle.putString("current_page_url", URLEncoder.encode((String)localObject1, "UTF-8"));
      label233:
      localBundle.putString("current_page_appid", str6);
      Object localObject2 = new b.a();
      ((b.a)localObject2).fsX = new axf();
      ((b.a)localObject2).fsY = new axg();
      ((b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
      ((b.a)localObject2).funcId = 1125;
      localObject2 = ((b.a)localObject2).ado();
      axf localaxf = (axf)((com.tencent.mm.ai.b)localObject2).fsV.fta;
      localaxf.cwc = str6;
      localaxf.xmy = paramString;
      localaxf.scene = 0;
      localaxf.url = ((String)localObject1);
      localaxf.xmz = str1;
      localaxf.kNx = i;
      localaxf.xmA = 0;
      localaxf.packageName = str3;
      ab.i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[] { str6, paramString, Integer.valueOf(localaxf.scene), localaxf.url, localaxf.xmz, Integer.valueOf(localaxf.kNx) });
      w.a((com.tencent.mm.ai.b)localObject2, new w.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ai.b paramAnonymousb, m paramAnonymousm)
        {
          AppMethodBeat.i(6328);
          l.post(new ac.1.1(this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb));
          AppMethodBeat.o(6328);
          return 0;
        }
      });
      AppMethodBeat.o(6329);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label233;
    }
  }
  
  public final void b(a<e>.a parama) {}
  
  public final int bjL()
  {
    return 2;
  }
  
  public final String name()
  {
    return "launchApplication";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ac
 * JD-Core Version:    0.7.0.1
 */