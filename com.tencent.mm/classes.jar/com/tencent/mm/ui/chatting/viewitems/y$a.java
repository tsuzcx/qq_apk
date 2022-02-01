package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class y$a
  extends c.a
{
  protected TextView PKZ;
  protected ImageView PLa;
  
  public final a gV(View paramView)
  {
    AppMethodBeat.i(36991);
    super.create(paramView);
    this.PKZ = ((TextView)paramView.findViewById(2131303749));
    this.userTV = ((TextView)paramView.findViewById(2131298566));
    this.PLa = ((ImageView)paramView.findViewById(2131303750));
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = paramView.findViewById(2131298508);
    AppMethodBeat.o(36991);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.a
 * JD-Core Version:    0.7.0.1
 */