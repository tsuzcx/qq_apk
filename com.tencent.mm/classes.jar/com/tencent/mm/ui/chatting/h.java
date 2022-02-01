package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class h
{
  private ChatFooterCustom HMn;
  private FrameLayout HMo;
  private View.OnClickListener iu;
  private LinearLayout plH;
  
  public h(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(34385);
    this.iu = new h.1(this);
    this.HMn = paramChatFooterCustom;
    AppMethodBeat.o(34385);
  }
  
  public final void fiu()
  {
    AppMethodBeat.i(34386);
    ac.i("MicroMsg.ChattingDownloaderFooterHandler", "initFooter");
    this.HMn.setVisibility(8);
    this.HMn.findViewById(2131298098).setVisibility(8);
    this.HMn.findViewById(2131298092).setVisibility(8);
    this.plH = ((LinearLayout)this.HMn.findViewById(2131298093));
    this.plH.setWeightSum(1.0F);
    this.HMo = ((FrameLayout)this.plH.getChildAt(0));
    this.HMo.setVisibility(0);
    this.HMo.setOnClickListener(this.iu);
    ((TextView)this.HMo.findViewById(2131298095)).setText(2131758142);
    this.HMo.findViewById(2131298094).setVisibility(8);
    int i = 1;
    while (i < 6)
    {
      this.plH.getChildAt(i).setVisibility(8);
      i += 1;
    }
    AppMethodBeat.o(34386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h
 * JD-Core Version:    0.7.0.1
 */