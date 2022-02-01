package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.a.c;
import kotlin.l.b.a.b.b.ao;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.e.c.a.d.a;
import kotlin.l.o;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "V", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "_javaField", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Ljava/lang/reflect/Field;", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "isBound", "", "()Z", "isConst", "isLateinit", "isSuspend", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "getName", "()Ljava/lang/String;", "getSignature", "computeDelegateField", "equals", "other", "getDelegate", "field", "receiver", "hashCode", "", "toString", "Accessor", "Companion", "Getter", "Setter", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public abstract class t<V>
  extends f<V>
  implements o<V>
{
  private static final Object aizR = new Object();
  public static final t.b aizS = new t.b((byte)0);
  final j aixX;
  private final ac.b<Field> aizP;
  private final ac.a<ap> aizQ;
  private final Object aizl;
  final String name;
  final String signature;
  
  public t(j paramj, String paramString1, String paramString2, Object paramObject)
  {
    this(paramj, paramString1, paramString2, null, paramObject);
  }
  
  private t(j paramj, String paramString1, String paramString2, ap paramap, Object paramObject)
  {
    this.aixX = paramj;
    this.name = paramString1;
    this.signature = paramString2;
    this.aizl = paramObject;
    paramj = ac.co((a)new f(this));
    s.s(paramj, "ReflectProperties.lazy {…y -> null\n        }\n    }");
    this.aizP = paramj;
    paramj = ac.d(paramap, (a)new e(this));
    s.s(paramj, "ReflectProperties.lazySo…or(name, signature)\n    }");
    this.aizQ = paramj;
  }
  
  public t(j paramj, ap paramap)
  {
    this(paramj, str, ag.c(paramap).PF(), paramap, kotlin.g.b.f.aiwK);
  }
  
  protected final Object a(Field paramField, Object paramObject)
  {
    try
    {
      if ((paramObject == aizR) && (kmt().knY() == null)) {
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
    paramObject = ai.hP(paramObject);
    if (paramObject == null) {}
    while ((!s.p(this.aixX, paramObject.aixX)) || (!s.p(this.name, paramObject.name)) || (!s.p(this.signature, paramObject.signature)) || (!s.p(this.aizl, paramObject.aizl))) {
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
    return (this.aixX.hashCode() * 31 + this.name.hashCode()) * 31 + this.signature.hashCode();
  }
  
  public final boolean isBound()
  {
    return s.p(this.aizl, kotlin.g.b.f.aiwK) ^ true;
  }
  
  public final kotlin.l.b.a.a.d<?> klW()
  {
    return kmo().klW();
  }
  
  public final kotlin.l.b.a.a.d<?> klX()
  {
    kmo();
    return null;
  }
  
  public final j klY()
  {
    return this.aixX;
  }
  
  public final Object kln()
  {
    return kotlin.l.b.a.a.h.a(this.aizl, (kotlin.l.b.a.b.b.b)kmt());
  }
  
  public abstract c<V> kmo();
  
  public final Field kmr()
  {
    return (Field)this.aizP.invoke();
  }
  
  protected final Field kms()
  {
    if (kmt().kpy()) {
      return kmr();
    }
    return null;
  }
  
  public final ap kmt()
  {
    Object localObject = this.aizQ.invoke();
    s.s(localObject, "_descriptor()");
    return (ap)localObject;
  }
  
  public String toString()
  {
    ae localae = ae.aiAr;
    return ae.b(kmt());
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "()V", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static abstract class a<PropertyType, ReturnType>
    extends f<ReturnType>
    implements kotlin.l.f<ReturnType>
  {
    public final boolean isBound()
    {
      return kmj().isBound();
    }
    
    public final kotlin.l.b.a.a.d<?> klX()
    {
      return null;
    }
    
    public final j klY()
    {
      return kmj().aixX;
    }
    
    public abstract t<PropertyType> kmj();
    
    public abstract ao kmu();
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static abstract class c<V>
    extends t.a<V, V>
    implements kotlin.l.p<V>
  {
    private final ac.a aiyz = ac.cp((a)new b(this));
    private final ac.b aizj = ac.co((a)new a(this));
    
    private aq kmv()
    {
      return (aq)this.aiyz.invoke();
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof c)) && (s.p(kmj(), ((c)paramObject).kmj()));
    }
    
    public final String getName()
    {
      return "<get-" + kmj().name + '>';
    }
    
    public int hashCode()
    {
      return kmj().hashCode();
    }
    
    public final kotlin.l.b.a.a.d<?> klW()
    {
      return (kotlin.l.b.a.a.d)this.aizj.invoke();
    }
    
    public String toString()
    {
      return "getter of " + kmj();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "kotlin.jvm.PlatformType", "V", "invoke"}, k=3, mv={1, 5, 1})
    static final class a
      extends u
      implements a<kotlin.l.b.a.a.d<?>>
    {
      a(t.c paramc)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "kotlin.jvm.PlatformType", "V", "invoke"}, k=3, mv={1, 5, 1})
    static final class b
      extends u
      implements a<aq>
    {
      b(t.c paramc)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static abstract class d<V>
    extends t.a<V, ah>
    implements kotlin.l.h<V>
  {
    private final ac.a aiyz = ac.cp((a)new b(this));
    private final ac.b aizj = ac.co((a)new a(this));
    
    private ar kmw()
    {
      return (ar)this.aiyz.invoke();
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof d)) && (s.p(kmj(), ((d)paramObject).kmj()));
    }
    
    public final String getName()
    {
      return "<set-" + kmj().name + '>';
    }
    
    public int hashCode()
    {
      return kmj().hashCode();
    }
    
    public final kotlin.l.b.a.a.d<?> klW()
    {
      return (kotlin.l.b.a.a.d)this.aizj.invoke();
    }
    
    public String toString()
    {
      return "setter of " + kmj();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "kotlin.jvm.PlatformType", "V", "invoke"}, k=3, mv={1, 5, 1})
    static final class a
      extends u
      implements a<kotlin.l.b.a.a.d<?>>
    {
      a(t.d paramd)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "kotlin.jvm.PlatformType", "V", "invoke"}, k=3, mv={1, 5, 1})
    static final class b
      extends u
      implements a<ar>
    {
      b(t.d paramd)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin.jvm.PlatformType", "V", "invoke"}, k=3, mv={1, 5, 1})
  static final class e
    extends u
    implements a<ap>
  {
    e(t paramt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/lang/reflect/Field;", "V", "invoke"}, k=3, mv={1, 5, 1})
  static final class f
    extends u
    implements a<Field>
  {
    f(t paramt)
    {
      super();
    }
    
    private Field jZb()
    {
      Object localObject3 = null;
      AppMethodBeat.i(56479);
      Object localObject1 = ag.aiAv;
      localObject1 = ag.c(this.aizV.kmt());
      ap localap;
      Object localObject4;
      Object localObject5;
      int i;
      if ((localObject1 instanceof e.c))
      {
        localap = ((e.c)localObject1).aiyh;
        localObject4 = kotlin.l.b.a.b.e.c.a.g.ajem;
        localObject4 = kotlin.l.b.a.b.e.c.a.g.a(((e.c)localObject1).aiyi, ((e.c)localObject1).aiyk, ((e.c)localObject1).aiyl);
        if (localObject4 != null)
        {
          if (localap == null) {
            kotlin.l.b.a.b.d.a.j.aKu(0);
          }
          if (localap.koh() != b.a.aiGm)
          {
            localObject5 = localap.knp();
            if (localObject5 == null) {
              kotlin.l.b.a.b.d.a.j.aKu(1);
            }
            if ((kotlin.l.b.a.b.j.d.u((l)localObject5)) && (kotlin.l.b.a.b.j.d.B(((l)localObject5).knp())))
            {
              localObject5 = (kotlin.l.b.a.b.b.e)localObject5;
              if (localObject5 == null) {
                kotlin.l.b.a.b.d.a.j.aKu(2);
              }
              if (!kotlin.l.b.a.b.a.d.a(c.aiBl, (kotlin.l.b.a.b.b.e)localObject5)) {
                i = 1;
              }
            }
          }
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          i = 1;
          label171:
          if ((i == 0) && (!kotlin.l.b.a.b.e.c.a.g.f(((e.c)localObject1).aiyi))) {
            break label328;
          }
          localObject1 = this.aizV.aixX.kls().getEnclosingClass();
          label202:
          if (localObject1 == null) {
            break label368;
          }
        }
        try
        {
          label323:
          label328:
          label368:
          for (localObject1 = ((Class)localObject1).getDeclaredField(((d.a)localObject4).name);; localObject1 = null)
          {
            AppMethodBeat.o(56479);
            return localObject1;
            i = 0;
            break;
            if (kotlin.l.b.a.b.j.d.u(localap.knp()))
            {
              if (localap == null) {
                kotlin.l.b.a.b.d.a.j.aKu(3);
              }
              if ((localap instanceof ap))
              {
                localObject5 = ((ap)localap).kpg();
                if ((localObject5 == null) || (!((kotlin.l.b.a.b.b.v)localObject5).knl().i(kotlin.l.b.a.b.d.a.v.aiPr))) {}
              }
              for (boolean bool = true;; bool = localap.knl().i(kotlin.l.b.a.b.d.a.v.aiPr))
              {
                if (!bool) {
                  break label323;
                }
                i = 1;
                break;
              }
            }
            i = 0;
            break label171;
            localObject1 = localap.knp();
            if ((localObject1 instanceof kotlin.l.b.a.b.b.e))
            {
              localObject1 = ai.b((kotlin.l.b.a.b.b.e)localObject1);
              break label202;
            }
            localObject1 = this.aizV.aixX.kls();
            break label202;
          }
          AppMethodBeat.o(56479);
          return null;
          if ((localObject1 instanceof e.a))
          {
            localObject1 = ((e.a)localObject1).dEn;
            AppMethodBeat.o(56479);
            return localObject1;
          }
          if ((localObject1 instanceof e.b))
          {
            AppMethodBeat.o(56479);
            return null;
          }
          if ((localObject1 instanceof e.d))
          {
            AppMethodBeat.o(56479);
            return null;
          }
          localObject1 = new kotlin.p();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.t
 * JD-Core Version:    0.7.0.1
 */