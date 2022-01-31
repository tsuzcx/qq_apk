package com.tencent.mm.plugin.traceroute.ui;

import android.os.Message;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.MMProgressBar;

final class NetworkDiagnoseUI$2
  extends ah
{
  NetworkDiagnoseUI$2(NetworkDiagnoseUI paramNetworkDiagnoseUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 2: 
      if (NetworkDiagnoseUI.b(this.pJy) < 95) {
        NetworkDiagnoseUI.c(this.pJy).setProgress(95);
      }
      NetworkDiagnoseUI.d(this.pJy).bOL();
      return;
    case 1: 
      NetworkDiagnoseUI.e(this.pJy);
      if (NetworkDiagnoseUI.b(this.pJy) < 95) {
        NetworkDiagnoseUI.c(this.pJy).setProgress(95);
      }
      NetworkDiagnoseUI.d(this.pJy).bOL();
      return;
    case 3: 
      NetworkDiagnoseUI.c(this.pJy).setProgress(100);
      NetworkDiagnoseUI.a(this.pJy, false);
      return;
    }
    NetworkDiagnoseUI.c(this.pJy).setProgress(100);
    NetworkDiagnoseUI.a(this.pJy, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI.2
 * JD-Core Version:    0.7.0.1
 */