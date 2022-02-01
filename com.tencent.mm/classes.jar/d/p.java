package d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", "isSuccess", "isSuccess-impl", "value$annotations", "()V", "equals", "other", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib"})
public final class p<T>
  implements Serializable
{
  public static final a Nhh;
  private final Object value;
  
  static
  {
    AppMethodBeat.i(128987);
    Nhh = new a((byte)0);
    AppMethodBeat.o(128987);
  }
  
  public static final boolean eL(Object paramObject)
  {
    return !(paramObject instanceof p.b);
  }
  
  public static final boolean eM(Object paramObject)
  {
    return paramObject instanceof p.b;
  }
  
  public static final Throwable eN(Object paramObject)
  {
    if ((paramObject instanceof p.b)) {
      return ((p.b)paramObject).Nhi;
    }
    return null;
  }
  
  public static Object eO(Object paramObject)
  {
    return paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(128989);
    Object localObject = this.value;
    if (((paramObject instanceof p)) && (d.g.b.p.i(localObject, ((p)paramObject).value)))
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
    if ((localObject instanceof p.b))
    {
      localObject = localObject.toString();
      AppMethodBeat.o(128986);
      return localObject;
    }
    localObject = "Success(" + localObject + ')';
    AppMethodBeat.o(128986);
    return localObject;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/Result$Companion;", "", "()V", "failure", "Lkotlin/Result;", "T", "exception", "", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "success", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.p
 * JD-Core Version:    0.7.0.1
 */