package com.tencent.tinker.loader.a;

import android.content.Intent;
import android.util.Log;
import java.io.Serializable;

public final class e
{
  public static void a(Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("intent_return_code", paramInt);
  }
  
  public static void a(Intent paramIntent, ClassLoader paramClassLoader)
  {
    try
    {
      paramIntent.setExtrasClassLoader(paramClassLoader);
      return;
    }
    catch (Throwable paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public static String b(Intent paramIntent, String paramString)
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
      Log.e("ShareIntentUtil", "getStringExtra exception:" + paramIntent.getMessage());
    }
    return null;
  }
  
  public static Serializable c(Intent paramIntent, String paramString)
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
      Log.e("ShareIntentUtil", "getSerializableExtra exception:" + paramIntent.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.a.e
 * JD-Core Version:    0.7.0.1
 */