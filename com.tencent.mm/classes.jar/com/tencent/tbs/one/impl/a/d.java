package com.tencent.tbs.one.impl.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class d
{
  public static String a;
  public static String b;
  public static String c;
  private static String d;
  
  public static String a()
  {
    AppMethodBeat.i(173921);
    if (!TextUtils.isEmpty(d))
    {
      localObject1 = d;
      AppMethodBeat.o(173921);
      return localObject1;
    }
    Locale localLocale = Locale.getDefault();
    localStringBuilder = new StringBuilder();
    localObject1 = Build.VERSION.RELEASE;
    try
    {
      localObject2 = new String(((String)localObject1).getBytes("UTF-8"), "ISO8859-1");
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject2;
        continue;
        localStringBuilder.append("en");
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "1.0";
    }
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("; ");
    localObject1 = localLocale.getLanguage();
    if (localObject1 != null)
    {
      localStringBuilder.append(((String)localObject1).toLowerCase());
      localObject1 = localLocale.getCountry();
      if (localObject1 != null)
      {
        localStringBuilder.append("-");
        localStringBuilder.append(((String)localObject1).toLowerCase());
      }
      if ("REL".equals(Build.VERSION.CODENAME)) {
        localObject1 = Build.MODEL;
      }
    }
    try
    {
      localObject2 = new String(((String)localObject1).getBytes("UTF-8"), "ISO8859-1");
      localObject1 = localObject2;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        continue;
        localObject1 = Build.ID.replaceAll("[一-龥]", "");
      }
    }
    localStringBuilder.append("; ");
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "";
    }
    localStringBuilder.append((String)localObject2);
    if (Build.ID == null)
    {
      localObject1 = null;
      localStringBuilder.append(" Build/");
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "00";
      }
      localStringBuilder.append((String)localObject2);
      localObject1 = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[] { localStringBuilder });
      d = (String)localObject1;
      AppMethodBeat.o(173921);
      return localObject1;
    }
  }
  
  public static String a(long paramLong)
  {
    AppMethodBeat.i(173923);
    String str = String.format(Locale.getDefault(), "%d(%s)", new Object[] { Long.valueOf(paramLong), new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(paramLong)) });
    AppMethodBeat.o(173923);
    return str;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(173922);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      AppMethodBeat.o(173922);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      if ((k & 0xFF) < 16) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(Long.toString(k & 0xFF, 16));
      i += 1;
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(173922);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.d
 * JD-Core Version:    0.7.0.1
 */