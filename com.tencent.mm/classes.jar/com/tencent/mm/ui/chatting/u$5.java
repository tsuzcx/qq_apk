package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.model.app.g;

final class u$5
  implements Runnable
{
  u$5(u paramu, Intent paramIntent) {}
  
  public final void run()
  {
    g.a(this.vkL.mContext, this.njN, this.vkL.mContext.getString(R.l.chatfooter_mail_without_unread_count), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.u.5
 * JD-Core Version:    0.7.0.1
 */