package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class t$a
  extends c.a
{
  protected TextView GLX;
  protected ImageView GLY;
  
  public final a fW(View paramView)
  {
    AppMethodBeat.i(36991);
    super.fK(paramView);
    this.GLX = ((TextView)paramView.findViewById(2131301539));
    this.wet = ((TextView)paramView.findViewById(2131298185));
    this.GLY = ((ImageView)paramView.findViewById(2131301540));
    this.hIS = ((CheckBox)paramView.findViewById(2131298068));
    this.lRB = paramView.findViewById(2131298147);
    AppMethodBeat.o(36991);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t.a
 * JD-Core Version:    0.7.0.1
 */