package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class bk$d
  extends c.a
{
  TextView PNK;
  
  public final c.a hd(View paramView)
  {
    AppMethodBeat.i(37548);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(2131298558));
    this.PNK = ((TextView)paramView.findViewById(2131298593));
    this.clickArea = paramView.findViewById(2131298411);
    this.stateIV = ((ImageView)paramView.findViewById(2131298554));
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = paramView.findViewById(2131298508);
    AppMethodBeat.o(37548);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bk.d
 * JD-Core Version:    0.7.0.1
 */