package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.b.a.a.h;
import kotlin.l.b.a.b.b.ag;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.b.aj;
import kotlin.l.b.a.b.d.a.o;
import kotlin.l.b.a.b.e.c.a.e.a;
import kotlin.l.f.a;
import kotlin.l.k;
import kotlin.l.k.a;
import kotlin.m;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "R", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "_javaField", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Ljava/lang/reflect/Field;", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "isBound", "", "()Z", "isConst", "isLateinit", "isSuspend", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "getName", "()Ljava/lang/String;", "getSignature", "computeDelegateField", "equals", "other", "getDelegate", "field", "receiver", "hashCode", "", "toString", "Accessor", "Companion", "Getter", "Setter", "kotlin-reflection"})
public abstract class r<R>
  extends e<R>
  implements k<R>
{
  private static final Object Tbg = new Object();
  public static final r.b Tbh = new r.b((byte)0);
  final i TaI;
  private final Object TaJ;
  private final y.b<Field> Tbe;
  private final y.a<ah> Tbf;
  final String name;
  final String signature;
  
  public r(i parami, String paramString1, String paramString2, Object paramObject)
  {
    this(parami, paramString1, paramString2, null, paramObject);
  }
  
  private r(i parami, String paramString1, String paramString2, ah paramah, Object paramObject)
  {
    this.TaI = parami;
    this.name = paramString1;
    this.signature = paramString2;
    this.TaJ = paramObject;
    parami = y.aj((a)new f(this));
    p.g(parami, "ReflectProperties.lazy {…y -> null\n        }\n    }");
    this.Tbe = parami;
    parami = y.a(paramah, (a)new e(this));
    p.g(parami, "ReflectProperties.lazySo…or(name, signature)\n    }");
    this.Tbf = parami;
  }
  
  public r(i parami, ah paramah)
  {
    this(parami, str, ac.c(paramah).sG(), paramah, kotlin.g.b.e.SYm);
  }
  
  protected final Object a(Field paramField, Object paramObject)
  {
    try
    {
      if ((paramObject == Tbg) && (hyO().hAr() == null)) {
        throw ((Throwable)new RuntimeException("'" + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead"));
      }
    }
    catch (IllegalAccessException paramField)
    {
      throw ((Throwable)new kotlin.l.a.b(paramField));
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
    paramObject = ae.fi(paramObject);
    if (paramObject == null) {}
    while ((!p.j(this.TaI, paramObject.TaI)) || (!p.j(this.name, paramObject.name)) || (!p.j(this.signature, paramObject.signature)) || (!p.j(this.TaJ, paramObject.TaJ))) {
      return false;
    }
    return true;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    return (this.TaI.hashCode() * 31 + this.name.hashCode()) * 31 + this.signature.hashCode();
  }
  
  public final Object hxQ()
  {
    return h.a(this.TaJ, (kotlin.l.b.a.b.b.b)hyO());
  }
  
  public abstract c<R> hyJ();
  
  public final Field hyM()
  {
    return (Field)this.Tbe.invoke();
  }
  
  protected final Field hyN()
  {
    if (hyO().hBJ()) {
      return hyM();
    }
    return null;
  }
  
  public final ah hyO()
  {
    Object localObject = this.Tbf.invoke();
    p.g(localObject, "_descriptor()");
    return (ah)localObject;
  }
  
  public final kotlin.l.b.a.a.d<?> hyt()
  {
    return hyJ().hyt();
  }
  
  public final kotlin.l.b.a.a.d<?> hyu()
  {
    hyJ();
    return null;
  }
  
  public final i hyv()
  {
    return this.TaI;
  }
  
  public final boolean isBound()
  {
    return p.j(this.TaJ, kotlin.g.b.e.SYm) ^ true;
  }
  
  public String toString()
  {
    aa localaa = aa.TbF;
    return aa.b(hyO());
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "()V", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "kotlin-reflection"})
  public static abstract class a<PropertyType, ReturnType>
    extends e<ReturnType>
    implements kotlin.l.e<ReturnType>
  {
    public abstract r<PropertyType> hyF();
    
    public abstract ag hyP();
    
    public final kotlin.l.b.a.a.d<?> hyu()
    {
      return null;
    }
    
    public final i hyv()
    {
      return hyF().TaI;
    }
    
    public final boolean isBound()
    {
      return hyF().isBound();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflection"})
  public static abstract class c<R>
    extends r.a<R, R>
    implements k.a<R>
  {
    private final y.a SZW = y.ak((a)new b(this));
    private final y.b TaG = y.aj((a)new a(this));
    
    private ai hyQ()
    {
      return (ai)this.SZW.invoke();
    }
    
    public final String getName()
    {
      return "<get-" + hyF().name + '>';
    }
    
    public final kotlin.l.b.a.a.d<?> hyt()
    {
      return (kotlin.l.b.a.a.d)this.TaG.invoke();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "R", "invoke"})
    static final class a
      extends q
      implements a<kotlin.l.b.a.a.d<?>>
    {
      a(r.c paramc)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "R", "invoke"})
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflection"})
  public static abstract class d<R>
    extends r.a<R, x>
    implements f.a<R>
  {
    private final y.a SZW = y.ak((a)new b(this));
    private final y.b TaG = y.aj((a)new a(this));
    
    private aj hyR()
    {
      return (aj)this.SZW.invoke();
    }
    
    public final String getName()
    {
      return "<set-" + hyF().name + '>';
    }
    
    public final kotlin.l.b.a.a.d<?> hyt()
    {
      return (kotlin.l.b.a.a.d)this.TaG.invoke();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "R", "invoke"})
    static final class a
      extends q
      implements a<kotlin.l.b.a.a.d<?>>
    {
      a(r.d paramd)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "R", "invoke"})
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "R", "invoke"})
  static final class e
    extends q
    implements a<ah>
  {
    e(r paramr)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/lang/reflect/Field;", "R", "invoke"})
  static final class f
    extends q
    implements a<Field>
  {
    f(r paramr)
    {
      super();
    }
    
    private Field hyS()
    {
      Object localObject3 = null;
      AppMethodBeat.i(56479);
      Object localObject1 = ac.TbJ;
      localObject1 = ac.c(this.Tbk.hyO());
      ah localah;
      Object localObject4;
      if ((localObject1 instanceof d.c))
      {
        localah = ((d.c)localObject1).SZE;
        localObject4 = kotlin.l.b.a.b.e.c.a.i.TCN;
        localObject4 = kotlin.l.b.a.b.e.c.a.i.a(((d.c)localObject1).SZF, ((d.c)localObject1).SZH, ((d.c)localObject1).SZI);
        if (localObject4 != null) {
          if ((o.d(localah)) || (kotlin.l.b.a.b.e.c.a.i.f(((d.c)localObject1).SZF))) {
            localObject1 = this.Tbk.TaI.hxU().getEnclosingClass();
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
            localObject1 = localah.hzx();
            if ((localObject1 instanceof kotlin.l.b.a.b.b.e))
            {
              localObject1 = ae.a((kotlin.l.b.a.b.b.e)localObject1);
              break;
            }
            localObject1 = this.Tbk.TaI.hxU();
            break;
          }
          AppMethodBeat.o(56479);
          return null;
          if ((localObject1 instanceof d.a))
          {
            localObject1 = ((d.a)localObject1).bUo;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.r
 * JD-Core Version:    0.7.0.1
 */