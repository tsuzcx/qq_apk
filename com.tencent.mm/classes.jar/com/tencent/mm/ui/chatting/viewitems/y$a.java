package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class y$a
  extends c.a
{
  protected View AkF;
  protected TextView Aoo;
  protected ImageView HLM;
  protected ImageView HLN;
  protected TextView aeNs;
  protected TextView aeQG;
  protected ImageView aeQH;
  
  public final a lB(View paramView)
  {
    AppMethodBeat.i(36965);
    super.create(paramView);
    this.HLM = ((ImageView)paramView.findViewById(R.h.fxc));
    this.Aoo = ((TextView)paramView.findViewById(R.h.fwZ));
    this.aeQG = ((TextView)paramView.findViewById(R.h.fwR));
    this.AkF = paramView.findViewById(R.h.fwS);
    this.aeNs = ((TextView)paramView.findViewById(R.h.fwD));
    this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
    this.aeQH = ((ImageView)paramView.findViewById(R.h.fwU));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    this.HLN = ((ImageView)paramView.findViewById(R.h.fxB));
    AppMethodBeat.o(36965);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.a
 * JD-Core Version:    0.7.0.1
 */