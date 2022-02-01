package d.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.a.m;
import d.g.b.k;
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
  public static final a JQS;
  
  static
  {
    AppMethodBeat.i(59881);
    JQS = new a();
    AppMethodBeat.o(59881);
  }
  
  private final boolean a(as paramas1, as paramas2, boolean paramBoolean, m<? super l, ? super l, Boolean> paramm)
  {
    AppMethodBeat.i(59878);
    if (k.g(paramas1, paramas2))
    {
      AppMethodBeat.o(59878);
      return true;
    }
    if (k.g(paramas1.fxq(), paramas2.fxq()))
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
    paraml1 = paraml1.fxq();
    paraml2 = paraml2.fxq();
    if (((paraml1 instanceof b)) || ((paraml2 instanceof b)))
    {
      paramBoolean = ((Boolean)paramm.n(paraml1, paraml2)).booleanValue();
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
      if ((!(parama instanceof b)) || (((b)parama).fyu() != b.a.JpW))
      {
        parama = parama.fxG();
        AppMethodBeat.o(59879);
        return parama;
      }
      parama = ((b)parama).fys();
      k.g(parama, "overriddenDescriptors");
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
      paramBoolean = k.g(paraml1.fxs(), paraml2.fxs());
      AppMethodBeat.o(59877);
      return paramBoolean;
    }
    if (((paraml1 instanceof as)) && ((paraml2 instanceof as)))
    {
      paramBoolean = a((as)paraml1, (as)paraml2, paramBoolean, (m)a.c.JQY);
      AppMethodBeat.o(59877);
      return paramBoolean;
    }
    if (((paraml1 instanceof d.l.b.a.b.b.a)) && ((paraml2 instanceof d.l.b.a.b.b.a)))
    {
      paraml1 = (d.l.b.a.b.b.a)paraml1;
      paraml2 = (d.l.b.a.b.b.a)paraml2;
      k.h(paraml1, "a");
      k.h(paraml2, "b");
      if (k.g(paraml1, paraml2))
      {
        AppMethodBeat.o(59877);
        return true;
      }
      if ((!(k.g(paraml1.fyB(), paraml2.fyB()) ^ true)) && ((!k.g(paraml1.fxq(), paraml2.fxq())) || ((paramBoolean) && (!(k.g(d(paraml1), d(paraml2)) ^ true)) && ((!(paraml1 instanceof v)) || (!(paraml2 instanceof v)) || (((v)paraml1).fxC() == ((v)paraml2).fxC())))))
      {
        if ((c.m((l)paraml1)) || (c.m((l)paraml2)))
        {
          AppMethodBeat.o(59877);
          return false;
        }
        if (a((l)paraml1, (l)paraml2, (m)a.a.JQT, paramBoolean))
        {
          i locali = i.a((g.a)new a.b(paramBoolean, paraml1, paraml2));
          k.g(locali, "OverridingUtil.createWit…= a && y == b }\n        }");
          i.a locala = locali.a(paraml1, paraml2, null, true);
          k.g(locala, "overridingUtil.isOverrid… null, !ignoreReturnType)");
          if (locala.fIS() == i.a.a.JRL)
          {
            paraml1 = locali.a(paraml2, paraml1, null, true);
            k.g(paraml1, "overridingUtil.isOverrid… null, !ignoreReturnType)");
            if (paraml1.fIS() == i.a.a.JRL)
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
      paramBoolean = k.g(((ab)paraml1).fzd(), ((ab)paraml2).fzd());
      AppMethodBeat.o(59877);
      return paramBoolean;
    }
    paramBoolean = k.g(paraml1, paraml2);
    AppMethodBeat.o(59877);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.a
 * JD-Core Version:    0.7.0.1
 */