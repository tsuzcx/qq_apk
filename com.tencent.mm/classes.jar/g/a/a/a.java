package g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class a
{
  public int CMs;
  public byte[] CSm;
  public int CSn = 0;
  public int CSo;
  public OutputStream CSp;
  
  public final byte Wv(int paramInt)
  {
    int i = this.CMs - paramInt - 1;
    paramInt = i;
    if (i < 0) {
      paramInt = i + this.CSn;
    }
    return this.CSm[paramInt];
  }
  
  public final void erO()
  {
    AppMethodBeat.i(86235);
    erP();
    this.CSp = null;
    AppMethodBeat.o(86235);
  }
  
  public final void erP()
  {
    AppMethodBeat.i(86236);
    int i = this.CMs - this.CSo;
    if (i == 0)
    {
      AppMethodBeat.o(86236);
      return;
    }
    this.CSp.write(this.CSm, this.CSo, i);
    if (this.CMs >= this.CSn) {
      this.CMs = 0;
    }
    this.CSo = this.CMs;
    AppMethodBeat.o(86236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     g.a.a.a
 * JD-Core Version:    0.7.0.1
 */