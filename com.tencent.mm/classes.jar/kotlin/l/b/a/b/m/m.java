package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.a.n;
import kotlin.l.b.a.b.m.c.e;

public final class m
  extends o
  implements e, l
{
  public static final a ajpo;
  public final al ajpp;
  private final boolean ajpq;
  
  static
  {
    AppMethodBeat.i(60631);
    ajpo = new a((byte)0);
    AppMethodBeat.o(60631);
  }
  
  private m(al paramal, boolean paramBoolean)
  {
    this.ajpp = paramal;
    this.ajpq = paramBoolean;
  }
  
  private m g(g paramg)
  {
    AppMethodBeat.i(60624);
    s.u(paramg, "newAnnotations");
    paramg = new m(this.ajpp.d(paramg), this.ajpq);
    AppMethodBeat.o(60624);
    return paramg;
  }
  
  public final ad H(ad paramad)
  {
    AppMethodBeat.i(60623);
    s.u(paramad, "replacement");
    paramad = (ad)ao.b(paramad.kAK(), this.ajpq);
    AppMethodBeat.o(60623);
    return paramad;
  }
  
  public final al Pq(boolean paramBoolean)
  {
    AppMethodBeat.i(60627);
    if (paramBoolean)
    {
      localal = this.ajpp.Pq(paramBoolean);
      AppMethodBeat.o(60627);
      return localal;
    }
    al localal = (al)this;
    AppMethodBeat.o(60627);
    return localal;
  }
  
  public final boolean ksA()
  {
    AppMethodBeat.i(60622);
    if (((this.ajpp.kzm() instanceof n)) || ((this.ajpp.kzm().knA() instanceof ba)))
    {
      AppMethodBeat.o(60622);
      return true;
    }
    AppMethodBeat.o(60622);
    return false;
  }
  
  public final boolean ksB()
  {
    return false;
  }
  
  protected final al ksx()
  {
    return this.ajpp;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60629);
    String str = this.ajpp + "!!";
    AppMethodBeat.o(60629);
    return str;
  }
  
  public static final class a
  {
    public static m a(bk parambk, boolean paramBoolean)
    {
      boolean bool = true;
      AppMethodBeat.i(191657);
      s.u(parambk, "type");
      if ((parambk instanceof m))
      {
        parambk = (m)parambk;
        AppMethodBeat.o(191657);
        return parambk;
      }
      int i;
      if (((parambk.kzm() instanceof n)) || ((parambk.kzm().knA() instanceof ba)) || ((parambk instanceof i)) || ((parambk instanceof as)))
      {
        i = 1;
        if (i == 0) {
          break label223;
        }
        if (!(parambk instanceof as)) {
          break label181;
        }
        bool = bg.aw((ad)parambk);
      }
      for (;;)
      {
        if (bool)
        {
          if ((parambk instanceof x))
          {
            bool = s.p(((x)parambk).ajpE.kzm(), ((x)parambk).ajpF.kzm());
            if ((ak.aiuY) && (!bool))
            {
              parambk = (Throwable)new AssertionError("DefinitelyNotNullType for flexible type (" + parambk + ") can be created only from type variable with the same constructor for bounds");
              AppMethodBeat.o(191657);
              throw parambk;
              i = 0;
              break;
              label181:
              if ((paramBoolean) && ((parambk.kzm().knA() instanceof ba)))
              {
                bool = bg.aw((ad)parambk);
                continue;
              }
              kotlin.l.b.a.b.m.a.o localo = kotlin.l.b.a.b.m.a.o.ajrp;
              if (!kotlin.l.b.a.b.m.a.o.c(parambk)) {
                continue;
              }
              label223:
              bool = false;
              continue;
            }
          }
          parambk = new m(aa.ae((ad)parambk), paramBoolean, (byte)0);
          AppMethodBeat.o(191657);
          return parambk;
        }
      }
      AppMethodBeat.o(191657);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.m
 * JD-Core Version:    0.7.0.1
 */