package com.tencent.mm.ui.transmit;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class SendAppMessageWrapperUI$5
  implements q.a
{
  SendAppMessageWrapperUI$5(SendAppMessageWrapperUI paramSendAppMessageWrapperUI, WXMediaMessage paramWXMediaMessage) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(35216);
    if (paramBoolean)
    {
      SendAppMessageWrapperUI.a(this.AAH, this.cac, paramString, paramInt);
      AppMethodBeat.o(35216);
      return;
    }
    SendAppMessageWrapperUI.e(this.AAH);
    AppMethodBeat.o(35216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.5
 * JD-Core Version:    0.7.0.1
 */