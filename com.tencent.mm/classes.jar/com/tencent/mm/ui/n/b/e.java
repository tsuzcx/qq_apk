package com.tencent.mm.ui.n.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.n.a.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/magicemoji/jsapi/MEJsApiGetMsgMeta;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "Lcom/tencent/mm/ui/magicemoji/jsapi/IMEChattingJsApi;", "()V", "invoke", "", "env", "Lcom/tencent/mm/ui/magicemoji/core/MEChattingMgr;", "data", "Lorg/json/JSONObject;", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends p
  implements a
{
  private static final String NAME = "getMsgMeta";
  public static final a afwT;
  
  static
  {
    AppMethodBeat.i(249831);
    afwT = new a((byte)0);
    AppMethodBeat.o(249831);
  }
  
  public final String a(b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(249842);
    s.u(paramb, "env");
    s.u(paramJSONObject, "data");
    long l1 = paramJSONObject.optLong("msgId", -1L);
    Object localObject = paramJSONObject.optString("ID");
    boolean bool = paramJSONObject.optBoolean("needFrame", true);
    long l2 = Util.currentTicks();
    localObject = i.a(l1, (String)localObject, "", bool, paramb.adCQ, (View)paramb.afwG);
    if (localObject != null)
    {
      if (BuildInfo.DEBUG) {
        Log.d("MicroMsg.MEGetMsgMeta", "stevecai: get msg meta " + localObject + ", using " + Util.ticksToNow(l2) + " ms");
      }
      paramb = a.e.rVt;
      paramJSONObject = new HashMap();
      paramJSONObject.put("meta", ((i)localObject).jBH());
      localObject = ah.aiuX;
      paramb = a(paramb, (Map)paramJSONObject);
      s.s(paramb, "makeReturnJson(AppBrandE…Map(true))\n            })");
      AppMethodBeat.o(249842);
      return paramb;
    }
    paramb = a(null, a.e.rVt, null);
    s.s(paramb, "makeReturnJson(AppBrandErrors.General.OK)");
    AppMethodBeat.o(249842);
    return paramb;
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(249851);
    s.u(this, "this");
    AppMethodBeat.o(249851);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/magicemoji/jsapi/MEJsApiGetMsgMeta$Companion;", "", "()V", "NAME", "", "TAG", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.n.b.e
 * JD-Core Version:    0.7.0.1
 */