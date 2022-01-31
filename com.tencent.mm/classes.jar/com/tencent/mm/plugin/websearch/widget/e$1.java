package com.tencent.mm.plugin.websearch.widget;

import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.c;
import java.util.Map;

final class e$1
  implements Runnable
{
  e$1(e parame) {}
  
  public final void run()
  {
    Object localObject = a.b.dHs;
    localObject = a.fJ("100458");
    if (localObject == null)
    {
      y.i("WidgetSafeModeProxyImpl", "ABTEST_LAYERID_SEARCH_WIDGET_SAFE_MODE_SWITCH item is null");
      return;
    }
    e locale = this.qXj;
    if ((((c)localObject).isValid()) && ("1".equals(((c)localObject).ctr().get("isOpen")))) {}
    for (boolean bool = true;; bool = false)
    {
      e.a(locale, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.e.1
 * JD-Core Version:    0.7.0.1
 */