package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLong;
import rx.f;

public final class b
  extends AtomicLong
  implements f
{
  boolean akaI;
  final a akdl;
  Throwable exception;
  public volatile boolean terminated;
  
  public b(a parama)
  {
    this.akdl = parama;
  }
  
  public final void Cp(long paramLong)
  {
    AppMethodBeat.i(90200);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(90200);
      return;
    }
    label91:
    label117:
    for (;;)
    {
      long l2 = get();
      int i;
      int j;
      long l1;
      if (l2 == 0L)
      {
        i = 1;
        j = i;
        if (l2 != 9223372036854775807L)
        {
          if (paramLong != 9223372036854775807L) {
            break label91;
          }
          l1 = paramLong;
          i = 1;
        }
      }
      for (;;)
      {
        if (!compareAndSet(l2, l1)) {
          break label117;
        }
        j = i;
        if (j != 0) {
          kKw();
        }
        AppMethodBeat.o(90200);
        return;
        i = 0;
        break;
        if (l2 > 9223372036854775807L - paramLong) {
          l1 = 9223372036854775807L;
        } else {
          l1 = l2 + paramLong;
        }
      }
    }
  }
  
  public final void an(Throwable paramThrowable)
  {
    AppMethodBeat.i(90199);
    if (!this.terminated)
    {
      this.exception = paramThrowable;
      this.terminated = true;
      kKw();
    }
    AppMethodBeat.o(90199);
  }
  
  /* Error */
  public final void kKw()
  {
    // Byte code:
    //   0: ldc 57
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 59	rx/internal/util/b:akaI	Z
    //   11: ifeq +11 -> 22
    //   14: aload_0
    //   15: monitorexit
    //   16: ldc 57
    //   18: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: return
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 59	rx/internal/util/b:akaI	Z
    //   27: aload_0
    //   28: getfield 54	rx/internal/util/b:terminated	Z
    //   31: istore 4
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_0
    //   36: invokevirtual 40	rx/internal/util/b:get	()J
    //   39: lstore 6
    //   41: iconst_0
    //   42: istore_3
    //   43: iload_3
    //   44: istore_1
    //   45: aload_0
    //   46: getfield 23	rx/internal/util/b:akdl	Lrx/internal/util/b$a;
    //   49: astore 10
    //   51: goto +302 -> 353
    //   54: iload 4
    //   56: ifeq +53 -> 109
    //   59: iload_3
    //   60: istore_1
    //   61: aload 10
    //   63: invokeinterface 63 1 0
    //   68: ifnonnull +34 -> 102
    //   71: iconst_1
    //   72: istore_1
    //   73: aload 10
    //   75: aload_0
    //   76: getfield 56	rx/internal/util/b:exception	Ljava/lang/Throwable;
    //   79: invokeinterface 66 2 0
    //   84: ldc 57
    //   86: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: return
    //   90: astore 10
    //   92: aload_0
    //   93: monitorexit
    //   94: ldc 57
    //   96: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload 10
    //   101: athrow
    //   102: lload 6
    //   104: lconst_0
    //   105: lcmp
    //   106: ifeq +56 -> 162
    //   109: iload_3
    //   110: istore_1
    //   111: aload 10
    //   113: invokeinterface 69 1 0
    //   118: astore 11
    //   120: aload 11
    //   122: ifnull +40 -> 162
    //   125: iload_3
    //   126: istore_1
    //   127: aload 10
    //   129: aload 11
    //   131: invokeinterface 73 2 0
    //   136: istore 5
    //   138: iload 5
    //   140: ifeq +9 -> 149
    //   143: ldc 57
    //   145: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: return
    //   149: lload 6
    //   151: lconst_1
    //   152: lsub
    //   153: lstore 6
    //   155: iload_2
    //   156: iconst_1
    //   157: iadd
    //   158: istore_2
    //   159: goto +196 -> 355
    //   162: iload_3
    //   163: istore_1
    //   164: aload_0
    //   165: monitorenter
    //   166: aload_0
    //   167: getfield 54	rx/internal/util/b:terminated	Z
    //   170: istore 4
    //   172: aload 10
    //   174: invokeinterface 63 1 0
    //   179: ifnull +42 -> 221
    //   182: iconst_1
    //   183: istore_1
    //   184: aload_0
    //   185: invokevirtual 40	rx/internal/util/b:get	()J
    //   188: lstore 6
    //   190: lload 6
    //   192: ldc2_w 41
    //   195: lcmp
    //   196: ifne +65 -> 261
    //   199: iload_1
    //   200: ifne +26 -> 226
    //   203: iload 4
    //   205: ifne +21 -> 226
    //   208: aload_0
    //   209: iconst_0
    //   210: putfield 59	rx/internal/util/b:akaI	Z
    //   213: aload_0
    //   214: monitorexit
    //   215: ldc 57
    //   217: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: return
    //   221: iconst_0
    //   222: istore_1
    //   223: goto -39 -> 184
    //   226: ldc2_w 41
    //   229: lstore 6
    //   231: iload_3
    //   232: istore_1
    //   233: aload_0
    //   234: monitorexit
    //   235: goto +118 -> 353
    //   238: astore 10
    //   240: iload_1
    //   241: ifne +12 -> 253
    //   244: aload_0
    //   245: monitorenter
    //   246: aload_0
    //   247: iconst_0
    //   248: putfield 59	rx/internal/util/b:akaI	Z
    //   251: aload_0
    //   252: monitorexit
    //   253: ldc 57
    //   255: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: aload 10
    //   260: athrow
    //   261: iload_2
    //   262: ineg
    //   263: i2l
    //   264: lstore 6
    //   266: aload_0
    //   267: lload 6
    //   269: invokevirtual 77	rx/internal/util/b:addAndGet	(J)J
    //   272: lstore 8
    //   274: lload 8
    //   276: lconst_0
    //   277: lcmp
    //   278: ifeq +11 -> 289
    //   281: lload 8
    //   283: lstore 6
    //   285: iload_1
    //   286: ifne -55 -> 231
    //   289: iload 4
    //   291: ifeq +11 -> 302
    //   294: lload 8
    //   296: lstore 6
    //   298: iload_1
    //   299: ifeq -68 -> 231
    //   302: aload_0
    //   303: iconst_0
    //   304: putfield 59	rx/internal/util/b:akaI	Z
    //   307: aload_0
    //   308: monitorexit
    //   309: ldc 57
    //   311: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   314: return
    //   315: astore 10
    //   317: iconst_0
    //   318: istore_1
    //   319: aload_0
    //   320: monitorexit
    //   321: ldc 57
    //   323: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: aload 10
    //   328: athrow
    //   329: astore 10
    //   331: goto -91 -> 240
    //   334: astore 10
    //   336: aload_0
    //   337: monitorexit
    //   338: ldc 57
    //   340: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   343: aload 10
    //   345: athrow
    //   346: iconst_1
    //   347: istore_1
    //   348: astore 10
    //   350: goto -31 -> 319
    //   353: iconst_0
    //   354: istore_2
    //   355: lload 6
    //   357: lconst_0
    //   358: lcmp
    //   359: ifgt -305 -> 54
    //   362: iload 4
    //   364: ifeq -202 -> 162
    //   367: goto -313 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	b
    //   44	304	1	i	int
    //   155	200	2	j	int
    //   42	190	3	k	int
    //   31	332	4	bool1	boolean
    //   136	3	5	bool2	boolean
    //   39	317	6	l1	long
    //   272	23	8	l2	long
    //   49	25	10	locala	a
    //   90	83	10	localObject1	Object
    //   238	21	10	localObject2	Object
    //   315	12	10	localObject3	Object
    //   329	1	10	localObject4	Object
    //   334	10	10	localObject5	Object
    //   348	1	10	localObject6	Object
    //   118	12	11	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	90	finally
    //   22	35	90	finally
    //   45	51	238	finally
    //   61	71	238	finally
    //   73	84	238	finally
    //   111	120	238	finally
    //   127	138	238	finally
    //   164	166	238	finally
    //   233	235	238	finally
    //   166	182	315	finally
    //   184	190	315	finally
    //   266	274	315	finally
    //   319	329	329	finally
    //   246	253	334	finally
    //   208	215	346	finally
    //   302	309	346	finally
  }
  
  public static abstract interface a
  {
    public abstract void al(Throwable paramThrowable);
    
    public abstract boolean be(Object paramObject);
    
    public abstract Object peek();
    
    public abstract Object poll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.util.b
 * JD-Core Version:    0.7.0.1
 */