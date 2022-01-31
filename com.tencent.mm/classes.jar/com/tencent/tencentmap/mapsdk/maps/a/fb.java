package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class fb
  extends eb<Time>
{
  public static final ec a;
  private final DateFormat b;
  
  static
  {
    AppMethodBeat.i(147739);
    a = new fb.1();
    AppMethodBeat.o(147739);
  }
  
  public fb()
  {
    AppMethodBeat.i(147734);
    this.b = new SimpleDateFormat("hh:mm:ss a");
    AppMethodBeat.o(147734);
  }
  
  public final Time a(ff paramff)
  {
    try
    {
      AppMethodBeat.i(147735);
      if (paramff.f() != fg.i) {
        break label32;
      }
      paramff.j();
      paramff = null;
      AppMethodBeat.o(147735);
    }
    finally
    {
      try
      {
        label32:
        paramff = new Time(this.b.parse(paramff.h()).getTime());
        AppMethodBeat.o(147735);
      }
      catch (ParseException paramff)
      {
        paramff = new dy(paramff);
        AppMethodBeat.o(147735);
        throw paramff;
      }
      paramff = finally;
    }
    return paramff;
  }
  
  /* Error */
  public final void a(fh paramfh, Time paramTime)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 90
    //   4: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_2
    //   8: ifnonnull +19 -> 27
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_1
    //   14: aload_2
    //   15: invokevirtual 95	com/tencent/tencentmap/mapsdk/maps/a/fh:b	(Ljava/lang/String;)Lcom/tencent/tencentmap/mapsdk/maps/a/fh;
    //   18: pop
    //   19: ldc 90
    //   21: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: getfield 40	com/tencent/tencentmap/mapsdk/maps/a/fb:b	Ljava/text/DateFormat;
    //   31: aload_2
    //   32: invokevirtual 99	java/text/DateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   35: astore_2
    //   36: goto -23 -> 13
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	fb
    //   0	44	1	paramfh	fh
    //   0	44	2	paramTime	Time
    // Exception table:
    //   from	to	target	type
    //   2	7	39	finally
    //   13	24	39	finally
    //   27	36	39	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fb
 * JD-Core Version:    0.7.0.1
 */