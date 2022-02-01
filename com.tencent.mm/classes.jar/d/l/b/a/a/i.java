package d.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.l;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Method;", "unboxMethod", "parameterTypes", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Method;Ljava/util/List;)V", "member", "getMember", "()Ljava/lang/reflect/Method;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "callMethod", "", "instance", "args", "", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "Bound", "Unbound", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "kotlin-reflection"})
public abstract class i
  implements d<Method>
{
  private final Method MPF;
  private final List<Type> MPb;
  private final Type MPv;
  
  private i(Method paramMethod, List<? extends Type> paramList)
  {
    this.MPF = paramMethod;
    this.MPb = paramList;
    paramMethod = this.MPF.getReturnType();
    p.g(paramMethod, "unboxMethod.returnType");
    this.MPv = ((Type)paramMethod);
  }
  
  public final void ag(Object[] paramArrayOfObject)
  {
    p.h(paramArrayOfObject, "args");
    d.a.a(this, paramArrayOfObject);
  }
  
  protected final Object b(Object paramObject, Object[] paramArrayOfObject)
  {
    p.h(paramArrayOfObject, "args");
    return this.MPF.invoke(paramObject, Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length));
  }
  
  public final Type ggR()
  {
    return this.MPv;
  }
  
  public final List<Type> ggS()
  {
    return this.MPb;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "unboxMethod", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class a
    extends i
    implements c
  {
    private final Object MPy;
    
    public a(Method paramMethod, Object paramObject)
    {
      super((List)d.a.v.MKE, (byte)0);
      AppMethodBeat.i(56641);
      this.MPy = paramObject;
      AppMethodBeat.o(56641);
    }
    
    public final Object af(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56640);
      p.h(paramArrayOfObject, "args");
      ag(paramArrayOfObject);
      paramArrayOfObject = b(this.MPy, paramArrayOfObject);
      AppMethodBeat.o(56640);
      return paramArrayOfObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "unboxMethod", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class b
    extends i
  {
    public b(Method paramMethod)
    {
      super(j.listOf(paramMethod.getDeclaringClass()), (byte)0);
      AppMethodBeat.i(56643);
      AppMethodBeat.o(56643);
    }
    
    public final Object af(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56642);
      p.h(paramArrayOfObject, "args");
      ag(paramArrayOfObject);
      Object localObject2 = paramArrayOfObject[0];
      Object localObject1 = e.MPx;
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