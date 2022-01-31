package com.tencent.mm.plugin.webview.luggage;

import android.view.MenuItem;
import com.tencent.luggage.e.e;
import com.tencent.mm.plugin.webview.luggage.b.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.c;

final class p$2
  implements n.d
{
  p$2(p paramp) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    p localp = this.rcR;
    localp.rcH.a(localp.rcp.mContext, localp.rcp, paramMenuItem);
    this.rcR.rcQ.bFp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.p.2
 * JD-Core Version:    0.7.0.1
 */