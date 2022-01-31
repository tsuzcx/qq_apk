package com.tencent.mm.plugin.readerapp.ui;

import android.app.ProgressDialog;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.TimerTask;

final class b$4
  extends TimerTask
{
  b$4(ProgressDialog paramProgressDialog, ah paramah) {}
  
  public final void run()
  {
    if (this.iMq != null)
    {
      this.iMq.dismiss();
      this.hZR.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.b.4
 * JD-Core Version:    0.7.0.1
 */