package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.a.j;
import d.g.a.b;
import d.g.b.k;
import d.l.b.a.b.e.c.a.e.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;

@d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "()V", "asString", "", "FakeJavaAnnotationConstructor", "JavaConstructor", "JavaMethod", "KotlinConstructor", "KotlinFunction", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "kotlin-reflection"})
public abstract class c
{
  public abstract String qV();
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "methods", "", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "getMethods", "()Ljava/util/List;", "asString", "", "kotlin-reflection"})
  public static final class a
    extends c
  {
    private final Class<?> Jhj;
    final List<Method> Jij;
    
    public a(Class<?> paramClass)
    {
      super();
      AppMethodBeat.i(56282);
      this.Jhj = paramClass;
      paramClass = this.Jhj.getDeclaredMethods();
      k.g(paramClass, "jClass.declaredMethods");
      this.Jij = e.b(paramClass, (Comparator)new c.a.a());
      AppMethodBeat.o(56282);
    }
    
    public final String qV()
    {
      AppMethodBeat.i(56281);
      String str = j.a((Iterable)this.Jij, (CharSequence)"", (CharSequence)"<init>(", (CharSequence)")V", 0, null, (b)b.Jik, 24);
      AppMethodBeat.o(56281);
      return str;
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "it", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends d.g.b.l
      implements b<Method, String>
    {
      public static final b Jik;
      
      static
      {
        AppMethodBeat.i(56280);
        Jik = new b();
        AppMethodBeat.o(56280);
      }
      
      b()
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "constructor", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getConstructor", "()Ljava/lang/reflect/Constructor;", "asString", "", "kotlin-reflection"})
  public static final class b
    extends c
  {
    final Constructor<?> Jil;
    
    public b(Constructor<?> paramConstructor)
    {
      super();
      AppMethodBeat.i(56286);
      this.Jil = paramConstructor;
      AppMethodBeat.o(56286);
    }
    
    public final String qV()
    {
      AppMethodBeat.i(56285);
      Object localObject = this.Jil.getParameterTypes();
      k.g(localObject, "constructor.parameterTypes");
      localObject = e.a((Object[])localObject, (CharSequence)"", (CharSequence)"<init>(", (CharSequence)")V", 0, null, (b)a.Jim, 24);
      AppMethodBeat.o(56285);
      return localObject;
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends d.g.b.l
      implements b<Class<?>, String>
    {
      public static final a Jim;
      
      static
      {
        AppMethodBeat.i(56284);
        Jim = new a();
        AppMethodBeat.o(56284);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "getMethod", "()Ljava/lang/reflect/Method;", "asString", "", "kotlin-reflection"})
  public static final class c
    extends c
  {
    final Method method;
    
    public c(Method paramMethod)
    {
      super();
      AppMethodBeat.i(56288);
      this.method = paramMethod;
      AppMethodBeat.o(56288);
    }
    
    public final String qV()
    {
      AppMethodBeat.i(56287);
      String str = ae.c(this.method);
      AppMethodBeat.o(56287);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "constructorDesc", "getConstructorDesc", "()Ljava/lang/String;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"})
  public static final class d
    extends c
  {
    private final String Jin;
    final e.b Jio;
    
    public d(e.b paramb)
    {
      super();
      AppMethodBeat.i(56289);
      this.Jio = paramb;
      this.Jin = this.Jio.qV();
      AppMethodBeat.o(56289);
    }
    
    public final String qV()
    {
      return this.Jin;
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "methodDesc", "getMethodDesc", "()Ljava/lang/String;", "methodName", "getMethodName", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"})
  public static final class e
    extends c
  {
    final String Jin;
    final e.b Jio;
    
    public e(e.b paramb)
    {
      super();
      AppMethodBeat.i(56290);
      this.Jio = paramb;
      this.Jin = this.Jio.qV();
      AppMethodBeat.o(56290);
    }
    
    public final String qV()
    {
      return this.Jin;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.c
 * JD-Core Version:    0.7.0.1
 */