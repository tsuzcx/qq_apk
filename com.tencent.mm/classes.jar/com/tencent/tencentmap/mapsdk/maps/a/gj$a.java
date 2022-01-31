package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

class gj$a
{
  public static final boolean a = gj.b;
  private final List<gj.a.a> b;
  private boolean c;
  
  gj$a()
  {
    AppMethodBeat.i(147987);
    this.b = new ArrayList();
    this.c = false;
    AppMethodBeat.o(147987);
  }
  
  private long a()
  {
    AppMethodBeat.i(147991);
    if (this.b.size() == 0)
    {
      AppMethodBeat.o(147991);
      return 0L;
    }
    long l1 = ((gj.a.a)this.b.get(0)).c;
    long l2 = ((gj.a.a)this.b.get(this.b.size() - 1)).c;
    AppMethodBeat.o(147991);
    return l2 - l1;
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 58
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: iconst_1
    //   9: putfield 38	com/tencent/tencentmap/mapsdk/maps/a/gj$a:c	Z
    //   12: aload_0
    //   13: invokespecial 60	com/tencent/tencentmap/mapsdk/maps/a/gj$a:a	()J
    //   16: lstore 4
    //   18: lload 4
    //   20: lconst_0
    //   21: lcmp
    //   22: ifgt +11 -> 33
    //   25: ldc 58
    //   27: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload_0
    //   34: getfield 36	com/tencent/tencentmap/mapsdk/maps/a/gj$a:b	Ljava/util/List;
    //   37: iconst_0
    //   38: invokeinterface 53 2 0
    //   43: checkcast 9	com/tencent/tencentmap/mapsdk/maps/a/gj$a$a
    //   46: getfield 56	com/tencent/tencentmap/mapsdk/maps/a/gj$a$a:c	J
    //   49: lstore_2
    //   50: ldc 62
    //   52: iconst_2
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: lload 4
    //   60: invokestatic 68	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload_1
    //   67: aastore
    //   68: invokestatic 71	com/tencent/tencentmap/mapsdk/maps/a/gj:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aload_0
    //   72: getfield 36	com/tencent/tencentmap/mapsdk/maps/a/gj$a:b	Ljava/util/List;
    //   75: invokeinterface 75 1 0
    //   80: astore_1
    //   81: aload_1
    //   82: invokeinterface 81 1 0
    //   87: ifeq +65 -> 152
    //   90: aload_1
    //   91: invokeinterface 85 1 0
    //   96: checkcast 9	com/tencent/tencentmap/mapsdk/maps/a/gj$a$a
    //   99: astore 6
    //   101: aload 6
    //   103: getfield 56	com/tencent/tencentmap/mapsdk/maps/a/gj$a$a:c	J
    //   106: lstore 4
    //   108: ldc 87
    //   110: iconst_3
    //   111: anewarray 4	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: lload 4
    //   118: lload_2
    //   119: lsub
    //   120: invokestatic 68	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: aload 6
    //   128: getfield 89	com/tencent/tencentmap/mapsdk/maps/a/gj$a$a:b	J
    //   131: invokestatic 68	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   134: aastore
    //   135: dup
    //   136: iconst_2
    //   137: aload 6
    //   139: getfield 92	com/tencent/tencentmap/mapsdk/maps/a/gj$a$a:a	Ljava/lang/String;
    //   142: aastore
    //   143: invokestatic 71	com/tencent/tencentmap/mapsdk/maps/a/gj:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: lload 4
    //   148: lstore_2
    //   149: goto -68 -> 81
    //   152: ldc 58
    //   154: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: goto -127 -> 30
    //   160: astore_1
    //   161: aload_0
    //   162: monitorexit
    //   163: aload_1
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	a
    //   0	165	1	paramString	String
    //   49	100	2	l1	long
    //   16	131	4	l2	long
    //   99	39	6	locala	gj.a.a
    // Exception table:
    //   from	to	target	type
    //   2	18	160	finally
    //   25	30	160	finally
    //   33	81	160	finally
    //   81	146	160	finally
    //   152	157	160	finally
  }
  
  public void a(String paramString, long paramLong)
  {
    try
    {
      AppMethodBeat.i(147988);
      if (this.c)
      {
        paramString = new IllegalStateException("Marker added to finished log");
        AppMethodBeat.o(147988);
        throw paramString;
      }
    }
    finally {}
    this.b.add(new gj.a.a(paramString, paramLong, SystemClock.elapsedRealtime()));
    AppMethodBeat.o(147988);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(147990);
    if (!this.c)
    {
      a("Request on the loose");
      gj.b("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }
    AppMethodBeat.o(147990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.gj.a
 * JD-Core Version:    0.7.0.1
 */