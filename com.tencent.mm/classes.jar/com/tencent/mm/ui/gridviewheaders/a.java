package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;
import java.util.Date;

public class a
{
  private static a AoA;
  private long Aox;
  private long Aoy;
  private long Aoz;
  
  private a()
  {
    AppMethodBeat.i(107324);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(7, 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    this.Aoy = localCalendar.getTimeInMillis();
    localCalendar = Calendar.getInstance();
    localCalendar.set(5, 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    this.Aoz = localCalendar.getTimeInMillis();
    this.Aox = Calendar.getInstance().getTimeInMillis();
    AppMethodBeat.o(107324);
  }
  
  private static long c(Date paramDate)
  {
    AppMethodBeat.i(107327);
    long l = paramDate.getYear() * 100 + paramDate.getMonth();
    AppMethodBeat.o(107327);
    return l;
  }
  
  public static a dNj()
  {
    AppMethodBeat.i(107323);
    if (AoA == null) {}
    try
    {
      AoA = new a();
      a locala = AoA;
      AppMethodBeat.o(107323);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(107323);
    }
  }
  
  public static long oS(long paramLong)
  {
    AppMethodBeat.i(107326);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    localCalendar.set(5, 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    paramLong = localCalendar.getTimeInMillis();
    AppMethodBeat.o(107326);
    return paramLong;
  }
  
  public final String a(Date paramDate, Context paramContext)
  {
    AppMethodBeat.i(107328);
    if (paramDate.getTime() >= this.Aoy)
    {
      paramDate = paramContext.getString(2131304286);
      AppMethodBeat.o(107328);
      return paramDate;
    }
    if (paramDate.getTime() >= this.Aoz)
    {
      paramDate = paramContext.getString(2131304285);
      AppMethodBeat.o(107328);
      return paramDate;
    }
    paramDate = String.format("%d/%d", new Object[] { Integer.valueOf(paramDate.getYear() + 1900), Integer.valueOf(paramDate.getMonth() + 1) });
    AppMethodBeat.o(107328);
    return paramDate;
  }
  
  public final long b(Date paramDate)
  {
    AppMethodBeat.i(107325);
    if (paramDate.getTime() >= this.Aoy)
    {
      AppMethodBeat.o(107325);
      return 9223372036854775807L;
    }
    if (paramDate.getTime() >= this.Aoz)
    {
      AppMethodBeat.o(107325);
      return 9223372036854775806L;
    }
    long l = c(paramDate);
    AppMethodBeat.o(107325);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.a
 * JD-Core Version:    0.7.0.1
 */