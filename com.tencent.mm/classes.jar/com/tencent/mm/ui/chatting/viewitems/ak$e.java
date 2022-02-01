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
  ViewStub KAZ;
  View KBa;
  ImageView KBb;
  ImageView KvW;
  RTChattingEmojiView KxR;
  ImageView KxS;
  
  public final c.a E(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37294);
    super.gs(paramView);
    this.fVV = ((TextView)paramView.findViewById(2131298178));
    this.KxR = ((RTChattingEmojiView)paramView.findViewById(2131298074));
    this.iFD = ((CheckBox)paramView.findViewById(2131298068));
    this.hcH = paramView.findViewById(2131298147);
    this.KBa = paramView.findViewById(2131298083);
    this.KBb = ((ImageView)paramView.findViewById(2131298084));
    this.KBb.setImageDrawable(ao.k(paramView.getContext(), 2131690116, -1));
    if (paramBoolean) {
      this.yUp = ((TextView)paramView.findViewById(2131298185));
    }
    for (;;)
    {
      if (this.KxS != null) {
        ((ViewGroup)this.KxS.getParent()).setBackgroundDrawable(null);
      }
      this.KAZ = ((ViewStub)paramView.findViewById(2131298162));
      AppMethodBeat.o(37294);
      return this;
      this.xvJ = ((ProgressBar)paramView.findViewById(2131306220));
      this.yUp = ((TextView)paramView.findViewById(2131298185));
      this.KuL = ((ImageView)paramView.findViewById(2131298174));
      this.KvW = ((ImageView)paramView.findViewById(2131298176));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.e
 * JD-Core Version:    0.7.0.1
 */