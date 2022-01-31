package com.tencent.mm.plugin.webview.fts.c;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.cb.a;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public static float[] a(JSONObject paramJSONObject, Context paramContext)
  {
    float[] arrayOfFloat = new float[5];
    if (paramJSONObject.has("x"))
    {
      arrayOfFloat[0] = a.fromDPToPix(paramContext, paramJSONObject.optInt("x"));
      if (!paramJSONObject.has("y")) {
        break label110;
      }
      arrayOfFloat[1] = a.fromDPToPix(paramContext, paramJSONObject.optInt("y"));
      label50:
      if (!paramJSONObject.has("width")) {
        break label118;
      }
      arrayOfFloat[2] = a.fromDPToPix(paramContext, paramJSONObject.optInt("width"));
      label73:
      if (!paramJSONObject.has("height")) {
        break label126;
      }
      arrayOfFloat[3] = a.fromDPToPix(paramContext, paramJSONObject.optInt("height"));
    }
    for (;;)
    {
      arrayOfFloat[4] = 0.0F;
      return arrayOfFloat;
      arrayOfFloat[0] = 3.4028235E+38F;
      break;
      label110:
      arrayOfFloat[1] = 3.4028235E+38F;
      break label50;
      label118:
      arrayOfFloat[2] = 3.4028235E+38F;
      break label73;
      label126:
      arrayOfFloat[3] = 3.4028235E+38F;
    }
  }
  
  public static String ax(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("playUrl");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {
      try
      {
        paramJSONObject = paramJSONObject.getString(0);
        return paramJSONObject;
      }
      catch (JSONException paramJSONObject) {}
    }
    return "";
  }
  
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
  
  public static int r(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("visible"))
    {
      if (paramJSONObject.optBoolean("visible")) {
        return 0;
      }
      return 1;
    }
    return 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.c
 * JD-Core Version:    0.7.0.1
 */