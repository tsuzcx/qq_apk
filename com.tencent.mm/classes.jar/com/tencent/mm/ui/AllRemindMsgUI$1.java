package com.tencent.mm.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AllRemindMsgUI$1
  extends RecyclerView.c
{
  AllRemindMsgUI$1(AllRemindMsgUI paramAllRemindMsgUI) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(29112);
    super.onChanged();
    ab.i("MicroMsg.emoji.AllRemindMsgUI", "[onChanged] size:%s", new Object[] { Integer.valueOf(AllRemindMsgUI.a(this.yTD).getItemCount()) });
    if (AllRemindMsgUI.a(this.yTD).getItemCount() == 0)
    {
      AllRemindMsgUI.b(this.yTD).setVisibility(0);
      AllRemindMsgUI.c(this.yTD).setVisibility(8);
      AppMethodBeat.o(29112);
      return;
    }
    AllRemindMsgUI.b(this.yTD).setVisibility(8);
    AllRemindMsgUI.c(this.yTD).setVisibility(0);
    AppMethodBeat.o(29112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.1
 * JD-Core Version:    0.7.0.1
 */