package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AddressUI$AddressUIFragment$14
  implements Runnable
{
  AddressUI$AddressUIFragment$14(AddressUI.AddressUIFragment paramAddressUIFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(33497);
    ab.i("MicroMsg.AddressUI", "post to first init finish");
    View localView = this.AaO.findViewById(2131828467);
    if (localView != null)
    {
      localView.setVisibility(8);
      localView.startAnimation(AnimationUtils.loadAnimation(this.AaO.getContext(), 2131034182));
    }
    AppMethodBeat.o(33497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.14
 * JD-Core Version:    0.7.0.1
 */