package com.tencent.mm.ui.transmit;

import android.view.View;
import android.view.Window;
import com.tencent.mm.sdk.platformtools.am.a;

final class SendAppMessageWrapperUI$1
  implements am.a
{
  SendAppMessageWrapperUI$1(SendAppMessageWrapperUI paramSendAppMessageWrapperUI) {}
  
  public final boolean tC()
  {
    boolean bool = false;
    if ((this.whK.getWindow() == null) || (this.whK.getWindow().getDecorView() == null) || (this.whK.getWindow().getDecorView().getWindowToken() == null))
    {
      if (SendAppMessageWrapperUI.a(this.whK) < 10)
      {
        SendAppMessageWrapperUI.b(this.whK);
        bool = true;
      }
      return bool;
    }
    SendAppMessageWrapperUI.c(this.whK);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.1
 * JD-Core Version:    0.7.0.1
 */