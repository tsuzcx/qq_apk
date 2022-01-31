package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class fa
  extends eb<java.sql.Date>
{
  public static final ec a;
  private final DateFormat b;
  
  static
  {
    AppMethodBeat.i(147732);
    a = new fa.1();
    AppMethodBeat.o(147732);
  }
  
  public fa()
  {
    AppMethodBeat.i(147727);
    this.b = new SimpleDateFormat("MMM d, yyyy");
    AppMethodBeat.o(147727);
  }
  
  public final java.sql.Date a(ff paramff)
  {
    try
    {
      AppMethodBeat.i(147728);
      if (paramff.f() != fg.i) {
        break label32;
      }
      paramff.j();
      paramff = null;
      AppMethodBeat.o(147728);
    }
    finally
    {
      try
      {
        label32:
        paramff = new java.sql.Date(this.b.parse(paramff.h()).getTime());
        AppMethodBeat.o(147728);
      }
      catch (ParseException paramff)
      {
        paramff = new dy(paramff);
        AppMethodBeat.o(147728);
        throw paramff;
      }
      paramff = finally;
    }
    return paramff;
  }
  
  /* Error */
  public final void a(fh paramfh, java.sql.Date paramDate)
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
    //   28: getfield 40	com/tencent/tencentmap/mapsdk/maps/a/fa:b	Ljava/text/DateFormat;
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
    //   0	44	0	this	fa
    //   0	44	1	paramfh	fh
    //   0	44	2	paramDate	java.sql.Date
    // Exception table:
    //   from	to	target	type
    //   2	7	39	finally
    //   13	24	39	finally
    //   27	36	39	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fa
 * JD-Core Version:    0.7.0.1
 */