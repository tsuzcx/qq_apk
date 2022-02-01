package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class br
  extends c.a
{
  protected ImageView KiB;
  protected TextView iCV;
  
  public final br gO(View paramView)
  {
    AppMethodBeat.i(37564);
    super.gn(paramView);
    this.iCV = ((TextView)paramView.findViewById(2131298026));
    this.KiB = ((ImageView)paramView.findViewById(2131298047));
    this.iCK = ((CheckBox)paramView.findViewById(2131298068));
    this.gZU = paramView.findViewById(2131298147);
    AppMethodBeat.o(37564);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.br
 * JD-Core Version:    0.7.0.1
 */