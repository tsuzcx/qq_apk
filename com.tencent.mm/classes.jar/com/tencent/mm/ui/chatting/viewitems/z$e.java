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
import com.tencent.mm.ui.aj;

final class z$e
  extends c.a
{
  ProgressBar pNd;
  ImageView zSm;
  RTChattingEmojiView zTS;
  ImageView zTT;
  ViewStub zVN;
  View zVO;
  ImageView zVP;
  
  public final c.a A(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(33202);
    super.eV(paramView);
    this.ekh = ((TextView)paramView.findViewById(2131820587));
    this.zTS = ((RTChattingEmojiView)paramView.findViewById(2131822642));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    this.zVO = paramView.findViewById(2131822666);
    this.zVP = ((ImageView)paramView.findViewById(2131822667));
    this.zVP.setImageDrawable(aj.g(paramView.getContext(), 2131231272, -1));
    if (paramBoolean) {
      this.qFY = ((TextView)paramView.findViewById(2131821122));
    }
    for (;;)
    {
      if (this.zTT != null) {
        ((ViewGroup)this.zTT.getParent()).setBackgroundDrawable(null);
      }
      this.zVN = ((ViewStub)paramView.findViewById(2131822733));
      AppMethodBeat.o(33202);
      return this;
      this.pNd = ((ProgressBar)paramView.findViewById(2131822728));
      this.qFY = ((TextView)paramView.findViewById(2131821122));
      this.zRC = ((ImageView)paramView.findViewById(2131822695));
      this.zSm = ((ImageView)paramView.findViewById(2131822729));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z.e
 * JD-Core Version:    0.7.0.1
 */