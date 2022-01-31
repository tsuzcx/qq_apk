package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class AllRemindMsgUI$c$1
  implements View.OnClickListener
{
  AllRemindMsgUI$c$1(AllRemindMsgUI.c paramc, AllRemindMsgUI paramAllRemindMsgUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = (AllRemindMsgUI.d)paramView.getTag();
    y.i("MicroMsg.emoji.AllRemindMsgUI", "[onClick] :%s", new Object[] { paramView });
    AllRemindMsgUI.c.a(this.uGG.uGB, paramView.username, paramView.bIt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.c.1
 * JD-Core Version:    0.7.0.1
 */