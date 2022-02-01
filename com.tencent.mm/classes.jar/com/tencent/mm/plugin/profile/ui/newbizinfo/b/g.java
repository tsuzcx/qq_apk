package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.br.d;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
{
  public static int NM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 42: 
    case 43: 
    case 57: 
      return 1;
    case 17: 
    case 41: 
      return 2;
    case 39: 
    case 87: 
    case 89: 
      return 3;
    }
    return 4;
  }
  
  public static void a(pd parampd, Context paramContext, String paramString)
  {
    AppMethodBeat.i(27582);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", parampd.value);
    localIntent.putExtra("geta8key_username", paramString);
    localIntent.putExtra("geta8key_scene", 59);
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(27582);
  }
  
  public static void b(pd parampd, Context paramContext, String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(27583);
    if (bu.isNullOrNil(parampd.value))
    {
      ae.d("MicroMsg.NewBizInfoUtil", "jumpToWeApp serviceInfo.id:%s value is null", new Object[] { Integer.valueOf(parampd.id) });
      AppMethodBeat.o(27583);
      return;
    }
    ae.d("MicroMsg.NewBizInfoUtil", "jumpToWeApp value:%s", new Object[] { parampd.value });
    try
    {
      Object localObject2 = new JSONObject(parampd.value);
      parampd = com.tencent.mm.al.g.eX(paramString);
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1102;
      localAppBrandStatObject.dlj = paramString;
      paramString = (p)com.tencent.mm.kernel.g.ab(p.class);
      String str = ((JSONObject)localObject2).optString("userName");
      localObject2 = ((JSONObject)localObject2).optString("pagePath");
      if (parampd == null) {}
      for (parampd = localObject1;; parampd = parampd.field_appId)
      {
        paramString.a(paramContext, str, null, 0, 0, (String)localObject2, localAppBrandStatObject, parampd);
        AppMethodBeat.o(27583);
        return;
      }
      return;
    }
    catch (JSONException parampd)
    {
      AppMethodBeat.o(27583);
    }
  }
  
  public static int bC(int paramInt, String paramString)
  {
    AppMethodBeat.i(27584);
    if ((paramString != null) && (x.Ao(paramString)))
    {
      AppMethodBeat.o(27584);
      return 3;
    }
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    case 8: 
    case 10: 
    default: 
      AppMethodBeat.o(27584);
      return 0;
    case 1: 
    case 2: 
      AppMethodBeat.o(27584);
      return paramInt;
    }
    AppMethodBeat.o(27584);
    return 3;
  }
  
  public static void c(pd parampd, Context paramContext, String paramString)
  {
    AppMethodBeat.i(186596);
    if (bu.isNullOrNil(parampd.value))
    {
      ae.d("MicroMsg.NewBizInfoUtil", "jumpToSearch serviceInfo.id: %s value is null", new Object[] { Integer.valueOf(parampd.id) });
      AppMethodBeat.o(186596);
      return;
    }
    parampd = parampd.value;
    ae.i("MicroMsg.NewBizInfoUtil", "jumpToSearch username: %s, suggestData: %s", new Object[] { paramString, parampd });
    Intent localIntent = ad.ePM();
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsbizscene", 76);
    localIntent.putExtra("ftsType", 2);
    Map localMap = ad.f(76, false, 2);
    localMap.put("userName", paramString);
    if (!bu.isNullOrNil(parampd)) {
      localMap.put("thirdExtParam", parampd);
    }
    localIntent.putExtra("rawUrl", ad.be(localMap));
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.putExtra("ftsbizusername", paramString);
    localIntent.addFlags(67108864);
    d.b(paramContext, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent);
    AppMethodBeat.o(186596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.g
 * JD-Core Version:    0.7.0.1
 */