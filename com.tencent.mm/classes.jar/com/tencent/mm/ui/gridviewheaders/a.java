package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.k;
import java.util.Calendar;
import java.util.Date;

public class a
{
  private static a afvi;
  private long afvf;
  private long afvg;
  private long afvh;
  
  private a()
  {
    AppMethodBeat.i(142754);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(7, 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    this.afvg = localCalendar.getTimeInMillis();
    localCalendar = Calendar.getInstance();
    localCalendar.set(5, 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    this.afvh = localCalendar.getTimeInMillis();
    this.afvf = Calendar.getInstance().getTimeInMillis();
    AppMethodBeat.o(142754);
  }
  
  public static long Aw(long paramLong)
  {
    AppMethodBeat.i(142756);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    localCalendar.set(5, 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    paramLong = localCalendar.getTimeInMillis();
    AppMethodBeat.o(142756);
    return paramLong;
  }
  
  private static long c(Date paramDate)
  {
    AppMethodBeat.i(142757);
    long l = paramDate.getYear() * 100 + paramDate.getMonth();
    AppMethodBeat.o(142757);
    return l;
  }
  
  public static a jBw()
  {
    AppMethodBeat.i(142753);
    if (afvi == null) {}
    try
    {
      afvi = new a();
      a locala = afvi;
      AppMethodBeat.o(142753);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(142753);
    }
  }
  
  public final String a(Date paramDate, Context paramContext)
  {
    AppMethodBeat.i(142758);
    if (paramDate.getTime() >= this.afvg)
    {
      paramDate = paramContext.getString(a.k.this_week);
      AppMethodBeat.o(142758);
      return paramDate;
    }
    if (paramDate.getTime() >= this.afvh)
    {
      paramDate = paramContext.getString(a.k.this_month);
      AppMethodBeat.o(142758);
      return paramDate;
    }
    paramDate = paramDate.getYear() + 1900 + "/" + (paramDate.getMonth() + 1);
    AppMethodBeat.o(142758);
    return paramDate;
  }
  
  public final long b(Date paramDate)
  {
    AppMethodBeat.i(142755);
    if (paramDate.getTime() >= this.afvg)
    {
      AppMethodBeat.o(142755);
      return 9223372036854775807L;
    }
    if (paramDate.getTime() >= this.afvh)
    {
      AppMethodBeat.o(142755);
      return 9223372036854775806L;
    }
    long l = c(paramDate);
    AppMethodBeat.o(142755);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.a
 * JD-Core Version:    0.7.0.1
 */