package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.lang.reflect.Method;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflection"})
public final class ad
{
  static final String c(Method paramMethod)
  {
    AppMethodBeat.i(56553);
    StringBuilder localStringBuilder = new StringBuilder().append(paramMethod.getName());
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    p.g(arrayOfClass, "parameterTypes");
    localStringBuilder = localStringBuilder.append(e.a(arrayOfClass, (CharSequence)"", (CharSequence)"(", (CharSequence)")", 0, null, (d.g.a.b)a.Nmc, 24));
    paramMethod = paramMethod.getReturnType();
    p.g(paramMethod, "returnType");
    paramMethod = d.l.b.a.b.b.d.b.b.bC(paramMethod);
    AppMethodBeat.o(56553);
    return paramMethod;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<Class<?>, String>
  {
    public static final a Nmc;
    
    static
    {
      AppMethodBeat.i(56552);
      Nmc = new a();
      AppMethodBeat.o(56552);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.ad
 * JD-Core Version:    0.7.0.1
 */