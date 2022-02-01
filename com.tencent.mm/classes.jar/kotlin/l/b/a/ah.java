package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflection"}, k=2, mv={1, 5, 1})
public final class ah
{
  static final String g(Method paramMethod)
  {
    AppMethodBeat.i(56553);
    StringBuilder localStringBuilder = new StringBuilder().append(paramMethod.getName());
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    s.s(arrayOfClass, "parameterTypes");
    localStringBuilder = localStringBuilder.append(k.a(arrayOfClass, (CharSequence)"", (CharSequence)"(", (CharSequence)")", 0, null, (kotlin.g.a.b)a.aiAw, 24));
    paramMethod = paramMethod.getReturnType();
    s.s(paramMethod, "returnType");
    paramMethod = kotlin.l.b.a.b.b.e.b.b.cN(paramMethod);
    AppMethodBeat.o(56553);
    return paramMethod;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
  static final class a
    extends u
    implements kotlin.g.a.b<Class<?>, CharSequence>
  {
    public static final a aiAw;
    
    static
    {
      AppMethodBeat.i(56552);
      aiAw = new a();
      AppMethodBeat.o(56552);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.ah
 * JD-Core Version:    0.7.0.1
 */