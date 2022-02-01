package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class bq$d
  extends c.a
{
  TextView aeUc;
  
  public final c.a lM(View paramView)
  {
    AppMethodBeat.i(37548);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.fAm));
    this.aeUc = ((TextView)paramView.findViewById(R.h.fAN));
    this.clickArea = paramView.findViewById(R.h.chatting_click_area);
    this.stateIV = ((ImageView)paramView.findViewById(R.h.fAj));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    AppMethodBeat.o(37548);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bq.d
 * JD-Core Version:    0.7.0.1
 */