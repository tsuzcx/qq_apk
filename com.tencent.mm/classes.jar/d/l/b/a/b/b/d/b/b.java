package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.g.a.d;
import d.g.a.g;
import d.g.a.k;
import d.g.a.l;
import d.g.a.m;
import d.g.a.o;
import d.g.a.r;
import d.g.a.s;
import d.g.a.t;
import d.g.a.w;
import d.g.b.z;
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
  private static final Map<Class<? extends d.c<?>>, Integer> NiI;
  private static final List<d.l.b<? extends Object>> Nxq;
  private static final Map<Class<? extends Object>, Class<? extends Object>> Nxr;
  private static final Map<Class<? extends Object>, Class<? extends Object>> Nxs;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(57407);
    Object localObject1 = d.a.j.listOf(new d.l.b[] { z.bp(Boolean.TYPE), z.bp(Byte.TYPE), z.bp(Character.TYPE), z.bp(Double.TYPE), z.bp(Float.TYPE), z.bp(Integer.TYPE), z.bp(Long.TYPE), z.bp(Short.TYPE) });
    Nxq = (List)localObject1;
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (d.l.b)((Iterator)localObject2).next();
      ((Collection)localObject1).add(d.u.R(d.g.a.c((d.l.b)localObject3), d.g.a.b((d.l.b)localObject3)));
    }
    Nxr = ae.A((Iterable)localObject1);
    localObject2 = (Iterable)Nxq;
    localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (d.l.b)((Iterator)localObject2).next();
      ((Collection)localObject1).add(d.u.R(d.g.a.b((d.l.b)localObject3), d.g.a.c((d.l.b)localObject3)));
    }
    Nxs = ae.A((Iterable)localObject1);
    localObject2 = (Iterable)d.a.j.listOf(new Class[] { d.g.a.a.class, d.g.a.b.class, m.class, d.g.a.q.class, r.class, s.class, t.class, d.g.a.u.class, d.g.a.v.class, w.class, d.g.a.c.class, d.class, d.g.a.e.class, d.g.a.f.class, g.class, d.g.a.h.class, d.g.a.i.class, d.g.a.j.class, k.class, l.class, d.g.a.n.class, o.class, d.g.a.p.class });
    localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        d.a.j.gkd();
      }
      ((Collection)localObject1).add(d.u.R((Class)localObject3, Integer.valueOf(i)));
      i += 1;
    }
    NiI = ae.A((Iterable)localObject1);
    AppMethodBeat.o(57407);
  }
  
  public static final Class<?> bA(Class<?> paramClass)
  {
    AppMethodBeat.i(57402);
    d.g.b.p.h(paramClass, "$this$wrapperByPrimitive");
    paramClass = (Class)Nxs.get(paramClass);
    AppMethodBeat.o(57402);
    return paramClass;
  }
  
  public static final d.l.b.a.b.f.a bB(Class<?> paramClass)
  {
    AppMethodBeat.i(57403);
    d.g.b.p.h(paramClass, "$this$classId");
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
      d.g.b.p.g(localObject, "simpleName");
      if (((CharSequence)localObject).length() != 0) {
        break label161;
      }
    }
    label161:
    for (int i = 1; i != 0; i = 0)
    {
      paramClass = new d.l.b.a.b.f.b(paramClass.getName());
      paramClass = new d.l.b.a.b.f.a(paramClass.gvI(), d.l.b.a.b.f.b.r(paramClass.gvJ()), true);
      AppMethodBeat.o(57403);
      return paramClass;
    }
    Object localObject = paramClass.getDeclaringClass();
    if (localObject != null)
    {
      localObject = bB((Class)localObject);
      if (localObject != null)
      {
        paramClass = ((d.l.b.a.b.f.a)localObject).o(d.l.b.a.b.f.f.bei(paramClass.getSimpleName()));
        AppMethodBeat.o(57403);
        return paramClass;
      }
    }
    paramClass = d.l.b.a.b.f.a.p(new d.l.b.a.b.f.b(paramClass.getName()));
    d.g.b.p.g(paramClass, "ClassId.topLevel(FqName(name))");
    AppMethodBeat.o(57403);
    return paramClass;
  }
  
  public static final String bC(Class<?> paramClass)
  {
    AppMethodBeat.i(57404);
    d.g.b.p.h(paramClass, "$this$desc");
    if (d.g.b.p.i(paramClass, Void.TYPE))
    {
      AppMethodBeat.o(57404);
      return "V";
    }
    paramClass = bD(paramClass).getName();
    d.g.b.p.g(paramClass, "createArrayType().name");
    if (paramClass == null)
    {
      paramClass = new d.v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(57404);
      throw paramClass;
    }
    paramClass = paramClass.substring(1);
    d.g.b.p.g(paramClass, "(this as java.lang.String).substring(startIndex)");
    paramClass = d.n.n.a(paramClass, '.', '/');
    AppMethodBeat.o(57404);
    return paramClass;
  }
  
  public static final Class<?> bD(Class<?> paramClass)
  {
    AppMethodBeat.i(57405);
    d.g.b.p.h(paramClass, "$this$createArrayType");
    paramClass = Array.newInstance(paramClass, 0).getClass();
    AppMethodBeat.o(57405);
    return paramClass;
  }
  
  public static final ClassLoader bx(Class<?> paramClass)
  {
    AppMethodBeat.i(57399);
    d.g.b.p.h(paramClass, "$this$safeClassLoader");
    ClassLoader localClassLoader = paramClass.getClassLoader();
    paramClass = localClassLoader;
    if (localClassLoader == null)
    {
      paramClass = ClassLoader.getSystemClassLoader();
      d.g.b.p.g(paramClass, "ClassLoader.getSystemClassLoader()");
    }
    AppMethodBeat.o(57399);
    return paramClass;
  }
  
  public static final boolean by(Class<?> paramClass)
  {
    AppMethodBeat.i(57400);
    d.g.b.p.h(paramClass, "$this$isEnumClassOrSpecializedEnumEntryClass");
    boolean bool = Enum.class.isAssignableFrom(paramClass);
    AppMethodBeat.o(57400);
    return bool;
  }
  
  public static final Class<?> bz(Class<?> paramClass)
  {
    AppMethodBeat.i(57401);
    d.g.b.p.h(paramClass, "$this$primitiveByWrapper");
    paramClass = (Class)Nxr.get(paramClass);
    AppMethodBeat.o(57401);
    return paramClass;
  }
  
  public static final List<Type> i(Type paramType)
  {
    AppMethodBeat.i(57406);
    d.g.b.p.h(paramType, "$this$parameterizedTypeArguments");
    if (!(paramType instanceof ParameterizedType))
    {
      paramType = (List)d.a.v.NhH;
      AppMethodBeat.o(57406);
      return paramType;
    }
    if (((ParameterizedType)paramType).getOwnerType() == null)
    {
      paramType = ((ParameterizedType)paramType).getActualTypeArguments();
      d.g.b.p.g(paramType, "actualTypeArguments");
      paramType = d.a.e.V(paramType);
      AppMethodBeat.o(57406);
      return paramType;
    }
    paramType = d.m.i.c(d.m.i.c(d.m.i.b(paramType, (d.g.a.b)a.Nxt), (d.g.a.b)b.Nxu));
    AppMethodBeat.o(57406);
    return paramType;
  }
  
  static final class a
    extends d.g.b.q
    implements d.g.a.b<ParameterizedType, ParameterizedType>
  {
    public static final a Nxt;
    
    static
    {
      AppMethodBeat.i(57396);
      Nxt = new a();
      AppMethodBeat.o(57396);
    }
    
    a()
    {
      super();
    }
  }
  
  static final class b
    extends d.g.b.q
    implements d.g.a.b<ParameterizedType, d.m.h<? extends Type>>
  {
    public static final b Nxu;
    
    static
    {
      AppMethodBeat.i(57398);
      Nxu = new b();
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