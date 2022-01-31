package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R.h;

final class m$a
  extends c.a
{
  protected TextView vDc;
  
  public final a dT(View paramView)
  {
    super.dN(paramView);
    this.vDc = ((TextView)paramView.findViewById(R.h.location_share_content));
    this.nSa = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.a
 * JD-Core Version:    0.7.0.1
 */