package com.tencent.mm.plugin.taskbar.ui.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
{
  private static boolean Pix;
  private static boolean STJ;
  private static boolean STK;
  private static SharedPreferences sp;
  
  static
  {
    AppMethodBeat.i(264197);
    sp = MMApplicationContext.getDefaultPreference();
    Pix = false;
    STJ = false;
    STK = true;
    AppMethodBeat.o(264197);
  }
  
  public static void aTs()
  {
    AppMethodBeat.i(264142);
    Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markWillCrash");
    if (sp == null) {
      sp = MMApplicationContext.getDefaultPreference();
    }
    if (sp != null)
    {
      e.Fg(false);
      sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
    }
    Pix = true;
    AppMethodBeat.o(264142);
  }
  
  public static boolean aTv()
  {
    return STJ;
  }
  
  public static boolean aTw()
  {
    return STK;
  }
  
  public static void aTx()
  {
    AppMethodBeat.i(264172);
    if (sp == null) {
      sp = MMApplicationContext.getDefaultPreference();
    }
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_draw_start_point_count", 0);
      Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawStartPoint current: %d", new Object[] { Integer.valueOf(i) });
      if (i > 2)
      {
        e.Fg(false);
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
      }
      sp.edit().putInt("dynamic_bg_draw_start_point_count", i + 1).apply();
    }
    AppMethodBeat.o(264172);
  }
  
  public static void aTy()
  {
    AppMethodBeat.i(264180);
    Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markDrawEndPoint");
    sp.edit().putInt("dynamic_bg_draw_start_point_count", 0).apply();
    sp.edit().putBoolean("dynamic_bg_will_crash", false).apply();
    e.Fg(true);
    STK = false;
    AppMethodBeat.o(264180);
  }
  
  public static boolean hDZ()
  {
    AppMethodBeat.i(264120);
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_init_start_point_count", 0);
      int j = sp.getInt("dynamic_bg_draw_start_point_count", 0);
      boolean bool = sp.getBoolean("dynamic_bg_init_crash", false);
      STJ = bool;
      if ((bool) || (i >= 2) || (j >= 2))
      {
        Pix = true;
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
        AppMethodBeat.o(264120);
        return true;
      }
      Pix = false;
      AppMethodBeat.o(264120);
      return false;
    }
    AppMethodBeat.o(264120);
    return false;
  }
  
  public static void hEa()
  {
    AppMethodBeat.i(264124);
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
    STJ = false;
    Pix = false;
    AppMethodBeat.o(264124);
  }
  
  public static void hEb()
  {
    AppMethodBeat.i(264134);
    Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitCrash");
    e.Fg(false);
    if (sp == null) {
      sp = MMApplicationContext.getDefaultPreference();
    }
    if (sp != null) {
      sp.edit().putBoolean("dynamic_bg_init_crash", true).apply();
    }
    STJ = true;
    AppMethodBeat.o(264134);
  }
  
  public static void hEc()
  {
    AppMethodBeat.i(264161);
    if (sp == null) {
      sp = MMApplicationContext.getDefaultPreference();
    }
    if (sp != null)
    {
      int i = sp.getInt("dynamic_bg_init_start_point_count", 0);
      Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitStartPoint current: %d", new Object[] { Integer.valueOf(i) });
      if (i > 2)
      {
        e.Fg(false);
        sp.edit().putBoolean("dynamic_bg_will_crash", true).apply();
      }
      sp.edit().putInt("dynamic_bg_init_start_point_count", i + 1).apply();
    }
    AppMethodBeat.o(264161);
  }
  
  public static void hEd()
  {
    AppMethodBeat.i(264167);
    Log.i("MicroMsg.DynamicBgCrashHelper", "alvinluo markInitEndPoint");
    sp.edit().putInt("dynamic_bg_init_start_point_count", 0).apply();
    sp.edit().putBoolean("dynamic_bg_will_crash", false).apply();
    sp.edit().putBoolean("dynamic_bg_init_crash", false).apply();
    Pix = false;
    STJ = false;
    e.Fg(true);
    AppMethodBeat.o(264167);
  }
  
  public static boolean hEe()
  {
    return Pix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.a.c
 * JD-Core Version:    0.7.0.1
 */