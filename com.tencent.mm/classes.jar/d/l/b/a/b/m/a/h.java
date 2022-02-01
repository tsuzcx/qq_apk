package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.m.ab;

public final class h
  implements g
{
  private final w NDc;
  
  private h(w paramw)
  {
    this.NDc = paramw;
  }
  
  public static g b(g.a parama)
  {
    AppMethodBeat.i(61048);
    if (parama == null) {
      ajm(0);
    }
    parama = new h(new w(new h.1(parama)));
    AppMethodBeat.o(61048);
    return parama;
  }
  
  public final boolean c(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(61049);
    if (paramab1 == null) {
      ajm(2);
    }
    if (paramab2 == null) {
      ajm(3);
    }
    boolean bool = this.NDc.c(paramab1, paramab2);
    AppMethodBeat.o(61049);
    return bool;
  }
  
  public final boolean d(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(61050);
    if (paramab1 == null) {
      ajm(4);
    }
    if (paramab2 == null) {
      ajm(5);
    }
    boolean bool = this.NDc.d(paramab1, paramab2);
    AppMethodBeat.o(61050);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.a.h
 * JD-Core Version:    0.7.0.1
 */