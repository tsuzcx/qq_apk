package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.h;

final class SnsTimeLineUI$21
  implements Runnable
{
  SnsTimeLineUI$21(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void run()
  {
    h.a(this.pfC, this.pfC.getString(i.j.notification_need_resend_dialog_prompt), "", this.pfC.getString(i.j.notification_need_resend_dialog_prompt_resend_now), this.pfC.getString(i.j.app_cancel), new SnsTimeLineUI.21.1(this), new SnsTimeLineUI.21.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.21
 * JD-Core Version:    0.7.0.1
 */