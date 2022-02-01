package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.rg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static void a(rg paramrg, Context paramContext, String paramString)
  {
    AppMethodBeat.i(27582);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramrg.value);
    localIntent.putExtra("geta8key_username", paramString);
    localIntent.putExtra("geta8key_scene", 59);
    localIntent.putExtra("key_enable_teen_mode_check", true);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(27582);
  }
  
  public static int afU(int paramInt)
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
  
  public static void b(rg paramrg, Context paramContext, String paramString)
  {
    Object localObject1 = null;
    int i = 0;
    AppMethodBeat.i(27583);
    if (Util.isNullOrNil(paramrg.value))
    {
      Log.d("MicroMsg.NewBizInfoUtil", "jumpToWeApp serviceInfo.id:%s value is null", new Object[] { Integer.valueOf(paramrg.id) });
      AppMethodBeat.o(27583);
      return;
    }
    Log.d("MicroMsg.NewBizInfoUtil", "jumpToWeApp value:%s", new Object[] { paramrg.value });
    try
    {
      Object localObject2 = new JSONObject(paramrg.value);
      com.tencent.mm.api.c localc = g.hU(paramString);
      if (!Util.isNullOrNil(paramrg.key))
      {
        localObject3 = paramrg.key.replace("_", "");
        i = paramrg.key.length() - ((String)localObject3).length();
      }
      paramrg = String.format("%s:%s:%s:%s", new Object[] { paramString, Integer.valueOf(i), paramrg.name, ((JSONObject)localObject2).optString("pagePath") });
      Log.d("MicroMsg.NewBizInfoUtil", "sceneNote = %s", new Object[] { paramrg });
      paramString = new AppBrandStatObject();
      paramString.scene = 1102;
      paramString.hzx = paramrg;
      Log.d("MicroMsg.NewBizInfoUtil", "sceneNote = %s", new Object[] { paramString.hzx });
      Object localObject3 = (t)h.ax(t.class);
      String str = ((JSONObject)localObject2).optString("userName");
      localObject2 = ((JSONObject)localObject2).optString("pagePath");
      if (localc == null) {}
      for (paramrg = localObject1;; paramrg = localc.field_appId)
      {
        ((t)localObject3).a(paramContext, str, null, 0, 0, (String)localObject2, paramString, paramrg);
        AppMethodBeat.o(27583);
        return;
      }
      return;
    }
    catch (JSONException paramrg)
    {
      Log.e("MicroMsg.NewBizInfoUtil", paramrg.getMessage());
      AppMethodBeat.o(27583);
    }
  }
  
  public static void c(rg paramrg, Context paramContext, String paramString)
  {
    AppMethodBeat.i(305716);
    if (Util.isNullOrNil(paramrg.value))
    {
      Log.d("MicroMsg.NewBizInfoUtil", "jumpToSearch serviceInfo.id: %s value is null", new Object[] { Integer.valueOf(paramrg.id) });
      AppMethodBeat.o(305716);
      return;
    }
    paramrg = paramrg.value;
    Log.i("MicroMsg.NewBizInfoUtil", "jumpToSearch username: %s, suggestData: %s", new Object[] { paramString, paramrg });
    Intent localIntent = aj.ipS();
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsbizscene", 76);
    localIntent.putExtra("ftsType", 2);
    Map localMap = aj.r(76, false, 2);
    localMap.put("userName", paramString);
    if (!Util.isNullOrNil(paramrg)) {
      localMap.put("thirdExtParam", paramrg);
    }
    localIntent.putExtra("rawUrl", aj.bo(localMap));
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.putExtra("ftsbizusername", paramString);
    localIntent.addFlags(67108864);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent);
    AppMethodBeat.o(305716);
  }
  
  public static int cw(int paramInt, String paramString)
  {
    AppMethodBeat.i(27584);
    if ((paramString != null) && (ab.IS(paramString)))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.b
 * JD-Core Version:    0.7.0.1
 */