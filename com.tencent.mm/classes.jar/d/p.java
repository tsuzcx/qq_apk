package d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import java.io.Serializable;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", "isSuccess", "isSuccess-impl", "value$annotations", "()V", "equals", "other", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib"})
public final class p<T>
  implements Serializable
{
  public static final a KTg;
  private final Object value;
  
  static
  {
    AppMethodBeat.i(128987);
    KTg = new a((byte)0);
    AppMethodBeat.o(128987);
  }
  
  public static final boolean eF(Object paramObject)
  {
    return !(paramObject instanceof b);
  }
  
  public static final boolean eG(Object paramObject)
  {
    return paramObject instanceof b;
  }
  
  public static final Throwable eH(Object paramObject)
  {
    if ((paramObject instanceof b)) {
      return ((b)paramObject).KTh;
    }
    return null;
  }
  
  public static Object eI(Object paramObject)
  {
    return paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(128989);
    Object localObject = this.value;
    if (((paramObject instanceof p)) && (k.g(localObject, ((p)paramObject).value)))
    {
      AppMethodBeat.o(128989);
      return true;
    }
    AppMethodBeat.o(128989);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(128988);
    Object localObject = this.value;
    if (localObject != null)
    {
      int i = localObject.hashCode();
      AppMethodBeat.o(128988);
      return i;
    }
    AppMethodBeat.o(128988);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(128986);
    Object localObject = this.value;
    if ((localObject instanceof b))
    {
      localObject = localObject.toString();
      AppMethodBeat.o(128986);
      return localObject;
    }
    localObject = "Success(" + localObject + ')';
    AppMethodBeat.o(128986);
    return localObject;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/Result$Companion;", "", "()V", "failure", "Lkotlin/Result;", "T", "exception", "", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "success", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "exception", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"})
  public static final class b
    implements Serializable
  {
    public final Throwable KTh;
    
    public b(Throwable paramThrowable)
    {
      AppMethodBeat.i(129288);
      this.KTh = paramThrowable;
      AppMethodBeat.o(129288);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(129285);
      if (((paramObject instanceof b)) && (k.g(this.KTh, ((b)paramObject).KTh)))
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
      int i = this.KTh.hashCode();
      AppMethodBeat.o(129286);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(129287);
      String str = "Failure(" + this.KTh + ')';
      AppMethodBeat.o(129287);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.p
 * JD-Core Version:    0.7.0.1
 */