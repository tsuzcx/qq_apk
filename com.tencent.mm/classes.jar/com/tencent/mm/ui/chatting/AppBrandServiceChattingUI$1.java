package com.tencent.mm.ui.chatting;

import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;

final class AppBrandServiceChattingUI$1
  implements Runnable
{
  AppBrandServiceChattingUI$1(AppBrandServiceChattingUI paramAppBrandServiceChattingUI) {}
  
  public final void run()
  {
    h.a(this.vhc, this.vhc.getString(R.l.notification_need_resend_dialog_prompt), "", this.vhc.getString(R.l.notification_need_resend_dialog_prompt_resend_now), this.vhc.getString(R.l.app_cancel), new AppBrandServiceChattingUI.1.1(this), new AppBrandServiceChattingUI.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.1
 * JD-Core Version:    0.7.0.1
 */