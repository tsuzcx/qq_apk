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

@d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "R", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "_javaField", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Ljava/lang/reflect/Field;", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "isBound", "", "()Z", "isConst", "isLateinit", "isSuspend", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "getName", "()Ljava/lang/String;", "getSignature", "computeDelegateField", "equals", "other", "getDelegate", "field", "receiver", "hashCode", "", "toString", "Accessor", "Companion", "Getter", "Setter", "kotlin-reflection"})
public abstract class s<R>
  extends e<R>
  implements d.l.k<R>
{
  private static final Object KXw = new Object();
  public static final b KXx = new b((byte)0);
  final i KWP;
  private final Object KWQ;
  private final z.b<Field> KXu;
  private final z.a<ah> KXv;
  final String name;
  final String signature;
  
  public s(i parami, ah paramah)
  {
    this(parami, str, ad.c(paramah).rf(), paramah, c.KUA);
  }
  
  private s(i parami, String paramString1, String paramString2, ah paramah, Object paramObject)
  {
    this.KWP = parami;
    this.name = paramString1;
    this.signature = paramString2;
    this.KWQ = paramObject;
    parami = z.M((a)new f(this));
    d.g.b.k.g(parami, "ReflectProperties.lazy {…y -> null\n        }\n    }");
    this.KXu = parami;
    parami = z.a(paramah, (a)new e(this));
    d.g.b.k.g(parami, "ReflectProperties.lazySo…or(name, signature)\n    }");
    this.KXv = parami;
  }
  
  public s(i parami, String paramString1, String paramString2, Object paramObject)
  {
    this(parami, paramString1, paramString2, null, paramObject);
  }
  
  protected final Object a(Field paramField, Object paramObject)
  {
    try
    {
      if ((paramObject == KXw) && (fPl().fQP() == null)) {
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
    paramObject = af.eY(paramObject);
    if (paramObject == null) {}
    while ((!d.g.b.k.g(this.KWP, paramObject.KWP)) || (!d.g.b.k.g(this.name, paramObject.name)) || (!d.g.b.k.g(this.signature, paramObject.signature)) || (!d.g.b.k.g(this.KWQ, paramObject.KWQ))) {
      return false;
    }
    return true;
  }
  
  public final d.l.b.a.a.d<?> fOO()
  {
    return fPg().fOO();
  }
  
  public final d.l.b.a.a.d<?> fOP()
  {
    fPg();
    return null;
  }
  
  public final i fOQ()
  {
    return this.KWP;
  }
  
  public final Object fOp()
  {
    return h.a(this.KWQ, (d.l.b.a.b.b.b)fPl());
  }
  
  public abstract c<R> fPg();
  
  public final Field fPj()
  {
    return (Field)this.KXu.invoke();
  }
  
  protected final Field fPk()
  {
    if (fPl().fSg()) {
      return fPj();
    }
    return null;
  }
  
  public final ah fPl()
  {
    Object localObject = this.KXv.invoke();
    d.g.b.k.g(localObject, "_descriptor()");
    return (ah)localObject;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    return (this.KWP.hashCode() * 31 + this.name.hashCode()) * 31 + this.signature.hashCode();
  }
  
  public final boolean isBound()
  {
    return d.g.b.k.g(this.KWQ, c.KUA) ^ true;
  }
  
  public String toString()
  {
    ab localab = ab.KXV;
    return ab.b(fPl());
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "()V", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "kotlin-reflection"})
  public static abstract class a<PropertyType, ReturnType>
    extends e<ReturnType>
    implements d.l.e<ReturnType>
  {
    public final d.l.b.a.a.d<?> fOP()
    {
      return null;
    }
    
    public final i fOQ()
    {
      return fPb().KWP;
    }
    
    public abstract s<PropertyType> fPb();
    
    public abstract ag fPm();
    
    public final boolean isBound()
    {
      return fPb().isBound();
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Companion;", "", "()V", "EXTENSION_PROPERTY_DELEGATE", "getEXTENSION_PROPERTY_DELEGATE", "()Ljava/lang/Object;", "kotlin-reflection"})
  public static final class b {}
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflection"})
  public static abstract class c<R>
    extends s.a<R, R>
    implements k.a<R>
  {
    private final z.b KWN = z.M((a)new a(this));
    private final z.a KWd = z.N((a)new b(this));
    
    private ai fPn()
    {
      return (ai)this.KWd.invoke();
    }
    
    public final d.l.b.a.a.d<?> fOO()
    {
      return (d.l.b.a.a.d)this.KWN.invoke();
    }
    
    public final String getName()
    {
      return "<get-" + fPb().name + '>';
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "R", "invoke"})
    static final class a
      extends d.g.b.l
      implements a<d.l.b.a.a.d<?>>
    {
      a(s.c paramc)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "R", "invoke"})
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
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflection"})
  public static abstract class d<R>
    extends s.a<R, y>
    implements f.a<R>
  {
    private final z.b KWN = z.M((a)new a(this));
    private final z.a KWd = z.N((a)new b(this));
    
    private aj fPo()
    {
      return (aj)this.KWd.invoke();
    }
    
    public final d.l.b.a.a.d<?> fOO()
    {
      return (d.l.b.a.a.d)this.KWN.invoke();
    }
    
    public final String getName()
    {
      return "<set-" + fPb().name + '>';
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "R", "invoke"})
    static final class a
      extends d.g.b.l
      implements a<d.l.b.a.a.d<?>>
    {
      a(s.d paramd)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "R", "invoke"})
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
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "R", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<ah>
  {
    e(s params)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Ljava/lang/reflect/Field;", "R", "invoke"})
  static final class f
    extends d.g.b.l
    implements a<Field>
  {
    f(s params)
    {
      super();
    }
    
    private Field fPp()
    {
      Object localObject3 = null;
      AppMethodBeat.i(56479);
      Object localObject1 = ad.KXZ;
      localObject1 = ad.c(this.KXA.fPl());
      ah localah;
      Object localObject4;
      if ((localObject1 instanceof d.c))
      {
        localah = ((d.c)localObject1).KVL;
        localObject4 = d.l.b.a.b.e.c.a.i.Lzg;
        localObject4 = d.l.b.a.b.e.c.a.i.a(((d.c)localObject1).KVM, ((d.c)localObject1).KVO, ((d.c)localObject1).KVP);
        if (localObject4 != null) {
          if ((o.d(localah)) || (d.l.b.a.b.e.c.a.i.f(((d.c)localObject1).KVM))) {
            localObject1 = this.KXA.KWP.fOt().getEnclosingClass();
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
            localObject1 = localah.fPU();
            if ((localObject1 instanceof d.l.b.a.b.b.e))
            {
              localObject1 = af.a((d.l.b.a.b.b.e)localObject1);
              break;
            }
            localObject1 = this.KXA.KWP.fOt();
            break;
          }
          AppMethodBeat.o(56479);
          return null;
          if ((localObject1 instanceof d.a))
          {
            localObject1 = ((d.a)localObject1).bCy;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.s
 * JD-Core Version:    0.7.0.1
 */