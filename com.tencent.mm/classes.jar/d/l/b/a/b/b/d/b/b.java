package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.g.a.d;
import d.g.a.g;
import d.g.a.m;
import d.g.a.o;
import d.g.a.p;
import d.g.a.q;
import d.g.a.r;
import d.g.a.s;
import d.g.a.t;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
{
  private static final Map<Class<? extends d.c<?>>, Integer> KUD;
  private static final List<d.l.b<? extends Object>> Ljo;
  private static final Map<Class<? extends Object>, Class<? extends Object>> Ljp;
  private static final Map<Class<? extends Object>, Class<? extends Object>> Ljq;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(57407);
    Object localObject1 = d.a.j.listOf(new d.l.b[] { d.g.b.w.bn(Boolean.TYPE), d.g.b.w.bn(Byte.TYPE), d.g.b.w.bn(Character.TYPE), d.g.b.w.bn(Double.TYPE), d.g.b.w.bn(Float.TYPE), d.g.b.w.bn(Integer.TYPE), d.g.b.w.bn(Long.TYPE), d.g.b.w.bn(Short.TYPE) });
    Ljo = (List)localObject1;
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (d.l.b)((Iterator)localObject2).next();
      ((Collection)localObject1).add(d.u.Q(d.g.a.c((d.l.b)localObject3), d.g.a.b((d.l.b)localObject3)));
    }
    Ljp = ae.y((Iterable)localObject1);
    localObject2 = (Iterable)Ljo;
    localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (d.l.b)((Iterator)localObject2).next();
      ((Collection)localObject1).add(d.u.Q(d.g.a.b((d.l.b)localObject3), d.g.a.c((d.l.b)localObject3)));
    }
    Ljq = ae.y((Iterable)localObject1);
    localObject2 = (Iterable)d.a.j.listOf(new Class[] { d.g.a.a.class, d.g.a.b.class, m.class, q.class, r.class, s.class, t.class, d.g.a.u.class, d.g.a.v.class, d.g.a.w.class, d.g.a.c.class, d.class, d.g.a.e.class, d.g.a.f.class, g.class, d.g.a.h.class, d.g.a.i.class, d.g.a.j.class, d.g.a.k.class, d.g.a.l.class, d.g.a.n.class, o.class, p.class });
    localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        d.a.j.fOc();
      }
      ((Collection)localObject1).add(d.u.Q((Class)localObject3, Integer.valueOf(i)));
      i += 1;
    }
    KUD = ae.y((Iterable)localObject1);
    AppMethodBeat.o(57407);
  }
  
  public static final String bA(Class<?> paramClass)
  {
    AppMethodBeat.i(57404);
    d.g.b.k.h(paramClass, "$this$desc");
    if (d.g.b.k.g(paramClass, Void.TYPE))
    {
      AppMethodBeat.o(57404);
      return "V";
    }
    paramClass = bB(paramClass).getName();
    d.g.b.k.g(paramClass, "createArrayType().name");
    if (paramClass == null)
    {
      paramClass = new d.v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(57404);
      throw paramClass;
    }
    paramClass = paramClass.substring(1);
    d.g.b.k.g(paramClass, "(this as java.lang.String).substring(startIndex)");
    paramClass = d.n.n.a(paramClass, '.', '/');
    AppMethodBeat.o(57404);
    return paramClass;
  }
  
  public static final Class<?> bB(Class<?> paramClass)
  {
    AppMethodBeat.i(57405);
    d.g.b.k.h(paramClass, "$this$createArrayType");
    paramClass = Array.newInstance(paramClass, 0).getClass();
    AppMethodBeat.o(57405);
    return paramClass;
  }
  
  public static final ClassLoader bv(Class<?> paramClass)
  {
    AppMethodBeat.i(57399);
    d.g.b.k.h(paramClass, "$this$safeClassLoader");
    ClassLoader localClassLoader = paramClass.getClassLoader();
    paramClass = localClassLoader;
    if (localClassLoader == null)
    {
      paramClass = ClassLoader.getSystemClassLoader();
      d.g.b.k.g(paramClass, "ClassLoader.getSystemClassLoader()");
    }
    AppMethodBeat.o(57399);
    return paramClass;
  }
  
  public static final boolean bw(Class<?> paramClass)
  {
    AppMethodBeat.i(57400);
    d.g.b.k.h(paramClass, "$this$isEnumClassOrSpecializedEnumEntryClass");
    boolean bool = Enum.class.isAssignableFrom(paramClass);
    AppMethodBeat.o(57400);
    return bool;
  }
  
  public static final Class<?> bx(Class<?> paramClass)
  {
    AppMethodBeat.i(57401);
    d.g.b.k.h(paramClass, "$this$primitiveByWrapper");
    paramClass = (Class)Ljp.get(paramClass);
    AppMethodBeat.o(57401);
    return paramClass;
  }
  
  public static final Class<?> by(Class<?> paramClass)
  {
    AppMethodBeat.i(57402);
    d.g.b.k.h(paramClass, "$this$wrapperByPrimitive");
    paramClass = (Class)Ljq.get(paramClass);
    AppMethodBeat.o(57402);
    return paramClass;
  }
  
  public static final d.l.b.a.b.f.a bz(Class<?> paramClass)
  {
    AppMethodBeat.i(57403);
    d.g.b.k.h(paramClass, "$this$classId");
    if (paramClass.isPrimitive())
    {
      paramClass = (Throwable)new IllegalArgumentException("Can't compute ClassId for primitive type: ".concat(String.valueOf(paramClass)));
      AppMethodBeat.o(57403);
      throw paramClass;
    }
    if (paramClass.isArray())
    {
      paramClass = (Throwable)new IllegalArgumentException("Can't compute ClassId for array type: ".concat(String.valueOf(paramClass)));
      AppMethodBeat.o(57403);
      throw paramClass;
    }
    if ((paramClass.getEnclosingMethod() == null) && (paramClass.getEnclosingConstructor() == null))
    {
      localObject = paramClass.getSimpleName();
      d.g.b.k.g(localObject, "simpleName");
      if (((CharSequence)localObject).length() != 0) {
        break label169;
      }
    }
    label169:
    for (int i = 1; i != 0; i = 0)
    {
      paramClass = new d.l.b.a.b.f.b(paramClass.getName());
      paramClass = new d.l.b.a.b.f.a(paramClass.fZH(), d.l.b.a.b.f.b.r(paramClass.fZI()), true);
      AppMethodBeat.o(57403);
      return paramClass;
    }
    Object localObject = paramClass.getDeclaringClass();
    if (localObject != null)
    {
      localObject = bz((Class)localObject);
      if (localObject != null)
      {
        paramClass = ((d.l.b.a.b.f.a)localObject).o(d.l.b.a.b.f.f.aWB(paramClass.getSimpleName()));
        AppMethodBeat.o(57403);
        return paramClass;
      }
    }
    paramClass = d.l.b.a.b.f.a.p(new d.l.b.a.b.f.b(paramClass.getName()));
    d.g.b.k.g(paramClass, "ClassId.topLevel(FqName(name))");
    AppMethodBeat.o(57403);
    return paramClass;
  }
  
  public static final List<Type> i(Type paramType)
  {
    AppMethodBeat.i(57406);
    d.g.b.k.h(paramType, "$this$parameterizedTypeArguments");
    if (!(paramType instanceof ParameterizedType))
    {
      paramType = (List)d.a.v.KTF;
      AppMethodBeat.o(57406);
      return paramType;
    }
    if (((ParameterizedType)paramType).getOwnerType() == null)
    {
      paramType = ((ParameterizedType)paramType).getActualTypeArguments();
      d.g.b.k.g(paramType, "actualTypeArguments");
      paramType = d.a.e.V(paramType);
      AppMethodBeat.o(57406);
      return paramType;
    }
    paramType = d.m.i.c(d.m.i.c(d.m.i.b(paramType, (d.g.a.b)a.Ljr), (d.g.a.b)b.Ljs));
    AppMethodBeat.o(57406);
    return paramType;
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.b<ParameterizedType, ParameterizedType>
  {
    public static final a Ljr;
    
    static
    {
      AppMethodBeat.i(57396);
      Ljr = new a();
      AppMethodBeat.o(57396);
    }
    
    a()
    {
      super();
    }
  }
  
  static final class b
    extends d.g.b.l
    implements d.g.a.b<ParameterizedType, d.m.h<? extends Type>>
  {
    public static final b Ljs;
    
    static
    {
      AppMethodBeat.i(57398);
      Ljs = new b();
      AppMethodBeat.o(57398);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.b
 * JD-Core Version:    0.7.0.1
 */