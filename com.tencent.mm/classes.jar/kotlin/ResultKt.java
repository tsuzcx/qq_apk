package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"createFailure", "", "exception", "", "runCatching", "Lkotlin/Result;", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "fold", "T", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "onFailure", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrThrow", "(Ljava/lang/Object;)Ljava/lang/Object;", "map", "transform", "mapCatching", "action", "", "recover", "recoverCatching", "Lkotlin/ExtensionFunctionType;", "throwOnFailure", "(Ljava/lang/Object;)V", "kotlin-stdlib"})
public final class ResultKt
{
  public static final Object createFailure(Throwable paramThrowable)
  {
    AppMethodBeat.i(129575);
    p.h(paramThrowable, "exception");
    paramThrowable = new Result.Failure(paramThrowable);
    AppMethodBeat.o(129575);
    return paramThrowable;
  }
  
  private static final <R, T> R fold(Object paramObject, b<? super T, ? extends R> paramb, b<? super Throwable, ? extends R> paramb1)
  {
    AppMethodBeat.i(206198);
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null)
    {
      paramObject = paramb.invoke(paramObject);
      AppMethodBeat.o(206198);
      return paramObject;
    }
    paramObject = paramb1.invoke(localThrowable);
    AppMethodBeat.o(206198);
    return paramObject;
  }
  
  private static final <R, T extends R> R getOrDefault(Object paramObject, R paramR)
  {
    AppMethodBeat.i(206197);
    if (Result.isFailure-impl(paramObject))
    {
      AppMethodBeat.o(206197);
      return paramR;
    }
    AppMethodBeat.o(206197);
    return paramObject;
  }
  
  private static final <R, T extends R> R getOrElse(Object paramObject, b<? super Throwable, ? extends R> paramb)
  {
    AppMethodBeat.i(206196);
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null)
    {
      AppMethodBeat.o(206196);
      return paramObject;
    }
    paramObject = paramb.invoke(localThrowable);
    AppMethodBeat.o(206196);
    return paramObject;
  }
  
  private static final <T> T getOrThrow(Object paramObject)
  {
    AppMethodBeat.i(206195);
    throwOnFailure(paramObject);
    AppMethodBeat.o(206195);
    return paramObject;
  }
  
  private static final <R, T> Object map(Object paramObject, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(206199);
    if (Result.isSuccess-impl(paramObject))
    {
      Result.Companion localCompanion = Result.Companion;
      paramObject = Result.constructor-impl(paramb.invoke(paramObject));
      AppMethodBeat.o(206199);
      return paramObject;
    }
    paramObject = Result.constructor-impl(paramObject);
    AppMethodBeat.o(206199);
    return paramObject;
  }
  
  private static final <R, T> Object mapCatching(Object paramObject, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(206200);
    if (Result.isSuccess-impl(paramObject)) {
      try
      {
        Result.Companion localCompanion = Result.Companion;
        paramObject = Result.constructor-impl(paramb.invoke(paramObject));
        AppMethodBeat.o(206200);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        for (;;)
        {
          paramb = Result.Companion;
          paramObject = Result.constructor-impl(createFailure(paramObject));
        }
      }
    }
    paramObject = Result.constructor-impl(paramObject);
    AppMethodBeat.o(206200);
    return paramObject;
  }
  
  private static final <T> Object onFailure(Object paramObject, b<? super Throwable, x> paramb)
  {
    AppMethodBeat.i(206203);
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable != null) {
      paramb.invoke(localThrowable);
    }
    AppMethodBeat.o(206203);
    return paramObject;
  }
  
  private static final <T> Object onSuccess(Object paramObject, b<? super T, x> paramb)
  {
    AppMethodBeat.i(206204);
    if (Result.isSuccess-impl(paramObject)) {
      paramb.invoke(paramObject);
    }
    AppMethodBeat.o(206204);
    return paramObject;
  }
  
  private static final <R, T extends R> Object recover(Object paramObject, b<? super Throwable, ? extends R> paramb)
  {
    AppMethodBeat.i(206201);
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null)
    {
      AppMethodBeat.o(206201);
      return paramObject;
    }
    paramObject = Result.Companion;
    paramObject = Result.constructor-impl(paramb.invoke(localThrowable));
    AppMethodBeat.o(206201);
    return paramObject;
  }
  
  private static final <R, T extends R> Object recoverCatching(Object paramObject, b<? super Throwable, ? extends R> paramb)
  {
    AppMethodBeat.i(206202);
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null)
    {
      AppMethodBeat.o(206202);
      return paramObject;
    }
    try
    {
      paramObject = Result.Companion;
      paramObject = Result.constructor-impl(paramb.invoke(localThrowable));
      AppMethodBeat.o(206202);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      for (;;)
      {
        paramb = Result.Companion;
        paramObject = Result.constructor-impl(createFailure(paramObject));
      }
    }
  }
  
  private static final <T, R> Object runCatching(T paramT, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(206194);
    try
    {
      Result.Companion localCompanion = Result.Companion;
      paramT = Result.constructor-impl(paramb.invoke(paramT));
      AppMethodBeat.o(206194);
      return paramT;
    }
    catch (Throwable paramT)
    {
      for (;;)
      {
        paramb = Result.Companion;
        paramT = Result.constructor-impl(createFailure(paramT));
      }
    }
  }
  
  private static final <R> Object runCatching(a<? extends R> parama)
  {
    AppMethodBeat.i(206193);
    try
    {
      localCompanion = Result.Companion;
      parama = Result.constructor-impl(parama.invoke());
      AppMethodBeat.o(206193);
      return parama;
    }
    catch (Throwable parama)
    {
      for (;;)
      {
        Result.Companion localCompanion = Result.Companion;
        parama = Result.constructor-impl(createFailure(parama));
      }
    }
  }
  
  public static final void throwOnFailure(Object paramObject)
  {
    if ((paramObject instanceof Result.Failure)) {
      throw ((Result.Failure)paramObject).exception;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlin.ResultKt
 * JD-Core Version:    0.7.0.1
 */