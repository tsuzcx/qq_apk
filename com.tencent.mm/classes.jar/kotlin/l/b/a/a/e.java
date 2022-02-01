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
import kotlin.a.j;
import kotlin.g.b.ad;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "member", "returnType", "Ljava/lang/reflect/Type;", "instanceClass", "Ljava/lang/Class;", "valueParameterTypes", "", "(Ljava/lang/reflect/Member;Ljava/lang/reflect/Type;Ljava/lang/Class;[Ljava/lang/reflect/Type;)V", "getInstanceClass", "()Ljava/lang/Class;", "getMember", "()Ljava/lang/reflect/Member;", "Ljava/lang/reflect/Member;", "parameterTypes", "", "getParameterTypes", "()Ljava/util/List;", "getReturnType", "()Ljava/lang/reflect/Type;", "checkObjectInstance", "", "obj", "", "AccessorForHiddenBoundConstructor", "AccessorForHiddenConstructor", "BoundConstructor", "Companion", "Constructor", "FieldGetter", "FieldSetter", "Method", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "kotlin-reflection"})
public abstract class e<M extends Member>
  implements d<M>
{
  public static final e.d Tck = new e.d((byte)0);
  private final List<Type> TbO;
  final M Tch;
  final Type Tci;
  final Class<?> Tcj;
  
  private e(M paramM, Type paramType, Class<?> paramClass, Type[] paramArrayOfType)
  {
    this.Tch = paramM;
    this.Tci = paramType;
    this.Tcj = paramClass;
    paramM = this.Tcj;
    if (paramM != null)
    {
      paramType = new ad(2);
      paramType.add((Type)paramM);
      paramType.eS(paramArrayOfType);
      paramType = j.listOf((Type[])paramType.toArray(new Type[paramType.dtS.size()]));
      paramM = paramType;
      if (paramType != null) {}
    }
    else
    {
      paramM = kotlin.a.e.W(paramArrayOfType);
    }
    this.TbO = paramM;
  }
  
  public void ah(Object[] paramArrayOfObject)
  {
    p.h(paramArrayOfObject, "args");
    d.a.a(this, paramArrayOfObject);
  }
  
  protected final void fk(Object paramObject)
  {
    if ((paramObject == null) || (!this.Tch.getDeclaringClass().isInstance(paramObject))) {
      throw ((Throwable)new IllegalArgumentException("An object member requires the object instance passed as the first argument."));
    }
  }
  
  public final M hyV()
  {
    return this.Tch;
  }
  
  public final Type hyW()
  {
    return this.Tci;
  }
  
  public final List<Type> hyX()
  {
    return this.TbO;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "constructor", "boundReceiver", "", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class a
    extends e<Constructor<?>>
    implements c
  {
    private final Object Tcl;
    
    public a(Constructor<?> paramConstructor, Object paramObject) {}
    
    public final Object ag(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56590);
      p.h(paramArrayOfObject, "args");
      ah(paramArrayOfObject);
      Constructor localConstructor = (Constructor)this.Tch;
      ad localad = new ad(3);
      localad.add(this.Tcl);
      localad.eS(paramArrayOfObject);
      localad.add(null);
      paramArrayOfObject = localConstructor.newInstance(localad.toArray(new Object[localad.dtS.size()]));
      AppMethodBeat.o(56590);
      return paramArrayOfObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class b
    extends e<Constructor<?>>
  {
    public b(Constructor<?> paramConstructor) {}
    
    public final Object ag(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56592);
      p.h(paramArrayOfObject, "args");
      ah(paramArrayOfObject);
      Constructor localConstructor = (Constructor)this.Tch;
      ad localad = new ad(2);
      localad.eS(paramArrayOfObject);
      localad.add(null);
      paramArrayOfObject = localConstructor.newInstance(localad.toArray(new Object[localad.dtS.size()]));
      AppMethodBeat.o(56592);
      return paramArrayOfObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "boundReceiver", "", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class c
    extends e<Constructor<?>>
    implements c
  {
    private final Object Tcl;
    
    public c(Constructor<?> paramConstructor, Object paramObject)
    {
      super((Type)localObject, null, paramConstructor, (byte)0);
      AppMethodBeat.i(56595);
      this.Tcl = paramObject;
      AppMethodBeat.o(56595);
    }
    
    public final Object ag(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56594);
      p.h(paramArrayOfObject, "args");
      ah(paramArrayOfObject);
      Constructor localConstructor = (Constructor)this.Tch;
      ad localad = new ad(2);
      localad.add(this.Tcl);
      localad.eS(paramArrayOfObject);
      paramArrayOfObject = localConstructor.newInstance(localad.toArray(new Object[localad.dtS.size()]));
      AppMethodBeat.o(56594);
      return paramArrayOfObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class e
    extends e<Constructor<?>>
  {
    public e(Constructor<?> paramConstructor) {}
    
    public final Object ag(Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(56596);
      p.h(paramArrayOfObject, "args");
      ah(paramArrayOfObject);
      paramArrayOfObject = ((Constructor)this.Tch).newInstance(Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length));
      AppMethodBeat.o(56596);
      return paramArrayOfObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "requiresInstance", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoundInstance", "BoundJvmStaticInObject", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundJvmStaticInObject;", "kotlin-reflection"})
  public static abstract class f
    extends e<Field>
  {
    private f(Field paramField, boolean paramBoolean) {}
    
    public Object ag(Object[] paramArrayOfObject)
    {
      p.h(paramArrayOfObject, "args");
      ah(paramArrayOfObject);
      Field localField = (Field)this.Tch;
      if (this.Tcj != null) {}
      for (paramArrayOfObject = kotlin.a.e.Q(paramArrayOfObject);; paramArrayOfObject = null) {
        return localField.get(paramArrayOfObject);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "boundReceiver", "", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class a
      extends e.f
      implements c
    {
      private final Object Tcl;
      
      public a(Field paramField, Object paramObject)
      {
        super(false, (byte)0);
        AppMethodBeat.i(56599);
        this.Tcl = paramObject;
        AppMethodBeat.o(56599);
      }
      
      public final Object ag(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56598);
        p.h(paramArrayOfObject, "args");
        ah(paramArrayOfObject);
        paramArrayOfObject = ((Field)this.Tch).get(this.Tcl);
        AppMethodBeat.o(56598);
        return paramArrayOfObject;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"})
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
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"})
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
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflection"})
    public static final class d
      extends e.f
    {
      public d(Field paramField)
      {
        super(true, (byte)0);
        AppMethodBeat.i(56603);
        AppMethodBeat.o(56603);
      }
      
      public final void ah(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56602);
        p.h(paramArrayOfObject, "args");
        super.ah(paramArrayOfObject);
        fk(kotlin.a.e.R(paramArrayOfObject));
        AppMethodBeat.o(56602);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"})
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "notNull", "", "requiresInstance", "(Ljava/lang/reflect/Field;ZZ)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", "", "([Ljava/lang/Object;)V", "BoundInstance", "BoundJvmStaticInObject", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundJvmStaticInObject;", "kotlin-reflection"})
  public static abstract class g
    extends e<Field>
  {
    private final boolean qEX;
    
    private g(Field paramField, boolean paramBoolean1, boolean paramBoolean2) {}
    
    public Object ag(Object[] paramArrayOfObject)
    {
      p.h(paramArrayOfObject, "args");
      ah(paramArrayOfObject);
      Field localField = (Field)this.Tch;
      if (this.Tcj != null) {}
      for (Object localObject = kotlin.a.e.Q(paramArrayOfObject);; localObject = null)
      {
        localField.set(localObject, kotlin.a.e.S(paramArrayOfObject));
        return x.SXb;
      }
    }
    
    public void ah(Object[] paramArrayOfObject)
    {
      p.h(paramArrayOfObject, "args");
      super.ah(paramArrayOfObject);
      if ((this.qEX) && (kotlin.a.e.S(paramArrayOfObject) == null)) {
        throw ((Throwable)new IllegalArgumentException("null is not allowed as a value for this property."));
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "boundReceiver", "", "(Ljava/lang/reflect/Field;ZLjava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class a
      extends e.g
      implements c
    {
      private final Object Tcl;
      
      public a(Field paramField, boolean paramBoolean, Object paramObject)
      {
        super(paramBoolean, false, (byte)0);
        AppMethodBeat.i(56606);
        this.Tcl = paramObject;
        AppMethodBeat.o(56606);
      }
      
      public final Object ag(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56605);
        p.h(paramArrayOfObject, "args");
        ah(paramArrayOfObject);
        ((Field)this.Tch).set(this.Tcl, kotlin.a.e.Q(paramArrayOfObject));
        paramArrayOfObject = x.SXb;
        AppMethodBeat.o(56605);
        return paramArrayOfObject;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
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
      
      public final Object ag(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56607);
        p.h(paramArrayOfObject, "args");
        ah(paramArrayOfObject);
        ((Field)this.Tch).set(null, kotlin.a.e.S(paramArrayOfObject));
        paramArrayOfObject = x.SXb;
        AppMethodBeat.o(56607);
        return paramArrayOfObject;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"})
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
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflection"})
    public static final class d
      extends e.g
    {
      public d(Field paramField, boolean paramBoolean)
      {
        super(paramBoolean, true, (byte)0);
        AppMethodBeat.i(56611);
        AppMethodBeat.o(56611);
      }
      
      public final void ah(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56610);
        p.h(paramArrayOfObject, "args");
        super.ah(paramArrayOfObject);
        fk(kotlin.a.e.R(paramArrayOfObject));
        AppMethodBeat.o(56610);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"})
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Method;", "method", "requiresInstance", "", "parameterTypes", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Method;Z[Ljava/lang/reflect/Type;)V", "isVoidMethod", "callMethod", "", "instance", "args", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "BoundInstance", "BoundJvmStaticInObject", "BoundStatic", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundJvmStaticInObject;", "kotlin-reflection"})
  public static abstract class h
    extends e<Method>
  {
    private final boolean Tcm;
    
    private h(Method paramMethod, boolean paramBoolean, Type[] paramArrayOfType) {}
    
    protected final Object b(Object paramObject, Object[] paramArrayOfObject)
    {
      p.h(paramArrayOfObject, "args");
      paramObject = ((Method)this.Tch).invoke(paramObject, Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length));
      if (this.Tcm) {
        paramObject = x.SXb;
      }
      return paramObject;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class a
      extends e.h
      implements c
    {
      private final Object Tcl;
      
      public a(Method paramMethod, Object paramObject)
      {
        super(false, null, 4);
        AppMethodBeat.i(56614);
        this.Tcl = paramObject;
        AppMethodBeat.o(56614);
      }
      
      public final Object ag(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56613);
        p.h(paramArrayOfObject, "args");
        ah(paramArrayOfObject);
        paramArrayOfObject = b(this.Tcl, paramArrayOfObject);
        AppMethodBeat.o(56613);
        return paramArrayOfObject;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
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
      
      public final Object ag(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56615);
        p.h(paramArrayOfObject, "args");
        ah(paramArrayOfObject);
        paramArrayOfObject = b(null, paramArrayOfObject);
        AppMethodBeat.o(56615);
        return paramArrayOfObject;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class c
      extends e.h
      implements c
    {
      private final Object Tcl;
      
      public c(Method paramMethod, Object paramObject) {}
      
      public final Object ag(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56617);
        p.h(paramArrayOfObject, "args");
        ah(paramArrayOfObject);
        ad localad = new ad(2);
        localad.add(this.Tcl);
        localad.eS(paramArrayOfObject);
        paramArrayOfObject = b(null, localad.toArray(new Object[localad.dtS.size()]));
        AppMethodBeat.o(56617);
        return paramArrayOfObject;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class d
      extends e.h
    {
      public d(Method paramMethod)
      {
        super(false, null, 6);
        AppMethodBeat.i(56620);
        AppMethodBeat.o(56620);
      }
      
      public final Object ag(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56619);
        p.h(paramArrayOfObject, "args");
        ah(paramArrayOfObject);
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
          arrayOfObject = kotlin.a.e.copyOfRange(paramArrayOfObject, 1, paramArrayOfObject.length);
          paramArrayOfObject = arrayOfObject;
        } while (arrayOfObject != null);
        paramArrayOfObject = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(56619);
        throw paramArrayOfObject;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class e
      extends e.h
    {
      public e(Method paramMethod)
      {
        super(true, null, 4);
        AppMethodBeat.i(56622);
        AppMethodBeat.o(56622);
      }
      
      public final Object ag(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56621);
        p.h(paramArrayOfObject, "args");
        ah(paramArrayOfObject);
        fk(kotlin.a.e.R(paramArrayOfObject));
        if (paramArrayOfObject.length <= 1) {
          paramArrayOfObject = new Object[0];
        }
        Object[] arrayOfObject;
        do
        {
          paramArrayOfObject = b(null, paramArrayOfObject);
          AppMethodBeat.o(56621);
          return paramArrayOfObject;
          arrayOfObject = kotlin.a.e.copyOfRange(paramArrayOfObject, 1, paramArrayOfObject.length);
          paramArrayOfObject = arrayOfObject;
        } while (arrayOfObject != null);
        paramArrayOfObject = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(56621);
        throw paramArrayOfObject;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class f
      extends e.h
    {
      public f(Method paramMethod)
      {
        super(false, null, 6);
        AppMethodBeat.i(56624);
        AppMethodBeat.o(56624);
      }
      
      public final Object ag(Object[] paramArrayOfObject)
      {
        AppMethodBeat.i(56623);
        p.h(paramArrayOfObject, "args");
        ah(paramArrayOfObject);
        paramArrayOfObject = b(null, paramArrayOfObject);
        AppMethodBeat.o(56623);
        return paramArrayOfObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */