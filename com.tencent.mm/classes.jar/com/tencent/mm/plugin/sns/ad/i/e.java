package com.tencent.mm.plugin.sns.ad.i;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  public static int aYL(String paramString)
  {
    AppMethodBeat.i(197462);
    int j = -352965;
    int i = j;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        i = Color.parseColor(paramString);
      }
      AppMethodBeat.o(197462);
      return i;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        Log.w("SnsAd.ColorUtil", "parse color from string failed, return default value!");
        i = j;
      }
    }
  }
  
  private static String d(float paramFloat, String paramString)
  {
    AppMethodBeat.i(197466);
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = (int)(255.0F * paramFloat);
      localStringBuilder.append('#').append(Integer.toHexString(i));
      if (paramString.startsWith("#")) {
        localStringBuilder.append(paramString.substring(1));
      }
      for (;;)
      {
        paramString = localStringBuilder.toString();
        AppMethodBeat.o(197466);
        return paramString;
        localStringBuilder.append(paramString);
      }
      return "";
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(197466);
    }
  }
  
  public static String kp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197463);
    try
    {
      paramString1 = d(Float.parseFloat(paramString1), paramString2);
      AppMethodBeat.o(197463);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      Log.w("SnsAd.ColorUtil", "parse color from string failed");
      AppMethodBeat.o(197463);
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.e
 * JD-Core Version:    0.7.0.1
 */