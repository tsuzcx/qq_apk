package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.d.a;

final class p$7
  implements ap.a
{
  p$7(p paramp) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(30630);
    long l = p.a(this.zyT).EN();
    ab.d("MicroMsg.ChattingFooterEventImpl", "ms ".concat(String.valueOf(l)));
    int i;
    if ((l >= 50000L) && (l <= 60000L))
    {
      if (!p.f(this.zyT))
      {
        bo.hf(p.e(this.zyT).zJz.getContext());
        p.g(this.zyT);
      }
      i = (int)((60000L - l) / 1000L);
      if (!p.d(this.zyT).getTransVoiceOpener()) {
        break label177;
      }
      p.d(this.zyT).setVoice2txtCountDown(i);
    }
    while (l >= 60000L)
    {
      ab.v("MicroMsg.ChattingFooterEventImpl", "record stop on countdown");
      p.h(this.zyT);
      p.d(this.zyT).bxy();
      ay.ax(p.e(this.zyT).zJz.getContext(), 2131304298);
      AppMethodBeat.o(30630);
      return false;
      label177:
      p.d(this.zyT).setRecordNormalWording(p.e(this.zyT).zJz.getMMResources().getQuantityString(2131361794, i, new Object[] { Integer.valueOf(i) }));
    }
    AppMethodBeat.o(30630);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.p.7
 * JD-Core Version:    0.7.0.1
 */