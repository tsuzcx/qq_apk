package com.tencent.mm.ui.chatting.b;

import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.a.d;
import com.tencent.mm.ai.a.d.a;
import com.tencent.mm.ai.a.d.a.a;
import com.tencent.mm.ai.a.d.a.b;
import com.tencent.mm.ai.a.k;
import com.tencent.mm.ai.z;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.chatting.c.a;

final class c$9
  implements d.a
{
  c$9(c paramc) {}
  
  public final void a(d.a.b paramb)
  {
    if ((this.voK.kax) && (paramb != null) && (paramb.ehm == this.voK.cDS()))
    {
      if (this.voK.byx.euf) {
        break label50;
      }
      y.i("MicroMsg.ChattingUI.BizComponent", "onNotifyChange fragment not foreground, return");
    }
    label50:
    do
    {
      return;
      if (paramb.ehw != d.a.a.eht)
      {
        y.i("MicroMsg.ChattingUI.BizComponent", "bizChatExtension bizChat change");
        paramb = z.MA().aj(this.voK.cDS());
        this.voK.veo = paramb;
        if (!this.voK.voC)
        {
          paramb = z.MC().bY(this.voK.veo.field_bizChatServId);
          if (paramb != null) {
            this.voK.mWL = paramb;
          }
        }
        for (;;)
        {
          ((q)this.voK.byx.ac(q.class)).cEE();
          return;
          c.a(this.voK, com.tencent.mm.ai.a.e.c(this.voK.veo));
          ((q)this.voK.byx.ac(q.class)).cEG();
        }
      }
    } while (!this.voK.voC);
    Toast.makeText(ae.getContext(), this.voK.byx.vtz.getMMResources().getString(R.l.room_delete_quit_tip), 1).show();
    this.voK.byx.vtz.cCo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.c.9
 * JD-Core Version:    0.7.0.1
 */