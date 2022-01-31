package com.tencent.mm.plugin.websearch.widget;

import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$2$1$9
  extends ac
{
  a$2$1$9(a.2.1 param1) {}
  
  public final void ae(String paramString1, String paramString2)
  {
    y.v("FTSSearchWidgetMgr", "on widget data push, widgetId[%s], respData[%s]", new Object[] { paramString1, paramString2 });
    paramString1 = a.c(this.qWN.qWI.qWF, paramString1);
    if (!bk.bl(paramString1))
    {
      a.j(this.qWN.qWI.qWF).fo(paramString1, paramString2);
      return;
    }
    y.e("FTSSearchWidgetMgr", "onWidgetDataPush widget cache key not found!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.2.1.9
 * JD-Core Version:    0.7.0.1
 */