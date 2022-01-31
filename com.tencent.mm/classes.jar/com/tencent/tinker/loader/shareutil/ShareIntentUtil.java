package com.tencent.tinker.loader.shareutil;

import android.content.Intent;
import java.io.Serializable;
import java.util.HashMap;

public class ShareIntentUtil
{
  public static void a(Intent paramIntent, long paramLong)
  {
    paramIntent.putExtra("intent_patch_cost_time", paramLong);
  }
  
  public static void a(Intent paramIntent, ClassLoader paramClassLoader)
  {
    try
    {
      paramIntent.setExtrasClassLoader(paramClassLoader);
      return;
    }
    catch (Throwable paramIntent) {}
  }
  
  public static void b(Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("intent_return_code", paramInt);
  }
  
  public static int bc(Intent paramIntent)
  {
    return v(paramIntent, "intent_return_code");
  }
  
  public static long bd(Intent paramIntent)
  {
    return paramIntent.getLongExtra("intent_patch_cost_time", 0L);
  }
  
  public static Throwable be(Intent paramIntent)
  {
    paramIntent = u(paramIntent, "intent_patch_exception");
    if (paramIntent != null) {
      return (Throwable)paramIntent;
    }
    return null;
  }
  
  public static Throwable bf(Intent paramIntent)
  {
    paramIntent = u(paramIntent, "intent_patch_interpret_exception");
    if (paramIntent != null) {
      return (Throwable)paramIntent;
    }
    return null;
  }
  
  public static HashMap<String, String> bg(Intent paramIntent)
  {
    paramIntent = u(paramIntent, "intent_patch_dexes_path");
    if (paramIntent != null) {
      return (HashMap)paramIntent;
    }
    return null;
  }
  
  public static HashMap<String, String> bh(Intent paramIntent)
  {
    paramIntent = u(paramIntent, "intent_patch_libs_path");
    if (paramIntent != null) {
      return (HashMap)paramIntent;
    }
    return null;
  }
  
  public static HashMap<String, String> bi(Intent paramIntent)
  {
    paramIntent = u(paramIntent, "intent_patch_package_config");
    if (paramIntent != null) {
      return (HashMap)paramIntent;
    }
    return null;
  }
  
  public static String n(Intent paramIntent, String paramString)
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
      new StringBuilder("getStringExtra exception:").append(paramIntent.getMessage());
    }
    return null;
  }
  
  public static Serializable u(Intent paramIntent, String paramString)
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
      new StringBuilder("getSerializableExtra exception:").append(paramIntent.getMessage());
    }
    return null;
  }
  
  private static int v(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      return -10000;
    }
    try
    {
      int i = paramIntent.getIntExtra(paramString, -10000);
      return i;
    }
    catch (Exception paramIntent)
    {
      new StringBuilder("getIntExtra exception:").append(paramIntent.getMessage());
    }
    return -10000;
  }
  
  public static boolean w(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      return false;
    }
    try
    {
      boolean bool = paramIntent.getBooleanExtra(paramString, false);
      return bool;
    }
    catch (Exception paramIntent)
    {
      new StringBuilder("getBooleanExtra exception:").append(paramIntent.getMessage());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareIntentUtil
 * JD-Core Version:    0.7.0.1
 */