package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.NoMeasuredTextView;

final class ac$a
  extends c.a
{
  protected ImageView gxs;
  protected NoMeasuredTextView zWg;
  
  ac$a(ac paramac) {}
  
  public final a fn(View paramView)
  {
    AppMethodBeat.i(33218);
    super.eV(paramView);
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.gxs = ((ImageView)paramView.findViewById(2131822705));
    this.zWg = ((NoMeasuredTextView)paramView.findViewById(2131822707));
    AppMethodBeat.o(33218);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.a
 * JD-Core Version:    0.7.0.1
 */