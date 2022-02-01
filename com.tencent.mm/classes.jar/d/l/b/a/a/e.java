package d.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "member", "returnType", "Ljava/lang/reflect/Type;", "instanceClass", "Ljava/lang/Class;", "valueParameterTypes", "", "(Ljava/lang/reflect/Member;Ljava/lang/reflect/Type;Ljava/lang/Class;[Ljava/lang/reflect/Type;)V", "getInstanceClass", "()Ljava/lang/Class;", "getMember", "()Ljava/lang/reflect/Member;", "Ljava/lang/reflect/Member;", "parameterTypes", "", "getParameterTypes", "()Ljava/util/List;", "getReturnType", "()Ljava/lang/reflect/Type;", "checkObjectInstance", "", "obj", "", "AccessorForHiddenBoundConstructor", "AccessorForHiddenConstructor", "BoundConstructor", "Companion", "Constructor", "FieldGetter", "FieldSetter", "Method", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "kotlin-reflection"})
public abstract class e<M extends Member>
  implements d<M>
{
  public static final d KYB = new d((byte)0);
  final Class<?> KYA;
  private final List<Type> KYe;
  final M KYy;
  final Type KYz;
  
  private e(M paramM, Type paramType, Class<?> paramClass, Type[] paramArrayOfType)
  {
    this.KYy = paramM;
    this.KYz = paramType;
    this.KYA = paramClass;
    paramM = this.KYA;
    if (paramM != null)
    {
      paramType = new d.g.b.y(2);
      paramType.add((Type)paramM);
      paramType.eL(paramArrayOfType);
      paramType = j.listOf((Type[])paramType.toArray(new Type[paramType.cQJ.size()]));
      paramM = paramType;
      if (paramType != null) {}
    }
    else
    {
      paramM = d.a.e.V(paramArrayOfType);
    }
    this.KYe = paramM;
  }
  
  public void af(Object[] paramArrayOfObject)
  {
    k.h(paramArrayOfObject, "args");
    d.a.a(this, paramArrayOfObject);
  }
  
  public final M fPs()
  {
    return this.KYy;
  }
  
  public final Type fPt()
  {
    return this.KYz;
  }
  
  public final List<Type> fPu()
  {
    return this.KYe;
  }
  
  protected final void fa(Object paramObject)
  {
    if ((paramObject == null) || (!this.KYy.getDeclaringClass().isInstance(paramObject))) {
      throw ((Throwable)new IllegalArgumentException("An object member requires the object instance passed as the first argument."));
    }
  }
  
  @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "constructor", "boundReceiver", "", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class a
    extends e<Constructor<?>>
    implements c
  {
    private final Object KYC;
    
    public a(Constructor<?> paramConstructor, Object paramObject) {}
    
    public final Object ae(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56590);
      k.h(paramArrayOfObject, "args");
      af(paramArrayOfObject);
      Constructor localConstructor = (Constructor)this.KYy;
      d.g.b.y localy = new d.g.b.y(3);
      localy.add(this.KYC);
      localy.eL(paramArrayOfObject);
      localy.add(null);
      paramArrayOfObject = localConstructor.newInstance(localy.toArray(new Object[localy.cQJ.size()]));
      AppMethodBeat.o(56590);
      return paramArrayOfObject;
    }
  }
  
  @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class b
    extends e<Constructor<?>>
  {
    public b(Constructor<?> paramConstructor) {}
    
    public final Object ae(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56592);
      k.h(paramArrayOfObject, "args");
      af(paramArrayOfObject);
      Constructor localConstructor = (Constructor)this.KYy;
      d.g.b.y localy = new d.g.b.y(2);
      localy.eL(paramArrayOfObject);
      localy.add(null);
      paramArrayOfObject = localConstructor.newInstance(localy.toArray(new Object[localy.cQJ.size()]));
      AppMethodBeat.o(56592);
      return paramArrayOfObject;
    }
  }
  
  @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "boundReceiver", "", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class c
    extends e<Constructor<?>>
    implements c
  {
    private final Object KYC;
    
    public c(Constructor<?> paramConstructor, Object paramObject)
    {
      super((Type)localObject, null, paramConstructor, (byte)0);
      AppMethodBeat.i(56595);
      this.KYC = paramObject;
      AppMethodBeat.o(56595);
    }
    
    public final Object ae(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56594);
      k.h(paramArrayOfObject, "args");
      af(paramArrayOfObject);
      Constructor localConstructor = (Constructor)this.KYy;
      d.g.b.y localy = new d.g.b.y(2);
      localy.add(this.KYC);
      localy.eL(paramArrayOfObject);
      paramArrayOfObject = localConstructor.newInstance(localy.toArray(new Object[localy.cQJ.size()]));
      AppMethodBeat.o(56594);
      return paramArrayOfObject;
    }
  }
  
  @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Companion;", "", "()V", "dropFirst", "", "T", "([Ljava/lang/Object;)[Ljava/lang/Object;", "dropFirstAndLast", "dropLast", "kotlin-reflection"})
  public static final class d {}
  
  @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class e
    extends e<Constructor<?>>
  {
    public e(Constructor<?> paramConstructor) {}
    
    public final Object ae(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56596);
      k.h(paramArrayOfObject, "args");
      af(paramArrayOfObject);
      paramArrayOfObject = ((Constructor)this.KYy).newInstance(Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length));
      AppMethodBeat.o(56596);
      return paramArrayOfObject;
    }
  }
  
  @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "requiresInstance", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoundInstance", "BoundJvmStaticInObject", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundJvmStaticInObject;", "kotlin-reflection"})
  public static abstract class f
    extends e<Field>
  {
    private f(Field paramField, boolean paramBoolean) {}
    
    public Object ae(Object[] paramArrayOfObject)
    {
      k.h(paramArrayOfObject, "args");
      af(paramArrayOfObject);
      Field localField = (Field)this.KYy;
      if (this.KYA != null) {}
      for (paramArrayOfObject = d.a.e.P(paramArrayOfObject);; paramArrayOfObject = null) {
        return localField.get(paramArrayOfObject);
      }
    }
    
    @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "boundReceiver", "", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class a
      extends e.f
      implements c
    {
      private final Object KYC;
      
      public a(Field paramField, Object paramObject)
      {
        super(false, (byte)0);
        AppMethodBeat.i(56599);
        this.KYC = paramObject;
        AppMethodBeat.o(56599);
      }
      
      public final Object ae(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56598);
        k.h(paramArrayOfObject, "args");
        af(paramArrayOfObject);
        paramArrayOfObject = ((Field)this.KYy).get(this.KYC);
        AppMethodBeat.o(56598);
        return paramArrayOfObject;
      }
    }
    
    @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"})
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
    
    @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"})
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
    
    @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflection"})
    public static final class d
      extends e.f
    {
      public d(Field paramField)
      {
        super(true, (byte)0);
        AppMethodBeat.i(56603);
        AppMethodBeat.o(56603);
      }
      
      public final void af(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56602);
        k.h(paramArrayOfObject, "args");
        super.af(paramArrayOfObject);
        fa(d.a.e.Q(paramArrayOfObject));
        AppMethodBeat.o(56602);
      }
    }
    
    @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"})
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
  
  @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "notNull", "", "requiresInstance", "(Ljava/lang/reflect/Field;ZZ)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", "", "([Ljava/lang/Object;)V", "BoundInstance", "BoundJvmStaticInObject", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundJvmStaticInObject;", "kotlin-reflection"})
  public static abstract class g
    extends e<Field>
  {
    private final boolean KYD;
    
    private g(Field paramField, boolean paramBoolean1, boolean paramBoolean2) {}
    
    public Object ae(Object[] paramArrayOfObject)
    {
      k.h(paramArrayOfObject, "args");
      af(paramArrayOfObject);
      Field localField = (Field)this.KYy;
      if (this.KYA != null) {}
      for (Object localObject = d.a.e.P(paramArrayOfObject);; localObject = null)
      {
        localField.set(localObject, d.a.e.R(paramArrayOfObject));
        return d.y.KTp;
      }
    }
    
    public void af(Object[] paramArrayOfObject)
    {
      k.h(paramArrayOfObject, "args");
      super.af(paramArrayOfObject);
      if ((this.KYD) && (d.a.e.R(paramArrayOfObject) == null)) {
        throw ((Throwable)new IllegalArgumentException("null is not allowed as a value for this property."));
      }
    }
    
    @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "boundReceiver", "", "(Ljava/lang/reflect/Field;ZLjava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class a
      extends e.g
      implements c
    {
      private final Object KYC;
      
      public a(Field paramField, boolean paramBoolean, Object paramObject)
      {
        super(paramBoolean, false, (byte)0);
        AppMethodBeat.i(56606);
        this.KYC = paramObject;
        AppMethodBeat.o(56606);
      }
      
      public final Object ae(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56605);
        k.h(paramArrayOfObject, "args");
        af(paramArrayOfObject);
        ((Field)this.KYy).set(this.KYC, d.a.e.P(paramArrayOfObject));
        paramArrayOfObject = d.y.KTp;
        AppMethodBeat.o(56605);
        return paramArrayOfObject;
      }
    }
    
    @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
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
      
      public final Object ae(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56607);
        k.h(paramArrayOfObject, "args");
        af(paramArrayOfObject);
        ((Field)this.KYy).set(null, d.a.e.R(paramArrayOfObject));
        paramArrayOfObject = d.y.KTp;
        AppMethodBeat.o(56607);
        return paramArrayOfObject;
      }
    }
    
    @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"})
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
    
    @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflection"})
    public static final class d
      extends e.g
    {
      public d(Field paramField, boolean paramBoolean)
      {
        super(paramBoolean, true, (byte)0);
        AppMethodBeat.i(56611);
        AppMethodBeat.o(56611);
      }
      
      public final void af(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56610);
        k.h(paramArrayOfObject, "args");
        super.af(paramArrayOfObject);
        fa(d.a.e.Q(paramArrayOfObject));
        AppMethodBeat.o(56610);
      }
    }
    
    @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"})
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
  
  @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Method;", "method", "requiresInstance", "", "parameterTypes", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Method;Z[Ljava/lang/reflect/Type;)V", "isVoidMethod", "callMethod", "", "instance", "args", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "BoundInstance", "BoundJvmStaticInObject", "BoundStatic", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundJvmStaticInObject;", "kotlin-reflection"})
  public static abstract class h
    extends e<Method>
  {
    private final boolean KYE;
    
    private h(Method paramMethod, boolean paramBoolean, Type[] paramArrayOfType) {}
    
    protected final Object b(Object paramObject, Object[] paramArrayOfObject)
    {
      k.h(paramArrayOfObject, "args");
      paramObject = ((Method)this.KYy).invoke(paramObject, Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length));
      if (this.KYE) {
        paramObject = d.y.KTp;
      }
      return paramObject;
    }
    
    @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class a
      extends e.h
      implements c
    {
      private final Object KYC;
      
      public a(Method paramMethod, Object paramObject)
      {
        super(false, null, 4);
        AppMethodBeat.i(56614);
        this.KYC = paramObject;
        AppMethodBeat.o(56614);
      }
      
      public final Object ae(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56613);
        k.h(paramArrayOfObject, "args");
        af(paramArrayOfObject);
        paramArrayOfObject = b(this.KYC, paramArrayOfObject);
        AppMethodBeat.o(56613);
        return paramArrayOfObject;
      }
    }
    
    @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
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
      
      public final Object ae(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56615);
        k.h(paramArrayOfObject, "args");
        af(paramArrayOfObject);
        paramArrayOfObject = b(null, paramArrayOfObject);
        AppMethodBeat.o(56615);
        return paramArrayOfObject;
      }
    }
    
    @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class c
      extends e.h
      implements c
    {
      private final Object KYC;
      
      public c(Method paramMethod, Object paramObject) {}
      
      public final Object ae(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56617);
        k.h(paramArrayOfObject, "args");
        af(paramArrayOfObject);
        d.g.b.y localy = new d.g.b.y(2);
        localy.add(this.KYC);
        localy.eL(paramArrayOfObject);
        paramArrayOfObject = b(null, localy.toArray(new Object[localy.cQJ.size()]));
        AppMethodBeat.o(56617);
        return paramArrayOfObject;
      }
    }
    
    @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class d
      extends e.h
    {
      public d(Method paramMethod)
      {
        super(false, null, 6);
        AppMethodBeat.i(56620);
        AppMethodBeat.o(56620);
      }
      
      public final Object ae(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56619);
        k.h(paramArrayOfObject, "args");
        af(paramArrayOfObject);
        Object localObject = paramArrayOfObject[0];
        if (paramArrayOfObject.length <= 1) {
          paramArrayOfObject = new Object[0];
        }
        Object[] arrayOfObject;
        do
        {
          paramArrayOfObject = b(localObject, paramArrayOfObject);
          AppMethodBeat.o(56619);
          return paramArrayOfObject;
          arrayOfObject = d.a.e.copyOfRange(paramArrayOfObject, 1, paramArrayOfObject.length);
          paramArrayOfObject = arrayOfObject;
        } while (arrayOfObject != null);
        paramArrayOfObject = new v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(56619);
        throw paramArrayOfObject;
      }
    }
    
    @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class e
      extends e.h
    {
      public e(Method paramMethod)
      {
        super(true, null, 4);
        AppMethodBeat.i(56622);
        AppMethodBeat.o(56622);
      }
      
      public final Object ae(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56621);
        k.h(paramArrayOfObject, "args");
        af(paramArrayOfObject);
        fa(d.a.e.Q(paramArrayOfObject));
        if (paramArrayOfObject.length <= 1) {
          paramArrayOfObject = new Object[0];
        }
        Object[] arrayOfObject;
        do
        {
          paramArrayOfObject = b(null, paramArrayOfObject);
          AppMethodBeat.o(56621);
          return paramArrayOfObject;
          arrayOfObject = d.a.e.copyOfRange(paramArrayOfObject, 1, paramArrayOfObject.length);
          paramArrayOfObject = arrayOfObject;
        } while (arrayOfObject != null);
        paramArrayOfObject = new v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(56621);
        throw paramArrayOfObject;
      }
    }
    
    @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class f
      extends e.h
    {
      public f(Method paramMethod)
      {
        super(false, null, 6);
        AppMethodBeat.i(56624);
        AppMethodBeat.o(56624);
      }
      
      public final Object ae(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56623);
        k.h(paramArrayOfObject, "args");
        af(paramArrayOfObject);
        paramArrayOfObject = b(null, paramArrayOfObject);
        AppMethodBeat.o(56623);
        return paramArrayOfObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */