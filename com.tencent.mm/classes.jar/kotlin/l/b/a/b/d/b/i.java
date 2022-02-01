package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.n.n;

public final class i<T>
{
  private int TvC;
  private T TvD;
  private final l<T> TvE;
  
  public final void fs(T paramT)
  {
    AppMethodBeat.i(58197);
    p.h(paramT, "objectType");
    ft(paramT);
    AppMethodBeat.o(58197);
  }
  
  final void ft(T paramT)
  {
    AppMethodBeat.i(58198);
    p.h(paramT, "type");
    if (this.TvD == null)
    {
      Object localObject = paramT;
      if (this.TvC > 0) {
        localObject = this.TvE.btM(n.r((CharSequence)"[", this.TvC) + this.TvE.toString(paramT));
      }
      this.TvD = localObject;
    }
    AppMethodBeat.o(58198);
  }
  
  public final void hEk()
  {
    if (this.TvD == null) {
      this.TvC += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.i
 * JD-Core Version:    0.7.0.1
 */