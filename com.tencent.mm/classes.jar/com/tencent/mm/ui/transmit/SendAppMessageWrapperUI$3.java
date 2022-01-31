package com.tencent.mm.ui.transmit;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class SendAppMessageWrapperUI$3
  implements q.a
{
  SendAppMessageWrapperUI$3(SendAppMessageWrapperUI paramSendAppMessageWrapperUI, WXMediaMessage paramWXMediaMessage) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      SendAppMessageWrapperUI.a(this.whK, this.bya, paramString, paramInt);
      return;
    }
    SendAppMessageWrapperUI.d(this.whK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.3
 * JD-Core Version:    0.7.0.1
 */