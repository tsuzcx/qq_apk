package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.c;
import java.util.Map;

final class aq$1
  implements Runnable
{
  aq$1(aq paramaq) {}
  
  public final void run()
  {
    Object localObject = a.b.dHs;
    localObject = a.fJ("100387");
    if (localObject == null)
    {
      y.i("WebSearchXWeb", "openSearchPreload item is null");
      return;
    }
    aq localaq = this.qVk;
    if ((((c)localObject).isValid()) && ("1".equals(((c)localObject).ctr().get("isOpen")))) {}
    for (boolean bool = true;; bool = false)
    {
      aq.a(localaq, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aq.1
 * JD-Core Version:    0.7.0.1
 */