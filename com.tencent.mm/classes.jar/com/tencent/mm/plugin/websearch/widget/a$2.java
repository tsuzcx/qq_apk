package com.tencent.mm.plugin.websearch.widget;

import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.sdk.platformtools.ai;

final class a$2
  implements Runnable
{
  a$2(a parama, WidgetData paramWidgetData, String paramString, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    if ((this.qWG == null) || (this.qWG.qVo == null) || (this.qWG.qVp == null)) {
      return;
    }
    d.caf();
    if (!d.a(this.qWG))
    {
      u.i("FTSSearchWidgetMgr", "local forbidden widget %s", new Object[] { this.qWG.qVo.dZY });
      return;
    }
    ai.d(new a.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.2
 * JD-Core Version:    0.7.0.1
 */