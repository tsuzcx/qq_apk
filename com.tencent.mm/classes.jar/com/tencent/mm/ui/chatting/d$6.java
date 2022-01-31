package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.d.a;

final class d$6
  implements ap.a
{
  d$6(d paramd, boolean paramBoolean) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(30410);
    if (!this.zwJ)
    {
      ab.i("MicroMsg.AutoPlay", "speaker off");
      this.zwH.mtV = false;
      d locald = this.zwH;
      if (locald.mtU.isPlaying())
      {
        ab.d("MicroMsg.AutoPlay", "deal sensor event, play next");
        locald.mtU.bv(false);
        locald.qR(false);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30410);
      return false;
      ab.i("MicroMsg.AutoPlay", "speaker true");
      this.zwH.dFO();
      if (this.zwH.context != null) {
        this.zwH.zww = t.a(this.zwH.caz.zJz.getActivity(), this.zwH.context.getString(2131300091), 2000L);
      }
      this.zwH.mtV = true;
      this.zwH.dFM();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.6
 * JD-Core Version:    0.7.0.1
 */