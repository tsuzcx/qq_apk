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
import com.tencent.mm.ui.am;

final class aj$e
  extends c.a
{
  ImageView Ijf;
  RTChattingEmojiView Ilb;
  ImageView Ilc;
  ViewStub Iog;
  View Ioh;
  ImageView Ioi;
  
  public final c.a z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37294);
    super.fX(paramView);
    this.fAz = ((TextView)paramView.findViewById(2131298178));
    this.Ilb = ((RTChattingEmojiView)paramView.findViewById(2131298074));
    this.ijt = ((CheckBox)paramView.findViewById(2131298068));
    this.gGk = paramView.findViewById(2131298147);
    this.Ioh = paramView.findViewById(2131298083);
    this.Ioi = ((ImageView)paramView.findViewById(2131298084));
    this.Ioi.setImageDrawable(am.k(paramView.getContext(), 2131690116, -1));
    if (paramBoolean) {
      this.xpH = ((TextView)paramView.findViewById(2131298185));
    }
    for (;;)
    {
      if (this.Ilc != null) {
        ((ViewGroup)this.Ilc.getParent()).setBackgroundDrawable(null);
      }
      this.Iog = ((ViewStub)paramView.findViewById(2131298162));
      AppMethodBeat.o(37294);
      return this;
      this.vYf = ((ProgressBar)paramView.findViewById(2131306220));
      this.xpH = ((TextView)paramView.findViewById(2131298185));
      this.IhW = ((ImageView)paramView.findViewById(2131298174));
      this.Ijf = ((ImageView)paramView.findViewById(2131298176));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj.e
 * JD-Core Version:    0.7.0.1
 */