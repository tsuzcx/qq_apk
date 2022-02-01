package com.tencent.mm.ui.n.b;

import android.graphics.RectF;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.emoji.magicemoji.view.MEHolderView;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/magicemoji/jsapi/MESetEasterEggBoundingBox;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "Lcom/tencent/mm/ui/magicemoji/jsapi/IMEChattingJsApi;", "()V", "getFloatDPFromJSONObject", "", "data", "Lorg/json/JSONObject;", "name", "", "invoke", "env", "Lcom/tencent/mm/ui/magicemoji/core/MEChattingMgr;", "retrieveRectF", "Landroid/graphics/RectF;", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends p
  implements a
{
  private static final String NAME = "setEasterEggBoundingBox";
  public static final f.a afwU;
  private static final RectF xKz;
  
  static
  {
    AppMethodBeat.i(249840);
    afwU = new f.a((byte)0);
    xKz = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    AppMethodBeat.o(249840);
  }
  
  private static float t(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(249835);
    float f = i.bW((float)paramJSONObject.optDouble(paramString));
    AppMethodBeat.o(249835);
    return f;
  }
  
  public final String a(com.tencent.mm.ui.n.a.b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(249855);
    s.u(paramb, "env");
    s.u(paramJSONObject, "data");
    Object localObject = paramJSONObject.optJSONObject("frame");
    String str;
    if (localObject == null)
    {
      localObject = xKz;
      str = paramJSONObject.optString("eggKey");
      paramJSONObject = paramJSONObject.optString("eggId");
      if (!s.p(localObject, xKz))
      {
        s.s(str, "eggKey");
        if (((CharSequence)str).length() != 0) {
          break label230;
        }
        i = 1;
        label84:
        if (i == 0)
        {
          s.s(paramJSONObject, "eggId");
          if (((CharSequence)paramJSONObject).length() != 0) {
            break label236;
          }
        }
      }
    }
    label230:
    label236:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label242;
      }
      Log.e("MicroMsg.MESetEasterEggBoundingB", "stevecai: set bounding box error: " + localObject + ' ' + str + ' ' + paramJSONObject);
      paramb = a(null, a.e.rVz, null);
      s.s(paramb, "makeReturnJson(AppBrandE…ral.INVALID_REQUEST_DATA)");
      AppMethodBeat.o(249855);
      return paramb;
      float f1 = t((JSONObject)localObject, "x");
      float f2 = t((JSONObject)localObject, "y");
      localObject = new RectF(f1, f2, t((JSONObject)localObject, "w") + f1, t((JSONObject)localObject, "h") + f2);
      break;
      i = 0;
      break label84;
    }
    label242:
    s.u(paramJSONObject, "eggId");
    s.u(localObject, "rectF");
    if (!s.p(paramJSONObject, paramb.afwJ.xIb)) {
      Log.w("MicroMsg.MEChattingMgr", "[MEChattingMgr]: can't set bbox because " + paramJSONObject + " is not " + paramb.afwJ);
    }
    for (;;)
    {
      paramb = a(null, a.e.rVt, null);
      s.s(paramb, "makeReturnJson(AppBrandErrors.General.OK)");
      AppMethodBeat.o(249855);
      return paramb;
      paramb.afwG.setBoundingBox((RectF)localObject);
      paramb.mHandler.removeCallbacks(paramb.afwL);
      paramb.mHandler.postDelayed(paramb.afwL, 300L);
    }
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(249860);
    s.u(this, "this");
    AppMethodBeat.o(249860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.n.b.f
 * JD-Core Version:    0.7.0.1
 */