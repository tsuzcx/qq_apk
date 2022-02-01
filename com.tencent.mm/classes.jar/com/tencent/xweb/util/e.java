package com.tencent.xweb.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;
import org.xwalk.core.Log;

public final class e
{
  public static double OP(long paramLong)
  {
    AppMethodBeat.i(219082);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int i = localCalendar.get(11);
    double d2 = localCalendar.get(12);
    double d1 = i;
    d2 /= 60.0D;
    AppMethodBeat.o(219082);
    return d1 + d2;
  }
  
  public static a bsC(String paramString)
  {
    AppMethodBeat.i(219078);
    a locala = new a();
    try
    {
      locala.SEG = Double.valueOf(Double.parseDouble(paramString));
      locala.SEF = true;
      AppMethodBeat.o(219078);
      return locala;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("NumberUtil", "safeGetDouble failed : " + paramString.getMessage());
      }
    }
  }
  
  public static a bsD(String paramString)
  {
    AppMethodBeat.i(219079);
    a locala = new a();
    try
    {
      for (paramString = paramString.trim(); (paramString.startsWith("0")) && (paramString.length() > 1); paramString = paramString.substring(1)) {}
      locala.SEG = Integer.valueOf(Integer.parseInt(paramString));
      locala.SEF = true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("NumberUtil", "safeParseInt failed : " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(219079);
    return locala;
  }
  
  public static double bsE(String paramString)
  {
    AppMethodBeat.i(219085);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(219085);
      return -1.0D;
    }
    paramString = paramString.split(":");
    if ((paramString == null) || (paramString.length == 0))
    {
      AppMethodBeat.o(219085);
      return -1.0D;
    }
    a locala = bsC(paramString[0]);
    if (!locala.SEF)
    {
      AppMethodBeat.o(219085);
      return -1.0D;
    }
    double d2 = locala.doubleValue();
    double d1 = d2;
    if (paramString.length == 2)
    {
      int i = bsD(paramString[1]).intValue();
      if ((i < 0) || (i >= 60))
      {
        AppMethodBeat.o(219085);
        return -1.0D;
      }
      d1 = d2 + i * 1.0D / 60.0D;
    }
    if ((d1 < 0.0D) || (d1 > 24.0D))
    {
      AppMethodBeat.o(219085);
      return -1.0D;
    }
    AppMethodBeat.o(219085);
    return d1;
  }
  
  public static long c(Calendar paramCalendar)
  {
    AppMethodBeat.i(219081);
    int i = paramCalendar.get(11);
    int j = paramCalendar.get(12);
    int k = paramCalendar.get(13);
    long l1 = 24 - i;
    long l2 = j;
    long l3 = k * 1000;
    AppMethodBeat.o(219081);
    return l1 * 3600000L - l2 * 60000L - l3;
  }
  
  public static double d(Calendar paramCalendar)
  {
    AppMethodBeat.i(219084);
    int i = paramCalendar.get(11);
    double d2 = paramCalendar.get(12);
    double d1 = i;
    d2 /= 60.0D;
    AppMethodBeat.o(219084);
    return d1 + d2;
  }
  
  public static long htR()
  {
    AppMethodBeat.i(219080);
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    long l1 = 24 - i;
    long l2 = j;
    AppMethodBeat.o(219080);
    return l1 * 3600000L - l2 * 60000L;
  }
  
  public static double htS()
  {
    AppMethodBeat.i(219083);
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    double d2 = localCalendar.get(12);
    double d1 = i;
    d2 /= 60.0D;
    AppMethodBeat.o(219083);
    return d1 + d2;
  }
  
  public static final class a
  {
    public boolean SEF = false;
    public Object SEG;
    
    public final double doubleValue()
    {
      AppMethodBeat.i(219076);
      if (this.SEG == null)
      {
        AppMethodBeat.o(219076);
        return 0.0D;
      }
      double d = ((Double)this.SEG).doubleValue();
      AppMethodBeat.o(219076);
      return d;
    }
    
    public final int intValue()
    {
      AppMethodBeat.i(219077);
      if (this.SEG == null)
      {
        AppMethodBeat.o(219077);
        return 0;
      }
      int i = ((Integer)this.SEG).intValue();
      AppMethodBeat.o(219077);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.util.e
 * JD-Core Version:    0.7.0.1
 */