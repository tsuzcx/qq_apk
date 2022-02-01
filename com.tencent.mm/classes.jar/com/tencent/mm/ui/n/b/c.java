package com.tencent.mm.ui.n.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.emoji.magicemoji.view.MEHolderView;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.n.a.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/magicemoji/jsapi/MEGetSystemInfo;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "Lcom/tencent/mm/ui/magicemoji/jsapi/IMEChattingJsApi;", "()V", "fontSize", "", "getFontSize", "invoke", "", "env", "Lcom/tencent/mm/ui/magicemoji/core/MEChattingMgr;", "data", "Lorg/json/JSONObject;", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends p
  implements a
{
  private static final String NAME = "getSystemInfo";
  public static final a afwR;
  private int fontSize;
  
  static
  {
    AppMethodBeat.i(249843);
    afwR = new a((byte)0);
    AppMethodBeat.o(249843);
  }
  
  private final int getFontSize()
  {
    float f1 = 1.0F;
    AppMethodBeat.i(249837);
    if (this.fontSize >= 0)
    {
      i = this.fontSize;
      AppMethodBeat.o(249837);
      return i;
    }
    try
    {
      float f2 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 4).getFloat("text_size_scale_key", 1.0F);
      f1 = f2;
    }
    catch (Exception localException)
    {
      label47:
      break label47;
    }
    int i = kotlin.h.a.eH(f1 * 16.0F);
    AppMethodBeat.o(249837);
    return i;
  }
  
  public final String a(b paramb, JSONObject paramJSONObject)
  {
    int j = 1;
    AppMethodBeat.i(249859);
    s.u(paramb, "env");
    s.u(paramJSONObject, "data");
    Object localObject1 = paramb.adCQ;
    paramb = paramb.afwG;
    paramJSONObject = new HashMap();
    Object localObject2 = (Map)paramJSONObject;
    String str = Build.BRAND;
    s.s(str, "BRAND");
    ((Map)localObject2).put("brand", str);
    localObject2 = (Map)paramJSONObject;
    str = q.aPo();
    s.s(str, "getModel()");
    ((Map)localObject2).put("model", str);
    localObject2 = (Map)paramJSONObject;
    str = Build.CPU_ABI;
    s.s(str, "CPU_ABI");
    ((Map)localObject2).put("abi", str);
    localObject2 = (Map)paramJSONObject;
    str = Build.VERSION.RELEASE;
    s.s(str, "RELEASE");
    ((Map)localObject2).put("system", str);
    int i;
    if (paramb.getWidth() > 0)
    {
      i = paramb.getWidth();
      if (paramb.getHeight() > 0) {
        j = paramb.getHeight();
      }
      ((Map)paramJSONObject).put("windowWidth", Integer.valueOf(i.DA(i)));
      ((Map)paramJSONObject).put("windowHeight", Integer.valueOf(i.DA(j)));
      ((Map)paramJSONObject).put("pixelRatio", Float.valueOf(i.mn()));
      ((Map)paramJSONObject).put("screenWidth", Integer.valueOf(i.DA(i)));
      ((Map)paramJSONObject).put("screenHeight", Integer.valueOf(i.DA(j)));
      paramb = (Map)paramJSONObject;
      localObject2 = LocaleUtil.getCurrentLanguage((Context)((com.tencent.mm.ui.chatting.d.a)localObject1).aezO.getContext());
      s.s(localObject2, "getCurrentLanguage(context.context)");
      paramb.put("language", localObject2);
      paramb = (Map)paramJSONObject;
      localObject2 = ChannelUtil.formatVersion(null, BuildInfo.CLIENT_VERSION_INT);
      s.s(localObject2, "formatVersion(null, BuildInfo.CLIENT_VERSION_INT)");
      paramb.put("version", localObject2);
      ((Map)paramJSONObject).put("benchmarkLevel", Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("ClientBenchmarkLevel", -1)));
      i = ((com.tencent.mm.ui.chatting.d.a)localObject1).aezO.getMMResources().getConfiguration().orientation;
      localObject1 = (Map)paramJSONObject;
      if (2 != i) {
        break label478;
      }
    }
    label478:
    for (paramb = "landscape";; paramb = "portrait")
    {
      ((Map)localObject1).put("deviceOrientation", paramb);
      ((Map)paramJSONObject).put("fontSizeSetting", Integer.valueOf(getFontSize()));
      paramb = a(a.e.rVt, (Map)paramJSONObject);
      s.s(paramb, "makeReturnJson(AppBrandErrors.General.OK, jMap)");
      AppMethodBeat.o(249859);
      return paramb;
      i = 1;
      break;
    }
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(249864);
    s.u(this, "this");
    AppMethodBeat.o(249864);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/magicemoji/jsapi/MEGetSystemInfo$Companion;", "", "()V", "NAME", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.n.b.c
 * JD-Core Version:    0.7.0.1
 */