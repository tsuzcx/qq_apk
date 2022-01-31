package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.TimerTask;

final class b$8
  extends TimerTask
{
  b$8(ProgressDialog paramProgressDialog, ah paramah) {}
  
  public final void run()
  {
    if (this.iMq != null)
    {
      this.iMq.dismiss();
      this.hZR.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.b.8
 * JD-Core Version:    0.7.0.1
 */