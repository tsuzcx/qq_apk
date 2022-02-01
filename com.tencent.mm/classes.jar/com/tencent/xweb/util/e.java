package com.tencent.xweb.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;
import org.xwalk.core.Log;

public final class e
{
  public static double Xf(long paramLong)
  {
    AppMethodBeat.i(196965);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int i = localCalendar.get(11);
    double d2 = localCalendar.get(12);
    double d1 = i;
    d2 /= 60.0D;
    AppMethodBeat.o(196965);
    return d1 + d2;
  }
  
  public static a bFB(String paramString)
  {
    AppMethodBeat.i(196952);
    a locala = new a();
    try
    {
      locala.aafQ = Double.valueOf(Double.parseDouble(paramString));
      locala.aafP = true;
      AppMethodBeat.o(196952);
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
  
  public static a bFC(String paramString)
  {
    AppMethodBeat.i(196957);
    a locala = new a();
    try
    {
      for (paramString = paramString.trim(); (paramString.startsWith("0")) && (paramString.length() > 1); paramString = paramString.substring(1)) {}
      locala.aafQ = Integer.valueOf(Integer.parseInt(paramString));
      locala.aafP = true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("NumberUtil", "safeParseInt failed : " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(196957);
    return locala;
  }
  
  public static double bFD(String paramString)
  {
    AppMethodBeat.i(196970);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(196970);
      return -1.0D;
    }
    paramString = paramString.split(":");
    if ((paramString == null) || (paramString.length == 0))
    {
      AppMethodBeat.o(196970);
      return -1.0D;
    }
    a locala = bFB(paramString[0]);
    if (!locala.aafP)
    {
      AppMethodBeat.o(196970);
      return -1.0D;
    }
    double d2 = locala.doubleValue();
    double d1 = d2;
    if (paramString.length == 2)
    {
      int i = bFC(paramString[1]).intValue();
      if ((i < 0) || (i >= 60))
      {
        AppMethodBeat.o(196970);
        return -1.0D;
      }
      d1 = d2 + i * 1.0D / 60.0D;
    }
    if ((d1 < 0.0D) || (d1 > 24.0D))
    {
      AppMethodBeat.o(196970);
      return -1.0D;
    }
    AppMethodBeat.o(196970);
    return d1;
  }
  
  public static long c(Calendar paramCalendar)
  {
    AppMethodBeat.i(196963);
    int i = paramCalendar.get(11);
    int j = paramCalendar.get(12);
    int k = paramCalendar.get(13);
    long l1 = 24 - i;
    long l2 = j;
    long l3 = k * 1000;
    AppMethodBeat.o(196963);
    return l1 * 3600000L - l2 * 60000L - l3;
  }
  
  public static double d(Calendar paramCalendar)
  {
    AppMethodBeat.i(196968);
    int i = paramCalendar.get(11);
    double d2 = paramCalendar.get(12);
    double d1 = i;
    d2 /= 60.0D;
    AppMethodBeat.o(196968);
    return d1 + d2;
  }
  
  public static long ixA()
  {
    AppMethodBeat.i(196959);
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    long l1 = 24 - i;
    long l2 = j;
    AppMethodBeat.o(196959);
    return l1 * 3600000L - l2 * 60000L;
  }
  
  public static double ixB()
  {
    AppMethodBeat.i(196967);
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    double d2 = localCalendar.get(12);
    double d1 = i;
    d2 /= 60.0D;
    AppMethodBeat.o(196967);
    return d1 + d2;
  }
  
  public static final class a
  {
    public boolean aafP = false;
    public Object aafQ;
    
    public final double doubleValue()
    {
      AppMethodBeat.i(197019);
      if (this.aafQ == null)
      {
        AppMethodBeat.o(197019);
        return 0.0D;
      }
      double d = ((Double)this.aafQ).doubleValue();
      AppMethodBeat.o(197019);
      return d;
    }
    
    public final int intValue()
    {
      AppMethodBeat.i(197021);
      if (this.aafQ == null)
      {
        AppMethodBeat.o(197021);
        return 0;
      }
      int i = ((Integer)this.aafQ).intValue();
      AppMethodBeat.o(197021);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.util.e
 * JD-Core Version:    0.7.0.1
 */