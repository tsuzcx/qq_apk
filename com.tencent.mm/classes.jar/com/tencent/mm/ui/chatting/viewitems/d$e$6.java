package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.plugin.appbrand.s.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class d$e$6
  implements b.i
{
  d$e$6(d.e parame, d.c paramc) {}
  
  public final void acG()
  {
    AppMethodBeat.i(32844);
    this.zSV.zSC.setVisibility(4);
    AppMethodBeat.o(32844);
  }
  
  public final void acH()
  {
    AppMethodBeat.i(153926);
    ab.w("MicroMsg.ChattingItemAppMsgTo", "hy: decode recorder cover failed sender!");
    h.qsU.cT(808, 3);
    AppMethodBeat.o(153926);
  }
  
  public final String tX()
  {
    AppMethodBeat.i(32846);
    String str = "CHAT#" + n.bt(this);
    AppMethodBeat.o(32846);
    return str;
  }
  
  public final void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(32845);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.zSV.zSC.setImageBitmap(paramBitmap);
      this.zSV.zSC.setVisibility(0);
    }
    AppMethodBeat.o(32845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.e.6
 * JD-Core Version:    0.7.0.1
 */