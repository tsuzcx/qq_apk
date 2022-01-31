package com.tencent.mm.ui.transmit;

import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class SendAppMessageWrapperUI$1
  implements ap.a
{
  SendAppMessageWrapperUI$1(SendAppMessageWrapperUI paramSendAppMessageWrapperUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(35213);
    if ((this.AAH.getWindow() == null) || (this.AAH.getWindow().getDecorView() == null) || (this.AAH.getWindow().getDecorView().getWindowToken() == null))
    {
      if (SendAppMessageWrapperUI.a(this.AAH) < 10)
      {
        SendAppMessageWrapperUI.b(this.AAH);
        AppMethodBeat.o(35213);
        return true;
      }
      AppMethodBeat.o(35213);
      return false;
    }
    SendAppMessageWrapperUI.c(this.AAH);
    AppMethodBeat.o(35213);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.1
 * JD-Core Version:    0.7.0.1
 */