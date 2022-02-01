package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;
import org.xwalk.core.Log;

public final class e
{
  public static double FI(long paramLong)
  {
    AppMethodBeat.i(217423);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int i = localCalendar.get(11);
    double d2 = localCalendar.get(12);
    double d1 = i;
    d2 /= 60.0D;
    AppMethodBeat.o(217423);
    return d1 + d2;
  }
  
  public static a bcR(String paramString)
  {
    AppMethodBeat.i(217419);
    a locala = new a();
    try
    {
      locala.MRC = Double.valueOf(Double.parseDouble(paramString));
      locala.MRB = true;
      AppMethodBeat.o(217419);
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
  
  public static a bcS(String paramString)
  {
    AppMethodBeat.i(217420);
    a locala = new a();
    try
    {
      for (paramString = paramString.trim(); (paramString.startsWith("0")) && (paramString.length() > 1); paramString = paramString.substring(1)) {}
      locala.MRC = Integer.valueOf(Integer.parseInt(paramString));
      locala.MRB = true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("NumberUtil", "safeParseInt failed : " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(217420);
    return locala;
  }
  
  public static long c(Calendar paramCalendar)
  {
    AppMethodBeat.i(217422);
    int i = paramCalendar.get(11);
    int j = paramCalendar.get(12);
    int k = paramCalendar.get(13);
    long l1 = 24 - i;
    long l2 = j;
    long l3 = k * 1000;
    AppMethodBeat.o(217422);
    return l1 * 3600000L - l2 * 60000L - l3;
  }
  
  public static double d(Calendar paramCalendar)
  {
    AppMethodBeat.i(217425);
    int i = paramCalendar.get(11);
    double d2 = paramCalendar.get(12);
    double d1 = i;
    d2 /= 60.0D;
    AppMethodBeat.o(217425);
    return d1 + d2;
  }
  
  public static double ggA()
  {
    AppMethodBeat.i(217424);
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    double d2 = localCalendar.get(12);
    double d1 = i;
    d2 /= 60.0D;
    AppMethodBeat.o(217424);
    return d1 + d2;
  }
  
  public static long ggz()
  {
    AppMethodBeat.i(217421);
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    long l1 = 24 - i;
    long l2 = j;
    AppMethodBeat.o(217421);
    return l1 * 3600000L - l2 * 60000L;
  }
  
  public static final class a
  {
    public boolean MRB = false;
    public Object MRC;
    
    public final double doubleValue()
    {
      AppMethodBeat.i(217417);
      if (this.MRC == null)
      {
        AppMethodBeat.o(217417);
        return 0.0D;
      }
      double d = ((Double)this.MRC).doubleValue();
      AppMethodBeat.o(217417);
      return d;
    }
    
    public final int intValue()
    {
      AppMethodBeat.i(217418);
      if (this.MRC == null)
      {
        AppMethodBeat.o(217418);
        return 0;
      }
      int i = ((Integer)this.MRC).intValue();
      AppMethodBeat.o(217418);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.util.e
 * JD-Core Version:    0.7.0.1
 */