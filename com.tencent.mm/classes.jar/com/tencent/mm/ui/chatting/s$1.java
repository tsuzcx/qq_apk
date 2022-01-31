package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ae.m;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.viewitems.aw;

final class s$1
  implements View.OnClickListener
{
  s$1(m paramm, String paramString) {}
  
  public final void onClick(View paramView)
  {
    paramView = (aw)paramView.getTag();
    y.i("MicroMsg.ChattingItemHelper", "on app brand(%s) button1 click", new Object[] { this.ifo.dTI });
    rc localrc = new rc();
    localrc.caq.userName = this.ifo.dTI;
    localrc.caq.cas = this.ifo.dTJ;
    localrc.caq.cat = this.ifo.dTL;
    localrc.caq.cau = this.ifo.dTK;
    localrc.caq.cax = true;
    localrc.caq.scene = 1076;
    localrc.caq.bFv = (this.egy + ":" + paramView.bWO.field_msgSvrId + ":" + paramView.rgM);
    a.udP.m(localrc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.1
 * JD-Core Version:    0.7.0.1
 */