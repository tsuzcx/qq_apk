package com.tencent.mm.plugin.webview.fts.c;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public static String GN(long paramLong)
  {
    AppMethodBeat.i(78161);
    if (paramLong < 3600000L) {}
    for (Object localObject = "mm:ss";; localObject = "HH:mm:ss")
    {
      localObject = new SimpleDateFormat((String)localObject);
      ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
      localObject = ((SimpleDateFormat)localObject).format(Long.valueOf(paramLong));
      AppMethodBeat.o(78161);
      return localObject;
    }
  }
  
  public static int Q(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(78163);
    if (paramJSONObject.has("visible"))
    {
      if (paramJSONObject.optBoolean("visible"))
      {
        AppMethodBeat.o(78163);
        return 0;
      }
      AppMethodBeat.o(78163);
      return 1;
    }
    AppMethodBeat.o(78163);
    return 2147483647;
  }
  
  public static float[] a(JSONObject paramJSONObject, Context paramContext)
  {
    AppMethodBeat.i(78162);
    float[] arrayOfFloat = new float[5];
    if (paramJSONObject.has("x"))
    {
      arrayOfFloat[0] = a.fromDPToPix(paramContext, paramJSONObject.optInt("x"));
      if (!paramJSONObject.has("y")) {
        break label120;
      }
      arrayOfFloat[1] = a.fromDPToPix(paramContext, paramJSONObject.optInt("y"));
      label55:
      if (!paramJSONObject.has("width")) {
        break label128;
      }
      arrayOfFloat[2] = a.fromDPToPix(paramContext, paramJSONObject.optInt("width"));
      label78:
      if (!paramJSONObject.has("height")) {
        break label136;
      }
      arrayOfFloat[3] = a.fromDPToPix(paramContext, paramJSONObject.optInt("height"));
    }
    for (;;)
    {
      arrayOfFloat[4] = 0.0F;
      AppMethodBeat.o(78162);
      return arrayOfFloat;
      arrayOfFloat[0] = 3.4028235E+38F;
      break;
      label120:
      arrayOfFloat[1] = 3.4028235E+38F;
      break label55;
      label128:
      arrayOfFloat[2] = 3.4028235E+38F;
      break label78;
      label136:
      arrayOfFloat[3] = 3.4028235E+38F;
    }
  }
  
  public static String ci(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(78164);
    paramJSONObject = paramJSONObject.optJSONArray("playUrl");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {
      try
      {
        paramJSONObject = paramJSONObject.getString(0);
        AppMethodBeat.o(78164);
        return paramJSONObject;
      }
      catch (JSONException paramJSONObject)
      {
        Log.e("MicroMsg.FTS.FtsVideoPlayerUtils", "ex %s", new Object[] { paramJSONObject.getMessage() });
      }
    }
    AppMethodBeat.o(78164);
    return "";
  }
  
  private static float dS(Context paramContext)
  {
    AppMethodBeat.i(78159);
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
        Log.e("MicroMsg.FTS.FtsVideoPlayerUtils", "ex %s", new Object[] { paramContext.getMessage() });
      }
    }
    AppMethodBeat.o(78159);
    return f;
  }
  
  public static float dT(Context paramContext)
  {
    AppMethodBeat.i(78160);
    WindowManager.LayoutParams localLayoutParams = ((Activity)paramContext).getWindow().getAttributes();
    if (localLayoutParams.screenBrightness < 0.0F)
    {
      f = dS(paramContext);
      AppMethodBeat.o(78160);
      return f;
    }
    float f = localLayoutParams.screenBrightness;
    AppMethodBeat.o(78160);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.c
 * JD-Core Version:    0.7.0.1
 */