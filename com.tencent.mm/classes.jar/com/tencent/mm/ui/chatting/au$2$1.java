package com.tencent.mm.ui.chatting;

import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.pluginsdk.model.app.am;
import java.util.Map;

final class au$2$1
  implements am
{
  au$2$1(au.2 param2, ShowMessageFromWX.Req paramReq) {}
  
  public final void cW(boolean paramBoolean)
  {
    if (paramBoolean) {
      au.b(this.vnD.vnC).put(this.rUe.transaction, this.rUe);
    }
    if (this.vnD.vnB != null) {
      this.vnD.vnB.cW(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.au.2.1
 * JD-Core Version:    0.7.0.1
 */