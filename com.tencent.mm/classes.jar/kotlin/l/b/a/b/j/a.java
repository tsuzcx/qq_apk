package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
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
  public static final a THm;
  
  static
  {
    AppMethodBeat.i(59881);
    THm = new a();
    AppMethodBeat.o(59881);
  }
  
  private final boolean a(as paramas1, as paramas2, boolean paramBoolean, m<? super l, ? super l, Boolean> paramm)
  {
    AppMethodBeat.i(59878);
    if (p.j(paramas1, paramas2))
    {
      AppMethodBeat.o(59878);
      return true;
    }
    if (p.j(paramas1.hzx(), paramas2.hzx()))
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
    paraml1 = paraml1.hzx();
    paraml2 = paraml2.hzx();
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
      if ((!(parama instanceof b)) || (((b)parama).hAA() != b.a.TgX))
      {
        parama = parama.hzM();
        AppMethodBeat.o(59879);
        return parama;
      }
      parama = ((b)parama).hAy();
      p.g(parama, "overriddenDescriptors");
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
      paramBoolean = p.j(paraml1.hzz(), paraml2.hzz());
      AppMethodBeat.o(59877);
      return paramBoolean;
    }
    if (((paraml1 instanceof as)) && ((paraml2 instanceof as)))
    {
      paramBoolean = a((as)paraml1, (as)paraml2, paramBoolean, (m)a.c.THs);
      AppMethodBeat.o(59877);
      return paramBoolean;
    }
    if (((paraml1 instanceof kotlin.l.b.a.b.b.a)) && ((paraml2 instanceof kotlin.l.b.a.b.b.a)))
    {
      paraml1 = (kotlin.l.b.a.b.b.a)paraml1;
      paraml2 = (kotlin.l.b.a.b.b.a)paraml2;
      p.h(paraml1, "a");
      p.h(paraml2, "b");
      if (p.j(paraml1, paraml2))
      {
        AppMethodBeat.o(59877);
        return true;
      }
      if ((!(p.j(paraml1.hAH(), paraml2.hAH()) ^ true)) && ((!p.j(paraml1.hzx(), paraml2.hzx())) || ((paramBoolean) && (!(p.j(d(paraml1), d(paraml2)) ^ true)) && ((!(paraml1 instanceof v)) || (!(paraml2 instanceof v)) || (((v)paraml1).hzJ() == ((v)paraml2).hzJ())))))
      {
        if ((c.m((l)paraml1)) || (c.m((l)paraml2)))
        {
          AppMethodBeat.o(59877);
          return false;
        }
        if (a((l)paraml1, (l)paraml2, (m)a.a.THn, paramBoolean))
        {
          i locali = i.a((g.a)new b(paramBoolean, paraml1, paraml2));
          p.g(locali, "OverridingUtil.createWit…= a && y == b }\n        }");
          i.a locala = locali.a(paraml1, paraml2, null, true);
          p.g(locala, "overridingUtil.isOverrid… null, !ignoreReturnType)");
          if (locala.hKA() == i.a.a.TIe)
          {
            paraml1 = locali.a(paraml2, paraml1, null, true);
            p.g(paraml1, "overridingUtil.isOverrid… null, !ignoreReturnType)");
            if (paraml1.hKA() == i.a.a.TIe)
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
      paramBoolean = p.j(((ab)paraml1).hBk(), ((ab)paraml2).hBk());
      AppMethodBeat.o(59877);
      return paramBoolean;
    }
    paramBoolean = p.j(paraml1, paraml2);
    AppMethodBeat.o(59877);
    return paramBoolean;
  }
  
  static final class b
    implements g.a
  {
    b(boolean paramBoolean, kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.a
 * JD-Core Version:    0.7.0.1
 */