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
import com.tencent.mm.ui.ao;

final class ak$e
  extends c.a
{
  ImageView JZD;
  ImageView KbA;
  RTChattingEmojiView Kbz;
  ViewStub KeG;
  View KeH;
  ImageView KeI;
  
  public final c.a z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37294);
    super.gn(paramView);
    this.fTP = ((TextView)paramView.findViewById(2131298178));
    this.Kbz = ((RTChattingEmojiView)paramView.findViewById(2131298074));
    this.iCK = ((CheckBox)paramView.findViewById(2131298068));
    this.gZU = paramView.findViewById(2131298147);
    this.KeH = paramView.findViewById(2131298083);
    this.KeI = ((ImageView)paramView.findViewById(2131298084));
    this.KeI.setImageDrawable(ao.k(paramView.getContext(), 2131690116, -1));
    if (paramBoolean) {
      this.yEk = ((TextView)paramView.findViewById(2131298185));
    }
    for (;;)
    {
      if (this.KbA != null) {
        ((ViewGroup)this.KbA.getParent()).setBackgroundDrawable(null);
      }
      this.KeG = ((ViewStub)paramView.findViewById(2131298162));
      AppMethodBeat.o(37294);
      return this;
      this.xfR = ((ProgressBar)paramView.findViewById(2131306220));
      this.yEk = ((TextView)paramView.findViewById(2131298185));
      this.JYs = ((ImageView)paramView.findViewById(2131298174));
      this.JZD = ((ImageView)paramView.findViewById(2131298176));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.e
 * JD-Core Version:    0.7.0.1
 */