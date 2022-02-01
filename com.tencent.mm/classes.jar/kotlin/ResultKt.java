package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"createFailure", "", "exception", "", "runCatching", "Lkotlin/Result;", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "fold", "T", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "onFailure", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrThrow", "(Ljava/lang/Object;)Ljava/lang/Object;", "map", "transform", "mapCatching", "action", "", "recover", "recoverCatching", "Lkotlin/ExtensionFunctionType;", "throwOnFailure", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class ResultKt
{
  public static final Object createFailure(Throwable paramThrowable)
  {
    AppMethodBeat.i(129575);
    s.u(paramThrowable, "exception");
    paramThrowable = new Result.Failure(paramThrowable);
    AppMethodBeat.o(129575);
    return paramThrowable;
  }
  
  private static final <R, T> R fold(Object paramObject, b<? super T, ? extends R> paramb, b<? super Throwable, ? extends R> paramb1)
  {
    AppMethodBeat.i(190871);
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null)
    {
      paramObject = paramb.invoke(paramObject);
      AppMethodBeat.o(190871);
      return paramObject;
    }
    paramObject = paramb1.invoke(localThrowable);
    AppMethodBeat.o(190871);
    return paramObject;
  }
  
  private static final <R, T extends R> R getOrDefault(Object paramObject, R paramR)
  {
    AppMethodBeat.i(190862);
    if (Result.isFailure-impl(paramObject))
    {
      AppMethodBeat.o(190862);
      return paramR;
    }
    AppMethodBeat.o(190862);
    return paramObject;
  }
  
  private static final <R, T extends R> R getOrElse(Object paramObject, b<? super Throwable, ? extends R> paramb)
  {
    AppMethodBeat.i(190855);
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null)
    {
      AppMethodBeat.o(190855);
      return paramObject;
    }
    paramObject = paramb.invoke(localThrowable);
    AppMethodBeat.o(190855);
    return paramObject;
  }
  
  private static final <T> T getOrThrow(Object paramObject)
  {
    AppMethodBeat.i(190851);
    throwOnFailure(paramObject);
    AppMethodBeat.o(190851);
    return paramObject;
  }
  
  private static final <R, T> Object map(Object paramObject, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(190877);
    if (Result.isSuccess-impl(paramObject))
    {
      Result.Companion localCompanion = Result.Companion;
      paramObject = Result.constructor-impl(paramb.invoke(paramObject));
      AppMethodBeat.o(190877);
      return paramObject;
    }
    paramObject = Result.constructor-impl(paramObject);
    AppMethodBeat.o(190877);
    return paramObject;
  }
  
  private static final <R, T> Object mapCatching(Object paramObject, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(190883);
    if (Result.isSuccess-impl(paramObject)) {
      try
      {
        Result.Companion localCompanion = Result.Companion;
        paramObject = Result.constructor-impl(paramb.invoke(paramObject));
        AppMethodBeat.o(190883);
        return paramObject;
      }
      finally
      {
        for (;;)
        {
          paramb = Result.Companion;
          paramObject = Result.constructor-impl(createFailure(paramObject));
        }
      }
    }
    paramObject = Result.constructor-impl(paramObject);
    AppMethodBeat.o(190883);
    return paramObject;
  }
  
  private static final <T> Object onFailure(Object paramObject, b<? super Throwable, ah> paramb)
  {
    AppMethodBeat.i(190893);
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable != null) {
      paramb.invoke(localThrowable);
    }
    AppMethodBeat.o(190893);
    return paramObject;
  }
  
  private static final <T> Object onSuccess(Object paramObject, b<? super T, ah> paramb)
  {
    AppMethodBeat.i(190897);
    if (Result.isSuccess-impl(paramObject)) {
      paramb.invoke(paramObject);
    }
    AppMethodBeat.o(190897);
    return paramObject;
  }
  
  private static final <R, T extends R> Object recover(Object paramObject, b<? super Throwable, ? extends R> paramb)
  {
    AppMethodBeat.i(190886);
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null)
    {
      AppMethodBeat.o(190886);
      return paramObject;
    }
    paramObject = Result.Companion;
    paramObject = Result.constructor-impl(paramb.invoke(localThrowable));
    AppMethodBeat.o(190886);
    return paramObject;
  }
  
  private static final <R, T extends R> Object recoverCatching(Object paramObject, b<? super Throwable, ? extends R> paramb)
  {
    AppMethodBeat.i(190890);
    Throwable localThrowable = Result.exceptionOrNull-impl(paramObject);
    if (localThrowable == null)
    {
      AppMethodBeat.o(190890);
      return paramObject;
    }
    try
    {
      paramObject = Result.Companion;
      paramObject = Result.constructor-impl(paramb.invoke(localThrowable));
      AppMethodBeat.o(190890);
      return paramObject;
    }
    finally
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
    AppMethodBeat.i(190847);
    try
    {
      Result.Companion localCompanion = Result.Companion;
      paramT = Result.constructor-impl(paramb.invoke(paramT));
      AppMethodBeat.o(190847);
      return paramT;
    }
    finally
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
    AppMethodBeat.i(190840);
    try
    {
      localCompanion = Result.Companion;
      parama = Result.constructor-impl(parama.invoke());
      AppMethodBeat.o(190840);
      return parama;
    }
    finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.ResultKt
 * JD-Core Version:    0.7.0.1
 */