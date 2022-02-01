package com.tencent.thumbplayer.utils;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public final class b
{
  public static final int SDK_INT;
  
  static
  {
    AppMethodBeat.i(189625);
    if ((Build.VERSION.SDK_INT == 25) && (Build.VERSION.CODENAME.charAt(0) == 'O')) {}
    for (int i = 26;; i = Build.VERSION.SDK_INT)
    {
      SDK_INT = i;
      AppMethodBeat.o(189625);
      return;
    }
  }
  
  public static String aSu(String paramString)
  {
    AppMethodBeat.i(189621);
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
        g.e("TPCommonUtils", paramString.toString());
        AppMethodBeat.o(189621);
        return null;
      }
      paramString = localStringBuilder.toString();
      AppMethodBeat.o(189621);
      return paramString;
      i += 1;
    }
  }
  
  public static boolean bnL(String paramString)
  {
    AppMethodBeat.i(189624);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(189624);
      return false;
    }
    try
    {
      paramString = paramString.split(":");
      boolean bool = paramString[0].matches("^((https|http|ftp|rtsp|mms)?)");
      AppMethodBeat.o(189624);
      return bool;
    }
    catch (PatternSyntaxException paramString)
    {
      AppMethodBeat.o(189624);
    }
    return false;
  }
  
  public static int bqF(String paramString)
  {
    AppMethodBeat.i(189622);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = Integer.parseInt(paramString);
        AppMethodBeat.o(189622);
        return i;
      }
      catch (NumberFormatException paramString)
      {
        g.e("TPCommonUtils", paramString);
      }
    }
    AppMethodBeat.o(189622);
    return 0;
  }
  
  public static void e(Object paramObject, String paramString)
  {
    AppMethodBeat.i(189620);
    if (paramObject == null)
    {
      if (!TextUtils.isEmpty(paramString)) {}
      for (;;)
      {
        paramObject = new IllegalArgumentException(paramString);
        AppMethodBeat.o(189620);
        throw paramObject;
        paramString = "this argument should not be null!";
      }
    }
    AppMethodBeat.o(189620);
  }
  
  public static boolean isEmpty(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(189618);
    if ((paramCollection == null) || (paramCollection.size() <= 0))
    {
      AppMethodBeat.o(189618);
      return true;
    }
    AppMethodBeat.o(189618);
    return false;
  }
  
  public static boolean isEmpty(Map<? extends Object, ? extends Object> paramMap)
  {
    AppMethodBeat.i(189619);
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      AppMethodBeat.o(189619);
      return true;
    }
    AppMethodBeat.o(189619);
    return false;
  }
  
  public static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(189623);
    Pattern localPattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
    try
    {
      paramString = new BigDecimal(paramString).toString();
      if (!localPattern.matcher(paramString).matches())
      {
        AppMethodBeat.o(189623);
        return false;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(189623);
      return false;
    }
    AppMethodBeat.o(189623);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.b
 * JD-Core Version:    0.7.0.1
 */