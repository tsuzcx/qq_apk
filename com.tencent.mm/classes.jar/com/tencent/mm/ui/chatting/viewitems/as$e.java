package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.ui.bb;

final class as$e
  extends c.a
{
  ImageView aeNG;
  RTChattingEmojiView aePJ;
  ImageView aePK;
  ViewStub aeTZ;
  View aeUa;
  ImageView aeUb;
  
  public final c.a P(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37294);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.fAm));
    this.aePJ = ((RTChattingEmojiView)paramView.findViewById(R.h.fxz));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    this.aeUa = paramView.findViewById(R.h.fxI);
    this.aeUb = ((ImageView)paramView.findViewById(R.h.fxJ));
    this.aeUb.setImageDrawable(bb.m(paramView.getContext(), R.k.emoticonstore_capture_icon, -1));
    if (paramBoolean) {
      this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
    }
    for (;;)
    {
      if (this.aePK != null) {
        ((ViewGroup)this.aePK.getParent()).setBackgroundDrawable(null);
      }
      this.aeTZ = ((ViewStub)paramView.findViewById(R.h.fzT));
      AppMethodBeat.o(37294);
      return this;
      this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
      this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
      this.stateIV = ((ImageView)paramView.findViewById(R.h.fAj));
      this.aeNG = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
    }
  }
  
  public final View getMainContainerView()
  {
    return this.aePJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.as.e
 * JD-Core Version:    0.7.0.1
 */