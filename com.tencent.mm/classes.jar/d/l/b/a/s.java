package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.c;
import d.l.b.a.a.h;
import d.l.b.a.b.b.ag;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.ai;
import d.l.b.a.b.b.aj;
import d.l.b.a.b.d.a.o;
import d.l.b.a.b.e.c.a.e.a;
import d.l.f.a;
import d.l.k.a;
import d.m;
import d.y;
import java.lang.reflect.Field;

@d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "R", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "_javaField", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Ljava/lang/reflect/Field;", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "isBound", "", "()Z", "isConst", "isLateinit", "isSuspend", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "getName", "()Ljava/lang/String;", "getSignature", "computeDelegateField", "equals", "other", "getDelegate", "field", "receiver", "hashCode", "", "toString", "Accessor", "Companion", "Getter", "Setter", "kotlin-reflection"})
public abstract class s<R>
  extends e<R>
  implements d.l.k<R>
{
  private static final Object Jkc = new Object();
  public static final s.b Jkd = new s.b((byte)0);
  final i Jjv;
  private final Object Jjw;
  private final z.b<Field> Jka;
  private final z.a<ah> Jkb;
  final String name;
  final String signature;
  
  public s(i parami, ah paramah)
  {
    this(parami, str, ad.c(paramah).qV(), paramah, c.Jhh);
  }
  
  private s(i parami, String paramString1, String paramString2, ah paramah, Object paramObject)
  {
    this.Jjv = parami;
    this.name = paramString1;
    this.signature = paramString2;
    this.Jjw = paramObject;
    parami = z.F((a)new f(this));
    d.g.b.k.g(parami, "ReflectProperties.lazy {…y -> null\n        }\n    }");
    this.Jka = parami;
    parami = z.a(paramah, (a)new e(this));
    d.g.b.k.g(parami, "ReflectProperties.lazySo…or(name, signature)\n    }");
    this.Jkb = parami;
  }
  
  public s(i parami, String paramString1, String paramString2, Object paramObject)
  {
    this(parami, paramString1, paramString2, null, paramObject);
  }
  
  protected final Object a(Field paramField, Object paramObject)
  {
    try
    {
      if ((paramObject == Jkc) && (fwH().fyl() == null)) {
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
    paramObject = af.eV(paramObject);
    if (paramObject == null) {}
    while ((!d.g.b.k.g(this.Jjv, paramObject.Jjv)) || (!d.g.b.k.g(this.name, paramObject.name)) || (!d.g.b.k.g(this.signature, paramObject.signature)) || (!d.g.b.k.g(this.Jjw, paramObject.Jjw))) {
      return false;
    }
    return true;
  }
  
  public final Object fvL()
  {
    return h.a(this.Jjw, (d.l.b.a.b.b.b)fwH());
  }
  
  public abstract c<R> fwC();
  
  public final Field fwF()
  {
    return (Field)this.Jka.invoke();
  }
  
  protected final Field fwG()
  {
    if (fwH().fzC()) {
      return fwF();
    }
    return null;
  }
  
  public final ah fwH()
  {
    Object localObject = this.Jkb.invoke();
    d.g.b.k.g(localObject, "_descriptor()");
    return (ah)localObject;
  }
  
  public final d.l.b.a.a.d<?> fwk()
  {
    return fwC().fwk();
  }
  
  public final d.l.b.a.a.d<?> fwl()
  {
    fwC();
    return null;
  }
  
  public final i fwm()
  {
    return this.Jjv;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    return (this.Jjv.hashCode() * 31 + this.name.hashCode()) * 31 + this.signature.hashCode();
  }
  
  public final boolean isBound()
  {
    return d.g.b.k.g(this.Jjw, c.Jhh) ^ true;
  }
  
  public String toString()
  {
    ab localab = ab.JkB;
    return ab.b(fwH());
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "()V", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "kotlin-reflection"})
  public static abstract class a<PropertyType, ReturnType>
    extends e<ReturnType>
    implements d.l.e<ReturnType>
  {
    public abstract ag fwI();
    
    public final d.l.b.a.a.d<?> fwl()
    {
      return null;
    }
    
    public final i fwm()
    {
      return fwx().Jjv;
    }
    
    public abstract s<PropertyType> fwx();
    
    public final boolean isBound()
    {
      return fwx().isBound();
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflection"})
  public static abstract class c<R>
    extends s.a<R, R>
    implements k.a<R>
  {
    private final z.a JiJ = z.G((a)new b(this));
    private final z.b Jjt = z.F((a)new a(this));
    
    private ai fwJ()
    {
      return (ai)this.JiJ.invoke();
    }
    
    public final d.l.b.a.a.d<?> fwk()
    {
      return (d.l.b.a.a.d)this.Jjt.invoke();
    }
    
    public final String getName()
    {
      return "<get-" + fwx().name + '>';
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "R", "invoke"})
    static final class a
      extends d.g.b.l
      implements a<d.l.b.a.a.d<?>>
    {
      a(s.c paramc)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "R", "invoke"})
    static final class b
      extends d.g.b.l
      implements a<ai>
    {
      b(s.c paramc)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflection"})
  public static abstract class d<R>
    extends s.a<R, y>
    implements f.a<R>
  {
    private final z.a JiJ = z.G((a)new b(this));
    private final z.b Jjt = z.F((a)new a(this));
    
    private aj fwK()
    {
      return (aj)this.JiJ.invoke();
    }
    
    public final d.l.b.a.a.d<?> fwk()
    {
      return (d.l.b.a.a.d)this.Jjt.invoke();
    }
    
    public final String getName()
    {
      return "<set-" + fwx().name + '>';
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "R", "invoke"})
    static final class a
      extends d.g.b.l
      implements a<d.l.b.a.a.d<?>>
    {
      a(s.d paramd)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "R", "invoke"})
    static final class b
      extends d.g.b.l
      implements a<aj>
    {
      b(s.d paramd)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "R", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<ah>
  {
    e(s params)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "Ljava/lang/reflect/Field;", "R", "invoke"})
  static final class f
    extends d.g.b.l
    implements a<Field>
  {
    f(s params)
    {
      super();
    }
    
    private Field fwL()
    {
      Object localObject3 = null;
      AppMethodBeat.i(56479);
      Object localObject1 = ad.JkF;
      localObject1 = ad.c(this.Jkg.fwH());
      ah localah;
      Object localObject4;
      if ((localObject1 instanceof d.c))
      {
        localah = ((d.c)localObject1).Jir;
        localObject4 = d.l.b.a.b.e.c.a.i.JLN;
        localObject4 = d.l.b.a.b.e.c.a.i.a(((d.c)localObject1).Jis, ((d.c)localObject1).Jiu, ((d.c)localObject1).Jiv);
        if (localObject4 != null) {
          if ((o.d(localah)) || (d.l.b.a.b.e.c.a.i.f(((d.c)localObject1).Jis))) {
            localObject1 = this.Jkg.Jjv.fvP().getEnclosingClass();
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
            localObject1 = localah.fxq();
            if ((localObject1 instanceof d.l.b.a.b.b.e))
            {
              localObject1 = af.a((d.l.b.a.b.b.e)localObject1);
              break;
            }
            localObject1 = this.Jkg.Jjv.fvP();
            break;
          }
          AppMethodBeat.o(56479);
          return null;
          if ((localObject1 instanceof d.a))
          {
            localObject1 = ((d.a)localObject1).bEQ;
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
 * Qualified Name:     d.l.b.a.s
 * JD-Core Version:    0.7.0.1
 */