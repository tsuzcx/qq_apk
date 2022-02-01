package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.ui.ar;

final class aq$e
  extends c.a
{
  ImageView PIn;
  RTChattingEmojiView PKh;
  ImageView PKi;
  ViewStub PNH;
  View PNI;
  ImageView PNJ;
  
  public final c.a G(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37294);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(2131298558));
    this.PKh = ((RTChattingEmojiView)paramView.findViewById(2131298417));
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = paramView.findViewById(2131298508);
    this.PNI = paramView.findViewById(2131298426);
    this.PNJ = ((ImageView)paramView.findViewById(2131298427));
    this.PNJ.setImageDrawable(ar.m(paramView.getContext(), 2131690148, -1));
    if (paramBoolean) {
      this.userTV = ((TextView)paramView.findViewById(2131298566));
    }
    for (;;)
    {
      if (this.PKi != null) {
        ((ViewGroup)this.PKi.getParent()).setBackgroundDrawable(null);
      }
      this.PNH = ((ViewStub)paramView.findViewById(2131298540));
      AppMethodBeat.o(37294);
      return this;
      this.uploadingPB = ((ProgressBar)paramView.findViewById(2131309619));
      this.userTV = ((TextView)paramView.findViewById(2131298566));
      this.stateIV = ((ImageView)paramView.findViewById(2131298554));
      this.PIn = ((ImageView)paramView.findViewById(2131298556));
    }
  }
  
  public final View getMainContainerView()
  {
    return this.PKh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.e
 * JD-Core Version:    0.7.0.1
 */