package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j;
import com.tencent.mm.ai.j.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.a;

final class p$1
  implements j.a
{
  p$1(p paramp) {}
  
  public final void onError()
  {
    AppMethodBeat.i(30623);
    p.a(this.zyT).reset();
    p.b(this.zyT).stopTimer();
    p.c(this.zyT).stopTimer();
    com.tencent.mm.sdk.platformtools.aj.apl("keep_app_silent");
    p.d(this.zyT).bxy();
    ((com.tencent.mm.ui.chatting.c.b.aj)p.e(this.zyT).ay(com.tencent.mm.ui.chatting.c.b.aj.class)).dJv().dFJ();
    ab.v("MicroMsg.ChattingFooterEventImpl", "record stop on error");
    p.e(this.zyT).zJz.enableOptionMenu(true);
    p.e(this.zyT).zJz.enableBackMenu(true);
    Toast.makeText(p.e(this.zyT).zJz.getContext(), p.e(this.zyT).zJz.getContext().getString(2131298285), 0).show();
    AppMethodBeat.o(30623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.p.1
 * JD-Core Version:    0.7.0.1
 */