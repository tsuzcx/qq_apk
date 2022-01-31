package com.tencent.mm.ui;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;

final class AllRemindMsgUI$c
  extends RecyclerView.v
{
  View aie;
  TextView eXr;
  ImageView ffK;
  TextView nXe;
  TextView uGE;
  
  public AllRemindMsgUI$c(AllRemindMsgUI paramAllRemindMsgUI, View paramView)
  {
    super(paramView);
    this.aie = paramView;
    this.eXr = ((TextView)paramView.findViewById(R.h.title));
    this.uGE = ((TextView)paramView.findViewById(R.h.timestamp));
    this.nXe = ((TextView)paramView.findViewById(R.h.nickname));
    this.ffK = ((ImageView)paramView.findViewById(R.h.avatar));
    this.aie.setOnClickListener(new AllRemindMsgUI.c.1(this, paramAllRemindMsgUI));
    this.aie.setOnTouchListener(new AllRemindMsgUI.c.2(this, paramAllRemindMsgUI));
    this.aie.setOnLongClickListener(new AllRemindMsgUI.c.3(this, paramAllRemindMsgUI));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.c
 * JD-Core Version:    0.7.0.1
 */