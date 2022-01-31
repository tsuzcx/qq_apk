package com.tencent.mm.plugin.websearch.widget;

import com.tencent.mm.modelappbrand.af;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$2$1$8
  extends af
{
  a$2$1$8(a.2.1 param1) {}
  
  public final void jF(String paramString)
  {
    y.v("FTSSearchWidgetMgr", "on widget reload data, widgetId[%s]", new Object[] { paramString });
    paramString = a.c(this.qWN.qWI.qWF, paramString);
    if (!bk.bl(paramString))
    {
      a.j(this.qWN.qWI.qWF).Rr(paramString);
      return;
    }
    y.e("FTSSearchWidgetMgr", "onWidgetReloadData widget cache key not found!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.2.1.8
 * JD-Core Version:    0.7.0.1
 */