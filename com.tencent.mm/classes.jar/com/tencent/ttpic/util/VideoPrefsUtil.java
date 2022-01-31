package com.tencent.ttpic.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

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
    return getDefaultPrefs().getInt("prefs_key_downgrade_level", -1);
  }
  
  public static boolean getMaterialMute()
  {
    return getDefaultPrefs().getBoolean("prefs_key_is_material_mute", false);
  }
  
  public static int getNormalEncodeWidth()
  {
    return getDefaultPrefs().getInt("prefs_key_encode_width", 720);
  }
  
  public static boolean getUseHardwareDecoder()
  {
    return getDefaultPrefs().getBoolean("prefs_key_use_hardware_decoder", true);
  }
  
  public static void init(Context paramContext)
  {
    mPrefs = PreferenceManager.getDefaultSharedPreferences(paramContext);
  }
  
  public static void setDowngradeLevel(int paramInt)
  {
    getDefaultPrefs().edit().putInt("prefs_key_downgrade_level", paramInt).apply();
  }
  
  public static void setMaterialMute(boolean paramBoolean)
  {
    getDefaultPrefs().edit().putBoolean("prefs_key_is_material_mute", paramBoolean).apply();
  }
  
  public static void setNormalEncodeWidth(int paramInt)
  {
    getDefaultPrefs().edit().putInt("prefs_key_encode_width", paramInt).apply();
  }
  
  public static void setUseHardWareDecoder(boolean paramBoolean)
  {
    getDefaultPrefs().edit().putBoolean("prefs_key_use_hardware_decoder", paramBoolean).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoPrefsUtil
 * JD-Core Version:    0.7.0.1
 */