package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.base.NoMeasuredTextView;

final class z$a
  extends c.a
{
  protected ImageView ffK;
  protected NoMeasuredTextView vES;
  
  z$a(z paramz) {}
  
  public final a dZ(View paramView)
  {
    super.dN(paramView);
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.ffK = ((ImageView)paramView.findViewById(R.h.like_avatar));
    this.vES = ((NoMeasuredTextView)paramView.findViewById(R.h.tip_msg));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z.a
 * JD-Core Version:    0.7.0.1
 */