package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ed;
import com.tencent.mm.autogen.a.ed.b;
import com.tencent.mm.autogen.a.ty;
import com.tencent.mm.cc.a.b;
import com.tencent.mm.emoji.c.b.af;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.component.api.x;

public final class as$c
  implements View.OnClickListener
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  public as$c(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.aeiK = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37290);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemEmoji$EmojiCaptureTipsClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.EmojiCaptureTipsClickListener", "onClick: ");
    h.baE().ban().set(at.a.acWY, Long.valueOf(System.currentTimeMillis()));
    EmojiCaptureReporter.dDw();
    paramView = new ed();
    paramView.hDT.type = 2;
    paramView.publish();
    new ty().publish();
    if (!paramView.hDU.hDV)
    {
      com.tencent.mm.cc.a.iRg();
      paramView = com.tencent.mm.cc.a.aclv;
      a.b.btU("capture");
      ((x)this.aeiK.cm(x.class)).jsd().setDefaultSmileyByDetail(af.aVv());
    }
    ((x)this.aeiK.cm(x.class)).jsd().iMe();
    paramView = this.aeiK;
    Log.i("MicroMsg.ChattingContext", "[scrollToLast]0");
    paramView.aezP.jpJ();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemEmoji$EmojiCaptureTipsClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.as.c
 * JD-Core Version:    0.7.0.1
 */