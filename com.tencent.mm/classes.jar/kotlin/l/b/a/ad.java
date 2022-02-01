package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflection"})
public final class ad
{
  static final String c(Method paramMethod)
  {
    AppMethodBeat.i(56553);
    StringBuilder localStringBuilder = new StringBuilder().append(paramMethod.getName());
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    p.g(arrayOfClass, "parameterTypes");
    localStringBuilder = localStringBuilder.append(e.a(arrayOfClass, (CharSequence)"", (CharSequence)"(", (CharSequence)")", 0, null, (kotlin.g.a.b)a.TbK, 24));
    paramMethod = paramMethod.getReturnType();
    p.g(paramMethod, "returnType");
    paramMethod = kotlin.l.b.a.b.b.d.b.b.bC(paramMethod);
    AppMethodBeat.o(56553);
    return paramMethod;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Class<?>, String>
  {
    public static final a TbK;
    
    static
    {
      AppMethodBeat.i(56552);
      TbK = new a();
      AppMethodBeat.o(56552);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.ad
 * JD-Core Version:    0.7.0.1
 */