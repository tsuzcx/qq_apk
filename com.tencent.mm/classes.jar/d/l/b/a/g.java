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

@d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isInner", "isOpen", "isSealed", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflection", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflection"})
public final class g<T>
  extends i
  implements d.l.b<T>
{
  final Class<T> Jhj;
  final z.b<g<T>.a> JiI;
  
  public g(Class<T> paramClass)
  {
    AppMethodBeat.i(56351);
    this.Jhj = paramClass;
    paramClass = z.F((d.g.a.a)new b(this));
    d.g.b.k.g(paramClass, "ReflectProperties.lazy { Data() }");
    this.JiI = paramClass;
    AppMethodBeat.o(56351);
  }
  
  private d.l.b.a.b.b.e fwo()
  {
    AppMethodBeat.i(56339);
    d.l.b.a.b.b.e locale = ((a)this.JiI.invoke()).fwo();
    AppMethodBeat.o(56339);
    return locale;
  }
  
  private final d.l.b.a.b.f.a fwp()
  {
    AppMethodBeat.i(56340);
    Object localObject1 = ad.JkF;
    localObject1 = this.Jhj;
    d.g.b.k.h(localObject1, "klass");
    if (((Class)localObject1).isArray())
    {
      localObject1 = ((Class)localObject1).getComponentType();
      d.g.b.k.g(localObject1, "klass.componentType");
      localObject1 = ad.bo((Class)localObject1);
      if (localObject1 != null)
      {
        localObject1 = new d.l.b.a.b.f.a(d.l.b.a.b.a.g.JlB, ((d.l.b.a.b.a.h)localObject1).fxn());
        AppMethodBeat.o(56340);
        return localObject1;
      }
      localObject1 = d.l.b.a.b.f.a.p(d.l.b.a.b.a.g.JlM.JlX.fHh());
      d.g.b.k.g(localObject1, "ClassId.topLevel(KotlinB….FQ_NAMES.array.toSafe())");
      AppMethodBeat.o(56340);
      return localObject1;
    }
    if (d.g.b.k.g(localObject1, Void.TYPE))
    {
      localObject1 = ad.JkE;
      AppMethodBeat.o(56340);
      return localObject1;
    }
    Object localObject2 = ad.bo((Class)localObject1);
    if (localObject2 != null)
    {
      localObject1 = new d.l.b.a.b.f.a(d.l.b.a.b.a.g.JlB, ((d.l.b.a.b.a.h)localObject2).fxm());
      AppMethodBeat.o(56340);
      return localObject1;
    }
    localObject1 = d.l.b.a.b.b.d.b.b.bw((Class)localObject1);
    if (!((d.l.b.a.b.f.a)localObject1).BOl)
    {
      localObject2 = d.l.b.a.b.a.b.c.JoY;
      localObject2 = ((d.l.b.a.b.f.a)localObject1).fHb();
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
    paramf = (Collection)d.a.j.b(fwq().a(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.JwG), (Iterable)fwr().a(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.JwG));
    AppMethodBeat.o(56344);
    return paramf;
  }
  
  public final ah adO(int paramInt)
  {
    AppMethodBeat.i(56346);
    for (Object localObject1 = this; d.g.b.k.g(((g)localObject1).Jhj.getSimpleName(), "DefaultImpls"); localObject1 = (g)localObject1)
    {
      localObject2 = ((g)localObject1).Jhj.getDeclaringClass();
      if ((localObject2 == null) || (!((Class)localObject2).isInterface())) {
        break;
      }
      localObject1 = d.g.a.bj((Class)localObject2);
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        AppMethodBeat.o(56346);
        throw ((Throwable)localObject1);
      }
    }
    Object localObject3 = ((g)localObject1).fwo();
    Object localObject2 = localObject3;
    if (!(localObject3 instanceof d.l.b.a.b.k.a.b.e)) {
      localObject2 = null;
    }
    localObject2 = (d.l.b.a.b.k.a.b.e)localObject2;
    if (localObject2 != null)
    {
      localObject3 = (i.c)((d.l.b.a.b.k.a.b.e)localObject2).JUg;
      i.f localf = d.l.b.a.b.e.c.a.JKS;
      d.g.b.k.g(localf, "JvmProtoBuf.classLocalVariable");
      localObject3 = (a.m)d.l.b.a.b.e.b.f.a((i.c)localObject3, localf, paramInt);
      if (localObject3 != null)
      {
        localObject1 = (ah)af.a(((g)localObject1).Jhj, (q)localObject3, ((d.l.b.a.b.k.a.b.e)localObject2).JUS.Jiu, ((d.l.b.a.b.k.a.b.e)localObject2).JUS.Jiv, ((d.l.b.a.b.k.a.b.e)localObject2).JUh, (m)c.Jjg);
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
    paramf = (Collection)d.a.j.b(fwq().b(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.JwG), (Iterable)fwr().b(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.JwG));
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
  
  public final Class<T> fvP()
  {
    return this.Jhj;
  }
  
  public final String fvQ()
  {
    AppMethodBeat.i(56347);
    String str = (String)((a)this.JiI.invoke()).JiM.invoke();
    AppMethodBeat.o(56347);
    return str;
  }
  
  public final Collection<d.l.e<T>> fvR()
  {
    AppMethodBeat.i(186690);
    Collection localCollection = (Collection)((a)this.JiI.invoke()).JiN.invoke();
    AppMethodBeat.o(186690);
    return localCollection;
  }
  
  public final Collection<d.l.b.a.b.b.k> fwh()
  {
    AppMethodBeat.i(56343);
    Object localObject = fwo();
    if ((((d.l.b.a.b.b.e)localObject).fxu() == d.l.b.a.b.b.f.Jqe) || (((d.l.b.a.b.b.e)localObject).fxu() == d.l.b.a.b.b.f.Jqi))
    {
      localObject = (Collection)d.a.v.Jgl;
      AppMethodBeat.o(56343);
      return localObject;
    }
    localObject = ((d.l.b.a.b.b.e)localObject).fvR();
    d.g.b.k.g(localObject, "descriptor.constructors");
    AppMethodBeat.o(56343);
    return localObject;
  }
  
  public final d.l.b.a.b.j.f.h fwq()
  {
    AppMethodBeat.i(56341);
    d.l.b.a.b.j.f.h localh = fwo().fyA().fyj();
    AppMethodBeat.o(56341);
    return localh;
  }
  
  public final d.l.b.a.b.j.f.h fwr()
  {
    AppMethodBeat.i(56342);
    d.l.b.a.b.j.f.h localh = fwo().fxr();
    d.g.b.k.g(localh, "descriptor.staticScope");
    AppMethodBeat.o(56342);
    return localh;
  }
  
  public final String getSimpleName()
  {
    AppMethodBeat.i(186689);
    String str = (String)((a)this.JiI.invoke()).JiL.invoke();
    AppMethodBeat.o(186689);
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
    Object localObject2 = fwp();
    Object localObject1 = ((d.l.b.a.b.f.a)localObject2).fGW();
    d.g.b.k.g(localObject1, "classId.packageFqName");
    if (((d.l.b.a.b.f.b)localObject1).JLQ.JLV.isEmpty()) {}
    for (localObject1 = "";; localObject1 = ((d.l.b.a.b.f.b)localObject1).qV() + ".")
    {
      localObject2 = ((d.l.b.a.b.f.a)localObject2).fGX().qV();
      d.g.b.k.g(localObject2, "classId.relativeClassName.asString()");
      localObject2 = d.n.n.a((String)localObject2, '.', '$');
      localObject1 = new StringBuilder().append((String)localObject1).append((String)localObject2).toString();
      AppMethodBeat.o(56350);
      return localObject1;
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "constructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "objectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflection"})
  public final class a
    extends i.b
  {
    private final z.a JiJ;
    private final z.a JiK;
    final z.a JiL;
    final z.a JiM;
    final z.a JiN;
    private final z.a JiO;
    private final z.b JiP;
    private final z.a JiQ;
    private final z.a JiR;
    private final z.a JiS;
    private final z.a JiT;
    private final z.a JiU;
    private final z.a JiV;
    private final z.a JiW;
    final z.a JiX;
    final z.a JiY;
    private final z.a JiZ;
    private final z.a Jja;
    
    static
    {
      AppMethodBeat.i(56326);
      $$delegatedProperties = new d.l.k[] { (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(a.class), "annotations", "getAnnotations()Ljava/util/List;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;")) };
      AppMethodBeat.o(56326);
    }
    
    public a()
    {
      super();
      AppMethodBeat.i(56329);
      this.JiJ = z.G((d.g.a.a)new i(this));
      this.JiK = z.G((d.g.a.a)new d(this));
      this.JiL = z.G((d.g.a.a)new p(this));
      this.JiM = z.G((d.g.a.a)new n(this));
      this.JiN = z.G((d.g.a.a)new e(this));
      this.JiO = z.G((d.g.a.a)new l(this));
      this.JiP = z.F((d.g.a.a)new m(this));
      this.JiQ = z.G((d.g.a.a)new r(this));
      this.JiR = z.G((d.g.a.a)new q(this));
      this.JiS = z.G((d.g.a.a)new o(this));
      this.JiT = z.G((d.g.a.a)new g(this));
      this.JiU = z.G((d.g.a.a)new h(this));
      this.JiV = z.G((d.g.a.a)new j(this));
      this.JiW = z.G((d.g.a.a)new k(this));
      this.JiX = z.G((d.g.a.a)new b(this));
      this.JiY = z.G((d.g.a.a)new c(this));
      this.JiZ = z.G((d.g.a.a)new f(this));
      this.Jja = z.G((d.g.a.a)new a(this));
      AppMethodBeat.o(56329);
    }
    
    public final d.l.b.a.b.b.e fwo()
    {
      AppMethodBeat.i(56327);
      d.l.b.a.b.b.e locale = (d.l.b.a.b.b.e)this.JiJ.invoke();
      AppMethodBeat.o(56327);
      return locale;
    }
    
    public final Collection<e<?>> fws()
    {
      AppMethodBeat.i(56328);
      Collection localCollection = (Collection)this.JiT.invoke();
      AppMethodBeat.o(56328);
      return localCollection;
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<List<? extends e<?>>>
    {
      a(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<List<? extends e<?>>>
    {
      b(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<List<? extends e<?>>>
    {
      c(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "", "T", "", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<List<? extends Annotation>>
    {
      d(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "Lkotlin/reflect/KFunction;", "T", "", "invoke"})
    static final class e
      extends d.g.b.l
      implements d.g.a.a<List<? extends d.l.e<? extends T>>>
    {
      e(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class f
      extends d.g.b.l
      implements d.g.a.a<List<? extends e<?>>>
    {
      f(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class g
      extends d.g.b.l
      implements d.g.a.a<Collection<? extends e<?>>>
    {
      g(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class h
      extends d.g.b.l
      implements d.g.a.a<Collection<? extends e<?>>>
    {
      h(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "T", "", "invoke"})
    static final class i
      extends d.g.b.l
      implements d.g.a.a<d.l.b.a.b.b.e>
    {
      i(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class j
      extends d.g.b.l
      implements d.g.a.a<Collection<? extends e<?>>>
    {
      j(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class k
      extends d.g.b.l
      implements d.g.a.a<Collection<? extends e<?>>>
    {
      k(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "", "kotlin.jvm.PlatformType", "T", "invoke"})
    static final class l
      extends d.g.b.l
      implements d.g.a.a<List<? extends g<? extends Object>>>
    {
      l(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"})
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
        Object localObject = this.Jjc.fwo();
        if (((d.l.b.a.b.b.e)localObject).fxu() != d.l.b.a.b.b.f.Jqi)
        {
          AppMethodBeat.o(56318);
          return null;
        }
        if (((d.l.b.a.b.b.e)localObject).fxy())
        {
          d.l.b.a.b.a.c localc = d.l.b.a.b.a.c.Jlx;
          if (d.l.b.a.b.a.c.b((d.l.b.a.b.b.e)localObject)) {}
        }
        for (localObject = this.Jjc.Jjb.Jhj.getEnclosingClass().getDeclaredField(((d.l.b.a.b.b.e)localObject).fyB().qV());; localObject = this.Jjc.Jjb.Jhj.getDeclaredField("INSTANCE"))
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
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "T", "", "invoke"})
    static final class n
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      n(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"})
    static final class o
      extends d.g.b.l
      implements d.g.a.a<List<? extends g<? extends T>>>
    {
      o(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "T", "", "invoke"})
    static final class p
      extends d.g.b.l
      implements d.g.a.a<String>
    {
      p(g.a parama)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "T", "", "invoke"})
    static final class q
      extends d.g.b.l
      implements d.g.a.a<List<? extends u>>
    {
      q(g.a parama)
      {
        super();
      }
      
      @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "Ljava/lang/reflect/Type;", "T", "", "invoke", "kotlin/reflect/jvm/internal/KClassImpl$Data$supertypes$2$1$1"})
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
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "T", "", "invoke"})
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
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.g
 * JD-Core Version:    0.7.0.1
 */