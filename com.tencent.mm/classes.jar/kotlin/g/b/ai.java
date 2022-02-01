package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.c;
import kotlin.l.e;
import kotlin.l.f;
import kotlin.l.i;
import kotlin.l.k;
import kotlin.l.q;
import kotlin.l.r;

public final class ai
{
  private static final aj aixd;
  private static final c[] aixe;
  
  static
  {
    AppMethodBeat.i(128951);
    try
    {
      aj localaj1 = (aj)Class.forName("kotlin.l.b.a.ad").newInstance();
      if (localaj1 != null)
      {
        aixd = localaj1;
        aixe = new c[0];
        AppMethodBeat.o(128951);
        return;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        Object localObject1 = null;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;)
      {
        Object localObject3 = null;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        aj localaj2 = null;
        continue;
        localaj2 = new aj();
      }
    }
  }
  
  public static String a(o paramo)
  {
    AppMethodBeat.i(128946);
    paramo = aixd.a(paramo);
    AppMethodBeat.o(128946);
    return paramo;
  }
  
  public static String a(u paramu)
  {
    AppMethodBeat.i(128945);
    paramu = aixd.a(paramu);
    AppMethodBeat.o(128945);
    return paramu;
  }
  
  public static f a(p paramp)
  {
    AppMethodBeat.i(128947);
    paramp = aixd.a(paramp);
    AppMethodBeat.o(128947);
    return paramp;
  }
  
  public static i a(x paramx)
  {
    AppMethodBeat.i(190999);
    paramx = aixd.a(paramx);
    AppMethodBeat.o(190999);
    return paramx;
  }
  
  public static k a(z paramz)
  {
    AppMethodBeat.i(128950);
    paramz = aixd.a(paramz);
    AppMethodBeat.o(128950);
    return paramz;
  }
  
  public static q a(ad paramad)
  {
    AppMethodBeat.i(128948);
    paramad = aixd.a(paramad);
    AppMethodBeat.o(128948);
    return paramad;
  }
  
  public static r a(af paramaf)
  {
    AppMethodBeat.i(128949);
    paramaf = aixd.a(paramaf);
    AppMethodBeat.o(128949);
    return paramaf;
  }
  
  public static e cy(Class paramClass)
  {
    AppMethodBeat.i(190978);
    paramClass = aixd.p(paramClass, "");
    AppMethodBeat.o(190978);
    return paramClass;
  }
  
  public static c cz(Class paramClass)
  {
    AppMethodBeat.i(128944);
    paramClass = aixd.cz(paramClass);
    AppMethodBeat.o(128944);
    return paramClass;
  }
  
  public static c[] d(Class[] paramArrayOfClass)
  {
    AppMethodBeat.i(190990);
    int j = paramArrayOfClass.length;
    if (j == 0)
    {
      paramArrayOfClass = aixe;
      AppMethodBeat.o(190990);
      return paramArrayOfClass;
    }
    c[] arrayOfc = new c[j];
    int i = 0;
    while (i < j)
    {
      Class localClass = paramArrayOfClass[i];
      arrayOfc[i] = aixd.cz(localClass);
      i += 1;
    }
    AppMethodBeat.o(190990);
    return arrayOfc;
  }
  
  public static e p(Class paramClass, String paramString)
  {
    AppMethodBeat.i(128943);
    paramClass = aixd.p(paramClass, paramString);
    AppMethodBeat.o(128943);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.g.b.ai
 * JD-Core Version:    0.7.0.1
 */