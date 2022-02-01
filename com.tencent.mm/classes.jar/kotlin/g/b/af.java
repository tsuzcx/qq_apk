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

public class af
{
  public static Iterable eT(Object paramObject)
  {
    AppMethodBeat.i(128964);
    if (((paramObject instanceof kotlin.g.b.a.a)) && (!(paramObject instanceof kotlin.g.b.a.c))) {
      i(paramObject, "kotlin.collections.MutableIterable");
    }
    paramObject = eU(paramObject);
    AppMethodBeat.o(128964);
    return paramObject;
  }
  
  private static Iterable eU(Object paramObject)
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
  
  public static Collection eV(Object paramObject)
  {
    AppMethodBeat.i(128966);
    if (((paramObject instanceof kotlin.g.b.a.a)) && (!(paramObject instanceof kotlin.g.b.a.b))) {
      i(paramObject, "kotlin.collections.MutableCollection");
    }
    paramObject = eW(paramObject);
    AppMethodBeat.o(128966);
    return paramObject;
  }
  
  private static Collection eW(Object paramObject)
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
  
  public static boolean eX(Object paramObject)
  {
    return ((paramObject instanceof List)) && ((!(paramObject instanceof kotlin.g.b.a.a)) || ((paramObject instanceof kotlin.g.b.a.e)));
  }
  
  public static List eY(Object paramObject)
  {
    AppMethodBeat.i(206188);
    if (((paramObject instanceof kotlin.g.b.a.a)) && (!(paramObject instanceof kotlin.g.b.a.e))) {
      i(paramObject, "kotlin.collections.MutableList");
    }
    paramObject = eZ(paramObject);
    AppMethodBeat.o(206188);
    return paramObject;
  }
  
  private static List eZ(Object paramObject)
  {
    AppMethodBeat.i(206189);
    try
    {
      paramObject = (List)paramObject;
      AppMethodBeat.o(206189);
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      paramObject = (ClassCastException)r(paramObject);
      AppMethodBeat.o(206189);
      throw paramObject;
    }
  }
  
  public static boolean fa(Object paramObject)
  {
    return ((paramObject instanceof Set)) && ((!(paramObject instanceof kotlin.g.b.a.a)) || ((paramObject instanceof kotlin.g.b.a.g)));
  }
  
  public static Set fb(Object paramObject)
  {
    AppMethodBeat.i(128968);
    if (((paramObject instanceof kotlin.g.b.a.a)) && (!(paramObject instanceof kotlin.g.b.a.g))) {
      i(paramObject, "kotlin.collections.MutableSet");
    }
    paramObject = fc(paramObject);
    AppMethodBeat.o(128968);
    return paramObject;
  }
  
  private static Set fc(Object paramObject)
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
  
  public static Map fd(Object paramObject)
  {
    AppMethodBeat.i(177350);
    if (((paramObject instanceof kotlin.g.b.a.a)) && (!(paramObject instanceof kotlin.g.b.a.f))) {
      i(paramObject, "kotlin.collections.MutableMap");
    }
    paramObject = fe(paramObject);
    AppMethodBeat.o(177350);
    return paramObject;
  }
  
  private static Map fe(Object paramObject)
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
  
  private static void i(Object paramObject, String paramString)
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
  
  public static Object r(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(206190);
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
        i(paramObject, "kotlin.jvm.functions.Function".concat(String.valueOf(paramInt)));
      }
      AppMethodBeat.o(206190);
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
  
  private static <T extends Throwable> T r(T paramT)
  {
    AppMethodBeat.i(128962);
    paramT = p.c(paramT, af.class.getName());
    AppMethodBeat.o(128962);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.g.b.af
 * JD-Core Version:    0.7.0.1
 */