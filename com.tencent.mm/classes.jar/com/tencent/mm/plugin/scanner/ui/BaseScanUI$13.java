package com.tencent.mm.plugin.scanner.ui;

import android.hardware.Camera;
import android.os.Message;
import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class BaseScanUI$13
  extends ah
{
  BaseScanUI$13(BaseScanUI paramBaseScanUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    BaseScanUI localBaseScanUI;
    if ((BaseScanUI.g(this.nJg) != null) && (BaseScanUI.r(this.nJg)) && (!BaseScanUI.L(this.nJg)) && (paramMessage.what == 0))
    {
      BaseScanUI.a(this.nJg, System.currentTimeMillis());
      paramMessage = BaseScanUI.g(this.nJg);
      localBaseScanUI = this.nJg;
      if ((paramMessage.dwJ == null) || (!paramMessage.jOC)) {}
    }
    try
    {
      paramMessage.byr();
      paramMessage.dwJ.autoFocus(localBaseScanUI);
      return;
    }
    catch (RuntimeException paramMessage)
    {
      y.w("MicroMsg.scanner.ScanCamera", "autoFocus() " + paramMessage.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.13
 * JD-Core Version:    0.7.0.1
 */