package i.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public short[] abSJ;
  public int abSK;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(155360);
    this.abSK = paramInt;
    this.abSJ = new short[1 << paramInt];
    AppMethodBeat.o(155360);
  }
  
  public final int a(b paramb)
  {
    AppMethodBeat.i(155361);
    int j = this.abSK;
    int i = 1;
    while (j != 0)
    {
      i = paramb.g(this.abSJ, i) + (i << 1);
      j -= 1;
    }
    j = this.abSK;
    AppMethodBeat.o(155361);
    return i - (1 << j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     i.a.c.a
 * JD-Core Version:    0.7.0.1
 */