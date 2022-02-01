package d.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.r;

public final class o
{
  public static final d.l.b.a.b.f.b Jye;
  public static final d.l.b.a.b.f.a Jyf;
  
  static
  {
    AppMethodBeat.i(57614);
    Jye = new d.l.b.a.b.f.b("kotlin.jvm.JvmField");
    Jyf = d.l.b.a.b.f.a.p(new d.l.b.a.b.f.b("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
    AppMethodBeat.o(57614);
  }
  
  public static boolean aQl(String paramString)
  {
    AppMethodBeat.i(57608);
    if (paramString == null) {
      adP(4);
    }
    if ((paramString.startsWith("get")) || (paramString.startsWith("is")))
    {
      AppMethodBeat.o(57608);
      return true;
    }
    AppMethodBeat.o(57608);
    return false;
  }
  
  public static boolean aQm(String paramString)
  {
    AppMethodBeat.i(57609);
    if (paramString == null) {
      adP(5);
    }
    boolean bool = paramString.startsWith("set");
    AppMethodBeat.o(57609);
    return bool;
  }
  
  public static String aQn(String paramString)
  {
    AppMethodBeat.i(57610);
    if (paramString == null) {
      adP(6);
    }
    if (aQp(paramString)) {}
    for (;;)
    {
      if (paramString == null) {
        adP(7);
      }
      AppMethodBeat.o(57610);
      return paramString;
      paramString = "get" + d.l.b.a.b.n.a.a.aQY(paramString);
    }
  }
  
  public static String aQo(String paramString)
  {
    AppMethodBeat.i(57611);
    if (paramString == null) {
      adP(8);
    }
    StringBuilder localStringBuilder = new StringBuilder("set");
    if (aQp(paramString)) {}
    for (paramString = paramString.substring(2);; paramString = d.l.b.a.b.n.a.a.aQY(paramString))
    {
      paramString = paramString;
      if (paramString == null) {
        adP(9);
      }
      AppMethodBeat.o(57611);
      return paramString;
    }
  }
  
  private static boolean aQp(String paramString)
  {
    AppMethodBeat.i(57612);
    if (!paramString.startsWith("is"))
    {
      AppMethodBeat.o(57612);
      return false;
    }
    if (paramString.length() == 2)
    {
      AppMethodBeat.o(57612);
      return false;
    }
    int i = paramString.charAt(2);
    if ((97 > i) || (i > 122))
    {
      AppMethodBeat.o(57612);
      return true;
    }
    AppMethodBeat.o(57612);
    return false;
  }
  
  public static boolean d(ah paramah)
  {
    AppMethodBeat.i(57613);
    if (paramah == null) {
      adP(10);
    }
    if (paramah.fyu() == b.a.JpW)
    {
      AppMethodBeat.o(57613);
      return false;
    }
    Object localObject = paramah.fxq();
    if (localObject == null) {
      adP(11);
    }
    if ((d.l.b.a.b.j.c.u((l)localObject)) && (d.l.b.a.b.j.c.B(((l)localObject).fxq())))
    {
      localObject = (e)localObject;
      if (localObject == null) {
        adP(12);
      }
      d.l.b.a.b.a.c localc = d.l.b.a.b.a.c.Jlx;
      if (d.l.b.a.b.a.c.b((e)localObject)) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(57613);
      return true;
    }
    if (d.l.b.a.b.j.c.u(paramah.fxq()))
    {
      if (paramah == null) {
        adP(13);
      }
      if ((paramah instanceof ah))
      {
        localObject = ((ah)paramah).fzk();
        if ((localObject == null) || (!((r)localObject).fxF().h(Jye))) {}
      }
      for (boolean bool = true; bool; bool = paramah.fxF().h(Jye))
      {
        AppMethodBeat.o(57613);
        return true;
      }
    }
    AppMethodBeat.o(57613);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.o
 * JD-Core Version:    0.7.0.1
 */