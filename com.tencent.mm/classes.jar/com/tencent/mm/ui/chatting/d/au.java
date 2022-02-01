package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.luckymoney.a.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public class au
  extends a
  implements ag
{
  public final void hGW()
  {
    AppMethodBeat.i(163320);
    if (ab.Qg(this.fgR.getTalkerUserName()))
    {
      String str = this.fgR.WQv.getContext().getIntent().getStringExtra("key_red_packet_preview_url");
      ((com.tencent.mm.plugin.wxpay.a.a)h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).doRedPacketPreviewLoading(this.fgR.WQv.getContext(), str);
      d.bRC();
    }
    AppMethodBeat.o(163320);
  }
  
  public final void hHa()
  {
    AppMethodBeat.i(163322);
    super.hHa();
    d.Bv(3);
    d.resetSession();
    AppMethodBeat.o(163322);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(163321);
    super.hNZ();
    ((com.tencent.mm.plugin.wxpay.a.a)h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).onExitRedPacketPreviewChatting();
    d.Bv(3);
    d.resetSession();
    AppMethodBeat.o(163321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.au
 * JD-Core Version:    0.7.0.1
 */