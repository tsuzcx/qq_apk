package kotlinx.coroutines;

import a.f.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.a.p;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/UndispatchedEventLoop;", "", "()V", "threadLocalEventLoop", "Lkotlinx/coroutines/internal/ThreadLocalWithInitialValue;", "Lkotlinx/coroutines/UndispatchedEventLoop$EventLoop;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "execute", "", "continuation", "Lkotlinx/coroutines/DispatchedContinuation;", "contState", "mode", "", "doYield", "block", "Lkotlin/Function0;", "", "resumeUndispatched", "task", "Lkotlinx/coroutines/DispatchedTask;", "runEventLoop", "eventLoop", "EventLoop", "kotlinx-coroutines-core"})
public final class bu
{
  public static final p<bu.a> CIF;
  public static final bu CIG;
  
  static
  {
    AppMethodBeat.i(118499);
    CIG = new bu();
    CIF = new p((a)bu.b.CII);
    AppMethodBeat.o(118499);
  }
  
  /* Error */
  public static boolean a(an<?> paraman)
  {
    // Byte code:
    //   0: ldc 78
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 79
    //   8: invokestatic 85	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: getstatic 68	kotlinx/coroutines/bu:CIF	Lkotlinx/coroutines/a/p;
    //   14: invokevirtual 89	kotlinx/coroutines/a/p:get	()Ljava/lang/Object;
    //   17: checkcast 6	kotlinx/coroutines/bu$a
    //   20: astore_1
    //   21: aload_1
    //   22: getfield 93	kotlinx/coroutines/bu$a:isActive	Z
    //   25: ifeq +18 -> 43
    //   28: aload_1
    //   29: getfield 97	kotlinx/coroutines/bu$a:CIH	Lkotlinx/coroutines/a/b;
    //   32: aload_0
    //   33: invokevirtual 103	kotlinx/coroutines/a/b:addLast	(Ljava/lang/Object;)V
    //   36: ldc 78
    //   38: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: iconst_1
    //   42: ireturn
    //   43: aload_1
    //   44: ldc 104
    //   46: invokestatic 107	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   49: aload_1
    //   50: iconst_1
    //   51: putfield 93	kotlinx/coroutines/bu$a:isActive	Z
    //   54: aload_0
    //   55: aload_0
    //   56: invokevirtual 113	kotlinx/coroutines/an:epp	()La/c/c;
    //   59: iconst_3
    //   60: invokestatic 118	kotlinx/coroutines/am:a	(Lkotlinx/coroutines/an;La/c/c;I)V
    //   63: aload_1
    //   64: getfield 97	kotlinx/coroutines/bu$a:CIH	Lkotlinx/coroutines/a/b;
    //   67: invokevirtual 121	kotlinx/coroutines/a/b:eqc	()Ljava/lang/Object;
    //   70: checkcast 123	java/lang/Runnable
    //   73: astore_0
    //   74: aload_0
    //   75: ifnonnull +15 -> 90
    //   78: aload_1
    //   79: iconst_0
    //   80: putfield 93	kotlinx/coroutines/bu$a:isActive	Z
    //   83: ldc 78
    //   85: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: iconst_0
    //   89: ireturn
    //   90: aload_0
    //   91: invokeinterface 126 1 0
    //   96: goto -33 -> 63
    //   99: astore_0
    //   100: aload_1
    //   101: getfield 97	kotlinx/coroutines/bu$a:CIH	Lkotlinx/coroutines/a/b;
    //   104: invokevirtual 129	kotlinx/coroutines/a/b:clear	()V
    //   107: new 131	kotlinx/coroutines/ak
    //   110: dup
    //   111: ldc 133
    //   113: aload_0
    //   114: invokespecial 136	kotlinx/coroutines/ak:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   117: checkcast 77	java/lang/Throwable
    //   120: astore_0
    //   121: ldc 78
    //   123: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_0
    //   127: athrow
    //   128: astore_0
    //   129: aload_1
    //   130: iconst_0
    //   131: putfield 93	kotlinx/coroutines/bu$a:isActive	Z
    //   134: ldc 78
    //   136: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_0
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paraman	an<?>
    //   20	110	1	locala	bu.a
    // Exception table:
    //   from	to	target	type
    //   49	63	99	java/lang/Throwable
    //   63	74	99	java/lang/Throwable
    //   90	96	99	java/lang/Throwable
    //   49	63	128	finally
    //   63	74	128	finally
    //   90	96	128	finally
    //   100	128	128	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.bu
 * JD-Core Version:    0.7.0.1
 */