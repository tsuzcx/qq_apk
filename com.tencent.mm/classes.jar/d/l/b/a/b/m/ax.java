package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.m.a.i;

public final class ax
  extends aw
{
  private final ab MOF;
  private final bh NCC;
  
  public ax(ab paramab)
  {
    this(bh.NCP, paramab);
    AppMethodBeat.i(60837);
    AppMethodBeat.o(60837);
  }
  
  public ax(bh parambh, ab paramab)
  {
    AppMethodBeat.i(60836);
    this.NCC = parambh;
    this.MOF = paramab;
    AppMethodBeat.o(60836);
  }
  
  public final ab gju()
  {
    AppMethodBeat.i(60839);
    ab localab = this.MOF;
    if (localab == null) {
      ajm(4);
    }
    AppMethodBeat.o(60839);
    return localab;
  }
  
  public final boolean guc()
  {
    return false;
  }
  
  public final bh gud()
  {
    AppMethodBeat.i(60838);
    bh localbh = this.NCC;
    if (localbh == null) {
      ajm(3);
    }
    AppMethodBeat.o(60838);
    return localbh;
  }
  
  public final av m(i parami)
  {
    AppMethodBeat.i(60840);
    if (parami == null) {
      ajm(5);
    }
    parami = new ax(this.NCC, parami.aL(this.MOF));
    AppMethodBeat.o(60840);
    return parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.ax
 * JD-Core Version:    0.7.0.1
 */