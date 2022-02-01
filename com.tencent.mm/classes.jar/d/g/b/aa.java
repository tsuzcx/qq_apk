package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.d;
import d.g.a.e;
import d.g.a.h;
import d.g.a.j;
import d.g.a.l;
import d.g.a.m;
import d.g.a.n;
import d.g.a.o;
import d.g.a.p;
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

public class aa
{
  public static Iterable eJ(Object paramObject)
  {
    AppMethodBeat.i(128964);
    if (((paramObject instanceof d.g.b.a.a)) && (!(paramObject instanceof d.g.b.a.c))) {
      i(paramObject, "kotlin.collections.MutableIterable");
    }
    paramObject = eK(paramObject);
    AppMethodBeat.o(128964);
    return paramObject;
  }
  
  private static Iterable eK(Object paramObject)
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
      paramObject = (ClassCastException)o(paramObject);
      AppMethodBeat.o(128965);
      throw paramObject;
    }
  }
  
  public static Collection eL(Object paramObject)
  {
    AppMethodBeat.i(128966);
    if (((paramObject instanceof d.g.b.a.a)) && (!(paramObject instanceof d.g.b.a.b))) {
      i(paramObject, "kotlin.collections.MutableCollection");
    }
    paramObject = eM(paramObject);
    AppMethodBeat.o(128966);
    return paramObject;
  }
  
  private static Collection eM(Object paramObject)
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
      paramObject = (ClassCastException)o(paramObject);
      AppMethodBeat.o(128967);
      throw paramObject;
    }
  }
  
  public static Set eN(Object paramObject)
  {
    AppMethodBeat.i(128968);
    if (((paramObject instanceof d.g.b.a.a)) && (!(paramObject instanceof d.g.b.a.g))) {
      i(paramObject, "kotlin.collections.MutableSet");
    }
    paramObject = eO(paramObject);
    AppMethodBeat.o(128968);
    return paramObject;
  }
  
  private static Set eO(Object paramObject)
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
      paramObject = (ClassCastException)o(paramObject);
      AppMethodBeat.o(128969);
      throw paramObject;
    }
  }
  
  public static Map eP(Object paramObject)
  {
    AppMethodBeat.i(177350);
    if (((paramObject instanceof d.g.b.a.a)) && (!(paramObject instanceof d.g.b.a.f))) {
      i(paramObject, "kotlin.collections.MutableMap");
    }
    paramObject = eQ(paramObject);
    AppMethodBeat.o(177350);
    return paramObject;
  }
  
  private static Map eQ(Object paramObject)
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
      paramObject = (ClassCastException)o(paramObject);
      AppMethodBeat.o(177351);
      throw paramObject;
    }
  }
  
  public static Object eR(Object paramObject)
  {
    AppMethodBeat.i(128970);
    if (paramObject != null)
    {
      if (!(paramObject instanceof d.c)) {
        break label355;
      }
      if (!(paramObject instanceof i)) {
        break label57;
      }
      i = ((i)paramObject).getArity();
      if (i != 2) {
        break label355;
      }
    }
    label57:
    label355:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        i(paramObject, "kotlin.jvm.functions.Function2");
      }
      AppMethodBeat.o(128970);
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
      if ((paramObject instanceof m))
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
      if ((paramObject instanceof d.g.a.i))
      {
        i = 16;
        break;
      }
      if ((paramObject instanceof j))
      {
        i = 17;
        break;
      }
      if ((paramObject instanceof d.g.a.k))
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
      if ((paramObject instanceof p))
      {
        i = 22;
        break;
      }
      i = -1;
      break;
    }
  }
  
  private static void i(Object paramObject, String paramString)
  {
    AppMethodBeat.i(128963);
    if (paramObject == null) {}
    for (paramObject = "null";; paramObject = paramObject.getClass().getName())
    {
      paramObject = (ClassCastException)o(new ClassCastException(paramObject + " cannot be cast to " + paramString));
      AppMethodBeat.o(128963);
      throw paramObject;
    }
  }
  
  private static <T extends Throwable> T o(T paramT)
  {
    AppMethodBeat.i(128962);
    paramT = k.b(paramT, aa.class.getName());
    AppMethodBeat.o(128962);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.aa
 * JD-Core Version:    0.7.0.1
 */