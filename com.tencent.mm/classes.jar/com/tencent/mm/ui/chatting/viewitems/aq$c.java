package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ca.a.b;
import com.tencent.mm.emoji.b.b.ad;
import com.tencent.mm.g.a.do;
import com.tencent.mm.g.a.do.b;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.d.b.u;

public final class aq$c
  implements View.OnClickListener
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  
  public aq$c(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.PhN = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37290);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemEmoji$EmojiCaptureTipsClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.EmojiCaptureTipsClickListener", "onClick: ");
    g.aAh().azQ().set(ar.a.OgZ, Long.valueOf(System.currentTimeMillis()));
    EmojiCaptureReporter.cIw();
    paramView = new do();
    paramView.dGz.type = 2;
    EventCenter.instance.publish(paramView);
    EventCenter.instance.publish(new rj());
    if (!paramView.dGA.dGB)
    {
      com.tencent.mm.ca.a.gvc();
      paramView = com.tencent.mm.ca.a.NCN;
      a.b.bhD("capture");
      ((u)this.PhN.bh(u.class)).gPO().setDefaultSmileyByDetail(ad.avD());
    }
    ((u)this.PhN.bh(u.class)).gPO().gqo();
    paramView = this.PhN;
    Log.i("MicroMsg.ChattingContext", "[scrollToLast]");
    paramView.Pwd.gNX();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemEmoji$EmojiCaptureTipsClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.c
 * JD-Core Version:    0.7.0.1
 */