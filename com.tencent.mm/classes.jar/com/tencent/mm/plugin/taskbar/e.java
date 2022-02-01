package com.tencent.mm.plugin.taskbar;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e
{
  public static com.tencent.mm.modelimage.loader.a.c SQv;
  public static com.tencent.mm.modelimage.loader.a.c SQw;
  private static boolean SQx;
  
  static
  {
    AppMethodBeat.i(263993);
    com.tencent.mm.modelimage.loader.a.c.a locala = new com.tencent.mm.modelimage.loader.a.c.a();
    locala.npV = 512;
    locala.npU = 512;
    locala.oKs = 5;
    locala.oKp = true;
    locala.oKn = true;
    SQv = locala.bKx();
    locala = new com.tencent.mm.modelimage.loader.a.c.a();
    locala.npV = 512;
    locala.npU = 512;
    locala.oKs = 1;
    locala.oKn = true;
    SQw = locala.bKx();
    SQx = false;
    AppMethodBeat.o(263993);
  }
  
  public static void Fg(boolean paramBoolean)
  {
    AppMethodBeat.i(263974);
    Log.i("MicroMsg.TaskBarConfig", "alvinluo setEnableNativeDynamicBackground enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (SQx != paramBoolean)
    {
      SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putBoolean("enable_dynamic_background", paramBoolean).apply();
      }
    }
    SQx = paramBoolean;
    AppMethodBeat.o(263974);
  }
  
  public static boolean aTo()
  {
    AppMethodBeat.i(263969);
    Log.d("MicroMsg.TaskBarConfig", "alvinluo isEnableNativeDynamicBackground %b, thread: %d", new Object[] { Boolean.valueOf(SQx), Long.valueOf(Thread.currentThread().getId()) });
    boolean bool = SQx;
    AppMethodBeat.o(263969);
    return bool;
  }
  
  public static void hCT()
  {
    AppMethodBeat.i(263987);
    SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(263987);
      return;
    }
    boolean bool1 = localSharedPreferences.getBoolean("enable_dynamic_background_for_test", false);
    if (bool1)
    {
      Log.i("MicroMsg.TaskBarConfig", "alvinluo initEnableNativeDynamicBackground enableForTest: %b", new Object[] { Boolean.valueOf(bool1) });
      SQx = true;
      Fg(true);
      com.tencent.mm.plugin.taskbar.ui.a.c.hEa();
      AppMethodBeat.o(263987);
      return;
    }
    boolean bool2;
    if (q.awm())
    {
      bool2 = localSharedPreferences.getBoolean("enable_dynamic_background", true);
      if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ztY, 1) == 1)
      {
        bool1 = true;
        Log.i("MicroMsg.TaskBarConfig", "dynamicbg enable state: %b %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((!bool2) || (!bool1)) {
          break label287;
        }
        bool1 = true;
        label142:
        SQx = bool1;
        label146:
        bool2 = com.tencent.mm.plugin.taskbar.ui.a.c.hDZ();
        bool1 = bool2;
        if (bool2)
        {
          int i = localSharedPreferences.getInt("dynamic_background_version", -1);
          Log.i("MicroMsg.TaskBarConfig", "alvinluo localVersion %d, currentVersion: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
          if (i == 1) {
            break label299;
          }
          Log.i("MicroMsg.TaskBarConfig", "alvinluo ignore crash because of new version", new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
          localSharedPreferences.edit().putInt("dynamic_background_version", 1).apply();
          com.tencent.mm.plugin.taskbar.ui.a.c.hEa();
          Fg(true);
        }
      }
    }
    for (bool1 = false;; bool1 = bool2)
    {
      Log.i("MicroMsg.TaskBarConfig", "alvinluo AppBrandDesktopConfig initEnableNativeDynamicBackground: %b, willCrash: %b", new Object[] { Boolean.valueOf(SQx), Boolean.valueOf(bool1) });
      AppMethodBeat.o(263987);
      return;
      bool1 = false;
      break;
      label287:
      bool1 = false;
      break label142;
      SQx = false;
      break label146;
      label299:
      Log.i("MicroMsg.TaskBarConfig", "alvinluo disable dynamicBackground because of crash");
      Fg(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.e
 * JD-Core Version:    0.7.0.1
 */