package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.f;
import kotlin.l.b.a.b.k.a.w;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.d;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isInner", "isOpen", "isSealed", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflection", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflection"})
public final class g<T>
  extends i
  implements kotlin.l.b<T>
{
  final Class<T> SYp;
  public final y.b<g<T>.a> SZV;
  
  public g(Class<T> paramClass)
  {
    AppMethodBeat.i(56351);
    this.SYp = paramClass;
    paramClass = y.aj((kotlin.g.a.a)new b(this));
    p.g(paramClass, "ReflectProperties.lazy { Data() }");
    this.SZV = paramClass;
    AppMethodBeat.o(56351);
  }
  
  private kotlin.l.b.a.b.b.e hyx()
  {
    AppMethodBeat.i(56339);
    kotlin.l.b.a.b.b.e locale = ((a)this.SZV.invoke()).hyx();
    AppMethodBeat.o(56339);
    return locale;
  }
  
  private final kotlin.l.b.a.b.f.a hyy()
  {
    AppMethodBeat.i(56340);
    Object localObject1 = ac.TbJ;
    localObject1 = this.SYp;
    p.h(localObject1, "klass");
    if (((Class)localObject1).isArray())
    {
      localObject1 = ((Class)localObject1).getComponentType();
      p.g(localObject1, "klass.componentType");
      localObject1 = ac.bt((Class)localObject1);
      if (localObject1 != null)
      {
        localObject1 = new kotlin.l.b.a.b.f.a(kotlin.l.b.a.b.a.g.TcD, ((kotlin.l.b.a.b.a.h)localObject1).hzu());
        AppMethodBeat.o(56340);
        return localObject1;
      }
      localObject1 = kotlin.l.b.a.b.f.a.p(kotlin.l.b.a.b.a.g.TcO.TcZ.hJj());
      p.g(localObject1, "ClassId.topLevel(KotlinB….FQ_NAMES.array.toSafe())");
      AppMethodBeat.o(56340);
      return localObject1;
    }
    if (p.j(localObject1, Void.TYPE))
    {
      localObject1 = ac.TbI;
      AppMethodBeat.o(56340);
      return localObject1;
    }
    Object localObject2 = ac.bt((Class)localObject1);
    if (localObject2 != null)
    {
      localObject1 = new kotlin.l.b.a.b.f.a(kotlin.l.b.a.b.a.g.TcD, ((kotlin.l.b.a.b.a.h)localObject2).hzt());
      AppMethodBeat.o(56340);
      return localObject1;
    }
    localObject1 = kotlin.l.b.a.b.b.d.b.b.bB((Class)localObject1);
    if (!((kotlin.l.b.a.b.f.a)localObject1).BPb)
    {
      localObject2 = kotlin.l.b.a.b.a.b.c.TfZ;
      localObject2 = ((kotlin.l.b.a.b.f.a)localObject1).hJd();
      p.g(localObject2, "classId.asSingleFqName()");
      localObject2 = kotlin.l.b.a.b.a.b.c.c((kotlin.l.b.a.b.f.b)localObject2);
      if (localObject2 != null)
      {
        AppMethodBeat.o(56340);
        return localObject2;
      }
    }
    AppMethodBeat.o(56340);
    return localObject1;
  }
  
  public final Collection<ah> a(kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(56344);
    p.h(paramf, "name");
    paramf = (Collection)j.b(hyz().a(paramf, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.TnJ), (Iterable)hyA().a(paramf, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.TnJ));
    AppMethodBeat.o(56344);
    return paramf;
  }
  
  public final ah atL(int paramInt)
  {
    AppMethodBeat.i(56346);
    for (Object localObject1 = this; p.j(((g)localObject1).SYp.getSimpleName(), "DefaultImpls"); localObject1 = (g)localObject1)
    {
      localObject2 = ((g)localObject1).SYp.getDeclaringClass();
      if ((localObject2 == null) || (!((Class)localObject2).isInterface())) {
        break;
      }
      localObject1 = kotlin.g.a.bo((Class)localObject2);
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        AppMethodBeat.o(56346);
        throw ((Throwable)localObject1);
      }
    }
    Object localObject3 = ((g)localObject1).hyx();
    Object localObject2 = localObject3;
    if (!(localObject3 instanceof kotlin.l.b.a.b.k.a.b.e)) {
      localObject2 = null;
    }
    localObject3 = (kotlin.l.b.a.b.k.a.b.e)localObject2;
    if (localObject3 != null)
    {
      localObject2 = (i.c)((kotlin.l.b.a.b.k.a.b.e)localObject3).TKA;
      i.f localf = kotlin.l.b.a.b.e.c.a.TBS;
      p.g(localf, "JvmProtoBuf.classLocalVariable");
      p.h(localObject2, "$this$getExtensionOrNull");
      p.h(localf, "extension");
      if (paramInt < ((i.c)localObject2).d(localf)) {}
      for (localObject2 = ((i.c)localObject2).a(localf, paramInt);; localObject2 = null)
      {
        localObject2 = (a.m)localObject2;
        if (localObject2 == null) {
          break;
        }
        localObject1 = (ah)ae.a(((g)localObject1).SYp, (kotlin.l.b.a.b.h.q)localObject2, ((kotlin.l.b.a.b.k.a.b.e)localObject3).TLm.SZH, ((kotlin.l.b.a.b.k.a.b.e)localObject3).TLm.SZI, ((kotlin.l.b.a.b.k.a.b.e)localObject3).TKB, (m)c.Tat);
        AppMethodBeat.o(56346);
        return localObject1;
      }
      AppMethodBeat.o(56346);
      return null;
    }
    AppMethodBeat.o(56346);
    return null;
  }
  
  public final Collection<kotlin.l.b.a.b.b.t> b(kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(56345);
    p.h(paramf, "name");
    paramf = (Collection)j.b(hyz().b(paramf, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.TnJ), (Iterable)hyA().b(paramf, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.TnJ));
    AppMethodBeat.o(56345);
    return paramf;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56348);
    if (((paramObject instanceof g)) && (p.j(kotlin.g.a.c(this), kotlin.g.a.c((kotlin.l.b)paramObject))))
    {
      AppMethodBeat.o(56348);
      return true;
    }
    AppMethodBeat.o(56348);
    return false;
  }
  
  public final String getSimpleName()
  {
    AppMethodBeat.i(186229);
    String str = (String)((a)this.SZV.invoke()).SZY.invoke();
    AppMethodBeat.o(186229);
    return str;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56349);
    int i = kotlin.g.a.c(this).hashCode();
    AppMethodBeat.o(56349);
    return i;
  }
  
  public final Class<T> hxU()
  {
    return this.SYp;
  }
  
  public final String hxV()
  {
    AppMethodBeat.i(56347);
    String str = (String)((a)this.SZV.invoke()).SZZ.invoke();
    AppMethodBeat.o(56347);
    return str;
  }
  
  public final Collection<kotlin.l.e<T>> hxW()
  {
    AppMethodBeat.i(186230);
    Collection localCollection = (Collection)((a)this.SZV.invoke()).Taa.invoke();
    AppMethodBeat.o(186230);
    return localCollection;
  }
  
  public final kotlin.l.b.a.b.j.f.h hyA()
  {
    AppMethodBeat.i(56342);
    kotlin.l.b.a.b.j.f.h localh = hyx().hzy();
    p.g(localh, "descriptor.staticScope");
    AppMethodBeat.o(56342);
    return localh;
  }
  
  public final Collection<kotlin.l.b.a.b.b.k> hyq()
  {
    AppMethodBeat.i(56343);
    Object localObject = hyx();
    if ((((kotlin.l.b.a.b.b.e)localObject).hzB() == kotlin.l.b.a.b.b.f.Thf) || (((kotlin.l.b.a.b.b.e)localObject).hzB() == kotlin.l.b.a.b.b.f.Thj))
    {
      localObject = (Collection)kotlin.a.v.SXr;
      AppMethodBeat.o(56343);
      return localObject;
    }
    localObject = ((kotlin.l.b.a.b.b.e)localObject).hxW();
    p.g(localObject, "descriptor.constructors");
    AppMethodBeat.o(56343);
    return localObject;
  }
  
  public final kotlin.l.b.a.b.j.f.h hyz()
  {
    AppMethodBeat.i(56341);
    kotlin.l.b.a.b.j.f.h localh = hyx().hAG().hAp();
    AppMethodBeat.o(56341);
    return localh;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56350);
    StringBuilder localStringBuilder = new StringBuilder("class ");
    Object localObject2 = hyy();
    Object localObject1 = ((kotlin.l.b.a.b.f.a)localObject2).hIY();
    p.g(localObject1, "classId.packageFqName");
    if (((kotlin.l.b.a.b.f.b)localObject1).TCR.TCW.isEmpty()) {}
    for (localObject1 = "";; localObject1 = ((kotlin.l.b.a.b.f.b)localObject1).sG() + ".")
    {
      localObject2 = ((kotlin.l.b.a.b.f.a)localObject2).hIZ().sG();
      p.g(localObject2, "classId.relativeClassName.asString()");
      localObject2 = kotlin.n.n.a((String)localObject2, '.', '$');
      localObject1 = new StringBuilder().append((String)localObject1).append((String)localObject2).toString();
      AppMethodBeat.o(56350);
      return localObject1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "constructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "objectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflection"})
  public final class a
    extends i.b
  {
    private final y.a SZW;
    private final y.a SZX;
    final y.a SZY;
    final y.a SZZ;
    final y.a Taa;
    private final y.a Tab;
    private final y.b Tac;
    private final y.a Tad;
    private final y.a Tae;
    private final y.a Taf;
    private final y.a Tag;
    private final y.a Tah;
    private final y.a Tai;
    private final y.a Taj;
    final y.a Tak;
    final y.a Tal;
    private final y.a Tam;
    private final y.a Tan;
    
    static
    {
      AppMethodBeat.i(56326);
      cLI = new kotlin.l.k[] { (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(a.class), "annotations", "getAnnotations()Ljava/util/List;")), (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), (kotlin.l.k)aa.a(new kotlin.g.b.y(aa.bp(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;")) };
      AppMethodBeat.o(56326);
    }
    
    public a()
    {
      super();
      AppMethodBeat.i(56329);
      this.SZW = y.ak((kotlin.g.a.a)new i(this));
      this.SZX = y.ak((kotlin.g.a.a)new d(this));
      this.SZY = y.ak((kotlin.g.a.a)new p(this));
      this.SZZ = y.ak((kotlin.g.a.a)new n(this));
      this.Taa = y.ak((kotlin.g.a.a)new e(this));
      this.Tab = y.ak((kotlin.g.a.a)new l(this));
      this.Tac = y.aj((kotlin.g.a.a)new m(this));
      this.Tad = y.ak((kotlin.g.a.a)new r(this));
      this.Tae = y.ak((kotlin.g.a.a)new q(this));
      this.Taf = y.ak((kotlin.g.a.a)new o(this));
      this.Tag = y.ak((kotlin.g.a.a)new g(this));
      this.Tah = y.ak((kotlin.g.a.a)new h(this));
      this.Tai = y.ak((kotlin.g.a.a)new j(this));
      this.Taj = y.ak((kotlin.g.a.a)new k(this));
      this.Tak = y.ak((kotlin.g.a.a)new b(this));
      this.Tal = y.ak((kotlin.g.a.a)new c(this));
      this.Tam = y.ak((kotlin.g.a.a)new f(this));
      this.Tan = y.ak((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(56329);
    }
    
    public final Collection<e<?>> hyB()
    {
      AppMethodBeat.i(56328);
      Collection localCollection = (Collection)this.Tag.invoke();
      AppMethodBeat.o(56328);
      return localCollection;
    }
    
    public final kotlin.l.b.a.b.b.e hyx()
    {
      AppMethodBeat.i(56327);
      kotlin.l.b.a.b.b.e locale = (kotlin.l.b.a.b.b.e)this.SZW.invoke();
      AppMethodBeat.o(56327);
      return locale;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<List<? extends e<?>>>
    {
      a(g.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<List<? extends e<?>>>
    {
      b(g.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<List<? extends e<?>>>
    {
      c(g.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "T", "", "invoke"})
    static final class d
      extends kotlin.g.b.q
      implements kotlin.g.a.a<List<? extends Annotation>>
    {
      d(g.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlin/reflect/KFunction;", "T", "", "invoke"})
    static final class e
      extends kotlin.g.b.q
      implements kotlin.g.a.a<List<? extends kotlin.l.e<? extends T>>>
    {
      e(g.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class f
      extends kotlin.g.b.q
      implements kotlin.g.a.a<List<? extends e<?>>>
    {
      f(g.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class g
      extends kotlin.g.b.q
      implements kotlin.g.a.a<Collection<? extends e<?>>>
    {
      g(g.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class h
      extends kotlin.g.b.q
      implements kotlin.g.a.a<Collection<? extends e<?>>>
    {
      h(g.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "T", "", "invoke"})
    static final class i
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.l.b.a.b.b.e>
    {
      i(g.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class j
      extends kotlin.g.b.q
      implements kotlin.g.a.a<Collection<? extends e<?>>>
    {
      j(g.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class k
      extends kotlin.g.b.q
      implements kotlin.g.a.a<Collection<? extends e<?>>>
    {
      k(g.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "", "kotlin.jvm.PlatformType", "T", "invoke"})
    static final class l
      extends kotlin.g.b.q
      implements kotlin.g.a.a<List<? extends g<? extends Object>>>
    {
      l(g.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"})
    static final class m
      extends kotlin.g.b.q
      implements kotlin.g.a.a<T>
    {
      m(g.a parama)
      {
        super();
      }
      
      public final T invoke()
      {
        AppMethodBeat.i(56318);
        Object localObject = this.Tap.hyx();
        if (((kotlin.l.b.a.b.b.e)localObject).hzB() != kotlin.l.b.a.b.b.f.Thj)
        {
          AppMethodBeat.o(56318);
          return null;
        }
        if (((kotlin.l.b.a.b.b.e)localObject).hzF())
        {
          kotlin.l.b.a.b.a.c localc = kotlin.l.b.a.b.a.c.Tcz;
          if (kotlin.l.b.a.b.a.c.b((kotlin.l.b.a.b.b.e)localObject)) {}
        }
        for (localObject = this.Tap.Tao.SYp.getEnclosingClass().getDeclaredField(((kotlin.l.b.a.b.b.e)localObject).hAH().sG());; localObject = this.Tap.Tao.SYp.getDeclaredField("INSTANCE"))
        {
          localObject = ((Field)localObject).get(null);
          if (localObject != null) {
            break;
          }
          localObject = new kotlin.t("null cannot be cast to non-null type T");
          AppMethodBeat.o(56318);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(56318);
        return localObject;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "", "invoke"})
    static final class n
      extends kotlin.g.b.q
      implements kotlin.g.a.a<String>
    {
      n(g.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"})
    static final class o
      extends kotlin.g.b.q
      implements kotlin.g.a.a<List<? extends g<? extends T>>>
    {
      o(g.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "", "invoke"})
    static final class p
      extends kotlin.g.b.q
      implements kotlin.g.a.a<String>
    {
      p(g.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "T", "", "invoke"})
    static final class q
      extends kotlin.g.b.q
      implements kotlin.g.a.a<List<? extends t>>
    {
      q(g.a parama)
      {
        super();
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/lang/reflect/Type;", "T", "", "invoke", "kotlin/reflect/jvm/internal/KClassImpl$Data$supertypes$2$1$1"})
      static final class a
        extends kotlin.g.b.q
        implements kotlin.g.a.a<Type>
      {
        a(ab paramab, g.a.q paramq)
        {
          super();
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "T", "", "invoke"})
    static final class r
      extends kotlin.g.b.q
      implements kotlin.g.a.a<List<? extends v>>
    {
      r(g.a parama)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<g<T>.a>
  {
    b(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.g
 * JD-Core Version:    0.7.0.1
 */