package com.tencent.mm.ui.contact;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class OpenIMAddressUI$a$14
  implements MMSlideDelView.f
{
  OpenIMAddressUI$a$14(OpenIMAddressUI.a parama) {}
  
  public final void bg(Object paramObject)
  {
    if (paramObject == null)
    {
      y.e("MicroMsg.OpenIMAddressUI", "onItemDel object null");
      return;
    }
    OpenIMAddressUI.a.a(this.vMP, paramObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI.a.14
 * JD-Core Version:    0.7.0.1
 */