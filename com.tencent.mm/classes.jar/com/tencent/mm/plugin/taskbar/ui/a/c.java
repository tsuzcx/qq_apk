package com.tencent.mm.plugin.taskbar.ui.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
{
  private static boolean FVb;
  private static boolean FVc;
  private static boolean FVd;
  private static SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(238312);
    sp = MMApplicationContext.getDefaultPreference();
    FVb = false;
    FVc = false;
    FVd = true;
    AppMethodBeat.o(238312);
  }
  
  public static void atF()
  {
    AppMethodBeat.i(238307);
    Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markWillCrash");
    if (sp == null) {
      sp = MMApplicationContext.getDefaultPreference();
    }
    if (sp != null)
    {
      e.wj(false);
      sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
    }
    FVb = true;
    AppMethodBeat.o(238307);
  }
  
  public static boolean atI()
  {
    return FVc;
  }
  
  public static boolean atJ()
  {
    return FVd;
  }
  
  public static void atK()
  {
    AppMethodBeat.i(238310);
    if (sp == null) {
      sp = MMApplicationContext.getDefaultPreference();
    }
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_draw_start_point_count", 0);
      Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawStartPoint current: %d", new Object[] { Integer.valueOf(i) });
      if (i > 2)
      {
        e.wj(false);
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
      }
      sp.edit().putInt("dynamic_bg_draw_start_point_count", i + 1).apply();
    }
    AppMethodBeat.o(238310);
  }
  
  public static void atL()
  {
    AppMethodBeat.i(238311);
    Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawEndPoint");
    sp.edit().putInt("dynamic_bg_draw_start_point_count", 0).apply();
    sp.edit().putBoolean("dynamic_bg_will_crash", false).apply();
    e.wj(true);
    FVd = false;
    AppMethodBeat.o(238311);
  }
  
  public static boolean fvb()
  {
    AppMethodBeat.i(238304);
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_init_start_point_count", 0);
      int j = sp.getInt("dynamic_bg_draw_start_point_count", 0);
      boolean bool = sp.getBoolean("dynamic_bg_init_crash", false);
      FVc = bool;
      if ((bool) || (i >= 2) || (j >= 2))
      {
        FVb = true;
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
        AppMethodBeat.o(238304);
        return true;
      }
      FVb = false;
      AppMethodBeat.o(238304);
      return false;
    }
    AppMethodBeat.o(238304);
    return false;
  }
  
  public static void fvc()
  {
    AppMethodBeat.i(238305);
    if (sp != null)
    {
      SharedPreferences.Editor localEditor = sp.edit();
      if (localEditor != null)
      {
        localEditor.putInt("dynamic_bg_init_start_point_count", 0);
        localEditor.putInt("dynamic_bg_draw_start_point_count", 0);
        localEditor.putBoolean("dynamic_bg_init_crash", false);
        localEditor.putBoolean("dynamic_bg_will_crash", false);
        localEditor.apply();
      }
    }
    FVc = false;
    FVb = false;
    AppMethodBeat.o(238305);
  }
  
  public static void fvd()
  {
    AppMethodBeat.i(238306);
    Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitCrash");
    e.wj(false);
    if (sp == null) {
      sp = MMApplicationContext.getDefaultPreference();
    }
    if (sp != null) {
      sp.edit().putBoolean("dynamic_bg_init_crash", true).apply();
    }
    FVc = true;
    AppMethodBeat.o(238306);
  }
  
  public static void fve()
  {
    AppMethodBeat.i(238308);
    if (sp == null) {
      sp = MMApplicationContext.getDefaultPreference();
    }
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_init_start_point_count", 0);
      Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitStartPoint current: %d", new Object[] { Integer.valueOf(i) });
      if (i > 2)
      {
        e.wj(false);
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
      }
      sp.edit().putInt("dynamic_bg_init_start_point_count", i + 1).apply();
    }
    AppMethodBeat.o(238308);
  }
  
  public static void fvf()
  {
    AppMethodBeat.i(238309);
    Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitEndPoint");
    sp.edit().putInt("dynamic_bg_init_start_point_count", 0).apply();
    sp.edit().putBoolean("dynamic_bg_will_crash", false).apply();
    sp.edit().putBoolean("dynamic_bg_init_crash", false).apply();
    FVb = false;
    FVc = false;
    e.wj(true);
    AppMethodBeat.o(238309);
  }
  
  public static boolean fvg()
  {
    return FVb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.a.c
 * JD-Core Version:    0.7.0.1
 */