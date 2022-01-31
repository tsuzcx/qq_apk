package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.c.a;

final class am$4
  implements View.OnClickListener
{
  am$4(am paramam, bi parambi, com.tencent.mm.plugin.subapp.c.e parame) {}
  
  public final void onClick(View paramView)
  {
    h.a(am.a(this.vGE).vtz.getContext(), R.l.voice_reminder_dialog_del_message, R.l.voice_reminder_dialog_title, new am.4.1(this), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.4
 * JD-Core Version:    0.7.0.1
 */