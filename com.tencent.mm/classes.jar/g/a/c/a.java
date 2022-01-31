package g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public short[] CST;
  public int CSU;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(86245);
    this.CSU = paramInt;
    this.CST = new short[1 << paramInt];
    AppMethodBeat.o(86245);
  }
  
  public final int a(b paramb)
  {
    AppMethodBeat.i(86246);
    int j = this.CSU;
    int i = 1;
    while (j != 0)
    {
      i = paramb.g(this.CST, i) + (i << 1);
      j -= 1;
    }
    j = this.CSU;
    AppMethodBeat.o(86246);
    return i - (1 << j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     g.a.c.a
 * JD-Core Version:    0.7.0.1
 */