package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.n.n;
import d.p.a;
import d.q;
import d.v;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"baseContinuationImplClass", "", "baseContinuationImplClassName", "kotlin.jvm.PlatformType", "stackTraceRecoveryClass", "stackTraceRecoveryClassName", "artificialFrame", "Ljava/lang/StackTraceElement;", "message", "createFinalException", "E", "", "cause", "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "Lkotlinx/coroutines/internal/StackTraceElement;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "createStackTrace", "continuation", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "mergeRecoveredTraces", "", "recoveredStacktrace", "", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", "exception", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "unwrap", "unwrapImpl", "causeAndStacktrace", "Lkotlin/Pair;", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "elementWiseEquals", "", "e", "frameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "initCause", "isArtificial", "sanitizeStackTrace", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"})
public final class s
{
  private static final String Ohi;
  private static final String Ohj;
  
  static
  {
    AppMethodBeat.i(209340);
    try
    {
      localObject1 = d.p.Nhh;
      localObject1 = d.p.eO(Class.forName("d.d.b.a.a").getCanonicalName());
      if (d.p.eN(localObject1) == null) {
        Ohi = (String)localObject1;
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          Object localObject1 = d.p.Nhh;
          localObject1 = d.p.eO(Class.forName("kotlinx.coroutines.internal.s").getCanonicalName());
          if (d.p.eN(localObject1) != null) {
            break;
          }
          Ohj = (String)localObject1;
          AppMethodBeat.o(209340);
          return;
          localThrowable1 = localThrowable1;
          locala = d.p.Nhh;
          localObject2 = d.p.eO(q.p(localThrowable1));
        }
        Object localObject2 = "d.d.b.a.a";
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          p.a locala = d.p.Nhh;
          Object localObject3 = d.p.eO(q.p(localThrowable2));
          continue;
          localObject3 = "kotlinx.coroutines.internal.s";
        }
      }
    }
  }
  
  public static final <E extends Throwable> E G(E paramE)
  {
    int k = 0;
    AppMethodBeat.i(209337);
    Throwable localThrowable = paramE.getCause();
    if ((localThrowable == null) || ((d.g.b.p.i(localThrowable.getClass(), paramE.getClass()) ^ true)))
    {
      AppMethodBeat.o(209337);
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
        AppMethodBeat.o(209337);
        return localThrowable;
      }
      i += 1;
    }
    AppMethodBeat.o(209337);
    return paramE;
  }
  
  private static final int a(StackTraceElement[] paramArrayOfStackTraceElement, String paramString)
  {
    AppMethodBeat.i(209339);
    int i = 0;
    int j = paramArrayOfStackTraceElement.length;
    while (i < j)
    {
      if (d.g.b.p.i(paramString, paramArrayOfStackTraceElement[i].getClassName()))
      {
        AppMethodBeat.o(209339);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(209339);
    return -1;
  }
  
  private static final <E extends Throwable> E a(E paramE1, E paramE2, ArrayDeque<StackTraceElement> paramArrayDeque)
  {
    AppMethodBeat.i(209335);
    paramArrayDeque.addFirst(new StackTraceElement("\b\b\b(".concat(String.valueOf("Coroutine boundary")), "\b", "\b", -1));
    StackTraceElement[] arrayOfStackTraceElement = paramE1.getStackTrace();
    int j = a(arrayOfStackTraceElement, Ohi);
    if (j == -1)
    {
      paramE1 = ((Collection)paramArrayDeque).toArray(new StackTraceElement[0]);
      if (paramE1 == null)
      {
        paramE1 = new v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(209335);
        throw paramE1;
      }
      paramE2.setStackTrace((StackTraceElement[])paramE1);
      AppMethodBeat.o(209335);
      return paramE2;
    }
    paramE1 = new StackTraceElement[paramArrayDeque.size() + j];
    int i = 0;
    while (i < j)
    {
      paramE1[i] = arrayOfStackTraceElement[i];
      i += 1;
    }
    paramArrayDeque = ((Iterable)paramArrayDeque).iterator();
    i = 0;
    while (paramArrayDeque.hasNext())
    {
      paramE1[(j + i)] = ((StackTraceElement)paramArrayDeque.next());
      i += 1;
    }
    paramE2.setStackTrace(paramE1);
    AppMethodBeat.o(209335);
    return paramE2;
  }
  
  private static final void a(StackTraceElement[] paramArrayOfStackTraceElement, ArrayDeque<StackTraceElement> paramArrayDeque)
  {
    AppMethodBeat.i(209336);
    int j = paramArrayOfStackTraceElement.length;
    int i = 0;
    label25:
    int k;
    if (i < j) {
      if (a(paramArrayOfStackTraceElement[i]))
      {
        k = i + 1;
        i = paramArrayOfStackTraceElement.length - 1;
        if (i < k) {
          break label164;
        }
        label41:
        StackTraceElement localStackTraceElement1 = paramArrayOfStackTraceElement[i];
        StackTraceElement localStackTraceElement2 = (StackTraceElement)paramArrayDeque.getLast();
        if ((localStackTraceElement1.getLineNumber() != localStackTraceElement2.getLineNumber()) || (!d.g.b.p.i(localStackTraceElement1.getMethodName(), localStackTraceElement2.getMethodName())) || (!d.g.b.p.i(localStackTraceElement1.getFileName(), localStackTraceElement2.getFileName())) || (!d.g.b.p.i(localStackTraceElement1.getClassName(), localStackTraceElement2.getClassName()))) {
          break label159;
        }
      }
    }
    label159:
    for (j = 1;; j = 0)
    {
      if (j != 0) {
        paramArrayDeque.removeLast();
      }
      paramArrayDeque.addFirst(paramArrayOfStackTraceElement[i]);
      if (i == k) {
        break label164;
      }
      i -= 1;
      break label41;
      i += 1;
      break;
      i = -1;
      break label25;
    }
    label164:
    AppMethodBeat.o(209336);
  }
  
  private static boolean a(StackTraceElement paramStackTraceElement)
  {
    AppMethodBeat.i(209338);
    boolean bool = n.nF(paramStackTraceElement.getClassName(), "\b\b\b");
    AppMethodBeat.o(209338);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.s
 * JD-Core Version:    0.7.0.1
 */