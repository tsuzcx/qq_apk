package com.tencent.thumbplayer.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

public final class b
{
  public static boolean aRh(String paramString)
  {
    AppMethodBeat.i(188221);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(188221);
      return false;
    }
    try
    {
      paramString = paramString.split(":");
      boolean bool = paramString[0].matches("^((https|http|ftp|rtsp|mms)?)");
      AppMethodBeat.o(188221);
      return bool;
    }
    catch (PatternSyntaxException paramString)
    {
      AppMethodBeat.o(188221);
    }
    return false;
  }
  
  public static String axc(String paramString)
  {
    AppMethodBeat.i(188219);
    for (;;)
    {
      StringBuilder localStringBuilder;
      int i;
      try
      {
        paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"));
        localStringBuilder = new StringBuilder(40);
        int j = paramString.length;
        i = 0;
        if (i < j)
        {
          int k = paramString[i];
          if ((k & 0xFF) >> 4 == 0) {
            localStringBuilder.append("0").append(Integer.toHexString(k & 0xFF));
          } else {
            localStringBuilder.append(Integer.toHexString(k & 0xFF));
          }
        }
      }
      catch (Exception paramString)
      {
        f.e("TPCommonUtils", paramString.toString());
        AppMethodBeat.o(188219);
        return null;
      }
      paramString = localStringBuilder.toString();
      AppMethodBeat.o(188219);
      return paramString;
      i += 1;
    }
  }
  
  public static boolean isEmpty(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(188217);
    if ((paramCollection == null) || (paramCollection.size() <= 0))
    {
      AppMethodBeat.o(188217);
      return true;
    }
    AppMethodBeat.o(188217);
    return false;
  }
  
  public static boolean isEmpty(Map<? extends Object, ? extends Object> paramMap)
  {
    AppMethodBeat.i(188218);
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      AppMethodBeat.o(188218);
      return true;
    }
    AppMethodBeat.o(188218);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.b
 * JD-Core Version:    0.7.0.1
 */