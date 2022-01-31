package com.tencent.mm.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;

final class DataTransferUI$1
  extends ah
{
  DataTransferUI$1(DataTransferUI paramDataTransferUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((DataTransferUI.a(this.uIH) != null) && (DataTransferUI.a(this.uIH).isShowing()))
    {
      y.e("MicroMsg.DataTransferUI", "dialog has shown for a long time, auto dismiss it...");
      DataTransferUI.a(this.uIH).dismiss();
      this.uIH.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.DataTransferUI.1
 * JD-Core Version:    0.7.0.1
 */