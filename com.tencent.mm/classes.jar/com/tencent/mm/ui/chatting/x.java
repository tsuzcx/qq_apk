package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.y;

public final class x
{
  private LinearLayout jiW;
  private View.OnClickListener nuB = new x.1(this);
  private ChatFooterCustom viW;
  private FrameLayout viX;
  
  public x(ChatFooterCustom paramChatFooterCustom)
  {
    this.viW = paramChatFooterCustom;
  }
  
  public final void cAN()
  {
    y.i("MicroMsg.Sport.ChattingSportFooterHandler", "initFooter");
    this.viW.findViewById(R.h.chatting_footer_switch2input).setVisibility(8);
    this.viW.findViewById(R.h.chatting_footer_menu_arrow).setVisibility(8);
    this.jiW = ((LinearLayout)this.viW.findViewById(R.h.chatting_footer_menu_container));
    this.jiW.setWeightSum(1.0F);
    this.viX = ((FrameLayout)this.jiW.getChildAt(0));
    this.viX.setVisibility(0);
    this.viX.setOnClickListener(this.nuB);
    ((TextView)this.viX.getChildAt(0).findViewById(R.h.chatting_footer_menu_text)).setText(R.l.exdevice_sport_rank_title);
    this.viX.getChildAt(0).findViewById(R.h.chatting_footer_menu_icon).setVisibility(8);
    this.viX.getChildAt(1).setVisibility(8);
    int i = 1;
    while (i < 6)
    {
      this.jiW.getChildAt(i).setVisibility(8);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.x
 * JD-Core Version:    0.7.0.1
 */