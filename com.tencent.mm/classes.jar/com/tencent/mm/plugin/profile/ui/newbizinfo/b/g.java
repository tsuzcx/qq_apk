package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.protocal.protobuf.pb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
{
  public static int Ng(int paramInt)
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
  
  public static void a(pb parampb, Context paramContext, String paramString)
  {
    AppMethodBeat.i(27582);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", parampb.value);
    localIntent.putExtra("geta8key_username", paramString);
    localIntent.putExtra("geta8key_scene", 59);
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(27582);
  }
  
  public static void b(pb parampb, Context paramContext, String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(27583);
    if (bt.isNullOrNil(parampb.value))
    {
      ad.d("MicroMsg.NewBizInfoUtil", "jumpToWeApp serviceInfo.id:%s value is null", new Object[] { Integer.valueOf(parampb.id) });
      AppMethodBeat.o(27583);
      return;
    }
    ad.d("MicroMsg.NewBizInfoUtil", "jumpToWeApp value:%s", new Object[] { parampb.value });
    try
    {
      Object localObject2 = new JSONObject(parampb.value);
      parampb = com.tencent.mm.am.g.eS(paramString);
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1102;
      localAppBrandStatObject.dkh = paramString;
      paramString = (o)com.tencent.mm.kernel.g.ab(o.class);
      String str = ((JSONObject)localObject2).optString("userName");
      localObject2 = ((JSONObject)localObject2).optString("pagePath");
      if (parampb == null) {}
      for (parampb = localObject1;; parampb = parampb.field_appId)
      {
        paramString.a(paramContext, str, null, 0, 0, (String)localObject2, localAppBrandStatObject, parampb);
        AppMethodBeat.o(27583);
        return;
      }
      return;
    }
    catch (JSONException parampb)
    {
      AppMethodBeat.o(27583);
    }
  }
  
  public static int bC(int paramInt, String paramString)
  {
    AppMethodBeat.i(27584);
    if ((paramString != null) && (w.zE(paramString)))
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
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.g
 * JD-Core Version:    0.7.0.1
 */