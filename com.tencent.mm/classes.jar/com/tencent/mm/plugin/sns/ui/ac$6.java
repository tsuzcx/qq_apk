package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

final class ac$6
  implements Runnable
{
  ac$6(ac paramac) {}
  
  public final void run()
  {
    y.i("MicroMsg.SightWidget", "showProgress");
    ac localac = this.oRe;
    MMActivity localMMActivity = this.oRe.bER;
    this.oRe.bER.getString(i.j.app_tip);
    localac.dnm = h.b(localMMActivity, this.oRe.bER.getString(i.j.sns_sight_send_wait), false, new ac.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ac.6
 * JD-Core Version:    0.7.0.1
 */