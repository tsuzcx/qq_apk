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
  public static final kotlin.l.b.a.b.f.b aaSb;
  public static final kotlin.l.b.a.b.f.a aaSc;
  
  static
  {
    AppMethodBeat.i(57614);
    aaSb = new kotlin.l.b.a.b.f.b("kotlin.jvm.JvmField");
    aaSc = kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
    AppMethodBeat.o(57614);
  }
  
  public static boolean bGK(String paramString)
  {
    AppMethodBeat.i(57608);
    if (paramString == null) {
      aDG(4);
    }
    if ((paramString.startsWith("get")) || (paramString.startsWith("is")))
    {
      AppMethodBeat.o(57608);
      return true;
    }
    AppMethodBeat.o(57608);
    return false;
  }
  
  public static boolean bGL(String paramString)
  {
    AppMethodBeat.i(57609);
    if (paramString == null) {
      aDG(5);
    }
    boolean bool = paramString.startsWith("set");
    AppMethodBeat.o(57609);
    return bool;
  }
  
  public static String bGM(String paramString)
  {
    AppMethodBeat.i(57610);
    if (paramString == null) {
      aDG(6);
    }
    if (bGO(paramString)) {}
    for (;;)
    {
      if (paramString == null) {
        aDG(7);
      }
      AppMethodBeat.o(57610);
      return paramString;
      paramString = "get" + kotlin.l.b.a.b.n.a.a.bHv(paramString);
    }
  }
  
  public static String bGN(String paramString)
  {
    AppMethodBeat.i(57611);
    if (paramString == null) {
      aDG(8);
    }
    StringBuilder localStringBuilder = new StringBuilder("set");
    if (bGO(paramString)) {}
    for (paramString = paramString.substring(2);; paramString = kotlin.l.b.a.b.n.a.a.bHv(paramString))
    {
      paramString = paramString;
      if (paramString == null) {
        aDG(9);
      }
      AppMethodBeat.o(57611);
      return paramString;
    }
  }
  
  private static boolean bGO(String paramString)
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
      aDG(10);
    }
    if (paramah.iEN() == b.a.aaJR)
    {
      AppMethodBeat.o(57613);
      return false;
    }
    Object localObject = paramah.iDJ();
    if (localObject == null) {
      aDG(11);
    }
    if ((kotlin.l.b.a.b.j.c.u((l)localObject)) && (kotlin.l.b.a.b.j.c.B(((l)localObject).iDJ())))
    {
      localObject = (e)localObject;
      if (localObject == null) {
        aDG(12);
      }
      kotlin.l.b.a.b.a.c localc = kotlin.l.b.a.b.a.c.aaFt;
      if (kotlin.l.b.a.b.a.c.b((e)localObject)) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(57613);
      return true;
    }
    if (kotlin.l.b.a.b.j.c.u(paramah.iDJ()))
    {
      if (paramah == null) {
        aDG(13);
      }
      if ((paramah instanceof ah))
      {
        localObject = ((ah)paramah).iFG();
        if ((localObject == null) || (!((r)localObject).iDY().h(aaSb))) {}
      }
      for (boolean bool = true; bool; bool = paramah.iDY().h(aaSb))
      {
        AppMethodBeat.o(57613);
        return true;
      }
    }
    AppMethodBeat.o(57613);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.o
 * JD-Core Version:    0.7.0.1
 */