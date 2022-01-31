package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class bg
  extends c.a
{
  TextView gpM;
  
  public final c.a fs(View paramView)
  {
    AppMethodBeat.i(33455);
    super.eV(paramView);
    this.ekh = ((TextView)paramView.findViewById(2131820587));
    this.qFY = ((TextView)paramView.findViewById(2131821122));
    this.gpM = ((TextView)paramView.findViewById(2131821123));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    AppMethodBeat.o(33455);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bg
 * JD-Core Version:    0.7.0.1
 */