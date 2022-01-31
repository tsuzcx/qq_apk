package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.ai;
import com.tencent.mm.pluginsdk.model.app.g;

final class ar$2
  implements Runnable
{
  ar$2(ar paramar, WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, ai paramai) {}
  
  public final void run()
  {
    AppMethodBeat.i(31088);
    ShowMessageFromWX.Req localReq = g.c(ar.a(this.zCY), this.kZP, this.mMU);
    g.a(ar.a(this.zCY), this.Cl, this.val$appId, localReq, 0, new ar.2.1(this, localReq), null);
    AppMethodBeat.o(31088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ar.2
 * JD-Core Version:    0.7.0.1
 */