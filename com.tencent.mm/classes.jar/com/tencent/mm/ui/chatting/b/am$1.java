package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.fo;
import com.tencent.mm.h.a.fo.a;
import com.tencent.mm.h.a.fo.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;

final class am$1
  implements Runnable
{
  am$1(am paramam, fo paramfo) {}
  
  public final void run()
  {
    if (this.rAq.bMA.aES)
    {
      if (bk.bl(this.rAq.bMA.content))
      {
        if (this.rAq.bMA.state == 2)
        {
          y.i("MicroMsg.TransformComponent", "go VoiceTransTextAct translateVoice fail msgId:%s", new Object[] { this.rAq.bMz.bMB });
          am.a(this.vtd, am.a(this.vtd).getString(R.l.chatting_transform_fail));
        }
        am.a(this.vtd, Long.valueOf(this.rAq.bMz.bMB).longValue());
        am.b(this.vtd, Long.valueOf(this.rAq.bMz.bMB).longValue());
        this.vtd.vta = false;
        am.b(this.vtd);
      }
      for (;;)
      {
        am.c(this.vtd);
        return;
        y.i("MicroMsg.TransformComponent", "go VoiceTransTextAct isCompleted msgId:%s", new Object[] { this.rAq.bMz.bMB });
        bi localbi = am.c(this.vtd, Long.valueOf(this.rAq.bMz.bMB).longValue());
        if (localbi != null)
        {
          this.vtd.a(Long.valueOf(this.rAq.bMz.bMB).longValue(), this.rAq.bMA.content, ChattingItemTranslate.b.vGd);
          localbi.cvH();
          au.Hx();
          c.Fy().a(localbi.field_msgId, localbi);
          am.b(this.vtd, Long.valueOf(this.rAq.bMz.bMB).longValue());
          am.b(this.vtd);
        }
        this.vtd.vta = false;
      }
    }
    if (!bk.bl(this.rAq.bMA.content))
    {
      this.vtd.a(Long.valueOf(this.rAq.bMz.bMB).longValue(), this.rAq.bMA.content, ChattingItemTranslate.b.vGc);
      y.i("MicroMsg.TransformComponent", "go VoiceTransTextAct refresh msgId:%s", new Object[] { this.rAq.bMz.bMB });
    }
    am.b(this.vtd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.am.1
 * JD-Core Version:    0.7.0.1
 */