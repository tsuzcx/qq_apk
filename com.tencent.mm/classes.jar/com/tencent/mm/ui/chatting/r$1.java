package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.q;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.viewitems.az;

final class r$1
  implements View.OnClickListener
{
  r$1(q paramq, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30708);
    paramView = (az)paramView.getTag();
    ab.i("MicroMsg.ChattingItemHelper", "on app brand(%s) button1 click", new Object[] { this.jYo.fjO });
    so localso = new so();
    localso.cIQ.userName = this.jYo.fjO;
    localso.cIQ.cIS = this.jYo.fjP;
    localso.cIQ.cIT = this.jYo.fjR;
    localso.cIQ.bDc = this.jYo.fjQ;
    localso.cIQ.cIW = true;
    localso.cIQ.scene = 1076;
    localso.cIQ.cmF = (this.fwC + ":" + paramView.cEE.field_msgSvrId + ":" + paramView.uXa);
    a.ymk.l(localso);
    AppMethodBeat.o(30708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.r.1
 * JD-Core Version:    0.7.0.1
 */