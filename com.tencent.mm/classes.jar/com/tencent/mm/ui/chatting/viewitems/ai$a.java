package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class ai$a
  extends c.a
{
  protected TextView Aoo;
  protected TextView aeNs;
  protected MMNeat7extView aeQs;
  protected ImageView stateIV;
  
  public final View getMainContainerView()
  {
    return this.aeQs;
  }
  
  public final a lJ(View paramView)
  {
    AppMethodBeat.i(37056);
    super.create(paramView);
    this.aeQs = ((MMNeat7extView)paramView.findViewById(R.h.fxy));
    this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
    this.stateIV = ((ImageView)paramView.findViewById(R.h.fAj));
    this.Aoo = ((TextView)paramView.findViewById(R.h.fwZ));
    this.aeNs = ((TextView)paramView.findViewById(R.h.fwD));
    this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    AppMethodBeat.o(37056);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ai.a
 * JD-Core Version:    0.7.0.1
 */