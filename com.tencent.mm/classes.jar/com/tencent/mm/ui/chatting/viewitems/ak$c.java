package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ca.a.b;
import com.tencent.mm.emoji.a.b.ad;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.g.a.dl.b;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.chatting.d.b.s;

public final class ak$c
  implements View.OnClickListener
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  
  public ak$c(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.JWz = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37290);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemEmoji$EmojiCaptureTipsClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.EmojiCaptureTipsClickListener", "onClick: ");
    g.ajR().ajA().set(am.a.IYC, Long.valueOf(System.currentTimeMillis()));
    EmojiCaptureReporter.cku();
    paramView = new dl();
    paramView.dpl.type = 2;
    com.tencent.mm.sdk.b.a.IvT.l(paramView);
    com.tencent.mm.sdk.b.a.IvT.l(new qp());
    if (!paramView.dpm.dpn)
    {
      com.tencent.mm.ca.a.flq();
      paramView = com.tencent.mm.ca.a.Ipp;
      a.b.aRa("capture");
      ((s)this.JWz.bh(s.class)).fHF().setDefaultSmileyByDetail(ad.afP());
    }
    ((s)this.JWz.bh(s.class)).fHF().fhf();
    paramView = this.JWz;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingContext", "[scrollToLast]");
    paramView.Kke.fFS();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemEmoji$EmojiCaptureTipsClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.c
 * JD-Core Version:    0.7.0.1
 */