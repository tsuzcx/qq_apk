package kotlin.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/calls/Caller;", "M", "Ljava/lang/reflect/Member;", "", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", "", "([Ljava/lang/Object;)V", "kotlin-reflection"})
public abstract interface d<M extends Member>
{
  public abstract Object ak(Object[] paramArrayOfObject);
  
  public abstract M iDg();
  
  public abstract Type iDh();
  
  public abstract List<Type> iDi();
  
  @l(iBK={1, 1, 16})
  public static final class a
  {
    public static <M extends Member> void a(d<? extends M> paramd, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56589);
      p.k(paramArrayOfObject, "args");
      if (f.a(paramd) != paramArrayOfObject.length)
      {
        paramd = (Throwable)new IllegalArgumentException("Callable expects " + f.a(paramd) + " arguments, but " + paramArrayOfObject.length + " were provided.");
        AppMethodBeat.o(56589);
        throw paramd;
      }
      AppMethodBeat.o(56589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */