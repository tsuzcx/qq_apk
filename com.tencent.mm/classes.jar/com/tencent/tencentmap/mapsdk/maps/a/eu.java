package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class eu
  extends eb<Date>
{
  public static final ec a;
  private final DateFormat b;
  private final DateFormat c;
  private final DateFormat d;
  
  static
  {
    AppMethodBeat.i(147659);
    a = new eu.1();
    AppMethodBeat.o(147659);
  }
  
  public eu()
  {
    AppMethodBeat.i(147652);
    this.b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    this.c = DateFormat.getDateTimeInstance(2, 2);
    this.d = a();
    AppMethodBeat.o(147652);
  }
  
  private static DateFormat a()
  {
    AppMethodBeat.i(147653);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    AppMethodBeat.o(147653);
    return localSimpleDateFormat;
  }
  
  /* Error */
  private Date a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 81
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 52	com/tencent/tencentmap/mapsdk/maps/a/eu:c	Ljava/text/DateFormat;
    //   11: aload_1
    //   12: invokevirtual 84	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   15: astore_2
    //   16: aload_2
    //   17: astore_1
    //   18: ldc 81
    //   20: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 47	com/tencent/tencentmap/mapsdk/maps/a/eu:b	Ljava/text/DateFormat;
    //   32: aload_1
    //   33: invokevirtual 84	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: ldc 81
    //   41: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -21 -> 23
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    //   52: astore_2
    //   53: aload_0
    //   54: getfield 57	com/tencent/tencentmap/mapsdk/maps/a/eu:d	Ljava/text/DateFormat;
    //   57: aload_1
    //   58: invokevirtual 84	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   61: astore_2
    //   62: aload_2
    //   63: astore_1
    //   64: ldc 81
    //   66: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: goto -46 -> 23
    //   72: astore_2
    //   73: new 86	com/tencent/tencentmap/mapsdk/maps/a/dy
    //   76: dup
    //   77: aload_1
    //   78: aload_2
    //   79: invokespecial 89	com/tencent/tencentmap/mapsdk/maps/a/dy:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   82: astore_1
    //   83: ldc 81
    //   85: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	eu
    //   0	90	1	paramString	java.lang.String
    //   15	2	2	localDate1	Date
    //   27	1	2	localParseException1	java.text.ParseException
    //   36	2	2	localDate2	Date
    //   52	1	2	localParseException2	java.text.ParseException
    //   61	2	2	localDate3	Date
    //   72	7	2	localParseException3	java.text.ParseException
    // Exception table:
    //   from	to	target	type
    //   7	16	27	java/text/ParseException
    //   2	7	47	finally
    //   7	16	47	finally
    //   18	23	47	finally
    //   28	37	47	finally
    //   39	44	47	finally
    //   53	62	47	finally
    //   64	69	47	finally
    //   73	90	47	finally
    //   28	37	52	java/text/ParseException
    //   53	62	72	java/text/ParseException
  }
  
  public final Date a(ff paramff)
  {
    AppMethodBeat.i(147654);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147654);
      return null;
    }
    paramff = a(paramff.h());
    AppMethodBeat.o(147654);
    return paramff;
  }
  
  /* Error */
  public final void a(fh paramfh, Date paramDate)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 119
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_2
    //   8: ifnonnull +16 -> 24
    //   11: aload_1
    //   12: invokevirtual 124	com/tencent/tencentmap/mapsdk/maps/a/fh:f	()Lcom/tencent/tencentmap/mapsdk/maps/a/fh;
    //   15: pop
    //   16: ldc 119
    //   18: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_1
    //   25: aload_0
    //   26: getfield 47	com/tencent/tencentmap/mapsdk/maps/a/eu:b	Ljava/text/DateFormat;
    //   29: aload_2
    //   30: invokevirtual 128	java/text/DateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   33: invokevirtual 131	com/tencent/tencentmap/mapsdk/maps/a/fh:b	(Ljava/lang/String;)Lcom/tencent/tencentmap/mapsdk/maps/a/fh;
    //   36: pop
    //   37: ldc 119
    //   39: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: goto -21 -> 21
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	eu
    //   0	50	1	paramfh	fh
    //   0	50	2	paramDate	Date
    // Exception table:
    //   from	to	target	type
    //   2	7	45	finally
    //   11	21	45	finally
    //   24	42	45	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.eu
 * JD-Core Version:    0.7.0.1
 */