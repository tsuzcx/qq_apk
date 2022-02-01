package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", "isSuccess", "isSuccess-impl", "getValue$annotations", "()V", "equals", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
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
    AppMethodBeat.i(190812);
    if (((paramObject2 instanceof Result)) && (s.p(paramObject1, ((Result)paramObject2).unbox-impl())))
    {
      AppMethodBeat.o(190812);
      return true;
    }
    AppMethodBeat.o(190812);
    return false;
  }
  
  public static final boolean equals-impl0(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(190819);
    if (s.p(paramObject1, paramObject2))
    {
      AppMethodBeat.o(190819);
      return true;
    }
    AppMethodBeat.o(190819);
    return false;
  }
  
  public static final Throwable exceptionOrNull-impl(Object paramObject)
  {
    if ((paramObject instanceof Failure)) {
      return ((Failure)paramObject).exception;
    }
    return null;
  }
  
  private static final T getOrNull-impl(Object paramObject)
  {
    AppMethodBeat.i(190774);
    if (isFailure-impl(paramObject))
    {
      AppMethodBeat.o(190774);
      return null;
    }
    AppMethodBeat.o(190774);
    return paramObject;
  }
  
  public static int hashCode-impl(Object paramObject)
  {
    AppMethodBeat.i(190805);
    if (paramObject != null)
    {
      int i = paramObject.hashCode();
      AppMethodBeat.o(190805);
      return i;
    }
    AppMethodBeat.o(190805);
    return 0;
  }
  
  public static final boolean isFailure-impl(Object paramObject)
  {
    return paramObject instanceof Failure;
  }
  
  public static final boolean isSuccess-impl(Object paramObject)
  {
    return !(paramObject instanceof Failure);
  }
  
  public static String toString-impl(Object paramObject)
  {
    AppMethodBeat.i(190786);
    if ((paramObject instanceof Failure))
    {
      paramObject = paramObject.toString();
      AppMethodBeat.o(190786);
      return paramObject;
    }
    paramObject = "Success(" + paramObject + ')';
    AppMethodBeat.o(190786);
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
  
  @Metadata(d1={""}, d2={"Lkotlin/Result$Companion;", "", "()V", "failure", "Lkotlin/Result;", "T", "exception", "", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "success", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class Companion
  {
    private final <T> Object failure(Throwable paramThrowable)
    {
      AppMethodBeat.i(190824);
      paramThrowable = Result.constructor-impl(ResultKt.createFailure(paramThrowable));
      AppMethodBeat.o(190824);
      return paramThrowable;
    }
    
    private final <T> Object success(T paramT)
    {
      AppMethodBeat.i(190817);
      paramT = Result.constructor-impl(paramT);
      AppMethodBeat.o(190817);
      return paramT;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "exception", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class Failure
    implements Serializable
  {
    public final Throwable exception;
    
    public Failure(Throwable paramThrowable)
    {
      AppMethodBeat.i(129288);
      this.exception = paramThrowable;
      AppMethodBeat.o(129288);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(129285);
      if (((paramObject instanceof Failure)) && (s.p(this.exception, ((Failure)paramObject).exception)))
      {
        AppMethodBeat.o(129285);
        return true;
      }
      AppMethodBeat.o(129285);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(129286);
      int i = this.exception.hashCode();
      AppMethodBeat.o(129286);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(129287);
      String str = "Failure(" + this.exception + ')';
      AppMethodBeat.o(129287);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.Result
 * JD-Core Version:    0.7.0.1
 */