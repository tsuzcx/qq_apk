package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.b.a.b.e.c.a.e.b;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "()V", "asString", "", "FakeJavaAnnotationConstructor", "JavaConstructor", "JavaMethod", "KotlinConstructor", "KotlinFunction", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "kotlin-reflection"})
public abstract class c
{
  public abstract String sG();
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "methods", "", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "getMethods", "()Ljava/util/List;", "asString", "", "kotlin-reflection"})
  public static final class a
    extends c
  {
    private final Class<?> SYp;
    final List<Method> SZw;
    
    public a(Class<?> paramClass)
    {
      super();
      AppMethodBeat.i(56282);
      this.SYp = paramClass;
      paramClass = this.SYp.getDeclaredMethods();
      p.g(paramClass, "jClass.declaredMethods");
      this.SZw = e.b(paramClass, (Comparator)new c.a.a());
      AppMethodBeat.o(56282);
    }
    
    public final String sG()
    {
      AppMethodBeat.i(56281);
      String str = j.a((Iterable)this.SZw, (CharSequence)"", (CharSequence)"<init>(", (CharSequence)")V", 0, null, (b)b.SZx, 24);
      AppMethodBeat.o(56281);
      return str;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends q
      implements b<Method, String>
    {
      public static final b SZx;
      
      static
      {
        AppMethodBeat.i(56280);
        SZx = new b();
        AppMethodBeat.o(56280);
      }
      
      b()
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "constructor", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getConstructor", "()Ljava/lang/reflect/Constructor;", "asString", "", "kotlin-reflection"})
  public static final class b
    extends c
  {
    final Constructor<?> SZy;
    
    public b(Constructor<?> paramConstructor)
    {
      super();
      AppMethodBeat.i(56286);
      this.SZy = paramConstructor;
      AppMethodBeat.o(56286);
    }
    
    public final String sG()
    {
      AppMethodBeat.i(56285);
      Object localObject = this.SZy.getParameterTypes();
      p.g(localObject, "constructor.parameterTypes");
      localObject = e.a((Object[])localObject, (CharSequence)"", (CharSequence)"<init>(", (CharSequence)")V", 0, null, (b)a.SZz, 24);
      AppMethodBeat.o(56285);
      return localObject;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends q
      implements b<Class<?>, String>
    {
      public static final a SZz;
      
      static
      {
        AppMethodBeat.i(56284);
        SZz = new a();
        AppMethodBeat.o(56284);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "getMethod", "()Ljava/lang/reflect/Method;", "asString", "", "kotlin-reflection"})
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
    
    public final String sG()
    {
      AppMethodBeat.i(56287);
      String str = ad.c(this.method);
      AppMethodBeat.o(56287);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "constructorDesc", "getConstructorDesc", "()Ljava/lang/String;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"})
  public static final class d
    extends c
  {
    private final String SZA;
    final e.b SZB;
    
    public d(e.b paramb)
    {
      super();
      AppMethodBeat.i(56289);
      this.SZB = paramb;
      this.SZA = this.SZB.sG();
      AppMethodBeat.o(56289);
    }
    
    public final String sG()
    {
      return this.SZA;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "methodDesc", "getMethodDesc", "()Ljava/lang/String;", "methodName", "getMethodName", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"})
  public static final class e
    extends c
  {
    final String SZA;
    final e.b SZB;
    
    public e(e.b paramb)
    {
      super();
      AppMethodBeat.i(56290);
      this.SZB = paramb;
      this.SZA = this.SZB.sG();
      AppMethodBeat.o(56290);
    }
    
    public final String sG()
    {
      return this.SZA;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.c
 * JD-Core Version:    0.7.0.1
 */