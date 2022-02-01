package com.tencent.mm.plugin.websearch.ui;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class a
{
  public static String AF(long paramLong)
  {
    AppMethodBeat.i(110228);
    if (paramLong < 3600000L) {}
    for (Object localObject = "mm:ss";; localObject = "HH:mm:ss")
    {
      localObject = new SimpleDateFormat((String)localObject);
      ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
      localObject = ((SimpleDateFormat)localObject).format(Long.valueOf(paramLong));
      AppMethodBeat.o(110228);
      return localObject;
    }
  }
  
  private static float dT(Context paramContext)
  {
    AppMethodBeat.i(110227);
    paramContext = paramContext.getContentResolver();
    float f = 0.0F;
    try
    {
      int i = Settings.System.getInt(paramContext, "screen_brightness");
      f = i / 255.0F;
    }
    catch (Exception paramContext)
    {
      label25:
      break label25;
    }
    AppMethodBeat.o(110227);
    return f;
  }
  
  public static float dV(Context paramContext)
  {
    AppMethodBeat.i(110226);
    WindowManager.LayoutParams localLayoutParams = ((Activity)paramContext).getWindow().getAttributes();
    if (localLayoutParams.screenBrightness < 0.0F)
    {
      f = dT(paramContext);
      AppMethodBeat.o(110226);
      return f;
    }
    float f = localLayoutParams.screenBrightness;
    AppMethodBeat.o(110226);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.a
 * JD-Core Version:    0.7.0.1
 */