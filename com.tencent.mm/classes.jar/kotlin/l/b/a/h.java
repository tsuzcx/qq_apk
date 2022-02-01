package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.a.i;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.e;
import kotlin.l.b.a.b.h.r;
import kotlin.l.b.a.b.k.a.l;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;
import kotlin.l.o;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isFun", "isInner", "isOpen", "isSealed", "isValue", "isValue$annotations", "()V", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflection", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public final class h<T>
  extends j
  implements z, kotlin.l.c<T>
{
  final Class<T> aiwN;
  final ac.b<h<T>.a> aiyy;
  
  public h(Class<T> paramClass)
  {
    AppMethodBeat.i(56351);
    this.aiwN = paramClass;
    paramClass = ac.co((kotlin.g.a.a)new b(this));
    s.s(paramClass, "ReflectProperties.lazy { Data() }");
    this.aiyy = paramClass;
    AppMethodBeat.o(56351);
  }
  
  private kotlin.l.b.a.b.b.e kma()
  {
    AppMethodBeat.i(56339);
    kotlin.l.b.a.b.b.e locale = ((a)this.aiyy.invoke()).kma();
    AppMethodBeat.o(56339);
    return locale;
  }
  
  private final kotlin.l.b.a.b.f.b kmb()
  {
    AppMethodBeat.i(56340);
    Object localObject1 = ag.aiAv;
    localObject1 = this.aiwN;
    s.u(localObject1, "klass");
    if (((Class)localObject1).isArray())
    {
      localObject1 = ((Class)localObject1).getComponentType();
      s.s(localObject1, "klass.componentType");
      localObject1 = ag.cD((Class)localObject1);
      if (localObject1 != null)
      {
        localObject1 = new kotlin.l.b.a.b.f.b(kotlin.l.b.a.b.a.k.aiCr, ((i)localObject1).aiBD);
        AppMethodBeat.o(56340);
        return localObject1;
      }
      localObject1 = kotlin.l.b.a.b.f.b.s(k.a.aiCF.kxX());
      s.s(localObject1, "ClassId.topLevel(Standar…s.FqNames.array.toSafe())");
      AppMethodBeat.o(56340);
      return localObject1;
    }
    if (s.p(localObject1, Void.TYPE))
    {
      localObject1 = ag.aiAu;
      AppMethodBeat.o(56340);
      return localObject1;
    }
    Object localObject2 = ag.cD((Class)localObject1);
    if (localObject2 != null)
    {
      localObject1 = new kotlin.l.b.a.b.f.b(kotlin.l.b.a.b.a.k.aiCr, ((i)localObject2).aiBC);
      AppMethodBeat.o(56340);
      return localObject1;
    }
    localObject1 = kotlin.l.b.a.b.b.e.b.b.cM((Class)localObject1);
    if (!((kotlin.l.b.a.b.f.b)localObject1).NIH)
    {
      localObject2 = kotlin.l.b.a.b.a.b.c.aiEX;
      localObject2 = ((kotlin.l.b.a.b.f.b)localObject1).kxQ();
      s.s(localObject2, "classId.asSingleFqName()");
      localObject2 = kotlin.l.b.a.b.a.b.c.c((kotlin.l.b.a.b.f.c)localObject2);
      if (localObject2 != null)
      {
        AppMethodBeat.o(56340);
        return localObject2;
      }
    }
    AppMethodBeat.o(56340);
    return localObject1;
  }
  
  public final Collection<ap> a(kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(56344);
    s.u(paramf, "name");
    paramf = (Collection)kotlin.a.p.b(kmc().a(paramf, (kotlin.l.b.a.b.c.a.b)kotlin.l.b.a.b.c.a.d.aiNC), (Iterable)kmd().a(paramf, (kotlin.l.b.a.b.c.a.b)kotlin.l.b.a.b.c.a.d.aiNC));
    AppMethodBeat.o(56344);
    return paramf;
  }
  
  public final ap aKt(int paramInt)
  {
    AppMethodBeat.i(56346);
    for (Object localObject1 = this; s.p(((h)localObject1).aiwN.getSimpleName(), "DefaultImpls"); localObject1 = (h)localObject1)
    {
      localObject2 = ((h)localObject1).aiwN.getDeclaringClass();
      if ((localObject2 == null) || (!((Class)localObject2).isInterface())) {
        break;
      }
      localObject1 = kotlin.g.a.cx((Class)localObject2);
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        AppMethodBeat.o(56346);
        throw ((Throwable)localObject1);
      }
    }
    Object localObject3 = ((h)localObject1).kma();
    Object localObject2 = localObject3;
    if (!(localObject3 instanceof kotlin.l.b.a.b.k.a.b.e)) {
      localObject2 = null;
    }
    localObject2 = (kotlin.l.b.a.b.k.a.b.e)localObject2;
    if (localObject2 != null)
    {
      localObject3 = (i.c)((kotlin.l.b.a.b.k.a.b.e)localObject2).ajlM;
      i.e locale = kotlin.l.b.a.b.e.c.a.ajds;
      s.s(locale, "JvmProtoBuf.classLocalVariable");
      localObject3 = (a.m)kotlin.l.b.a.b.e.b.e.a((i.c)localObject3, locale, paramInt);
      if (localObject3 != null)
      {
        localObject1 = (ap)ai.a(((h)localObject1).aiwN, (r)localObject3, ((kotlin.l.b.a.b.k.a.b.e)localObject2).ajmz.aiyk, ((kotlin.l.b.a.b.k.a.b.e)localObject2).ajmz.aiyl, ((kotlin.l.b.a.b.k.a.b.e)localObject2).ajlN, (m)c.aiyW);
        AppMethodBeat.o(56346);
        return localObject1;
      }
      AppMethodBeat.o(56346);
      return null;
    }
    AppMethodBeat.o(56346);
    return null;
  }
  
  public final Collection<kotlin.l.b.a.b.b.x> b(kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(56345);
    s.u(paramf, "name");
    paramf = (Collection)kotlin.a.p.b(kmc().b(paramf, (kotlin.l.b.a.b.c.a.b)kotlin.l.b.a.b.c.a.d.aiNC), (Iterable)kmd().b(paramf, (kotlin.l.b.a.b.c.a.b)kotlin.l.b.a.b.c.a.d.aiNC));
    AppMethodBeat.o(56345);
    return paramf;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56348);
    if (((paramObject instanceof h)) && (s.p(kotlin.g.a.d(this), kotlin.g.a.d((kotlin.l.c)paramObject))))
    {
      AppMethodBeat.o(56348);
      return true;
    }
    AppMethodBeat.o(56348);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56349);
    int i = kotlin.g.a.d(this).hashCode();
    AppMethodBeat.o(56349);
    return i;
  }
  
  public final Collection<kotlin.l.b.a.b.b.k> klT()
  {
    AppMethodBeat.i(56343);
    Object localObject = kma();
    if ((((kotlin.l.b.a.b.b.e)localObject).kna() == kotlin.l.b.a.b.b.f.aiGu) || (((kotlin.l.b.a.b.b.e)localObject).kna() == kotlin.l.b.a.b.b.f.aiGy))
    {
      localObject = (Collection)ab.aivy;
      AppMethodBeat.o(56343);
      return localObject;
    }
    localObject = ((kotlin.l.b.a.b.b.e)localObject).klv();
    s.s(localObject, "descriptor.constructors");
    AppMethodBeat.o(56343);
    return localObject;
  }
  
  public final Class<T> kls()
  {
    return this.aiwN;
  }
  
  public final String klt()
  {
    AppMethodBeat.i(191372);
    String str = (String)((a)this.aiyy.invoke()).aiyB.invoke();
    AppMethodBeat.o(191372);
    return str;
  }
  
  public final String klu()
  {
    AppMethodBeat.i(56347);
    String str = (String)((a)this.aiyy.invoke()).aiyC.invoke();
    AppMethodBeat.o(56347);
    return str;
  }
  
  public final Collection<kotlin.l.f<T>> klv()
  {
    AppMethodBeat.i(191378);
    Collection localCollection = (Collection)((a)this.aiyy.invoke()).aiyD.invoke();
    AppMethodBeat.o(191378);
    return localCollection;
  }
  
  public final kotlin.l.b.a.b.j.g.h kmc()
  {
    AppMethodBeat.i(56341);
    kotlin.l.b.a.b.j.g.h localh = kma().koj().knP();
    AppMethodBeat.o(56341);
    return localh;
  }
  
  public final kotlin.l.b.a.b.j.g.h kmd()
  {
    AppMethodBeat.i(56342);
    kotlin.l.b.a.b.j.g.h localh = kma().knq();
    s.s(localh, "descriptor.staticScope");
    AppMethodBeat.o(56342);
    return localh;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56350);
    StringBuilder localStringBuilder = new StringBuilder("class ");
    Object localObject2 = kmb();
    Object localObject1 = ((kotlin.l.b.a.b.f.b)localObject2).kxL();
    s.s(localObject1, "classId.packageFqName");
    if (((kotlin.l.b.a.b.f.c)localObject1).ajex.ajeC.isEmpty()) {}
    for (localObject1 = "";; localObject1 = ((kotlin.l.b.a.b.f.c)localObject1).PF() + ".")
    {
      localObject2 = ((kotlin.l.b.a.b.f.b)localObject2).kxM().PF();
      s.s(localObject2, "classId.relativeClassName.asString()");
      localObject2 = n.a((String)localObject2, '.', '$');
      localObject1 = new StringBuilder().append((String)localObject1).append((String)localObject2).toString();
      AppMethodBeat.o(56350);
      return localObject1;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "getObjectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public final class a
    extends j.b
  {
    private final ac.a aiyA;
    final ac.a aiyB;
    final ac.a aiyC;
    final ac.a aiyD;
    private final ac.a aiyE;
    private final ac.b aiyF;
    private final ac.a aiyG;
    private final ac.a aiyH;
    private final ac.a aiyI;
    private final ac.a aiyJ;
    private final ac.a aiyK;
    private final ac.a aiyL;
    private final ac.a aiyM;
    final ac.a aiyN;
    final ac.a aiyO;
    private final ac.a aiyP;
    private final ac.a aiyQ;
    private final ac.a aiyz;
    
    static
    {
      AppMethodBeat.i(56326);
      aYe = new o[] { (o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(a.class), "annotations", "getAnnotations()Ljava/util/List;")), (o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), (o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), (o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), (o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), (o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), (o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), (o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), (o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), (o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), (o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), (o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), (o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), (o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), (o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), (o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), (o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;")) };
      AppMethodBeat.o(56326);
    }
    
    public a()
    {
      super();
      AppMethodBeat.i(56329);
      this.aiyz = ac.cp((kotlin.g.a.a)new i(this));
      this.aiyA = ac.cp((kotlin.g.a.a)new d(this));
      this.aiyB = ac.cp((kotlin.g.a.a)new p(this));
      this.aiyC = ac.cp((kotlin.g.a.a)new n(this));
      this.aiyD = ac.cp((kotlin.g.a.a)new e(this));
      this.aiyE = ac.cp((kotlin.g.a.a)new l(this));
      this.aiyF = ac.co((kotlin.g.a.a)new m(this));
      this.aiyG = ac.cp((kotlin.g.a.a)new r(this));
      this.aiyH = ac.cp((kotlin.g.a.a)new q(this));
      this.aiyI = ac.cp((kotlin.g.a.a)new o(this));
      this.aiyJ = ac.cp((kotlin.g.a.a)new g(this));
      this.aiyK = ac.cp((kotlin.g.a.a)new h(this));
      this.aiyL = ac.cp((kotlin.g.a.a)new j(this));
      this.aiyM = ac.cp((kotlin.g.a.a)new k(this));
      this.aiyN = ac.cp((kotlin.g.a.a)new b(this));
      this.aiyO = ac.cp((kotlin.g.a.a)new c(this));
      this.aiyP = ac.cp((kotlin.g.a.a)new f(this));
      this.aiyQ = ac.cp((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(56329);
    }
    
    public final kotlin.l.b.a.b.b.e kma()
    {
      AppMethodBeat.i(56327);
      kotlin.l.b.a.b.b.e locale = (kotlin.l.b.a.b.b.e)this.aiyz.invoke();
      AppMethodBeat.o(56327);
      return locale;
    }
    
    public final Collection<f<?>> kme()
    {
      AppMethodBeat.i(56328);
      Collection localCollection = (Collection)this.aiyJ.invoke();
      AppMethodBeat.o(56328);
      return localCollection;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k=3, mv={1, 5, 1})
    static final class a
      extends u
      implements kotlin.g.a.a<List<? extends f<?>>>
    {
      a(h.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k=3, mv={1, 5, 1})
    static final class b
      extends u
      implements kotlin.g.a.a<List<? extends f<?>>>
    {
      b(h.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k=3, mv={1, 5, 1})
    static final class c
      extends u
      implements kotlin.g.a.a<List<? extends f<?>>>
    {
      c(h.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k=3, mv={1, 5, 1})
    static final class d
      extends u
      implements kotlin.g.a.a<List<? extends Annotation>>
    {
      d(h.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/KFunction;", "T", "kotlin.jvm.PlatformType", "", "invoke"}, k=3, mv={1, 5, 1})
    static final class e
      extends u
      implements kotlin.g.a.a<List<? extends kotlin.l.f<? extends T>>>
    {
      e(h.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k=3, mv={1, 5, 1})
    static final class f
      extends u
      implements kotlin.g.a.a<List<? extends f<?>>>
    {
      f(h.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k=3, mv={1, 5, 1})
    static final class g
      extends u
      implements kotlin.g.a.a<Collection<? extends f<?>>>
    {
      g(h.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k=3, mv={1, 5, 1})
    static final class h
      extends u
      implements kotlin.g.a.a<Collection<? extends f<?>>>
    {
      h(h.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k=3, mv={1, 5, 1})
    static final class i
      extends u
      implements kotlin.g.a.a<kotlin.l.b.a.b.b.e>
    {
      i(h.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k=3, mv={1, 5, 1})
    static final class j
      extends u
      implements kotlin.g.a.a<Collection<? extends f<?>>>
    {
      j(h.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k=3, mv={1, 5, 1})
    static final class k
      extends u
      implements kotlin.g.a.a<Collection<? extends f<?>>>
    {
      k(h.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "", "kotlin.jvm.PlatformType", "T", "invoke"}, k=3, mv={1, 5, 1})
    static final class l
      extends u
      implements kotlin.g.a.a<List<? extends h<? extends Object>>>
    {
      l(h.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
    static final class m
      extends u
      implements kotlin.g.a.a<T>
    {
      m(h.a parama)
      {
        super();
      }
      
      public final T invoke()
      {
        AppMethodBeat.i(56318);
        Object localObject = this.aiyS.kma();
        if (((kotlin.l.b.a.b.b.e)localObject).kna() != kotlin.l.b.a.b.b.f.aiGy)
        {
          AppMethodBeat.o(56318);
          return null;
        }
        if ((((kotlin.l.b.a.b.b.e)localObject).knd()) && (!kotlin.l.b.a.b.a.d.a(kotlin.l.b.a.b.a.c.aiBl, (kotlin.l.b.a.b.b.e)localObject))) {}
        for (localObject = this.aiyS.aiyR.aiwN.getEnclosingClass().getDeclaredField(((kotlin.l.b.a.b.b.e)localObject).kok().PF());; localObject = this.aiyS.aiyR.aiwN.getDeclaredField("INSTANCE"))
        {
          localObject = ((Field)localObject).get(null);
          if (localObject != null) {
            break;
          }
          localObject = new NullPointerException("null cannot be cast to non-null type T");
          AppMethodBeat.o(56318);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(56318);
        return localObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "", "invoke"}, k=3, mv={1, 5, 1})
    static final class n
      extends u
      implements kotlin.g.a.a<String>
    {
      n(h.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "kotlin.jvm.PlatformType", "", "invoke"}, k=3, mv={1, 5, 1})
    static final class o
      extends u
      implements kotlin.g.a.a<List<? extends h<? extends T>>>
    {
      o(h.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "", "invoke"}, k=3, mv={1, 5, 1})
    static final class p
      extends u
      implements kotlin.g.a.a<String>
    {
      p(h.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k=3, mv={1, 5, 1})
    static final class q
      extends u
      implements kotlin.g.a.a<List<? extends v>>
    {
      q(h.a parama)
      {
        super();
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", "Ljava/lang/reflect/Type;", "T", "", "invoke", "kotlin/reflect/jvm/internal/KClassImpl$Data$supertypes$2$1$1"}, k=3, mv={1, 5, 1})
      static final class a
        extends u
        implements kotlin.g.a.a<Type>
      {
        a(ad paramad, h.a.q paramq)
        {
          super();
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k=3, mv={1, 5, 1})
    static final class r
      extends u
      implements kotlin.g.a.a<List<? extends x>>
    {
      r(h.a parama)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "kotlin.jvm.PlatformType", "", "invoke"}, k=3, mv={1, 5, 1})
  static final class b
    extends u
    implements kotlin.g.a.a<h<T>.a>
  {
    b(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.h
 * JD-Core Version:    0.7.0.1
 */