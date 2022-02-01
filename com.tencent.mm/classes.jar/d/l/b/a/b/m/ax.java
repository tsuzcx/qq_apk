package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.m.a.i;

public final class ax
  extends aw
{
  private final ab KXI;
  private final bh LLH;
  
  public ax(ab paramab)
  {
    this(bh.LLV, paramab);
    AppMethodBeat.i(60837);
    AppMethodBeat.o(60837);
  }
  
  public ax(bh parambh, ab paramab)
  {
    AppMethodBeat.i(60836);
    this.LLH = parambh;
    this.KXI = paramab;
    AppMethodBeat.o(60836);
  }
  
  public final ab fRV()
  {
    AppMethodBeat.i(60839);
    ab localab = this.KXI;
    if (localab == null) {
      agL(4);
    }
    AppMethodBeat.o(60839);
    return localab;
  }
  
  public final boolean gcB()
  {
    return false;
  }
  
  public final bh gcC()
  {
    AppMethodBeat.i(60838);
    bh localbh = this.LLH;
    if (localbh == null) {
      agL(3);
    }
    AppMethodBeat.o(60838);
    return localbh;
  }
  
  public final av m(i parami)
  {
    AppMethodBeat.i(60840);
    if (parami == null) {
      agL(5);
    }
    parami = new ax(this.LLH, parami.aL(this.KXI));
    AppMethodBeat.o(60840);
    return parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.ax
 * JD-Core Version:    0.7.0.1
 */