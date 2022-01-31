package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;

final class aa$a
  extends c.a
{
  protected ImageView ffK;
  protected TextView vEU;
  
  aa$a(aa paramaa) {}
  
  public final a ea(View paramView)
  {
    super.dN(paramView);
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.ffK = ((ImageView)paramView.findViewById(R.h.push_avatar));
    this.vEU = ((TextView)paramView.findViewById(R.h.tip_msg));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.a
 * JD-Core Version:    0.7.0.1
 */