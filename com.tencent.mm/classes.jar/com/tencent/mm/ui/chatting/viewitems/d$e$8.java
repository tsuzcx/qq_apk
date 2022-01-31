package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.i;
import java.util.Locale;

final class d$e$8
  implements b.i
{
  d$e$8(d.e parame, d.c paramc) {}
  
  public final void acG()
  {
    AppMethodBeat.i(153929);
    this.zSV.zSC.setVisibility(4);
    this.zSV.zSB.setVisibility(0);
    AppMethodBeat.o(153929);
  }
  
  public final void acH() {}
  
  public final String tX()
  {
    AppMethodBeat.i(153931);
    String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(120) });
    AppMethodBeat.o(153931);
    return str;
  }
  
  public final void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(153930);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.zSV.zSC.setImageBitmap(paramBitmap);
      this.zSV.zSC.setVisibility(0);
      this.zSV.zSB.setVisibility(4);
    }
    AppMethodBeat.o(153930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.e.8
 * JD-Core Version:    0.7.0.1
 */