package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b;
import d.l.e;
import d.l.h;

public final class z
{
  private static final aa NiZ;
  private static final b[] Nja;
  
  static
  {
    AppMethodBeat.i(128951);
    try
    {
      aa localaa1 = (aa)Class.forName("d.l.b.a.z").newInstance();
      if (localaa1 != null)
      {
        NiZ = localaa1;
        Nja = new b[0];
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
        aa localaa2 = null;
        continue;
        localaa2 = new aa();
      }
    }
  }
  
  public static e a(n paramn)
  {
    AppMethodBeat.i(128947);
    paramn = NiZ.a(paramn);
    AppMethodBeat.o(128947);
    return paramn;
  }
  
  public static h a(t paramt)
  {
    AppMethodBeat.i(128950);
    paramt = NiZ.a(paramt);
    AppMethodBeat.o(128950);
    return paramt;
  }
  
  public static d.l.m a(w paramw)
  {
    AppMethodBeat.i(128949);
    paramw = NiZ.a(paramw);
    AppMethodBeat.o(128949);
    return paramw;
  }
  
  public static String a(m paramm)
  {
    AppMethodBeat.i(128946);
    paramm = NiZ.a(paramm);
    AppMethodBeat.o(128946);
    return paramm;
  }
  
  public static String a(q paramq)
  {
    AppMethodBeat.i(128945);
    paramq = NiZ.a(paramq);
    AppMethodBeat.o(128945);
    return paramq;
  }
  
  public static b bp(Class paramClass)
  {
    AppMethodBeat.i(128944);
    paramClass = NiZ.bp(paramClass);
    AppMethodBeat.o(128944);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.z
 * JD-Core Version:    0.7.0.1
 */