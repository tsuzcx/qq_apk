package d.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.k;
import d.l;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

@l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Method;", "unboxMethod", "parameterTypes", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Method;Ljava/util/List;)V", "member", "getMember", "()Ljava/lang/reflect/Method;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "callMethod", "", "instance", "args", "", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "Bound", "Unbound", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "kotlin-reflection"})
public abstract class i
  implements d<Method>
{
  private final List<Type> JkK;
  private final Type Jlf;
  private final Method Jlq;
  
  private i(Method paramMethod, List<? extends Type> paramList)
  {
    this.Jlq = paramMethod;
    this.JkK = paramList;
    paramMethod = this.Jlq.getReturnType();
    k.g(paramMethod, "unboxMethod.returnType");
    this.Jlf = ((Type)paramMethod);
  }
  
  public final void ad(Object[] paramArrayOfObject)
  {
    k.h(paramArrayOfObject, "args");
    d.a.a(this, paramArrayOfObject);
  }
  
  protected final Object b(Object paramObject, Object[] paramArrayOfObject)
  {
    k.h(paramArrayOfObject, "args");
    return this.Jlq.invoke(paramObject, Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length));
  }
  
  public final Type fwP()
  {
    return this.Jlf;
  }
  
  public final List<Type> fwQ()
  {
    return this.JkK;
  }
  
  @l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "unboxMethod", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class a
    extends i
    implements c
  {
    private final Object Jli;
    
    public a(Method paramMethod, Object paramObject)
    {
      super((List)d.a.v.Jgl, (byte)0);
      AppMethodBeat.i(56641);
      this.Jli = paramObject;
      AppMethodBeat.o(56641);
    }
    
    public final Object ac(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56640);
      k.h(paramArrayOfObject, "args");
      ad(paramArrayOfObject);
      paramArrayOfObject = b(this.Jli, paramArrayOfObject);
      AppMethodBeat.o(56640);
      return paramArrayOfObject;
    }
  }
  
  @l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "unboxMethod", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class b
    extends i
  {
    public b(Method paramMethod)
    {
      super(j.listOf(paramMethod.getDeclaringClass()), (byte)0);
      AppMethodBeat.i(56643);
      AppMethodBeat.o(56643);
    }
    
    public final Object ac(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56642);
      k.h(paramArrayOfObject, "args");
      ad(paramArrayOfObject);
      Object localObject2 = paramArrayOfObject[0];
      Object localObject1 = e.Jlh;
      if (paramArrayOfObject.length <= 1) {
        paramArrayOfObject = new Object[0];
      }
      do
      {
        paramArrayOfObject = b(localObject2, paramArrayOfObject);
        AppMethodBeat.o(56642);
        return paramArrayOfObject;
        localObject1 = d.a.e.copyOfRange(paramArrayOfObject, 1, paramArrayOfObject.length);
        paramArrayOfObject = (Object[])localObject1;
      } while (localObject1 != null);
      paramArrayOfObject = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(56642);
      throw paramArrayOfObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.a.i
 * JD-Core Version:    0.7.0.1
 */