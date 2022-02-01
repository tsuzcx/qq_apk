package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.r;

public final class o
{
  public static final kotlin.l.b.a.b.f.b Tph;
  public static final kotlin.l.b.a.b.f.a Tpi;
  
  static
  {
    AppMethodBeat.i(57614);
    Tph = new kotlin.l.b.a.b.f.b("kotlin.jvm.JvmField");
    Tpi = kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
    AppMethodBeat.o(57614);
  }
  
  public static boolean btH(String paramString)
  {
    AppMethodBeat.i(57608);
    if (paramString == null) {
      atM(4);
    }
    if ((paramString.startsWith("get")) || (paramString.startsWith("is")))
    {
      AppMethodBeat.o(57608);
      return true;
    }
    AppMethodBeat.o(57608);
    return false;
  }
  
  public static boolean btI(String paramString)
  {
    AppMethodBeat.i(57609);
    if (paramString == null) {
      atM(5);
    }
    boolean bool = paramString.startsWith("set");
    AppMethodBeat.o(57609);
    return bool;
  }
  
  public static String btJ(String paramString)
  {
    AppMethodBeat.i(57610);
    if (paramString == null) {
      atM(6);
    }
    if (btL(paramString)) {}
    for (;;)
    {
      if (paramString == null) {
        atM(7);
      }
      AppMethodBeat.o(57610);
      return paramString;
      paramString = "get" + kotlin.l.b.a.b.n.a.a.but(paramString);
    }
  }
  
  public static String btK(String paramString)
  {
    AppMethodBeat.i(57611);
    if (paramString == null) {
      atM(8);
    }
    StringBuilder localStringBuilder = new StringBuilder("set");
    if (btL(paramString)) {}
    for (paramString = paramString.substring(2);; paramString = kotlin.l.b.a.b.n.a.a.but(paramString))
    {
      paramString = paramString;
      if (paramString == null) {
        atM(9);
      }
      AppMethodBeat.o(57611);
      return paramString;
    }
  }
  
  private static boolean btL(String paramString)
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
      atM(10);
    }
    if (paramah.hAA() == b.a.TgX)
    {
      AppMethodBeat.o(57613);
      return false;
    }
    Object localObject = paramah.hzx();
    if (localObject == null) {
      atM(11);
    }
    if ((kotlin.l.b.a.b.j.c.u((l)localObject)) && (kotlin.l.b.a.b.j.c.B(((l)localObject).hzx())))
    {
      localObject = (e)localObject;
      if (localObject == null) {
        atM(12);
      }
      kotlin.l.b.a.b.a.c localc = kotlin.l.b.a.b.a.c.Tcz;
      if (kotlin.l.b.a.b.a.c.b((e)localObject)) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(57613);
      return true;
    }
    if (kotlin.l.b.a.b.j.c.u(paramah.hzx()))
    {
      if (paramah == null) {
        atM(13);
      }
      if ((paramah instanceof ah))
      {
        localObject = ((ah)paramah).hBr();
        if ((localObject == null) || (!((r)localObject).hzL().h(Tph))) {}
      }
      for (boolean bool = true; bool; bool = paramah.hzL().h(Tph))
      {
        AppMethodBeat.o(57613);
        return true;
      }
    }
    AppMethodBeat.o(57613);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.o
 * JD-Core Version:    0.7.0.1
 */