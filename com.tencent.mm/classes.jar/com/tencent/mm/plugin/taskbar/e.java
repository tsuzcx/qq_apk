package com.tencent.mm.plugin.taskbar;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.taskbar.ui.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e
{
  private static boolean FRZ = false;
  
  public static boolean atB()
  {
    AppMethodBeat.i(238099);
    Log.d("MicroMsg.TaskBarConfig", "alvinluo isEnableNativeDynamicBackground %b, thread: %d", new Object[] { Boolean.valueOf(FRZ), Long.valueOf(Thread.currentThread().getId()) });
    boolean bool = FRZ;
    AppMethodBeat.o(238099);
    return bool;
  }
  
  public static void fur()
  {
    AppMethodBeat.i(238101);
    SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(238101);
      return;
    }
    boolean bool1 = localSharedPreferences.getBoolean("enable_dynamic_background_for_test", false);
    if (bool1)
    {
      Log.i("MicroMsg.TaskBarConfig", "alvinluo initEnableNativeDynamicBackground enableForTest: %b", new Object[] { Boolean.valueOf(bool1) });
      FRZ = true;
      wj(true);
      c.fvc();
      AppMethodBeat.o(238101);
      return;
    }
    boolean bool2 = localSharedPreferences.getBoolean("enable_dynamic_background", true);
    if (((b)g.af(b.class)).a(b.a.RbQ, 0) == 1)
    {
      bool1 = true;
      Log.i("MicroMsg.TaskBarConfig", "dynamicbg enable state: %b %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((!bool2) || (!bool1)) {
        break label281;
      }
      bool1 = true;
      label136:
      FRZ = bool1;
      bool2 = c.fvb();
      bool1 = bool2;
      if (bool2)
      {
        int i = localSharedPreferences.getInt("dynamic_background_version", -1);
        Log.i("MicroMsg.TaskBarConfig", "alvinluo localVersion %d, currentVersion: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
        if (i == 1) {
          break label286;
        }
        Log.i("MicroMsg.TaskBarConfig", "alvinluo ignore crash because of new version", new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
        localSharedPreferences.edit().putInt("dynamic_background_version", 1).apply();
        c.fvc();
        wj(true);
      }
    }
    for (bool1 = false;; bool1 = bool2)
    {
      Log.i("MicroMsg.TaskBarConfig", "alvinluo AppBrandDesktopConfig initEnableNativeDynamicBackground: %b, willCrash: %b", new Object[] { Boolean.valueOf(FRZ), Boolean.valueOf(bool1) });
      AppMethodBeat.o(238101);
      return;
      bool1 = false;
      break;
      label281:
      bool1 = false;
      break label136;
      label286:
      Log.i("MicroMsg.TaskBarConfig", "alvinluo disable dynamicBackground because of crash");
      wj(false);
    }
  }
  
  public static void wj(boolean paramBoolean)
  {
    AppMethodBeat.i(238100);
    Log.i("MicroMsg.TaskBarConfig", "alvinluo setEnableNativeDynamicBackground enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (FRZ != paramBoolean)
    {
      SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putBoolean("enable_dynamic_background", paramBoolean).apply();
      }
    }
    FRZ = paramBoolean;
    AppMethodBeat.o(238100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.e
 * JD-Core Version:    0.7.0.1
 */