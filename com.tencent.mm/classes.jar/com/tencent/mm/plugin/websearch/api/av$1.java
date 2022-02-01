package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.c;
import java.util.Map;

final class av$1
  implements Runnable
{
  av$1(av paramav) {}
  
  public final void run()
  {
    AppMethodBeat.i(117803);
    Object localObject = a.a.mzH;
    localObject = a.Fd("100387");
    if (localObject == null)
    {
      Log.i("WebSearchXWeb", "openSearchPreload item is null");
      AppMethodBeat.o(117803);
      return;
    }
    av localav = this.Wql;
    if ((((c)localObject).isValid()) && ("1".equals(((c)localObject).iWZ().get("isOpen")))) {}
    for (boolean bool = true;; bool = false)
    {
      av.a(localav, bool);
      AppMethodBeat.o(117803);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.av.1
 * JD-Core Version:    0.7.0.1
 */