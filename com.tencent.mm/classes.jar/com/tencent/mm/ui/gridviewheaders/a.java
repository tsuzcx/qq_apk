package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import com.tencent.mm.ac.a.k;
import java.util.Calendar;
import java.util.Date;

public class a
{
  private static a vWs;
  private long vWp;
  private long vWq;
  private long vWr;
  
  private a()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(7, 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    this.vWq = localCalendar.getTimeInMillis();
    localCalendar = Calendar.getInstance();
    localCalendar.set(5, 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    this.vWr = localCalendar.getTimeInMillis();
    this.vWp = Calendar.getInstance().getTimeInMillis();
  }
  
  public static a cIz()
  {
    if (vWs == null) {}
    try
    {
      vWs = new a();
      return vWs;
    }
    finally {}
  }
  
  public static long ig(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    localCalendar.set(5, 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public final String a(Date paramDate, Context paramContext)
  {
    if (paramDate.getTime() >= this.vWq) {
      return paramContext.getString(a.k.this_week);
    }
    if (paramDate.getTime() >= this.vWr) {
      return paramContext.getString(a.k.this_month);
    }
    return String.format("%d/%d", new Object[] { Integer.valueOf(paramDate.getYear() + 1900), Integer.valueOf(paramDate.getMonth() + 1) });
  }
  
  public final long b(Date paramDate)
  {
    if (paramDate.getTime() >= this.vWq) {
      return 9223372036854775807L;
    }
    if (paramDate.getTime() >= this.vWr) {
      return 9223372036854775806L;
    }
    return paramDate.getYear() * 100 + paramDate.getMonth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.a
 * JD-Core Version:    0.7.0.1
 */