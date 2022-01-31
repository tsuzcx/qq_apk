package com.tencent.mm.ui.transmit;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.i.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class SelectConversationUI$2
  implements i.b
{
  SelectConversationUI$2(SelectConversationUI paramSelectConversationUI, e parame) {}
  
  public final void kP(int paramInt)
  {
    AppMethodBeat.i(35125);
    ab.i("MicroMsg.SelectConversationUI", "onLoadImageResult() result:%d", new Object[] { Integer.valueOf(paramInt) });
    e locale = this.AAq;
    locale.iNl = true;
    if (locale.lw())
    {
      al.ae(locale.hGy);
      locale.aMj();
    }
    AppMethodBeat.o(35125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.2
 * JD-Core Version:    0.7.0.1
 */