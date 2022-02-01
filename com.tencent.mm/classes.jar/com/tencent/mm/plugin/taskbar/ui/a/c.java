package com.tencent.mm.plugin.taskbar.ui.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
{
  private static boolean Mqw;
  private static boolean Mqx;
  private static boolean Mqy;
  private static SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(214361);
    sp = MMApplicationContext.getDefaultPreference();
    Mqw = false;
    Mqx = false;
    Mqy = true;
    AppMethodBeat.o(214361);
  }
  
  public static boolean aAA()
  {
    return Mqx;
  }
  
  public static boolean aAB()
  {
    return Mqy;
  }
  
  public static void aAC()
  {
    AppMethodBeat.i(214359);
    if (sp == null) {
      sp = MMApplicationContext.getDefaultPreference();
    }
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_draw_start_point_count", 0);
      Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawStartPoint current: %d", new Object[] { Integer.valueOf(i) });
      if (i > 2)
      {
        e.zP(false);
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
      }
      sp.edit().putInt("dynamic_bg_draw_start_point_count", i + 1).apply();
    }
    AppMethodBeat.o(214359);
  }
  
  public static void aAD()
  {
    AppMethodBeat.i(214360);
    Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawEndPoint");
    sp.edit().putInt("dynamic_bg_draw_start_point_count", 0).apply();
    sp.edit().putBoolean("dynamic_bg_will_crash", false).apply();
    e.zP(true);
    Mqy = false;
    AppMethodBeat.o(214360);
  }
  
  public static void aAx()
  {
    AppMethodBeat.i(214356);
    Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markWillCrash");
    if (sp == null) {
      sp = MMApplicationContext.getDefaultPreference();
    }
    if (sp != null)
    {
      e.zP(false);
      sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
    }
    Mqw = true;
    AppMethodBeat.o(214356);
  }
  
  public static boolean gjZ()
  {
    AppMethodBeat.i(214352);
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_init_start_point_count", 0);
      int j = sp.getInt("dynamic_bg_draw_start_point_count", 0);
      boolean bool = sp.getBoolean("dynamic_bg_init_crash", false);
      Mqx = bool;
      if ((bool) || (i >= 2) || (j >= 2))
      {
        Mqw = true;
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
        AppMethodBeat.o(214352);
        return true;
      }
      Mqw = false;
      AppMethodBeat.o(214352);
      return false;
    }
    AppMethodBeat.o(214352);
    return false;
  }
  
  public static void gka()
  {
    AppMethodBeat.i(214354);
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
    Mqx = false;
    Mqw = false;
    AppMethodBeat.o(214354);
  }
  
  public static void gkb()
  {
    AppMethodBeat.i(214355);
    Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitCrash");
    e.zP(false);
    if (sp == null) {
      sp = MMApplicationContext.getDefaultPreference();
    }
    if (sp != null) {
      sp.edit().putBoolean("dynamic_bg_init_crash", true).apply();
    }
    Mqx = true;
    AppMethodBeat.o(214355);
  }
  
  public static void gkc()
  {
    AppMethodBeat.i(214357);
    if (sp == null) {
      sp = MMApplicationContext.getDefaultPreference();
    }
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_init_start_point_count", 0);
      Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitStartPoint current: %d", new Object[] { Integer.valueOf(i) });
      if (i > 2)
      {
        e.zP(false);
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
      }
      sp.edit().putInt("dynamic_bg_init_start_point_count", i + 1).apply();
    }
    AppMethodBeat.o(214357);
  }
  
  public static void gkd()
  {
    AppMethodBeat.i(214358);
    Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitEndPoint");
    sp.edit().putInt("dynamic_bg_init_start_point_count", 0).apply();
    sp.edit().putBoolean("dynamic_bg_will_crash", false).apply();
    sp.edit().putBoolean("dynamic_bg_init_crash", false).apply();
    Mqw = false;
    Mqx = false;
    e.zP(true);
    AppMethodBeat.o(214358);
  }
  
  public static boolean gke()
  {
    return Mqw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.a.c
 * JD-Core Version:    0.7.0.1
 */