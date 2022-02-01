package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.m.a.q;
import kotlin.l.b.a.b.m.c.e;
import kotlin.z;

public final class l
  extends n
  implements e, k
{
  public static final a abqh;
  final aj abqg;
  
  static
  {
    AppMethodBeat.i(60631);
    abqh = new a((byte)0);
    AppMethodBeat.o(60631);
  }
  
  private l(aj paramaj)
  {
    this.abqg = paramaj;
  }
  
  private l g(g paramg)
  {
    AppMethodBeat.i(60624);
    kotlin.g.b.p.k(paramg, "newAnnotations");
    paramg = new l(this.abqg.d(paramg));
    AppMethodBeat.o(60624);
    return paramg;
  }
  
  public final aj Jn(boolean paramBoolean)
  {
    AppMethodBeat.i(60627);
    if (paramBoolean)
    {
      localaj = this.abqg.Jn(paramBoolean);
      AppMethodBeat.o(60627);
      return localaj;
    }
    aj localaj = (aj)this;
    AppMethodBeat.o(60627);
    return localaj;
  }
  
  public final ab Q(ab paramab)
  {
    AppMethodBeat.i(60623);
    kotlin.g.b.p.k(paramab, "replacement");
    paramab = (ab)am.b(paramab.iPX());
    AppMethodBeat.o(60623);
    return paramab;
  }
  
  protected final aj iIq()
  {
    return this.abqg;
  }
  
  public final boolean iIt()
  {
    AppMethodBeat.i(60622);
    if (((this.abqg.iOU() instanceof kotlin.l.b.a.b.m.a.p)) || ((this.abqg.iOU().iEf() instanceof as)))
    {
      AppMethodBeat.o(60622);
      return true;
    }
    AppMethodBeat.o(60622);
    return false;
  }
  
  public final boolean iIu()
  {
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60629);
    String str = this.abqg + "!!";
    AppMethodBeat.o(60629);
    return str;
  }
  
  public static final class a
  {
    public static l a(bg parambg)
    {
      int j = 1;
      AppMethodBeat.i(60621);
      kotlin.g.b.p.k(parambg, "type");
      if ((parambg instanceof l))
      {
        parambg = (l)parambg;
        AppMethodBeat.o(60621);
        return parambg;
      }
      kotlin.g.b.p.k(parambg, "$this$canHaveUndefinedNullability");
      int i;
      if (((parambg.iOU() instanceof kotlin.l.b.a.b.m.a.p)) || ((parambg.iOU().iEf() instanceof as)) || ((parambg instanceof kotlin.l.b.a.b.m.a.k)))
      {
        i = 1;
        if (i == 0) {
          break label179;
        }
        q localq = q.abrT;
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
            boolean bool = kotlin.g.b.p.h(((v)parambg).abqv.iOU(), ((v)parambg).abqw.iOU());
            if ((z.aazO) && (!bool))
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
          parambg = new l(y.an((ab)parambg), (byte)0);
          AppMethodBeat.o(60621);
          return parambg;
        }
      }
      AppMethodBeat.o(60621);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.l
 * JD-Core Version:    0.7.0.1
 */