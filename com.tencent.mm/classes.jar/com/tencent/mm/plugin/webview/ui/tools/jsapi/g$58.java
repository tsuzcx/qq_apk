package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.modelgeo.a.b;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class g$58
  implements a.b
{
  g$58(g paramg, String paramString) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return false;
  }
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, Bundle paramBundle)
  {
    if (!paramBoolean) {
      return true;
    }
    y.v("MicroMsg.MsgHandler", "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    if (g.x(this.rzi) != null) {
      g.x(this.rzi).c(g.y(this.rzi));
    }
    if (g.y(this.rzi) == null)
    {
      y.w("MicroMsg.MsgHandler", "already callback");
      return false;
    }
    g.z(this.rzi);
    HashMap localHashMap = new HashMap();
    localHashMap.put("longitude", Float.valueOf(paramFloat1));
    g.b(this.rzi, String.valueOf(paramFloat1));
    localHashMap.put("latitude", Float.valueOf(paramFloat2));
    g.c(this.rzi, String.valueOf(paramFloat2));
    localHashMap.put("speed", Double.valueOf(paramDouble1));
    localHashMap.put("accuracy", Double.valueOf(paramDouble2));
    localHashMap.put("type", this.rzU);
    if (paramBundle != null)
    {
      localHashMap.put("indoor_building_id", paramBundle.getString("indoor_building_id"));
      localHashMap.put("indoor_building_floor", paramBundle.getString("indoor_building_floor"));
      localHashMap.put("indoor_building_type", Integer.valueOf(paramBundle.getInt("indoor_building_type")));
    }
    g.a(this.rzi, g.j(this.rzi), "geo_location:ok", localHashMap);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.58
 * JD-Core Version:    0.7.0.1
 */