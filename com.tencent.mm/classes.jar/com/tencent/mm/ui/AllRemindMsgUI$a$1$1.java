package com.tencent.mm.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.widget.ProgressBar;

final class AllRemindMsgUI$a$1$1
  implements Runnable
{
  AllRemindMsgUI$a$1$1(AllRemindMsgUI.a.1 param1) {}
  
  public final void run()
  {
    AllRemindMsgUI.c(this.uGD.uGC.uGB).setVisibility(0);
    AllRemindMsgUI.e(this.uGD.uGC.uGB).setVisibility(8);
    AllRemindMsgUI.a(this.uGD.uGC.uGB).agL.notifyChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.a.1.1
 * JD-Core Version:    0.7.0.1
 */