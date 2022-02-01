package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.c;
import java.util.Map;

final class e$1
  implements Runnable
{
  e$1(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(116639);
    Object localObject = a.a.hnM;
    localObject = a.Fu("100458");
    if (localObject == null)
    {
      Log.i("WidgetSafeModeProxyImpl", "ABTEST_LAYERID_SEARCH_WIDGET_SAFE_MODE_SWITCH item is null");
      AppMethodBeat.o(116639);
      return;
    }
    e locale = this.IIj;
    if ((((c)localObject).isValid()) && ("1".equals(((c)localObject).gzz().get("isOpen")))) {}
    for (boolean bool = true;; bool = false)
    {
      e.a(locale, bool);
      AppMethodBeat.o(116639);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.e.1
 * JD-Core Version:    0.7.0.1
 */