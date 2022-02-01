package i.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public short[] Upu;
  public int Upv;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(155360);
    this.Upv = paramInt;
    this.Upu = new short[1 << paramInt];
    AppMethodBeat.o(155360);
  }
  
  public final int a(b paramb)
  {
    AppMethodBeat.i(155361);
    int j = this.Upv;
    int i = 1;
    while (j != 0)
    {
      i = paramb.g(this.Upu, i) + (i << 1);
      j -= 1;
    }
    j = this.Upv;
    AppMethodBeat.o(155361);
    return i - (1 << j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     i.a.c.a
 * JD-Core Version:    0.7.0.1
 */