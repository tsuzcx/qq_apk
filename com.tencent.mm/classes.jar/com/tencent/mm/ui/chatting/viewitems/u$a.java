package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$a
  extends c.a
{
  protected TextView Kcu;
  protected ImageView Kcv;
  
  public final a gA(View paramView)
  {
    AppMethodBeat.i(36991);
    super.gn(paramView);
    this.Kcu = ((TextView)paramView.findViewById(2131301539));
    this.yEk = ((TextView)paramView.findViewById(2131298185));
    this.Kcv = ((ImageView)paramView.findViewById(2131301540));
    this.iCK = ((CheckBox)paramView.findViewById(2131298068));
    this.gZU = paramView.findViewById(2131298147);
    AppMethodBeat.o(36991);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.a
 * JD-Core Version:    0.7.0.1
 */