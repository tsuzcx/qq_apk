package com.tencent.mm.plugin.taskbar.ui.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.a.c;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBackgroundConfig;", "", "()V", "BAN_FPS", "", "CURRENT_DRAW_FPS", "", "DEFAULT_DRAW_FPS", "FRAME_PER_SECOND", "HIGH_FPS", "LAST_APP_FPS", "LOWEST_DRAW_FPS", "LOW_FPS", "MIDDLE_FPS", "MONITOR_CHECK_FPS_DURATION", "", "MONITOR_LAST_CHECK_FPS_TIME", "SLEEP_TIME_IN_MS_PER_FRAME", "", "getSLEEP_TIME_IN_MS_PER_FRAME", "()F", "setSLEEP_TIME_IN_MS_PER_FRAME", "(F)V", "TAG", "lastAppFps", "lastCheckTime", "adjustDynamicBackgroundDrawFps", "", "appFps", "", "computeSleepTimePerFrame", "init", "needMonitorFps", "", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a STE;
  public static int STF;
  private static float STG;
  public static int STH;
  private static long lastCheckTime;
  
  static
  {
    AppMethodBeat.i(264163);
    STE = new a();
    STF = 20;
    STG = 16.0F;
    lastCheckTime = -1L;
    AppMethodBeat.o(264163);
  }
  
  public static float hDW()
  {
    return STG;
  }
  
  public static boolean hDX()
  {
    AppMethodBeat.i(264143);
    SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
    boolean bool;
    if (localSharedPreferences != null)
    {
      long l = localSharedPreferences.getLong("monitory_last_check_time", -1L);
      if (STH == 0) {
        STH = localSharedPreferences.getInt("current_app_fps", 0);
      }
      Log.d("MicroMsg.DynamicBackgroundConfig", "alvinluo needMonitorFps lastAppFps: %d, lastCheckTime: %d", new Object[] { Integer.valueOf(STH), Long.valueOf(l) });
      if ((l == -1L) || (STH <= 45) || (System.currentTimeMillis() - l > 3600000L))
      {
        localSharedPreferences.edit().putLong("monitory_last_check_time", System.currentTimeMillis()).apply();
        bool = true;
        Log.i("MicroMsg.DynamicBackgroundConfig", "alvinluo needMonitorFps needCheck: %b", new Object[] { Boolean.valueOf(bool) });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(264143);
      return bool;
      bool = false;
      break;
      bool = false;
    }
  }
  
  public static void hDY()
  {
    AppMethodBeat.i(264154);
    Object localObject = MMApplicationContext.getDefaultPreference();
    if (localObject == null) {}
    for (int i = 20;; i = ((SharedPreferences)localObject).getInt("current_draw_fps", 20))
    {
      STF = i;
      STG = 1000.0F / STF - 20.0F;
      if (STF == 2)
      {
        localObject = DynamicBackgroundGLSurfaceView.b.mbY;
        c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo updateAlphaAnimation %d", new Object[] { Long.valueOf(1500L) });
        DynamicBackgroundGLSurfaceView.b.aTK();
      }
      Log.i("MicroMsg.DynamicBackgroundConfig", "alvinluo computeSleepTimePerFrame: %f, fps: %d, DEFAULT_DRAW_FPS: %d", new Object[] { Float.valueOf(STG), Integer.valueOf(STF), Integer.valueOf(20) });
      AppMethodBeat.o(264154);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.a.a
 * JD-Core Version:    0.7.0.1
 */