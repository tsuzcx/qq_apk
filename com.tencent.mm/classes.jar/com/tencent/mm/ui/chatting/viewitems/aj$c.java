package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a.b;
import com.tencent.mm.emoji.a.a.z;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.dh.b;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.chatting.c.b.q;

public final class aj$c
  implements View.OnClickListener
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
  public aj$c(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.HNS = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37290);
    ac.i("MicroMsg.EmojiCaptureTipsClickListener", "onClick: ");
    g.agR().agA().set(ah.a.GRy, Long.valueOf(System.currentTimeMillis()));
    EmojiCaptureReporter.ceB();
    paramView = new dh();
    paramView.dcK.type = 2;
    com.tencent.mm.sdk.b.a.GpY.l(paramView);
    com.tencent.mm.sdk.b.a.GpY.l(new qd());
    if (!paramView.dcL.dcM)
    {
      com.tencent.mm.cb.a.eSf();
      paramView = com.tencent.mm.cb.a.Gju;
      a.b.aJX("capture");
      ((q)this.HNS.bf(q.class)).fne().setDefaultSmileyByDetail(z.acU());
    }
    ((q)this.HNS.bf(q.class)).fne().eOr();
    this.HNS.flA();
    AppMethodBeat.o(37290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj.c
 * JD-Core Version:    0.7.0.1
 */