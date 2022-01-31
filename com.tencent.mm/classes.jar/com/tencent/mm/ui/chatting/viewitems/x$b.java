package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;

final class x$b
  extends c.a
{
  TextView frb;
  TextView vDK;
  TextView vEC;
  View vED;
  ImageView vEE;
  ImageView vEF;
  TextView vEG;
  TextView vEH;
  
  public final c.a dX(View paramView)
  {
    super.dN(paramView);
    this.dsz = ((TextView)paramView.findViewById(R.h.chatting_time_tv));
    this.vDK = ((TextView)paramView.findViewById(R.h.chatting_type_tv));
    this.frb = ((TextView)paramView.findViewById(R.h.chatting_username_tv));
    this.vEC = ((TextView)paramView.findViewById(R.h.chatting_content_itv));
    this.igg = paramView.findViewById(R.h.chatting_click_area);
    this.vEH = ((TextView)paramView.findViewById(R.h.chatting_mobliename_tv));
    this.vED = paramView.findViewById(R.h.chatting_from_message_add_layout);
    this.vEE = ((ImageView)paramView.findViewById(R.h.chatfrom_bg_fmessage_okicon_iv));
    this.vEF = ((ImageView)paramView.findViewById(R.h.chatting_from_message_add_plus));
    this.vEG = ((TextView)paramView.findViewById(R.h.chatfrom_bg_fmessage_okicon_tv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.b
 * JD-Core Version:    0.7.0.1
 */