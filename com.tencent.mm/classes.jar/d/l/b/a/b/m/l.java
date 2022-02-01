package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.ac;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.as;
import d.l.b.a.b.m.a.q;
import d.l.b.a.b.m.c.e;

public final class l
  extends n
  implements e, k
{
  public static final a NBF;
  final aj NBE;
  
  static
  {
    AppMethodBeat.i(60631);
    NBF = new a((byte)0);
    AppMethodBeat.o(60631);
  }
  
  private l(aj paramaj)
  {
    this.NBE = paramaj;
  }
  
  private l g(g paramg)
  {
    AppMethodBeat.i(60624);
    d.g.b.p.h(paramg, "newAnnotations");
    paramg = new l(this.NBE.d(paramg));
    AppMethodBeat.o(60624);
    return paramg;
  }
  
  public final aj Ac(boolean paramBoolean)
  {
    AppMethodBeat.i(60627);
    if (paramBoolean)
    {
      localaj = this.NBE.Ac(paramBoolean);
      AppMethodBeat.o(60627);
      return localaj;
    }
    aj localaj = (aj)this;
    AppMethodBeat.o(60627);
    return localaj;
  }
  
  public final ab R(ab paramab)
  {
    AppMethodBeat.i(60623);
    d.g.b.p.h(paramab, "replacement");
    paramab = (ab)am.b(paramab.gua());
    AppMethodBeat.o(60623);
    return paramab;
  }
  
  protected final aj glS()
  {
    return this.NBE;
  }
  
  public final boolean glV()
  {
    AppMethodBeat.i(60622);
    if (((this.NBE.gsZ() instanceof d.l.b.a.b.m.a.p)) || ((this.NBE.gsZ().ghO() instanceof as)))
    {
      AppMethodBeat.o(60622);
      return true;
    }
    AppMethodBeat.o(60622);
    return false;
  }
  
  public final boolean glW()
  {
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60629);
    String str = this.NBE + "!!";
    AppMethodBeat.o(60629);
    return str;
  }
  
  public static final class a
  {
    public static l a(bg parambg)
    {
      int j = 1;
      AppMethodBeat.i(60621);
      d.g.b.p.h(parambg, "type");
      if ((parambg instanceof l))
      {
        parambg = (l)parambg;
        AppMethodBeat.o(60621);
        return parambg;
      }
      d.g.b.p.h(parambg, "$this$canHaveUndefinedNullability");
      int i;
      if (((parambg.gsZ() instanceof d.l.b.a.b.m.a.p)) || ((parambg.gsZ().ghO() instanceof as)) || ((parambg instanceof d.l.b.a.b.m.a.k)))
      {
        i = 1;
        if (i == 0) {
          break label179;
        }
        q localq = q.NDt;
        if (q.d(parambg)) {
          break label179;
        }
        i = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          if ((parambg instanceof v))
          {
            boolean bool = d.g.b.p.i(((v)parambg).NBV.gsZ(), ((v)parambg).NBW.gsZ());
            if ((ac.MKp) && (!bool))
            {
              parambg = (Throwable)new AssertionError("DefinitelyNotNullType for flexible type (" + parambg + ") can be created only from type variable with the same constructor for bounds");
              AppMethodBeat.o(60621);
              throw parambg;
              i = 0;
              break;
              label179:
              i = 0;
              continue;
            }
          }
          parambg = new l(y.ao((ab)parambg), (byte)0);
          AppMethodBeat.o(60621);
          return parambg;
        }
      }
      AppMethodBeat.o(60621);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.l
 * JD-Core Version:    0.7.0.1
 */