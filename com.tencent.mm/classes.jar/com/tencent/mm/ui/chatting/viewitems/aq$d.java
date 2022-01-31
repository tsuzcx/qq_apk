package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;

final class aq$d
  extends c.a
{
  TextView vEC;
  
  public final c.a dX(View paramView)
  {
    super.dN(paramView);
    this.dsz = ((TextView)paramView.findViewById(R.h.chatting_time_tv));
    this.vEC = ((TextView)paramView.findViewById(R.h.chatting_voip_tv));
    this.igg = paramView.findViewById(R.h.chatting_click_area);
    this.vBa = ((ImageView)paramView.findViewById(R.h.chatting_state_iv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.d
 * JD-Core Version:    0.7.0.1
 */