package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.i;
import java.util.Locale;

final class t$a$1
  implements b.i
{
  t$a$1(t.a parama, t.d paramd) {}
  
  public final void acG() {}
  
  public final void acH() {}
  
  public final String tX()
  {
    AppMethodBeat.i(33045);
    String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
    AppMethodBeat.o(33045);
    return str;
  }
  
  public final void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(33044);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.zUB.zSu.setImageBitmap(paramBitmap);
      this.zUB.zSu.setVisibility(0);
      this.zUB.zSv.setVisibility(4);
      AppMethodBeat.o(33044);
      return;
    }
    this.zUB.zSu.setVisibility(4);
    this.zUB.zSv.setVisibility(0);
    AppMethodBeat.o(33044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t.a.1
 * JD-Core Version:    0.7.0.1
 */