package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;
import org.xwalk.core.Log;

public final class e
{
  public static a aPs(String paramString)
  {
    AppMethodBeat.i(195178);
    a locala = new a();
    try
    {
      locala.IRC = Double.valueOf(Double.parseDouble(paramString));
      locala.IRB = true;
      AppMethodBeat.o(195178);
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
  
  public static a aPt(String paramString)
  {
    AppMethodBeat.i(195179);
    a locala = new a();
    try
    {
      locala.IRC = Integer.valueOf(Integer.parseInt(paramString));
      locala.IRB = true;
      AppMethodBeat.o(195179);
      return locala;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("NumberUtil", "safeParseInt failed : " + paramString.getMessage());
      }
    }
  }
  
  public static long frZ()
  {
    AppMethodBeat.i(195180);
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    long l1 = 24 - i;
    long l2 = j;
    AppMethodBeat.o(195180);
    return l1 * 3600000L - l2 * 60000L;
  }
  
  public static double fsa()
  {
    AppMethodBeat.i(195181);
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    double d2 = localCalendar.get(12);
    double d1 = i;
    d2 /= 60.0D;
    AppMethodBeat.o(195181);
    return d1 + d2;
  }
  
  public static final class a
  {
    public boolean IRB = false;
    public Object IRC;
    
    public final double doubleValue()
    {
      AppMethodBeat.i(195176);
      if (this.IRC == null)
      {
        AppMethodBeat.o(195176);
        return 0.0D;
      }
      double d = ((Double)this.IRC).doubleValue();
      AppMethodBeat.o(195176);
      return d;
    }
    
    public final int intValue()
    {
      AppMethodBeat.i(195177);
      if (this.IRC == null)
      {
        AppMethodBeat.o(195177);
        return 0;
      }
      int i = ((Integer)this.IRC).intValue();
      AppMethodBeat.o(195177);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.util.e
 * JD-Core Version:    0.7.0.1
 */