package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.h;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.x;

final class d$6
  implements am.a
{
  d$6(d paramd, boolean paramBoolean) {}
  
  public final boolean tC()
  {
    if (!this.vhP)
    {
      y.i("MicroMsg.AutoPlay", "speaker off");
      this.vhN.iak = false;
      d locald = this.vhN;
      if (locald.jZC.isPlaying())
      {
        y.d("MicroMsg.AutoPlay", "deal sensor event, play next");
        locald.jZC.ua();
        locald.ni(false);
      }
      return false;
    }
    y.i("MicroMsg.AutoPlay", "speaker true");
    this.vhN.cCc();
    if (this.vhN.context != null) {
      this.vhN.vhC = s.a(this.vhN.byx.vtz.getActivity(), this.vhN.context.getString(R.l.fmt_route_speaker), 2000L);
    }
    this.vhN.iak = true;
    this.vhN.cCa();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.6
 * JD-Core Version:    0.7.0.1
 */