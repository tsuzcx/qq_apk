package com.tencent.mm.plugin.sns.ad.j;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  public static int aWR(String paramString)
  {
    AppMethodBeat.i(309695);
    int j = -352965;
    int i = j;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        i = Color.parseColor(paramString);
      }
      AppMethodBeat.o(309695);
      return i;
    }
    finally
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
    AppMethodBeat.i(309710);
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
        return paramString;
        localStringBuilder.append(paramString);
      }
      return "";
    }
    finally
    {
      AppMethodBeat.o(309710);
    }
  }
  
  public static String lP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(309702);
    try
    {
      paramString1 = d(Float.parseFloat(paramString1), paramString2);
      AppMethodBeat.o(309702);
      return paramString1;
    }
    finally
    {
      Log.w("SnsAd.ColorUtil", "parse color from string failed");
      AppMethodBeat.o(309702);
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.j.e
 * JD-Core Version:    0.7.0.1
 */