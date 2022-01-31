package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.StringTokenizer;

final class fd$17
  extends eb<Locale>
{
  public final Locale a(ff paramff)
  {
    AppMethodBeat.i(147776);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147776);
      return null;
    }
    Object localObject = new StringTokenizer(paramff.h(), "_");
    if (((StringTokenizer)localObject).hasMoreElements()) {}
    for (paramff = ((StringTokenizer)localObject).nextToken();; paramff = null)
    {
      if (((StringTokenizer)localObject).hasMoreElements()) {}
      for (String str = ((StringTokenizer)localObject).nextToken();; str = null)
      {
        if (((StringTokenizer)localObject).hasMoreElements()) {}
        for (localObject = ((StringTokenizer)localObject).nextToken();; localObject = null)
        {
          if ((str == null) && (localObject == null))
          {
            paramff = new Locale(paramff);
            AppMethodBeat.o(147776);
            return paramff;
          }
          if (localObject == null)
          {
            paramff = new Locale(paramff, str);
            AppMethodBeat.o(147776);
            return paramff;
          }
          paramff = new Locale(paramff, str, (String)localObject);
          AppMethodBeat.o(147776);
          return paramff;
        }
      }
    }
  }
  
  public final void a(fh paramfh, Locale paramLocale)
  {
    AppMethodBeat.i(147777);
    if (paramLocale == null) {}
    for (paramLocale = null;; paramLocale = paramLocale.toString())
    {
      paramfh.b(paramLocale);
      AppMethodBeat.o(147777);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.17
 * JD-Core Version:    0.7.0.1
 */