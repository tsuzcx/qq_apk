package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cv
  implements bz, ct
{
  private static cv a;
  private ct b;
  private bz c;
  private boolean d = false;
  
  static
  {
    AppMethodBeat.i(147383);
    a = new cv();
    AppMethodBeat.o(147383);
  }
  
  public static cv d()
  {
    return a;
  }
  
  public final void a()
  {
    AppMethodBeat.i(147377);
    this.b.a();
    AppMethodBeat.o(147377);
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(147379);
    this.b.a(paramInt);
    AppMethodBeat.o(147379);
  }
  
  public final void a(bz parambz)
  {
    this.c = parambz;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147382);
    this.c.a(paramString1, paramString2);
    AppMethodBeat.o(147382);
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(147381);
    this.c.a(paramString1, paramArrayOfByte, paramString2);
    AppMethodBeat.o(147381);
  }
  
  public final void b()
  {
    AppMethodBeat.i(147378);
    this.b.b();
    AppMethodBeat.o(147378);
  }
  
  public final void c()
  {
    AppMethodBeat.i(147380);
    this.c.c();
    AppMethodBeat.o(147380);
  }
  
  /* Error */
  public final void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 65
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 37	com/tencent/tencentmap/mapsdk/maps/a/cv:d	Z
    //   11: ifeq +11 -> 22
    //   14: ldc 65
    //   16: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: invokestatic 70	com/tencent/tencentmap/mapsdk/maps/a/cl:c	()Lcom/tencent/tencentmap/mapsdk/maps/a/cl;
    //   26: putfield 41	com/tencent/tencentmap/mapsdk/maps/a/cv:b	Lcom/tencent/tencentmap/mapsdk/maps/a/ct;
    //   29: aload_0
    //   30: getfield 41	com/tencent/tencentmap/mapsdk/maps/a/cv:b	Lcom/tencent/tencentmap/mapsdk/maps/a/ct;
    //   33: ifnull +22 -> 55
    //   36: aload_0
    //   37: getfield 41	com/tencent/tencentmap/mapsdk/maps/a/cv:b	Lcom/tencent/tencentmap/mapsdk/maps/a/ct;
    //   40: aload_0
    //   41: invokeinterface 72 2 0
    //   46: aload_0
    //   47: getfield 41	com/tencent/tencentmap/mapsdk/maps/a/cv:b	Lcom/tencent/tencentmap/mapsdk/maps/a/ct;
    //   50: invokeinterface 74 1 0
    //   55: aload_0
    //   56: iconst_1
    //   57: putfield 37	com/tencent/tencentmap/mapsdk/maps/a/cv:d	Z
    //   60: ldc 65
    //   62: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -46 -> 19
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	cv
    //   68	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	68	finally
    //   22	55	68	finally
    //   55	65	68	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.cv
 * JD-Core Version:    0.7.0.1
 */