package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.d;
import d.g.a.e;
import d.g.a.h;
import d.g.a.i;
import d.g.a.j;
import d.g.a.k;
import d.g.a.l;
import d.g.a.n;
import d.g.a.o;
import d.g.a.q;
import d.g.a.r;
import d.g.a.s;
import d.g.a.t;
import d.g.a.u;
import d.g.a.v;
import d.g.a.w;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ae
{
  public static Iterable eP(Object paramObject)
  {
    AppMethodBeat.i(128964);
    if (((paramObject instanceof d.g.b.a.a)) && (!(paramObject instanceof d.g.b.a.c))) {
      i(paramObject, "kotlin.collections.MutableIterable");
    }
    paramObject = eQ(paramObject);
    AppMethodBeat.o(128964);
    return paramObject;
  }
  
  private static Iterable eQ(Object paramObject)
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
      paramObject = (ClassCastException)p(paramObject);
      AppMethodBeat.o(128965);
      throw paramObject;
    }
  }
  
  public static Collection eR(Object paramObject)
  {
    AppMethodBeat.i(128966);
    if (((paramObject instanceof d.g.b.a.a)) && (!(paramObject instanceof d.g.b.a.b))) {
      i(paramObject, "kotlin.collections.MutableCollection");
    }
    paramObject = eS(paramObject);
    AppMethodBeat.o(128966);
    return paramObject;
  }
  
  private static Collection eS(Object paramObject)
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
      paramObject = (ClassCastException)p(paramObject);
      AppMethodBeat.o(128967);
      throw paramObject;
    }
  }
  
  public static Set eT(Object paramObject)
  {
    AppMethodBeat.i(128968);
    if (((paramObject instanceof d.g.b.a.a)) && (!(paramObject instanceof d.g.b.a.g))) {
      i(paramObject, "kotlin.collections.MutableSet");
    }
    paramObject = eU(paramObject);
    AppMethodBeat.o(128968);
    return paramObject;
  }
  
  private static Set eU(Object paramObject)
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
      paramObject = (ClassCastException)p(paramObject);
      AppMethodBeat.o(128969);
      throw paramObject;
    }
  }
  
  public static Map eV(Object paramObject)
  {
    AppMethodBeat.i(177350);
    if (((paramObject instanceof d.g.b.a.a)) && (!(paramObject instanceof d.g.b.a.f))) {
      i(paramObject, "kotlin.collections.MutableMap");
    }
    paramObject = eW(paramObject);
    AppMethodBeat.o(177350);
    return paramObject;
  }
  
  private static Map eW(Object paramObject)
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
      paramObject = (ClassCastException)p(paramObject);
      AppMethodBeat.o(177351);
      throw paramObject;
    }
  }
  
  private static void i(Object paramObject, String paramString)
  {
    AppMethodBeat.i(128963);
    if (paramObject == null) {}
    for (paramObject = "null";; paramObject = paramObject.getClass().getName())
    {
      paramObject = (ClassCastException)p(new ClassCastException(paramObject + " cannot be cast to " + paramString));
      AppMethodBeat.o(128963);
      throw paramObject;
    }
  }
  
  public static Object p(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(199605);
    if (paramObject != null)
    {
      if (!(paramObject instanceof d.c)) {
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
        i(paramObject, "kotlin.jvm.functions.Function".concat(String.valueOf(paramInt)));
      }
      AppMethodBeat.o(199605);
      return paramObject;
      if ((paramObject instanceof d.g.a.a))
      {
        i = 0;
        break;
      }
      if ((paramObject instanceof d.g.a.b))
      {
        i = 1;
        break;
      }
      if ((paramObject instanceof d.g.a.m))
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
      if ((paramObject instanceof d.g.a.c))
      {
        i = 10;
        break;
      }
      if ((paramObject instanceof d))
      {
        i = 11;
        break;
      }
      if ((paramObject instanceof e))
      {
        i = 12;
        break;
      }
      if ((paramObject instanceof d.g.a.f))
      {
        i = 13;
        break;
      }
      if ((paramObject instanceof d.g.a.g))
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
      if ((paramObject instanceof d.g.a.p))
      {
        i = 22;
        break;
      }
      i = -1;
      break;
    }
  }
  
  private static <T extends Throwable> T p(T paramT)
  {
    AppMethodBeat.i(128962);
    paramT = p.b(paramT, ae.class.getName());
    AppMethodBeat.o(128962);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.ae
 * JD-Core Version:    0.7.0.1
 */