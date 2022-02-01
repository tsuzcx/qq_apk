package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.l.b.a.a.h;
import d.l.b.a.b.b.ag;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.ai;
import d.l.b.a.b.b.aj;
import d.l.b.a.b.d.a.o;
import d.l.b.a.b.e.c.a.e.a;
import d.l.f.a;
import d.l.k;
import d.l.k.a;
import d.m;
import d.z;
import java.lang.reflect.Field;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "R", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "_javaField", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Ljava/lang/reflect/Field;", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "isBound", "", "()Z", "isConst", "isLateinit", "isSuspend", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "getName", "()Ljava/lang/String;", "getSignature", "computeDelegateField", "equals", "other", "getDelegate", "field", "receiver", "hashCode", "", "toString", "Accessor", "Companion", "Getter", "Setter", "kotlin-reflection"})
public abstract class r<R>
  extends e<R>
  implements k<R>
{
  private static final Object MOt = new Object();
  public static final r.b MOu = new r.b((byte)0);
  final i MNV;
  private final Object MNW;
  private final y.b<Field> MOr;
  private final y.a<ah> MOs;
  final String name;
  final String signature;
  
  public r(i parami, ah paramah)
  {
    this(parami, str, ac.c(paramah).sD(), paramah, d.g.b.e.MLB);
  }
  
  private r(i parami, String paramString1, String paramString2, ah paramah, Object paramObject)
  {
    this.MNV = parami;
    this.name = paramString1;
    this.signature = paramString2;
    this.MNW = paramObject;
    parami = y.Q((a)new f(this));
    p.g(parami, "ReflectProperties.lazy {…y -> null\n        }\n    }");
    this.MOr = parami;
    parami = y.a(paramah, (a)new e(this));
    p.g(parami, "ReflectProperties.lazySo…or(name, signature)\n    }");
    this.MOs = parami;
  }
  
  public r(i parami, String paramString1, String paramString2, Object paramObject)
  {
    this(parami, paramString1, paramString2, null, paramObject);
  }
  
  protected final Object a(Field paramField, Object paramObject)
  {
    try
    {
      if ((paramObject == MOt) && (ggJ().gin() == null)) {
        throw ((Throwable)new RuntimeException("'" + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead"));
      }
    }
    catch (IllegalAccessException paramField)
    {
      throw ((Throwable)new d.l.a.b(paramField));
    }
    if (paramField != null)
    {
      paramField = paramField.get(paramObject);
      return paramField;
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = ae.fa(paramObject);
    if (paramObject == null) {}
    while ((!p.i(this.MNV, paramObject.MNV)) || (!p.i(this.name, paramObject.name)) || (!p.i(this.signature, paramObject.signature)) || (!p.i(this.MNW, paramObject.MNW))) {
      return false;
    }
    return true;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final Object gfP()
  {
    return h.a(this.MNW, (d.l.b.a.b.b.b)ggJ());
  }
  
  public abstract c<R> ggE();
  
  public final Field ggH()
  {
    return (Field)this.MOr.invoke();
  }
  
  protected final Field ggI()
  {
    if (ggJ().gjF()) {
      return ggH();
    }
    return null;
  }
  
  public final ah ggJ()
  {
    Object localObject = this.MOs.invoke();
    p.g(localObject, "_descriptor()");
    return (ah)localObject;
  }
  
  public final d.l.b.a.a.d<?> ggo()
  {
    return ggE().ggo();
  }
  
  public final d.l.b.a.a.d<?> ggp()
  {
    ggE();
    return null;
  }
  
  public final i ggq()
  {
    return this.MNV;
  }
  
  public int hashCode()
  {
    return (this.MNV.hashCode() * 31 + this.name.hashCode()) * 31 + this.signature.hashCode();
  }
  
  public final boolean isBound()
  {
    return p.i(this.MNW, d.g.b.e.MLB) ^ true;
  }
  
  public String toString()
  {
    aa localaa = aa.MOS;
    return aa.b(ggJ());
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "()V", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "kotlin-reflection"})
  public static abstract class a<PropertyType, ReturnType>
    extends e<ReturnType>
    implements d.l.e<ReturnType>
  {
    public abstract r<PropertyType> ggA();
    
    public abstract ag ggK();
    
    public final d.l.b.a.a.d<?> ggp()
    {
      return null;
    }
    
    public final i ggq()
    {
      return ggA().MNV;
    }
    
    public final boolean isBound()
    {
      return ggA().isBound();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflection"})
  public static abstract class c<R>
    extends r.a<R, R>
    implements k.a<R>
  {
    private final y.b MNT = y.Q((a)new a(this));
    private final y.a MNj = y.R((a)new b(this));
    
    private ai ggL()
    {
      return (ai)this.MNj.invoke();
    }
    
    public final String getName()
    {
      return "<get-" + ggA().name + '>';
    }
    
    public final d.l.b.a.a.d<?> ggo()
    {
      return (d.l.b.a.a.d)this.MNT.invoke();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "R", "invoke"})
    static final class a
      extends q
      implements a<d.l.b.a.a.d<?>>
    {
      a(r.c paramc)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "R", "invoke"})
    static final class b
      extends q
      implements a<ai>
    {
      b(r.c paramc)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflection"})
  public static abstract class d<R>
    extends r.a<R, z>
    implements f.a<R>
  {
    private final y.b MNT = y.Q((a)new a(this));
    private final y.a MNj = y.R((a)new b(this));
    
    private aj ggM()
    {
      return (aj)this.MNj.invoke();
    }
    
    public final String getName()
    {
      return "<set-" + ggA().name + '>';
    }
    
    public final d.l.b.a.a.d<?> ggo()
    {
      return (d.l.b.a.a.d)this.MNT.invoke();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "R", "invoke"})
    static final class a
      extends q
      implements a<d.l.b.a.a.d<?>>
    {
      a(r.d paramd)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "R", "invoke"})
    static final class b
      extends q
      implements a<aj>
    {
      b(r.d paramd)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "R", "invoke"})
  static final class e
    extends q
    implements a<ah>
  {
    e(r paramr)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/lang/reflect/Field;", "R", "invoke"})
  static final class f
    extends q
    implements a<Field>
  {
    f(r paramr)
    {
      super();
    }
    
    private Field ggN()
    {
      Object localObject3 = null;
      AppMethodBeat.i(56479);
      Object localObject1 = ac.MOW;
      localObject1 = ac.c(this.MOx.ggJ());
      ah localah;
      Object localObject4;
      if ((localObject1 instanceof d.c))
      {
        localah = ((d.c)localObject1).MMR;
        localObject4 = d.l.b.a.b.e.c.a.i.Nqd;
        localObject4 = d.l.b.a.b.e.c.a.i.a(((d.c)localObject1).MMS, ((d.c)localObject1).MMU, ((d.c)localObject1).MMV);
        if (localObject4 != null) {
          if ((o.d(localah)) || (d.l.b.a.b.e.c.a.i.f(((d.c)localObject1).MMS))) {
            localObject1 = this.MOx.MNV.gfT().getEnclosingClass();
          }
        }
      }
      for (;;)
      {
        if (localObject1 != null) {}
        try
        {
          for (localObject1 = ((Class)localObject1).getDeclaredField(((e.a)localObject4).name);; localObject1 = null)
          {
            AppMethodBeat.o(56479);
            return localObject1;
            localObject1 = localah.ghs();
            if ((localObject1 instanceof d.l.b.a.b.b.e))
            {
              localObject1 = ae.a((d.l.b.a.b.b.e)localObject1);
              break;
            }
            localObject1 = this.MOx.MNV.gfT();
            break;
          }
          AppMethodBeat.o(56479);
          return null;
          if ((localObject1 instanceof d.a))
          {
            localObject1 = ((d.a)localObject1).bMM;
            AppMethodBeat.o(56479);
            return localObject1;
          }
          if ((localObject1 instanceof d.b))
          {
            AppMethodBeat.o(56479);
            return null;
          }
          if ((localObject1 instanceof d.d))
          {
            AppMethodBeat.o(56479);
            return null;
          }
          localObject1 = new m();
          AppMethodBeat.o(56479);
          throw ((Throwable)localObject1);
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          for (;;)
          {
            Object localObject2 = localObject3;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.r
 * JD-Core Version:    0.7.0.1
 */