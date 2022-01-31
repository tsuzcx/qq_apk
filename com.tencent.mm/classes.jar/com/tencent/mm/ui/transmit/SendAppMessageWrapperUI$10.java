package com.tencent.mm.ui.transmit;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.j.a;
import com.tencent.mm.ui.base.p;

final class SendAppMessageWrapperUI$10
  implements j.a
{
  SendAppMessageWrapperUI$10(SendAppMessageWrapperUI paramSendAppMessageWrapperUI) {}
  
  public final void dlh()
  {
    AppMethodBeat.i(154020);
    if (SendAppMessageWrapperUI.h(this.AAH) != null)
    {
      SendAppMessageWrapperUI.h(this.AAH).dismiss();
      SendAppMessageWrapperUI.i(this.AAH);
    }
    AppMethodBeat.o(154020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.10
 * JD-Core Version:    0.7.0.1
 */