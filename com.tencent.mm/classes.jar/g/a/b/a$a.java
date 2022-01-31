package g.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.c.b;

final class a$a
{
  short[] CSH;
  g.a.c.a[] CSI;
  g.a.c.a[] CSJ;
  g.a.c.a CSK;
  int CSL;
  
  a$a(a parama)
  {
    AppMethodBeat.i(86237);
    this.CSH = new short[2];
    this.CSI = new g.a.c.a[16];
    this.CSJ = new g.a.c.a[16];
    this.CSK = new g.a.c.a(8);
    this.CSL = 0;
    AppMethodBeat.o(86237);
  }
  
  public final void Ww(int paramInt)
  {
    AppMethodBeat.i(86238);
    while (this.CSL < paramInt)
    {
      this.CSI[this.CSL] = new g.a.c.a(3);
      this.CSJ[this.CSL] = new g.a.c.a(3);
      this.CSL += 1;
    }
    AppMethodBeat.o(86238);
  }
  
  public final int a(b paramb, int paramInt)
  {
    AppMethodBeat.i(86240);
    if (paramb.g(this.CSH, 0) == 0)
    {
      paramInt = this.CSI[paramInt].a(paramb);
      AppMethodBeat.o(86240);
      return paramInt;
    }
    if (paramb.g(this.CSH, 1) == 0) {}
    for (paramInt = this.CSJ[paramInt].a(paramb) + 8;; paramInt = this.CSK.a(paramb) + 8 + 8)
    {
      AppMethodBeat.o(86240);
      return paramInt;
    }
  }
  
  public final void erQ()
  {
    AppMethodBeat.i(86239);
    b.c(this.CSH);
    int i = 0;
    while (i < this.CSL)
    {
      b.c(this.CSI[i].CST);
      b.c(this.CSJ[i].CST);
      i += 1;
    }
    b.c(this.CSK.CST);
    AppMethodBeat.o(86239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     g.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */