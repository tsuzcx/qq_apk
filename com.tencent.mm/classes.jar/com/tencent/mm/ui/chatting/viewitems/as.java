package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;

final class as
  extends c.a
{
  protected TextView eXP;
  protected TextView vGU;
  protected TextView vGV;
  protected Button vGW;
  protected Button vGX;
  protected ImageView vGY;
  
  public final as ec(View paramView)
  {
    super.dN(paramView);
    this.eXP = ((TextView)paramView.findViewById(R.h.chatting_appmsg_desc_tv));
    this.vGU = ((TextView)paramView.findViewById(R.h.chatting_appmsg_date_tv));
    this.vGV = ((TextView)paramView.findViewById(R.h.chatting_appmsg_time_tv));
    this.vGW = ((Button)paramView.findViewById(R.h.chatting_item_voiceremind_play));
    this.vGX = ((Button)paramView.findViewById(R.h.chatting_item_voiceremind_del));
    this.vGY = ((ImageView)paramView.findViewById(R.h.chatting_timeout_icon));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.as
 * JD-Core Version:    0.7.0.1
 */