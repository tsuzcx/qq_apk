package kotlin.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/calls/ThrowingCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "()V", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
public final class j
  implements d
{
  public static final j aaFn;
  
  static
  {
    AppMethodBeat.i(56646);
    aaFn = new j();
    AppMethodBeat.o(56646);
  }
  
  public final Object ak(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(56645);
    p.k(paramArrayOfObject, "args");
    paramArrayOfObject = (Throwable)new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    AppMethodBeat.o(56645);
    throw paramArrayOfObject;
  }
  
  public final Type iDh()
  {
    AppMethodBeat.i(56644);
    Object localObject = Void.TYPE;
    p.j(localObject, "Void.TYPE");
    localObject = (Type)localObject;
    AppMethodBeat.o(56644);
    return localObject;
  }
  
  public final List<Type> iDi()
  {
    return (List)v.aaAd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.a.j
 * JD-Core Version:    0.7.0.1
 */