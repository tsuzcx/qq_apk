package com.tencent.mm.plugin.websearch.ui;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class b
{
  public static String ce(long paramLong)
  {
    if (paramLong < 3600000L) {}
    for (Object localObject = "mm:ss";; localObject = "HH:mm:ss")
    {
      localObject = new SimpleDateFormat((String)localObject);
      ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
      return ((SimpleDateFormat)localObject).format(Long.valueOf(paramLong));
    }
  }
  
  private static float cl(Context paramContext)
  {
    paramContext = paramContext.getContentResolver();
    try
    {
      int i = Settings.System.getInt(paramContext, "screen_brightness");
      return i / 255.0F;
    }
    catch (Settings.SettingNotFoundException paramContext) {}
    return 0.0F;
  }
  
  public static float cn(Context paramContext)
  {
    WindowManager.LayoutParams localLayoutParams = ((Activity)paramContext).getWindow().getAttributes();
    if (localLayoutParams.screenBrightness < 0.0F) {
      return cl(paramContext);
    }
    return localLayoutParams.screenBrightness;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.b
 * JD-Core Version:    0.7.0.1
 */