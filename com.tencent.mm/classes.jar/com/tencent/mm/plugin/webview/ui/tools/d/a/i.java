package com.tencent.mm.plugin.webview.ui.tools.d.a;

import com.tencent.luggage.k.a.a.b.b.c;
import com.tencent.luggage.k.a.a.b.b.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;

public final class i
  implements c
{
  private c.a kAF;
  
  public final void a(c.a parama)
  {
    this.kAF = parama;
  }
  
  public final void cd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188692);
    ad.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "onVideoError(%d, %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    c.a locala;
    String str;
    if (this.kAF != null)
    {
      locala = this.kAF;
      if (paramInt1 != -1024) {
        break label69;
      }
      str = "VIDEO_ERROR";
    }
    for (;;)
    {
      locala.f(str, paramInt1, paramInt2);
      AppMethodBeat.o(188692);
      return;
      label69:
      if (paramInt1 == -1010) {
        str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
      } else if (paramInt1 == -1007) {
        str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
      } else if (paramInt1 == -1004)
      {
        if (!ay.isConnected(aj.getContext())) {
          str = "MEDIA_ERR_NETWORK";
        } else {
          str = "MEDIA_ERR_DECODE";
        }
      }
      else if (!ay.isConnected(aj.getContext())) {
        str = "MEDIA_ERR_NETWORK";
      } else {
        str = "MEDIA_ERR_DECODE";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.d.a.i
 * JD-Core Version:    0.7.0.1
 */