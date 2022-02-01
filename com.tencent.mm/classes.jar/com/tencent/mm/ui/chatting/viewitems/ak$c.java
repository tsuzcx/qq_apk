package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a.b;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.g.a.dk.b;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.chatting.d.b.s;

public final class ak$c
  implements View.OnClickListener
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
  public ak$c(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.JBI = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37290);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemEmoji$EmojiCaptureTipsClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.EmojiCaptureTipsClickListener", "onClick: ");
    g.ajC().ajl().set(al.a.IEc, Long.valueOf(System.currentTimeMillis()));
    EmojiCaptureReporter.cje();
    paramView = new dk();
    paramView.dog.type = 2;
    com.tencent.mm.sdk.b.a.IbL.l(paramView);
    com.tencent.mm.sdk.b.a.IbL.l(new qo());
    if (!paramView.doh.doi)
    {
      com.tencent.mm.cb.a.fhy();
      paramView = com.tencent.mm.cb.a.HVh;
      a.b.aPD("capture");
      ((s)this.JBI.bh(s.class)).fDC().setDefaultSmileyByDetail(com.tencent.mm.emoji.a.a.ad.afB());
    }
    ((s)this.JBI.bh(s.class)).fDC().fdq();
    paramView = this.JBI;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingContext", "[scrollToLast]");
    paramView.JOS.fBQ();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemEmoji$EmojiCaptureTipsClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.c
 * JD-Core Version:    0.7.0.1
 */