package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.g.b.k;
import java.lang.reflect.Method;

@d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflection"})
public final class ae
{
  static final String c(Method paramMethod)
  {
    AppMethodBeat.i(56553);
    StringBuilder localStringBuilder = new StringBuilder().append(paramMethod.getName());
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    k.g(arrayOfClass, "parameterTypes");
    localStringBuilder = localStringBuilder.append(e.a(arrayOfClass, (CharSequence)"", (CharSequence)"(", (CharSequence)")", 0, null, (d.g.a.b)a.KYa, 24));
    paramMethod = paramMethod.getReturnType();
    k.g(paramMethod, "returnType");
    paramMethod = d.l.b.a.b.b.d.b.b.bA(paramMethod);
    AppMethodBeat.o(56553);
    return paramMethod;
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Class<?>, String>
  {
    public static final a KYa;
    
    static
    {
      AppMethodBeat.i(56552);
      KYa = new a();
      AppMethodBeat.o(56552);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.ae
 * JD-Core Version:    0.7.0.1
 */