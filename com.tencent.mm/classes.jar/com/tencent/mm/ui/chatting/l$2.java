package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.q;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Locale;

final class l$2
  implements b.i
{
  l$2(q paramq) {}
  
  public final void acG() {}
  
  public final void acH() {}
  
  public final String tX()
  {
    AppMethodBeat.i(30592);
    String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(112), Integer.valueOf(90) });
    AppMethodBeat.o(30592);
    return str;
  }
  
  public final void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(30591);
    ab.d("MicroMsg.ChattingEditModeSendToAppBrand", "onBitmapLoaded %s", new Object[] { this.jYo.fjT });
    AppMethodBeat.o(30591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.2
 * JD-Core Version:    0.7.0.1
 */