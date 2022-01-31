package com.tencent.mm.ui;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AllRemindMsgUI$c
  extends RecyclerView.v
{
  View aku;
  ImageView gxs;
  TextView kgG;
  TextView titleTv;
  TextView yTG;
  
  public AllRemindMsgUI$c(AllRemindMsgUI paramAllRemindMsgUI, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(29126);
    this.aku = paramView;
    this.titleTv = ((TextView)paramView.findViewById(2131820680));
    this.yTG = ((TextView)paramView.findViewById(2131827180));
    this.kgG = ((TextView)paramView.findViewById(2131827179));
    this.gxs = ((ImageView)paramView.findViewById(2131823820));
    this.aku.setOnClickListener(new AllRemindMsgUI.c.1(this, paramAllRemindMsgUI));
    this.aku.setOnTouchListener(new AllRemindMsgUI.c.2(this, paramAllRemindMsgUI));
    this.aku.setOnLongClickListener(new AllRemindMsgUI.c.3(this, paramAllRemindMsgUI));
    AppMethodBeat.o(29126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.c
 * JD-Core Version:    0.7.0.1
 */