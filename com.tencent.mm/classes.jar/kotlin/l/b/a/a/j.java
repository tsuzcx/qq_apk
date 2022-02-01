package kotlin.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/ThrowingCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "()V", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public final class j
  implements d
{
  public static final j aiBe;
  
  static
  {
    AppMethodBeat.i(56646);
    aiBe = new j();
    AppMethodBeat.o(56646);
  }
  
  public final Object ap(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(56645);
    s.u(paramArrayOfObject, "args");
    paramArrayOfObject = (Throwable)new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    AppMethodBeat.o(56645);
    throw paramArrayOfObject;
  }
  
  public final List<Type> kmA()
  {
    return (List)ab.aivy;
  }
  
  public final Type kmz()
  {
    AppMethodBeat.i(56644);
    Object localObject = Void.TYPE;
    s.s(localObject, "Void.TYPE");
    localObject = (Type)localObject;
    AppMethodBeat.o(56644);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.a.j
 * JD-Core Version:    0.7.0.1
 */