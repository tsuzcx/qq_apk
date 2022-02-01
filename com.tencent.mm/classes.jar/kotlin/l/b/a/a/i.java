package kotlin.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Method;", "unboxMethod", "parameterTypes", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Method;Ljava/util/List;)V", "member", "getMember", "()Ljava/lang/reflect/Method;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "callMethod", "", "instance", "args", "", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "Bound", "Unbound", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public abstract class i
  implements d<Method>
{
  private final Type aiAT;
  private final List<Type> aiAz;
  private final Method aiBd;
  
  private i(Method paramMethod, List<? extends Type> paramList)
  {
    this.aiBd = paramMethod;
    this.aiAz = paramList;
    paramMethod = this.aiBd.getReturnType();
    s.s(paramMethod, "unboxMethod.returnType");
    this.aiAT = ((Type)paramMethod);
  }
  
  public final void aq(Object[] paramArrayOfObject)
  {
    s.u(paramArrayOfObject, "args");
    d.a.a(this, paramArrayOfObject);
  }
  
  protected final Object c(Object paramObject, Object[] paramArrayOfObject)
  {
    s.u(paramArrayOfObject, "args");
    return this.aiBd.invoke(paramObject, Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length));
  }
  
  public final List<Type> kmA()
  {
    return this.aiAz;
  }
  
  public final Type kmz()
  {
    return this.aiAT;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "unboxMethod", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class a
    extends i
    implements c
  {
    private final Object aiAW;
    
    public a(Method paramMethod, Object paramObject)
    {
      super((List)ab.aivy, (byte)0);
      AppMethodBeat.i(56641);
      this.aiAW = paramObject;
      AppMethodBeat.o(56641);
    }
    
    public final Object ap(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56640);
      s.u(paramArrayOfObject, "args");
      aq(paramArrayOfObject);
      paramArrayOfObject = c(this.aiAW, paramArrayOfObject);
      AppMethodBeat.o(56640);
      return paramArrayOfObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "unboxMethod", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class b
    extends i
  {
    public b(Method paramMethod)
    {
      super(p.listOf(paramMethod.getDeclaringClass()), (byte)0);
      AppMethodBeat.i(56643);
      AppMethodBeat.o(56643);
    }
    
    public final Object ap(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56642);
      s.u(paramArrayOfObject, "args");
      aq(paramArrayOfObject);
      Object localObject2 = paramArrayOfObject[0];
      Object localObject1 = e.aiAV;
      if (paramArrayOfObject.length <= 1) {
        paramArrayOfObject = new Object[0];
      }
      do
      {
        paramArrayOfObject = c(localObject2, paramArrayOfObject);
        AppMethodBeat.o(56642);
        return paramArrayOfObject;
        localObject1 = k.e(paramArrayOfObject, 1, paramArrayOfObject.length);
        paramArrayOfObject = (Object[])localObject1;
      } while (localObject1 != null);
      paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(56642);
      throw paramArrayOfObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.a.i
 * JD-Core Version:    0.7.0.1
 */