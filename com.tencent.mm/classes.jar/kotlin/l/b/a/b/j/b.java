package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.p;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.aa;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.m.a.e.a;
import kotlin.l.b.a.b.m.a.g;
import kotlin.l.b.a.b.m.a.g.a;

public final class b
{
  public static final b ajiF;
  
  static
  {
    AppMethodBeat.i(59881);
    ajiF = new b();
    AppMethodBeat.o(59881);
  }
  
  private final boolean a(l paraml1, l paraml2, m<? super l, ? super l, Boolean> paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(59880);
    paraml1 = paraml1.knp();
    paraml2 = paraml2.knp();
    if (((paraml1 instanceof kotlin.l.b.a.b.b.b)) || ((paraml2 instanceof kotlin.l.b.a.b.b.b)))
    {
      paramBoolean = ((Boolean)paramm.invoke(paraml1, paraml2)).booleanValue();
      AppMethodBeat.o(59880);
      return paramBoolean;
    }
    paramBoolean = a(paraml1, paraml2, paramBoolean);
    AppMethodBeat.o(59880);
    return paramBoolean;
  }
  
  private static av d(a parama)
  {
    AppMethodBeat.i(59879);
    for (;;)
    {
      if ((!(parama instanceof kotlin.l.b.a.b.b.b)) || (((kotlin.l.b.a.b.b.b)parama).koh() != kotlin.l.b.a.b.b.b.a.aiGm))
      {
        parama = parama.knm();
        AppMethodBeat.o(59879);
        return parama;
      }
      parama = ((kotlin.l.b.a.b.b.b)parama).kof();
      s.s(parama, "overriddenDescriptors");
      parama = (kotlin.l.b.a.b.b.b)p.j((Iterable)parama);
      if (parama == null)
      {
        AppMethodBeat.o(59879);
        return null;
      }
      parama = (a)parama;
    }
  }
  
  public final boolean a(ba paramba1, ba paramba2, boolean paramBoolean, m<? super l, ? super l, Boolean> paramm)
  {
    AppMethodBeat.i(59878);
    s.u(paramba1, "a");
    s.u(paramba2, "b");
    s.u(paramm, "equivalentCallables");
    if (s.p(paramba1, paramba2))
    {
      AppMethodBeat.o(59878);
      return true;
    }
    if (s.p(paramba1.knp(), paramba2.knp()))
    {
      AppMethodBeat.o(59878);
      return false;
    }
    if (!a((l)paramba1, (l)paramba2, paramm, paramBoolean))
    {
      AppMethodBeat.o(59878);
      return false;
    }
    if (paramba1.getIndex() == paramba2.getIndex())
    {
      AppMethodBeat.o(59878);
      return true;
    }
    AppMethodBeat.o(59878);
    return false;
  }
  
  public final boolean a(l paraml1, l paraml2, boolean paramBoolean)
  {
    AppMethodBeat.i(192198);
    if (((paraml1 instanceof e)) && ((paraml2 instanceof e)))
    {
      paraml1 = (e)paraml1;
      paraml2 = (e)paraml2;
      paramBoolean = s.p(paraml1.kmZ(), paraml2.kmZ());
      AppMethodBeat.o(192198);
      return paramBoolean;
    }
    if (((paraml1 instanceof ba)) && ((paraml2 instanceof ba)))
    {
      paramBoolean = a(this, (ba)paraml1, (ba)paraml2, paramBoolean);
      AppMethodBeat.o(192198);
      return paramBoolean;
    }
    if (((paraml1 instanceof a)) && ((paraml2 instanceof a)))
    {
      paraml1 = (a)paraml1;
      paraml2 = (a)paraml2;
      Object localObject = (g)g.a.ajra;
      s.u(paraml1, "a");
      s.u(paraml2, "b");
      s.u(localObject, "kotlinTypeRefiner");
      if (s.p(paraml1, paraml2))
      {
        AppMethodBeat.o(192198);
        return true;
      }
      if ((s.p(paraml1.kok(), paraml2.kok())) && ((!(paraml1 instanceof aa)) || (!(paraml2 instanceof aa)) || (((aa)paraml1).kni() == ((aa)paraml2).kni())) && ((!s.p(paraml1.knp(), paraml2.knp())) || ((paramBoolean) && (s.p(d(paraml1), d(paraml2))))))
      {
        if ((d.m((l)paraml1)) || (d.m((l)paraml2)))
        {
          AppMethodBeat.o(192198);
          return false;
        }
        if (a((l)paraml1, (l)paraml2, (m)b.a.ajiG, paramBoolean))
        {
          localObject = j.a((g)localObject, (e.a)new b.b(paramBoolean, paraml1, paraml2));
          s.s(localObject, "a: CallableDescriptor,\n …= a && y == b }\n        }");
          if ((((j)localObject).a(paraml1, paraml2, null, true).kzj() == j.a.a.ajjn) && (((j)localObject).a(paraml2, paraml1, null, true).kzj() == j.a.a.ajjn))
          {
            AppMethodBeat.o(192198);
            return true;
          }
        }
      }
      AppMethodBeat.o(192198);
      return false;
    }
    if (((paraml1 instanceof ah)) && ((paraml2 instanceof ah)))
    {
      paramBoolean = s.p(((ah)paraml1).koY(), ((ah)paraml2).koY());
      AppMethodBeat.o(192198);
      return paramBoolean;
    }
    paramBoolean = s.p(paraml1, paraml2);
    AppMethodBeat.o(192198);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b
 * JD-Core Version:    0.7.0.1
 */