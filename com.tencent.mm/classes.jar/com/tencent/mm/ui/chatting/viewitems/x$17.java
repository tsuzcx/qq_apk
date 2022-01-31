package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.i.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bi;
import java.util.Map;

final class x$17
  implements i.a
{
  x$17(x paramx, Map paramMap, bi parambi, be parambe) {}
  
  public final void d(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(33147);
    if (paramWxaAttributes == null)
    {
      AppMethodBeat.o(33147);
      return;
    }
    x.b(this.zVk, paramWxaAttributes.field_appId);
    if ((paramWxaAttributes.field_appOpt & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      al.d(new x.17.1(this, bool));
      AppMethodBeat.o(33147);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.17
 * JD-Core Version:    0.7.0.1
 */