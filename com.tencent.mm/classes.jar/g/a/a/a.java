package g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class a
{
  public int NQh;
  public byte[] ObV;
  public int ObW = 0;
  public int ObX;
  public OutputStream ObY;
  
  public final byte amb(int paramInt)
  {
    int i = this.NQh - paramInt - 1;
    paramInt = i;
    if (i < 0) {
      paramInt = i + this.ObW;
    }
    return this.ObV[paramInt];
  }
  
  public final void gzE()
  {
    AppMethodBeat.i(155350);
    gzF();
    this.ObY = null;
    AppMethodBeat.o(155350);
  }
  
  public final void gzF()
  {
    AppMethodBeat.i(155351);
    int i = this.NQh - this.ObX;
    if (i == 0)
    {
      AppMethodBeat.o(155351);
      return;
    }
    this.ObY.write(this.ObV, this.ObX, i);
    if (this.NQh >= this.ObW) {
      this.NQh = 0;
    }
    this.ObX = this.NQh;
    AppMethodBeat.o(155351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     g.a.a.a
 * JD-Core Version:    0.7.0.1
 */