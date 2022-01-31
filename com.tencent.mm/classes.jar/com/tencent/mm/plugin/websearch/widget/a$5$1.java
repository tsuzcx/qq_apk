package com.tencent.mm.plugin.websearch.widget;

import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.sdk.platformtools.y;

final class a$5$1
  implements Runnable
{
  a$5$1(a.5 param5) {}
  
  public final void run()
  {
    if (this.qWS.qWQ.equals(a.k(this.qWS.qWF)))
    {
      y.i("FTSSearchWidgetMgr", "tap event timeout id %s", new Object[] { this.qWS.qWQ });
      a.b(this.qWS.qWF, null);
      a.j(this.qWS.qWF).a(this.qWS.qWQ, false, "timeout", this.qWS.fVe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.5.1
 * JD-Core Version:    0.7.0.1
 */