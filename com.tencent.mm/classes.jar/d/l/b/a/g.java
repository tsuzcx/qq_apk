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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isInner", "isOpen", "isSealed", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflection", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflection"})
public final class g<T>
  extends i
  implements d.l.b<T>
{
  final Class<T> MLE;
  final y.b<g<T>.a> MNi;
  
  public g(Class<T> paramClass)
  {
    AppMethodBeat.i(56351);
    this.MLE = paramClass;
    paramClass = y.Q((d.g.a.a)new b(this));
    p.g(paramClass, "ReflectProperties.lazy { Data() }");
    this.MNi = paramClass;
    AppMethodBeat.o(56351);
  }
  
  private d.l.b.a.b.b.e ggs()
  {
    AppMethodBeat.i(56339);
    d.l.b.a.b.b.e locale = ((a)this.MNi.invoke()).ggs();
    AppMethodBeat.o(56339);
    return locale;
  }
  
  private final d.l.b.a.b.f.a ggt()
  {
    AppMethodBeat.i(56340);
    Object localObject1 = ac.MOW;
    localObject1 = this.MLE;
    p.h(localObject1, "klass");
    if (((Class)localObject1).isArray())
    {
      localObject1 = ((Class)localObject1).getComponentType();
      p.g(localObject1, "klass.componentType");
      localObject1 = ac.bt((Class)localObject1);
      if (localObject1 != null)
      {
        localObject1 = new d.l.b.a.b.f.a(d.l.b.a.b.a.g.MPQ, ((d.l.b.a.b.a.h)localObject1).ghp());
        AppMethodBeat.o(56340);
        return localObject1;
      }
      localObject1 = d.l.b.a.b.f.a.p(d.l.b.a.b.a.g.MQb.MQm.grk());
      p.g(localObject1, "ClassId.topLevel(KotlinB….FQ_NAMES.array.toSafe())");
      AppMethodBeat.o(56340);
      return localObject1;
    }
    if (p.i(localObject1, Void.TYPE))
    {
      localObject1 = ac.MOV;
      AppMethodBeat.o(56340);
      return localObject1;
    }
    Object localObject2 = ac.bt((Class)localObject1);
    if (localObject2 != null)
    {
      localObject1 = new d.l.b.a.b.f.a(d.l.b.a.b.a.g.MPQ, ((d.l.b.a.b.a.h)localObject2).gho());
      AppMethodBeat.o(56340);
      return localObject1;
    }
    localObject1 = d.l.b.a.b.b.d.b.b.bB((Class)localObject1);
    if (!((d.l.b.a.b.f.a)localObject1).ELj)
    {
      localObject2 = d.l.b.a.b.a.b.c.MTm;
      localObject2 = ((d.l.b.a.b.f.a)localObject1).gre();
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
    paramf = (Collection)j.b(ggu().a(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.NaW), (Iterable)ggv().a(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.NaW));
    AppMethodBeat.o(56344);
    return paramf;
  }
  
  public final ah ajl(int paramInt)
  {
    AppMethodBeat.i(56346);
    for (Object localObject1 = this; p.i(((g)localObject1).MLE.getSimpleName(), "DefaultImpls"); localObject1 = (g)localObject1)
    {
      localObject2 = ((g)localObject1).MLE.getDeclaringClass();
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
    Object localObject3 = ((g)localObject1).ggs();
    Object localObject2 = localObject3;
    if (!(localObject3 instanceof d.l.b.a.b.k.a.b.e)) {
      localObject2 = null;
    }
    localObject3 = (d.l.b.a.b.k.a.b.e)localObject2;
    if (localObject3 != null)
    {
      localObject2 = (i.c)((d.l.b.a.b.k.a.b.e)localObject3).Nyx;
      i.f localf = d.l.b.a.b.e.c.a.Npi;
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
        localObject1 = (ah)ae.a(((g)localObject1).MLE, (d.l.b.a.b.h.q)localObject2, ((d.l.b.a.b.k.a.b.e)localObject3).Nzj.MMU, ((d.l.b.a.b.k.a.b.e)localObject3).Nzj.MMV, ((d.l.b.a.b.k.a.b.e)localObject3).Nyy, (m)c.MNG);
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
    paramf = (Collection)j.b(ggu().b(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.NaW), (Iterable)ggv().b(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.NaW));
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
    AppMethodBeat.i(187758);
    String str = (String)((a)this.MNi.invoke()).MNl.invoke();
    AppMethodBeat.o(187758);
    return str;
  }
  
  public final Class<T> gfT()
  {
    return this.MLE;
  }
  
  public final String gfU()
  {
    AppMethodBeat.i(56347);
    String str = (String)((a)this.MNi.invoke()).MNm.invoke();
    AppMethodBeat.o(56347);
    return str;
  }
  
  public final Collection<d.l.e<T>> gfV()
  {
    AppMethodBeat.i(187759);
    Collection localCollection = (Collection)((a)this.MNi.invoke()).MNn.invoke();
    AppMethodBeat.o(187759);
    return localCollection;
  }
  
  public final Collection<d.l.b.a.b.b.k> ggl()
  {
    AppMethodBeat.i(56343);
    Object localObject = ggs();
    if ((((d.l.b.a.b.b.e)localObject).ghw() == d.l.b.a.b.b.f.MUs) || (((d.l.b.a.b.b.e)localObject).ghw() == d.l.b.a.b.b.f.MUw))
    {
      localObject = (Collection)d.a.v.MKE;
      AppMethodBeat.o(56343);
      return localObject;
    }
    localObject = ((d.l.b.a.b.b.e)localObject).gfV();
    p.g(localObject, "descriptor.constructors");
    AppMethodBeat.o(56343);
    return localObject;
  }
  
  public final d.l.b.a.b.j.f.h ggu()
  {
    AppMethodBeat.i(56341);
    d.l.b.a.b.j.f.h localh = ggs().giC().gil();
    AppMethodBeat.o(56341);
    return localh;
  }
  
  public final d.l.b.a.b.j.f.h ggv()
  {
    AppMethodBeat.i(56342);
    d.l.b.a.b.j.f.h localh = ggs().ght();
    p.g(localh, "descriptor.staticScope");
    AppMethodBeat.o(56342);
    return localh;
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
    Object localObject2 = ggt();
    Object localObject1 = ((d.l.b.a.b.f.a)localObject2).gqZ();
    p.g(localObject1, "classId.packageFqName");
    if (((d.l.b.a.b.f.b)localObject1).Nqg.Nql.isEmpty()) {}
    for (localObject1 = "";; localObject1 = ((d.l.b.a.b.f.b)localObject1).sD() + ".")
    {
      localObject2 = ((d.l.b.a.b.f.a)localObject2).gra().sD();
      p.g(localObject2, "classId.relativeClassName.asString()");
      localObject2 = d.n.n.a((String)localObject2, '.', '$');
      localObject1 = new StringBuilder().append((String)localObject1).append((String)localObject2).toString();
      AppMethodBeat.o(56350);
      return localObject1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "constructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "objectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflection"})
  public final class a
    extends i.b
  {
    private final y.a MNA;
    private final y.a MNj;
    private final y.a MNk;
    final y.a MNl;
    final y.a MNm;
    final y.a MNn;
    private final y.a MNo;
    private final y.b MNp;
    private final y.a MNq;
    private final y.a MNr;
    private final y.a MNs;
    private final y.a MNt;
    private final y.a MNu;
    private final y.a MNv;
    private final y.a MNw;
    final y.a MNx;
    final y.a MNy;
    private final y.a MNz;
    
    static
    {
      AppMethodBeat.i(56326);
      cwV = new d.l.k[] { (d.l.k)z.a(new x(z.bp(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)z.a(new x(z.bp(a.class), "annotations", "getAnnotations()Ljava/util/List;")), (d.l.k)z.a(new x(z.bp(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), (d.l.k)z.a(new x(z.bp(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), (d.l.k)z.a(new x(z.bp(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), (d.l.k)z.a(new x(z.bp(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), (d.l.k)z.a(new x(z.bp(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), (d.l.k)z.a(new x(z.bp(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), (d.l.k)z.a(new x(z.bp(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), (d.l.k)z.a(new x(z.bp(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), (d.l.k)z.a(new x(z.bp(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), (d.l.k)z.a(new x(z.bp(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), (d.l.k)z.a(new x(z.bp(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), (d.l.k)z.a(new x(z.bp(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), (d.l.k)z.a(new x(z.bp(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), (d.l.k)z.a(new x(z.bp(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), (d.l.k)z.a(new x(z.bp(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), (d.l.k)z.a(new x(z.bp(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;")) };
      AppMethodBeat.o(56326);
    }
    
    public a()
    {
      super();
      AppMethodBeat.i(56329);
      this.MNj = y.R((d.g.a.a)new i(this));
      this.MNk = y.R((d.g.a.a)new d(this));
      this.MNl = y.R((d.g.a.a)new p(this));
      this.MNm = y.R((d.g.a.a)new n(this));
      this.MNn = y.R((d.g.a.a)new e(this));
      this.MNo = y.R((d.g.a.a)new l(this));
      this.MNp = y.Q((d.g.a.a)new m(this));
      this.MNq = y.R((d.g.a.a)new r(this));
      this.MNr = y.R((d.g.a.a)new q(this));
      this.MNs = y.R((d.g.a.a)new o(this));
      this.MNt = y.R((d.g.a.a)new g(this));
      this.MNu = y.R((d.g.a.a)new h(this));
      this.MNv = y.R((d.g.a.a)new j(this));
      this.MNw = y.R((d.g.a.a)new k(this));
      this.MNx = y.R((d.g.a.a)new b(this));
      this.MNy = y.R((d.g.a.a)new c(this));
      this.MNz = y.R((d.g.a.a)new f(this));
      this.MNA = y.R((d.g.a.a)new a(this));
      AppMethodBeat.o(56329);
    }
    
    public final d.l.b.a.b.b.e ggs()
    {
      AppMethodBeat.i(56327);
      d.l.b.a.b.b.e locale = (d.l.b.a.b.b.e)this.MNj.invoke();
      AppMethodBeat.o(56327);
      return locale;
    }
    
    public final Collection<e<?>> ggw()
    {
      AppMethodBeat.i(56328);
      Collection localCollection = (Collection)this.MNt.invoke();
      AppMethodBeat.o(56328);
      return localCollection;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<List<? extends e<?>>>
    {
      a(g.a parama)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.a<List<? extends e<?>>>
    {
      b(g.a parama)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class c
      extends d.g.b.q
      implements d.g.a.a<List<? extends e<?>>>
    {
      c(g.a parama)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "T", "", "invoke"})
    static final class d
      extends d.g.b.q
      implements d.g.a.a<List<? extends Annotation>>
    {
      d(g.a parama)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlin/reflect/KFunction;", "T", "", "invoke"})
    static final class e
      extends d.g.b.q
      implements d.g.a.a<List<? extends d.l.e<? extends T>>>
    {
      e(g.a parama)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class f
      extends d.g.b.q
      implements d.g.a.a<List<? extends e<?>>>
    {
      f(g.a parama)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class g
      extends d.g.b.q
      implements d.g.a.a<Collection<? extends e<?>>>
    {
      g(g.a parama)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class h
      extends d.g.b.q
      implements d.g.a.a<Collection<? extends e<?>>>
    {
      h(g.a parama)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "T", "", "invoke"})
    static final class i
      extends d.g.b.q
      implements d.g.a.a<d.l.b.a.b.b.e>
    {
      i(g.a parama)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class j
      extends d.g.b.q
      implements d.g.a.a<Collection<? extends e<?>>>
    {
      j(g.a parama)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class k
      extends d.g.b.q
      implements d.g.a.a<Collection<? extends e<?>>>
    {
      k(g.a parama)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "", "kotlin.jvm.PlatformType", "T", "invoke"})
    static final class l
      extends d.g.b.q
      implements d.g.a.a<List<? extends g<? extends Object>>>
    {
      l(g.a parama)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"})
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
        Object localObject = this.MNC.ggs();
        if (((d.l.b.a.b.b.e)localObject).ghw() != d.l.b.a.b.b.f.MUw)
        {
          AppMethodBeat.o(56318);
          return null;
        }
        if (((d.l.b.a.b.b.e)localObject).ghA())
        {
          d.l.b.a.b.a.c localc = d.l.b.a.b.a.c.MPM;
          if (d.l.b.a.b.a.c.b((d.l.b.a.b.b.e)localObject)) {}
        }
        for (localObject = this.MNC.MNB.MLE.getEnclosingClass().getDeclaredField(((d.l.b.a.b.b.e)localObject).giD().sD());; localObject = this.MNC.MNB.MLE.getDeclaredField("INSTANCE"))
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
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "", "invoke"})
    static final class n
      extends d.g.b.q
      implements d.g.a.a<String>
    {
      n(g.a parama)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"})
    static final class o
      extends d.g.b.q
      implements d.g.a.a<List<? extends g<? extends T>>>
    {
      o(g.a parama)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "", "invoke"})
    static final class p
      extends d.g.b.q
      implements d.g.a.a<String>
    {
      p(g.a parama)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "T", "", "invoke"})
    static final class q
      extends d.g.b.q
      implements d.g.a.a<List<? extends t>>
    {
      q(g.a parama)
      {
        super();
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/lang/reflect/Type;", "T", "", "invoke", "kotlin/reflect/jvm/internal/KClassImpl$Data$supertypes$2$1$1"})
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
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "T", "", "invoke"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.g
 * JD-Core Version:    0.7.0.1
 */