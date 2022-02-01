package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.a.j;
import d.b.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.l.b.a.b.e.c.a.e.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "()V", "asString", "", "FakeJavaAnnotationConstructor", "JavaConstructor", "JavaMethod", "KotlinConstructor", "KotlinFunction", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "kotlin-reflection"})
public abstract class c
{
  public abstract String sD();
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "methods", "", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "getMethods", "()Ljava/util/List;", "asString", "", "kotlin-reflection"})
  public static final class a
    extends c
  {
    private final Class<?> NiH;
    final List<Method> NjO;
    
    public a(Class<?> paramClass)
    {
      super();
      AppMethodBeat.i(56282);
      this.NiH = paramClass;
      paramClass = this.NiH.getDeclaredMethods();
      p.g(paramClass, "jClass.declaredMethods");
      this.NjO = e.b(paramClass, (Comparator)new a());
      AppMethodBeat.o(56282);
    }
    
    public final String sD()
    {
      AppMethodBeat.i(56281);
      String str = j.a((Iterable)this.NjO, (CharSequence)"", (CharSequence)"<init>(", (CharSequence)")V", 0, null, (b)b.NjP, 24);
      AppMethodBeat.o(56281);
      return str;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class a<T>
      implements Comparator<T>
    {
      public final int compare(T paramT1, T paramT2)
      {
        AppMethodBeat.i(56278);
        paramT1 = (Method)paramT1;
        p.g(paramT1, "it");
        paramT1 = (Comparable)paramT1.getName();
        paramT2 = (Method)paramT2;
        p.g(paramT2, "it");
        int i = a.a(paramT1, (Comparable)paramT2.getName());
        AppMethodBeat.o(56278);
        return i;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends q
      implements b<Method, String>
    {
      public static final b NjP;
      
      static
      {
        AppMethodBeat.i(56280);
        NjP = new b();
        AppMethodBeat.o(56280);
      }
      
      b()
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "constructor", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getConstructor", "()Ljava/lang/reflect/Constructor;", "asString", "", "kotlin-reflection"})
  public static final class b
    extends c
  {
    final Constructor<?> NjQ;
    
    public b(Constructor<?> paramConstructor)
    {
      super();
      AppMethodBeat.i(56286);
      this.NjQ = paramConstructor;
      AppMethodBeat.o(56286);
    }
    
    public final String sD()
    {
      AppMethodBeat.i(56285);
      Object localObject = this.NjQ.getParameterTypes();
      p.g(localObject, "constructor.parameterTypes");
      localObject = e.a((Object[])localObject, (CharSequence)"", (CharSequence)"<init>(", (CharSequence)")V", 0, null, (b)a.NjR, 24);
      AppMethodBeat.o(56285);
      return localObject;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends q
      implements b<Class<?>, String>
    {
      public static final a NjR;
      
      static
      {
        AppMethodBeat.i(56284);
        NjR = new a();
        AppMethodBeat.o(56284);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "getMethod", "()Ljava/lang/reflect/Method;", "asString", "", "kotlin-reflection"})
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "constructorDesc", "getConstructorDesc", "()Ljava/lang/String;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"})
  public static final class d
    extends c
  {
    private final String NjS;
    final e.b NjT;
    
    public d(e.b paramb)
    {
      super();
      AppMethodBeat.i(56289);
      this.NjT = paramb;
      this.NjS = this.NjT.sD();
      AppMethodBeat.o(56289);
    }
    
    public final String sD()
    {
      return this.NjS;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "methodDesc", "getMethodDesc", "()Ljava/lang/String;", "methodName", "getMethodName", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"})
  public static final class e
    extends c
  {
    final String NjS;
    final e.b NjT;
    
    public e(e.b paramb)
    {
      super();
      AppMethodBeat.i(56290);
      this.NjT = paramb;
      this.NjS = this.NjT.sD();
      AppMethodBeat.o(56290);
    }
    
    public final String sD()
    {
      return this.NjS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.c
 * JD-Core Version:    0.7.0.1
 */