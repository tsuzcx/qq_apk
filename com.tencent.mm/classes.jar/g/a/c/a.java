package g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public short[] OcC;
  public int OcD;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(155360);
    this.OcD = paramInt;
    this.OcC = new short[1 << paramInt];
    AppMethodBeat.o(155360);
  }
  
  public final int a(b paramb)
  {
    AppMethodBeat.i(155361);
    int j = this.OcD;
    int i = 1;
    while (j != 0)
    {
      i = paramb.f(this.OcC, i) + (i << 1);
      j -= 1;
    }
    j = this.OcD;
    AppMethodBeat.o(155361);
    return i - (1 << j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     g.a.c.a
 * JD-Core Version:    0.7.0.1
 */