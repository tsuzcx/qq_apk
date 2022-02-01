package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.d;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.t;
import d.l.b.a.b.f.f;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.j.f.j.a;
import d.v;
import d.y;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", "", "result", "", "desc", "", "isConstructor", "", "createProperty", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "signature", "findMethodBySignature", "findPropertyDescriptor", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "index", "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", "", "loadReturnType", "parseType", "begin", "end", "lookupMethod", "parameterTypes", "", "returnType", "isStaticDefault", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetConstructor", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"})
public abstract class i
  implements d
{
  private static final Class<?> Jjh = Class.forName("d.g.b.g");
  static final d.n.k Jji = new d.n.k("<v#(\\d+)>");
  public static final i.a Jjj = new i.a((byte)0);
  
  static Constructor<?> a(Class<?> paramClass, List<? extends Class<?>> paramList)
  {
    try
    {
      paramList = ((Collection)paramList).toArray(new Class[0]);
      if (paramList == null) {
        throw new v("null cannot be cast to non-null type kotlin.Array<T>");
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
      d.g.b.k.g(localObject, "result");
      if (d.g.b.k.g(((Method)localObject).getReturnType(), paramClass2)) {
        return localObject;
      }
      localObject = paramClass1.getDeclaredMethods();
      d.g.b.k.g(localObject, "declaredMethods");
      int k = localObject.length;
      int i = 0;
      if (i < k)
      {
        paramClass1 = localObject[i];
        d.g.b.k.g(paramClass1, "method");
        if ((d.g.b.k.g(paramClass1.getName(), paramString)) && (d.g.b.k.g(paramClass1.getReturnType(), paramClass2)))
        {
          Class[] arrayOfClass = paramClass1.getParameterTypes();
          if (arrayOfClass == null) {
            d.g.b.k.fvU();
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
        break label196;
      }
      Object localObject3 = localObject2[i];
      d.g.b.k.g(localObject3, "superInterface");
      paramClass1 = a(localObject3, paramString, paramArrayOfClass, paramClass2, paramBoolean);
      localObject1 = paramClass1;
      if (paramClass1 != null) {
        break;
      }
      if (paramBoolean)
      {
        paramClass1 = localObject3.getClassLoader();
        d.g.b.k.g(paramClass1, "superInterface.classLoader");
        paramClass1 = d.l.b.a.b.b.d.a.e.a(paramClass1, localObject3.getName() + "$DefaultImpls");
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
    label196:
    return null;
  }
  
  private final List<Class<?>> aQb(String paramString)
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
      if (d.n.n.d((CharSequence)"VZCBSIFJD", c)) {
        j += 1;
      }
      for (;;)
      {
        localArrayList.add(aY(paramString, i, j));
        i = j;
        break;
        if (c != 'L') {
          break label114;
        }
        j = d.n.n.a((CharSequence)paramString, ';', i, 4) + 1;
      }
      label114:
      throw ((Throwable)new x("Unknown type prefix in the method signature: ".concat(String.valueOf(paramString))));
    }
    return (List)localArrayList;
  }
  
  private final Class<?> aQc(String paramString)
  {
    return aY(paramString, d.n.n.a((CharSequence)paramString, ')', 0, 6) + 1, paramString.length());
  }
  
  private final Class<?> aY(String paramString, int paramInt1, int paramInt2)
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
      throw ((Throwable)new x("Unknown type prefix in the method signature: ".concat(String.valueOf(paramString))));
    case 'L': 
      ClassLoader localClassLoader = d.l.b.a.b.b.d.b.b.bs(fvP());
      if (paramString == null) {
        throw new v("null cannot be cast to non-null type java.lang.String");
      }
      paramString = paramString.substring(paramInt1 + 1, paramInt2 - 1);
      d.g.b.k.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = localClassLoader.loadClass(d.n.n.a(paramString, '/', '.'));
      d.g.b.k.g(paramString, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
      return paramString;
    case '[': 
      return d.l.b.a.b.b.d.b.b.by(aY(paramString, paramInt1 + 1, paramInt2));
    case 'V': 
      paramString = Void.TYPE;
      d.g.b.k.g(paramString, "Void.TYPE");
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
  
  public final Method H(String paramString1, String paramString2, boolean paramBoolean)
  {
    d.g.b.k.h(paramString1, "name");
    d.g.b.k.h(paramString2, "desc");
    if (d.g.b.k.g(paramString1, "<init>")) {
      return null;
    }
    Object localObject = new ArrayList();
    if (paramBoolean) {
      ((ArrayList)localObject).add(fvP());
    }
    c((List)localObject, paramString2, false);
    Class localClass = fwt();
    paramString1 = paramString1 + "$default";
    localObject = ((Collection)localObject).toArray(new Class[0]);
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.Array<T>");
    }
    return a(localClass, paramString1, (Class[])localObject, aQc(paramString2), paramBoolean);
  }
  
  public abstract Collection<ah> a(f paramf);
  
  protected final Collection<e<?>> a(h paramh, c paramc)
  {
    d.g.b.k.h(paramh, "scope");
    d.g.b.k.h(paramc, "belonginess");
    g localg = new g(this);
    paramh = (Iterable)j.a.a(paramh, null, null, 3);
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramh.iterator();
    label149:
    while (localIterator.hasNext())
    {
      paramh = (d.l.b.a.b.b.l)localIterator.next();
      if (((paramh instanceof d.l.b.a.b.b.b)) && ((d.g.b.k.g(((d.l.b.a.b.b.b)paramh).fxx(), az.JqW) ^ true)) && (paramc.a((d.l.b.a.b.b.b)paramh))) {}
      for (paramh = (e)paramh.a((d.l.b.a.b.b.n)localg, y.JfV);; paramh = null)
      {
        if (paramh == null) {
          break label149;
        }
        localCollection.add(paramh);
        break;
      }
    }
    return (Collection)d.a.j.m((Iterable)localCollection);
  }
  
  public final Constructor<?> aQa(String paramString)
  {
    d.g.b.k.h(paramString, "desc");
    return a(fvP(), aQb(paramString));
  }
  
  public abstract ah adO(int paramInt);
  
  public abstract Collection<t> b(f paramf);
  
  final void c(List<Class<?>> paramList, String paramString, boolean paramBoolean)
  {
    paramString = aQb(paramString);
    paramList.addAll((Collection)paramString);
    int j = (paramString.size() + 32 - 1) / 32;
    int i = 0;
    while (i < j)
    {
      paramString = Integer.TYPE;
      d.g.b.k.g(paramString, "Integer.TYPE");
      paramList.add(paramString);
      i += 1;
    }
    if (paramBoolean) {}
    for (paramString = Jjh;; paramString = Object.class)
    {
      d.g.b.k.g(paramString, "if (isConstructor) DEFAU…RKER else Any::class.java");
      paramList.add(paramString);
      return;
    }
  }
  
  public abstract Collection<d.l.b.a.b.b.k> fwh();
  
  protected Class<?> fwt()
  {
    Class localClass2 = d.l.b.a.b.b.d.b.b.bv(fvP());
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = fvP();
    }
    return localClass1;
  }
  
  public final Method mr(String paramString1, String paramString2)
  {
    d.g.b.k.h(paramString1, "name");
    d.g.b.k.h(paramString2, "desc");
    if (d.g.b.k.g(paramString1, "<init>")) {
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
        localObject = ((Collection)aQb(paramString2)).toArray(new Class[0]);
        if (localObject == null) {
          throw new v("null cannot be cast to non-null type kotlin.Array<T>");
        }
        arrayOfClass = (Class[])localObject;
        localClass = aQc(paramString2);
        localObject = a(fwt(), paramString1, arrayOfClass, localClass, false);
        paramString2 = (String)localObject;
      } while (localObject != null);
      if (!fwt().isInterface()) {
        break;
      }
      paramString1 = a(Object.class, paramString1, arrayOfClass, localClass, false);
      paramString2 = paramString1;
    } while (paramString1 != null);
    return null;
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"})
  public abstract class b
  {
    private final z.a Jjk = z.G((a)new a(this));
    
    public final d.l.b.a.b.b.d.a.j fwv()
    {
      return (d.l.b.a.b.b.d.a.j)this.Jjk.invoke();
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "invoke"})
    static final class a
      extends d.g.b.l
      implements a<d.l.b.a.b.b.d.a.j>
    {
      a(i.b paramb)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflection"})
  protected static enum c
  {
    static
    {
      AppMethodBeat.i(56355);
      c localc1 = new c("DECLARED", 0);
      Jjn = localc1;
      c localc2 = new c("INHERITED", 1);
      Jjo = localc2;
      Jjp = new c[] { localc1, localc2 };
      AppMethodBeat.o(56355);
    }
    
    private c() {}
    
    public final boolean a(d.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(56356);
      d.g.b.k.h(paramb, "member");
      paramb = paramb.fyu();
      d.g.b.k.g(paramb, "member.kind");
      boolean bool2 = paramb.fyv();
      if ((c)this == Jjn) {}
      for (boolean bool1 = true; bool2 == bool1; bool1 = false)
      {
        AppMethodBeat.o(56356);
        return true;
      }
      AppMethodBeat.o(56356);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<t, String>
  {
    public static final d Jjq;
    
    static
    {
      AppMethodBeat.i(56360);
      Jjq = new d();
      AppMethodBeat.o(56360);
    }
    
    d()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<ah, String>
  {
    public static final e Jjr;
    
    static
    {
      AppMethodBeat.i(56362);
      Jjr = new e();
      AppMethodBeat.o(56362);
    }
    
    e()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "first", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "kotlin.jvm.PlatformType", "second", "compare"})
  static final class f<T>
    implements Comparator<ba>
  {
    public static final f Jjs;
    
    static
    {
      AppMethodBeat.i(56364);
      Jjs = new f();
      AppMethodBeat.o(56364);
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"kotlin/reflect/jvm/internal/KDeclarationContainerImpl$getMembers$visitor$1", "Lkotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorVisitorEmptyBodies;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "visitConstructorDescriptor", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "data", "(Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflection"})
  public static final class g
    extends d.l.b.a.b.b.c.l<e<?>, y>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.i
 * JD-Core Version:    0.7.0.1
 */