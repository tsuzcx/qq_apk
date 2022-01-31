package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class h
{
  private LinearLayout lrN;
  private View.OnClickListener qaq;
  private ChatFooterCustom zxW;
  private FrameLayout zxX;
  
  public h(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(30527);
    this.qaq = new h.1(this);
    this.zxW = paramChatFooterCustom;
    AppMethodBeat.o(30527);
  }
  
  public final void dDW()
  {
    AppMethodBeat.i(30528);
    ab.i("MicroMsg.ChattingDownloaderFooterHandler", "initFooter");
    this.zxW.setVisibility(8);
    this.zxW.findViewById(2131822498).setVisibility(8);
    this.zxW.findViewById(2131822501).setVisibility(8);
    this.lrN = ((LinearLayout)this.zxW.findViewById(2131822500));
    this.lrN.setWeightSum(1.0F);
    this.zxX = ((FrameLayout)this.lrN.getChildAt(0));
    this.zxX.setVisibility(0);
    this.zxX.setOnClickListener(this.qaq);
    ((TextView)this.zxX.findViewById(2131822496)).setText(2131299039);
    this.zxX.findViewById(2131822495).setVisibility(8);
    this.zxX.getChildAt(2).setVisibility(8);
    int i = 1;
    while (i < 6)
    {
      this.lrN.getChildAt(i).setVisibility(8);
      i += 1;
    }
    AppMethodBeat.o(30528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h
 * JD-Core Version:    0.7.0.1
 */