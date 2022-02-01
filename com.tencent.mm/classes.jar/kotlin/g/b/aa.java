package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b;
import kotlin.l.e;
import kotlin.l.g;
import kotlin.l.h;

public final class aa
{
  private static final ab SYH;
  private static final b[] SYI;
  
  static
  {
    AppMethodBeat.i(128951);
    try
    {
      ab localab1 = (ab)Class.forName("kotlin.l.b.a.z").newInstance();
      if (localab1 != null)
      {
        SYH = localab1;
        SYI = new b[0];
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
        ab localab2 = null;
        continue;
        localab2 = new ab();
      }
    }
  }
  
  public static String a(m paramm)
  {
    AppMethodBeat.i(128946);
    paramm = SYH.a(paramm);
    AppMethodBeat.o(128946);
    return paramm;
  }
  
  public static String a(q paramq)
  {
    AppMethodBeat.i(128945);
    paramq = SYH.a(paramq);
    AppMethodBeat.o(128945);
    return paramq;
  }
  
  public static e a(n paramn)
  {
    AppMethodBeat.i(128947);
    paramn = SYH.a(paramn);
    AppMethodBeat.o(128947);
    return paramn;
  }
  
  public static g a(t paramt)
  {
    AppMethodBeat.i(206187);
    paramt = SYH.a(paramt);
    AppMethodBeat.o(206187);
    return paramt;
  }
  
  public static h a(u paramu)
  {
    AppMethodBeat.i(128950);
    paramu = SYH.a(paramu);
    AppMethodBeat.o(128950);
    return paramu;
  }
  
  public static kotlin.l.m a(x paramx)
  {
    AppMethodBeat.i(128949);
    paramx = SYH.a(paramx);
    AppMethodBeat.o(128949);
    return paramx;
  }
  
  public static b bp(Class paramClass)
  {
    AppMethodBeat.i(128944);
    paramClass = SYH.bp(paramClass);
    AppMethodBeat.o(128944);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.g.b.aa
 * JD-Core Version:    0.7.0.1
 */