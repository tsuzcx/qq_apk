package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class by
  extends c.a
{
  TextView jBR;
  
  public final View getMainContainerView()
  {
    return null;
  }
  
  public final c.a hk(View paramView)
  {
    AppMethodBeat.i(37565);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(2131298558));
    this.userTV = ((TextView)paramView.findViewById(2131298566));
    this.jBR = ((TextView)paramView.findViewById(2131298416));
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = paramView.findViewById(2131298508);
    AppMethodBeat.o(37565);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.by
 * JD-Core Version:    0.7.0.1
 */