package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

final class df
  implements dp<java.util.Date>, dx<java.util.Date>
{
  private final DateFormat a;
  private final DateFormat b;
  private final DateFormat c;
  
  df()
  {
    this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    AppMethodBeat.i(147435);
    AppMethodBeat.o(147435);
  }
  
  public df(int paramInt1, int paramInt2)
  {
    this(DateFormat.getDateTimeInstance(paramInt1, paramInt2, Locale.US), DateFormat.getDateTimeInstance(paramInt1, paramInt2));
    AppMethodBeat.i(147437);
    AppMethodBeat.o(147437);
  }
  
  df(String paramString)
  {
    this(new SimpleDateFormat(paramString, Locale.US), new SimpleDateFormat(paramString));
    AppMethodBeat.i(147436);
    AppMethodBeat.o(147436);
  }
  
  df(DateFormat paramDateFormat1, DateFormat paramDateFormat2)
  {
    AppMethodBeat.i(147438);
    this.a = paramDateFormat1;
    this.b = paramDateFormat2;
    this.c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    this.c.setTimeZone(TimeZone.getTimeZone("UTC"));
    AppMethodBeat.o(147438);
  }
  
  private java.util.Date a(dq paramdq)
  {
    AppMethodBeat.i(147441);
    synchronized (this.b)
    {
      try
      {
        java.util.Date localDate1 = this.b.parse(paramdq.c());
        AppMethodBeat.o(147441);
        return localDate1;
      }
      catch (ParseException localParseException1)
      {
        try
        {
          java.util.Date localDate2 = this.a.parse(paramdq.c());
          AppMethodBeat.o(147441);
          return localDate2;
        }
        catch (ParseException localParseException2)
        {
          try
          {
            java.util.Date localDate3 = this.c.parse(paramdq.c());
            AppMethodBeat.o(147441);
            return localDate3;
          }
          catch (ParseException localParseException3)
          {
            paramdq = new dy(paramdq.c(), localParseException3);
            AppMethodBeat.o(147441);
            throw paramdq;
          }
        }
      }
    }
  }
  
  public final dq a(java.util.Date paramDate, Type arg2, dw paramdw)
  {
    AppMethodBeat.i(147439);
    synchronized (this.b)
    {
      paramDate = new dv(this.a.format(paramDate));
      AppMethodBeat.o(147439);
      return paramDate;
    }
  }
  
  public final java.util.Date a(dq paramdq, Type paramType, do paramdo)
  {
    AppMethodBeat.i(147440);
    if (!(paramdq instanceof dv))
    {
      paramdq = new du("The date should be a string value");
      AppMethodBeat.o(147440);
      throw paramdq;
    }
    paramdq = a(paramdq);
    if (paramType == java.util.Date.class)
    {
      AppMethodBeat.o(147440);
      return paramdq;
    }
    if (paramType == Timestamp.class)
    {
      paramdq = new Timestamp(paramdq.getTime());
      AppMethodBeat.o(147440);
      return paramdq;
    }
    if (paramType == java.sql.Date.class)
    {
      paramdq = new java.sql.Date(paramdq.getTime());
      AppMethodBeat.o(147440);
      return paramdq;
    }
    paramdq = new IllegalArgumentException(getClass() + " cannot deserialize to " + paramType);
    AppMethodBeat.o(147440);
    throw paramdq;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(147442);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(df.class.getSimpleName());
    ((StringBuilder)localObject).append('(').append(this.b.getClass().getSimpleName()).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(147442);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.df
 * JD-Core Version:    0.7.0.1
 */