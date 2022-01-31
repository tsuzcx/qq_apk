package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class fd$16
  extends eb<Calendar>
{
  public final Calendar a(ff paramff)
  {
    AppMethodBeat.i(147772);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147772);
      return null;
    }
    paramff.c();
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    while (paramff.f() != fg.d)
    {
      String str = paramff.g();
      int i = paramff.m();
      if ("year".equals(str)) {
        i2 = i;
      } else if ("month".equals(str)) {
        i1 = i;
      } else if ("dayOfMonth".equals(str)) {
        n = i;
      } else if ("hourOfDay".equals(str)) {
        m = i;
      } else if ("minute".equals(str)) {
        k = i;
      } else if ("second".equals(str)) {
        j = i;
      }
    }
    paramff.d();
    paramff = new GregorianCalendar(i2, i1, n, m, k, j);
    AppMethodBeat.o(147772);
    return paramff;
  }
  
  public final void a(fh paramfh, Calendar paramCalendar)
  {
    AppMethodBeat.i(147773);
    if (paramCalendar == null)
    {
      paramfh.f();
      AppMethodBeat.o(147773);
      return;
    }
    paramfh.d();
    paramfh.a("year");
    paramfh.a(paramCalendar.get(1));
    paramfh.a("month");
    paramfh.a(paramCalendar.get(2));
    paramfh.a("dayOfMonth");
    paramfh.a(paramCalendar.get(5));
    paramfh.a("hourOfDay");
    paramfh.a(paramCalendar.get(11));
    paramfh.a("minute");
    paramfh.a(paramCalendar.get(12));
    paramfh.a("second");
    paramfh.a(paramCalendar.get(13));
    paramfh.e();
    AppMethodBeat.o(147773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.16
 * JD-Core Version:    0.7.0.1
 */