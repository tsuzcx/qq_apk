package g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class a
{
  public int KhZ;
  public byte[] Ktk;
  public int Ktl = 0;
  public int Ktm;
  public OutputStream Ktn;
  
  public final byte agu(int paramInt)
  {
    int i = this.KhZ - paramInt - 1;
    paramInt = i;
    if (i < 0) {
      paramInt = i + this.Ktl;
    }
    return this.Ktk[paramInt];
  }
  
  public final void fOk()
  {
    AppMethodBeat.i(155350);
    fOl();
    this.Ktn = null;
    AppMethodBeat.o(155350);
  }
  
  public final void fOl()
  {
    AppMethodBeat.i(155351);
    int i = this.KhZ - this.Ktm;
    if (i == 0)
    {
      AppMethodBeat.o(155351);
      return;
    }
    this.Ktn.write(this.Ktk, this.Ktm, i);
    if (this.KhZ >= this.Ktl) {
      this.KhZ = 0;
    }
    this.Ktm = this.KhZ;
    AppMethodBeat.o(155351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     g.a.a.a
 * JD-Core Version:    0.7.0.1
 */