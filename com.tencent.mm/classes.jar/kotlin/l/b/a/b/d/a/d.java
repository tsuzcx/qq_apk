package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.d.b.t;
import kotlin.l.b.a.b.f.f;

public final class d
  extends ad
{
  public static final d aiOu;
  
  static
  {
    AppMethodBeat.i(57551);
    aiOu = new d();
    AppMethodBeat.o(57551);
  }
  
  public static f a(au paramau)
  {
    AppMethodBeat.i(57547);
    s.u(paramau, "functionDescriptor");
    Map localMap = ad.ksa();
    paramau = t.c((kotlin.l.b.a.b.b.a)paramau);
    if (paramau == null)
    {
      AppMethodBeat.o(57547);
      return null;
    }
    paramau = (f)localMap.get(paramau);
    AppMethodBeat.o(57547);
    return paramau;
  }
  
  public static boolean b(au paramau)
  {
    AppMethodBeat.i(57548);
    s.u(paramau, "functionDescriptor");
    if ((h.c((l)paramau)) && (kotlin.l.b.a.b.j.d.a.b((kotlin.l.b.a.b.b.b)paramau, (kotlin.g.a.b)new a(paramau)) != null))
    {
      AppMethodBeat.o(57548);
      return true;
    }
    AppMethodBeat.o(57548);
    return false;
  }
  
  public static boolean c(au paramau)
  {
    AppMethodBeat.i(57550);
    s.u(paramau, "<this>");
    if ((s.p(paramau.kok().PF(), "removeAt")) && (s.p(t.c((kotlin.l.b.a.b.b.a)paramau), ad.krZ().signature)))
    {
      AppMethodBeat.o(57550);
      return true;
    }
    AppMethodBeat.o(57550);
    return false;
  }
  
  static final class a
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean>
  {
    a(au paramau)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.d
 * JD-Core Version:    0.7.0.1
 */