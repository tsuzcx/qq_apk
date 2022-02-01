package i.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class a
{
  public int Ucm;
  public byte[] UoN;
  public int UoO = 0;
  public int UoP;
  public OutputStream UoQ;
  
  public final byte awq(int paramInt)
  {
    int i = this.Ucm - paramInt - 1;
    paramInt = i;
    if (i < 0) {
      paramInt = i + this.UoO;
    }
    return this.UoN[paramInt];
  }
  
  public final void hRo()
  {
    AppMethodBeat.i(155350);
    hRp();
    this.UoQ = null;
    AppMethodBeat.o(155350);
  }
  
  public final void hRp()
  {
    AppMethodBeat.i(155351);
    int i = this.Ucm - this.UoP;
    if (i == 0)
    {
      AppMethodBeat.o(155351);
      return;
    }
    this.UoQ.write(this.UoN, this.UoP, i);
    if (this.Ucm >= this.UoO) {
      this.Ucm = 0;
    }
    this.UoP = this.Ucm;
    AppMethodBeat.o(155351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     i.a.a.a
 * JD-Core Version:    0.7.0.1
 */