package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class bx
  extends c.a
{
  protected ImageView PRJ;
  protected TextView jBR;
  
  public final View getMainContainerView()
  {
    return null;
  }
  
  public final bx hj(View paramView)
  {
    AppMethodBeat.i(37564);
    super.create(paramView);
    this.jBR = ((TextView)paramView.findViewById(2131298367));
    this.PRJ = ((ImageView)paramView.findViewById(2131298388));
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = paramView.findViewById(2131298508);
    AppMethodBeat.o(37564);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bx
 * JD-Core Version:    0.7.0.1
 */