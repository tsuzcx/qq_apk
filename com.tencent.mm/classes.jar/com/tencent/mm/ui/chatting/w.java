package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class w
{
  private LinearLayout lrN;
  private View.OnClickListener qaq;
  private ChatFooterCustom zxW;
  private FrameLayout zxX;
  
  public w(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(30815);
    this.qaq = new w.1(this);
    this.zxW = paramChatFooterCustom;
    AppMethodBeat.o(30815);
  }
  
  public final void dDW()
  {
    AppMethodBeat.i(30816);
    ab.i("MicroMsg.Sport.ChattingSportFooterHandler", "initFooter");
    this.zxW.findViewById(2131822498).setVisibility(8);
    this.zxW.findViewById(2131822501).setVisibility(8);
    this.lrN = ((LinearLayout)this.zxW.findViewById(2131822500));
    this.lrN.setWeightSum(1.0F);
    this.zxX = ((FrameLayout)this.lrN.getChildAt(0));
    this.zxX.setVisibility(0);
    this.zxX.setOnClickListener(this.qaq);
    ((TextView)this.zxX.findViewById(2131822496)).setText(2131299477);
    this.zxX.findViewById(2131822495).setVisibility(8);
    this.zxX.getChildAt(2).setVisibility(8);
    int i = 1;
    while (i < 6)
    {
      this.lrN.getChildAt(i).setVisibility(8);
      i += 1;
    }
    AppMethodBeat.o(30816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.w
 * JD-Core Version:    0.7.0.1
 */