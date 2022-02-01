package com.tencent.mm.ui.n.b;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/magicemoji/jsapi/MESetEasterEggStatus;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "Lcom/tencent/mm/ui/magicemoji/jsapi/IMEChattingJsApi;", "()V", "invoke", "", "env", "Lcom/tencent/mm/ui/magicemoji/core/MEChattingMgr;", "data", "Lorg/json/JSONObject;", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends p
  implements a
{
  private static final String NAME = "setEasterEggAnimationStatus";
  public static final g.a afwV;
  
  static
  {
    AppMethodBeat.i(249833);
    afwV = new g.a((byte)0);
    AppMethodBeat.o(249833);
  }
  
  public final String a(com.tencent.mm.ui.n.a.b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(249847);
    s.u(paramb, "env");
    s.u(paramJSONObject, "data");
    int j = paramJSONObject.optInt("status");
    paramJSONObject = paramJSONObject.getJSONObject("result");
    String str1 = paramJSONObject.optString("eggKey");
    String str2 = paramJSONObject.optString("eggId");
    long l2 = paramJSONObject.optLong("timeout");
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = 20000L;
    }
    if (j > 0)
    {
      s.s(str1, "eggKey");
      if (((CharSequence)str1).length() != 0) {
        break label204;
      }
      i = 1;
      if (i == 0)
      {
        s.s(str2, "eggId");
        if (((CharSequence)str2).length() != 0) {
          break label209;
        }
      }
    }
    label204:
    label209:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label214;
      }
      Log.e("MicroMsg.MESetEasterEggStatus", "stevecai: set easter egg status error: " + j + ' ' + str1 + ' ' + str2 + ' ' + l1);
      paramb = a(null, a.e.rVz, null);
      s.s(paramb, "makeReturnJson(AppBrandE…ral.INVALID_REQUEST_DATA)");
      AppMethodBeat.o(249847);
      return paramb;
      i = 0;
      break;
    }
    label214:
    s.u(str2, "eggId");
    if (!s.p(str2, paramb.afwJ.xIb)) {
      Log.w("MicroMsg.MEChattingMgr", "[MEChattingMgr]: can't send status change because " + str2 + " is not " + paramb.afwJ);
    }
    for (;;)
    {
      paramb = a(null, a.e.rVt, null);
      s.s(paramb, "makeReturnJson(AppBrandErrors.General.OK)");
      AppMethodBeat.o(249847);
      return paramb;
      Log.i("MicroMsg.MEChattingMgr", "[MEChattingMgr]: onMagicEggStatusChange: " + j + ' ' + str2);
      switch (j)
      {
      default: 
        Log.e("MicroMsg.MEChattingMgr", s.X("[MEChattingMgr]: onMagicEggStatusChange: wrong status: ", Integer.valueOf(j)));
        break;
      case 1: 
        paramb.afwN = l1;
        paramb.mHandler.postDelayed(paramb.afwM, l1);
        paramJSONObject = paramb.afwI;
        if (paramJSONObject != null) {
          paramJSONObject.a(paramb.afwJ);
        }
        break;
      case 2: 
        paramJSONObject = paramb.afwI;
        if (paramJSONObject != null) {
          paramJSONObject.b(paramb.afwJ);
        }
        break;
      case 3: 
        paramb.jBG();
      }
    }
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(249854);
    s.u(this, "this");
    AppMethodBeat.o(249854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.n.b.g
 * JD-Core Version:    0.7.0.1
 */