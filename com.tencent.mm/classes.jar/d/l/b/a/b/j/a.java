package d.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.a.m;
import d.g.b.p;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.b;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.v;
import d.l.b.a.b.m.a.g.a;

public final class a
{
  public static final a Nvk;
  
  static
  {
    AppMethodBeat.i(59881);
    Nvk = new a();
    AppMethodBeat.o(59881);
  }
  
  private final boolean a(as paramas1, as paramas2, boolean paramBoolean, m<? super l, ? super l, Boolean> paramm)
  {
    AppMethodBeat.i(59878);
    if (p.i(paramas1, paramas2))
    {
      AppMethodBeat.o(59878);
      return true;
    }
    if (p.i(paramas1.ghs(), paramas2.ghs()))
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
    paraml1 = paraml1.ghs();
    paraml2 = paraml2.ghs();
    if (((paraml1 instanceof b)) || ((paraml2 instanceof b)))
    {
      paramBoolean = ((Boolean)paramm.p(paraml1, paraml2)).booleanValue();
      AppMethodBeat.o(59880);
      return paramBoolean;
    }
    paramBoolean = a(paraml1, paraml2, paramBoolean);
    AppMethodBeat.o(59880);
    return paramBoolean;
  }
  
  private static an d(d.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(59879);
    for (;;)
    {
      if ((!(parama instanceof b)) || (((b)parama).giw() != b.a.MUk))
      {
        parama = parama.ghI();
        AppMethodBeat.o(59879);
        return parama;
      }
      parama = ((b)parama).giu();
      p.g(parama, "overriddenDescriptors");
      parama = (b)j.g((Iterable)parama);
      if (parama == null) {
        break;
      }
      parama = (d.l.b.a.b.b.a)parama;
    }
    AppMethodBeat.o(59879);
    return null;
  }
  
  public final boolean a(l paraml1, l paraml2, boolean paramBoolean)
  {
    AppMethodBeat.i(59877);
    if (((paraml1 instanceof e)) && ((paraml2 instanceof e)))
    {
      paraml1 = (e)paraml1;
      paraml2 = (e)paraml2;
      paramBoolean = p.i(paraml1.ghu(), paraml2.ghu());
      AppMethodBeat.o(59877);
      return paramBoolean;
    }
    if (((paraml1 instanceof as)) && ((paraml2 instanceof as)))
    {
      paramBoolean = a((as)paraml1, (as)paraml2, paramBoolean, (m)a.c.Nvq);
      AppMethodBeat.o(59877);
      return paramBoolean;
    }
    if (((paraml1 instanceof d.l.b.a.b.b.a)) && ((paraml2 instanceof d.l.b.a.b.b.a)))
    {
      paraml1 = (d.l.b.a.b.b.a)paraml1;
      paraml2 = (d.l.b.a.b.b.a)paraml2;
      p.h(paraml1, "a");
      p.h(paraml2, "b");
      if (p.i(paraml1, paraml2))
      {
        AppMethodBeat.o(59877);
        return true;
      }
      if ((!(p.i(paraml1.giD(), paraml2.giD()) ^ true)) && ((!p.i(paraml1.ghs(), paraml2.ghs())) || ((paramBoolean) && (!(p.i(d(paraml1), d(paraml2)) ^ true)) && ((!(paraml1 instanceof v)) || (!(paraml2 instanceof v)) || (((v)paraml1).ghE() == ((v)paraml2).ghE())))))
      {
        if ((c.m((l)paraml1)) || (c.m((l)paraml2)))
        {
          AppMethodBeat.o(59877);
          return false;
        }
        if (a((l)paraml1, (l)paraml2, (m)a.a.Nvl, paramBoolean))
        {
          i locali = i.a((g.a)new a.b(paramBoolean, paraml1, paraml2));
          p.g(locali, "OverridingUtil.createWit…= a && y == b }\n        }");
          i.a locala = locali.a(paraml1, paraml2, null, true);
          p.g(locala, "overridingUtil.isOverrid… null, !ignoreReturnType)");
          if (locala.gsV() == i.a.a.Nwc)
          {
            paraml1 = locali.a(paraml2, paraml1, null, true);
            p.g(paraml1, "overridingUtil.isOverrid… null, !ignoreReturnType)");
            if (paraml1.gsV() == i.a.a.Nwc)
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
      paramBoolean = p.i(((ab)paraml1).gjg(), ((ab)paraml2).gjg());
      AppMethodBeat.o(59877);
      return paramBoolean;
    }
    paramBoolean = p.i(paraml1, paraml2);
    AppMethodBeat.o(59877);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.a
 * JD-Core Version:    0.7.0.1
 */