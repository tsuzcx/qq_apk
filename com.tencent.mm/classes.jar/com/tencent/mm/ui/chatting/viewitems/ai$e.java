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

final class ai$e
  extends c.a
{
  ImageView GJi;
  RTChattingEmojiView GLe;
  ImageView GLf;
  ViewStub GOe;
  View GOf;
  ImageView GOg;
  ProgressBar uPp;
  
  public final c.a z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37294);
    super.fK(paramView);
    this.fwS = ((TextView)paramView.findViewById(2131298178));
    this.GLe = ((RTChattingEmojiView)paramView.findViewById(2131298074));
    this.hIS = ((CheckBox)paramView.findViewById(2131298068));
    this.lRB = paramView.findViewById(2131298147);
    this.GOf = paramView.findViewById(2131298083);
    this.GOg = ((ImageView)paramView.findViewById(2131298084));
    this.GOg.setImageDrawable(am.i(paramView.getContext(), 2131690116, -1));
    if (paramBoolean) {
      this.wet = ((TextView)paramView.findViewById(2131298185));
    }
    for (;;)
    {
      if (this.GLf != null) {
        ((ViewGroup)this.GLf.getParent()).setBackgroundDrawable(null);
      }
      this.GOe = ((ViewStub)paramView.findViewById(2131298162));
      AppMethodBeat.o(37294);
      return this;
      this.uPp = ((ProgressBar)paramView.findViewById(2131306220));
      this.wet = ((TextView)paramView.findViewById(2131298185));
      this.GHZ = ((ImageView)paramView.findViewById(2131298174));
      this.GJi = ((ImageView)paramView.findViewById(2131298176));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ai.e
 * JD-Core Version:    0.7.0.1
 */