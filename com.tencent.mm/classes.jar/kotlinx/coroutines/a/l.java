package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/ChannelResult;", "T", "", "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getHolder$annotations", "()V", "isClosed", "", "isClosed-impl", "(Ljava/lang/Object;)Z", "isFailure", "isFailure-impl", "isSuccess", "isSuccess-impl", "equals", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "getOrThrow", "getOrThrow-impl", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Closed", "Companion", "Failed", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class l<T>
{
  public static final b ajxF;
  private static final l.c ajxH;
  public final Object ajxG;
  
  static
  {
    AppMethodBeat.i(189357);
    ajxF = new b((byte)0);
    ajxH = new l.c();
    AppMethodBeat.o(189357);
  }
  
  public static <T> Object constructor-impl(Object paramObject)
  {
    return paramObject;
  }
  
  public static final Throwable exceptionOrNull-impl(Object paramObject)
  {
    if ((paramObject instanceof l.a)) {}
    for (paramObject = (l.a)paramObject; paramObject == null; paramObject = null) {
      return null;
    }
    return paramObject.cause;
  }
  
  public static final T getOrNull-impl(Object paramObject)
  {
    if (!(paramObject instanceof l.c)) {
      return paramObject;
    }
    return null;
  }
  
  public static final boolean iW(Object paramObject)
  {
    return paramObject instanceof l.a;
  }
  
  public static final T iX(Object paramObject)
  {
    AppMethodBeat.i(189303);
    if (!(paramObject instanceof l.c))
    {
      AppMethodBeat.o(189303);
      return paramObject;
    }
    if (((paramObject instanceof l.a)) && (((l.a)paramObject).cause != null))
    {
      paramObject = ((l.a)paramObject).cause;
      AppMethodBeat.o(189303);
      throw paramObject;
    }
    paramObject = (Throwable)new IllegalStateException(s.X("Trying to call 'getOrThrow' on a failed channel result: ", paramObject).toString());
    AppMethodBeat.o(189303);
    throw paramObject;
  }
  
  public static final boolean isFailure-impl(Object paramObject)
  {
    return paramObject instanceof l.c;
  }
  
  public static final boolean isSuccess-impl(Object paramObject)
  {
    return !(paramObject instanceof l.c);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(189384);
    Object localObject = this.ajxG;
    if (!(paramObject instanceof l))
    {
      AppMethodBeat.o(189384);
      return false;
    }
    if (!s.p(localObject, ((l)paramObject).ajxG))
    {
      AppMethodBeat.o(189384);
      return false;
    }
    AppMethodBeat.o(189384);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(189376);
    Object localObject = this.ajxG;
    if (localObject == null)
    {
      AppMethodBeat.o(189376);
      return 0;
    }
    int i = localObject.hashCode();
    AppMethodBeat.o(189376);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(189367);
    Object localObject = this.ajxG;
    if ((localObject instanceof l.a))
    {
      localObject = localObject.toString();
      AppMethodBeat.o(189367);
      return localObject;
    }
    localObject = "Value(" + localObject + ')';
    AppMethodBeat.o(189367);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/ChannelResult$Companion;", "", "()V", "failed", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "closed", "Lkotlinx/coroutines/channels/ChannelResult;", "E", "cause", "", "closed-JP2dKIU", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "failure", "failure-PtdJZtk", "()Ljava/lang/Object;", "success", "value", "success-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static <E> Object Y(Throwable paramThrowable)
    {
      AppMethodBeat.i(189351);
      paramThrowable = l.constructor-impl(new l.a(paramThrowable));
      AppMethodBeat.o(189351);
      return paramThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.l
 * JD-Core Version:    0.7.0.1
 */