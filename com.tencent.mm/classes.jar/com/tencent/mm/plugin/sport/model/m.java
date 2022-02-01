package com.tencent.mm.plugin.sport.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sport/model/SportKtUtil;", "", "()V", "Companion", "plugin-sport_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final a SbZ;
  private static Boolean Sca;
  private static Boolean Scb;
  
  static
  {
    AppMethodBeat.i(263909);
    SbZ = new a((byte)0);
    AppMethodBeat.o(263909);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sport/model/SportKtUtil$Companion;", "", "()V", "TAG", "", "hasDefaultSensor", "", "Ljava/lang/Boolean;", "hasSystemFeature", "checkDeviceSupportSport", "context", "Landroid/content/Context;", "plugin-sport_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean jX(Context paramContext)
    {
      AppMethodBeat.i(263903);
      s.u(paramContext, "context");
      if (d.rc(19))
      {
        Log.i("MicroMsg.Sport.SportKtUtil", "Not Support SDK VERSION");
        AppMethodBeat.o(263903);
        return false;
      }
      if (m.hup() == null) {
        m.E(Boolean.valueOf(paramContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")));
      }
      if (!s.p(m.hup(), Boolean.TRUE))
      {
        Log.i("MicroMsg.Sport.SportKtUtil", "Not Support FEATURE_SENSOR_STEP_COUNTER");
        AppMethodBeat.o(263903);
        return false;
      }
      try
      {
        if (m.huq() != null) {
          break label152;
        }
        paramContext = MMApplicationContext.getContext().getSystemService("sensor");
        if (paramContext == null)
        {
          paramContext = new NullPointerException("null cannot be cast to non-null type android.hardware.SensorManager");
          AppMethodBeat.o(263903);
          throw paramContext;
        }
      }
      catch (Exception paramContext)
      {
        Log.i("MicroMsg.Sport.SportKtUtil", "Not Support can not get sensor Exception");
        AppMethodBeat.o(263903);
        return false;
      }
      if (((SensorManager)paramContext).getDefaultSensor(19) != null) {}
      for (boolean bool = true;; bool = false)
      {
        m.F(Boolean.valueOf(bool));
        label152:
        if (s.p(m.huq(), Boolean.TRUE)) {
          break;
        }
        Log.i("MicroMsg.Sport.SportKtUtil", "Not Support can not get sensor");
        AppMethodBeat.o(263903);
        return false;
      }
      if (k.huj().optInt("deviceStepSwitch") != 1)
      {
        Log.i("MicroMsg.Sport.SportKtUtil", "Not Support deviceStepSwitch is off");
        AppMethodBeat.o(263903);
        return false;
      }
      AppMethodBeat.o(263903);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.m
 * JD-Core Version:    0.7.0.1
 */