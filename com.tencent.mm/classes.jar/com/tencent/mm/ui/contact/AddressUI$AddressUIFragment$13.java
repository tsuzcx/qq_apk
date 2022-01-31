package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.voicesearch.b;

final class AddressUI$AddressUIFragment$13
  implements Runnable
{
  AddressUI$AddressUIFragment$13(AddressUI.AddressUIFragment paramAddressUIFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(33496);
    ab.v("MicroMsg.AddressUI", "post search adapter to do refresh");
    AddressUI.AddressUIFragment.h(this.AaO).a(null, null);
    AppMethodBeat.o(33496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.13
 * JD-Core Version:    0.7.0.1
 */