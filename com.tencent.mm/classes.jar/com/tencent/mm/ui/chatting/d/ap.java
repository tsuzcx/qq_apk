package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.luckymoney.a.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public class ap
  extends a
  implements ad
{
  public final void fCC()
  {
    AppMethodBeat.i(163321);
    super.fCC();
    ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).onExitRedPacketPreviewChatting();
    d.tQ(3);
    d.resetSession();
    AppMethodBeat.o(163321);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(163320);
    if (w.zy(this.cWM.getTalkerUserName()))
    {
      String str = this.cWM.JOR.getContext().getIntent().getStringExtra("key_red_packet_preview_url");
      ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).doRedPacketPreviewLoading(this.cWM.JOR.getContext(), str);
      d.bjO();
    }
    AppMethodBeat.o(163320);
  }
  
  public final void fwy()
  {
    AppMethodBeat.i(163322);
    super.fwy();
    d.tQ(3);
    d.resetSession();
    AppMethodBeat.o(163322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ap
 * JD-Core Version:    0.7.0.1
 */