package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.storage.IBrandSubscribeMsgService.b;
import com.tencent.mm.msgsubscription.storage.IBrandSubscribeMsgService.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Map;

final class ah$7
  implements IBrandSubscribeMsgService.b
{
  ah$7(ah paramah, String paramString, Map paramMap, com.tencent.mm.storage.bo parambo, bo parambo1) {}
  
  public final void c(String paramString, IBrandSubscribeMsgService.c paramc)
  {
    boolean bool = false;
    AppMethodBeat.i(169882);
    if (paramString.equals(ah.d(this.Inu)))
    {
      ac.d("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s, templateId: %s, isSubscribed: %b, switchOpened: %b", new Object[] { this.CIt, paramString, Boolean.valueOf(paramc.iis), Boolean.valueOf(paramc.iit) });
      paramString = this.Inu;
      Map localMap = this.frY;
      com.tencent.mm.storage.bo localbo = this.hmq;
      bo localbo1 = this.InF;
      if (!paramc.iis) {
        bool = true;
      }
      ah.a(paramString, localMap, localbo, localbo1, bool, paramc.iit, true);
    }
    AppMethodBeat.o(169882);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(169883);
    ac.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo getSubscribeStatus onError");
    AppMethodBeat.o(169883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ah.7
 * JD-Core Version:    0.7.0.1
 */