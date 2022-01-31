package com.tencent.mm.ui.chatting.viewitems;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class am$b$2
  implements n.d
{
  am$b$2(am.b paramb, am.f paramf, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(33305);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33305);
      return;
      ((ClipboardManager)ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(am.b.a(this.zXd), am.b.a(this.zXd)));
      if (this.zWZ.zXj != null)
      {
        this.zWZ.zXj.dPQ();
        this.zWZ.zXj.ANj = true;
        this.zWZ.zXj.ANk = true;
        this.zWZ.zXj.dPP();
      }
      Toast.makeText(this.val$context, 2131296896, 0).show();
      AppMethodBeat.o(33305);
      return;
      if (this.zWZ.zXj != null)
      {
        this.zWZ.zXj.ANj = true;
        this.zWZ.zXj.dPP();
        this.zWZ.zXj.hZ(0, this.zWZ.zXe.dTB().length());
        this.zWZ.zXj.dPS();
        this.zWZ.zXj.dPV();
        AppMethodBeat.o(33305);
        return;
        paramMenuItem = new Intent(this.val$context, MsgRetransmitUI.class);
        paramMenuItem.putExtra("Retr_Msg_content", am.b.a(this.zXd));
        paramMenuItem.putExtra("Retr_Msg_Type", 4);
        this.val$context.startActivity(paramMenuItem);
        AppMethodBeat.o(33305);
        return;
        paramMenuItem = new cm();
        e.b(paramMenuItem, am.b.a(this.zXd).toString(), 1);
        paramMenuItem.cpR.fragment = am.b.b(this.zXd).zJz;
        paramMenuItem.cpR.cpY = 43;
        if (paramMenuItem.cpR.cpT != null)
        {
          acw localacw = paramMenuItem.cpR.cpT.wVa;
          if (localacw != null)
          {
            az localaz = (az)this.zWZ.zXe.getTag();
            if (localaz != null)
            {
              localacw.aon(r.Zn());
              localacw.aoo(localaz.cEE.field_talker);
              com.tencent.mm.sdk.b.a.ymk.l(paramMenuItem);
            }
          }
        }
        if (this.zWZ.zXj != null)
        {
          this.zWZ.zXj.dPQ();
          this.zWZ.zXj.ANj = true;
          this.zWZ.zXj.ANk = true;
          this.zWZ.zXj.dPP();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.b.2
 * JD-Core Version:    0.7.0.1
 */