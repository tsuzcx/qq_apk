package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.a.j;
import d.b.a;
import d.g.a.b;
import d.g.b.k;
import d.l.b.a.b.e.c.a.e.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;

@d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "()V", "asString", "", "FakeJavaAnnotationConstructor", "JavaConstructor", "JavaMethod", "KotlinConstructor", "KotlinFunction", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "kotlin-reflection"})
public abstract class c
{
  public abstract String rf();
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "methods", "", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "getMethods", "()Ljava/util/List;", "asString", "", "kotlin-reflection"})
  public static final class a
    extends c
  {
    private final Class<?> KUC;
    final List<Method> KVD;
    
    public a(Class<?> paramClass)
    {
      super();
      AppMethodBeat.i(56282);
      this.KUC = paramClass;
      paramClass = this.KUC.getDeclaredMethods();
      k.g(paramClass, "jClass.declaredMethods");
      this.KVD = e.b(paramClass, (Comparator)new a());
      AppMethodBeat.o(56282);
    }
    
    public final String rf()
    {
      AppMethodBeat.i(56281);
      String str = j.a((Iterable)this.KVD, (CharSequence)"", (CharSequence)"<init>(", (CharSequence)")V", 0, null, (b)b.KVE, 24);
      AppMethodBeat.o(56281);
      return str;
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class a<T>
      implements Comparator<T>
    {
      public final int compare(T paramT1, T paramT2)
      {
        AppMethodBeat.i(56278);
        paramT1 = (Method)paramT1;
        k.g(paramT1, "it");
        paramT1 = (Comparable)paramT1.getName();
        paramT2 = (Method)paramT2;
        k.g(paramT2, "it");
        int i = a.a(paramT1, (Comparable)paramT2.getName());
        AppMethodBeat.o(56278);
        return i;
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "it", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends d.g.b.l
      implements b<Method, String>
    {
      public static final b KVE;
      
      static
      {
        AppMethodBeat.i(56280);
        KVE = new b();
        AppMethodBeat.o(56280);
      }
      
      b()
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "constructor", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getConstructor", "()Ljava/lang/reflect/Constructor;", "asString", "", "kotlin-reflection"})
  public static final class b
    extends c
  {
    final Constructor<?> KVF;
    
    public b(Constructor<?> paramConstructor)
    {
      super();
      AppMethodBeat.i(56286);
      this.KVF = paramConstructor;
      AppMethodBeat.o(56286);
    }
    
    public final String rf()
    {
      AppMethodBeat.i(56285);
      Object localObject = this.KVF.getParameterTypes();
      k.g(localObject, "constructor.parameterTypes");
      localObject = e.a((Object[])localObject, (CharSequence)"", (CharSequence)"<init>(", (CharSequence)")V", 0, null, (b)a.KVG, 24);
      AppMethodBeat.o(56285);
      return localObject;
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends d.g.b.l
      implements b<Class<?>, String>
    {
      public static final a KVG;
      
      static
      {
        AppMethodBeat.i(56284);
        KVG = new a();
        AppMethodBeat.o(56284);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "getMethod", "()Ljava/lang/reflect/Method;", "asString", "", "kotlin-reflection"})
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
    
    public final String rf()
    {
      AppMethodBeat.i(56287);
      String str = ae.c(this.method);
      AppMethodBeat.o(56287);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "constructorDesc", "getConstructorDesc", "()Ljava/lang/String;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"})
  public static final class d
    extends c
  {
    private final String KVH;
    final e.b KVI;
    
    public d(e.b paramb)
    {
      super();
      AppMethodBeat.i(56289);
      this.KVI = paramb;
      this.KVH = this.KVI.rf();
      AppMethodBeat.o(56289);
    }
    
    public final String rf()
    {
      return this.KVH;
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "methodDesc", "getMethodDesc", "()Ljava/lang/String;", "methodName", "getMethodName", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"})
  public static final class e
    extends c
  {
    final String KVH;
    final e.b KVI;
    
    public e(e.b paramb)
    {
      super();
      AppMethodBeat.i(56290);
      this.KVI = paramb;
      this.KVH = this.KVI.rf();
      AppMethodBeat.o(56290);
    }
    
    public final String rf()
    {
      return this.KVH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.c
 * JD-Core Version:    0.7.0.1
 */