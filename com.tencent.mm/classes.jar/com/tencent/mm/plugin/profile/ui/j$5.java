package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.p;
import java.util.TimerTask;

final class j$5
  extends TimerTask
{
  j$5(p paramp, ah paramah) {}
  
  public final void run()
  {
    if (this.hZQ != null)
    {
      this.hZQ.dismiss();
      this.hZR.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.j.5
 * JD-Core Version:    0.7.0.1
 */