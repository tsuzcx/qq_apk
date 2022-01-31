package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.plugin.appbrand.s.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class d$d$4
  implements b.i
{
  d$d$4(d.d paramd, d.c paramc) {}
  
  public final void acG()
  {
    AppMethodBeat.i(32827);
    this.zSV.zSC.setVisibility(4);
    AppMethodBeat.o(32827);
  }
  
  public final void acH()
  {
    AppMethodBeat.i(153915);
    ab.w("MicroMsg.ChattingItemAppMsgFrom", "hy: decode recorder cover failed receiver!");
    h.qsU.cT(808, 2);
    AppMethodBeat.o(153915);
  }
  
  public final String tX()
  {
    AppMethodBeat.i(32829);
    String str = "CHAT#" + n.bt(this);
    AppMethodBeat.o(32829);
    return str;
  }
  
  public final void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(32828);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.zSV.zSC.setImageBitmap(paramBitmap);
      this.zSV.zSC.setVisibility(0);
    }
    AppMethodBeat.o(32828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.d.4
 * JD-Core Version:    0.7.0.1
 */