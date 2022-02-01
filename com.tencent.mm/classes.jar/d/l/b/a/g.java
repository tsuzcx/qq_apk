package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.a.m;
import d.g.b.p;
import d.g.b.x;
import d.g.b.z;
import d.l;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.e.a.m;
import d.l.b.a.b.h.i.c;
import d.l.b.a.b.h.i.f;
import d.l.b.a.b.k.a.w;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.aj;
import d.l.d;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isInner", "isOpen", "isSealed", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflection", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflection"})
public final class g<T>
  extends i
  implements d.l.b<T>
{
  final Class<T> NiH;
  final y.b<g<T>.a> Nkn;
  
  public g(Class<T> paramClass)
  {
    AppMethodBeat.i(56351);
    this.NiH = paramClass;
    paramClass = y.Q((d.g.a.a)new b(this));
    p.g(paramClass, "ReflectProperties.lazy { Data() }");
    this.Nkn = paramClass;
    AppMethodBeat.o(56351);
  }
  
  private d.l.b.a.b.b.e gkU()
  {
    AppMethodBeat.i(56339);
    d.l.b.a.b.b.e locale = ((a)this.Nkn.invoke()).gkU();
    AppMethodBeat.o(56339);
    return locale;
  }
  
  private final d.l.b.a.b.f.a gkV()
  {
    AppMethodBeat.i(56340);
    Object localObject1 = ac.Nmb;
    localObject1 = this.NiH;
    p.h(localObject1, "klass");
    if (((Class)localObject1).isArray())
    {
      localObject1 = ((Class)localObject1).getComponentType();
      p.g(localObject1, "klass.componentType");
      localObject1 = ac.bt((Class)localObject1);
      if (localObject1 != null)
      {
        localObject1 = new d.l.b.a.b.f.a(d.l.b.a.b.a.g.NmV, ((d.l.b.a.b.a.h)localObject1).glR());
        AppMethodBeat.o(56340);
        return localObject1;
      }
      localObject1 = d.l.b.a.b.f.a.p(d.l.b.a.b.a.g.Nng.Nnr.gvM());
      p.g(localObject1, "ClassId.topLevel(KotlinB….FQ_NAMES.array.toSafe())");
      AppMethodBeat.o(56340);
      return localObject1;
    }
    if (p.i(localObject1, Void.TYPE))
    {
      localObject1 = ac.Nma;
      AppMethodBeat.o(56340);
      return localObject1;
    }
    Object localObject2 = ac.bt((Class)localObject1);
    if (localObject2 != null)
    {
      localObject1 = new d.l.b.a.b.f.a(d.l.b.a.b.a.g.NmV, ((d.l.b.a.b.a.h)localObject2).glQ());
      AppMethodBeat.o(56340);
      return localObject1;
    }
    localObject1 = d.l.b.a.b.b.d.b.b.bB((Class)localObject1);
    if (!((d.l.b.a.b.f.a)localObject1).FdH)
    {
      localObject2 = d.l.b.a.b.a.b.c.Nqr;
      localObject2 = ((d.l.b.a.b.f.a)localObject1).gvG();
      p.g(localObject2, "classId.asSingleFqName()");
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
    p.h(paramf, "name");
    paramf = (Collection)j.b(gkW().a(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.Nyb), (Iterable)gkX().a(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.Nyb));
    AppMethodBeat.o(56344);
    return paramf;
  }
  
  public final ah ajV(int paramInt)
  {
    AppMethodBeat.i(56346);
    for (Object localObject1 = this; p.i(((g)localObject1).NiH.getSimpleName(), "DefaultImpls"); localObject1 = (g)localObject1)
    {
      localObject2 = ((g)localObject1).NiH.getDeclaringClass();
      if ((localObject2 == null) || (!((Class)localObject2).isInterface())) {
        break;
      }
      localObject1 = d.g.a.bo((Class)localObject2);
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        AppMethodBeat.o(56346);
        throw ((Throwable)localObject1);
      }
    }
    Object localObject3 = ((g)localObject1).gkU();
    Object localObject2 = localObject3;
    if (!(localObject3 instanceof d.l.b.a.b.k.a.b.e)) {
      localObject2 = null;
    }
    localObject3 = (d.l.b.a.b.k.a.b.e)localObject2;
    if (localObject3 != null)
    {
      localObject2 = (i.c)((d.l.b.a.b.k.a.b.e)localObject3).NVE;
      i.f localf = d.l.b.a.b.e.c.a.NMo;
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
        localObject1 = (ah)ae.a(((g)localObject1).NiH, (d.l.b.a.b.h.q)localObject2, ((d.l.b.a.b.k.a.b.e)localObject3).NWq.NjZ, ((d.l.b.a.b.k.a.b.e)localObject3).NWq.Nka, ((d.l.b.a.b.k.a.b.e)localObject3).NVF, (m)c.NkL);
        AppMethodBeat.o(56346);
        return localObject1;
      }
      AppMethodBeat.o(56346);
      return null;
    }
    AppMethodBeat.o(56346);
    return null;
  }
  
  public final Collection<d.l.b.a.b.b.t> b(d.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(56345);
    p.h(paramf, "name");
    paramf = (Collection)j.b(gkW().b(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.Nyb), (Iterable)gkX().b(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.Nyb));
    AppMethodBeat.o(56345);
    return paramf;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56348);
    if (((paramObject instanceof g)) && (p.i(d.g.a.c(this), d.g.a.c((d.l.b)paramObject))))
    {
      AppMethodBeat.o(56348);
      return true;
    }
    AppMethodBeat.o(56348);
    return false;
  }
  
  public final String getSimpleName()
  {
    AppMethodBeat.i(193282);
    String str = (String)((a)this.Nkn.invoke()).Nkq.invoke();
    AppMethodBeat.o(193282);
    return str;
  }
  
  public final Collection<d.l.b.a.b.b.k> gkN()
  {
    AppMethodBeat.i(56343);
    Object localObject = gkU();
    if ((((d.l.b.a.b.b.e)localObject).glY() == d.l.b.a.b.b.f.Nrx) || (((d.l.b.a.b.b.e)localObject).glY() == d.l.b.a.b.b.f.NrB))
    {
      localObject = (Collection)d.a.v.NhH;
      AppMethodBeat.o(56343);
      return localObject;
    }
    localObject = ((d.l.b.a.b.b.e)localObject).gkx();
    p.g(localObject, "descriptor.constructors");
    AppMethodBeat.o(56343);
    return localObject;
  }
  
  public final d.l.b.a.b.j.f.h gkW()
  {
    AppMethodBeat.i(56341);
    d.l.b.a.b.j.f.h localh = gkU().gne().gmN();
    AppMethodBeat.o(56341);
    return localh;
  }
  
  public final d.l.b.a.b.j.f.h gkX()
  {
    AppMethodBeat.i(56342);
    d.l.b.a.b.j.f.h localh = gkU().glV();
    p.g(localh, "descriptor.staticScope");
    AppMethodBeat.o(56342);
    return localh;
  }
  
  public final Class<T> gkv()
  {
    return this.NiH;
  }
  
  public final String gkw()
  {
    AppMethodBeat.i(56347);
    String str = (String)((a)this.Nkn.invoke()).Nkr.invoke();
    AppMethodBeat.o(56347);
    return str;
  }
  
  public final Collection<d.l.e<T>> gkx()
  {
    AppMethodBeat.i(193283);
    Collection localCollection = (Collection)((a)this.Nkn.invoke()).Nks.invoke();
    AppMethodBeat.o(193283);
    return localCollection;
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
    Object localObject2 = gkV();
    Object localObject1 = ((d.l.b.a.b.f.a)localObject2).gvB();
    p.g(localObject1, "classId.packageFqName");
    if (((d.l.b.a.b.f.b)localObject1).NNm.NNr.isEmpty()) {}
    for (localObject1 = "";; localObject1 = ((d.l.b.a.b.f.b)localObject1).sD() + ".")
    {
      localObject2 = ((d.l.b.a.b.f.a)localObject2).gvC().sD();
      p.g(localObject2, "classId.relativeClassName.asString()");
      localObject2 = d.n.n.a((String)localObject2, '.', '$');
      localObject1 = new StringBuilder().append((String)localObject1).append((String)localObject2).toString();
      AppMethodBeat.o(56350);
      return localObject1;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "constructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "objectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflection"})
  public final class a
    extends i.b
  {
    private final y.a NkA;
    private final y.a NkB;
    final y.a NkC;
    final y.a NkD;
    private final y.a NkE;
    private final y.a NkF;
    private final y.a Nko;
    private final y.a Nkp;
    final y.a Nkq;
    final y.a Nkr;
    final y.a Nks;
    private final y.a Nkt;
    private final y.b Nku;
    private final y.a Nkv;
    private final y.a Nkw;
    private final y.a Nkx;
    private final y.a Nky;
    private final y.a Nkz;
    
    static
    {
      AppMethodBeat.i(56326);
      cxA = new d.l.k[] { (d.l.k)z.a(new x(z.bp(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)z.a(new x(z.bp(a.class), "annotations", "getAnnotations()Ljava/util/List;")), (d.l.k)z.a(new x(z.bp(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), (d.l.k)z.a(new x(z.bp(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), (d.l.k)z.a(new x(z.bp(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), (d.l.k)z.a(new x(z.bp(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), (d.l.k)z.a(new x(z.bp(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), (d.l.k)z.a(new x(z.bp(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), (d.l.k)z.a(new x(z.bp(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), (d.l.k)z.a(new x(z.bp(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), (d.l.k)z.a(new x(z.bp(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), (d.l.k)z.a(new x(z.bp(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), (d.l.k)z.a(new x(z.bp(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), (d.l.k)z.a(new x(z.bp(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), (d.l.k)z.a(new x(z.bp(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), (d.l.k)z.a(new x(z.bp(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), (d.l.k)z.a(new x(z.bp(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), (d.l.k)z.a(new x(z.bp(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;")) };
      AppMethodBeat.o(56326);
    }
    
    public a()
    {
      super();
      AppMethodBeat.i(56329);
      this.Nko = y.R((d.g.a.a)new i(this));
      this.Nkp = y.R((d.g.a.a)new d(this));
      this.Nkq = y.R((d.g.a.a)new p(this));
      this.Nkr = y.R((d.g.a.a)new n(this));
      this.Nks = y.R((d.g.a.a)new e(this));
      this.Nkt = y.R((d.g.a.a)new l(this));
      this.Nku = y.Q((d.g.a.a)new m(this));
      this.Nkv = y.R((d.g.a.a)new r(this));
      this.Nkw = y.R((d.g.a.a)new q(this));
      this.Nkx = y.R((d.g.a.a)new o(this));
      this.Nky = y.R((d.g.a.a)new g(this));
      this.Nkz = y.R((d.g.a.a)new h(this));
      this.NkA = y.R((d.g.a.a)new j(this));
      this.NkB = y.R((d.g.a.a)new k(this));
      this.NkC = y.R((d.g.a.a)new b(this));
      this.NkD = y.R((d.g.a.a)new c(this));
      this.NkE = y.R((d.g.a.a)new f(this));
      this.NkF = y.R((d.g.a.a)new a(this));
      AppMethodBeat.o(56329);
    }
    
    public final d.l.b.a.b.b.e gkU()
    {
      AppMethodBeat.i(56327);
      d.l.b.a.b.b.e locale = (d.l.b.a.b.b.e)this.Nko.invoke();
      AppMethodBeat.o(56327);
      return locale;
    }
    
    public final Collection<e<?>> gkY()
    {
      AppMethodBeat.i(56328);
      Collection localCollection = (Collection)this.Nky.invoke();
      AppMethodBeat.o(56328);
      return localCollection;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<List<? extends e<?>>>
    {
      a(g.a parama)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.a<List<? extends e<?>>>
    {
      b(g.a parama)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class c
      extends d.g.b.q
      implements d.g.a.a<List<? extends e<?>>>
    {
      c(g.a parama)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "T", "", "invoke"})
    static final class d
      extends d.g.b.q
      implements d.g.a.a<List<? extends Annotation>>
    {
      d(g.a parama)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlin/reflect/KFunction;", "T", "", "invoke"})
    static final class e
      extends d.g.b.q
      implements d.g.a.a<List<? extends d.l.e<? extends T>>>
    {
      e(g.a parama)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class f
      extends d.g.b.q
      implements d.g.a.a<List<? extends e<?>>>
    {
      f(g.a parama)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class g
      extends d.g.b.q
      implements d.g.a.a<Collection<? extends e<?>>>
    {
      g(g.a parama)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class h
      extends d.g.b.q
      implements d.g.a.a<Collection<? extends e<?>>>
    {
      h(g.a parama)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "T", "", "invoke"})
    static final class i
      extends d.g.b.q
      implements d.g.a.a<d.l.b.a.b.b.e>
    {
      i(g.a parama)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class j
      extends d.g.b.q
      implements d.g.a.a<Collection<? extends e<?>>>
    {
      j(g.a parama)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class k
      extends d.g.b.q
      implements d.g.a.a<Collection<? extends e<?>>>
    {
      k(g.a parama)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "", "kotlin.jvm.PlatformType", "T", "invoke"})
    static final class l
      extends d.g.b.q
      implements d.g.a.a<List<? extends g<? extends Object>>>
    {
      l(g.a parama)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"})
    static final class m
      extends d.g.b.q
      implements d.g.a.a<T>
    {
      m(g.a parama)
      {
        super();
      }
      
      public final T invoke()
      {
        AppMethodBeat.i(56318);
        Object localObject = this.NkH.gkU();
        if (((d.l.b.a.b.b.e)localObject).glY() != d.l.b.a.b.b.f.NrB)
        {
          AppMethodBeat.o(56318);
          return null;
        }
        if (((d.l.b.a.b.b.e)localObject).gmc())
        {
          d.l.b.a.b.a.c localc = d.l.b.a.b.a.c.NmR;
          if (d.l.b.a.b.a.c.b((d.l.b.a.b.b.e)localObject)) {}
        }
        for (localObject = this.NkH.NkG.NiH.getEnclosingClass().getDeclaredField(((d.l.b.a.b.b.e)localObject).gnf().sD());; localObject = this.NkH.NkG.NiH.getDeclaredField("INSTANCE"))
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
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "", "invoke"})
    static final class n
      extends d.g.b.q
      implements d.g.a.a<String>
    {
      n(g.a parama)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"})
    static final class o
      extends d.g.b.q
      implements d.g.a.a<List<? extends g<? extends T>>>
    {
      o(g.a parama)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "", "invoke"})
    static final class p
      extends d.g.b.q
      implements d.g.a.a<String>
    {
      p(g.a parama)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "T", "", "invoke"})
    static final class q
      extends d.g.b.q
      implements d.g.a.a<List<? extends t>>
    {
      q(g.a parama)
      {
        super();
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/lang/reflect/Type;", "T", "", "invoke", "kotlin/reflect/jvm/internal/KClassImpl$Data$supertypes$2$1$1"})
      static final class a
        extends d.g.b.q
        implements d.g.a.a<Type>
      {
        a(ab paramab, g.a.q paramq)
        {
          super();
        }
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "T", "", "invoke"})
    static final class r
      extends d.g.b.q
      implements d.g.a.a<List<? extends v>>
    {
      r(g.a parama)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"})
  static final class b
    extends d.g.b.q
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