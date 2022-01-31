package com.tencent.mm.ui.chatting;

import android.widget.ListView;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.b.aa;
import com.tencent.mm.ui.chatting.b.b.ai;
import com.tencent.mm.ui.chatting.c.a;

final class q$6
  implements Runnable
{
  q$6(q paramq) {}
  
  public final void run()
  {
    synchronized (q.f(this.vjS))
    {
      if (q.g(this.vjS))
      {
        y.i("MicroMsg.ChattingFooterEventImpl", "jacks already stop before begin!!");
        return;
      }
      q.h(this.vjS);
      q.b(this.vjS).S(100L, 100L);
      q.a(this.vjS, false);
      q.c(this.vjS).S(200L, 200L);
      q.d(this.vjS).Ej(q.e(this.vjS).getListView().getHeight());
      ??? = ((ai)q.e(this.vjS).ac(ai.class)).cFx();
      ((d)???).isRecording = true;
      ((d)???).cCb();
      ((d)???).cBW();
      q.i(this.vjS);
      this.vjS.uPh.setKeepScreenOn(true);
      ((aa)q.e(this.vjS).ac(aa.class)).Hf(3);
      ((aa)q.e(this.vjS).ac(aa.class)).keepSignalling();
      q.cCN();
      ((ai)q.e(this.vjS).ac(ai.class)).a(q.e(this.vjS).vtz, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q.6
 * JD-Core Version:    0.7.0.1
 */