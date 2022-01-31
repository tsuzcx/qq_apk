package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.r.c.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.bi;
import java.util.Map;

final class u$17
  implements c.a
{
  u$17(u paramu, Map paramMap, bi parambi, bb parambb) {}
  
  public final void b(WxaAttributes paramWxaAttributes)
  {
    if (paramWxaAttributes == null) {
      return;
    }
    u.b(this.vDZ, paramWxaAttributes.field_appId);
    if ((paramWxaAttributes.field_appOpt & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ai.d(new u.17.1(this, bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.17
 * JD-Core Version:    0.7.0.1
 */