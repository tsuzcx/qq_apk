package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AddressUI$AddressUIFragment$11
  implements Runnable
{
  AddressUI$AddressUIFragment$11(AddressUI.AddressUIFragment paramAddressUIFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(33494);
    AddressUI.AddressUIFragment.a(this.AaO).dLD();
    if (AddressUI.AddressUIFragment.f(this.AaO) != null)
    {
      AddressUI.AddressUIFragment.f(this.AaO).reset();
      if (AddressUI.AddressUIFragment.f(this.AaO).getOpenIMCount() <= 0)
      {
        AddressUI.AddressUIFragment.f(this.AaO).setVisibility(8);
        AppMethodBeat.o(33494);
        return;
      }
      AddressUI.AddressUIFragment.f(this.AaO).setVisibility(0);
    }
    AppMethodBeat.o(33494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.11
 * JD-Core Version:    0.7.0.1
 */