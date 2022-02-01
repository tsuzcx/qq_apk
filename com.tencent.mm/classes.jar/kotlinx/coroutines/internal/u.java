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
import kotlin.t;
import kotlinx.coroutines.ap;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"baseContinuationImplClass", "", "baseContinuationImplClassName", "kotlin.jvm.PlatformType", "stackTraceRecoveryClass", "stackTraceRecoveryClassName", "artificialFrame", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "message", "createFinalException", "E", "", "cause", "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "createStackTrace", "continuation", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "mergeRecoveredTraces", "", "recoveredStacktrace", "", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", "exception", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "unwrap", "unwrapImpl", "causeAndStacktrace", "Lkotlin/Pair;", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "elementWiseEquals", "", "e", "frameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "initCause", "isArtificial", "sanitizeStackTrace", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"})
public final class u
{
  private static final String abzx;
  private static final String abzy;
  
  static
  {
    AppMethodBeat.i(204966);
    try
    {
      localObject1 = Result.Companion;
      localObject1 = Result.constructor-impl(Class.forName("kotlin.d.b.a.a").getCanonicalName());
      if (Result.exceptionOrNull-impl(localObject1) == null) {
        abzx = (String)localObject1;
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          Object localObject1 = Result.Companion;
          localObject1 = Result.constructor-impl(Class.forName("kotlinx.coroutines.internal.u").getCanonicalName());
          if (Result.exceptionOrNull-impl(localObject1) != null) {
            break;
          }
          abzy = (String)localObject1;
          AppMethodBeat.o(204966);
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
          localObject3 = "kotlinx.coroutines.internal.u";
        }
      }
    }
  }
  
  public static final <E extends Throwable> E L(E paramE)
  {
    int j = 0;
    AppMethodBeat.i(204959);
    if (!ap.iRh())
    {
      AppMethodBeat.o(204959);
      return paramE;
    }
    Throwable localThrowable = f.J(paramE);
    if (localThrowable == null)
    {
      AppMethodBeat.o(204959);
      return paramE;
    }
    StackTraceElement[] arrayOfStackTraceElement1 = localThrowable.getStackTrace();
    int m = arrayOfStackTraceElement1.length;
    int k = a(arrayOfStackTraceElement1, abzy);
    int i = a(arrayOfStackTraceElement1, abzx);
    StackTraceElement[] arrayOfStackTraceElement2;
    if (i == -1)
    {
      i = 0;
      m = m - k - i;
      arrayOfStackTraceElement2 = new StackTraceElement[m];
      i = j;
      label92:
      if (i >= m) {
        break label142;
      }
      if (i != 0) {
        break label128;
      }
    }
    label128:
    for (paramE = bHE("Coroutine boundary");; paramE = arrayOfStackTraceElement1[(k + 1 + i - 1)])
    {
      arrayOfStackTraceElement2[i] = paramE;
      i += 1;
      break label92;
      i = m - i;
      break;
    }
    label142:
    localThrowable.setStackTrace(arrayOfStackTraceElement2);
    AppMethodBeat.o(204959);
    return localThrowable;
  }
  
  public static final <E extends Throwable> E M(E paramE)
  {
    int k = 0;
    AppMethodBeat.i(204962);
    Throwable localThrowable = paramE.getCause();
    if ((localThrowable == null) || ((p.h(localThrowable.getClass(), paramE.getClass()) ^ true)))
    {
      AppMethodBeat.o(204962);
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
        AppMethodBeat.o(204962);
        return localThrowable;
      }
      i += 1;
    }
    AppMethodBeat.o(204962);
    return paramE;
  }
  
  private static final int a(StackTraceElement[] paramArrayOfStackTraceElement, String paramString)
  {
    AppMethodBeat.i(204965);
    int i = 0;
    int j = paramArrayOfStackTraceElement.length;
    while (i < j)
    {
      if (p.h(paramString, paramArrayOfStackTraceElement[i].getClassName()))
      {
        AppMethodBeat.o(204965);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(204965);
    return -1;
  }
  
  private static final <E extends Throwable> E a(E paramE1, E paramE2, ArrayDeque<StackTraceElement> paramArrayDeque)
  {
    AppMethodBeat.i(204960);
    paramArrayDeque.addFirst(bHE("Coroutine boundary"));
    StackTraceElement[] arrayOfStackTraceElement = paramE1.getStackTrace();
    int j = a(arrayOfStackTraceElement, abzx);
    if (j == -1)
    {
      paramE1 = ((Collection)paramArrayDeque).toArray(new StackTraceElement[0]);
      if (paramE1 == null)
      {
        paramE1 = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(204960);
        throw paramE1;
      }
      paramE2.setStackTrace((StackTraceElement[])paramE1);
      AppMethodBeat.o(204960);
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
    AppMethodBeat.o(204960);
    return paramE2;
  }
  
  private static final void a(StackTraceElement[] paramArrayOfStackTraceElement, ArrayDeque<StackTraceElement> paramArrayDeque)
  {
    AppMethodBeat.i(204961);
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
        if ((localStackTraceElement1.getLineNumber() != localStackTraceElement2.getLineNumber()) || (!p.h(localStackTraceElement1.getMethodName(), localStackTraceElement2.getMethodName())) || (!p.h(localStackTraceElement1.getFileName(), localStackTraceElement2.getFileName())) || (!p.h(localStackTraceElement1.getClassName(), localStackTraceElement2.getClassName()))) {
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
    AppMethodBeat.o(204961);
  }
  
  private static boolean a(StackTraceElement paramStackTraceElement)
  {
    AppMethodBeat.i(204964);
    boolean bool = n.M(paramStackTraceElement.getClassName(), "\b\b\b", false);
    AppMethodBeat.o(204964);
    return bool;
  }
  
  private static StackTraceElement bHE(String paramString)
  {
    AppMethodBeat.i(204963);
    paramString = new StackTraceElement("\b\b\b(".concat(String.valueOf(paramString)), "\b", "\b", -1);
    AppMethodBeat.o(204963);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.internal.u
 * JD-Core Version:    0.7.0.1
 */