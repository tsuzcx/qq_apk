package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.n.a.a;
import kotlin.n.n;

public final class v
{
  public static final v aiPq;
  public static final c aiPr;
  private static final b aiPs;
  
  static
  {
    AppMethodBeat.i(57614);
    aiPq = new v();
    aiPr = new c("kotlin.jvm.JvmField");
    b localb = b.s(new c("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
    s.s(localb, "topLevel(FqName(\"kotlin.….ReflectionFactoryImpl\"))");
    aiPs = localb;
    AppMethodBeat.o(57614);
  }
  
  public static final boolean bIM(String paramString)
  {
    AppMethodBeat.i(57608);
    s.u(paramString, "name");
    if ((n.U(paramString, "get", false)) || (n.U(paramString, "is", false)))
    {
      AppMethodBeat.o(57608);
      return true;
    }
    AppMethodBeat.o(57608);
    return false;
  }
  
  public static final boolean bIN(String paramString)
  {
    AppMethodBeat.i(57609);
    s.u(paramString, "name");
    boolean bool = n.U(paramString, "set", false);
    AppMethodBeat.o(57609);
    return bool;
  }
  
  public static final String bIO(String paramString)
  {
    AppMethodBeat.i(57610);
    s.u(paramString, "propertyName");
    if (bIQ(paramString))
    {
      AppMethodBeat.o(57610);
      return paramString;
    }
    paramString = s.X("get", a.bJy(paramString));
    AppMethodBeat.o(57610);
    return paramString;
  }
  
  public static final String bIP(String paramString)
  {
    AppMethodBeat.i(57611);
    s.u(paramString, "propertyName");
    if (bIQ(paramString))
    {
      paramString = paramString.substring(2);
      s.s(paramString, "(this as java.lang.String).substring(startIndex)");
    }
    for (;;)
    {
      paramString = s.X("set", paramString);
      AppMethodBeat.o(57611);
      return paramString;
      paramString = a.bJy(paramString);
    }
  }
  
  private static boolean bIQ(String paramString)
  {
    AppMethodBeat.i(57612);
    s.u(paramString, "name");
    if (!n.U(paramString, "is", false))
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
    if ((s.compare(97, i) > 0) || (s.compare(i, 122) > 0))
    {
      AppMethodBeat.o(57612);
      return true;
    }
    AppMethodBeat.o(57612);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.v
 * JD-Core Version:    0.7.0.1
 */