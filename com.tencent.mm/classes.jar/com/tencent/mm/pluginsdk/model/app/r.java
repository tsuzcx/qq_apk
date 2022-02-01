package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/app/AppShareUtil;", "", "()V", "TAG", "", "canSendToStatus", "", "wxMsg", "Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;", "canShareVideoFile", "req", "Lcom/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final r XSH;
  
  static
  {
    AppMethodBeat.i(244906);
    XSH = new r();
    AppMethodBeat.o(244906);
  }
  
  public static final boolean a(SendMessageToWX.Req paramReq)
  {
    AppMethodBeat.i(244902);
    s.u(paramReq, "req");
    if ((paramReq.scene == 1) || (paramReq.scene == 4))
    {
      AppMethodBeat.o(244902);
      return true;
    }
    AppMethodBeat.o(244902);
    return false;
  }
  
  public static final boolean b(WXMediaMessage paramWXMediaMessage)
  {
    AppMethodBeat.i(244900);
    s.u(paramWXMediaMessage, "wxMsg");
    if ((paramWXMediaMessage.getType() == 1) || (paramWXMediaMessage.getType() == 2) || (paramWXMediaMessage.getType() == 76) || (paramWXMediaMessage.getType() == 38))
    {
      AppMethodBeat.o(244900);
      return true;
    }
    AppMethodBeat.o(244900);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.r
 * JD-Core Version:    0.7.0.1
 */