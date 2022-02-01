package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.coroutines.aj;
import kotlinx.coroutines.au;

@Metadata(d1={""}, d2={"baseContinuationImplClass", "", "baseContinuationImplClassName", "kotlin.jvm.PlatformType", "stackTraceRecoveryClass", "stackTraceRecoveryClassName", "artificialFrame", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "message", "createFinalException", "E", "", "cause", "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "createStackTrace", "continuation", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "mergeRecoveredTraces", "", "recoveredStacktrace", "", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", "exception", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "tryCopyAndVerify", "unwrap", "unwrapImpl", "causeAndStacktrace", "Lkotlin/Pair;", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "elementWiseEquals", "", "e", "frameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "initCause", "isArtificial", "sanitizeStackTrace", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class ab
{
  private static final String ajAQ;
  private static final String ajAR;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 71
    //   2: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 83	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   8: astore_0
    //   9: ldc 85
    //   11: invokestatic 91	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   14: invokevirtual 95	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   17: invokestatic 99	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: astore_0
    //   21: aload_0
    //   22: invokestatic 103	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   25: ifnonnull +62 -> 87
    //   28: aload_0
    //   29: checkcast 105	java/lang/String
    //   32: putstatic 107	kotlinx/coroutines/internal/ab:ajAQ	Ljava/lang/String;
    //   35: getstatic 83	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   38: astore_0
    //   39: ldc 109
    //   41: invokestatic 91	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   44: invokevirtual 95	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   47: invokestatic 99	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   50: astore_0
    //   51: aload_0
    //   52: invokestatic 103	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   55: ifnonnull +54 -> 109
    //   58: aload_0
    //   59: checkcast 105	java/lang/String
    //   62: putstatic 111	kotlinx/coroutines/internal/ab:ajAR	Ljava/lang/String;
    //   65: ldc 71
    //   67: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: return
    //   71: astore_0
    //   72: getstatic 83	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   75: astore_1
    //   76: aload_0
    //   77: invokestatic 120	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   80: invokestatic 99	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: astore_0
    //   84: goto -63 -> 21
    //   87: ldc 85
    //   89: astore_0
    //   90: goto -62 -> 28
    //   93: astore_0
    //   94: getstatic 83	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   97: astore_1
    //   98: aload_0
    //   99: invokestatic 120	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   102: invokestatic 99	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   105: astore_0
    //   106: goto -55 -> 51
    //   109: ldc 109
    //   111: astore_0
    //   112: goto -54 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   8	51	0	localObject1	Object
    //   71	6	0	localThrowable1	Throwable
    //   83	7	0	localObject2	Object
    //   93	6	0	localThrowable2	Throwable
    //   105	7	0	localObject3	Object
    //   75	23	1	localCompanion	kotlin.Result.Companion
    // Exception table:
    //   from	to	target	type
    //   5	21	71	finally
    //   35	51	93	finally
  }
  
  private static final int a(StackTraceElement[] paramArrayOfStackTraceElement, String paramString)
  {
    AppMethodBeat.i(189462);
    int i = 0;
    int j = paramArrayOfStackTraceElement.length;
    while (i < j)
    {
      if (s.p(paramString, paramArrayOfStackTraceElement[i].getClassName()))
      {
        AppMethodBeat.o(189462);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(189462);
    return -1;
  }
  
  private static final <E extends Throwable> E a(E paramE1, E paramE2, ArrayDeque<StackTraceElement> paramArrayDeque)
  {
    int j = 0;
    AppMethodBeat.i(189441);
    paramArrayDeque.addFirst(bJK("Coroutine boundary"));
    StackTraceElement[] arrayOfStackTraceElement = paramE1.getStackTrace();
    int m = a(arrayOfStackTraceElement, ajAQ);
    if (m == -1)
    {
      paramE1 = ((Collection)paramArrayDeque).toArray(new StackTraceElement[0]);
      if (paramE1 == null)
      {
        paramE1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(189441);
        throw paramE1;
      }
      paramE2.setStackTrace((StackTraceElement[])paramE1);
      AppMethodBeat.o(189441);
      return paramE2;
    }
    paramE1 = new StackTraceElement[paramArrayDeque.size() + m];
    if (m > 0) {}
    int k;
    for (int i = 0;; i = k)
    {
      k = i + 1;
      paramE1[i] = arrayOfStackTraceElement[i];
      if (k >= m)
      {
        paramArrayDeque = paramArrayDeque.iterator();
        i = j;
        while (paramArrayDeque.hasNext())
        {
          paramE1[(i + m)] = ((StackTraceElement)paramArrayDeque.next());
          i += 1;
        }
        paramE2.setStackTrace(paramE1);
        AppMethodBeat.o(189441);
        return paramE2;
      }
    }
  }
  
  private static final void a(StackTraceElement[] paramArrayOfStackTraceElement, ArrayDeque<StackTraceElement> paramArrayDeque)
  {
    AppMethodBeat.i(189449);
    int j = paramArrayOfStackTraceElement.length;
    int i = 0;
    label24:
    int k;
    if (i < j) {
      if (a(paramArrayOfStackTraceElement[i]))
      {
        k = i + 1;
        i = paramArrayOfStackTraceElement.length - 1;
        if (k > i) {}
      }
    }
    for (;;)
    {
      StackTraceElement localStackTraceElement1 = paramArrayOfStackTraceElement[i];
      StackTraceElement localStackTraceElement2 = (StackTraceElement)paramArrayDeque.getLast();
      if ((localStackTraceElement1.getLineNumber() == localStackTraceElement2.getLineNumber()) && (s.p(localStackTraceElement1.getMethodName(), localStackTraceElement2.getMethodName())) && (s.p(localStackTraceElement1.getFileName(), localStackTraceElement2.getFileName())) && (s.p(localStackTraceElement1.getClassName(), localStackTraceElement2.getClassName()))) {}
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          paramArrayDeque.removeLast();
        }
        paramArrayDeque.addFirst(paramArrayOfStackTraceElement[i]);
        if (i != k) {
          break label162;
        }
        AppMethodBeat.o(189449);
        return;
        i += 1;
        break;
        i = -1;
        break label24;
      }
      label162:
      i -= 1;
    }
  }
  
  private static boolean a(StackTraceElement paramStackTraceElement)
  {
    AppMethodBeat.i(189459);
    boolean bool = n.U(paramStackTraceElement.getClassName(), "\b\b\b", false);
    AppMethodBeat.o(189459);
    return bool;
  }
  
  public static final <E extends Throwable> E ab(E paramE)
  {
    int j = 0;
    AppMethodBeat.i(189424);
    if (!au.ajvP)
    {
      AppMethodBeat.o(189424);
      return paramE;
    }
    Throwable localThrowable = ac(paramE);
    if (localThrowable == null)
    {
      AppMethodBeat.o(189424);
      return paramE;
    }
    StackTraceElement[] arrayOfStackTraceElement1 = localThrowable.getStackTrace();
    int m = arrayOfStackTraceElement1.length;
    int k = a(arrayOfStackTraceElement1, ajAR);
    int i = a(arrayOfStackTraceElement1, ajAQ);
    StackTraceElement[] arrayOfStackTraceElement2;
    if (i == -1)
    {
      i = 0;
      m = m - k - i;
      arrayOfStackTraceElement2 = new StackTraceElement[m];
      i = j;
      label95:
      if (i >= m) {
        break label145;
      }
      if (i != 0) {
        break label131;
      }
    }
    label131:
    for (paramE = bJK("Coroutine boundary");; paramE = arrayOfStackTraceElement1[(k + 1 + i - 1)])
    {
      arrayOfStackTraceElement2[i] = paramE;
      i += 1;
      break label95;
      i = m - i;
      break;
    }
    label145:
    localThrowable.setStackTrace(arrayOfStackTraceElement2);
    AppMethodBeat.o(189424);
    return localThrowable;
  }
  
  private static final <E extends Throwable> E ac(E paramE)
  {
    AppMethodBeat.i(189432);
    Throwable localThrowable = j.Z(paramE);
    if (localThrowable == null)
    {
      AppMethodBeat.o(189432);
      return null;
    }
    if ((!(paramE instanceof aj)) && (!s.p(localThrowable.getMessage(), paramE.getMessage())))
    {
      AppMethodBeat.o(189432);
      return null;
    }
    AppMethodBeat.o(189432);
    return localThrowable;
  }
  
  public static final <E extends Throwable> E ad(E paramE)
  {
    int k = 0;
    AppMethodBeat.i(189452);
    Throwable localThrowable = paramE.getCause();
    if ((localThrowable == null) || (!s.p(localThrowable.getClass(), paramE.getClass())))
    {
      AppMethodBeat.o(189452);
      return paramE;
    }
    StackTraceElement[] arrayOfStackTraceElement = paramE.getStackTrace();
    int m = arrayOfStackTraceElement.length;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        if (a(arrayOfStackTraceElement[i])) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break;
        }
        AppMethodBeat.o(189452);
        return localThrowable;
      }
      i += 1;
    }
    AppMethodBeat.o(189452);
    return paramE;
  }
  
  private static StackTraceElement bJK(String paramString)
  {
    AppMethodBeat.i(189455);
    paramString = new StackTraceElement(s.X("\b\b\b(", paramString), "\b", "\b", -1);
    AppMethodBeat.o(189455);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.ab
 * JD-Core Version:    0.7.0.1
 */