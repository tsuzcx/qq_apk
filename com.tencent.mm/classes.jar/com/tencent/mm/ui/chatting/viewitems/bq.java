package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class bq
  extends c.a
{
  protected ImageView IrW;
  protected TextView ijE;
  
  public final bq gx(View paramView)
  {
    AppMethodBeat.i(37564);
    super.fX(paramView);
    this.ijE = ((TextView)paramView.findViewById(2131298026));
    this.IrW = ((ImageView)paramView.findViewById(2131298047));
    this.ijt = ((CheckBox)paramView.findViewById(2131298068));
    this.gGk = paramView.findViewById(2131298147);
    AppMethodBeat.o(37564);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bq
 * JD-Core Version:    0.7.0.1
 */