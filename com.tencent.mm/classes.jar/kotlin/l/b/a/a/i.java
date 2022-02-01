package kotlin.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Method;", "unboxMethod", "parameterTypes", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Method;Ljava/util/List;)V", "member", "getMember", "()Ljava/lang/reflect/Method;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "callMethod", "", "instance", "args", "", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "Bound", "Unbound", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "kotlin-reflection"})
public abstract class i
  implements d<Method>
{
  private final List<Type> aaEI;
  private final Type aaFc;
  private final Method aaFm;
  
  private i(Method paramMethod, List<? extends Type> paramList)
  {
    this.aaFm = paramMethod;
    this.aaEI = paramList;
    paramMethod = this.aaFm.getReturnType();
    p.j(paramMethod, "unboxMethod.returnType");
    this.aaFc = ((Type)paramMethod);
  }
  
  public final void al(Object[] paramArrayOfObject)
  {
    p.k(paramArrayOfObject, "args");
    d.a.a(this, paramArrayOfObject);
  }
  
  protected final Object c(Object paramObject, Object[] paramArrayOfObject)
  {
    p.k(paramArrayOfObject, "args");
    return this.aaFm.invoke(paramObject, Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length));
  }
  
  public final Type iDh()
  {
    return this.aaFc;
  }
  
  public final List<Type> iDi()
  {
    return this.aaEI;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "unboxMethod", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class a
    extends i
    implements c
  {
    private final Object aaFf;
    
    public a(Method paramMethod, Object paramObject)
    {
      super((List)v.aaAd, (byte)0);
      AppMethodBeat.i(56641);
      this.aaFf = paramObject;
      AppMethodBeat.o(56641);
    }
    
    public final Object ak(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56640);
      p.k(paramArrayOfObject, "args");
      al(paramArrayOfObject);
      paramArrayOfObject = c(this.aaFf, paramArrayOfObject);
      AppMethodBeat.o(56640);
      return paramArrayOfObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "unboxMethod", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class b
    extends i
  {
    public b(Method paramMethod)
    {
      super(j.listOf(paramMethod.getDeclaringClass()), (byte)0);
      AppMethodBeat.i(56643);
      AppMethodBeat.o(56643);
    }
    
    public final Object ak(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56642);
      p.k(paramArrayOfObject, "args");
      al(paramArrayOfObject);
      Object localObject2 = paramArrayOfObject[0];
      Object localObject1 = e.aaFe;
      if (paramArrayOfObject.length <= 1) {
        paramArrayOfObject = new Object[0];
      }
      do
      {
        paramArrayOfObject = c(localObject2, paramArrayOfObject);
        AppMethodBeat.o(56642);
        return paramArrayOfObject;
        localObject1 = kotlin.a.e.a(paramArrayOfObject, 1, paramArrayOfObject.length);
        paramArrayOfObject = (Object[])localObject1;
      } while (localObject1 != null);
      paramArrayOfObject = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(56642);
      throw paramArrayOfObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.a.i
 * JD-Core Version:    0.7.0.1
 */