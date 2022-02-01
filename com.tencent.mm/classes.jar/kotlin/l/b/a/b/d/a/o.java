package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.bi;
import kotlin.l.b.a.b.b.d.a.a;
import kotlin.l.b.a.b.b.d.a.b;
import kotlin.l.b.a.b.b.d.a.c;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.p;
import kotlin.l.b.a.b.b.q;
import kotlin.l.b.a.b.b.s;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.j.d;
import kotlin.l.b.a.b.j.g.a.e;

public final class o
{
  private static final Map<bi, t> aiGS;
  public static final t aiOQ;
  public static final t aiOR;
  public static final t aiOS;
  
  static
  {
    AppMethodBeat.i(192038);
    aiOQ = new q(a.a.aiMr)
    {
      public final boolean b(e paramAnonymouse, p paramAnonymousp, l paramAnonymousl)
      {
        AppMethodBeat.i(191964);
        if (paramAnonymousp == null) {
          aKu(0);
        }
        if (paramAnonymousl == null) {
          aKu(1);
        }
        boolean bool = o.c(paramAnonymousp, paramAnonymousl);
        AppMethodBeat.o(191964);
        return bool;
      }
    };
    aiOR = new q(a.c.aiMt)
    {
      public final boolean b(e paramAnonymouse, p paramAnonymousp, l paramAnonymousl)
      {
        AppMethodBeat.i(191967);
        if (paramAnonymousp == null) {
          aKu(0);
        }
        if (paramAnonymousl == null) {
          aKu(1);
        }
        boolean bool = o.c(paramAnonymouse, paramAnonymousp, paramAnonymousl);
        AppMethodBeat.o(191967);
        return bool;
      }
    };
    aiOS = new q(a.b.aiMs)
    {
      public final boolean b(e paramAnonymouse, p paramAnonymousp, l paramAnonymousl)
      {
        AppMethodBeat.i(191965);
        if (paramAnonymousp == null) {
          aKu(0);
        }
        if (paramAnonymousl == null) {
          aKu(1);
        }
        boolean bool = o.c(paramAnonymouse, paramAnonymousp, paramAnonymousl);
        AppMethodBeat.o(191965);
        return bool;
      }
    };
    aiGS = new HashMap();
    b(aiOQ);
    b(aiOR);
    b(aiOS);
    AppMethodBeat.o(192038);
  }
  
  public static t a(bi parambi)
  {
    AppMethodBeat.i(192023);
    if (parambi == null) {
      aKu(4);
    }
    t localt = (t)aiGS.get(parambi);
    if (localt == null)
    {
      parambi = s.a(parambi);
      if (parambi == null) {
        aKu(5);
      }
      AppMethodBeat.o(192023);
      return parambi;
    }
    if (localt == null) {
      aKu(6);
    }
    AppMethodBeat.o(192023);
    return localt;
  }
  
  private static void b(t paramt)
  {
    AppMethodBeat.i(192014);
    aiGS.put(paramt.koB(), paramt);
    AppMethodBeat.o(192014);
  }
  
  private static boolean b(l paraml1, l paraml2)
  {
    AppMethodBeat.i(192007);
    if (paraml1 == null) {
      aKu(2);
    }
    if (paraml2 == null) {
      aKu(3);
    }
    paraml1 = (ah)d.a(paraml1, ah.class, false);
    paraml2 = (ah)d.a(paraml2, ah.class, false);
    if ((paraml2 != null) && (paraml1 != null) && (paraml1.koY().equals(paraml2.koY())))
    {
      AppMethodBeat.o(192007);
      return true;
    }
    AppMethodBeat.o(192007);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.o
 * JD-Core Version:    0.7.0.1
 */