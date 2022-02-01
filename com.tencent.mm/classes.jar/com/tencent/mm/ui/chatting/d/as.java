package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.luckymoney.a.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public class as
  extends a
  implements af
{
  public final void gIm()
  {
    AppMethodBeat.i(163320);
    if (ab.IN(this.dom.getTalkerUserName()))
    {
      String str = this.dom.Pwc.getContext().getIntent().getStringExtra("key_red_packet_preview_url");
      ((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).doRedPacketPreviewLoading(this.dom.Pwc.getContext(), str);
      d.bFT();
    }
    AppMethodBeat.o(163320);
  }
  
  public final void gIo()
  {
    AppMethodBeat.i(163322);
    super.gIo();
    d.xV(3);
    d.resetSession();
    AppMethodBeat.o(163322);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(163321);
    super.gOK();
    ((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).onExitRedPacketPreviewChatting();
    d.xV(3);
    d.resetSession();
    AppMethodBeat.o(163321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.as
 * JD-Core Version:    0.7.0.1
 */