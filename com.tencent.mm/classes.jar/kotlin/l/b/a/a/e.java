package kotlin.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.al;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "member", "returnType", "Ljava/lang/reflect/Type;", "instanceClass", "Ljava/lang/Class;", "valueParameterTypes", "", "(Ljava/lang/reflect/Member;Ljava/lang/reflect/Type;Ljava/lang/Class;[Ljava/lang/reflect/Type;)V", "getInstanceClass", "()Ljava/lang/Class;", "getMember", "()Ljava/lang/reflect/Member;", "Ljava/lang/reflect/Member;", "parameterTypes", "", "getParameterTypes", "()Ljava/util/List;", "getReturnType", "()Ljava/lang/reflect/Type;", "checkObjectInstance", "", "obj", "", "AccessorForHiddenBoundConstructor", "AccessorForHiddenConstructor", "BoundConstructor", "Companion", "Constructor", "FieldGetter", "FieldSetter", "Method", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public abstract class e<M extends Member>
  implements d<M>
{
  public static final e.d aiAV = new e.d((byte)0);
  private final M aiAS;
  private final Type aiAT;
  private final Class<?> aiAU;
  private final List<Type> aiAz;
  
  private e(M paramM, Type paramType, Class<?> paramClass, Type[] paramArrayOfType)
  {
    this.aiAS = paramM;
    this.aiAT = paramType;
    this.aiAU = paramClass;
    paramM = this.aiAU;
    if (paramM != null)
    {
      paramType = new al(2);
      paramType.add((Type)paramM);
      paramType.hx(paramArrayOfType);
      paramType = p.listOf((Type[])paramType.toArray(new Type[paramType.hqL.size()]));
      paramM = paramType;
      if (paramType != null) {}
    }
    else
    {
      paramM = k.ae(paramArrayOfType);
    }
    this.aiAz = paramM;
  }
  
  public void aq(Object[] paramArrayOfObject)
  {
    s.u(paramArrayOfObject, "args");
    d.a.a(this, paramArrayOfObject);
  }
  
  protected final void hR(Object paramObject)
  {
    if ((paramObject == null) || (!this.aiAS.getDeclaringClass().isInstance(paramObject))) {
      throw ((Throwable)new IllegalArgumentException("An object member requires the object instance passed as the first argument."));
    }
  }
  
  public final List<Type> kmA()
  {
    return this.aiAz;
  }
  
  public final Class<?> kmB()
  {
    return this.aiAU;
  }
  
  public final M kmy()
  {
    return this.aiAS;
  }
  
  public final Type kmz()
  {
    return this.aiAT;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "constructor", "boundReceiver", "", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class a
    extends e<Constructor<?>>
    implements c
  {
    private final Object aiAW;
    
    public a(Constructor<?> paramConstructor, Object paramObject) {}
    
    public final Object ap(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56590);
      s.u(paramArrayOfObject, "args");
      aq(paramArrayOfObject);
      Constructor localConstructor = (Constructor)kmy();
      al localal = new al(3);
      localal.add(this.aiAW);
      localal.hx(paramArrayOfObject);
      localal.add(null);
      paramArrayOfObject = localConstructor.newInstance(localal.toArray(new Object[localal.hqL.size()]));
      AppMethodBeat.o(56590);
      return paramArrayOfObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class b
    extends e<Constructor<?>>
  {
    public b(Constructor<?> paramConstructor) {}
    
    public final Object ap(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56592);
      s.u(paramArrayOfObject, "args");
      aq(paramArrayOfObject);
      Constructor localConstructor = (Constructor)kmy();
      al localal = new al(2);
      localal.hx(paramArrayOfObject);
      localal.add(null);
      paramArrayOfObject = localConstructor.newInstance(localal.toArray(new Object[localal.hqL.size()]));
      AppMethodBeat.o(56592);
      return paramArrayOfObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "boundReceiver", "", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class c
    extends e<Constructor<?>>
    implements c
  {
    private final Object aiAW;
    
    public c(Constructor<?> paramConstructor, Object paramObject)
    {
      super((Type)localObject, null, paramConstructor, (byte)0);
      AppMethodBeat.i(56595);
      this.aiAW = paramObject;
      AppMethodBeat.o(56595);
    }
    
    public final Object ap(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56594);
      s.u(paramArrayOfObject, "args");
      aq(paramArrayOfObject);
      Constructor localConstructor = (Constructor)kmy();
      al localal = new al(2);
      localal.add(this.aiAW);
      localal.hx(paramArrayOfObject);
      paramArrayOfObject = localConstructor.newInstance(localal.toArray(new Object[localal.hqL.size()]));
      AppMethodBeat.o(56594);
      return paramArrayOfObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class e
    extends e<Constructor<?>>
  {
    public e(Constructor<?> paramConstructor) {}
    
    public final Object ap(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56596);
      s.u(paramArrayOfObject, "args");
      aq(paramArrayOfObject);
      paramArrayOfObject = ((Constructor)kmy()).newInstance(Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length));
      AppMethodBeat.o(56596);
      return paramArrayOfObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "requiresInstance", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoundInstance", "BoundJvmStaticInObject", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundJvmStaticInObject;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static abstract class f
    extends e<Field>
  {
    private f(Field paramField, boolean paramBoolean) {}
    
    public Object ap(Object[] paramArrayOfObject)
    {
      s.u(paramArrayOfObject, "args");
      aq(paramArrayOfObject);
      Field localField = (Field)kmy();
      if (kmB() != null) {}
      for (paramArrayOfObject = k.X(paramArrayOfObject);; paramArrayOfObject = null) {
        return localField.get(paramArrayOfObject);
      }
    }
    
    @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "boundReceiver", "", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
    public static final class a
      extends e.f
      implements c
    {
      private final Object aiAW;
      
      public a(Field paramField, Object paramObject)
      {
        super(false, (byte)0);
        AppMethodBeat.i(56599);
        this.aiAW = paramObject;
        AppMethodBeat.o(56599);
      }
      
      public final Object ap(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56598);
        s.u(paramArrayOfObject, "args");
        aq(paramArrayOfObject);
        paramArrayOfObject = ((Field)kmy()).get(this.aiAW);
        AppMethodBeat.o(56598);
        return paramArrayOfObject;
      }
    }
    
    @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k=1, mv={1, 5, 1})
    public static final class b
      extends e.f
      implements c
    {
      public b(Field paramField)
      {
        super(false, (byte)0);
        AppMethodBeat.i(56600);
        AppMethodBeat.o(56600);
      }
    }
    
    @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k=1, mv={1, 5, 1})
    public static final class c
      extends e.f
    {
      public c(Field paramField)
      {
        super(true, (byte)0);
        AppMethodBeat.i(56601);
        AppMethodBeat.o(56601);
      }
    }
    
    @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflection"}, k=1, mv={1, 5, 1})
    public static final class d
      extends e.f
    {
      public d(Field paramField)
      {
        super(true, (byte)0);
        AppMethodBeat.i(56603);
        AppMethodBeat.o(56603);
      }
      
      public final void aq(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56602);
        s.u(paramArrayOfObject, "args");
        super.aq(paramArrayOfObject);
        hR(k.Y(paramArrayOfObject));
        AppMethodBeat.o(56602);
      }
    }
    
    @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k=1, mv={1, 5, 1})
    public static final class e
      extends e.f
    {
      public e(Field paramField)
      {
        super(false, (byte)0);
        AppMethodBeat.i(56604);
        AppMethodBeat.o(56604);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "notNull", "", "requiresInstance", "(Ljava/lang/reflect/Field;ZZ)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", "", "([Ljava/lang/Object;)V", "BoundInstance", "BoundJvmStaticInObject", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundJvmStaticInObject;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static abstract class g
    extends e<Field>
  {
    private final boolean xkb;
    
    private g(Field paramField, boolean paramBoolean1, boolean paramBoolean2) {}
    
    public Object ap(Object[] paramArrayOfObject)
    {
      s.u(paramArrayOfObject, "args");
      aq(paramArrayOfObject);
      Field localField = (Field)kmy();
      if (kmB() != null) {}
      for (Object localObject = k.X(paramArrayOfObject);; localObject = null)
      {
        localField.set(localObject, k.Z(paramArrayOfObject));
        return ah.aiuX;
      }
    }
    
    public void aq(Object[] paramArrayOfObject)
    {
      s.u(paramArrayOfObject, "args");
      super.aq(paramArrayOfObject);
      if ((this.xkb) && (k.Z(paramArrayOfObject) == null)) {
        throw ((Throwable)new IllegalArgumentException("null is not allowed as a value for this property."));
      }
    }
    
    @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "boundReceiver", "", "(Ljava/lang/reflect/Field;ZLjava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
    public static final class a
      extends e.g
      implements c
    {
      private final Object aiAW;
      
      public a(Field paramField, boolean paramBoolean, Object paramObject)
      {
        super(paramBoolean, false, (byte)0);
        AppMethodBeat.i(56606);
        this.aiAW = paramObject;
        AppMethodBeat.o(56606);
      }
      
      public final Object ap(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56605);
        s.u(paramArrayOfObject, "args");
        aq(paramArrayOfObject);
        ((Field)kmy()).set(this.aiAW, k.X(paramArrayOfObject));
        paramArrayOfObject = ah.aiuX;
        AppMethodBeat.o(56605);
        return paramArrayOfObject;
      }
    }
    
    @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
    public static final class b
      extends e.g
      implements c
    {
      public b(Field paramField, boolean paramBoolean)
      {
        super(paramBoolean, false, (byte)0);
        AppMethodBeat.i(56608);
        AppMethodBeat.o(56608);
      }
      
      public final Object ap(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56607);
        s.u(paramArrayOfObject, "args");
        aq(paramArrayOfObject);
        ((Field)kmy()).set(null, k.Z(paramArrayOfObject));
        paramArrayOfObject = ah.aiuX;
        AppMethodBeat.o(56607);
        return paramArrayOfObject;
      }
    }
    
    @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"}, k=1, mv={1, 5, 1})
    public static final class c
      extends e.g
    {
      public c(Field paramField, boolean paramBoolean)
      {
        super(paramBoolean, true, (byte)0);
        AppMethodBeat.i(56609);
        AppMethodBeat.o(56609);
      }
    }
    
    @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflection"}, k=1, mv={1, 5, 1})
    public static final class d
      extends e.g
    {
      public d(Field paramField, boolean paramBoolean)
      {
        super(paramBoolean, true, (byte)0);
        AppMethodBeat.i(56611);
        AppMethodBeat.o(56611);
      }
      
      public final void aq(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56610);
        s.u(paramArrayOfObject, "args");
        super.aq(paramArrayOfObject);
        hR(k.Y(paramArrayOfObject));
        AppMethodBeat.o(56610);
      }
    }
    
    @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"}, k=1, mv={1, 5, 1})
    public static final class e
      extends e.g
    {
      public e(Field paramField, boolean paramBoolean)
      {
        super(paramBoolean, false, (byte)0);
        AppMethodBeat.i(56612);
        AppMethodBeat.o(56612);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Method;", "method", "requiresInstance", "", "parameterTypes", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Method;Z[Ljava/lang/reflect/Type;)V", "isVoidMethod", "callMethod", "", "instance", "args", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "BoundInstance", "BoundJvmStaticInObject", "BoundStatic", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundJvmStaticInObject;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static abstract class h
    extends e<Method>
  {
    private final boolean aiAX;
    
    private h(Method paramMethod, boolean paramBoolean, Type[] paramArrayOfType) {}
    
    protected final Object c(Object paramObject, Object[] paramArrayOfObject)
    {
      s.u(paramArrayOfObject, "args");
      paramObject = ((Method)kmy()).invoke(paramObject, Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length));
      if (this.aiAX) {
        paramObject = ah.aiuX;
      }
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
    public static final class a
      extends e.h
      implements c
    {
      private final Object aiAW;
      
      public a(Method paramMethod, Object paramObject)
      {
        super(false, null, 4);
        AppMethodBeat.i(56614);
        this.aiAW = paramObject;
        AppMethodBeat.o(56614);
      }
      
      public final Object ap(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56613);
        s.u(paramArrayOfObject, "args");
        aq(paramArrayOfObject);
        paramArrayOfObject = c(this.aiAW, paramArrayOfObject);
        AppMethodBeat.o(56613);
        return paramArrayOfObject;
      }
    }
    
    @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
    public static final class b
      extends e.h
      implements c
    {
      public b(Method paramMethod)
      {
        super(false, null, 4);
        AppMethodBeat.i(56616);
        AppMethodBeat.o(56616);
      }
      
      public final Object ap(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56615);
        s.u(paramArrayOfObject, "args");
        aq(paramArrayOfObject);
        paramArrayOfObject = c(null, paramArrayOfObject);
        AppMethodBeat.o(56615);
        return paramArrayOfObject;
      }
    }
    
    @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
    public static final class c
      extends e.h
      implements c
    {
      private final Object aiAW;
      
      public c(Method paramMethod, Object paramObject) {}
      
      public final Object ap(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56617);
        s.u(paramArrayOfObject, "args");
        aq(paramArrayOfObject);
        al localal = new al(2);
        localal.add(this.aiAW);
        localal.hx(paramArrayOfObject);
        paramArrayOfObject = c(null, localal.toArray(new Object[localal.hqL.size()]));
        AppMethodBeat.o(56617);
        return paramArrayOfObject;
      }
    }
    
    @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
    public static final class d
      extends e.h
    {
      public d(Method paramMethod)
      {
        super(false, null, 6);
        AppMethodBeat.i(56620);
        AppMethodBeat.o(56620);
      }
      
      public final Object ap(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56619);
        s.u(paramArrayOfObject, "args");
        aq(paramArrayOfObject);
        Object localObject = paramArrayOfObject[0];
        if (paramArrayOfObject.length <= 1) {
          paramArrayOfObject = new Object[0];
        }
        Object[] arrayOfObject;
        do
        {
          paramArrayOfObject = c(localObject, paramArrayOfObject);
          AppMethodBeat.o(56619);
          return paramArrayOfObject;
          arrayOfObject = k.e(paramArrayOfObject, 1, paramArrayOfObject.length);
          paramArrayOfObject = arrayOfObject;
        } while (arrayOfObject != null);
        paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(56619);
        throw paramArrayOfObject;
      }
    }
    
    @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
    public static final class e
      extends e.h
    {
      public e(Method paramMethod)
      {
        super(true, null, 4);
        AppMethodBeat.i(56622);
        AppMethodBeat.o(56622);
      }
      
      public final Object ap(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56621);
        s.u(paramArrayOfObject, "args");
        aq(paramArrayOfObject);
        hR(k.Y(paramArrayOfObject));
        if (paramArrayOfObject.length <= 1) {
          paramArrayOfObject = new Object[0];
        }
        Object[] arrayOfObject;
        do
        {
          paramArrayOfObject = c(null, paramArrayOfObject);
          AppMethodBeat.o(56621);
          return paramArrayOfObject;
          arrayOfObject = k.e(paramArrayOfObject, 1, paramArrayOfObject.length);
          paramArrayOfObject = arrayOfObject;
        } while (arrayOfObject != null);
        paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(56621);
        throw paramArrayOfObject;
      }
    }
    
    @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
    public static final class f
      extends e.h
    {
      public f(Method paramMethod)
      {
        super(false, null, 6);
        AppMethodBeat.i(56624);
        AppMethodBeat.o(56624);
      }
      
      public final Object ap(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56623);
        s.u(paramArrayOfObject, "args");
        aq(paramArrayOfObject);
        paramArrayOfObject = c(null, paramArrayOfObject);
        AppMethodBeat.o(56623);
        return paramArrayOfObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */