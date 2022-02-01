package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/ValueOrClosed;", "T", "", "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "closeCause", "", "closeCause$annotations", "()V", "getCloseCause-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "isClosed", "", "isClosed-impl", "(Ljava/lang/Object;)Z", "value", "value$annotations", "getValue-impl", "valueOrNull", "valueOrNull$annotations", "getValueOrNull-impl", "equals", "other", "hashCode", "", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Closed", "Companion", "kotlinx-coroutines-core"})
public final class z<T>
{
  public static final z.b abyF;
  public final Object abyE;
  
  static
  {
    AppMethodBeat.i(204421);
    abyF = new z.b((byte)0);
    AppMethodBeat.o(204421);
  }
  
  public static Object constructor-impl(Object paramObject)
  {
    return paramObject;
  }
  
  public static final boolean gr(Object paramObject)
  {
    return paramObject instanceof z.a;
  }
  
  public static final T gs(Object paramObject)
  {
    AppMethodBeat.i(204416);
    if ((paramObject instanceof z.a))
    {
      paramObject = (Throwable)new IllegalStateException("Channel was closed".toString());
      AppMethodBeat.o(204416);
      throw paramObject;
    }
    AppMethodBeat.o(204416);
    return paramObject;
  }
  
  public static final Throwable gt(Object paramObject)
  {
    AppMethodBeat.i(204417);
    if ((paramObject instanceof z.a))
    {
      paramObject = ((z.a)paramObject).cause;
      AppMethodBeat.o(204417);
      return paramObject;
    }
    paramObject = (Throwable)new IllegalStateException("Channel was not closed".toString());
    AppMethodBeat.o(204417);
    throw paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204424);
    Object localObject = this.abyE;
    if (((paramObject instanceof z)) && (p.h(localObject, ((z)paramObject).abyE)))
    {
      AppMethodBeat.o(204424);
      return true;
    }
    AppMethodBeat.o(204424);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204423);
    Object localObject = this.abyE;
    if (localObject != null)
    {
      int i = localObject.hashCode();
      AppMethodBeat.o(204423);
      return i;
    }
    AppMethodBeat.o(204423);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204414);
    Object localObject = this.abyE;
    if ((localObject instanceof z.a))
    {
      localObject = localObject.toString();
      AppMethodBeat.o(204414);
      return localObject;
    }
    localObject = "Value(" + localObject + ')';
    AppMethodBeat.o(204414);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.a.z
 * JD-Core Version:    0.7.0.1
 */