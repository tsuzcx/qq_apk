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
import com.tencent.mm.model.bh;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class am$a$3
  implements n.d
{
  am$a$3(am.a parama, am.f paramf, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(33289);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33289);
      return;
      ((ClipboardManager)ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(am.a.a(this.zXa), am.a.a(this.zXa)));
      if (this.zWZ.zXj != null)
      {
        this.zWZ.zXj.dPQ();
        this.zWZ.zXj.ANj = true;
        this.zWZ.zXj.ANk = true;
        this.zWZ.zXj.dPP();
      }
      Toast.makeText(this.val$context, 2131296896, 0).show();
      AppMethodBeat.o(33289);
      return;
      if (this.zWZ.zXj != null)
      {
        this.zWZ.zXj.ANj = true;
        this.zWZ.zXj.dPP();
        this.zWZ.zXj.hZ(0, this.zWZ.zXe.dTB().length());
        this.zWZ.zXj.dPS();
        this.zWZ.zXj.dPV();
        AppMethodBeat.o(33289);
        return;
        paramMenuItem = (az)this.zWZ.zXe.getTag();
        if (paramMenuItem != null)
        {
          paramMenuItem = bh.s(paramMenuItem.cEE);
          if (bo.isNullOrNil(paramMenuItem))
          {
            paramMenuItem = new Intent(this.val$context, MsgRetransmitUI.class);
            paramMenuItem.putExtra("Retr_Msg_content", am.a.a(this.zXa));
            paramMenuItem.putExtra("Retr_Msg_Type", 4);
            this.val$context.startActivity(paramMenuItem);
            AppMethodBeat.o(33289);
            return;
          }
          h.a(this.val$context, 2131303029, 2131303030, 2131297104, 2131298297, true, new am.a.3.1(this, paramMenuItem), new am.a.3.2(this, paramMenuItem));
          AppMethodBeat.o(33289);
          return;
          paramMenuItem = new cm();
          e.b(paramMenuItem, am.a.a(this.zXa).toString(), 1);
          paramMenuItem.cpR.fragment = am.a.b(this.zXa).zJz;
          paramMenuItem.cpR.cpY = 43;
          if (paramMenuItem.cpR.cpT != null)
          {
            acw localacw = paramMenuItem.cpR.cpT.wVa;
            if (localacw != null)
            {
              az localaz = (az)this.zWZ.zXe.getTag();
              if (localaz != null)
              {
                localacw.aon(localaz.cEE.field_talker);
                localacw.aoo(r.Zn());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.a.3
 * JD-Core Version:    0.7.0.1
 */