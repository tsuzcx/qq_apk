package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.h.h.a;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.d;
import kotlin.l.b.a.b.h.i.e;
import kotlin.l.b.a.b.h.r;
import kotlin.l.b.a.b.k.a.w;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.d;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isInner", "isOpen", "isSealed", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflection", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflection"})
public final class g<T>
  extends i
  implements kotlin.l.b<T>
{
  final Class<T> aaBb;
  public final y.b<g<T>.a> aaCP;
  
  public g(Class<T> paramClass)
  {
    AppMethodBeat.i(56351);
    this.aaBb = paramClass;
    paramClass = y.at((kotlin.g.a.a)new b(this));
    p.j(paramClass, "ReflectProperties.lazy { Data() }");
    this.aaCP = paramClass;
    AppMethodBeat.o(56351);
  }
  
  private kotlin.l.b.a.b.b.e iCI()
  {
    AppMethodBeat.i(56339);
    kotlin.l.b.a.b.b.e locale = ((a)this.aaCP.invoke()).iCI();
    AppMethodBeat.o(56339);
    return locale;
  }
  
  private final kotlin.l.b.a.b.f.a iCJ()
  {
    AppMethodBeat.i(56340);
    Object localObject1 = ac.aaED;
    localObject1 = this.aaBb;
    p.k(localObject1, "klass");
    if (((Class)localObject1).isArray())
    {
      localObject1 = ((Class)localObject1).getComponentType();
      p.j(localObject1, "klass.componentType");
      localObject1 = ac.bS((Class)localObject1);
      if (localObject1 != null)
      {
        localObject1 = new kotlin.l.b.a.b.f.a(kotlin.l.b.a.b.a.g.aaFx, ((kotlin.l.b.a.b.a.h)localObject1).iDG());
        AppMethodBeat.o(56340);
        return localObject1;
      }
      localObject1 = kotlin.l.b.a.b.f.a.p(kotlin.l.b.a.b.a.g.aaFI.aaFT.iND());
      p.j(localObject1, "ClassId.topLevel(KotlinB….FQ_NAMES.array.toSafe())");
      AppMethodBeat.o(56340);
      return localObject1;
    }
    if (p.h(localObject1, Void.TYPE))
    {
      localObject1 = ac.aaEC;
      AppMethodBeat.o(56340);
      return localObject1;
    }
    Object localObject2 = ac.bS((Class)localObject1);
    if (localObject2 != null)
    {
      localObject1 = new kotlin.l.b.a.b.f.a(kotlin.l.b.a.b.a.g.aaFx, ((kotlin.l.b.a.b.a.h)localObject2).iDF());
      AppMethodBeat.o(56340);
      return localObject1;
    }
    localObject1 = kotlin.l.b.a.b.b.d.b.b.ca((Class)localObject1);
    if (!((kotlin.l.b.a.b.f.a)localObject1).HLG)
    {
      localObject2 = kotlin.l.b.a.b.a.b.c.aaIT;
      localObject2 = ((kotlin.l.b.a.b.f.a)localObject1).iNx();
      p.j(localObject2, "classId.asSingleFqName()");
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
    p.k(paramf, "name");
    paramf = (Collection)j.b(iCK().a(paramf, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.aaQD), (Iterable)iCL().a(paramf, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.aaQD));
    AppMethodBeat.o(56344);
    return paramf;
  }
  
  public final ah aDF(int paramInt)
  {
    AppMethodBeat.i(56346);
    for (Object localObject1 = this; p.h(((g)localObject1).aaBb.getSimpleName(), "DefaultImpls"); localObject1 = (g)localObject1)
    {
      localObject2 = ((g)localObject1).aaBb.getDeclaringClass();
      if ((localObject2 == null) || (!((Class)localObject2).isInterface())) {
        break;
      }
      localObject1 = kotlin.g.a.bN((Class)localObject2);
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        AppMethodBeat.o(56346);
        throw ((Throwable)localObject1);
      }
    }
    Object localObject3 = ((g)localObject1).iCI();
    Object localObject2 = localObject3;
    if (!(localObject3 instanceof kotlin.l.b.a.b.k.a.b.e)) {
      localObject2 = null;
    }
    localObject3 = (kotlin.l.b.a.b.k.a.b.e)localObject2;
    if (localObject3 != null)
    {
      Object localObject4 = (i.c)((kotlin.l.b.a.b.k.a.b.e)localObject3).abnd;
      localObject2 = kotlin.l.b.a.b.e.c.a.abeG;
      p.j(localObject2, "JvmProtoBuf.classLocalVariable");
      p.k(localObject4, "$this$getExtensionOrNull");
      p.k(localObject2, "extension");
      ((i.c)localObject4).b((i.e)localObject2);
      Object localObject5 = ((i.c)localObject4).abgm;
      i.d locald = ((i.e)localObject2).abgv;
      if (!locald.Hp())
      {
        localObject1 = new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        AppMethodBeat.o(56346);
        throw ((Throwable)localObject1);
      }
      localObject5 = ((kotlin.l.b.a.b.h.h)localObject5).b(locald);
      int i;
      if (localObject5 == null) {
        i = 0;
      }
      for (;;)
      {
        if (paramInt < i)
        {
          ((i.c)localObject4).b((i.e)localObject2);
          localObject4 = ((i.c)localObject4).abgm;
          localObject5 = ((i.e)localObject2).abgv;
          if (!((h.a)localObject5).Hp())
          {
            localObject1 = new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
            AppMethodBeat.o(56346);
            throw ((Throwable)localObject1);
            i = ((List)localObject5).size();
          }
          else
          {
            localObject4 = ((kotlin.l.b.a.b.h.h)localObject4).b((h.a)localObject5);
            if (localObject4 == null)
            {
              localObject1 = new IndexOutOfBoundsException();
              AppMethodBeat.o(56346);
              throw ((Throwable)localObject1);
            }
          }
        }
      }
      for (localObject2 = ((i.e)localObject2).fC(((List)localObject4).get(paramInt));; localObject2 = null)
      {
        localObject2 = (a.m)localObject2;
        if (localObject2 == null) {
          break;
        }
        localObject1 = (ah)ae.a(((g)localObject1).aaBb, (r)localObject2, ((kotlin.l.b.a.b.k.a.b.e)localObject3).abnP.aaCB, ((kotlin.l.b.a.b.k.a.b.e)localObject3).abnP.aaCC, ((kotlin.l.b.a.b.k.a.b.e)localObject3).abne, (m)c.aaDn);
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
    p.k(paramf, "name");
    paramf = (Collection)j.b(iCK().b(paramf, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.aaQD), (Iterable)iCL().b(paramf, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.aaQD));
    AppMethodBeat.o(56345);
    return paramf;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56348);
    if (((paramObject instanceof g)) && (p.h(kotlin.g.a.c(this), kotlin.g.a.c((kotlin.l.b)paramObject))))
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
    int i = kotlin.g.a.c(this).hashCode();
    AppMethodBeat.o(56349);
    return i;
  }
  
  public final Collection<k> iCB()
  {
    AppMethodBeat.i(56343);
    Object localObject = iCI();
    if ((((kotlin.l.b.a.b.b.e)localObject).iDN() == kotlin.l.b.a.b.b.f.aaJZ) || (((kotlin.l.b.a.b.b.e)localObject).iDN() == kotlin.l.b.a.b.b.f.aaKd))
    {
      localObject = (Collection)kotlin.a.v.aaAd;
      AppMethodBeat.o(56343);
      return localObject;
    }
    localObject = ((kotlin.l.b.a.b.b.e)localObject).iCg();
    p.j(localObject, "descriptor.constructors");
    AppMethodBeat.o(56343);
    return localObject;
  }
  
  public final kotlin.l.b.a.b.j.f.h iCK()
  {
    AppMethodBeat.i(56341);
    kotlin.l.b.a.b.j.f.h localh = iCI().iET().iEC();
    AppMethodBeat.o(56341);
    return localh;
  }
  
  public final kotlin.l.b.a.b.j.f.h iCL()
  {
    AppMethodBeat.i(56342);
    kotlin.l.b.a.b.j.f.h localh = iCI().iDK();
    p.j(localh, "descriptor.staticScope");
    AppMethodBeat.o(56342);
    return localh;
  }
  
  public final Class<T> iCd()
  {
    return this.aaBb;
  }
  
  public final String iCe()
  {
    AppMethodBeat.i(245738);
    String str = (String)((a)this.aaCP.invoke()).aaCS.invoke();
    AppMethodBeat.o(245738);
    return str;
  }
  
  public final String iCf()
  {
    AppMethodBeat.i(56347);
    String str = (String)((a)this.aaCP.invoke()).aaCT.invoke();
    AppMethodBeat.o(56347);
    return str;
  }
  
  public final Collection<kotlin.l.e<T>> iCg()
  {
    AppMethodBeat.i(245739);
    Collection localCollection = (Collection)((a)this.aaCP.invoke()).aaCU.invoke();
    AppMethodBeat.o(245739);
    return localCollection;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56350);
    StringBuilder localStringBuilder = new StringBuilder("class ");
    Object localObject2 = iCJ();
    Object localObject1 = ((kotlin.l.b.a.b.f.a)localObject2).iNs();
    p.j(localObject1, "classId.packageFqName");
    if (((kotlin.l.b.a.b.f.b)localObject1).abfE.abfJ.isEmpty()) {}
    for (localObject1 = "";; localObject1 = ((kotlin.l.b.a.b.f.b)localObject1).qu() + ".")
    {
      localObject2 = ((kotlin.l.b.a.b.f.a)localObject2).iNt().qu();
      p.j(localObject2, "classId.relativeClassName.asString()");
      localObject2 = kotlin.n.n.a((String)localObject2, '.', '$');
      localObject1 = new StringBuilder().append((String)localObject1).append((String)localObject2).toString();
      AppMethodBeat.o(56350);
      return localObject1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "constructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "objectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflection"})
  public final class a
    extends i.b
  {
    private final y.a aaCQ;
    private final y.a aaCR;
    final y.a aaCS;
    final y.a aaCT;
    final y.a aaCU;
    private final y.a aaCV;
    private final y.b aaCW;
    private final y.a aaCX;
    private final y.a aaCY;
    private final y.a aaCZ;
    private final y.a aaDa;
    private final y.a aaDb;
    private final y.a aaDc;
    private final y.a aaDd;
    final y.a aaDe;
    final y.a aaDf;
    private final y.a aaDg;
    private final y.a aaDh;
    
    static
    {
      AppMethodBeat.i(56326);
      cMt = new kotlin.l.n[] { (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(a.class), "annotations", "getAnnotations()Ljava/util/List;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;")) };
      AppMethodBeat.o(56326);
    }
    
    public a()
    {
      super();
      AppMethodBeat.i(56329);
      this.aaCQ = y.au((kotlin.g.a.a)new i(this));
      this.aaCR = y.au((kotlin.g.a.a)new d(this));
      this.aaCS = y.au((kotlin.g.a.a)new p(this));
      this.aaCT = y.au((kotlin.g.a.a)new n(this));
      this.aaCU = y.au((kotlin.g.a.a)new e(this));
      this.aaCV = y.au((kotlin.g.a.a)new l(this));
      this.aaCW = y.at((kotlin.g.a.a)new m(this));
      this.aaCX = y.au((kotlin.g.a.a)new r(this));
      this.aaCY = y.au((kotlin.g.a.a)new q(this));
      this.aaCZ = y.au((kotlin.g.a.a)new o(this));
      this.aaDa = y.au((kotlin.g.a.a)new g(this));
      this.aaDb = y.au((kotlin.g.a.a)new h(this));
      this.aaDc = y.au((kotlin.g.a.a)new j(this));
      this.aaDd = y.au((kotlin.g.a.a)new k(this));
      this.aaDe = y.au((kotlin.g.a.a)new b(this));
      this.aaDf = y.au((kotlin.g.a.a)new c(this));
      this.aaDg = y.au((kotlin.g.a.a)new f(this));
      this.aaDh = y.au((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(56329);
    }
    
    public final kotlin.l.b.a.b.b.e iCI()
    {
      AppMethodBeat.i(56327);
      kotlin.l.b.a.b.b.e locale = (kotlin.l.b.a.b.b.e)this.aaCQ.invoke();
      AppMethodBeat.o(56327);
      return locale;
    }
    
    public final Collection<e<?>> iCM()
    {
      AppMethodBeat.i(56328);
      Collection localCollection = (Collection)this.aaDa.invoke();
      AppMethodBeat.o(56328);
      return localCollection;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<List<? extends e<?>>>
    {
      a(g.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<List<? extends e<?>>>
    {
      b(g.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<List<? extends e<?>>>
    {
      c(g.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "T", "", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.a<List<? extends Annotation>>
    {
      d(g.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlin/reflect/KFunction;", "T", "", "invoke"})
    static final class e
      extends q
      implements kotlin.g.a.a<List<? extends kotlin.l.e<? extends T>>>
    {
      e(g.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class f
      extends q
      implements kotlin.g.a.a<List<? extends e<?>>>
    {
      f(g.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class g
      extends q
      implements kotlin.g.a.a<Collection<? extends e<?>>>
    {
      g(g.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class h
      extends q
      implements kotlin.g.a.a<Collection<? extends e<?>>>
    {
      h(g.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "T", "", "invoke"})
    static final class i
      extends q
      implements kotlin.g.a.a<kotlin.l.b.a.b.b.e>
    {
      i(g.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class j
      extends q
      implements kotlin.g.a.a<Collection<? extends e<?>>>
    {
      j(g.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
    static final class k
      extends q
      implements kotlin.g.a.a<Collection<? extends e<?>>>
    {
      k(g.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "", "kotlin.jvm.PlatformType", "T", "invoke"})
    static final class l
      extends q
      implements kotlin.g.a.a<List<? extends g<? extends Object>>>
    {
      l(g.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"})
    static final class m
      extends q
      implements kotlin.g.a.a<T>
    {
      m(g.a parama)
      {
        super();
      }
      
      public final T invoke()
      {
        AppMethodBeat.i(56318);
        Object localObject = this.aaDj.iCI();
        if (((kotlin.l.b.a.b.b.e)localObject).iDN() != kotlin.l.b.a.b.b.f.aaKd)
        {
          AppMethodBeat.o(56318);
          return null;
        }
        if (((kotlin.l.b.a.b.b.e)localObject).iDR())
        {
          kotlin.l.b.a.b.a.c localc = kotlin.l.b.a.b.a.c.aaFt;
          if (kotlin.l.b.a.b.a.c.b((kotlin.l.b.a.b.b.e)localObject)) {}
        }
        for (localObject = this.aaDj.aaDi.aaBb.getEnclosingClass().getDeclaredField(((kotlin.l.b.a.b.b.e)localObject).iEU().qu());; localObject = this.aaDj.aaDi.aaBb.getDeclaredField("INSTANCE"))
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
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "", "invoke"})
    static final class n
      extends q
      implements kotlin.g.a.a<String>
    {
      n(g.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"})
    static final class o
      extends q
      implements kotlin.g.a.a<List<? extends g<? extends T>>>
    {
      o(g.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "", "invoke"})
    static final class p
      extends q
      implements kotlin.g.a.a<String>
    {
      p(g.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "T", "", "invoke"})
    static final class q
      extends q
      implements kotlin.g.a.a<List<? extends t>>
    {
      q(g.a parama)
      {
        super();
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/lang/reflect/Type;", "T", "", "invoke", "kotlin/reflect/jvm/internal/KClassImpl$Data$supertypes$2$1$1"})
      static final class a
        extends q
        implements kotlin.g.a.a<Type>
      {
        a(kotlin.l.b.a.b.m.ab paramab, g.a.q paramq)
        {
          super();
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "T", "", "invoke"})
    static final class r
      extends q
      implements kotlin.g.a.a<List<? extends v>>
    {
      r(g.a parama)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<g<T>.a>
  {
    b(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.g
 * JD-Core Version:    0.7.0.1
 */