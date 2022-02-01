package com.tencent.xweb.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;
import org.xwalk.core.Log;

public final class i
{
  public static a bIa(String paramString)
  {
    AppMethodBeat.i(212616);
    a locala = new a();
    try
    {
      locala.aimE = Double.valueOf(Double.parseDouble(paramString));
      locala.aimD = true;
      AppMethodBeat.o(212616);
      return locala;
    }
    finally
    {
      for (;;)
      {
        Log.e("NumberUtil", "safeParseDouble error:".concat(String.valueOf(paramString)));
      }
    }
  }
  
  public static a bIb(String paramString)
  {
    AppMethodBeat.i(212624);
    a locala = new a();
    try
    {
      for (paramString = paramString.trim(); (paramString.startsWith("0")) && (paramString.length() > 1); paramString = paramString.substring(1)) {}
      locala.aimE = Integer.valueOf(Integer.parseInt(paramString));
      locala.aimD = true;
    }
    finally
    {
      for (;;)
      {
        Log.e("NumberUtil", "safeParseInt error:".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(212624);
    return locala;
  }
  
  public static double bIc(String paramString)
  {
    AppMethodBeat.i(212640);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(212640);
      return -1.0D;
    }
    paramString = paramString.split(":");
    if ((paramString == null) || (paramString.length == 0))
    {
      AppMethodBeat.o(212640);
      return -1.0D;
    }
    a locala = bIa(paramString[0]);
    if (!locala.aimD)
    {
      AppMethodBeat.o(212640);
      return -1.0D;
    }
    double d2 = locala.doubleValue();
    double d1 = d2;
    if (paramString.length == 2)
    {
      int i = bIb(paramString[1]).intValue();
      if ((i < 0) || (i >= 60))
      {
        AppMethodBeat.o(212640);
        return -1.0D;
      }
      d1 = d2 + i * 1.0D / 60.0D;
    }
    if ((d1 < 0.0D) || (d1 > 24.0D))
    {
      AppMethodBeat.o(212640);
      return -1.0D;
    }
    AppMethodBeat.o(212640);
    return d1;
  }
  
  public static long khB()
  {
    AppMethodBeat.i(212630);
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    long l1 = 24 - i;
    long l2 = j;
    AppMethodBeat.o(212630);
    return l1 * 3600000L - l2 * 60000L;
  }
  
  public static double khC()
  {
    AppMethodBeat.i(212633);
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    double d2 = localCalendar.get(12);
    double d1 = i;
    d2 /= 60.0D;
    AppMethodBeat.o(212633);
    return d1 + d2;
  }
  
  public static final class a
  {
    public boolean aimD = false;
    public Object aimE;
    
    public final double doubleValue()
    {
      AppMethodBeat.i(212581);
      if (this.aimE == null)
      {
        AppMethodBeat.o(212581);
        return 0.0D;
      }
      double d = ((Double)this.aimE).doubleValue();
      AppMethodBeat.o(212581);
      return d;
    }
    
    public final int intValue()
    {
      AppMethodBeat.i(212585);
      if (this.aimE == null)
      {
        AppMethodBeat.o(212585);
        return 0;
      }
      int i = ((Integer)this.aimE).intValue();
      AppMethodBeat.o(212585);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.util.i
 * JD-Core Version:    0.7.0.1
 */