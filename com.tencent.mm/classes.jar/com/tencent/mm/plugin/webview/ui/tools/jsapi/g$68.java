package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

final class g$68
  implements b.b
{
  g$68(g paramg, String paramString) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return false;
  }
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, Bundle paramBundle)
  {
    AppMethodBeat.i(154989);
    if (!paramBoolean)
    {
      if ((!g.z(this.vqm)) && (!d.agR()))
      {
        g.A(this.vqm);
        if (g.j(this.vqm) != null) {
          WebViewStubTempUI.c(g.j(this.vqm), g.j(this.vqm).getString(2131300538), g.j(this.vqm).getString(2131297087), g.j(this.vqm).getString(2131300996), g.j(this.vqm).getString(2131296888), new g.68.1(this), new g.68.2(this));
        }
      }
      AppMethodBeat.o(154989);
      return true;
    }
    ab.v("MicroMsg.MsgHandler", "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    if (g.B(this.vqm) != null) {
      g.B(this.vqm).c(g.C(this.vqm));
    }
    if (g.C(this.vqm) == null)
    {
      ab.w("MicroMsg.MsgHandler", "already callback");
      AppMethodBeat.o(154989);
      return false;
    }
    g.D(this.vqm);
    HashMap localHashMap = new HashMap();
    localHashMap.put("longitude", Float.valueOf(paramFloat1));
    g.b(this.vqm, String.valueOf(paramFloat1));
    localHashMap.put("latitude", Float.valueOf(paramFloat2));
    g.c(this.vqm, String.valueOf(paramFloat2));
    localHashMap.put("speed", Double.valueOf(paramDouble1));
    localHashMap.put("accuracy", Double.valueOf(paramDouble2));
    localHashMap.put("type", this.vqY);
    if (paramBundle != null)
    {
      localHashMap.put("indoor_building_id", paramBundle.getString("indoor_building_id"));
      localHashMap.put("indoor_building_floor", paramBundle.getString("indoor_building_floor"));
      localHashMap.put("indoor_building_type", Integer.valueOf(paramBundle.getInt("indoor_building_type")));
    }
    this.vqm.a(g.k(this.vqm), "geo_location:ok", localHashMap);
    AppMethodBeat.o(154989);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.68
 * JD-Core Version:    0.7.0.1
 */