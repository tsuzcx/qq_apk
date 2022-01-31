package com.tencent.mm.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.view.View;
import com.tencent.mm.sdk.platformtools.y;

final class AllRemindMsgUI$1
  extends RecyclerView.c
{
  AllRemindMsgUI$1(AllRemindMsgUI paramAllRemindMsgUI) {}
  
  public final void onChanged()
  {
    super.onChanged();
    y.i("MicroMsg.emoji.AllRemindMsgUI", "[onChanged] size:%s", new Object[] { Integer.valueOf(AllRemindMsgUI.a(this.uGB).getItemCount()) });
    if (AllRemindMsgUI.a(this.uGB).getItemCount() == 0)
    {
      AllRemindMsgUI.b(this.uGB).setVisibility(0);
      AllRemindMsgUI.c(this.uGB).setVisibility(8);
      return;
    }
    AllRemindMsgUI.b(this.uGB).setVisibility(8);
    AllRemindMsgUI.c(this.uGB).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.1
 * JD-Core Version:    0.7.0.1
 */