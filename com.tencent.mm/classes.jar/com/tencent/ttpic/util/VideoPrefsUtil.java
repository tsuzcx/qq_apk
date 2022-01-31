package com.tencent.ttpic.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoPrefsUtil
{
  public static final String PREFS_KEY_DOWNGRADE_LEVEL = "prefs_key_downgrade_level";
  public static final String PREFS_KEY_ENCODE_WIDTH = "prefs_key_encode_width";
  public static final String PREFS_KEY_IS_MATERIAL_MUTE = "prefs_key_is_material_mute";
  public static final String PREFS_KEY_SEGMENT_ON_CPU = "prefs_key_segment_on_cpu";
  public static final String PREFS_KEY_STORAGE = "pref_key_storage";
  public static final String PREFS_KEY_USE_HARDWARE_DECODER = "prefs_key_use_hardware_decoder";
  public static final String PREFS_KEY_WATERMARK_COUNTDOWN = "prefs_key_watermark_countdown";
  public static final String PREFS_KEY_WATERMARK_SINCE = "prefs_key_watermark_since";
  public static final String PREF_KEY_WATERMARK = "pref_key_watermark";
  private static SharedPreferences mPrefs;
  
  public static SharedPreferences getDefaultPrefs()
  {
    return mPrefs;
  }
  
  public static int getDowngradeLevel()
  {
    AppMethodBeat.i(84215);
    int i = getDefaultPrefs().getInt("prefs_key_downgrade_level", -1);
    AppMethodBeat.o(84215);
    return i;
  }
  
  public static boolean getMaterialMute()
  {
    AppMethodBeat.i(84213);
    boolean bool = getDefaultPrefs().getBoolean("prefs_key_is_material_mute", false);
    AppMethodBeat.o(84213);
    return bool;
  }
  
  public static int getNormalEncodeWidth()
  {
    AppMethodBeat.i(84219);
    int i = getDefaultPrefs().getInt("prefs_key_encode_width", 720);
    AppMethodBeat.o(84219);
    return i;
  }
  
  public static boolean getUseHardwareDecoder()
  {
    AppMethodBeat.i(84218);
    boolean bool = getDefaultPrefs().getBoolean("prefs_key_use_hardware_decoder", true);
    AppMethodBeat.o(84218);
    return bool;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(84212);
    mPrefs = PreferenceManager.getDefaultSharedPreferences(paramContext);
    AppMethodBeat.o(84212);
  }
  
  public static void setDowngradeLevel(int paramInt)
  {
    AppMethodBeat.i(84216);
    getDefaultPrefs().edit().putInt("prefs_key_downgrade_level", paramInt).apply();
    AppMethodBeat.o(84216);
  }
  
  public static void setMaterialMute(boolean paramBoolean)
  {
    AppMethodBeat.i(84214);
    getDefaultPrefs().edit().putBoolean("prefs_key_is_material_mute", paramBoolean).apply();
    AppMethodBeat.o(84214);
  }
  
  public static void setNormalEncodeWidth(int paramInt)
  {
    AppMethodBeat.i(84220);
    getDefaultPrefs().edit().putInt("prefs_key_encode_width", paramInt).apply();
    AppMethodBeat.o(84220);
  }
  
  public static void setUseHardWareDecoder(boolean paramBoolean)
  {
    AppMethodBeat.i(84217);
    getDefaultPrefs().edit().putBoolean("prefs_key_use_hardware_decoder", paramBoolean).apply();
    AppMethodBeat.o(84217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoPrefsUtil
 * JD-Core Version:    0.7.0.1
 */