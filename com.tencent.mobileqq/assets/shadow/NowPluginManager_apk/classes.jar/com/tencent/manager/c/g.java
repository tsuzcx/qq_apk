package com.tencent.manager.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class g
{
  private static float a = -1.0F;
  
  public static float a(Context paramContext)
  {
    if (a < 0.0F) {
      a = paramContext.getResources().getDisplayMetrics().density;
    }
    return a;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return Math.round(a(paramContext) * paramFloat);
  }
  
  public static Bitmap a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(paramString)));
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.c.g
 * JD-Core Version:    0.7.0.1
 */