package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.g.b.p;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", "isSuccess", "isSuccess-impl", "value$annotations", "()V", "equals", "other", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib"})
public final class Result<T>
  implements Serializable
{
  public static final Companion Companion;
  private final Object value;
  
  static
  {
    AppMethodBeat.i(128987);
    Companion = new Companion(null);
    AppMethodBeat.o(128987);
  }
  
  public static Object constructor-impl(Object paramObject)
  {
    return paramObject;
  }
  
  public static boolean equals-impl(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(206229);
    if (((paramObject2 instanceof Result)) && (p.j(paramObject1, ((Result)paramObject2).unbox-impl())))
    {
      AppMethodBeat.o(206229);
      return true;
    }
    AppMethodBeat.o(206229);
    return false;
  }
  
  public static final boolean equals-impl0(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(206230);
    if (p.j(paramObject1, paramObject2))
    {
      AppMethodBeat.o(206230);
      return true;
    }
    AppMethodBeat.o(206230);
    return false;
  }
  
  public static final Throwable exceptionOrNull-impl(Object paramObject)
  {
    if ((paramObject instanceof Result.Failure)) {
      return ((Result.Failure)paramObject).exception;
    }
    return null;
  }
  
  private static final T getOrNull-impl(Object paramObject)
  {
    AppMethodBeat.i(206225);
    if (isFailure-impl(paramObject))
    {
      AppMethodBeat.o(206225);
      return null;
    }
    AppMethodBeat.o(206225);
    return paramObject;
  }
  
  public static int hashCode-impl(Object paramObject)
  {
    AppMethodBeat.i(206228);
    if (paramObject != null)
    {
      int i = paramObject.hashCode();
      AppMethodBeat.o(206228);
      return i;
    }
    AppMethodBeat.o(206228);
    return 0;
  }
  
  public static final boolean isFailure-impl(Object paramObject)
  {
    return paramObject instanceof Result.Failure;
  }
  
  public static final boolean isSuccess-impl(Object paramObject)
  {
    return !(paramObject instanceof Result.Failure);
  }
  
  public static String toString-impl(Object paramObject)
  {
    AppMethodBeat.i(206226);
    if ((paramObject instanceof Result.Failure))
    {
      paramObject = paramObject.toString();
      AppMethodBeat.o(206226);
      return paramObject;
    }
    paramObject = "Success(" + paramObject + ')';
    AppMethodBeat.o(206226);
    return paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(128989);
    boolean bool = equals-impl(this.value, paramObject);
    AppMethodBeat.o(128989);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(128988);
    int i = hashCode-impl(this.value);
    AppMethodBeat.o(128988);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(128986);
    String str = toString-impl(this.value);
    AppMethodBeat.o(128986);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/Result$Companion;", "", "()V", "failure", "Lkotlin/Result;", "T", "exception", "", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "success", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
  public static final class Companion
  {
    private final <T> Object failure(Throwable paramThrowable)
    {
      AppMethodBeat.i(206286);
      paramThrowable = Result.constructor-impl(ResultKt.createFailure(paramThrowable));
      AppMethodBeat.o(206286);
      return paramThrowable;
    }
    
    private final <T> Object success(T paramT)
    {
      AppMethodBeat.i(206285);
      paramT = Result.constructor-impl(paramT);
      AppMethodBeat.o(206285);
      return paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlin.Result
 * JD-Core Version:    0.7.0.1
 */