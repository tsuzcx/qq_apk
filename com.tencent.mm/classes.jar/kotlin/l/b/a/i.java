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
import kotlin.g.a.a;
import kotlin.g.b.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.j.f.j.a;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", "", "result", "", "desc", "", "isConstructor", "", "createProperty", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "signature", "findMethodBySignature", "findPropertyDescriptor", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "index", "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", "", "loadReturnType", "parseType", "begin", "end", "lookupMethod", "parameterTypes", "", "returnType", "isStaticDefault", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetConstructor", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"})
public abstract class i
  implements g
{
  private static final Class<?> aaDo = Class.forName("kotlin.g.b.j");
  static final kotlin.n.k aaDp = new kotlin.n.k("<v#(\\d+)>");
  public static final i.a aaDq = new i.a((byte)0);
  
  static Constructor<?> a(Class<?> paramClass, List<? extends Class<?>> paramList)
  {
    try
    {
      paramList = ((Collection)paramList).toArray(new Class[0]);
      if (paramList == null) {
        throw new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
      }
      paramList = (Class[])paramList;
      paramClass = paramClass.getDeclaredConstructor((Class[])Arrays.copyOf(paramList, paramList.length));
      return paramClass;
    }
    catch (NoSuchMethodException paramClass) {}
    return null;
  }
  
  private static Method a(Class<?> paramClass1, String paramString, Class<?>[] paramArrayOfClass, Class<?> paramClass2)
  {
    try
    {
      Object localObject = paramClass1.getDeclaredMethod(paramString, (Class[])Arrays.copyOf(paramArrayOfClass, paramArrayOfClass.length));
      p.j(localObject, "result");
      if (p.h(((Method)localObject).getReturnType(), paramClass2)) {
        return localObject;
      }
      localObject = paramClass1.getDeclaredMethods();
      p.j(localObject, "declaredMethods");
      int k = localObject.length;
      int i = 0;
      if (i < k)
      {
        paramClass1 = localObject[i];
        p.j(paramClass1, "method");
        if ((p.h(paramClass1.getName(), paramString)) && (p.h(paramClass1.getReturnType(), paramClass2)))
        {
          Class[] arrayOfClass = paramClass1.getParameterTypes();
          if (arrayOfClass == null) {
            p.iCn();
          }
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
        break label195;
      }
      Object localObject3 = localObject2[i];
      p.j(localObject3, "superInterface");
      paramClass1 = a(localObject3, paramString, paramArrayOfClass, paramClass2, paramBoolean);
      localObject1 = paramClass1;
      if (paramClass1 != null) {
        break;
      }
      if (paramBoolean)
      {
        paramClass1 = localObject3.getClassLoader();
        p.j(paramClass1, "superInterface.classLoader");
        paramClass1 = kotlin.l.b.a.b.b.d.a.e.a(paramClass1, localObject3.getName() + "$DefaultImpls");
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
    label195:
    return null;
  }
  
  private final List<Class<?>> bGA(String paramString)
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
        localArrayList.add(bf(paramString, i, j));
        i = j;
        break;
        if (c != 'L') {
          break label115;
        }
        j = kotlin.n.n.a((CharSequence)paramString, ';', i, false, 4) + 1;
      }
      label115:
      throw ((Throwable)new w("Unknown type prefix in the method signature: ".concat(String.valueOf(paramString))));
    }
    return (List)localArrayList;
  }
  
  private final Class<?> bGB(String paramString)
  {
    return bf(paramString, kotlin.n.n.a((CharSequence)paramString, ')', 0, false, 6) + 1, paramString.length());
  }
  
  private final Class<?> bf(String paramString, int paramInt1, int paramInt2)
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
      throw ((Throwable)new w("Unknown type prefix in the method signature: ".concat(String.valueOf(paramString))));
    case 'L': 
      ClassLoader localClassLoader = kotlin.l.b.a.b.b.d.b.b.bW(iCd());
      if (paramString == null) {
        throw new kotlin.t("null cannot be cast to non-null type java.lang.String");
      }
      paramString = paramString.substring(paramInt1 + 1, paramInt2 - 1);
      p.j(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = localClassLoader.loadClass(kotlin.n.n.a(paramString, '/', '.'));
      p.j(paramString, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
      return paramString;
    case '[': 
      return kotlin.l.b.a.b.b.d.b.b.cc(bf(paramString, paramInt1 + 1, paramInt2));
    case 'V': 
      paramString = Void.TYPE;
      p.j(paramString, "Void.TYPE");
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
  
  private Class<?> iCN()
  {
    Class localClass2 = kotlin.l.b.a.b.b.d.b.b.bZ(iCd());
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = iCd();
    }
    return localClass1;
  }
  
  public final Method K(String paramString1, String paramString2, boolean paramBoolean)
  {
    p.k(paramString1, "name");
    p.k(paramString2, "desc");
    if (p.h(paramString1, "<init>")) {
      return null;
    }
    Object localObject = new ArrayList();
    if (paramBoolean) {
      ((ArrayList)localObject).add(iCd());
    }
    e((List)localObject, paramString2, false);
    Class localClass = iCN();
    paramString1 = paramString1 + "$default";
    localObject = ((Collection)localObject).toArray(new Class[0]);
    if (localObject == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
    }
    return a(localClass, paramString1, (Class[])localObject, bGB(paramString2), paramBoolean);
  }
  
  public abstract Collection<ah> a(f paramf);
  
  protected final Collection<e<?>> a(h paramh, c paramc)
  {
    p.k(paramh, "scope");
    p.k(paramc, "belonginess");
    g localg = new g(this);
    paramh = (Iterable)j.a.a(paramh, null, null, 3);
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramh.iterator();
    label149:
    while (localIterator.hasNext())
    {
      paramh = (kotlin.l.b.a.b.b.l)localIterator.next();
      if (((paramh instanceof kotlin.l.b.a.b.b.b)) && ((p.h(((kotlin.l.b.a.b.b.b)paramh).iDQ(), az.aaKR) ^ true)) && (paramc.a((kotlin.l.b.a.b.b.b)paramh))) {}
      for (paramh = (e)paramh.a((kotlin.l.b.a.b.b.n)localg, x.aazN);; paramh = null)
      {
        if (paramh == null) {
          break label149;
        }
        localCollection.add(paramh);
        break;
      }
    }
    return (Collection)kotlin.a.j.p((Iterable)localCollection);
  }
  
  public abstract ah aDF(int paramInt);
  
  public abstract Collection<kotlin.l.b.a.b.b.t> b(f paramf);
  
  public final Constructor<?> bGz(String paramString)
  {
    p.k(paramString, "desc");
    return a(iCd(), bGA(paramString));
  }
  
  final void e(List<Class<?>> paramList, String paramString, boolean paramBoolean)
  {
    paramString = bGA(paramString);
    paramList.addAll((Collection)paramString);
    int j = (paramString.size() + 32 - 1) / 32;
    int i = 0;
    while (i < j)
    {
      paramString = Integer.TYPE;
      p.j(paramString, "Integer.TYPE");
      paramList.add(paramString);
      i += 1;
    }
    if (paramBoolean) {}
    for (paramString = aaDo;; paramString = Object.class)
    {
      p.j(paramString, "if (isConstructor) DEFAU…RKER else Any::class.java");
      paramList.add(paramString);
      return;
    }
  }
  
  public abstract Collection<kotlin.l.b.a.b.b.k> iCB();
  
  public final Method pm(String paramString1, String paramString2)
  {
    p.k(paramString1, "name");
    p.k(paramString2, "desc");
    if (p.h(paramString1, "<init>")) {
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
        localObject = ((Collection)bGA(paramString2)).toArray(new Class[0]);
        if (localObject == null) {
          throw new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
        }
        arrayOfClass = (Class[])localObject;
        localClass = bGB(paramString2);
        localObject = a(iCN(), paramString1, arrayOfClass, localClass, false);
        paramString2 = (String)localObject;
      } while (localObject != null);
      if (!iCN().isInterface()) {
        break;
      }
      paramString1 = a(Object.class, paramString1, arrayOfClass, localClass, false);
      paramString2 = paramString1;
    } while (paramString1 != null);
    return null;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"})
  public abstract class b
  {
    final y.a aaDr = y.au((a)new a(this));
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "invoke"})
    static final class a
      extends q
      implements a<kotlin.l.b.a.b.b.d.a.j>
    {
      a(i.b paramb)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflection"})
  protected static enum c
  {
    static
    {
      AppMethodBeat.i(56355);
      c localc1 = new c("DECLARED", 0);
      aaDu = localc1;
      c localc2 = new c("INHERITED", 1);
      aaDv = localc2;
      aaDw = new c[] { localc1, localc2 };
      AppMethodBeat.o(56355);
    }
    
    private c() {}
    
    public final boolean a(kotlin.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(56356);
      p.k(paramb, "member");
      paramb = paramb.iEN();
      p.j(paramb, "member.kind");
      boolean bool2 = paramb.iEO();
      if ((c)this == aaDu) {}
      for (boolean bool1 = true; bool2 == bool1; bool1 = false)
      {
        AppMethodBeat.o(56356);
        return true;
      }
      AppMethodBeat.o(56356);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.t, String>
  {
    public static final d aaDx;
    
    static
    {
      AppMethodBeat.i(56360);
      aaDx = new d();
      AppMethodBeat.o(56360);
    }
    
    d()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<ah, String>
  {
    public static final e aaDy;
    
    static
    {
      AppMethodBeat.i(56362);
      aaDy = new e();
      AppMethodBeat.o(56362);
    }
    
    e()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "first", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "kotlin.jvm.PlatformType", "second", "compare"})
  static final class f<T>
    implements Comparator<ba>
  {
    public static final f aaDz;
    
    static
    {
      AppMethodBeat.i(56364);
      aaDz = new f();
      AppMethodBeat.o(56364);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/reflect/jvm/internal/KDeclarationContainerImpl$getMembers$visitor$1", "Lkotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorVisitorEmptyBodies;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "visitConstructorDescriptor", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "data", "(Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflection"})
  public static final class g
    extends kotlin.l.b.a.b.b.c.l<e<?>, x>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.i
 * JD-Core Version:    0.7.0.1
 */