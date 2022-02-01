package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a.b;
import com.tencent.mm.emoji.b.b.af;
import com.tencent.mm.f.a.dt;
import com.tencent.mm.f.a.dt.b;
import com.tencent.mm.f.a.si;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.d.b.u;

public final class at$c
  implements View.OnClickListener
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
  public at$c(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.WBq = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37290);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemEmoji$EmojiCaptureTipsClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("MicroMsg.EmojiCaptureTipsClickListener", "onClick: ");
    h.aHG().aHp().set(ar.a.Vvp, Long.valueOf(System.currentTimeMillis()));
    EmojiCaptureReporter.cXf();
    paramView = new dt();
    paramView.fzk.type = 2;
    EventCenter.instance.publish(paramView);
    EventCenter.instance.publish(new si());
    if (!paramView.fzl.fzm)
    {
      com.tencent.mm.ch.a.hqW();
      paramView = com.tencent.mm.ch.a.UQl;
      a.b.btV("capture");
      ((u)this.WBq.bC(u.class)).hPj().setDefaultSmileyByDetail(af.aCy());
    }
    ((u)this.WBq.bC(u.class)).hPj().hln();
    paramView = this.WBq;
    Log.i("MicroMsg.ChattingContext", "[scrollToLast]");
    paramView.WQw.hNg();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemEmoji$EmojiCaptureTipsClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.at.c
 * JD-Core Version:    0.7.0.1
 */