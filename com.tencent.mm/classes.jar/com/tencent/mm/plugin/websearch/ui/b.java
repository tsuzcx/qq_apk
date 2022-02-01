package com.tencent.mm.plugin.websearch.ui;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class b
{
  public static String GN(long paramLong)
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
  
  private static float dS(Context paramContext)
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
  
  public static float dT(Context paramContext)
  {
    AppMethodBeat.i(110226);
    WindowManager.LayoutParams localLayoutParams = ((Activity)paramContext).getWindow().getAttributes();
    if (localLayoutParams.screenBrightness < 0.0F)
    {
      f = dS(paramContext);
      AppMethodBeat.o(110226);
      return f;
    }
    float f = localLayoutParams.screenBrightness;
    AppMethodBeat.o(110226);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.b
 * JD-Core Version:    0.7.0.1
 */