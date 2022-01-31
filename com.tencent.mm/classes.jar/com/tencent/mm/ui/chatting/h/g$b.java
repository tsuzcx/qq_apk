package com.tencent.mm.ui.chatting.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.chatting.a.c.a;

final class g$b
  extends c.a
{
  TextView eXP;
  ImageView gSx;
  
  public g$b(g paramg, View paramView)
  {
    super(paramView);
    this.gSx = ((ImageView)paramView.findViewById(R.h.fav_icon));
    this.eXO.setSingleLine(false);
    this.eXO.setMaxLines(2);
    this.eXP = ((TextView)paramView.findViewById(R.h.fav_detail));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.g.b
 * JD-Core Version:    0.7.0.1
 */