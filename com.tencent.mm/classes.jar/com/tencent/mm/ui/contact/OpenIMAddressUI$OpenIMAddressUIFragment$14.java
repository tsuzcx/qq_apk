package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class OpenIMAddressUI$OpenIMAddressUIFragment$14
  implements MMSlideDelView.f
{
  OpenIMAddressUI$OpenIMAddressUIFragment$14(OpenIMAddressUI.OpenIMAddressUIFragment paramOpenIMAddressUIFragment) {}
  
  public final void bC(Object paramObject)
  {
    AppMethodBeat.i(33779);
    if (paramObject == null)
    {
      ab.e("MicroMsg.OpenIMAddressUI", "onItemDel object null");
      AppMethodBeat.o(33779);
      return;
    }
    OpenIMAddressUI.OpenIMAddressUIFragment.a(this.Aes, paramObject.toString());
    AppMethodBeat.o(33779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.14
 * JD-Core Version:    0.7.0.1
 */