package com.tencent.mm.plugin.taskbar;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e
{
  public static com.tencent.mm.ay.a.a.c Mnc;
  public static com.tencent.mm.ay.a.a.c Mnd;
  private static boolean Mne;
  
  static
  {
    AppMethodBeat.i(215666);
    c.a locala = new c.a();
    locala.kOg = 512;
    locala.kOf = 512;
    locala.lRG = 5;
    locala.lRD = true;
    locala.lRB = true;
    Mnc = locala.bmL();
    locala = new c.a();
    locala.kOg = 512;
    locala.kOf = 512;
    locala.lRG = 1;
    locala.lRB = true;
    Mnd = locala.bmL();
    Mne = false;
    AppMethodBeat.o(215666);
  }
  
  public static boolean aAt()
  {
    AppMethodBeat.i(215663);
    Log.d("MicroMsg.TaskBarConfig", "alvinluo isEnableNativeDynamicBackground %b, thread: %d", new Object[] { Boolean.valueOf(Mne), Long.valueOf(Thread.currentThread().getId()) });
    boolean bool = Mne;
    AppMethodBeat.o(215663);
    return bool;
  }
  
  public static void giT()
  {
    AppMethodBeat.i(215665);
    SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(215665);
      return;
    }
    boolean bool1 = localSharedPreferences.getBoolean("enable_dynamic_background_for_test", false);
    if (bool1)
    {
      Log.i("MicroMsg.TaskBarConfig", "alvinluo initEnableNativeDynamicBackground enableForTest: %b", new Object[] { Boolean.valueOf(bool1) });
      Mne = true;
      zP(true);
      com.tencent.mm.plugin.taskbar.ui.a.c.gka();
      AppMethodBeat.o(215665);
      return;
    }
    boolean bool2;
    if (q.is64BitRuntime())
    {
      bool2 = localSharedPreferences.getBoolean("enable_dynamic_background", true);
      if (((b)h.ae(b.class)).a(b.a.waw, 0) == 1)
      {
        bool1 = true;
        Log.i("MicroMsg.TaskBarConfig", "dynamicbg enable state: %b %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((!bool2) || (!bool1)) {
          break label287;
        }
        bool1 = true;
        label142:
        Mne = bool1;
        label146:
        bool2 = com.tencent.mm.plugin.taskbar.ui.a.c.gjZ();
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
          com.tencent.mm.plugin.taskbar.ui.a.c.gka();
          zP(true);
        }
      }
    }
    for (bool1 = false;; bool1 = bool2)
    {
      Log.i("MicroMsg.TaskBarConfig", "alvinluo AppBrandDesktopConfig initEnableNativeDynamicBackground: %b, willCrash: %b", new Object[] { Boolean.valueOf(Mne), Boolean.valueOf(bool1) });
      AppMethodBeat.o(215665);
      return;
      bool1 = false;
      break;
      label287:
      bool1 = false;
      break label142;
      Mne = false;
      break label146;
      label299:
      Log.i("MicroMsg.TaskBarConfig", "alvinluo disable dynamicBackground because of crash");
      zP(false);
    }
  }
  
  public static void zP(boolean paramBoolean)
  {
    AppMethodBeat.i(215664);
    Log.i("MicroMsg.TaskBarConfig", "alvinluo setEnableNativeDynamicBackground enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (Mne != paramBoolean)
    {
      SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putBoolean("enable_dynamic_background", paramBoolean).apply();
      }
    }
    Mne = paramBoolean;
    AppMethodBeat.o(215664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.e
 * JD-Core Version:    0.7.0.1
 */