package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;
import org.xwalk.core.Log;

public final class e
{
  public static double Fg(long paramLong)
  {
    AppMethodBeat.i(197105);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int i = localCalendar.get(11);
    double d2 = localCalendar.get(12);
    double d1 = i;
    d2 /= 60.0D;
    AppMethodBeat.o(197105);
    return d1 + d2;
  }
  
  public static a bbo(String paramString)
  {
    AppMethodBeat.i(197101);
    a locala = new a();
    try
    {
      locala.Muy = Double.valueOf(Double.parseDouble(paramString));
      locala.Mux = true;
      AppMethodBeat.o(197101);
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
  
  public static a bbp(String paramString)
  {
    AppMethodBeat.i(197102);
    a locala = new a();
    try
    {
      for (paramString = paramString.trim(); (paramString.startsWith("0")) && (paramString.length() > 1); paramString = paramString.substring(1)) {}
      locala.Muy = Integer.valueOf(Integer.parseInt(paramString));
      locala.Mux = true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("NumberUtil", "safeParseInt failed : " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(197102);
    return locala;
  }
  
  public static long c(Calendar paramCalendar)
  {
    AppMethodBeat.i(197104);
    int i = paramCalendar.get(11);
    int j = paramCalendar.get(12);
    int k = paramCalendar.get(13);
    long l1 = 24 - i;
    long l2 = j;
    long l3 = k * 1000;
    AppMethodBeat.o(197104);
    return l1 * 3600000L - l2 * 60000L - l3;
  }
  
  public static double d(Calendar paramCalendar)
  {
    AppMethodBeat.i(197107);
    int i = paramCalendar.get(11);
    double d2 = paramCalendar.get(12);
    double d1 = i;
    d2 /= 60.0D;
    AppMethodBeat.o(197107);
    return d1 + d2;
  }
  
  public static long gbX()
  {
    AppMethodBeat.i(197103);
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    long l1 = 24 - i;
    long l2 = j;
    AppMethodBeat.o(197103);
    return l1 * 3600000L - l2 * 60000L;
  }
  
  public static double gbY()
  {
    AppMethodBeat.i(197106);
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    double d2 = localCalendar.get(12);
    double d1 = i;
    d2 /= 60.0D;
    AppMethodBeat.o(197106);
    return d1 + d2;
  }
  
  public static final class a
  {
    public boolean Mux = false;
    public Object Muy;
    
    public final double doubleValue()
    {
      AppMethodBeat.i(197099);
      if (this.Muy == null)
      {
        AppMethodBeat.o(197099);
        return 0.0D;
      }
      double d = ((Double)this.Muy).doubleValue();
      AppMethodBeat.o(197099);
      return d;
    }
    
    public final int intValue()
    {
      AppMethodBeat.i(197100);
      if (this.Muy == null)
      {
        AppMethodBeat.o(197100);
        return 0;
      }
      int i = ((Integer)this.Muy).intValue();
      AppMethodBeat.o(197100);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.util.e
 * JD-Core Version:    0.7.0.1
 */