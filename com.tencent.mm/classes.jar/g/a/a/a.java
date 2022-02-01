package g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class a
{
  public int Onn;
  public byte[] Oza;
  public int Ozb = 0;
  public int Ozc;
  public OutputStream Ozd;
  
  public final byte amL(int paramInt)
  {
    int i = this.Onn - paramInt - 1;
    paramInt = i;
    if (i < 0) {
      paramInt = i + this.Ozb;
    }
    return this.Oza[paramInt];
  }
  
  public final void gEg()
  {
    AppMethodBeat.i(155350);
    gEh();
    this.Ozd = null;
    AppMethodBeat.o(155350);
  }
  
  public final void gEh()
  {
    AppMethodBeat.i(155351);
    int i = this.Onn - this.Ozc;
    if (i == 0)
    {
      AppMethodBeat.o(155351);
      return;
    }
    this.Ozd.write(this.Oza, this.Ozc, i);
    if (this.Onn >= this.Ozb) {
      this.Onn = 0;
    }
    this.Ozc = this.Onn;
    AppMethodBeat.o(155351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     g.a.a.a
 * JD-Core Version:    0.7.0.1
 */