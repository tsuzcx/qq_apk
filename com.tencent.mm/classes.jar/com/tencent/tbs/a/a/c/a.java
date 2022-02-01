package com.tencent.tbs.a.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class a
  implements b
{
  ThreadLocal<SimpleDateFormat> a;
  
  public a()
  {
    AppMethodBeat.i(174291);
    this.a = new ThreadLocal() {};
    AppMethodBeat.o(174291);
  }
  
  public final String d(com.tencent.tbs.a.b paramb)
  {
    AppMethodBeat.i(174292);
    if (paramb != null) {}
    for (long l = paramb.a;; l = System.currentTimeMillis())
    {
      paramb = (SimpleDateFormat)this.a.get();
      paramb.setTimeZone(TimeZone.getDefault());
      paramb = paramb.format(new Date(l));
      AppMethodBeat.o(174292);
      return paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */