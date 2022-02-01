package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.a.d;
import kotlin.g.a.g;
import kotlin.g.a.h;
import kotlin.g.a.k;
import kotlin.g.a.l;
import kotlin.g.a.m;
import kotlin.g.a.o;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.a.u;
import kotlin.g.a.w;
import kotlin.g.b.aa;

public final class b
{
  private static final Map<Class<? extends kotlin.c<?>>, Integer> SYq;
  private static final List<kotlin.l.b<? extends Object>> TmY;
  private static final Map<Class<? extends Object>, Class<? extends Object>> TmZ;
  private static final Map<Class<? extends Object>, Class<? extends Object>> Tna;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(57407);
    Object localObject1 = kotlin.a.j.listOf(new kotlin.l.b[] { aa.bp(Boolean.TYPE), aa.bp(Byte.TYPE), aa.bp(Character.TYPE), aa.bp(Double.TYPE), aa.bp(Float.TYPE), aa.bp(Integer.TYPE), aa.bp(Long.TYPE), aa.bp(Short.TYPE) });
    TmY = (List)localObject1;
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (kotlin.l.b)((Iterator)localObject2).next();
      ((Collection)localObject1).add(kotlin.s.U(kotlin.g.a.c((kotlin.l.b)localObject3), kotlin.g.a.b((kotlin.l.b)localObject3)));
    }
    TmZ = ae.E((Iterable)localObject1);
    localObject2 = (Iterable)TmY;
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (kotlin.l.b)((Iterator)localObject2).next();
      ((Collection)localObject1).add(kotlin.s.U(kotlin.g.a.b((kotlin.l.b)localObject3), kotlin.g.a.c((kotlin.l.b)localObject3)));
    }
    Tna = ae.E((Iterable)localObject1);
    localObject2 = (Iterable)kotlin.a.j.listOf(new Class[] { kotlin.g.a.a.class, kotlin.g.a.b.class, m.class, q.class, r.class, kotlin.g.a.s.class, kotlin.g.a.t.class, u.class, kotlin.g.a.v.class, w.class, kotlin.g.a.c.class, d.class, kotlin.g.a.e.class, kotlin.g.a.f.class, g.class, h.class, kotlin.g.a.i.class, kotlin.g.a.j.class, k.class, l.class, kotlin.g.a.n.class, o.class, kotlin.g.a.p.class });
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      ((Collection)localObject1).add(kotlin.s.U((Class)localObject3, Integer.valueOf(i)));
      i += 1;
    }
    SYq = ae.E((Iterable)localObject1);
    AppMethodBeat.o(57407);
  }
  
  public static final List<Type> a(Type paramType)
  {
    AppMethodBeat.i(57406);
    kotlin.g.b.p.h(paramType, "$this$parameterizedTypeArguments");
    if (!(paramType instanceof ParameterizedType))
    {
      paramType = (List)kotlin.a.v.SXr;
      AppMethodBeat.o(57406);
      return paramType;
    }
    if (((ParameterizedType)paramType).getOwnerType() == null)
    {
      paramType = ((ParameterizedType)paramType).getActualTypeArguments();
      kotlin.g.b.p.g(paramType, "actualTypeArguments");
      paramType = kotlin.a.e.W(paramType);
      AppMethodBeat.o(57406);
      return paramType;
    }
    paramType = kotlin.m.i.c(kotlin.m.i.c(kotlin.m.i.b(paramType, (kotlin.g.a.b)b.a.Tnb), (kotlin.g.a.b)b.b.Tnc));
    AppMethodBeat.o(57406);
    return paramType;
  }
  
  public static final Class<?> bA(Class<?> paramClass)
  {
    AppMethodBeat.i(57402);
    kotlin.g.b.p.h(paramClass, "$this$wrapperByPrimitive");
    paramClass = (Class)Tna.get(paramClass);
    AppMethodBeat.o(57402);
    return paramClass;
  }
  
  public static final kotlin.l.b.a.b.f.a bB(Class<?> paramClass)
  {
    AppMethodBeat.i(57403);
    kotlin.g.b.p.h(paramClass, "$this$classId");
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
      kotlin.g.b.p.g(localObject, "simpleName");
      if (((CharSequence)localObject).length() != 0) {
        break label169;
      }
    }
    label169:
    for (int i = 1; i != 0; i = 0)
    {
      paramClass = new kotlin.l.b.a.b.f.b(paramClass.getName());
      paramClass = new kotlin.l.b.a.b.f.a(paramClass.hJf(), kotlin.l.b.a.b.f.b.r(paramClass.hJg()), true);
      AppMethodBeat.o(57403);
      return paramClass;
    }
    Object localObject = paramClass.getDeclaringClass();
    if (localObject != null)
    {
      localObject = bB((Class)localObject);
      if (localObject != null)
      {
        paramClass = ((kotlin.l.b.a.b.f.a)localObject).o(kotlin.l.b.a.b.f.f.btY(paramClass.getSimpleName()));
        AppMethodBeat.o(57403);
        return paramClass;
      }
    }
    paramClass = kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b(paramClass.getName()));
    kotlin.g.b.p.g(paramClass, "ClassId.topLevel(FqName(name))");
    AppMethodBeat.o(57403);
    return paramClass;
  }
  
  public static final String bC(Class<?> paramClass)
  {
    AppMethodBeat.i(57404);
    kotlin.g.b.p.h(paramClass, "$this$desc");
    if (kotlin.g.b.p.j(paramClass, Void.TYPE))
    {
      AppMethodBeat.o(57404);
      return "V";
    }
    paramClass = bD(paramClass).getName();
    kotlin.g.b.p.g(paramClass, "createArrayType().name");
    if (paramClass == null)
    {
      paramClass = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(57404);
      throw paramClass;
    }
    paramClass = paramClass.substring(1);
    kotlin.g.b.p.g(paramClass, "(this as java.lang.String).substring(startIndex)");
    paramClass = kotlin.n.n.a(paramClass, '.', '/');
    AppMethodBeat.o(57404);
    return paramClass;
  }
  
  public static final Class<?> bD(Class<?> paramClass)
  {
    AppMethodBeat.i(57405);
    kotlin.g.b.p.h(paramClass, "$this$createArrayType");
    paramClass = Array.newInstance(paramClass, 0).getClass();
    AppMethodBeat.o(57405);
    return paramClass;
  }
  
  public static final ClassLoader bx(Class<?> paramClass)
  {
    AppMethodBeat.i(57399);
    kotlin.g.b.p.h(paramClass, "$this$safeClassLoader");
    ClassLoader localClassLoader = paramClass.getClassLoader();
    paramClass = localClassLoader;
    if (localClassLoader == null)
    {
      paramClass = ClassLoader.getSystemClassLoader();
      kotlin.g.b.p.g(paramClass, "ClassLoader.getSystemClassLoader()");
    }
    AppMethodBeat.o(57399);
    return paramClass;
  }
  
  public static final boolean by(Class<?> paramClass)
  {
    AppMethodBeat.i(57400);
    kotlin.g.b.p.h(paramClass, "$this$isEnumClassOrSpecializedEnumEntryClass");
    boolean bool = Enum.class.isAssignableFrom(paramClass);
    AppMethodBeat.o(57400);
    return bool;
  }
  
  public static final Class<?> bz(Class<?> paramClass)
  {
    AppMethodBeat.i(57401);
    kotlin.g.b.p.h(paramClass, "$this$primitiveByWrapper");
    paramClass = (Class)TmZ.get(paramClass);
    AppMethodBeat.o(57401);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.b
 * JD-Core Version:    0.7.0.1
 */