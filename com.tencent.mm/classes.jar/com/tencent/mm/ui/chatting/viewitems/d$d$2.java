package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.i;
import java.util.Locale;

final class d$d$2
  implements b.i
{
  d$d$2(d.d paramd, d.c paramc) {}
  
  public final void acG() {}
  
  public final void acH() {}
  
  public final String tX()
  {
    AppMethodBeat.i(32824);
    String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
    AppMethodBeat.o(32824);
    return str;
  }
  
  public final void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(32823);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.zSV.zSu.setImageBitmap(paramBitmap);
      this.zSV.zSu.setVisibility(0);
      this.zSV.zSv.setVisibility(4);
      AppMethodBeat.o(32823);
      return;
    }
    this.zSV.zSu.setVisibility(4);
    this.zSV.zSv.setVisibility(0);
    AppMethodBeat.o(32823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.d.2
 * JD-Core Version:    0.7.0.1
 */