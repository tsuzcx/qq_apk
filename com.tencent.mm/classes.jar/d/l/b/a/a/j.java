package d.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.p;
import d.l;
import java.lang.reflect.Type;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/reflect/jvm/internal/calls/ThrowingCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "()V", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
public final class j
  implements d
{
  public static final j NmL;
  
  static
  {
    AppMethodBeat.i(56646);
    NmL = new j();
    AppMethodBeat.o(56646);
  }
  
  public final Object ae(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(56645);
    p.h(paramArrayOfObject, "args");
    paramArrayOfObject = (Throwable)new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    AppMethodBeat.o(56645);
    throw paramArrayOfObject;
  }
  
  public final Type glt()
  {
    AppMethodBeat.i(56644);
    Object localObject = Void.TYPE;
    p.g(localObject, "Void.TYPE");
    localObject = (Type)localObject;
    AppMethodBeat.o(56644);
    return localObject;
  }
  
  public final List<Type> glu()
  {
    return (List)v.NhH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.a.j
 * JD-Core Version:    0.7.0.1
 */