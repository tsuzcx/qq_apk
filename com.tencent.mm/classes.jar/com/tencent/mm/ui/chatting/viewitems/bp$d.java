package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class bp$d
  extends c.a
{
  TextView XjK;
  
  public final c.a ip(View paramView)
  {
    AppMethodBeat.i(37548);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.dzs));
    this.XjK = ((TextView)paramView.findViewById(R.h.dzT));
    this.clickArea = paramView.findViewById(R.h.chatting_click_area);
    this.stateIV = ((ImageView)paramView.findViewById(R.h.dzp));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = paramView.findViewById(R.h.dyD);
    AppMethodBeat.o(37548);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bp.d
 * JD-Core Version:    0.7.0.1
 */