package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.f.b;

final class h$a
{
  final b aiEe;
  final f ajlS;
  
  public h$a(b paramb, f paramf)
  {
    AppMethodBeat.i(60294);
    this.aiEe = paramb;
    this.ajlS = paramf;
    AppMethodBeat.o(60294);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(60292);
    if (((paramObject instanceof a)) && (s.p(this.aiEe, ((a)paramObject).aiEe)))
    {
      AppMethodBeat.o(60292);
      return true;
    }
    AppMethodBeat.o(60292);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(60293);
    int i = this.aiEe.hashCode();
    AppMethodBeat.o(60293);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.h.a
 * JD-Core Version:    0.7.0.1
 */