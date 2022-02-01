package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.a.m;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.c.a.d;
import kotlin.l.b.a.b.e.a.k;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.e.a.s;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.b.g;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.e;
import kotlin.l.b.a.b.h.r;
import kotlin.l.b.a.b.j.g.h;
import kotlin.l.b.a.b.k.a.v;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KPackageImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "jClass", "Ljava/lang/Class;", "usageModuleName", "", "(Ljava/lang/Class;Ljava/lang/String;)V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "kotlin.jvm.PlatformType", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "methodOwner", "getMethodOwner", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "getUsageModuleName", "()Ljava/lang/String;", "equals", "", "other", "", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "toString", "Data", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public final class o
  extends j
{
  final Class<?> aiwN;
  private final ac.b<a> aiyy;
  private final String aizu;
  
  public o(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(56432);
    this.aiwN = paramClass;
    this.aizu = paramString;
    paramClass = ac.co((kotlin.g.a.a)new b(this));
    s.s(paramClass, "ReflectProperties.lazy { Data() }");
    this.aiyy = paramClass;
    AppMethodBeat.o(56432);
  }
  
  private final h kml()
  {
    AppMethodBeat.i(56425);
    h localh = ((a)this.aiyy.invoke()).kml();
    AppMethodBeat.o(56425);
    return localh;
  }
  
  public final Collection<ap> a(kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(56426);
    s.u(paramf, "name");
    paramf = kml().a(paramf, (kotlin.l.b.a.b.c.a.b)d.aiNC);
    AppMethodBeat.o(56426);
    return paramf;
  }
  
  public final ap aKt(int paramInt)
  {
    AppMethodBeat.i(56428);
    Object localObject2 = (kotlin.u)((a)this.aiyy.invoke()).aizy.invoke();
    if (localObject2 != null)
    {
      Object localObject3 = (kotlin.l.b.a.b.e.c.a.f)((kotlin.u)localObject2).bsC;
      Object localObject1 = (a.k)((kotlin.u)localObject2).bsD;
      localObject2 = (kotlin.l.b.a.b.e.c.a.e)((kotlin.u)localObject2).aiuN;
      Object localObject4 = (i.c)localObject1;
      Object localObject5 = kotlin.l.b.a.b.e.c.a.ajdw;
      s.s(localObject5, "JvmProtoBuf.packageLocalVariable");
      localObject5 = (a.m)kotlin.l.b.a.b.e.b.e.a((i.c)localObject4, (i.e)localObject5, paramInt);
      if (localObject5 != null)
      {
        localObject4 = this.aiwN;
        localObject5 = (r)localObject5;
        localObject3 = (c)localObject3;
        localObject1 = ((a.k)localObject1).aiYZ;
        s.s(localObject1, "packageProto.typeTable");
        localObject1 = (ap)ai.a((Class)localObject4, (r)localObject5, (c)localObject3, new g((a.s)localObject1), (kotlin.l.b.a.b.e.b.a)localObject2, (m)c.aizC);
        AppMethodBeat.o(56428);
        return localObject1;
      }
      AppMethodBeat.o(56428);
      return null;
    }
    AppMethodBeat.o(56428);
    return null;
  }
  
  public final Collection<x> b(kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(56427);
    s.u(paramf, "name");
    paramf = kml().b(paramf, (kotlin.l.b.a.b.c.a.b)d.aiNC);
    AppMethodBeat.o(56427);
    return paramf;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56429);
    if (((paramObject instanceof o)) && (s.p(this.aiwN, ((o)paramObject).aiwN)))
    {
      AppMethodBeat.o(56429);
      return true;
    }
    AppMethodBeat.o(56429);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56430);
    int i = this.aiwN.hashCode();
    AppMethodBeat.o(56430);
    return i;
  }
  
  public final Collection<k> klT()
  {
    return (Collection)ab.aivy;
  }
  
  public final Class<?> kls()
  {
    return this.aiwN;
  }
  
  protected final Class<?> kmf()
  {
    AppMethodBeat.i(56424);
    Class localClass2 = (Class)((a)this.aiyy.invoke()).aizx.invoke();
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = this.aiwN;
    }
    AppMethodBeat.o(56424);
    return localClass1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56431);
    String str = "file class " + kotlin.l.b.a.b.b.e.b.b.cM(this.aiwN).kxQ();
    AppMethodBeat.o(56431);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KPackageImpl;)V", "kotlinClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/ReflectKotlinClass;", "getKotlinClass", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", "kotlinClass$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "members", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getMembers", "()Ljava/util/Collection;", "members$delegate", "metadata", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "getMetadata", "()Lkotlin/Triple;", "metadata$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "multifileFacade", "Ljava/lang/Class;", "getMultifileFacade", "()Ljava/lang/Class;", "multifileFacade$delegate", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope$delegate", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  final class a
    extends j.b
  {
    private final ac.a aizv;
    private final ac.a aizw;
    final ac.b aizx;
    final ac.b aizy;
    private final ac.a aizz;
    
    static
    {
      AppMethodBeat.i(56416);
      aYe = new kotlin.l.o[] { (kotlin.l.o)kotlin.g.b.ai.a(new ag(kotlin.g.b.ai.cz(a.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), (kotlin.l.o)kotlin.g.b.ai.a(new ag(kotlin.g.b.ai.cz(a.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), (kotlin.l.o)kotlin.g.b.ai.a(new ag(kotlin.g.b.ai.cz(a.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), (kotlin.l.o)kotlin.g.b.ai.a(new ag(kotlin.g.b.ai.cz(a.class), "metadata", "getMetadata()Lkotlin/Triple;")), (kotlin.l.o)kotlin.g.b.ai.a(new ag(kotlin.g.b.ai.cz(a.class), "members", "getMembers()Ljava/util/Collection;")) };
      AppMethodBeat.o(56416);
    }
    
    public a()
    {
      super();
      AppMethodBeat.i(56418);
      this.aizv = ac.cp((kotlin.g.a.a)new a(this));
      this.aizw = ac.cp((kotlin.g.a.a)new e(this));
      this.aizx = ac.co((kotlin.g.a.a)new d(this));
      this.aizy = ac.co((kotlin.g.a.a)new c(this));
      this.aizz = ac.cp((kotlin.g.a.a)new b(this));
      AppMethodBeat.o(56418);
    }
    
    public final h kml()
    {
      AppMethodBeat.i(56417);
      h localh = (h)this.aizw.invoke();
      AppMethodBeat.o(56417);
      return localh;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/ReflectKotlinClass;", "invoke"}, k=3, mv={1, 5, 1})
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<kotlin.l.b.a.b.b.e.a.f>
    {
      a(o.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<Collection<? extends f<?>>>
    {
      b(o.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "invoke"}, k=3, mv={1, 5, 1})
    static final class c
      extends kotlin.g.b.u
      implements kotlin.g.a.a<kotlin.u<? extends kotlin.l.b.a.b.e.c.a.f, ? extends a.k, ? extends kotlin.l.b.a.b.e.c.a.e>>
    {
      c(o.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Ljava/lang/Class;", "invoke"}, k=3, mv={1, 5, 1})
    static final class d
      extends kotlin.g.b.u
      implements kotlin.g.a.a<Class<?>>
    {
      d(o.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
    static final class e
      extends kotlin.g.b.u
      implements kotlin.g.a.a<h>
    {
      e(o.a parama)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KPackageImpl;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<o.a>
  {
    b(o paramo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.o
 * JD-Core Version:    0.7.0.1
 */