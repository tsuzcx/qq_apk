package i.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class a
{
  public int abFB;
  public byte[] abSc;
  public int abSd = 0;
  public int abSe;
  public OutputStream abSf;
  
  public final byte aGl(int paramInt)
  {
    int i = this.abFB - paramInt - 1;
    paramInt = i;
    if (i < 0) {
      paramInt = i + this.abSd;
    }
    return this.abSc[paramInt];
  }
  
  public final void iWy()
  {
    AppMethodBeat.i(155350);
    iWz();
    this.abSf = null;
    AppMethodBeat.o(155350);
  }
  
  public final void iWz()
  {
    AppMethodBeat.i(155351);
    int i = this.abFB - this.abSe;
    if (i == 0)
    {
      AppMethodBeat.o(155351);
      return;
    }
    this.abSf.write(this.abSc, this.abSe, i);
    if (this.abFB >= this.abSd) {
      this.abFB = 0;
    }
    this.abSe = this.abFB;
    AppMethodBeat.o(155351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     i.a.a.a
 * JD-Core Version:    0.7.0.1
 */