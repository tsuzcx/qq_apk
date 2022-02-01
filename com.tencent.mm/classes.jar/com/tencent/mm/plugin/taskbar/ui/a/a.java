package com.tencent.mm.plugin.taskbar.ui.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.a.c;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBackgroundConfig;", "", "()V", "BAN_FPS", "", "CURRENT_DRAW_FPS", "", "DEFAULT_DRAW_FPS", "FRAME_PER_SECOND", "HIGH_FPS", "LAST_APP_FPS", "LOWEST_DRAW_FPS", "LOW_FPS", "MIDDLE_FPS", "MONITOR_CHECK_FPS_DURATION", "", "MONITOR_LAST_CHECK_FPS_TIME", "SLEEP_TIME_IN_MS_PER_FRAME", "", "getSLEEP_TIME_IN_MS_PER_FRAME", "()F", "setSLEEP_TIME_IN_MS_PER_FRAME", "(F)V", "TAG", "lastAppFps", "lastCheckTime", "adjustDynamicBackgroundDrawFps", "", "appFps", "", "computeSleepTimePerFrame", "init", "needMonitorFps", "", "plugin-taskbar_release"})
public final class a
{
  public static int FUW;
  private static float FUX;
  public static int FUY;
  public static final a FUZ;
  private static long lastCheckTime;
  
  static
  {
    AppMethodBeat.i(238469);
    FUZ = new a();
    FUW = 20;
    FUX = 16.0F;
    lastCheckTime = -1L;
    AppMethodBeat.o(238469);
  }
  
  public static float fuY()
  {
    return FUX;
  }
  
  public static boolean fuZ()
  {
    AppMethodBeat.i(238467);
    SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
    boolean bool;
    if (localSharedPreferences != null)
    {
      long l = localSharedPreferences.getLong("monitory_last_check_time", -1L);
      if (FUY == 0) {
        FUY = localSharedPreferences.getInt("current_app_fps", 0);
      }
      Log.d("MicroMsg.DynamicBackgroundConfig", "alvinluo needMonitorFps lastAppFps: %d, lastCheckTime: %d", new Object[] { Integer.valueOf(FUY), Long.valueOf(l) });
      if ((l == -1L) || (FUY <= 45) || (System.currentTimeMillis() - l > 3600000L))
      {
        localSharedPreferences.edit().putLong("monitory_last_check_time", System.currentTimeMillis()).apply();
        bool = true;
        Log.i("MicroMsg.DynamicBackgroundConfig", "alvinluo needMonitorFps needCheck: %b", new Object[] { Boolean.valueOf(bool) });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(238467);
      return bool;
      bool = false;
      break;
      bool = false;
    }
  }
  
  public static void fva()
  {
    AppMethodBeat.i(238468);
    Object localObject = MMApplicationContext.getDefaultPreference();
    if (localObject != null) {}
    for (int i = ((SharedPreferences)localObject).getInt("current_draw_fps", 20);; i = 20)
    {
      FUW = i;
      FUX = 1000.0F / FUW - 20.0F;
      if (FUW == 2)
      {
        localObject = DynamicBackgroundGLSurfaceView.b.gRP;
        c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo updateAlphaAnimation %d", new Object[] { Long.valueOf(1500L) });
        DynamicBackgroundGLSurfaceView.b.atV();
      }
      Log.i("MicroMsg.DynamicBackgroundConfig", "alvinluo computeSleepTimePerFrame: %f, fps: %d, DEFAULT_DRAW_FPS: %d", new Object[] { Float.valueOf(FUX), Integer.valueOf(FUW), Integer.valueOf(20) });
      AppMethodBeat.o(238468);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.a.a
 * JD-Core Version:    0.7.0.1
 */