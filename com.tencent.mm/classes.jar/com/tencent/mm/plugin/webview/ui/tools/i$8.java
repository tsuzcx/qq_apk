package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.pluginsdk.ui.tools.u.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class i$8
  implements u.a
{
  i$8(i parami) {}
  
  public final void Dc(String paramString)
  {
    AppMethodBeat.i(153203);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.WebViewLongClickHelper", "share image to friend fail, imgPath is null");
      AppMethodBeat.o(153203);
      return;
    }
    i locali = this.vcB;
    if (!locali.dds()) {
      try
      {
        locali.ddt().igU.ahV(paramString);
        AppMethodBeat.o(153203);
        return;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.WebViewLongClickHelper", "sendImgToFriend fail, ex = " + paramString.getMessage());
      }
    }
    AppMethodBeat.o(153203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.i.8
 * JD-Core Version:    0.7.0.1
 */