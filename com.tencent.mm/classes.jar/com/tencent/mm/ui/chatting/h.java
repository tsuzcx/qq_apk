package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
{
  private ChatFooterCustom JAd;
  private FrameLayout JAe;
  private View.OnClickListener km;
  private LinearLayout pPh;
  
  public h(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(34385);
    this.km = new h.1(this);
    this.JAd = paramChatFooterCustom;
    AppMethodBeat.o(34385);
  }
  
  public final void fyJ()
  {
    AppMethodBeat.i(34386);
    ad.i("MicroMsg.ChattingDownloaderFooterHandler", "initFooter");
    this.JAd.setVisibility(8);
    this.JAd.findViewById(2131298098).setVisibility(8);
    this.JAd.findViewById(2131298092).setVisibility(8);
    this.pPh = ((LinearLayout)this.JAd.findViewById(2131298093));
    this.pPh.setWeightSum(1.0F);
    this.JAe = ((FrameLayout)this.pPh.getChildAt(0));
    this.JAe.setVisibility(0);
    this.JAe.setOnClickListener(this.km);
    ((TextView)this.JAe.findViewById(2131298095)).setText(2131758142);
    this.JAe.findViewById(2131298094).setVisibility(8);
    int i = 1;
    while (i < 6)
    {
      this.pPh.getChildAt(i).setVisibility(8);
      i += 1;
    }
    AppMethodBeat.o(34386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h
 * JD-Core Version:    0.7.0.1
 */