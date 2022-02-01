package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.a.j;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.l.b.a.b.e.c.a.e.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "()V", "asString", "", "FakeJavaAnnotationConstructor", "JavaConstructor", "JavaMethod", "KotlinConstructor", "KotlinFunction", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "kotlin-reflection"})
public abstract class c
{
  public abstract String sD();
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "methods", "", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "getMethods", "()Ljava/util/List;", "asString", "", "kotlin-reflection"})
  public static final class a
    extends c
  {
    private final Class<?> MLE;
    final List<Method> MMJ;
    
    public a(Class<?> paramClass)
    {
      super();
      AppMethodBeat.i(56282);
      this.MLE = paramClass;
      paramClass = this.MLE.getDeclaredMethods();
      p.g(paramClass, "jClass.declaredMethods");
      this.MMJ = e.b(paramClass, (Comparator)new c.a.a());
      AppMethodBeat.o(56282);
    }
    
    public final String sD()
    {
      AppMethodBeat.i(56281);
      String str = j.a((Iterable)this.MMJ, (CharSequence)"", (CharSequence)"<init>(", (CharSequence)")V", 0, null, (b)b.MMK, 24);
      AppMethodBeat.o(56281);
      return str;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends q
      implements b<Method, String>
    {
      public static final b MMK;
      
      static
      {
        AppMethodBeat.i(56280);
        MMK = new b();
        AppMethodBeat.o(56280);
      }
      
      b()
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "constructor", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getConstructor", "()Ljava/lang/reflect/Constructor;", "asString", "", "kotlin-reflection"})
  public static final class b
    extends c
  {
    final Constructor<?> MML;
    
    public b(Constructor<?> paramConstructor)
    {
      super();
      AppMethodBeat.i(56286);
      this.MML = paramConstructor;
      AppMethodBeat.o(56286);
    }
    
    public final String sD()
    {
      AppMethodBeat.i(56285);
      Object localObject = this.MML.getParameterTypes();
      p.g(localObject, "constructor.parameterTypes");
      localObject = e.a((Object[])localObject, (CharSequence)"", (CharSequence)"<init>(", (CharSequence)")V", 0, null, (b)a.MMM, 24);
      AppMethodBeat.o(56285);
      return localObject;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends q
      implements b<Class<?>, String>
    {
      public static final a MMM;
      
      static
      {
        AppMethodBeat.i(56284);
        MMM = new a();
        AppMethodBeat.o(56284);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "getMethod", "()Ljava/lang/reflect/Method;", "asString", "", "kotlin-reflection"})
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
    
    public final String sD()
    {
      AppMethodBeat.i(56287);
      String str = ad.c(this.method);
      AppMethodBeat.o(56287);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "constructorDesc", "getConstructorDesc", "()Ljava/lang/String;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"})
  public static final class d
    extends c
  {
    private final String MMN;
    final e.b MMO;
    
    public d(e.b paramb)
    {
      super();
      AppMethodBeat.i(56289);
      this.MMO = paramb;
      this.MMN = this.MMO.sD();
      AppMethodBeat.o(56289);
    }
    
    public final String sD()
    {
      return this.MMN;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "methodDesc", "getMethodDesc", "()Ljava/lang/String;", "methodName", "getMethodName", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"})
  public static final class e
    extends c
  {
    final String MMN;
    final e.b MMO;
    
    public e(e.b paramb)
    {
      super();
      AppMethodBeat.i(56290);
      this.MMO = paramb;
      this.MMN = this.MMO.sD();
      AppMethodBeat.o(56290);
    }
    
    public final String sD()
    {
      return this.MMN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.c
 * JD-Core Version:    0.7.0.1
 */