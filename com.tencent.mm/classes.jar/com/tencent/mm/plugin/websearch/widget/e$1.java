package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.c;
import java.util.Map;

final class e$1
  implements Runnable
{
  e$1(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(91444);
    Object localObject = a.b.eEW;
    localObject = a.me("100458");
    if (localObject == null)
    {
      ab.i("WidgetSafeModeProxyImpl", "ABTEST_LAYERID_SEARCH_WIDGET_SAFE_MODE_SWITCH item is null");
      AppMethodBeat.o(91444);
      return;
    }
    e locale = this.uMy;
    if ((((c)localObject).isValid()) && ("1".equals(((c)localObject).dvN().get("isOpen")))) {}
    for (boolean bool = true;; bool = false)
    {
      e.a(locale, bool);
      AppMethodBeat.o(91444);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.e.1
 * JD-Core Version:    0.7.0.1
 */