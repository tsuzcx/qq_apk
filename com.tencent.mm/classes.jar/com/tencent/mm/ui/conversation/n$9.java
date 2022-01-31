package com.tencent.mm.ui.conversation;

import android.app.Activity;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;

final class n$9
  implements Runnable
{
  n$9(n paramn) {}
  
  public final void run()
  {
    h.a(this.vTV.bMV, this.vTV.bMV.getString(R.l.notification_need_resend_dialog_prompt), "", this.vTV.bMV.getString(R.l.notification_need_resend_dialog_prompt_resend_now), this.vTV.bMV.getString(R.l.app_cancel), new n.9.1(this), new n.9.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.n.9
 * JD-Core Version:    0.7.0.1
 */