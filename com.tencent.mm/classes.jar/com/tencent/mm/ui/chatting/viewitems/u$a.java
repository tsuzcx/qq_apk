package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$a
  extends c.a
{
  protected TextView KyM;
  protected ImageView KyN;
  
  public final a gF(View paramView)
  {
    AppMethodBeat.i(36991);
    super.gs(paramView);
    this.KyM = ((TextView)paramView.findViewById(2131301539));
    this.yUp = ((TextView)paramView.findViewById(2131298185));
    this.KyN = ((ImageView)paramView.findViewById(2131301540));
    this.iFD = ((CheckBox)paramView.findViewById(2131298068));
    this.hcH = paramView.findViewById(2131298147);
    AppMethodBeat.o(36991);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.a
 * JD-Core Version:    0.7.0.1
 */