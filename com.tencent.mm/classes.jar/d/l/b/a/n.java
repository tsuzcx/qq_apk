package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.a.m;
import d.g.b.j;
import d.g.b.u;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.d.b.b;
import d.l.b.a.b.e.a.k;
import d.l.b.a.b.e.a.m;
import d.l.b.a.b.e.a.s;
import d.l.b.a.b.e.c.a.g;
import d.l.b.a.b.h.i.c;
import d.l.b.a.b.h.i.f;
import d.l.b.a.b.h.q;
import d.l.d;
import java.util.Collection;

@d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/KPackageImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "jClass", "Ljava/lang/Class;", "usageModuleName", "", "(Ljava/lang/Class;Ljava/lang/String;)V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "kotlin.jvm.PlatformType", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "methodOwner", "getMethodOwner", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "getUsageModuleName", "()Ljava/lang/String;", "equals", "", "other", "", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "toString", "Data", "kotlin-reflection"})
public final class n
  extends i
{
  final Class<?> KUC;
  private final String KWZ;
  private final z.b<a> KWc;
  
  public n(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(56432);
    this.KUC = paramClass;
    this.KWZ = paramString;
    paramClass = z.M((d.g.a.a)new b(this));
    d.g.b.k.g(paramClass, "ReflectProperties.lazy { Data() }");
    this.KWc = paramClass;
    AppMethodBeat.o(56432);
  }
  
  private final d.l.b.a.b.j.f.h fPd()
  {
    AppMethodBeat.i(56425);
    d.l.b.a.b.j.f.h localh = ((a)this.KWc.invoke()).fPd();
    AppMethodBeat.o(56425);
    return localh;
  }
  
  public final Collection<ah> a(d.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(56426);
    d.g.b.k.h(paramf, "name");
    paramf = fPd().a(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.LjZ);
    AppMethodBeat.o(56426);
    return paramf;
  }
  
  public final ah agK(int paramInt)
  {
    AppMethodBeat.i(56428);
    Object localObject2 = (d.t)((a)this.KWc.invoke()).KXd.invoke();
    if (localObject2 != null)
    {
      Object localObject3 = (g)((d.t)localObject2).first;
      Object localObject1 = (a.k)((d.t)localObject2).second;
      localObject2 = (d.l.b.a.b.e.c.a.f)((d.t)localObject2).KTn;
      Object localObject4 = (i.c)localObject1;
      Object localObject5 = d.l.b.a.b.e.c.a.Lyo;
      d.g.b.k.g(localObject5, "JvmProtoBuf.packageLocalVariable");
      localObject5 = (a.m)d.l.b.a.b.e.b.f.a((i.c)localObject4, (i.f)localObject5, paramInt);
      if (localObject5 != null)
      {
        localObject4 = this.KUC;
        localObject5 = (q)localObject5;
        localObject3 = (d.l.b.a.b.e.b.c)localObject3;
        localObject1 = ((a.k)localObject1).Luc;
        d.g.b.k.g(localObject1, "packageProto.typeTable");
        localObject1 = (ah)af.a((Class)localObject4, (q)localObject5, (d.l.b.a.b.e.b.c)localObject3, new d.l.b.a.b.e.b.h((a.s)localObject1), (d.l.b.a.b.e.b.a)localObject2, (m)c.KXh);
        AppMethodBeat.o(56428);
        return localObject1;
      }
      AppMethodBeat.o(56428);
      return null;
    }
    AppMethodBeat.o(56428);
    return null;
  }
  
  public final Collection<d.l.b.a.b.b.t> b(d.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(56427);
    d.g.b.k.h(paramf, "name");
    paramf = fPd().b(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.LjZ);
    AppMethodBeat.o(56427);
    return paramf;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56429);
    if (((paramObject instanceof n)) && (d.g.b.k.g(this.KUC, ((n)paramObject).KUC)))
    {
      AppMethodBeat.o(56429);
      return true;
    }
    AppMethodBeat.o(56429);
    return false;
  }
  
  public final Collection<d.l.b.a.b.b.k> fOL()
  {
    return (Collection)v.KTF;
  }
  
  protected final Class<?> fOX()
  {
    AppMethodBeat.i(56424);
    Class localClass2 = (Class)((a)this.KWc.invoke()).KXc.invoke();
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = this.KUC;
    }
    AppMethodBeat.o(56424);
    return localClass1;
  }
  
  public final Class<?> fOt()
  {
    return this.KUC;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56430);
    int i = this.KUC.hashCode();
    AppMethodBeat.o(56430);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56431);
    String str = "file class " + b.bz(this.KUC).fZF();
    AppMethodBeat.o(56431);
    return str;
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KPackageImpl;)V", "kotlinClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/ReflectKotlinClass;", "getKotlinClass", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", "kotlinClass$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "members", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getMembers", "()Ljava/util/Collection;", "members$delegate", "metadata", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "getMetadata", "()Lkotlin/Triple;", "metadata$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "multifileFacade", "Ljava/lang/Class;", "getMultifileFacade", "()Ljava/lang/Class;", "multifileFacade$delegate", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope$delegate", "kotlin-reflection"})
  final class a
    extends i.b
  {
    private final z.a KXa;
    private final z.a KXb;
    final z.b KXc;
    final z.b KXd;
    private final z.a KXe;
    
    static
    {
      AppMethodBeat.i(56416);
      $$delegatedProperties = new d.l.k[] { (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(a.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(a.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(a.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(a.class), "metadata", "getMetadata()Lkotlin/Triple;")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bn(a.class), "members", "getMembers()Ljava/util/Collection;")) };
      AppMethodBeat.o(56416);
    }
    
    public a()
    {
      super();
      AppMethodBeat.i(56418);
      this.KXa = z.N((d.g.a.a)new a(this));
      this.KXb = z.N((d.g.a.a)new e(this));
      this.KXc = z.M((d.g.a.a)new d(this));
      this.KXd = z.M((d.g.a.a)new c(this));
      this.KXe = z.N((d.g.a.a)new b(this));
      AppMethodBeat.o(56418);
    }
    
    public final d.l.b.a.b.j.f.h fPd()
    {
      AppMethodBeat.i(56417);
      d.l.b.a.b.j.f.h localh = (d.l.b.a.b.j.f.h)this.KXb.invoke();
      AppMethodBeat.o(56417);
      return localh;
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/ReflectKotlinClass;", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<d.l.b.a.b.b.d.a.f>
    {
      a(n.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<Collection<? extends e<?>>>
    {
      b(n.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<d.t<? extends g, ? extends a.k, ? extends d.l.b.a.b.e.c.a.f>>
    {
      c(n.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Ljava/lang/Class;", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<Class<?>>
    {
      d(n.a parama)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "invoke"})
    static final class e
      extends d.g.b.l
      implements d.g.a.a<d.l.b.a.b.j.f.h>
    {
      e(n.a parama)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KPackageImpl;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<n.a>
  {
    b(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.n
 * JD-Core Version:    0.7.0.1
 */