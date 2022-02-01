package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMTextView;

final class j$a
  extends c.a
{
  ImageView aeNG;
  MMTextView aePx;
  View hDw;
  
  public final c.a P(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36886);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.fAm));
    this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
    this.aePx = ((MMTextView)paramView.findViewById(R.h.fxy));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    this.hDw = paramView.findViewById(R.h.fxw);
    if (!paramBoolean)
    {
      this.aeNG = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
      this.stateIV = ((ImageView)paramView.findViewById(R.h.fAj));
      this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
    }
    AppMethodBeat.o(36886);
    return this;
  }
  
  public final View getMainContainerView()
  {
    return this.hDw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.a
 * JD-Core Version:    0.7.0.1
 */