package com.tencent.mm.ui.chatting.d;

import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.d.a;
import com.tencent.mm.al.a.d.a.a;
import com.tencent.mm.al.a.d.a.b;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.ag;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.e.a;

final class c$11
  implements d.a
{
  c$11(c paramc) {}
  
  public final void a(d.a.b paramb)
  {
    AppMethodBeat.i(35092);
    if ((this.PmV.tca) && (paramb != null) && (paramb.iPE == this.PmV.gPc()))
    {
      if (!this.PmV.dom.cQp)
      {
        Log.i("MicroMsg.ChattingUI.BizComponent", "onNotifyChange fragment not foreground, return");
        AppMethodBeat.o(35092);
        return;
      }
      if (paramb.iPO != d.a.a.iPL)
      {
        Log.i("MicroMsg.ChattingUI.BizComponent", "bizChatExtension bizChat change");
        paramb = ag.baj().bs(this.PmV.gPc());
        this.PmV.Pag = paramb;
        if (!this.PmV.PmM)
        {
          paramb = ag.bal().fB(this.PmV.Pag.field_bizChatServId);
          if (paramb != null) {
            this.PmV.BeV = paramb;
          }
        }
        for (;;)
        {
          ((aa)this.PmV.dom.bh(aa.class)).gPx();
          AppMethodBeat.o(35092);
          return;
          c.a(this.PmV, e.c(this.PmV.Pag));
          ((aa)this.PmV.dom.bh(aa.class)).gQp();
        }
      }
      if (this.PmV.PmM)
      {
        Toast.makeText(MMApplicationContext.getContext(), this.PmV.dom.Pwc.getMMResources().getString(2131764694), 1).show();
        this.PmV.dom.Pwc.gNh();
      }
    }
    AppMethodBeat.o(35092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.c.11
 * JD-Core Version:    0.7.0.1
 */