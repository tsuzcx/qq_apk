package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

final class GLTextureView$l
  extends Writer
{
  private StringBuilder xgv;
  
  GLTextureView$l()
  {
    AppMethodBeat.i(97204);
    this.xgv = new StringBuilder();
    AppMethodBeat.o(97204);
  }
  
  private void eR()
  {
    AppMethodBeat.i(97208);
    if (this.xgv.length() > 0) {
      this.xgv.delete(0, this.xgv.length());
    }
    AppMethodBeat.o(97208);
  }
  
  public final void close()
  {
    AppMethodBeat.i(97205);
    eR();
    AppMethodBeat.o(97205);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(97206);
    eR();
    AppMethodBeat.o(97206);
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97207);
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        eR();
      }
      for (;;)
      {
        i += 1;
        break;
        this.xgv.append(c);
      }
    }
    AppMethodBeat.o(97207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.l
 * JD-Core Version:    0.7.0.1
 */