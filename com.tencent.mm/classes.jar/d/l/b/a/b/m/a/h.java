package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.at;

public final class h
  implements g
{
  private final w Oaj;
  
  private h(w paramw)
  {
    this.Oaj = paramw;
  }
  
  public static g b(g.a parama)
  {
    AppMethodBeat.i(61048);
    if (parama == null) {
      ajW(0);
    }
    parama = new h(new w(new v()
    {
      public final boolean b(at paramAnonymousat1, at paramAnonymousat2)
      {
        AppMethodBeat.i(61046);
        if (paramAnonymousat1 == null) {
          ajW(0);
        }
        if (paramAnonymousat2 == null) {
          ajW(1);
        }
        if ((paramAnonymousat1.equals(paramAnonymousat2)) || (this.Oak.a(paramAnonymousat1, paramAnonymousat2)))
        {
          AppMethodBeat.o(61046);
          return true;
        }
        AppMethodBeat.o(61046);
        return false;
      }
    }));
    AppMethodBeat.o(61048);
    return parama;
  }
  
  public final boolean c(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(61049);
    if (paramab1 == null) {
      ajW(2);
    }
    if (paramab2 == null) {
      ajW(3);
    }
    boolean bool = this.Oaj.c(paramab1, paramab2);
    AppMethodBeat.o(61049);
    return bool;
  }
  
  public final boolean d(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(61050);
    if (paramab1 == null) {
      ajW(4);
    }
    if (paramab2 == null) {
      ajW(5);
    }
    boolean bool = this.Oaj.d(paramab1, paramab2);
    AppMethodBeat.o(61050);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.a.h
 * JD-Core Version:    0.7.0.1
 */