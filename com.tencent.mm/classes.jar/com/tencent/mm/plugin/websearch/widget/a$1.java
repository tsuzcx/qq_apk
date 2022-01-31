package com.tencent.mm.plugin.websearch.widget;

import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

final class a$1
  implements j
{
  a$1(a parama, com.tencent.mm.plugin.websearch.api.r paramr) {}
  
  public final void onDisconnect()
  {
    if ("com.tencent.mm:support".equals(a.a(this.qWF)))
    {
      u.i("FTSSearchWidgetMgr", "support process dead", new Object[0]);
      if (a.b(this.qWF) != null)
      {
        com.tencent.mm.h.b.a.r localr = new com.tencent.mm.h.b.a.r();
        localr.cjv = a.b(this.qWF).qVo.dZY;
        localr.cjw = a.b(this.qWF).qVo.dWx;
        localr.cjs = 21L;
        localr.cjt = System.currentTimeMillis();
        localr.cjy = aq.fH(ae.getContext());
        localr.QX();
        v.jdMethod_if(30);
        this.qWE.bZn();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.1
 * JD-Core Version:    0.7.0.1
 */