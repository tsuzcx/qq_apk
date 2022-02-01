package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b;
import kotlin.l.e;
import kotlin.l.h;
import kotlin.l.j;
import kotlin.l.p;
import kotlin.l.r;

public final class ab
{
  private static final ac aaBD;
  private static final b[] aaBE;
  
  static
  {
    AppMethodBeat.i(128951);
    try
    {
      ac localac1 = (ac)Class.forName("kotlin.l.b.a.z").newInstance();
      if (localac1 != null)
      {
        aaBD = localac1;
        aaBE = new b[0];
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
        ac localac2 = null;
        continue;
        localac2 = new ac();
      }
    }
  }
  
  public static String a(m paramm)
  {
    AppMethodBeat.i(128946);
    paramm = aaBD.a(paramm);
    AppMethodBeat.o(128946);
    return paramm;
  }
  
  public static String a(q paramq)
  {
    AppMethodBeat.i(128945);
    paramq = aaBD.a(paramq);
    AppMethodBeat.o(128945);
    return paramq;
  }
  
  public static e a(n paramn)
  {
    AppMethodBeat.i(128947);
    paramn = aaBD.a(paramn);
    AppMethodBeat.o(128947);
    return paramn;
  }
  
  public static h a(t paramt)
  {
    AppMethodBeat.i(216878);
    paramt = aaBD.a(paramt);
    AppMethodBeat.o(216878);
    return paramt;
  }
  
  public static j a(u paramu)
  {
    AppMethodBeat.i(128950);
    paramu = aaBD.a(paramu);
    AppMethodBeat.o(128950);
    return paramu;
  }
  
  public static p a(x paramx)
  {
    AppMethodBeat.i(128948);
    paramx = aaBD.a(paramx);
    AppMethodBeat.o(128948);
    return paramx;
  }
  
  public static r a(y paramy)
  {
    AppMethodBeat.i(128949);
    paramy = aaBD.a(paramy);
    AppMethodBeat.o(128949);
    return paramy;
  }
  
  public static b bO(Class paramClass)
  {
    AppMethodBeat.i(128944);
    paramClass = aaBD.bO(paramClass);
    AppMethodBeat.o(128944);
    return paramClass;
  }
  
  public static b[] d(Class[] paramArrayOfClass)
  {
    AppMethodBeat.i(216867);
    int j = paramArrayOfClass.length;
    if (j == 0)
    {
      paramArrayOfClass = aaBE;
      AppMethodBeat.o(216867);
      return paramArrayOfClass;
    }
    b[] arrayOfb = new b[j];
    int i = 0;
    while (i < j)
    {
      Class localClass = paramArrayOfClass[i];
      arrayOfb[i] = aaBD.bO(localClass);
      i += 1;
    }
    AppMethodBeat.o(216867);
    return arrayOfb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.g.b.ab
 * JD-Core Version:    0.7.0.1
 */