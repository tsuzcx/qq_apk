package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AllRemindMsgUI$c$1
  implements View.OnClickListener
{
  AllRemindMsgUI$c$1(AllRemindMsgUI.c paramc, AllRemindMsgUI paramAllRemindMsgUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29121);
    paramView = (AllRemindMsgUI.d)paramView.getTag();
    ab.i("MicroMsg.emoji.AllRemindMsgUI", "[onClick] :%s", new Object[] { paramView });
    AllRemindMsgUI.c.a(this.yTI.yTD, paramView.username, paramView.cpO);
    AppMethodBeat.o(29121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.c.1
 * JD-Core Version:    0.7.0.1
 */