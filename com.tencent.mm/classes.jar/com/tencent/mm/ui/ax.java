package com.tencent.mm.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/VibrateUtils;", "", "()V", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ax
{
  private static final String TAG;
  private static final int Wsj;
  private static final int Wsk;
  private static final int Wsl;
  private static final int Wsm;
  private static final int Wsn;
  public static final a adKR;
  
  static
  {
    AppMethodBeat.i(249367);
    adKR = new a((byte)0);
    TAG = "MicroMsg.WebSearch.WebSearchUtils";
    Wsj = -1;
    Wsk = -2;
    Wsl = 1;
    Wsm = 2;
    Wsn = 3;
    AppMethodBeat.o(249367);
  }
  
  public static final boolean jlo()
  {
    AppMethodBeat.i(249347);
    boolean bool = a.jlo();
    AppMethodBeat.o(249347);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/VibrateUtils$Companion;", "", "()V", "TAG", "", "VIBRATION_INTENSITY_DEFAULT", "", "VIBRATION_INTENSITY_ERROR", "VIBRATION_INTENSITY_HIGH", "VIBRATION_INTENSITY_LOW", "VIBRATION_INTENSITY_MEDIUM", "commonVibrate", "", "vibrateShort", "params", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static boolean biO(String paramString)
    {
      long l = 50L;
      AppMethodBeat.i(249459);
      Log.i(ax.access$getTAG$cp(), s.X("vibrateShort , type = ", paramString));
      try
      {
        paramString = new JSONObject(paramString);
        localObject = MMApplicationContext.getContext().getSystemService("vibrator");
        if (localObject == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
          AppMethodBeat.o(249459);
          throw paramString;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace(ax.access$getTAG$cp(), (Throwable)paramString, "vibrateShort", new Object[0]);
        AppMethodBeat.o(249459);
        return false;
      }
      Object localObject = (Vibrator)localObject;
      paramString = paramString.get("style");
      int i = ax.iqV();
      if (s.p(paramString, "light")) {
        i = ax.iqW();
      }
      while (ax.iqZ() == i)
      {
        ((Vibrator)localObject).vibrate(50L);
        AppMethodBeat.o(249459);
        return true;
        if (s.p(paramString, "medium")) {
          i = ax.iqX();
        } else if (s.p(paramString, "heavy")) {
          i = ax.iqY();
        }
      }
      if (ax.iqV() == i)
      {
        ((Vibrator)localObject).vibrate(50L);
        AppMethodBeat.o(249459);
        return true;
      }
      if ((Build.VERSION.SDK_INT >= 26) && (((Vibrator)localObject).hasAmplitudeControl())) {
        if (i == ax.iqW())
        {
          i = 128;
          l = 15L;
        }
      }
      for (;;)
      {
        if (-1 == i) {
          ((Vibrator)localObject).vibrate(l);
        }
        for (;;)
        {
          AppMethodBeat.o(249459);
          return true;
          if (i == ax.iqX())
          {
            i = 192;
            break;
          }
          if (i != ax.iqY()) {
            break label298;
          }
          i = 255;
          l = 85L;
          break;
          ((Vibrator)localObject).vibrate(VibrationEffect.createOneShot(l, i));
          continue;
          ((Vibrator)localObject).vibrate(50L);
        }
        label298:
        i = -1;
      }
    }
    
    public static boolean jlo()
    {
      AppMethodBeat.i(249463);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("style", "medium");
      boolean bool = biO(localJSONObject.toString());
      AppMethodBeat.o(249463);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ax
 * JD-Core Version:    0.7.0.1
 */