package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.protocal.protobuf.lv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
{
  public static int BQ(int paramInt)
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
  
  public static void a(lv paramlv, Context paramContext, String paramString)
  {
    AppMethodBeat.i(153601);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramlv.value);
    localIntent.putExtra("geta8key_username", paramString);
    localIntent.putExtra("geta8key_scene", 59);
    com.tencent.mm.bq.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(153601);
  }
  
  public static int aW(int paramInt, String paramString)
  {
    AppMethodBeat.i(23938);
    if ((paramString != null) && (t.nU(paramString)))
    {
      AppMethodBeat.o(23938);
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
      AppMethodBeat.o(23938);
      return 0;
    case 1: 
    case 2: 
      AppMethodBeat.o(23938);
      return paramInt;
    }
    AppMethodBeat.o(23938);
    return 3;
  }
  
  public static void b(lv paramlv, Context paramContext, String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(153602);
    if (bo.isNullOrNil(paramlv.value))
    {
      ab.d("MicroMsg.NewBizInfoUtil", "jumpToWeApp serviceInfo.id:%s value is null", new Object[] { Integer.valueOf(paramlv.id) });
      AppMethodBeat.o(153602);
      return;
    }
    ab.d("MicroMsg.NewBizInfoUtil", "jumpToWeApp value:%s", new Object[] { paramlv.value });
    try
    {
      Object localObject2 = new JSONObject(paramlv.value);
      paramlv = f.rS(paramString);
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1102;
      localAppBrandStatObject.cmF = paramString;
      paramString = (j)com.tencent.mm.kernel.g.E(j.class);
      String str = ((JSONObject)localObject2).optString("userName");
      localObject2 = ((JSONObject)localObject2).optString("pagePath");
      if (paramlv == null) {}
      for (paramlv = localObject1;; paramlv = paramlv.field_appId)
      {
        paramString.a(paramContext, str, null, 0, 0, (String)localObject2, localAppBrandStatObject, paramlv);
        AppMethodBeat.o(153602);
        return;
      }
      return;
    }
    catch (JSONException paramlv)
    {
      AppMethodBeat.o(153602);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.g
 * JD-Core Version:    0.7.0.1
 */