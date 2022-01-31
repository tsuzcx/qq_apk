package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;

final class y$a
  extends c.a
{
  protected TextView vEK;
  protected TextView vEL;
  protected TextView vEM;
  protected TextView vEN;
  protected TextView vEO;
  protected TextView vEP;
  protected ImageView vEQ;
  
  y$a(y paramy) {}
  
  public final a dY(View paramView)
  {
    super.dN(paramView);
    this.vEK = ((TextView)paramView.findViewById(R.h.step_number));
    this.vEM = ((TextView)paramView.findViewById(R.h.rank_number));
    this.vEL = ((TextView)paramView.findViewById(R.h.step_number_tip));
    this.vEN = ((TextView)paramView.findViewById(R.h.rank_number_tip));
    this.vEO = ((TextView)paramView.findViewById(R.h.view_rank_tip));
    this.vEP = ((TextView)paramView.findViewById(R.h.hard_device_spilter));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.vEQ = ((ImageView)paramView.findViewById(R.h.view_avatar));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.a
 * JD-Core Version:    0.7.0.1
 */