package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.n.n;

public final class i<T>
{
  private int NFW;
  private T NFX;
  private final l<T> NFY;
  
  public final void fn(T paramT)
  {
    AppMethodBeat.i(58197);
    p.h(paramT, "objectType");
    fo(paramT);
    AppMethodBeat.o(58197);
  }
  
  final void fo(T paramT)
  {
    AppMethodBeat.i(58198);
    p.h(paramT, "type");
    if (this.NFX == null)
    {
      Object localObject = paramT;
      if (this.NFW > 0) {
        localObject = this.NFY.bdW(n.r((CharSequence)"[", this.NFW) + this.NFY.toString(paramT));
      }
      this.NFX = localObject;
    }
    AppMethodBeat.o(58198);
  }
  
  public final void gqI()
  {
    if (this.NFX == null) {
      this.NFW += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.b.i
 * JD-Core Version:    0.7.0.1
 */