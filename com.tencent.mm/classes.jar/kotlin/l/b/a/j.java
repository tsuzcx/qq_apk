package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.e.a.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.j.g.k.a;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", "", "result", "", "desc", "", "isConstructor", "", "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "signature", "findMethodBySignature", "findPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "index", "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", "", "loadReturnType", "parseType", "begin", "end", "lookupMethod", "parameterTypes", "", "returnType", "isStaticDefault", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetConstructor", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public abstract class j
  implements kotlin.g.b.h
{
  private static final Class<?> aiyX = Class.forName("kotlin.g.b.k");
  static final kotlin.n.k aiyY = new kotlin.n.k("<v#(\\d+)>");
  public static final j.a aiyZ = new j.a((byte)0);
  
  private static Method a(Class<?> paramClass1, String paramString, Class<?>[] paramArrayOfClass, Class<?> paramClass2)
  {
    try
    {
      Object localObject = paramClass1.getDeclaredMethod(paramString, (Class[])Arrays.copyOf(paramArrayOfClass, paramArrayOfClass.length));
      kotlin.g.b.s.s(localObject, "result");
      if (kotlin.g.b.s.p(((Method)localObject).getReturnType(), paramClass2)) {
        return localObject;
      }
      localObject = paramClass1.getDeclaredMethods();
      kotlin.g.b.s.s(localObject, "declaredMethods");
      int k = localObject.length;
      int i = 0;
      if (i < k)
      {
        paramClass1 = localObject[i];
        kotlin.g.b.s.s(paramClass1, "method");
        if ((kotlin.g.b.s.p(paramClass1.getName(), paramString)) && (kotlin.g.b.s.p(paramClass1.getReturnType(), paramClass2)))
        {
          Class[] arrayOfClass = paramClass1.getParameterTypes();
          kotlin.g.b.s.checkNotNull(arrayOfClass);
          boolean bool = Arrays.equals(arrayOfClass, paramArrayOfClass);
          if (!bool) {}
        }
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            return paramClass1;
          }
          i += 1;
          break;
        }
      }
      return null;
    }
    catch (NoSuchMethodException paramClass1)
    {
      paramClass1 = null;
    }
    return paramClass1;
  }
  
  private final Method a(Class<?> paramClass1, String paramString, Class<?>[] paramArrayOfClass, Class<?> paramClass2, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramArrayOfClass[0] = paramClass1;
    }
    Object localObject1 = a(paramClass1, paramString, paramArrayOfClass, paramClass2);
    if (localObject1 != null) {}
    do
    {
      return localObject1;
      localObject1 = paramClass1.getSuperclass();
      if (localObject1 == null) {
        break;
      }
      localObject2 = a((Class)localObject1, paramString, paramArrayOfClass, paramClass2, paramBoolean);
      localObject1 = localObject2;
    } while (localObject2 != null);
    Object localObject2 = paramClass1.getInterfaces();
    int j = localObject2.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label187;
      }
      Object localObject3 = localObject2[i];
      kotlin.g.b.s.s(localObject3, "superInterface");
      paramClass1 = a(localObject3, paramString, paramArrayOfClass, paramClass2, paramBoolean);
      localObject1 = paramClass1;
      if (paramClass1 != null) {
        break;
      }
      if (paramBoolean)
      {
        paramClass1 = e.e(kotlin.l.b.a.b.b.e.b.b.cI(localObject3), localObject3.getName() + "$DefaultImpls");
        if (paramClass1 != null)
        {
          paramArrayOfClass[0] = localObject3;
          paramClass1 = a(paramClass1, paramString, paramArrayOfClass, paramClass2);
          localObject1 = paramClass1;
          if (paramClass1 != null) {
            break;
          }
        }
      }
      i += 1;
    }
    label187:
    return null;
  }
  
  private final List<Class<?>> bIA(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    if (paramString.charAt(i) != ')')
    {
      int j = i;
      while (paramString.charAt(j) == '[') {
        j += 1;
      }
      char c = paramString.charAt(j);
      if (kotlin.n.n.d((CharSequence)"VZCBSIFJD", c)) {
        j += 1;
      }
      for (;;)
      {
        localArrayList.add(bo(paramString, i, j));
        i = j;
        break;
        if (c != 'L') {
          break label114;
        }
        j = kotlin.n.n.a((CharSequence)paramString, ';', i, false, 4) + 1;
      }
      label114:
      throw ((Throwable)new aa("Unknown type prefix in the method signature: ".concat(String.valueOf(paramString))));
    }
    return (List)localArrayList;
  }
  
  private final Class<?> bIB(String paramString)
  {
    return bo(paramString, kotlin.n.n.a((CharSequence)paramString, ')', 0, false, 6) + 1, paramString.length());
  }
  
  private final Class<?> bo(String paramString, int paramInt1, int paramInt2)
  {
    switch (paramString.charAt(paramInt1))
    {
    case 'E': 
    case 'G': 
    case 'H': 
    case 'K': 
    case 'M': 
    case 'N': 
    case 'O': 
    case 'P': 
    case 'Q': 
    case 'R': 
    case 'T': 
    case 'U': 
    case 'W': 
    case 'X': 
    case 'Y': 
    default: 
      throw ((Throwable)new aa("Unknown type prefix in the method signature: ".concat(String.valueOf(paramString))));
    case 'L': 
      ClassLoader localClassLoader = kotlin.l.b.a.b.b.e.b.b.cI(kls());
      if (paramString == null) {
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
      }
      paramString = paramString.substring(paramInt1 + 1, paramInt2 - 1);
      kotlin.g.b.s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = localClassLoader.loadClass(kotlin.n.n.a(paramString, '/', '.'));
      kotlin.g.b.s.s(paramString, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
      return paramString;
    case '[': 
      return ai.cE(bo(paramString, paramInt1 + 1, paramInt2));
    case 'V': 
      paramString = Void.TYPE;
      kotlin.g.b.s.s(paramString, "Void.TYPE");
      return paramString;
    case 'Z': 
      return Boolean.TYPE;
    case 'C': 
      return Character.TYPE;
    case 'B': 
      return Byte.TYPE;
    case 'S': 
      return Short.TYPE;
    case 'I': 
      return Integer.TYPE;
    case 'F': 
      return Float.TYPE;
    case 'J': 
      return Long.TYPE;
    }
    return Double.TYPE;
  }
  
  static Constructor<?> c(Class<?> paramClass, List<? extends Class<?>> paramList)
  {
    try
    {
      paramList = ((Collection)paramList).toArray(new Class[0]);
      if (paramList == null) {
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      }
      paramList = (Class[])paramList;
      paramClass = paramClass.getDeclaredConstructor((Class[])Arrays.copyOf(paramList, paramList.length));
      return paramClass;
    }
    catch (NoSuchMethodException paramClass) {}
    return null;
  }
  
  public final Method S(String paramString1, String paramString2, boolean paramBoolean)
  {
    kotlin.g.b.s.u(paramString1, "name");
    kotlin.g.b.s.u(paramString2, "desc");
    if (kotlin.g.b.s.p(paramString1, "<init>")) {
      return null;
    }
    Object localObject = new ArrayList();
    if (paramBoolean) {
      ((ArrayList)localObject).add(kls());
    }
    e((List)localObject, paramString2, false);
    Class localClass = kmf();
    paramString1 = paramString1 + "$default";
    localObject = ((Collection)localObject).toArray(new Class[0]);
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    return a(localClass, paramString1, (Class[])localObject, bIB(paramString2), paramBoolean);
  }
  
  public abstract Collection<ap> a(kotlin.l.b.a.b.f.f paramf);
  
  protected final Collection<f<?>> a(kotlin.l.b.a.b.j.g.h paramh, c paramc)
  {
    kotlin.g.b.s.u(paramh, "scope");
    kotlin.g.b.s.u(paramc, "belonginess");
    g localg = new g(this, this);
    paramh = (Iterable)k.a.a((kotlin.l.b.a.b.j.g.k)paramh, null, null, 3);
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramh.iterator();
    label153:
    while (localIterator.hasNext())
    {
      paramh = (l)localIterator.next();
      if (((paramh instanceof kotlin.l.b.a.b.b.b)) && ((kotlin.g.b.s.p(((kotlin.l.b.a.b.b.b)paramh).knc(), kotlin.l.b.a.b.b.s.aiGJ) ^ true)) && (paramc.a((kotlin.l.b.a.b.b.b)paramh))) {}
      for (paramh = (f)paramh.a((kotlin.l.b.a.b.b.n)localg, ah.aiuX);; paramh = null)
      {
        if (paramh == null) {
          break label153;
        }
        localCollection.add(paramh);
        break;
      }
    }
    return (Collection)p.p((Iterable)localCollection);
  }
  
  public abstract ap aKt(int paramInt);
  
  public abstract Collection<x> b(kotlin.l.b.a.b.f.f paramf);
  
  public final Constructor<?> bIz(String paramString)
  {
    kotlin.g.b.s.u(paramString, "desc");
    return c(kls(), bIA(paramString));
  }
  
  final void e(List<Class<?>> paramList, String paramString, boolean paramBoolean)
  {
    paramString = bIA(paramString);
    paramList.addAll((Collection)paramString);
    int j = (paramString.size() + 32 - 1) / 32;
    int i = 0;
    while (i < j)
    {
      paramString = Integer.TYPE;
      kotlin.g.b.s.s(paramString, "Integer.TYPE");
      paramList.add(paramString);
      i += 1;
    }
    if (paramBoolean) {}
    for (paramString = aiyX;; paramString = Object.class)
    {
      kotlin.g.b.s.s(paramString, "if (isConstructor) DEFAU…RKER else Any::class.java");
      paramList.add(paramString);
      return;
    }
  }
  
  public abstract Collection<kotlin.l.b.a.b.b.k> klT();
  
  protected Class<?> kmf()
  {
    Class localClass2 = kotlin.l.b.a.b.b.e.b.b.cL(kls());
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = kls();
    }
    return localClass1;
  }
  
  public final Method rk(String paramString1, String paramString2)
  {
    kotlin.g.b.s.u(paramString1, "name");
    kotlin.g.b.s.u(paramString2, "desc");
    if (kotlin.g.b.s.p(paramString1, "<init>")) {
      paramString2 = null;
    }
    do
    {
      Object localObject;
      Class[] arrayOfClass;
      Class localClass;
      do
      {
        return paramString2;
        localObject = ((Collection)bIA(paramString2)).toArray(new Class[0]);
        if (localObject == null) {
          throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        arrayOfClass = (Class[])localObject;
        localClass = bIB(paramString2);
        localObject = a(kmf(), paramString1, arrayOfClass, localClass, false);
        paramString2 = (String)localObject;
      } while (localObject != null);
      if (!kmf().isInterface()) {
        break;
      }
      paramString1 = a(Object.class, paramString1, arrayOfClass, localClass, false);
      paramString2 = paramString1;
    } while (paramString1 != null);
    return null;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public abstract class b
  {
    private final ac.a aiza = ac.cp((kotlin.g.a.a)new a(this));
    
    public final kotlin.l.b.a.b.b.e.a.j kmh()
    {
      return (kotlin.l.b.a.b.b.e.a.j)this.aiza.invoke();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
    static final class a
      extends u
      implements kotlin.g.a.a<kotlin.l.b.a.b.b.e.a.j>
    {
      a(j.b paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  protected static enum c
  {
    static
    {
      AppMethodBeat.i(56355);
      c localc1 = new c("DECLARED", 0);
      aizd = localc1;
      c localc2 = new c("INHERITED", 1);
      aize = localc2;
      aizf = new c[] { localc1, localc2 };
      AppMethodBeat.o(56355);
    }
    
    private c() {}
    
    public final boolean a(kotlin.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(56356);
      kotlin.g.b.s.u(paramb, "member");
      paramb = paramb.koh();
      kotlin.g.b.s.s(paramb, "member.kind");
      boolean bool2 = paramb.koi();
      if ((c)this == aizd) {}
      for (boolean bool1 = true; bool2 == bool1; bool1 = false)
      {
        AppMethodBeat.o(56356);
        return true;
      }
      AppMethodBeat.o(56356);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "invoke"}, k=3, mv={1, 5, 1})
  static final class d
    extends u
    implements kotlin.g.a.b<x, CharSequence>
  {
    public static final d aizg;
    
    static
    {
      AppMethodBeat.i(56360);
      aizg = new d();
      AppMethodBeat.o(56360);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "invoke"}, k=3, mv={1, 5, 1})
  static final class e
    extends u
    implements kotlin.g.a.b<ap, CharSequence>
  {
    public static final e aizh;
    
    static
    {
      AppMethodBeat.i(56362);
      aizh = new e();
      AppMethodBeat.o(56362);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "first", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "kotlin.jvm.PlatformType", "second", "compare"}, k=3, mv={1, 5, 1})
  static final class f<T>
    implements Comparator
  {
    public static final f aizi;
    
    static
    {
      AppMethodBeat.i(56364);
      aizi = new f();
      AppMethodBeat.o(56364);
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/reflect/jvm/internal/KDeclarationContainerImpl$getMembers$visitor$1", "Lkotlin/reflect/jvm/internal/CreateKCallableVisitor;", "visitConstructorDescriptor", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "data", "", "(Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class g
    extends a
  {
    g(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.j
 * JD-Core Version:    0.7.0.1
 */