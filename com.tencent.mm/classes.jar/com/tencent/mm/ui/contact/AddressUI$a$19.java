package com.tencent.mm.ui.contact;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class AddressUI$a$19
  implements MMSlideDelView.f
{
  AddressUI$a$19(AddressUI.a parama) {}
  
  public final void bg(Object paramObject)
  {
    if (paramObject == null)
    {
      y.e("MicroMsg.AddressUI", "onItemDel object null");
      return;
    }
    AddressUI.a.a(this.vJs, paramObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.a.19
 * JD-Core Version:    0.7.0.1
 */