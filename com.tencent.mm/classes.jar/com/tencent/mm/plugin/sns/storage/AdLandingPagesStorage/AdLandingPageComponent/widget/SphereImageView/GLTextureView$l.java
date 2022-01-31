package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

final class GLTextureView$l
  extends Writer
{
  private StringBuilder rAP;
  
  GLTextureView$l()
  {
    AppMethodBeat.i(145358);
    this.rAP = new StringBuilder();
    AppMethodBeat.o(145358);
  }
  
  private void flushBuilder()
  {
    AppMethodBeat.i(145362);
    if (this.rAP.length() > 0) {
      this.rAP.delete(0, this.rAP.length());
    }
    AppMethodBeat.o(145362);
  }
  
  public final void close()
  {
    AppMethodBeat.i(145359);
    flushBuilder();
    AppMethodBeat.o(145359);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(145360);
    flushBuilder();
    AppMethodBeat.o(145360);
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145361);
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        flushBuilder();
      }
      for (;;)
      {
        i += 1;
        break;
        this.rAP.append(c);
      }
    }
    AppMethodBeat.o(145361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.l
 * JD-Core Version:    0.7.0.1
 */