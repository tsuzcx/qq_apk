package com.tencent.mm.plugin.shake.ui;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.s;

final class ShakeReportUI$6
  implements MessageQueue.IdleHandler
{
  ShakeReportUI$6(ShakeReportUI paramShakeReportUI) {}
  
  public final boolean queueIdle()
  {
    s.a(this.odm, 0, this.odm.getString(R.l.shake_set_mute_tips));
    au.Hx();
    c.Dz().o(4117, Boolean.valueOf(true));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.6
 * JD-Core Version:    0.7.0.1
 */