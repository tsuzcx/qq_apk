package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.luckymoney.a.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public class ap
  extends a
  implements ad
{
  public final void fAu()
  {
    AppMethodBeat.i(163320);
    if (x.Ai(this.cXJ.getTalkerUserName()))
    {
      String str = this.cXJ.Kkd.getContext().getIntent().getStringExtra("key_red_packet_preview_url");
      ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).doRedPacketPreviewLoading(this.cXJ.Kkd.getContext(), str);
      d.bkx();
    }
    AppMethodBeat.o(163320);
  }
  
  public final void fAy()
  {
    AppMethodBeat.i(163322);
    super.fAy();
    d.tW(3);
    d.resetSession();
    AppMethodBeat.o(163322);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(163321);
    super.fGE();
    ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).onExitRedPacketPreviewChatting();
    d.tW(3);
    d.resetSession();
    AppMethodBeat.o(163321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ap
 * JD-Core Version:    0.7.0.1
 */