package g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public short[] OzH;
  public int OzI;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(155360);
    this.OzI = paramInt;
    this.OzH = new short[1 << paramInt];
    AppMethodBeat.o(155360);
  }
  
  public final int a(b paramb)
  {
    AppMethodBeat.i(155361);
    int j = this.OzI;
    int i = 1;
    while (j != 0)
    {
      i = paramb.f(this.OzH, i) + (i << 1);
      j -= 1;
    }
    j = this.OzI;
    AppMethodBeat.o(155361);
    return i - (1 << j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     g.a.c.a
 * JD-Core Version:    0.7.0.1
 */