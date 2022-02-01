package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.plugin.webview.luggage.LuggageStubUI;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class s
  extends bw<g>
{
  private static final HashSet<String> WIH;
  private String PUw;
  private bv.a WIF;
  private boolean WIG;
  private b.b WII;
  private MMHandler WIJ;
  private boolean WIK;
  private BroadcastReceiver WIL;
  private d lsy;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(296050);
    HashSet localHashSet = new HashSet();
    WIH = localHashSet;
    localHashSet.add("gcj02");
    WIH.add("wgs84");
    AppMethodBeat.o(296050);
  }
  
  public s()
  {
    AppMethodBeat.i(296035);
    this.WIG = false;
    this.lsy = null;
    this.WII = null;
    this.WIK = false;
    this.WIL = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(296067);
        if ((paramAnonymousIntent != null) && ("com.tencent.mm.ACTION_LOCATION_FROM_JSAPI".equals(paramAnonymousIntent.getAction())) && (paramAnonymousIntent.getIntExtra("key_permission_request_code", 0) == 75))
        {
          int i = paramAnonymousIntent.getIntExtra("key_result_code", 0);
          Log.d("MicroMsg.JsApiGeoLocation", "locationReceiver, resultCode:%d", new Object[] { Integer.valueOf(i) });
          if (i == -1)
          {
            s.a(s.this, s.a(s.this));
            AppMethodBeat.o(296067);
            return;
          }
          s.a(s.this, s.a(s.this), "fail");
        }
        AppMethodBeat.o(296067);
      }
    };
    AppMethodBeat.o(296035);
  }
  
  private void a(bv.a parama)
  {
    AppMethodBeat.i(296037);
    Log.v("MicroMsg.JsApiGeoLocation", "doGeoLocation, geoType = %s", new Object[] { this.PUw });
    if ((!Util.isNullOrNil(this.PUw)) && (!WIH.contains(this.PUw)))
    {
      Log.e("MicroMsg.JsApiGeoLocation", "doGeoLocation fail, unsupported type = %s", new Object[] { this.PUw });
      a(parama, "unsupported_type");
      AppMethodBeat.o(296037);
      return;
    }
    this.lsy = d.bJl();
    a(this.PUw, parama);
    AppMethodBeat.o(296037);
  }
  
  private void a(bv.a parama, String paramString)
  {
    try
    {
      AppMethodBeat.i(296040);
      this.mContext.unregisterReceiver(this.WIL);
      if ((this.lsy != null) && (this.WII != null)) {
        this.lsy.a(this.WII);
      }
      if (this.WIJ != null) {
        this.WIJ.removeCallbacksAndMessages(null);
      }
      this.WII = null;
      if (!this.WIG)
      {
        this.WIG = true;
        parama.j(paramString, null);
      }
      AppMethodBeat.o(296040);
      return;
    }
    finally {}
  }
  
  private void a(bv.a parama, JSONObject paramJSONObject)
  {
    try
    {
      AppMethodBeat.i(296041);
      this.mContext.unregisterReceiver(this.WIL);
      if ((this.lsy != null) && (this.WII != null)) {
        this.lsy.a(this.WII);
      }
      if (this.WIJ != null) {
        this.WIJ.removeCallbacksAndMessages(null);
      }
      this.WII = null;
      if (!this.WIG)
      {
        this.WIG = true;
        parama.j(null, paramJSONObject);
      }
      AppMethodBeat.o(296041);
      return;
    }
    finally {}
  }
  
  private void a(final String paramString, final bv.a parama)
  {
    AppMethodBeat.i(296039);
    if (this.WIK)
    {
      AppMethodBeat.o(296039);
      return;
    }
    Log.i("MicroMsg.JsApiGeoLocation", "startGeoLocation");
    if (this.WII == null) {
      this.WII = new b.b()
      {
        public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(296069);
          Log.v("MicroMsg.JsApiGeoLocation", "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Integer.valueOf(paramAnonymousInt), Double.valueOf(paramAnonymousDouble1), Double.valueOf(paramAnonymousDouble2) });
          if (!paramAnonymousBoolean)
          {
            s.a(s.this, parama, "location_error");
            AppMethodBeat.o(296069);
            return true;
          }
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("longitude", paramAnonymousFloat1);
            localJSONObject.put("latitude", paramAnonymousFloat2);
            localJSONObject.put("speed", paramAnonymousDouble1);
            localJSONObject.put("accuracy", paramAnonymousDouble2);
            localJSONObject.put("type", paramString);
            if (paramAnonymousBundle != null)
            {
              localJSONObject.put("indoor_building_id", paramAnonymousBundle.getString("indoor_building_id"));
              localJSONObject.put("indoor_building_floor", paramAnonymousBundle.getString("indoor_building_floor"));
              localJSONObject.put("indoor_building_type", paramAnonymousBundle.getInt("indoor_building_type"));
            }
          }
          catch (JSONException paramAnonymousBundle)
          {
            label189:
            break label189;
          }
          s.a(s.this, parama, localJSONObject);
          AppMethodBeat.o(296069);
          return false;
        }
        
        public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
        {
          return false;
        }
      };
    }
    if (this.WIJ == null) {
      this.WIJ = new MMHandler(Looper.getMainLooper());
    }
    this.WIJ.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(296068);
        s.a(s.this, parama, "timeout");
        AppMethodBeat.o(296068);
      }
    }, 20000L);
    if ((Util.isNullOrNil(paramString)) || (paramString.equalsIgnoreCase("gcj02")))
    {
      this.WIK = true;
      this.lsy.a(this.WII, false);
      l.kK(22, 10);
      AppMethodBeat.o(296039);
      return;
    }
    if (paramString.equalsIgnoreCase("wgs84"))
    {
      this.WIK = true;
      this.lsy.a(this.WII, false, true);
      l.kK(22, 10);
      AppMethodBeat.o(296039);
      return;
    }
    Log.e("MicroMsg.JsApiGeoLocation", "startGeoLocation, should not reach here !!!!!");
    a(parama, "fail_unsupported_type_startgeo");
    AppMethodBeat.o(296039);
  }
  
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(296053);
    this.mContext = paramContext;
    this.WIF = parama;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mm.ACTION_LOCATION_FROM_JSAPI");
    paramContext.registerReceiver(this.WIL, localIntentFilter, WeChatPermissions.PERMISSION_MM_MESSAGE(), null);
    paramString = c.ZL(paramString);
    if (paramString != null) {
      this.PUw = paramString.optString("type");
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.s(paramContext, "android.permission.ACCESS_FINE_LOCATION");
    Log.i("MicroMsg.JsApiGeoLocation", "location perm: %s", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      if (!LuggageStubUI.f(paramContext, new String[] { "android.permission.ACCESS_FINE_LOCATION" })) {
        a(parama, "fail");
      }
      AppMethodBeat.o(296053);
      return;
    }
    a(parama);
    AppMethodBeat.o(296053);
  }
  
  public final void b(com.tencent.luggage.d.b<g>.a paramb) {}
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "geoLocation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.s
 * JD-Core Version:    0.7.0.1
 */