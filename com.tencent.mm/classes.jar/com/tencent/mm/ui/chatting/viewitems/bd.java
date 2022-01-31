package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R.h;

final class bd
  extends c.a
{
  TextView eXP;
  
  public final c.a ee(View paramView)
  {
    super.dN(paramView);
    this.dsz = ((TextView)paramView.findViewById(R.h.chatting_time_tv));
    this.nSa = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.eXP = ((TextView)paramView.findViewById(R.h.chatting_content_itv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bd
 * JD-Core Version:    0.7.0.1
 */