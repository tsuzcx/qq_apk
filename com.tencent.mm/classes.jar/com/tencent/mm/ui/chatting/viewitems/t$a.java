package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t$a
  extends c.a
{
  protected TextView IlU;
  protected ImageView IlV;
  
  public final a gj(View paramView)
  {
    AppMethodBeat.i(36991);
    super.fX(paramView);
    this.IlU = ((TextView)paramView.findViewById(2131301539));
    this.xpH = ((TextView)paramView.findViewById(2131298185));
    this.IlV = ((ImageView)paramView.findViewById(2131301540));
    this.ijt = ((CheckBox)paramView.findViewById(2131298068));
    this.gGk = paramView.findViewById(2131298147);
    AppMethodBeat.o(36991);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t.a
 * JD-Core Version:    0.7.0.1
 */