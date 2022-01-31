package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AddressUI$AddressUIFragment$2
  implements i.a
{
  AddressUI$AddressUIFragment$2(AddressUI.AddressUIFragment paramAddressUIFragment) {}
  
  public final void Qr(int paramInt)
  {
    AppMethodBeat.i(33485);
    if (AddressUI.AddressUIFragment.g(this.AaO) == null)
    {
      AppMethodBeat.o(33485);
      return;
    }
    if (paramInt <= 0)
    {
      AddressUI.AddressUIFragment.g(this.AaO).setVisibility(8);
      AppMethodBeat.o(33485);
      return;
    }
    AddressUI.AddressUIFragment.g(this.AaO).setVisibility(0);
    AppMethodBeat.o(33485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.2
 * JD-Core Version:    0.7.0.1
 */