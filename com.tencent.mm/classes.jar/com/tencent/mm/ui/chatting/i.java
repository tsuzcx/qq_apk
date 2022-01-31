package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.y;

public final class i
{
  private LinearLayout jiW;
  private View.OnClickListener nuB = new i.1(this);
  private ChatFooterCustom viW;
  private FrameLayout viX;
  
  public i(ChatFooterCustom paramChatFooterCustom)
  {
    this.viW = paramChatFooterCustom;
  }
  
  public final void cAN()
  {
    y.i("MicroMsg.ChattingDownloaderFooterHandler", "initFooter");
    this.viW.setVisibility(8);
    this.viW.findViewById(R.h.chatting_footer_switch2input).setVisibility(8);
    this.viW.findViewById(R.h.chatting_footer_menu_arrow).setVisibility(8);
    this.jiW = ((LinearLayout)this.viW.findViewById(R.h.chatting_footer_menu_container));
    this.jiW.setWeightSum(1.0F);
    this.viX = ((FrameLayout)this.jiW.getChildAt(0));
    this.viX.setVisibility(0);
    this.viX.setOnClickListener(this.nuB);
    ((TextView)this.viX.getChildAt(0).findViewById(R.h.chatting_footer_menu_text)).setText(R.l.downloaderapp_manager);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i
 * JD-Core Version:    0.7.0.1
 */