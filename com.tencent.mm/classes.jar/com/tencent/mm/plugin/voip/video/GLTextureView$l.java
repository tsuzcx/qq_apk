package com.tencent.mm.plugin.voip.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

final class GLTextureView$l
  extends Writer
{
  private StringBuilder zKr;
  
  GLTextureView$l()
  {
    AppMethodBeat.i(115608);
    this.zKr = new StringBuilder();
    AppMethodBeat.o(115608);
  }
  
  private void fq()
  {
    AppMethodBeat.i(115612);
    if (this.zKr.length() > 0) {
      this.zKr.delete(0, this.zKr.length());
    }
    AppMethodBeat.o(115612);
  }
  
  public final void close()
  {
    AppMethodBeat.i(115609);
    fq();
    AppMethodBeat.o(115609);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(115610);
    fq();
    AppMethodBeat.o(115610);
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115611);
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        fq();
      }
      for (;;)
      {
        i += 1;
        break;
        this.zKr.append(c);
      }
    }
    AppMethodBeat.o(115611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.GLTextureView.l
 * JD-Core Version:    0.7.0.1
 */