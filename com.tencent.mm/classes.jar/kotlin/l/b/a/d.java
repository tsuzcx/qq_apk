package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "()V", "asString", "", "FakeJavaAnnotationConstructor", "JavaConstructor", "JavaMethod", "KotlinConstructor", "KotlinFunction", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public abstract class d
{
  public abstract String PF();
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "methods", "", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "getMethods", "()Ljava/util/List;", "asString", "", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class a
    extends d
  {
    private final Class<?> aiwN;
    final List<Method> aixZ;
    
    public a(Class<?> paramClass)
    {
      super();
      AppMethodBeat.i(56282);
      this.aiwN = paramClass;
      paramClass = this.aiwN.getDeclaredMethods();
      s.s(paramClass, "jClass.declaredMethods");
      this.aixZ = k.b(paramClass, (Comparator)new d.a.a());
      AppMethodBeat.o(56282);
    }
    
    public final String PF()
    {
      AppMethodBeat.i(56281);
      String str = p.a((Iterable)this.aixZ, (CharSequence)"", (CharSequence)"<init>(", (CharSequence)")V", 0, null, (b)b.aiya, 24);
      AppMethodBeat.o(56281);
      return str;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
    static final class b
      extends u
      implements b<Method, CharSequence>
    {
      public static final b aiya;
      
      static
      {
        AppMethodBeat.i(56280);
        aiya = new b();
        AppMethodBeat.o(56280);
      }
      
      b()
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "constructor", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getConstructor", "()Ljava/lang/reflect/Constructor;", "asString", "", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class b
    extends d
  {
    final Constructor<?> aiyb;
    
    public b(Constructor<?> paramConstructor)
    {
      super();
      AppMethodBeat.i(56286);
      this.aiyb = paramConstructor;
      AppMethodBeat.o(56286);
    }
    
    public final String PF()
    {
      AppMethodBeat.i(56285);
      Object localObject = this.aiyb.getParameterTypes();
      s.s(localObject, "constructor.parameterTypes");
      localObject = k.a((Object[])localObject, (CharSequence)"", (CharSequence)"<init>(", (CharSequence)")V", 0, null, (b)a.aiyc, 24);
      AppMethodBeat.o(56285);
      return localObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
    static final class a
      extends u
      implements b<Class<?>, CharSequence>
    {
      public static final a aiyc;
      
      static
      {
        AppMethodBeat.i(56284);
        aiyc = new a();
        AppMethodBeat.o(56284);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "getMethod", "()Ljava/lang/reflect/Method;", "asString", "", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class c
    extends d
  {
    final Method method;
    
    public c(Method paramMethod)
    {
      super();
      AppMethodBeat.i(56288);
      this.method = paramMethod;
      AppMethodBeat.o(56288);
    }
    
    public final String PF()
    {
      AppMethodBeat.i(56287);
      String str = ah.g(this.method);
      AppMethodBeat.o(56287);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "constructorDesc", "getConstructorDesc", "()Ljava/lang/String;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class d
    extends d
  {
    private final String aiyd;
    final kotlin.l.b.a.b.e.c.a.d.b aiye;
    
    public d(kotlin.l.b.a.b.e.c.a.d.b paramb)
    {
      super();
      AppMethodBeat.i(56289);
      this.aiye = paramb;
      this.aiyd = this.aiye.PF();
      AppMethodBeat.o(56289);
    }
    
    public final String PF()
    {
      return this.aiyd;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "methodDesc", "getMethodDesc", "()Ljava/lang/String;", "methodName", "getMethodName", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class e
    extends d
  {
    final String aiyd;
    final kotlin.l.b.a.b.e.c.a.d.b aiye;
    
    public e(kotlin.l.b.a.b.e.c.a.d.b paramb)
    {
      super();
      AppMethodBeat.i(56290);
      this.aiye = paramb;
      this.aiyd = this.aiye.PF();
      AppMethodBeat.o(56290);
    }
    
    public final String PF()
    {
      return this.aiyd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.d
 * JD-Core Version:    0.7.0.1
 */