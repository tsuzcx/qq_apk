package com.tencent.mm.ui.chatting;

import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.g;

final class au$2
  implements Runnable
{
  au$2(au paramau, WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3, am paramam) {}
  
  public final void run()
  {
    ShowMessageFromWX.Req localReq = g.c(au.a(this.vnC), this.iRq, this.krh);
    g.a(au.a(this.vnC), this.Bz, this.val$appId, localReq, 0, new au.2.1(this, localReq), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.au.2
 * JD-Core Version:    0.7.0.1
 */