package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.v;
import kotlin.l.b.a.b.m.a.g.a;

public final class a
{
  public static final a abjQ;
  
  static
  {
    AppMethodBeat.i(59881);
    abjQ = new a();
    AppMethodBeat.o(59881);
  }
  
  private final boolean a(as paramas1, as paramas2, boolean paramBoolean, m<? super l, ? super l, Boolean> paramm)
  {
    AppMethodBeat.i(59878);
    if (p.h(paramas1, paramas2))
    {
      AppMethodBeat.o(59878);
      return true;
    }
    if (p.h(paramas1.iDJ(), paramas2.iDJ()))
    {
      AppMethodBeat.o(59878);
      return false;
    }
    if (!a((l)paramas1, (l)paramas2, paramm, paramBoolean))
    {
      AppMethodBeat.o(59878);
      return false;
    }
    if (paramas1.getIndex() == paramas2.getIndex())
    {
      AppMethodBeat.o(59878);
      return true;
    }
    AppMethodBeat.o(59878);
    return false;
  }
  
  private final boolean a(l paraml1, l paraml2, m<? super l, ? super l, Boolean> paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(59880);
    paraml1 = paraml1.iDJ();
    paraml2 = paraml2.iDJ();
    if (((paraml1 instanceof b)) || ((paraml2 instanceof b)))
    {
      paramBoolean = ((Boolean)paramm.invoke(paraml1, paraml2)).booleanValue();
      AppMethodBeat.o(59880);
      return paramBoolean;
    }
    paramBoolean = a(paraml1, paraml2, paramBoolean);
    AppMethodBeat.o(59880);
    return paramBoolean;
  }
  
  private static an d(kotlin.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(59879);
    for (;;)
    {
      if ((!(parama instanceof b)) || (((b)parama).iEN() != b.a.aaJR))
      {
        parama = parama.iDZ();
        AppMethodBeat.o(59879);
        return parama;
      }
      parama = ((b)parama).iEL();
      p.j(parama, "overriddenDescriptors");
      parama = (b)j.j((Iterable)parama);
      if (parama == null) {
        break;
      }
      parama = (kotlin.l.b.a.b.b.a)parama;
    }
    AppMethodBeat.o(59879);
    return null;
  }
  
  public final boolean a(final l paraml1, final l paraml2, boolean paramBoolean)
  {
    AppMethodBeat.i(59877);
    if (((paraml1 instanceof e)) && ((paraml2 instanceof e)))
    {
      paraml1 = (e)paraml1;
      paraml2 = (e)paraml2;
      paramBoolean = p.h(paraml1.iDL(), paraml2.iDL());
      AppMethodBeat.o(59877);
      return paramBoolean;
    }
    if (((paraml1 instanceof as)) && ((paraml2 instanceof as)))
    {
      paramBoolean = a((as)paraml1, (as)paraml2, paramBoolean, (m)a.c.abjW);
      AppMethodBeat.o(59877);
      return paramBoolean;
    }
    if (((paraml1 instanceof kotlin.l.b.a.b.b.a)) && ((paraml2 instanceof kotlin.l.b.a.b.b.a)))
    {
      paraml1 = (kotlin.l.b.a.b.b.a)paraml1;
      paraml2 = (kotlin.l.b.a.b.b.a)paraml2;
      p.k(paraml1, "a");
      p.k(paraml2, "b");
      if (p.h(paraml1, paraml2))
      {
        AppMethodBeat.o(59877);
        return true;
      }
      if ((!(p.h(paraml1.iEU(), paraml2.iEU()) ^ true)) && ((!p.h(paraml1.iDJ(), paraml2.iDJ())) || ((paramBoolean) && (!(p.h(d(paraml1), d(paraml2)) ^ true)) && ((!(paraml1 instanceof v)) || (!(paraml2 instanceof v)) || (((v)paraml1).iDV() == ((v)paraml2).iDV())))))
      {
        if ((c.m((l)paraml1)) || (c.m((l)paraml2)))
        {
          AppMethodBeat.o(59877);
          return false;
        }
        if (a((l)paraml1, (l)paraml2, (m)a.a.abjR, paramBoolean))
        {
          i locali = i.a((g.a)new b(paramBoolean, paraml1, paraml2));
          p.j(locali, "OverridingUtil.createWit…= a && y == b }\n        }");
          i.a locala = locali.a(paraml1, paraml2, null, true);
          p.j(locala, "overridingUtil.isOverrid… null, !ignoreReturnType)");
          if (locala.iOQ() == i.a.a.abkI)
          {
            paraml1 = locali.a(paraml2, paraml1, null, true);
            p.j(paraml1, "overridingUtil.isOverrid… null, !ignoreReturnType)");
            if (paraml1.iOQ() == i.a.a.abkI)
            {
              AppMethodBeat.o(59877);
              return true;
            }
          }
        }
      }
      AppMethodBeat.o(59877);
      return false;
    }
    if (((paraml1 instanceof ab)) && ((paraml2 instanceof ab)))
    {
      paramBoolean = p.h(((ab)paraml1).iFy(), ((ab)paraml2).iFy());
      AppMethodBeat.o(59877);
      return paramBoolean;
    }
    paramBoolean = p.h(paraml1, paraml2);
    AppMethodBeat.o(59877);
    return paramBoolean;
  }
  
  static final class b
    implements g.a
  {
    b(boolean paramBoolean, kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.a
 * JD-Core Version:    0.7.0.1
 */