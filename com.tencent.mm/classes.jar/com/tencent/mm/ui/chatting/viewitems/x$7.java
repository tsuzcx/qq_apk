package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.i.a;
import com.tencent.mm.sdk.platformtools.al;

final class x$7
  implements i.a
{
  x$7(x paramx, be parambe, String paramString) {}
  
  public final void d(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(33134);
    if (paramWxaAttributes == null)
    {
      AppMethodBeat.o(33134);
      return;
    }
    al.d(new x.7.1(this, paramWxaAttributes.field_brandIconURL, paramWxaAttributes.field_nickname));
    AppMethodBeat.o(33134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.7
 * JD-Core Version:    0.7.0.1
 */