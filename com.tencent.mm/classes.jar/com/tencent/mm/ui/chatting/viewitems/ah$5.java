package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.storage.IBrandSubscribeMsgService.b;
import com.tencent.mm.msgsubscription.storage.IBrandSubscribeMsgService.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.chatting.d.a;

final class ah$5
  implements IBrandSubscribeMsgService.b
{
  ah$5(ah paramah) {}
  
  public final void c(String paramString, IBrandSubscribeMsgService.c paramc)
  {
    AppMethodBeat.i(37207);
    ac.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo switchSubscribeStatus onFinish isSubscribed: %b, switchOpen: %b", new Object[] { Boolean.valueOf(paramc.iis), Boolean.valueOf(paramc.iit) });
    AppMethodBeat.o(37207);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(37208);
    ac.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo switchSubscribeStatus onError");
    if (ah.b(this.Inu) != null) {
      ah.b(this.Inu).bJU();
    }
    AppMethodBeat.o(37208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ah.5
 * JD-Core Version:    0.7.0.1
 */