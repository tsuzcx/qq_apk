package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;

final class bc
  extends c.a
{
  protected TextView eXP;
  protected ImageView vIn;
  
  public final bc ed(View paramView)
  {
    super.dN(paramView);
    this.eXP = ((TextView)paramView.findViewById(R.h.chatting_appmsg_desc_tv));
    this.vIn = ((ImageView)paramView.findViewById(R.h.chatting_appmsg_thumb_iv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bc
 * JD-Core Version:    0.7.0.1
 */