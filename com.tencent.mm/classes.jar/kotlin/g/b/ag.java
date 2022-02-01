package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.a.d;
import kotlin.g.a.h;
import kotlin.g.a.i;
import kotlin.g.a.j;
import kotlin.g.a.k;
import kotlin.g.a.l;
import kotlin.g.a.n;
import kotlin.g.a.o;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.a.s;
import kotlin.g.a.t;
import kotlin.g.a.u;
import kotlin.g.a.v;
import kotlin.g.a.w;

public class ag
{
  public static Iterable fa(Object paramObject)
  {
    AppMethodBeat.i(128964);
    if (((paramObject instanceof kotlin.g.b.a.a)) && (!(paramObject instanceof kotlin.g.b.a.c))) {
      l(paramObject, "kotlin.collections.MutableIterable");
    }
    paramObject = fb(paramObject);
    AppMethodBeat.o(128964);
    return paramObject;
  }
  
  private static Iterable fb(Object paramObject)
  {
    AppMethodBeat.i(128965);
    try
    {
      paramObject = (Iterable)paramObject;
      AppMethodBeat.o(128965);
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      paramObject = (ClassCastException)r(paramObject);
      AppMethodBeat.o(128965);
      throw paramObject;
    }
  }
  
  public static Collection fc(Object paramObject)
  {
    AppMethodBeat.i(128966);
    if (((paramObject instanceof kotlin.g.b.a.a)) && (!(paramObject instanceof kotlin.g.b.a.b))) {
      l(paramObject, "kotlin.collections.MutableCollection");
    }
    paramObject = fd(paramObject);
    AppMethodBeat.o(128966);
    return paramObject;
  }
  
  private static Collection fd(Object paramObject)
  {
    AppMethodBeat.i(128967);
    try
    {
      paramObject = (Collection)paramObject;
      AppMethodBeat.o(128967);
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      paramObject = (ClassCastException)r(paramObject);
      AppMethodBeat.o(128967);
      throw paramObject;
    }
  }
  
  public static boolean fe(Object paramObject)
  {
    return ((paramObject instanceof List)) && ((!(paramObject instanceof kotlin.g.b.a.a)) || ((paramObject instanceof kotlin.g.b.a.e)));
  }
  
  public static List ff(Object paramObject)
  {
    AppMethodBeat.i(216927);
    if (((paramObject instanceof kotlin.g.b.a.a)) && (!(paramObject instanceof kotlin.g.b.a.e))) {
      l(paramObject, "kotlin.collections.MutableList");
    }
    paramObject = fg(paramObject);
    AppMethodBeat.o(216927);
    return paramObject;
  }
  
  private static List fg(Object paramObject)
  {
    AppMethodBeat.i(216930);
    try
    {
      paramObject = (List)paramObject;
      AppMethodBeat.o(216930);
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      paramObject = (ClassCastException)r(paramObject);
      AppMethodBeat.o(216930);
      throw paramObject;
    }
  }
  
  public static boolean fh(Object paramObject)
  {
    return ((paramObject instanceof Set)) && ((!(paramObject instanceof kotlin.g.b.a.a)) || ((paramObject instanceof kotlin.g.b.a.g)));
  }
  
  public static Set fi(Object paramObject)
  {
    AppMethodBeat.i(128968);
    if (((paramObject instanceof kotlin.g.b.a.a)) && (!(paramObject instanceof kotlin.g.b.a.g))) {
      l(paramObject, "kotlin.collections.MutableSet");
    }
    paramObject = fj(paramObject);
    AppMethodBeat.o(128968);
    return paramObject;
  }
  
  private static Set fj(Object paramObject)
  {
    AppMethodBeat.i(128969);
    try
    {
      paramObject = (Set)paramObject;
      AppMethodBeat.o(128969);
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      paramObject = (ClassCastException)r(paramObject);
      AppMethodBeat.o(128969);
      throw paramObject;
    }
  }
  
  public static Map fk(Object paramObject)
  {
    AppMethodBeat.i(177350);
    if (((paramObject instanceof kotlin.g.b.a.a)) && (!(paramObject instanceof kotlin.g.b.a.f))) {
      l(paramObject, "kotlin.collections.MutableMap");
    }
    paramObject = fl(paramObject);
    AppMethodBeat.o(177350);
    return paramObject;
  }
  
  private static Map fl(Object paramObject)
  {
    AppMethodBeat.i(177351);
    try
    {
      paramObject = (Map)paramObject;
      AppMethodBeat.o(177351);
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      paramObject = (ClassCastException)r(paramObject);
      AppMethodBeat.o(177351);
      throw paramObject;
    }
  }
  
  private static void l(Object paramObject, String paramString)
  {
    AppMethodBeat.i(128963);
    if (paramObject == null) {}
    for (paramObject = "null";; paramObject = paramObject.getClass().getName())
    {
      paramObject = (ClassCastException)r(new ClassCastException(paramObject + " cannot be cast to " + paramString));
      AppMethodBeat.o(128963);
      throw paramObject;
    }
  }
  
  private static <T extends Throwable> T r(T paramT)
  {
    AppMethodBeat.i(128962);
    paramT = p.c(paramT, ag.class.getName());
    AppMethodBeat.o(128962);
    return paramT;
  }
  
  public static Object x(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(216943);
    if (paramObject != null)
    {
      if (!(paramObject instanceof kotlin.c)) {
        break label362;
      }
      if (!(paramObject instanceof m)) {
        break label64;
      }
      i = ((m)paramObject).getArity();
      if (i != paramInt) {
        break label362;
      }
    }
    label64:
    label362:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        l(paramObject, "kotlin.jvm.functions.Function".concat(String.valueOf(paramInt)));
      }
      AppMethodBeat.o(216943);
      return paramObject;
      if ((paramObject instanceof kotlin.g.a.a))
      {
        i = 0;
        break;
      }
      if ((paramObject instanceof kotlin.g.a.b))
      {
        i = 1;
        break;
      }
      if ((paramObject instanceof kotlin.g.a.m))
      {
        i = 2;
        break;
      }
      if ((paramObject instanceof q))
      {
        i = 3;
        break;
      }
      if ((paramObject instanceof r))
      {
        i = 4;
        break;
      }
      if ((paramObject instanceof s))
      {
        i = 5;
        break;
      }
      if ((paramObject instanceof t))
      {
        i = 6;
        break;
      }
      if ((paramObject instanceof u))
      {
        i = 7;
        break;
      }
      if ((paramObject instanceof v))
      {
        i = 8;
        break;
      }
      if ((paramObject instanceof w))
      {
        i = 9;
        break;
      }
      if ((paramObject instanceof kotlin.g.a.c))
      {
        i = 10;
        break;
      }
      if ((paramObject instanceof d))
      {
        i = 11;
        break;
      }
      if ((paramObject instanceof kotlin.g.a.e))
      {
        i = 12;
        break;
      }
      if ((paramObject instanceof kotlin.g.a.f))
      {
        i = 13;
        break;
      }
      if ((paramObject instanceof kotlin.g.a.g))
      {
        i = 14;
        break;
      }
      if ((paramObject instanceof h))
      {
        i = 15;
        break;
      }
      if ((paramObject instanceof i))
      {
        i = 16;
        break;
      }
      if ((paramObject instanceof j))
      {
        i = 17;
        break;
      }
      if ((paramObject instanceof k))
      {
        i = 18;
        break;
      }
      if ((paramObject instanceof l))
      {
        i = 19;
        break;
      }
      if ((paramObject instanceof n))
      {
        i = 20;
        break;
      }
      if ((paramObject instanceof o))
      {
        i = 21;
        break;
      }
      if ((paramObject instanceof kotlin.g.a.p))
      {
        i = 22;
        break;
      }
      i = -1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.g.b.ag
 * JD-Core Version:    0.7.0.1
 */