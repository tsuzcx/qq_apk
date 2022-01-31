package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.j;
import com.tencent.mm.ah.j.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.b.ai;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.x;

final class q$1
  implements j.a
{
  q$1(q paramq) {}
  
  public final void onError()
  {
    q.a(this.vjS).reset();
    q.b(this.vjS).stopTimer();
    q.c(this.vjS).stopTimer();
    ag.Zn("keep_app_silent");
    q.d(this.vjS).aRj();
    ((ai)q.e(this.vjS).ac(ai.class)).cFx().cBX();
    y.v("MicroMsg.ChattingFooterEventImpl", "record stop on error");
    q.e(this.vjS).vtz.enableOptionMenu(true);
    q.e(this.vjS).vtz.enableBackMenu(true);
    Toast.makeText(q.e(this.vjS).vtz.getContext(), q.e(this.vjS).vtz.getContext().getString(R.l.chatting_rcd_err), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q.1
 * JD-Core Version:    0.7.0.1
 */