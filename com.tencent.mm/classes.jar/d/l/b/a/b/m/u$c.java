package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.l;
import d.l.b.a.b.c.a.a;
import d.l.b.a.b.f.f;
import d.l.b.a.b.j.f.d;
import java.util.Collection;
import java.util.Set;

final class u$c
  implements d.l.b.a.b.j.f.h
{
  private final String JRK;
  
  private u$c(String paramString)
  {
    AppMethodBeat.i(60696);
    this.JRK = paramString;
    AppMethodBeat.o(60696);
  }
  
  public final Collection<? extends ah> a(f paramf, a parama)
  {
    AppMethodBeat.i(60698);
    if (paramf == null) {
      adP(5);
    }
    if (parama == null) {
      adP(6);
    }
    paramf = new IllegalStateException(this.JRK + ", required name: " + paramf);
    AppMethodBeat.o(60698);
    throw paramf;
  }
  
  public final Collection<l> a(d paramd, b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(60700);
    if (paramd == null) {
      adP(9);
    }
    if (paramb == null) {
      adP(10);
    }
    paramd = new IllegalStateException(this.JRK);
    AppMethodBeat.o(60700);
    throw paramd;
  }
  
  public final Collection<? extends am> b(f paramf, a parama)
  {
    AppMethodBeat.i(60699);
    if (paramf == null) {
      adP(7);
    }
    if (parama == null) {
      adP(8);
    }
    paramf = new IllegalStateException(this.JRK + ", required name: " + paramf);
    AppMethodBeat.o(60699);
    throw paramf;
  }
  
  public final d.l.b.a.b.b.h c(f paramf, a parama)
  {
    AppMethodBeat.i(60697);
    if (paramf == null) {
      adP(1);
    }
    if (parama == null) {
      adP(2);
    }
    paramf = new IllegalStateException(this.JRK + ", required name: " + paramf);
    AppMethodBeat.o(60697);
    throw paramf;
  }
  
  public final Set<f> fzU()
  {
    AppMethodBeat.i(60701);
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(60701);
    throw localIllegalStateException;
  }
  
  public final Set<f> fzV()
  {
    AppMethodBeat.i(60702);
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(60702);
    throw localIllegalStateException;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60703);
    String str = "ThrowingScope{" + this.JRK + '}';
    AppMethodBeat.o(60703);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.l.b.a.b.m.u.c
 * JD-Core Version:    0.7.0.1
 */