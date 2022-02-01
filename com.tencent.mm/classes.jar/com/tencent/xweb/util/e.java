package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;
import org.xwalk.core.Log;

public final class e
{
  public static double Ce(long paramLong)
  {
    AppMethodBeat.i(205093);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int i = localCalendar.get(11);
    double d2 = localCalendar.get(12);
    double d1 = i;
    d2 /= 60.0D;
    AppMethodBeat.o(205093);
    return d1 + d2;
  }
  
  public static a aVl(String paramString)
  {
    AppMethodBeat.i(205090);
    a locala = new a();
    try
    {
      locala.KDY = Double.valueOf(Double.parseDouble(paramString));
      locala.KDX = true;
      AppMethodBeat.o(205090);
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
  
  public static a aVm(String paramString)
  {
    AppMethodBeat.i(205091);
    a locala = new a();
    try
    {
      for (paramString = paramString.trim(); (paramString.startsWith("0")) && (paramString.length() > 1); paramString = paramString.substring(1)) {}
      locala.KDY = Integer.valueOf(Integer.parseInt(paramString));
      locala.KDX = true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("NumberUtil", "safeParseInt failed : " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(205091);
    return locala;
  }
  
  public static long c(Calendar paramCalendar)
  {
    AppMethodBeat.i(210394);
    int i = paramCalendar.get(11);
    int j = paramCalendar.get(12);
    int k = paramCalendar.get(13);
    long l1 = 24 - i;
    long l2 = j;
    long l3 = k * 1000;
    AppMethodBeat.o(210394);
    return l1 * 3600000L - l2 * 60000L - l3;
  }
  
  public static long fKC()
  {
    AppMethodBeat.i(205092);
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    long l1 = 24 - i;
    long l2 = j;
    AppMethodBeat.o(205092);
    return l1 * 3600000L - l2 * 60000L;
  }
  
  public static double fKD()
  {
    AppMethodBeat.i(205094);
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    double d2 = localCalendar.get(12);
    double d1 = i;
    d2 /= 60.0D;
    AppMethodBeat.o(205094);
    return d1 + d2;
  }
  
  public static final class a
  {
    public boolean KDX = false;
    public Object KDY;
    
    public final double doubleValue()
    {
      AppMethodBeat.i(205088);
      if (this.KDY == null)
      {
        AppMethodBeat.o(205088);
        return 0.0D;
      }
      double d = ((Double)this.KDY).doubleValue();
      AppMethodBeat.o(205088);
      return d;
    }
    
    public final int intValue()
    {
      AppMethodBeat.i(205089);
      if (this.KDY == null)
      {
        AppMethodBeat.o(205089);
        return 0;
      }
      int i = ((Integer)this.KDY).intValue();
      AppMethodBeat.o(205089);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.util.e
 * JD-Core Version:    0.7.0.1
 */