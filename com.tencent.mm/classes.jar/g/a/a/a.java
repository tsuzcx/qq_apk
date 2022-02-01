package g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class a
{
  public int LVI;
  public byte[] MgT;
  public int MgU = 0;
  public int MgV;
  public OutputStream MgW;
  
  public final byte ajq(int paramInt)
  {
    int i = this.LVI - paramInt - 1;
    paramInt = i;
    if (i < 0) {
      paramInt = i + this.MgU;
    }
    return this.MgT[paramInt];
  }
  
  public final void gha()
  {
    AppMethodBeat.i(155350);
    ghb();
    this.MgW = null;
    AppMethodBeat.o(155350);
  }
  
  public final void ghb()
  {
    AppMethodBeat.i(155351);
    int i = this.LVI - this.MgV;
    if (i == 0)
    {
      AppMethodBeat.o(155351);
      return;
    }
    this.MgW.write(this.MgT, this.MgV, i);
    if (this.LVI >= this.MgU) {
      this.LVI = 0;
    }
    this.MgV = this.LVI;
    AppMethodBeat.o(155351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     g.a.a.a
 * JD-Core Version:    0.7.0.1
 */