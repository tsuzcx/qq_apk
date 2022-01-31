package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.TimerTask;

final class n$3
  extends TimerTask
{
  n$3(ProgressDialog paramProgressDialog, ah paramah) {}
  
  public final void run()
  {
    if (this.iMq != null)
    {
      this.iMq.dismiss();
      this.hZR.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.n.3
 * JD-Core Version:    0.7.0.1
 */