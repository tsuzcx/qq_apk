package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class bs
  extends c.a
{
  protected TextView aeXu;
  protected TextView aeXv;
  protected Button aeXw;
  protected Button aeXx;
  protected ImageView aeXy;
  protected TextView plr;
  
  public final bs lQ(View paramView)
  {
    AppMethodBeat.i(37551);
    super.create(paramView);
    this.plr = ((TextView)paramView.findViewById(R.h.fwH));
    this.aeXu = ((TextView)paramView.findViewById(R.h.fwF));
    this.aeXv = ((TextView)paramView.findViewById(R.h.fxd));
    this.aeXw = ((Button)paramView.findViewById(R.h.fzd));
    this.aeXx = ((Button)paramView.findViewById(R.h.fzc));
    this.aeXy = ((ImageView)paramView.findViewById(R.h.fAn));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    AppMethodBeat.o(37551);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bs
 * JD-Core Version:    0.7.0.1
 */