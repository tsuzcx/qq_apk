package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.t;
import d.l.b.a.b.e.a.m;
import d.l.b.a.b.h.i.c;
import d.l.b.a.b.h.i.f;
import d.l.b.a.b.h.q;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.aj;
import d.l.d;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

@d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isInner", "isOpen", "isSealed", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflection", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflection"})
public final class g<T>
  extends i
  implements d.l.b<T>
{
  final Class<T> KUC;
  final z.b<g<T>.a> KWc;
  
  public g(Class<T> paramClass)
  {
    AppMethodBeat.i(56351);
    this.KUC = paramClass;
    paramClass = z.M((d.g.a.a)new b(this));
    d.g.b.k.g(paramClass, "ReflectProperties.lazy { Data() }");
    this.KWc = paramClass;
    AppMethodBeat.o(56351);
  }
  
  private d.l.b.a.b.b.e fOS()
  {
    AppMethodBeat.i(56339);
    d.l.b.a.b.b.e locale = ((a)this.KWc.invoke()).fOS();
    AppMethodBeat.o(56339);
    return locale;
  }
  
  private final d.l.b.a.b.f.a fOT()
  {
    AppMethodBeat.i(56340);
    Object localObject1 = ad.KXZ;
    localObject1 = this.KUC;
    d.g.b.k.h(localObject1, "klass");
    if (((Class)localObject1).isArray())
    {
      localObject1 = ((Class)localObject1).getComponentType();
      d.g.b.k.g(localObject1, "klass.componentType");
      localObject1 = ad.br((Class)localObject1);
      if (localObject1 != null)
      {
        localObject1 = new d.l.b.a.b.f.a(d.l.b.a.b.a.g.KYV, ((d.l.b.a.b.a.h)localObject1).fPR());
        AppMethodBeat.o(56340);
        return localObject1;
      }
      localObject1 = d.l.b.a.b.f.a.p(d.l.b.a.b.a.g.KZg.KZr.fZL());
      d.g.b.k.g(localObject1, "ClassId.topLevel(KotlinB….FQ_NAMES.array.toSafe())");
      AppMethodBeat.o(56340);
      return localObject1;
    }
    if (d.g.b.k.g(localObject1, Void.TYPE))
    {
      localObject1 = ad.KXY;
      AppMethodBeat.o(56340);
      return localObject1;
    }
    Object localObject2 = ad.br((Class)localObject1);
    if (localObject2 != null)
    {
      localObject1 = new d.l.b.a.b.f.a(d.l.b.a.b.a.g.KYV, ((d.l.b.a.b.a.h)localObject2).fPQ());
      AppMethodBeat.o(56340);
      return localObject1;
    }
    localObject1 = d.l.b.a.b.b.d.b.b.bz((Class)localObject1);
    if (!((d.l.b.a.b.f.a)localObject1).Dgz)
    {
      localObject2 = d.l.b.a.b.a.b.c.Lcr;
      localObject2 = ((d.l.b.a.b.f.a)localObject1).fZF();
      d.g.b.k.g(localObject2, "classId.asSingleFqName()");
      localObject2 = d.l.b.a.b.a.b.c.c((d.l.b.a.b.f.b)localObject2);
      if (localObject2 != null)
      {
        AppMethodBeat.o(56340);
        return localObject2;
      }
    }
    AppMethodBeat.o(56340);
    return localObject1;
  }
  
  public final Collection<ah> a(d.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(56344);
    d.g.b.k.h(paramf, "name");
    paramf = (Collection)d.a.j.b(fOU().a(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.LjZ), (Iterable)fOV().a(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.LjZ));
    AppMethodBeat.o(56344);
    return paramf;
  }
  
  public final ah agK(int paramInt)
  {
    AppMethodBeat.i(56346);
    for (Object localObject1 = this; d.g.b.k.g(((g)localObject1).KUC.getSimpleName(), "DefaultImpls"); localObject1 = (g)localObject1)
    {
      localObject2 = ((g)localObject1).KUC.getDeclaringClass();
      if ((localObject2 == null) || (!((Class)localObject2).isInterface())) {
        break;
      }
      localObject1 = d.g.a.bm((Class)localObject2);
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        AppMethodBeat.o(56346);
        throw ((Throwable)localObject1);
      }
    }
    Object localObject3 = ((g)localObject1).fOS();
    Object localObject2 = localObject3;
    if (!(localObject3 instanceof d.l.b.a.b.k.a.b.e)) {
      localObject2 = null;
    }
    localObject2 = (d.l.b.a.b.k.a.b.e)localObject2;
    if (localObject2 != null)
    {
      localObject3 = (i.c)((d.l.b.a.b.k.a.b.e)localObject2).LHz;
      i.f localf = d.l.b.a.b.e.c.a.Lyl;
      d.g.b.k.g(localf, "JvmProtoBuf.classLocalVariable");
      localObject3 = (a.m)d.l.b.a.b.e.b.f.a((i.c)localObject3, localf, paramInt);
      if (localObject3 != null)
      {
        localObject1 = (ah)af.a(((g)localObject1).KUC, (q)localObject3, ((d.l.b.a.b.k.a.b.e)localObject2).LIl.KVO, ((d.l.b.a.b.k.a.b.e)localObject2).LIl.KVP, ((d.l.b.a.b.k.a.b.e)localObject2).LHA, (m)c.KWA);
        AppMethodBeat.o(56346);
        return localObject1;
      }
      AppMethodBeat.o(56346);
      return null;
    }
    AppMethodBeat.o(56346);
    return null;
  }
  
  public final Collection<t> b(d.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(56345);
    d.g.b.k.h(paramf, "name");
    paramf = (Collection)d.a.j.b(fOU().b(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.LjZ), (Iterable)fOV().b(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.LjZ));
    AppMethodBeat.o(56345);
    return paramf;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56348);
    if (((paramObject instanceof g)) && (d.g.b.k.g(d.g.a.c(this), d.g.a.c((d.l.b)paramObject))))
    {
      AppMethodBeat.o(56348);
      return true;
    }
    AppMethodBeat.o(56348);
    return false;
  }
  
  public final Collection<d.l.b.a.b.b.k> fOL()
  {
    AppMethodBeat.i(56343);
    Object localObject = fOS();
    if ((((d.l.b.a.b.b.e)localObject).fPY() == d.l.b.a.b.b.f.Ldx) || (((d.l.b.a.b.b.e)localObject).fPY() == d.l.b.a.b.b.f.LdB))
    {
      localObject = (Collection)d.a.v.KTF;
      AppMethodBeat.o(56343);
      return localObject;
    }
    localObject = ((d.l.b.a.b.b.e)localObject).fOv();
    d.g.b.k.g(localObject, "descriptor.constructors");
    AppMethodBeat.o(56343);
    return localObject;
  }
  
  public final d.l.b.a.b.j.f.h fOU()
  {
    AppMethodBeat.i(56341);
    d.l.b.a.b.j.f.h localh = fOS().fRe().fQN();
    AppMethodBeat.o(56341);
    return localh;
  }
  
  public final d.l.b.a.b.j.f.h fOV()
  {
    AppMethodBeat.i(56342);
    d.l.b.a.b.j.f.h localh = fOS().fPV();
    d.g.b.k.g(localh, "descriptor.staticScope");
    AppMethodBeat.o(56342);
    return localh;
  }
  
  public final Class<T> fOt()
  {
    return this.KUC;
  }
  
  public final String fOu()
  {
    AppMethodBeat.i(56347);
    String str = (String)((a)this.KWc.invoke()).KWg.invoke();
    AppMethodBeat.o(56347);
    return str;
  }
  
  public final Collection<d.l.e<T>> fOv()
  {
    AppMethodBeat.i(207353);
    Collection localCollection = (Collection)((a)this.KWc.invoke()).KWh.invoke();
    AppMethodBeat.o(207353);
    return localCollection;
  }
  
  public final String getSimpleName()
  {
    AppMethodBeat.i(207352);
    String str = (String)((a)this.KWc.invoke()).KWf.invoke();
    AppMethodBeat.o(207352);
    return str;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56349);
    int i = d.g.a.c(this).hashCode();
    AppMethodBeat.o(56349);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56350);
    StringBuilder localStringBuilder = new StringBuilder("class ");
    Object localObject2 = fOT();
    Object localObject1 = ((d.l.b.a.b.f.a)localObject2).fZA();
    d.g.b.k.g(localObject1, "classId.packageFqName");
    if (((d.l.b.a.b.f.b)localObject1).Lzj.Lzo.isEmpty()) {}
    for (localObject1 = "";; localObject1 = ((d.l.b.a.b.f.b)localObject1).rf() + ".")
    {
      localObject2 = ((d.l.b.a.b.f.a)localObject2).fZB().rf();
      d.g.b.k.g(localObject2, "classId.relativeClassName.asString()");
      localObject2 = d.n.n.a((String)localObject2, '.', '$');
      localObject1 = new StringBuilder().append((String)localObject1).append((String)localObject2).toString();
      AppMethodBeat.o(56350);
      return localObject1;
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "constructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "objectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflection"})
  public final class a
    extends i.b
  {
    private final z.a KWd;
    private final z.a KWe;
    final z.a KWf;
    final z.a KWg;
    final z.a KWh;
    private final z.a KWi;
    private final z.b KWj;
    private final z.a KWk;
    private final z.a KWl;
    private final z.a KWm;
    private final z.a KWn;
    private final z.a KWo;
    private final z.a KWp;
    private final z.a KWq;
    final z.a KWr;
    final z.a KWs;
    private final z.a KWt;
    private final z.a KWu;
    
    static
    {
      AppMethodBeat.i(56326);
      $$delegatedProperties = new d.l.k[] { (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(a.class), "annotations", "getAnnotations()Ljava/util/List;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;")) };
      AppMethodBeat.o(56326);
    }
    
    public a()
    {
      super();
      AppMethodBeat.i(56329);
      this.KWd = z.N((d.g.a.a)new i(this));
      this.KWe = z.N((d.g.a.a)new d(this));
      this.KWf = z.N((d.g.a.a)new p(this));
      this.KWg = z.N((d.g.a.a)new n(this));
      this.KWh = z.N((d.g.a.a)new e(this));
      this.KWi = z.N((d.g.a.a)new l(this));
      this.KWj = z.M((d.g.a.a)new m(this));
      this.KWk = z.N((d.g.a.a)new r(this));
      this.KWl = z.N((d.g.a.a)new q(this));
      this.KWm = z.N((d.g.a.a)new o(this));
      this.KWn = z.N((d.g.a.a)new g(this));
      this.KWo = z.N((d.g.a.a)new h(this));
      this.KWp = z.N((d.g.a.a)new j(this));
      this.KWq = z.N((d.g.a.a)new k(this));
      this.KWr = z.N((d.g.a.a)new b(this));
      this.KWs = z.N((d.g.a.a)new c(this));
      this.KWt = z.N((d.g.a.a)new f(this));
      this.KWu = z.N((d.g.a.a)new a(this));
      AppMethodBeat.o(56329);
    }
    
    public final d.l.b.a.b.b.e fOS()
    {
      AppMethodBeat.i(56327);
      d.l.b.a.b.b.e locale = (d.l.b.a.b.b.e)this.KWd.invoke();
      AppMethodBeat.o(56327);
      return locale;
    }
    
    public final Collection<e<?>> fOW()
    {
      AppMethodBeat.i(56328);
      Collection localCollection = (Collection)this.KWn.invoke();
      AppMethodBeat.o(56328);
      return localCollection;
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<List<? extends e<?>>>
    {
      a(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<List<? extends e<?>>>
    {
      b(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<List<? extends e<?>>>
    {
      c(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "", "T", "", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<List<? extends Annotation>>
    {
      d(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlin/reflect/KFunction;", "T", "", "invoke"})
    static final class e
      extends d.g.b.l
      implements d.g.a.a<List<? extends d.l.e<? extends T>>>
    {
      e(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class f
      extends d.g.b.l
      implements d.g.a.a<List<? extends e<?>>>
    {
      f(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class g
      extends d.g.b.l
      implements d.g.a.a<Collection<? extends e<?>>>
    {
      g(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class h
      extends d.g.b.l
      implements d.g.a.a<Collection<? extends e<?>>>
    {
      h(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "T", "", "invoke"})
    static final class i
      extends d.g.b.l
      implements d.g.a.a<d.l.b.a.b.b.e>
    {
      i(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class j
      extends d.g.b.l
      implements d.g.a.a<Collection<? extends e<?>>>
    {
      j(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class k
      extends d.g.b.l
      implements d.g.a.a<Collection<? extends e<?>>>
    {
      k(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "", "kotlin.jvm.PlatformType", "T", "invoke"})
    static final class l
      extends d.g.b.l
      implements d.g.a.a<List<? extends g<? extends Object>>>
    {
      l(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"})
    static final class m
      extends d.g.b.l
      implements d.g.a.a<T>
    {
      m(g.a parama)
      {
        super();
      }
      
      public final T invoke()
      {
        AppMethodBeat.i(56318);
        Object localObject = this.KWw.fOS();
        if (((d.l.b.a.b.b.e)localObject).fPY() != d.l.b.a.b.b.f.LdB)
        {
          AppMethodBeat.o(56318);
          return null;
        }
        if (((d.l.b.a.b.b.e)localObject).fQc())
        {
          d.l.b.a.b.a.c localc = d.l.b.a.b.a.c.KYR;
          if (d.l.b.a.b.a.c.b((d.l.b.a.b.b.e)localObject)) {}
        }
        for (localObject = this.KWw.KWv.KUC.getEnclosingClass().getDeclaredField(((d.l.b.a.b.b.e)localObject).fRf().rf());; localObject = this.KWw.KWv.KUC.getDeclaredField("INSTANCE"))
        {
          localObject = ((Field)localObject).get(null);
          if (localObject != null) {
            break;
          }
          localObject = new d.v("null cannot be cast to non-null type T");
          AppMethodBeat.o(56318);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(56318);
        return localObject;
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "T", "", "invoke"})
    static final class n
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      n(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"})
    static final class o
      extends d.g.b.l
      implements d.g.a.a<List<? extends g<? extends T>>>
    {
      o(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "T", "", "invoke"})
    static final class p
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      p(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "T", "", "invoke"})
    static final class q
      extends d.g.b.l
      implements d.g.a.a<List<? extends u>>
    {
      q(g.a parama)
      {
        super();
      }
      
      @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Ljava/lang/reflect/Type;", "T", "", "invoke", "kotlin/reflect/jvm/internal/KClassImpl$Data$supertypes$2$1$1"})
      static final class a
        extends d.g.b.l
        implements d.g.a.a<Type>
      {
        a(ab paramab, g.a.q paramq)
        {
          super();
        }
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "T", "", "invoke"})
    static final class r
      extends d.g.b.l
      implements d.g.a.a<List<? extends w>>
    {
      r(g.a parama)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<g<T>.a>
  {
    b(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.g
 * JD-Core Version:    0.7.0.1
 */