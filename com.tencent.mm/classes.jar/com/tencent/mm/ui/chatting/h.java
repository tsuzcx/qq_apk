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
  private ChatFooterCustom Gmx;
  private FrameLayout Gmy;
  private View.OnClickListener hs;
  private LinearLayout oIh;
  
  public h(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(34385);
    this.hs = new h.1(this);
    this.Gmx = paramChatFooterCustom;
    AppMethodBeat.o(34385);
  }
  
  public final void eSK()
  {
    AppMethodBeat.i(34386);
    ad.i("MicroMsg.ChattingDownloaderFooterHandler", "initFooter");
    this.Gmx.setVisibility(8);
    this.Gmx.findViewById(2131298098).setVisibility(8);
    this.Gmx.findViewById(2131298092).setVisibility(8);
    this.oIh = ((LinearLayout)this.Gmx.findViewById(2131298093));
    this.oIh.setWeightSum(1.0F);
    this.Gmy = ((FrameLayout)this.oIh.getChildAt(0));
    this.Gmy.setVisibility(0);
    this.Gmy.setOnClickListener(this.hs);
    ((TextView)this.Gmy.findViewById(2131298095)).setText(2131758142);
    this.Gmy.findViewById(2131298094).setVisibility(8);
    int i = 1;
    while (i < 6)
    {
      this.oIh.getChildAt(i).setVisibility(8);
      i += 1;
    }
    AppMethodBeat.o(34386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h
 * JD-Core Version:    0.7.0.1
 */