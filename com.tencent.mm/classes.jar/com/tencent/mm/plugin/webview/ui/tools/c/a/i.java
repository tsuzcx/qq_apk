package com.tencent.mm.plugin.webview.ui.tools.c.a;

import com.tencent.luggage.k.a.a.b.b.c;
import com.tencent.luggage.k.a.a.b.b.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;

public final class i
  implements c
{
  private c.a lbX;
  
  public final void a(c.a parama)
  {
    this.lbX = parama;
  }
  
  public final void ca(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189259);
    ac.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "onVideoError(%d, %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    c.a locala;
    String str;
    if (this.lbX != null)
    {
      locala = this.lbX;
      if (paramInt1 != -1024) {
        break label69;
      }
      str = "VIDEO_ERROR";
    }
    for (;;)
    {
      locala.f(str, paramInt1, paramInt2);
      AppMethodBeat.o(189259);
      return;
      label69:
      if (paramInt1 == -1010) {
        str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
      } else if (paramInt1 == -1007) {
        str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
      } else if (paramInt1 == -1004)
      {
        if (!ax.isConnected(ai.getContext())) {
          str = "MEDIA_ERR_NETWORK";
        } else {
          str = "MEDIA_ERR_DECODE";
        }
      }
      else if (!ax.isConnected(ai.getContext())) {
        str = "MEDIA_ERR_NETWORK";
      } else {
        str = "MEDIA_ERR_DECODE";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.a.i
 * JD-Core Version:    0.7.0.1
 */