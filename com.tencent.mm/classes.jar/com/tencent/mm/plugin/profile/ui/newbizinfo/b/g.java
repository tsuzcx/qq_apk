package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
{
  public static int Vb(int paramInt)
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
  
  public static void a(qa paramqa, Context paramContext, String paramString)
  {
    AppMethodBeat.i(27582);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramqa.value);
    localIntent.putExtra("geta8key_username", paramString);
    localIntent.putExtra("geta8key_scene", 59);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(27582);
  }
  
  public static void b(qa paramqa, Context paramContext, String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(27583);
    if (Util.isNullOrNil(paramqa.value))
    {
      Log.d("MicroMsg.NewBizInfoUtil", "jumpToWeApp serviceInfo.id:%s value is null", new Object[] { Integer.valueOf(paramqa.id) });
      AppMethodBeat.o(27583);
      return;
    }
    Log.d("MicroMsg.NewBizInfoUtil", "jumpToWeApp value:%s", new Object[] { paramqa.value });
    try
    {
      Object localObject2 = new JSONObject(paramqa.value);
      paramqa = com.tencent.mm.al.g.fJ(paramString);
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1102;
      localAppBrandStatObject.dCw = paramString;
      paramString = (r)com.tencent.mm.kernel.g.af(r.class);
      String str = ((JSONObject)localObject2).optString("userName");
      localObject2 = ((JSONObject)localObject2).optString("pagePath");
      if (paramqa == null) {}
      for (paramqa = localObject1;; paramqa = paramqa.field_appId)
      {
        paramString.a(paramContext, str, null, 0, 0, (String)localObject2, localAppBrandStatObject, paramqa);
        AppMethodBeat.o(27583);
        return;
      }
      return;
    }
    catch (JSONException paramqa)
    {
      AppMethodBeat.o(27583);
    }
  }
  
  public static int bQ(int paramInt, String paramString)
  {
    AppMethodBeat.i(27584);
    if ((paramString != null) && (ab.IT(paramString)))
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
  
  public static void c(qa paramqa, Context paramContext, String paramString)
  {
    AppMethodBeat.i(231963);
    if (Util.isNullOrNil(paramqa.value))
    {
      Log.d("MicroMsg.NewBizInfoUtil", "jumpToSearch serviceInfo.id: %s value is null", new Object[] { Integer.valueOf(paramqa.id) });
      AppMethodBeat.o(231963);
      return;
    }
    paramqa = paramqa.value;
    Log.i("MicroMsg.NewBizInfoUtil", "jumpToSearch username: %s, suggestData: %s", new Object[] { paramString, paramqa });
    Intent localIntent = ai.fXX();
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsbizscene", 76);
    localIntent.putExtra("ftsType", 2);
    Map localMap = ai.h(76, false, 2);
    localMap.put("userName", paramString);
    if (!Util.isNullOrNil(paramqa)) {
      localMap.put("thirdExtParam", paramqa);
    }
    localIntent.putExtra("rawUrl", ai.bd(localMap));
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.putExtra("ftsbizusername", paramString);
    localIntent.addFlags(67108864);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent);
    AppMethodBeat.o(231963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.g
 * JD-Core Version:    0.7.0.1
 */