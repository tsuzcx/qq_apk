package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.luckymoney.a.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public class bb
  extends a
  implements aj
{
  public final void jjh()
  {
    AppMethodBeat.i(163320);
    if (ab.IN(this.hlc.getTalkerUserName()))
    {
      String str = this.hlc.aezO.getContext().getIntent().getStringExtra("key_red_packet_preview_url");
      ((com.tencent.mm.plugin.wxpay.a.a)h.az(com.tencent.mm.plugin.wxpay.a.a.class)).doRedPacketPreviewLoading(this.hlc.aezO.getContext(), str);
      d.dpe();
    }
    AppMethodBeat.o(163320);
  }
  
  public final void jjl()
  {
    AppMethodBeat.i(163322);
    super.jjl();
    d.BI(3);
    d.aqI();
    AppMethodBeat.o(163322);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(163321);
    super.jqF();
    ((com.tencent.mm.plugin.wxpay.a.a)h.az(com.tencent.mm.plugin.wxpay.a.a.class)).onExitRedPacketPreviewChatting();
    d.BI(3);
    d.aqI();
    AppMethodBeat.o(163321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bb
 * JD-Core Version:    0.7.0.1
 */