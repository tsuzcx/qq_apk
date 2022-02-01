package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.model.app.h;

final class w$5
  implements Runnable
{
  w$5(w paramw, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(34613);
    h.a(this.aejf.mContext, this.NpR, this.aejf.mContext.getString(R.l.chatfooter_mail_without_unread_count), null, null);
    AppMethodBeat.o(34613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.w.5
 * JD-Core Version:    0.7.0.1
 */