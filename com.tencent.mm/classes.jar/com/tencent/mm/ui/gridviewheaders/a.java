package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;
import java.util.Date;

public class a
{
  private static a IJp;
  private long IJm;
  private long IJn;
  private long IJo;
  
  private a()
  {
    AppMethodBeat.i(142754);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(7, 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    this.IJn = localCalendar.getTimeInMillis();
    localCalendar = Calendar.getInstance();
    localCalendar.set(5, 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    this.IJo = localCalendar.getTimeInMillis();
    this.IJm = Calendar.getInstance().getTimeInMillis();
    AppMethodBeat.o(142754);
  }
  
  public static long By(long paramLong)
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
  
  public static a fsS()
  {
    AppMethodBeat.i(142753);
    if (IJp == null) {}
    try
    {
      IJp = new a();
      a locala = IJp;
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
    if (paramDate.getTime() >= this.IJn)
    {
      paramDate = paramContext.getString(2131764412);
      AppMethodBeat.o(142758);
      return paramDate;
    }
    if (paramDate.getTime() >= this.IJo)
    {
      paramDate = paramContext.getString(2131764411);
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
    if (paramDate.getTime() >= this.IJn)
    {
      AppMethodBeat.o(142755);
      return 9223372036854775807L;
    }
    if (paramDate.getTime() >= this.IJo)
    {
      AppMethodBeat.o(142755);
      return 9223372036854775806L;
    }
    long l = c(paramDate);
    AppMethodBeat.o(142755);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.a
 * JD-Core Version:    0.7.0.1
 */