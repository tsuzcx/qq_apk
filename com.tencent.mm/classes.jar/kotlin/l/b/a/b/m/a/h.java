package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;

public final class h
  implements g
{
  private final w TPd;
  
  private h(w paramw)
  {
    this.TPd = paramw;
  }
  
  public static g b(g.a parama)
  {
    AppMethodBeat.i(61048);
    if (parama == null) {
      atM(0);
    }
    parama = new h(new w(new v()
    {
      public final boolean b(at paramAnonymousat1, at paramAnonymousat2)
      {
        AppMethodBeat.i(61046);
        if (paramAnonymousat1 == null) {
          atM(0);
        }
        if (paramAnonymousat2 == null) {
          atM(1);
        }
        if ((paramAnonymousat1.equals(paramAnonymousat2)) || (this.TPe.a(paramAnonymousat1, paramAnonymousat2)))
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
      atM(2);
    }
    if (paramab2 == null) {
      atM(3);
    }
    boolean bool = this.TPd.c(paramab1, paramab2);
    AppMethodBeat.o(61049);
    return bool;
  }
  
  public final boolean d(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(61050);
    if (paramab1 == null) {
      atM(4);
    }
    if (paramab2 == null) {
      atM(5);
    }
    boolean bool = this.TPd.d(paramab1, paramab2);
    AppMethodBeat.o(61050);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.h
 * JD-Core Version:    0.7.0.1
 */