package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.a.f;
import kotlin.g.a.i;
import kotlin.g.a.j;
import kotlin.g.a.k;
import kotlin.g.a.l;
import kotlin.g.a.m;
import kotlin.g.a.n;
import kotlin.g.a.p;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.a.t;
import kotlin.g.a.u;
import kotlin.g.a.v;
import kotlin.g.a.w;
import kotlin.g.b.a.g.a;

public class an
{
  private static <T extends Throwable> T H(T paramT)
  {
    AppMethodBeat.i(128962);
    paramT = s.c(paramT, an.class.getName());
    AppMethodBeat.o(128962);
    return paramT;
  }
  
  public static Collection hA(Object paramObject)
  {
    AppMethodBeat.i(128966);
    if (((paramObject instanceof kotlin.g.b.a.a)) && (!(paramObject instanceof kotlin.g.b.a.b))) {
      v(paramObject, "kotlin.collections.MutableCollection");
    }
    paramObject = hB(paramObject);
    AppMethodBeat.o(128966);
    return paramObject;
  }
  
  private static Collection hB(Object paramObject)
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
      paramObject = (ClassCastException)H(paramObject);
      AppMethodBeat.o(128967);
      throw paramObject;
    }
  }
  
  public static boolean hC(Object paramObject)
  {
    return ((paramObject instanceof List)) && ((!(paramObject instanceof kotlin.g.b.a.a)) || ((paramObject instanceof kotlin.g.b.a.e)));
  }
  
  public static List hD(Object paramObject)
  {
    AppMethodBeat.i(190995);
    if (((paramObject instanceof kotlin.g.b.a.a)) && (!(paramObject instanceof kotlin.g.b.a.e))) {
      v(paramObject, "kotlin.collections.MutableList");
    }
    paramObject = hE(paramObject);
    AppMethodBeat.o(190995);
    return paramObject;
  }
  
  private static List hE(Object paramObject)
  {
    AppMethodBeat.i(190997);
    try
    {
      paramObject = (List)paramObject;
      AppMethodBeat.o(190997);
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      paramObject = (ClassCastException)H(paramObject);
      AppMethodBeat.o(190997);
      throw paramObject;
    }
  }
  
  public static boolean hF(Object paramObject)
  {
    return ((paramObject instanceof Set)) && ((!(paramObject instanceof kotlin.g.b.a.a)) || ((paramObject instanceof kotlin.g.b.a.h)));
  }
  
  public static Set hG(Object paramObject)
  {
    AppMethodBeat.i(128968);
    if (((paramObject instanceof kotlin.g.b.a.a)) && (!(paramObject instanceof kotlin.g.b.a.h))) {
      v(paramObject, "kotlin.collections.MutableSet");
    }
    paramObject = hH(paramObject);
    AppMethodBeat.o(128968);
    return paramObject;
  }
  
  private static Set hH(Object paramObject)
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
      paramObject = (ClassCastException)H(paramObject);
      AppMethodBeat.o(128969);
      throw paramObject;
    }
  }
  
  public static boolean hI(Object paramObject)
  {
    return ((paramObject instanceof Map)) && ((!(paramObject instanceof kotlin.g.b.a.a)) || ((paramObject instanceof kotlin.g.b.a.g)));
  }
  
  public static Map hJ(Object paramObject)
  {
    AppMethodBeat.i(177350);
    if (((paramObject instanceof kotlin.g.b.a.a)) && (!(paramObject instanceof kotlin.g.b.a.g))) {
      v(paramObject, "kotlin.collections.MutableMap");
    }
    paramObject = hK(paramObject);
    AppMethodBeat.o(177350);
    return paramObject;
  }
  
  private static Map hK(Object paramObject)
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
      paramObject = (ClassCastException)H(paramObject);
      AppMethodBeat.o(177351);
      throw paramObject;
    }
  }
  
  public static boolean hL(Object paramObject)
  {
    return ((paramObject instanceof Map.Entry)) && ((!(paramObject instanceof kotlin.g.b.a.a)) || ((paramObject instanceof g.a)));
  }
  
  public static Iterable hy(Object paramObject)
  {
    AppMethodBeat.i(128964);
    if (((paramObject instanceof kotlin.g.b.a.a)) && (!(paramObject instanceof kotlin.g.b.a.c))) {
      v(paramObject, "kotlin.collections.MutableIterable");
    }
    paramObject = hz(paramObject);
    AppMethodBeat.o(128964);
    return paramObject;
  }
  
  private static Iterable hz(Object paramObject)
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
      paramObject = (ClassCastException)H(paramObject);
      AppMethodBeat.o(128965);
      throw paramObject;
    }
  }
  
  private static void v(Object paramObject, String paramString)
  {
    AppMethodBeat.i(128963);
    if (paramObject == null) {}
    for (paramObject = "null";; paramObject = paramObject.getClass().getName())
    {
      paramObject = (ClassCastException)H(new ClassCastException(paramObject + " cannot be cast to " + paramString));
      AppMethodBeat.o(128963);
      throw paramObject;
    }
  }
  
  public static boolean x(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(191009);
    if ((paramObject instanceof kotlin.d))
    {
      int i;
      if ((paramObject instanceof o)) {
        i = ((o)paramObject).getArity();
      }
      while (i == paramInt)
      {
        AppMethodBeat.o(191009);
        return true;
        if ((paramObject instanceof kotlin.g.a.a)) {
          i = 0;
        } else if ((paramObject instanceof kotlin.g.a.b)) {
          i = 1;
        } else if ((paramObject instanceof m)) {
          i = 2;
        } else if ((paramObject instanceof q)) {
          i = 3;
        } else if ((paramObject instanceof r)) {
          i = 4;
        } else if ((paramObject instanceof kotlin.g.a.s)) {
          i = 5;
        } else if ((paramObject instanceof t)) {
          i = 6;
        } else if ((paramObject instanceof u)) {
          i = 7;
        } else if ((paramObject instanceof v)) {
          i = 8;
        } else if ((paramObject instanceof w)) {
          i = 9;
        } else if ((paramObject instanceof kotlin.g.a.c)) {
          i = 10;
        } else if ((paramObject instanceof kotlin.g.a.d)) {
          i = 11;
        } else if ((paramObject instanceof kotlin.g.a.e)) {
          i = 12;
        } else if ((paramObject instanceof f)) {
          i = 13;
        } else if ((paramObject instanceof kotlin.g.a.g)) {
          i = 14;
        } else if ((paramObject instanceof kotlin.g.a.h)) {
          i = 15;
        } else if ((paramObject instanceof i)) {
          i = 16;
        } else if ((paramObject instanceof j)) {
          i = 17;
        } else if ((paramObject instanceof k)) {
          i = 18;
        } else if ((paramObject instanceof l)) {
          i = 19;
        } else if ((paramObject instanceof n)) {
          i = 20;
        } else if ((paramObject instanceof kotlin.g.a.o)) {
          i = 21;
        } else if ((paramObject instanceof p)) {
          i = 22;
        } else {
          i = -1;
        }
      }
    }
    AppMethodBeat.o(191009);
    return false;
  }
  
  public static Object y(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(191011);
    if ((paramObject != null) && (!x(paramObject, paramInt))) {
      v(paramObject, "kotlin.jvm.functions.Function".concat(String.valueOf(paramInt)));
    }
    AppMethodBeat.o(191011);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.g.b.an
 * JD-Core Version:    0.7.0.1
 */