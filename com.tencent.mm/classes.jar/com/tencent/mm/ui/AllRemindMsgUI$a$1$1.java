package com.tencent.mm.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AllRemindMsgUI$a$1$1
  implements Runnable
{
  AllRemindMsgUI$a$1$1(AllRemindMsgUI.a.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(29114);
    AllRemindMsgUI.c(this.yTF.yTE.yTD).setVisibility(0);
    AllRemindMsgUI.e(this.yTF.yTE.yTD).setVisibility(8);
    AllRemindMsgUI.a(this.yTF.yTE.yTD).ajb.notifyChanged();
    AppMethodBeat.o(29114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.a.1.1
 * JD-Core Version:    0.7.0.1
 */