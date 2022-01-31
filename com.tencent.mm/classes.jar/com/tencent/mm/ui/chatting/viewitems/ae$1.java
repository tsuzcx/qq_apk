package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.mm.ax.a;
import com.tencent.mm.ax.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

final class ae$1
  extends be
{
  ae$1(ae paramae, int paramInt1, int paramInt2, a parama, a.b paramb, ag.b paramb1, bi parambi, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2);
  }
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.ChattingItemNewXmlSysImpl", "[onClick] pBaseNewXmlMsg:%s", new Object[] { this.vrC });
    this.vFj.a(this.vFk.kKz, this.dUy, this.vrC, this.ifp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.1
 * JD-Core Version:    0.7.0.1
 */