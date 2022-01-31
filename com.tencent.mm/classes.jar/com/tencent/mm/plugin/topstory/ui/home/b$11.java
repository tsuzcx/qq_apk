package com.tencent.mm.plugin.topstory.ui.home;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.protocal.protobuf.cku;

final class b$11
  implements View.OnClickListener
{
  b$11(b paramb, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(1589);
    if (this.tgw.tgp)
    {
      AppMethodBeat.o(1589);
      return;
    }
    this.tgw.tgp = true;
    if (!this.tgK) {
      this.tgw.gg(36, 3);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.e.qrI.e(15449, new Object[] { Integer.valueOf(0) });
      if (this.tgw.tgh.getVisibility() == 0)
      {
        this.tgw.tgh.setVisibility(8);
        paramView = new cku();
        paramView.cDC = ((com.tencent.mm.plugin.topstory.a.b)g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cIo();
        paramView.xUH = ((com.tencent.mm.plugin.topstory.a.b)g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cIp();
        an.a(paramView, 106, 5, 0, System.currentTimeMillis() / 1000L, "");
        ((com.tencent.mm.plugin.topstory.a.b)g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cIr();
      }
      AppMethodBeat.o(1589);
      return;
      this.tgw.cIO();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.11
 * JD-Core Version:    0.7.0.1
 */