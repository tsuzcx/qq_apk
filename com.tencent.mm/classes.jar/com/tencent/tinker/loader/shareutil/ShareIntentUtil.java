package com.tencent.tinker.loader.shareutil;

import android.content.Intent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ShareIntentUtil
{
  public static final String INTENT_IS_PROTECTED_APP = "intent_is_protected_app";
  public static final String INTENT_PATCH_COST_TIME = "intent_patch_cost_time";
  public static final String INTENT_PATCH_DEXES_PATH = "intent_patch_dexes_path";
  public static final String INTENT_PATCH_EXCEPTION = "intent_patch_exception";
  public static final String INTENT_PATCH_INTERPRET_EXCEPTION = "intent_patch_interpret_exception";
  public static final String INTENT_PATCH_LIBS_PATH = "intent_patch_libs_path";
  public static final String INTENT_PATCH_MISMATCH_DEX_PATH = "intent_patch_mismatch_dex_path";
  public static final String INTENT_PATCH_MISMATCH_LIB_PATH = "intent_patch_mismatch_lib_path";
  public static final String INTENT_PATCH_MISSING_DEX_PATH = "intent_patch_missing_dex_path";
  public static final String INTENT_PATCH_MISSING_LIB_PATH = "intent_patch_missing_lib_path";
  public static final String INTENT_PATCH_NEW_VERSION = "intent_patch_new_version";
  public static final String INTENT_PATCH_OAT_DIR = "intent_patch_oat_dir";
  public static final String INTENT_PATCH_OLD_VERSION = "intent_patch_old_version";
  public static final String INTENT_PATCH_PACKAGE_CONFIG = "intent_patch_package_config";
  public static final String INTENT_PATCH_PACKAGE_PATCH_CHECK = "intent_patch_package_patch_check";
  public static final String INTENT_PATCH_SYSTEM_OTA = "intent_patch_system_ota";
  public static final String INTENT_RETURN_CODE = "intent_return_code";
  private static final String TAG = "ShareIntentUtil";
  
  public static void fixIntentClassLoader(Intent paramIntent, ClassLoader paramClassLoader)
  {
    try
    {
      paramIntent.setExtrasClassLoader(paramClassLoader);
      return;
    }
    finally {}
  }
  
  public static boolean getBooleanExtra(Intent paramIntent, String paramString, boolean paramBoolean)
  {
    if (paramIntent == null) {
      return paramBoolean;
    }
    try
    {
      boolean bool = paramIntent.getBooleanExtra(paramString, paramBoolean);
      return bool;
    }
    catch (Exception paramIntent)
    {
      ShareTinkerLog.e("ShareIntentUtil", "getBooleanExtra exception:" + paramIntent.getMessage(), new Object[0]);
    }
    return paramBoolean;
  }
  
  public static int getIntExtra(Intent paramIntent, String paramString, int paramInt)
  {
    if (paramIntent == null) {
      return paramInt;
    }
    try
    {
      int i = paramIntent.getIntExtra(paramString, paramInt);
      return i;
    }
    catch (Exception paramIntent)
    {
      ShareTinkerLog.e("ShareIntentUtil", "getIntExtra exception:" + paramIntent.getMessage(), new Object[0]);
    }
    return paramInt;
  }
  
  public static Throwable getIntentInterpretException(Intent paramIntent)
  {
    paramIntent = getSerializableExtra(paramIntent, "intent_patch_interpret_exception");
    if (paramIntent != null) {
      return (Throwable)paramIntent;
    }
    return null;
  }
  
  public static HashMap<String, String> getIntentPackageConfig(Intent paramIntent)
  {
    paramIntent = getSerializableExtra(paramIntent, "intent_patch_package_config");
    if (paramIntent != null) {
      return (HashMap)paramIntent;
    }
    return null;
  }
  
  public static long getIntentPatchCostTime(Intent paramIntent)
  {
    return paramIntent.getLongExtra("intent_patch_cost_time", 0L);
  }
  
  public static HashMap<String, String> getIntentPatchDexPaths(Intent paramIntent)
  {
    paramIntent = getSerializableExtra(paramIntent, "intent_patch_dexes_path");
    if (paramIntent != null) {
      return (HashMap)paramIntent;
    }
    return null;
  }
  
  public static Throwable getIntentPatchException(Intent paramIntent)
  {
    paramIntent = getSerializableExtra(paramIntent, "intent_patch_exception");
    if (paramIntent != null) {
      return (Throwable)paramIntent;
    }
    return null;
  }
  
  public static HashMap<String, String> getIntentPatchLibsPaths(Intent paramIntent)
  {
    paramIntent = getSerializableExtra(paramIntent, "intent_patch_libs_path");
    if (paramIntent != null) {
      return (HashMap)paramIntent;
    }
    return null;
  }
  
  public static int getIntentReturnCode(Intent paramIntent)
  {
    return getIntExtra(paramIntent, "intent_return_code", -10000);
  }
  
  public static long getLongExtra(Intent paramIntent, String paramString, long paramLong)
  {
    if (paramIntent == null) {
      return paramLong;
    }
    try
    {
      long l = paramIntent.getLongExtra(paramString, paramLong);
      return l;
    }
    catch (Exception paramIntent)
    {
      ShareTinkerLog.e("ShareIntentUtil", "getIntExtra exception:" + paramIntent.getMessage(), new Object[0]);
    }
    return paramLong;
  }
  
  public static Serializable getSerializableExtra(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      return null;
    }
    try
    {
      paramIntent = paramIntent.getSerializableExtra(paramString);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      ShareTinkerLog.e("ShareIntentUtil", "getSerializableExtra exception:" + paramIntent.getMessage(), new Object[0]);
    }
    return null;
  }
  
  public static ArrayList<String> getStringArrayListExtra(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      return null;
    }
    try
    {
      paramIntent = paramIntent.getStringArrayListExtra(paramString);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      ShareTinkerLog.e("ShareIntentUtil", "getStringExtra exception:" + paramIntent.getMessage(), new Object[0]);
    }
    return null;
  }
  
  public static String getStringExtra(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      return null;
    }
    try
    {
      paramIntent = paramIntent.getStringExtra(paramString);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      ShareTinkerLog.e("ShareIntentUtil", "getStringExtra exception:" + paramIntent.getMessage(), new Object[0]);
    }
    return null;
  }
  
  public static void setIntentPatchCostTime(Intent paramIntent, long paramLong)
  {
    paramIntent.putExtra("intent_patch_cost_time", paramLong);
  }
  
  public static void setIntentReturnCode(Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("intent_return_code", paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareIntentUtil
 * JD-Core Version:    0.7.0.1
 */