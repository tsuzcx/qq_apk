package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fr;
import com.tencent.mm.g.a.fr.a;
import com.tencent.mm.g.a.fr.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;

final class ao$1
  implements Runnable
{
  ao$1(ao paramao, fr paramfr, int paramInt, bi parambi) {}
  
  public final void run()
  {
    AppMethodBeat.i(31783);
    if (!this.zIW.oG(Long.valueOf(this.vrt.ctT.ctV).longValue()))
    {
      AppMethodBeat.o(31783);
      return;
    }
    if (this.vrt.ctU.aLC)
    {
      if (bo.isNullOrNil(this.vrt.ctU.content))
      {
        if (this.vrt.ctU.state == 2)
        {
          ab.i("MicroMsg.TransformComponent", "go VoiceTransTextAct translateVoice fail msgId:%s", new Object[] { this.vrt.ctT.ctV });
          ao.a(this.zIW, ao.a(this.zIW).getString(2131298330));
        }
        ao.a(this.zIW, Long.valueOf(this.vrt.ctT.ctV).longValue());
        ao.b(this.zIW, Long.valueOf(this.vrt.ctT.ctV).longValue());
        this.zIW.zIR = false;
        ao.b(this.zIW);
      }
      for (;;)
      {
        ao.a(this.zIW, this.fkQ, this.gxr);
        AppMethodBeat.o(31783);
        return;
        ab.i("MicroMsg.TransformComponent", "go VoiceTransTextAct isCompleted msgId:%s", new Object[] { this.vrt.ctT.ctV });
        bi localbi = ao.c(this.zIW, Long.valueOf(this.vrt.ctT.ctV).longValue());
        if (localbi != null)
        {
          this.zIW.a(Long.valueOf(this.vrt.ctT.ctV).longValue(), this.vrt.ctU.content, ChattingItemTranslate.b.zXx);
          localbi.dyp();
          aw.aaz();
          c.YC().a(localbi.field_msgId, localbi);
          ao.b(this.zIW, Long.valueOf(this.vrt.ctT.ctV).longValue());
          ao.b(this.zIW);
          ao.a(this.zIW, this.gxr);
        }
        this.zIW.zIR = false;
      }
    }
    if (!bo.isNullOrNil(this.vrt.ctU.content))
    {
      this.zIW.a(Long.valueOf(this.vrt.ctT.ctV).longValue(), this.vrt.ctU.content, ChattingItemTranslate.b.zXw);
      ab.i("MicroMsg.TransformComponent", "go VoiceTransTextAct refresh msgId:%s", new Object[] { this.vrt.ctT.ctV });
    }
    ao.b(this.zIW);
    ao.a(this.zIW, this.gxr);
    AppMethodBeat.o(31783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ao.1
 * JD-Core Version:    0.7.0.1
 */