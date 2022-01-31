package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.r.c.a;
import com.tencent.mm.sdk.platformtools.ai;

final class u$7
  implements c.a
{
  u$7(u paramu, bb parambb, String paramString) {}
  
  public final void b(WxaAttributes paramWxaAttributes)
  {
    if (paramWxaAttributes == null) {
      return;
    }
    ai.d(new u.7.1(this, paramWxaAttributes.field_brandIconURL, paramWxaAttributes.field_nickname));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.7
 * JD-Core Version:    0.7.0.1
 */