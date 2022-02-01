package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.luckymoney.a.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public class am
  extends a
  implements ab
{
  public final void eQC()
  {
    AppMethodBeat.i(163320);
    if (w.sz(this.cOd.getTalkerUserName()))
    {
      String str = this.cOd.GzJ.getContext().getIntent().getStringExtra("key_red_packet_preview_url");
      ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).doRedPacketPreviewLoading(this.cOd.GzJ.getContext(), str);
      d.aZs();
    }
    AppMethodBeat.o(163320);
  }
  
  public final void eQG()
  {
    AppMethodBeat.i(163322);
    super.eQG();
    d.sw(3);
    d.resetSession();
    AppMethodBeat.o(163322);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(163321);
    super.eWx();
    ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).onExitRedPacketPreviewChatting();
    d.sw(3);
    d.resetSession();
    AppMethodBeat.o(163321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.am
 * JD-Core Version:    0.7.0.1
 */