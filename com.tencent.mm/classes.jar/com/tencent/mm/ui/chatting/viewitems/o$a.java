package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o$a
  extends c.a
{
  TextView zUl;
  RelativeLayout zUm;
  
  o$a(o paramo) {}
  
  final a ff(View paramView)
  {
    AppMethodBeat.i(153944);
    super.eV(paramView);
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jYu = paramView.findViewById(2131822580);
    this.zUl = ((TextView)paramView.findViewById(2131822724));
    this.zUm = ((RelativeLayout)paramView.findViewById(2131822725));
    AppMethodBeat.o(153944);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o.a
 * JD-Core Version:    0.7.0.1
 */