package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ab;
import kotlin.a.ak;
import kotlin.g.a.e;
import kotlin.g.a.g;
import kotlin.g.a.h;
import kotlin.g.a.i;
import kotlin.g.a.j;
import kotlin.g.a.l;
import kotlin.g.a.m;
import kotlin.g.a.o;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.a.t;
import kotlin.g.a.u;
import kotlin.g.a.w;
import kotlin.g.b.ai;

public final class b
{
  private static final List<kotlin.l.c<? extends Object>> aiMP;
  private static final Map<Class<? extends Object>, Class<? extends Object>> aiMQ;
  private static final Map<Class<? extends Object>, Class<? extends Object>> aiMR;
  private static final Map<Class<? extends kotlin.d<?>>, Integer> aiwO;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(57407);
    Object localObject1 = kotlin.a.p.listOf(new kotlin.l.c[] { ai.cz(Boolean.TYPE), ai.cz(Byte.TYPE), ai.cz(Character.TYPE), ai.cz(Double.TYPE), ai.cz(Float.TYPE), ai.cz(Integer.TYPE), ai.cz(Long.TYPE), ai.cz(Short.TYPE) });
    aiMP = (List)localObject1;
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (kotlin.l.c)((Iterator)localObject2).next();
      ((Collection)localObject1).add(kotlin.v.Y(kotlin.g.a.d((kotlin.l.c)localObject3), kotlin.g.a.c((kotlin.l.c)localObject3)));
    }
    aiMQ = ak.F((Iterable)localObject1);
    localObject2 = (Iterable)aiMP;
    localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (kotlin.l.c)((Iterator)localObject2).next();
      ((Collection)localObject1).add(kotlin.v.Y(kotlin.g.a.c((kotlin.l.c)localObject3), kotlin.g.a.d((kotlin.l.c)localObject3)));
    }
    aiMR = ak.F((Iterable)localObject1);
    localObject2 = (Iterable)kotlin.a.p.listOf(new Class[] { kotlin.g.a.a.class, kotlin.g.a.b.class, m.class, q.class, r.class, kotlin.g.a.s.class, t.class, u.class, kotlin.g.a.v.class, w.class, kotlin.g.a.c.class, kotlin.g.a.d.class, e.class, kotlin.g.a.f.class, g.class, h.class, i.class, j.class, kotlin.g.a.k.class, l.class, kotlin.g.a.n.class, o.class, kotlin.g.a.p.class });
    localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      ((Collection)localObject1).add(kotlin.v.Y((Class)localObject3, Integer.valueOf(i)));
      i += 1;
    }
    aiwO = ak.F((Iterable)localObject1);
    AppMethodBeat.o(57407);
  }
  
  public static final ClassLoader cI(Class<?> paramClass)
  {
    AppMethodBeat.i(57399);
    kotlin.g.b.s.u(paramClass, "<this>");
    paramClass = paramClass.getClassLoader();
    if (paramClass == null)
    {
      paramClass = ClassLoader.getSystemClassLoader();
      kotlin.g.b.s.s(paramClass, "getSystemClassLoader()");
      AppMethodBeat.o(57399);
      return paramClass;
    }
    AppMethodBeat.o(57399);
    return paramClass;
  }
  
  public static final boolean cJ(Class<?> paramClass)
  {
    AppMethodBeat.i(57400);
    kotlin.g.b.s.u(paramClass, "<this>");
    boolean bool = Enum.class.isAssignableFrom(paramClass);
    AppMethodBeat.o(57400);
    return bool;
  }
  
  public static final Class<?> cK(Class<?> paramClass)
  {
    AppMethodBeat.i(57401);
    kotlin.g.b.s.u(paramClass, "<this>");
    paramClass = (Class)aiMQ.get(paramClass);
    AppMethodBeat.o(57401);
    return paramClass;
  }
  
  public static final Class<?> cL(Class<?> paramClass)
  {
    AppMethodBeat.i(57402);
    kotlin.g.b.s.u(paramClass, "<this>");
    paramClass = (Class)aiMR.get(paramClass);
    AppMethodBeat.o(57402);
    return paramClass;
  }
  
  public static final kotlin.l.b.a.b.f.b cM(Class<?> paramClass)
  {
    AppMethodBeat.i(57403);
    kotlin.g.b.s.u(paramClass, "<this>");
    if (paramClass.isPrimitive())
    {
      paramClass = new IllegalArgumentException(kotlin.g.b.s.X("Can't compute ClassId for primitive type: ", paramClass));
      AppMethodBeat.o(57403);
      throw paramClass;
    }
    if (paramClass.isArray())
    {
      paramClass = new IllegalArgumentException(kotlin.g.b.s.X("Can't compute ClassId for array type: ", paramClass));
      AppMethodBeat.o(57403);
      throw paramClass;
    }
    if ((paramClass.getEnclosingMethod() == null) && (paramClass.getEnclosingConstructor() == null))
    {
      localObject1 = paramClass.getSimpleName();
      kotlin.g.b.s.s(localObject1, "simpleName");
      if (((CharSequence)localObject1).length() != 0) {
        break label150;
      }
    }
    label150:
    for (int i = 1; i != 0; i = 0)
    {
      paramClass = new kotlin.l.b.a.b.f.c(paramClass.getName());
      paramClass = new kotlin.l.b.a.b.f.b(paramClass.kxS(), kotlin.l.b.a.b.f.c.s(paramClass.kxT()), true);
      AppMethodBeat.o(57403);
      return paramClass;
    }
    Object localObject1 = paramClass.getDeclaringClass();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = cM((Class)localObject1).p(kotlin.l.b.a.b.f.f.bJe(paramClass.getSimpleName())))
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = kotlin.l.b.a.b.f.b.s(new kotlin.l.b.a.b.f.c(paramClass.getName()));
      }
      kotlin.g.b.s.s(localObject2, "declaringClass?.classId?…Id.topLevel(FqName(name))");
      AppMethodBeat.o(57403);
      return localObject2;
    }
  }
  
  public static final String cN(Class<?> paramClass)
  {
    AppMethodBeat.i(57404);
    kotlin.g.b.s.u(paramClass, "<this>");
    if (paramClass.isPrimitive())
    {
      localObject = paramClass.getName();
      if (localObject != null) {
        switch (((String)localObject).hashCode())
        {
        }
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        paramClass = new IllegalArgumentException(kotlin.g.b.s.X("Unsupported primitive type: ", paramClass));
                        AppMethodBeat.o(57404);
                        throw paramClass;
                      } while (!((String)localObject).equals("boolean"));
                      AppMethodBeat.o(57404);
                      return "Z";
                    } while (!((String)localObject).equals("void"));
                    AppMethodBeat.o(57404);
                    return "V";
                  } while (!((String)localObject).equals("byte"));
                  AppMethodBeat.o(57404);
                  return "B";
                } while (!((String)localObject).equals("double"));
                AppMethodBeat.o(57404);
                return "D";
              } while (!((String)localObject).equals("char"));
              AppMethodBeat.o(57404);
              return "C";
            } while (!((String)localObject).equals("short"));
            AppMethodBeat.o(57404);
            return "S";
          } while (!((String)localObject).equals("float"));
          AppMethodBeat.o(57404);
          return "F";
        } while (!((String)localObject).equals("int"));
        AppMethodBeat.o(57404);
        return "I";
      } while (!((String)localObject).equals("long"));
      AppMethodBeat.o(57404);
      return "J";
    }
    if (paramClass.isArray())
    {
      paramClass = paramClass.getName();
      kotlin.g.b.s.s(paramClass, "name");
      paramClass = kotlin.n.n.a(paramClass, '.', '/');
      AppMethodBeat.o(57404);
      return paramClass;
    }
    Object localObject = new StringBuilder("L");
    paramClass = paramClass.getName();
    kotlin.g.b.s.s(paramClass, "name");
    paramClass = kotlin.n.n.a(paramClass, '.', '/') + ';';
    AppMethodBeat.o(57404);
    return paramClass;
  }
  
  public static final List<Type> k(Type paramType)
  {
    AppMethodBeat.i(57406);
    kotlin.g.b.s.u(paramType, "<this>");
    if (!(paramType instanceof ParameterizedType))
    {
      paramType = (List)ab.aivy;
      AppMethodBeat.o(57406);
      return paramType;
    }
    if (((ParameterizedType)paramType).getOwnerType() == null)
    {
      paramType = ((ParameterizedType)paramType).getActualTypeArguments();
      kotlin.g.b.s.s(paramType, "actualTypeArguments");
      paramType = kotlin.a.k.ae((Object[])paramType);
      AppMethodBeat.o(57406);
      return paramType;
    }
    paramType = kotlin.m.k.d(kotlin.m.k.c(kotlin.m.k.b(paramType, (kotlin.g.a.b)b.a.aiMS), (kotlin.g.a.b)b.b.aiMT));
    AppMethodBeat.o(57406);
    return paramType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.b
 * JD-Core Version:    0.7.0.1
 */