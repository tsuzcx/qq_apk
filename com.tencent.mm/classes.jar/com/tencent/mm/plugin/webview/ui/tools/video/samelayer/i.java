package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class i
  implements c
{
  private c.a mLd;
  
  public final void a(c.a parama)
  {
    this.mLd = parama;
  }
  
  public final void cd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212061);
    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoErrorHandler", "onVideoError(%d, %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    c.a locala;
    String str;
    if (this.mLd != null)
    {
      locala = this.mLd;
      if (paramInt1 != -1024) {
        break label69;
      }
      str = "VIDEO_ERROR";
    }
    for (;;)
    {
      locala.h(str, paramInt1, paramInt2);
      AppMethodBeat.o(212061);
      return;
      label69:
      if (paramInt1 == -1010) {
        str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
      } else if (paramInt1 == -1007) {
        str = "MEDIA_ERR_SRC_NOT_SUPPORTED";
      } else if (paramInt1 == -1004)
      {
        if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
          str = "MEDIA_ERR_NETWORK";
        } else {
          str = "MEDIA_ERR_DECODE";
        }
      }
      else if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
        str = "MEDIA_ERR_NETWORK";
      } else {
        str = "MEDIA_ERR_DECODE";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.i
 * JD-Core Version:    0.7.0.1
 */