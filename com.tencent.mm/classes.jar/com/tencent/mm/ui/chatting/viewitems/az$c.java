package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class az$c
  extends c.a
{
  TextView PNK;
  View pxo;
  TextView tln;
  
  public final View getMainContainerView()
  {
    return this.pxo;
  }
  
  public final c.a hd(View paramView)
  {
    AppMethodBeat.i(37372);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(2131298558));
    this.userTV = ((TextView)paramView.findViewById(2131298566));
    this.PNK = ((TextView)paramView.findViewById(2131298416));
    this.tln = ((TextView)paramView.findViewById(2131298539));
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = paramView.findViewById(2131298508);
    this.pxo = paramView.findViewById(2131298487);
    AppMethodBeat.o(37372);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.az.c
 * JD-Core Version:    0.7.0.1
 */