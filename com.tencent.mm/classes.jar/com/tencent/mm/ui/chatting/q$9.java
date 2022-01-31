package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import com.tencent.mm.R.j;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.j;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.c.a;

final class q$9
  implements am.a
{
  q$9(q paramq) {}
  
  public final boolean tC()
  {
    long l = q.a(this.vjS).uy();
    y.d("MicroMsg.ChattingFooterEventImpl", "ms " + l);
    if ((l >= 50000L) && (l <= 60000L))
    {
      if (!q.k(this.vjS))
      {
        bk.fO(q.e(this.vjS).vtz.getContext());
        q.a(this.vjS, true);
      }
      int i = (int)((60000L - l) / 1000L);
      q.d(this.vjS).setRecordNormalWording(q.e(this.vjS).vtz.getMMResources().getQuantityString(R.j.chatting_rcd_time_limit, i, new Object[] { Integer.valueOf(i) }));
    }
    if (l >= 60000L)
    {
      y.v("MicroMsg.ChattingFooterEventImpl", "record stop on countdown");
      q.l(this.vjS);
      q.d(this.vjS).aRj();
      au.G(q.e(this.vjS).vtz.getContext(), R.l.time_limit);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q.9
 * JD-Core Version:    0.7.0.1
 */