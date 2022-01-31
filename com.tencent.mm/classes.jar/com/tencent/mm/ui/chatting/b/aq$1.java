package com.tencent.mm.ui.chatting.b;

import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.model.al;
import com.tencent.mm.model.am.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

final class aq$1
  implements am.d
{
  aq$1(aq paramaq) {}
  
  public final void n(String paramString, long paramLong)
  {
    y.d("MicroMsg.ChattingUI.VoiceComponent", "onVoiceRemind " + paramString + " time " + paramLong);
    if (s.hI(au.getNotification().wo())) {
      h.a(this.vts.byx.vtz.getContext(), false, paramString, this.vts.byx.vtz.getMMResources().getString(R.l.voice_reminder_dialog_title), this.vts.byx.vtz.getMMResources().getString(R.l.voice_reminder_dialog_check), this.vts.byx.vtz.getMMResources().getString(R.l.voice_reminder_dialog_ignore), new aq.1.1(this, paramLong), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.aq.1
 * JD-Core Version:    0.7.0.1
 */