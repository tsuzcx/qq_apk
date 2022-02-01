package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.m.k;

@Metadata(d1={""}, d2={"handlers", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleCoroutineExceptionImpl", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class am
{
  private static final List<CoroutineExceptionHandler> wNB;
  
  static
  {
    AppMethodBeat.i(118160);
    wNB = k.d(k.d(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator()));
    AppMethodBeat.o(118160);
  }
  
  /* Error */
  public static final void a(kotlin.d.f paramf, java.lang.Throwable paramThrowable)
  {
    // Byte code:
    //   0: ldc 71
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 64	kotlinx/coroutines/am:wNB	Ljava/util/List;
    //   8: invokeinterface 74 1 0
    //   13: astore_2
    //   14: aload_2
    //   15: invokeinterface 80 1 0
    //   20: ifeq +50 -> 70
    //   23: aload_2
    //   24: invokeinterface 84 1 0
    //   29: checkcast 37	kotlinx/coroutines/CoroutineExceptionHandler
    //   32: astore_3
    //   33: aload_3
    //   34: aload_0
    //   35: aload_1
    //   36: invokeinterface 87 3 0
    //   41: goto -27 -> 14
    //   44: astore_3
    //   45: invokestatic 93	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   48: astore 4
    //   50: aload 4
    //   52: invokevirtual 97	java/lang/Thread:getUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   55: aload 4
    //   57: aload_1
    //   58: aload_3
    //   59: invokestatic 103	kotlinx/coroutines/an:b	(Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   62: invokeinterface 109 3 0
    //   67: goto -53 -> 14
    //   70: invokestatic 93	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 97	java/lang/Thread:getUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   78: aload_0
    //   79: aload_1
    //   80: invokeinterface 109 3 0
    //   85: ldc 71
    //   87: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramf	kotlin.d.f
    //   0	91	1	paramThrowable	java.lang.Throwable
    //   13	11	2	localIterator	java.util.Iterator
    //   32	2	3	localCoroutineExceptionHandler	CoroutineExceptionHandler
    //   44	15	3	localThrowable	java.lang.Throwable
    //   48	8	4	localThread	java.lang.Thread
    // Exception table:
    //   from	to	target	type
    //   33	41	44	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.am
 * JD-Core Version:    0.7.0.1
 */