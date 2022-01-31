package com.tencent.mm.ui.chatting.c;

import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.d;
import com.tencent.mm.aj.a.d.a;
import com.tencent.mm.aj.a.d.a.a;
import com.tencent.mm.aj.a.d.a.b;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.a.k;
import com.tencent.mm.aj.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.d.a;

final class c$9
  implements d.a
{
  c$9(c paramc) {}
  
  public final void a(d.a.b paramb)
  {
    AppMethodBeat.i(31200);
    if ((this.zEm.muT) && (paramb != null) && (paramb.fxq == this.zEm.dHI()))
    {
      if (!this.zEm.caz.bSe)
      {
        ab.i("MicroMsg.ChattingUI.BizComponent", "onNotifyChange fragment not foreground, return");
        AppMethodBeat.o(31200);
        return;
      }
      if (paramb.fxA != d.a.a.fxx)
      {
        ab.i("MicroMsg.ChattingUI.BizComponent", "bizChatExtension bizChat change");
        paramb = z.afk().aG(this.zEm.dHI());
        this.zEm.zsO = paramb;
        if (!this.zEm.zEd)
        {
          paramb = z.afm().df(this.zEm.zsO.field_bizChatServId);
          if (paramb != null) {
            this.zEm.pzG = paramb;
          }
        }
        for (;;)
        {
          ((r)this.zEm.caz.ay(r.class)).dIv();
          AppMethodBeat.o(31200);
          return;
          c.a(this.zEm, e.c(this.zEm.zsO));
          ((r)this.zEm.caz.ay(r.class)).dIy();
        }
      }
      if (this.zEm.zEd)
      {
        Toast.makeText(ah.getContext(), this.zEm.caz.zJz.getMMResources().getString(2131302701), 1).show();
        this.zEm.caz.zJz.dGb();
      }
    }
    AppMethodBeat.o(31200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c.9
 * JD-Core Version:    0.7.0.1
 */