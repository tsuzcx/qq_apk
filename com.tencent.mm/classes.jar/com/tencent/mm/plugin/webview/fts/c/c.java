package com.tencent.mm.plugin.webview.fts.c;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public static float[] a(JSONObject paramJSONObject, Context paramContext)
  {
    AppMethodBeat.i(5948);
    float[] arrayOfFloat = new float[5];
    if (paramJSONObject.has("x"))
    {
      arrayOfFloat[0] = a.fromDPToPix(paramContext, paramJSONObject.optInt("x"));
      if (!paramJSONObject.has("y")) {
        break label122;
      }
      arrayOfFloat[1] = a.fromDPToPix(paramContext, paramJSONObject.optInt("y"));
      label56:
      if (!paramJSONObject.has("width")) {
        break label130;
      }
      arrayOfFloat[2] = a.fromDPToPix(paramContext, paramJSONObject.optInt("width"));
      label79:
      if (!paramJSONObject.has("height")) {
        break label138;
      }
      arrayOfFloat[3] = a.fromDPToPix(paramContext, paramJSONObject.optInt("height"));
    }
    for (;;)
    {
      arrayOfFloat[4] = 0.0F;
      AppMethodBeat.o(5948);
      return arrayOfFloat;
      arrayOfFloat[0] = 3.4028235E+38F;
      break;
      label122:
      arrayOfFloat[1] = 3.4028235E+38F;
      break label56;
      label130:
      arrayOfFloat[2] = 3.4028235E+38F;
      break label79;
      label138:
      arrayOfFloat[3] = 3.4028235E+38F;
    }
  }
  
  public static String aQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(5950);
    paramJSONObject = paramJSONObject.optJSONArray("playUrl");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {
      try
      {
        paramJSONObject = paramJSONObject.getString(0);
        AppMethodBeat.o(5950);
        return paramJSONObject;
      }
      catch (JSONException paramJSONObject)
      {
        ab.e("MicroMsg.FTS.FtsVideoPlayerUtils", "ex %s", new Object[] { paramJSONObject.getMessage() });
      }
    }
    AppMethodBeat.o(5950);
    return "";
  }
  
  private static float cN(Context paramContext)
  {
    AppMethodBeat.i(5945);
    paramContext = paramContext.getContentResolver();
    float f = 0.0F;
    try
    {
      int i = Settings.System.getInt(paramContext, "screen_brightness");
      f = i / 255.0F;
    }
    catch (Settings.SettingNotFoundException paramContext)
    {
      for (;;)
      {
        ab.e("MicroMsg.FTS.FtsVideoPlayerUtils", "ex %s", new Object[] { paramContext.getMessage() });
      }
    }
    AppMethodBeat.o(5945);
    return f;
  }
  
  public static float cP(Context paramContext)
  {
    AppMethodBeat.i(5946);
    WindowManager.LayoutParams localLayoutParams = ((Activity)paramContext).getWindow().getAttributes();
    if (localLayoutParams.screenBrightness < 0.0F)
    {
      f = cN(paramContext);
      AppMethodBeat.o(5946);
      return f;
    }
    float f = localLayoutParams.screenBrightness;
    AppMethodBeat.o(5946);
    return f;
  }
  
  public static String ha(long paramLong)
  {
    AppMethodBeat.i(5947);
    if (paramLong < 3600000L) {}
    for (Object localObject = "mm:ss";; localObject = "HH:mm:ss")
    {
      localObject = new SimpleDateFormat((String)localObject);
      ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
      localObject = ((SimpleDateFormat)localObject).format(Long.valueOf(paramLong));
      AppMethodBeat.o(5947);
      return localObject;
    }
  }
  
  public static int y(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(5949);
    if (paramJSONObject.has("visible"))
    {
      if (paramJSONObject.optBoolean("visible"))
      {
        AppMethodBeat.o(5949);
        return 0;
      }
      AppMethodBeat.o(5949);
      return 1;
    }
    AppMethodBeat.o(5949);
    return 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.c
 * JD-Core Version:    0.7.0.1
 */