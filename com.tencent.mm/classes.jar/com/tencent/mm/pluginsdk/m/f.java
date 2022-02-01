package com.tencent.mm.pluginsdk.m;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/tools/VibrateUtils;", "", "()V", "Companion", "app_release"})
public final class f
{
  private static final int PBD = -1;
  private static final int PBE = -2;
  private static final int PBF = 1;
  private static final int PBG = 2;
  private static final int PBH = 3;
  public static final a Rbq;
  private static final String TAG = "MicroMsg.WebSearch.WebSearchUtils";
  
  static
  {
    AppMethodBeat.i(291782);
    Rbq = new a((byte)0);
    TAG = "MicroMsg.WebSearch.WebSearchUtils";
    PBD = -1;
    PBE = -2;
    PBF = 1;
    PBG = 2;
    PBH = 3;
    AppMethodBeat.o(291782);
  }
  
  public static final boolean hiY()
  {
    AppMethodBeat.i(291785);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style", "medium");
    boolean bool = a.bjd(localJSONObject.toString());
    AppMethodBeat.o(291785);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/tools/VibrateUtils$Companion;", "", "()V", "TAG", "", "VIBRATION_INTENSITY_DEFAULT", "", "VIBRATION_INTENSITY_ERROR", "VIBRATION_INTENSITY_HIGH", "VIBRATION_INTENSITY_LOW", "VIBRATION_INTENSITY_MEDIUM", "commonVibrate", "", "vibrateShort", "params", "app_release"})
  public static final class a
  {
    public static boolean bjd(String paramString)
    {
      long l = 50L;
      AppMethodBeat.i(276678);
      Log.i(f.access$getTAG$cp(), "vibrateShort , type = ".concat(String.valueOf(paramString)));
      try
      {
        paramString = new JSONObject(paramString);
        localObject = MMApplicationContext.getContext().getSystemService("vibrator");
        if (localObject == null)
        {
          paramString = new t("null cannot be cast to non-null type android.os.Vibrator");
          AppMethodBeat.o(276678);
          throw paramString;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace(f.access$getTAG$cp(), (Throwable)paramString, "vibrateShort", new Object[0]);
        AppMethodBeat.o(276678);
        return false;
      }
      Object localObject = (Vibrator)localObject;
      paramString = paramString.get("style");
      int i = f.gRE();
      if (p.h(paramString, "light")) {
        i = f.gRF();
      }
      while (f.gRI() == i)
      {
        ((Vibrator)localObject).vibrate(50L);
        AppMethodBeat.o(276678);
        return true;
        if (p.h(paramString, "medium")) {
          i = f.gRG();
        } else if (p.h(paramString, "heavy")) {
          i = f.gRH();
        }
      }
      if (f.gRE() == i)
      {
        ((Vibrator)localObject).vibrate(50L);
        AppMethodBeat.o(276678);
        return true;
      }
      if ((Build.VERSION.SDK_INT >= 26) && (((Vibrator)localObject).hasAmplitudeControl())) {
        if (i == f.gRF())
        {
          i = 128;
          l = 15L;
        }
      }
      for (;;)
      {
        if (-1 != i) {
          ((Vibrator)localObject).vibrate(VibrationEffect.createOneShot(l, i));
        }
        for (;;)
        {
          AppMethodBeat.o(276678);
          return true;
          if (i == f.gRG())
          {
            i = 192;
            break;
          }
          if (i != f.gRH()) {
            break label292;
          }
          i = 255;
          l = 85L;
          break;
          ((Vibrator)localObject).vibrate(50L);
        }
        label292:
        l = 0L;
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.m.f
 * JD-Core Version:    0.7.0.1
 */