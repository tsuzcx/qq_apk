package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.model.app.h;

final class u$5
  implements Runnable
{
  u$5(u paramu, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(34613);
    h.a(this.WBL.mContext, this.Hse, this.WBL.mContext.getString(R.l.chatfooter_mail_without_unread_count), null, null);
    AppMethodBeat.o(34613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.u.5
 * JD-Core Version:    0.7.0.1
 */