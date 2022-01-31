package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.p;
import java.util.TimerTask;

final class f$3
  extends TimerTask
{
  f$3(p paramp, ah paramah) {}
  
  public final void run()
  {
    if (this.hZQ != null)
    {
      this.hZQ.dismiss();
      this.hZR.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.f.3
 * JD-Core Version:    0.7.0.1
 */