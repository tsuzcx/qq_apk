package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"baseContinuationImplClass", "", "baseContinuationImplClassName", "kotlin.jvm.PlatformType", "stackTraceRecoveryClass", "stackTraceRecoveryClassName", "artificialFrame", "Ljava/lang/StackTraceElement;", "message", "createFinalException", "E", "", "cause", "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "Lkotlinx/coroutines/internal/StackTraceElement;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "createStackTrace", "continuation", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "mergeRecoveredTraces", "", "recoveredStacktrace", "", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", "exception", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "unwrap", "unwrapImpl", "causeAndStacktrace", "Lkotlin/Pair;", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "elementWiseEquals", "", "e", "frameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "initCause", "isArtificial", "sanitizeStackTrace", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"})
public final class t
{
  private static final String TWg;
  private static final String TWh;
  
  static
  {
    AppMethodBeat.i(192484);
    try
    {
      localObject1 = Result.Companion;
      localObject1 = Result.constructor-impl(Class.forName("kotlin.d.b.a.a").getCanonicalName());
      if (Result.exceptionOrNull-impl(localObject1) == null) {
        TWg = (String)localObject1;
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          Object localObject1 = Result.Companion;
          localObject1 = Result.constructor-impl(Class.forName("kotlinx.coroutines.internal.t").getCanonicalName());
          if (Result.exceptionOrNull-impl(localObject1) != null) {
            break;
          }
          TWh = (String)localObject1;
          AppMethodBeat.o(192484);
          return;
          localThrowable1 = localThrowable1;
          localCompanion = Result.Companion;
          localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable1));
        }
        Object localObject2 = "kotlin.d.b.a.a";
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Result.Companion localCompanion = Result.Companion;
          Object localObject3 = Result.constructor-impl(ResultKt.createFailure(localThrowable2));
          continue;
          localObject3 = "kotlinx.coroutines.internal.t";
        }
      }
    }
  }
  
  public static final <E extends Throwable> E I(E paramE)
  {
    int k = 0;
    AppMethodBeat.i(192481);
    Throwable localThrowable = paramE.getCause();
    if ((localThrowable == null) || ((p.j(localThrowable.getClass(), paramE.getClass()) ^ true)))
    {
      AppMethodBeat.o(192481);
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
        AppMethodBeat.o(192481);
        return localThrowable;
      }
      i += 1;
    }
    AppMethodBeat.o(192481);
    return paramE;
  }
  
  private static final int a(StackTraceElement[] paramArrayOfStackTraceElement, String paramString)
  {
    AppMethodBeat.i(192483);
    int i = 0;
    int j = paramArrayOfStackTraceElement.length;
    while (i < j)
    {
      if (p.j(paramString, paramArrayOfStackTraceElement[i].getClassName()))
      {
        AppMethodBeat.o(192483);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(192483);
    return -1;
  }
  
  private static final <E extends Throwable> E a(E paramE1, E paramE2, ArrayDeque<StackTraceElement> paramArrayDeque)
  {
    AppMethodBeat.i(192479);
    paramArrayDeque.addFirst(new StackTraceElement("\b\b\b(".concat(String.valueOf("Coroutine boundary")), "\b", "\b", -1));
    StackTraceElement[] arrayOfStackTraceElement = paramE1.getStackTrace();
    int j = a(arrayOfStackTraceElement, TWg);
    if (j == -1)
    {
      paramE1 = ((Collection)paramArrayDeque).toArray(new StackTraceElement[0]);
      if (paramE1 == null)
      {
        paramE1 = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(192479);
        throw paramE1;
      }
      paramE2.setStackTrace((StackTraceElement[])paramE1);
      AppMethodBeat.o(192479);
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
    AppMethodBeat.o(192479);
    return paramE2;
  }
  
  private static final void a(StackTraceElement[] paramArrayOfStackTraceElement, ArrayDeque<StackTraceElement> paramArrayDeque)
  {
    AppMethodBeat.i(192480);
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
        if ((localStackTraceElement1.getLineNumber() != localStackTraceElement2.getLineNumber()) || (!p.j(localStackTraceElement1.getMethodName(), localStackTraceElement2.getMethodName())) || (!p.j(localStackTraceElement1.getFileName(), localStackTraceElement2.getFileName())) || (!p.j(localStackTraceElement1.getClassName(), localStackTraceElement2.getClassName()))) {
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
    AppMethodBeat.o(192480);
  }
  
  private static boolean a(StackTraceElement paramStackTraceElement)
  {
    AppMethodBeat.i(192482);
    boolean bool = n.J(paramStackTraceElement.getClassName(), "\b\b\b", false);
    AppMethodBeat.o(192482);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.internal.t
 * JD-Core Version:    0.7.0.1
 */