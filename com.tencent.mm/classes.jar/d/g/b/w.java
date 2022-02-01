package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b;
import d.l.d;
import d.l.e;
import d.l.h;
import d.l.m;

public final class w
{
  private static final x KUR;
  private static final b[] KUS;
  
  static
  {
    AppMethodBeat.i(128951);
    try
    {
      x localx1 = (x)Class.forName("d.l.b.a.aa").newInstance();
      if (localx1 != null)
      {
        KUR = localx1;
        KUS = new b[0];
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
        x localx2 = null;
        continue;
        localx2 = new x();
      }
    }
  }
  
  public static e a(j paramj)
  {
    AppMethodBeat.i(128947);
    paramj = KUR.a(paramj);
    AppMethodBeat.o(128947);
    return paramj;
  }
  
  public static h a(n paramn)
  {
    AppMethodBeat.i(128950);
    paramn = KUR.a(paramn);
    AppMethodBeat.o(128950);
    return paramn;
  }
  
  public static d.l.l a(r paramr)
  {
    AppMethodBeat.i(128948);
    paramr = KUR.a(paramr);
    AppMethodBeat.o(128948);
    return paramr;
  }
  
  public static m a(t paramt)
  {
    AppMethodBeat.i(128949);
    paramt = KUR.a(paramt);
    AppMethodBeat.o(128949);
    return paramt;
  }
  
  public static String a(i parami)
  {
    AppMethodBeat.i(128946);
    parami = KUR.a(parami);
    AppMethodBeat.o(128946);
    return parami;
  }
  
  public static String a(l paraml)
  {
    AppMethodBeat.i(128945);
    paraml = KUR.a(paraml);
    AppMethodBeat.o(128945);
    return paraml;
  }
  
  public static b bn(Class paramClass)
  {
    AppMethodBeat.i(128944);
    paramClass = KUR.bn(paramClass);
    AppMethodBeat.o(128944);
    return paramClass;
  }
  
  public static d g(Class paramClass, String paramString)
  {
    AppMethodBeat.i(128943);
    paramClass = KUR.g(paramClass, paramString);
    AppMethodBeat.o(128943);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.w
 * JD-Core Version:    0.7.0.1
 */