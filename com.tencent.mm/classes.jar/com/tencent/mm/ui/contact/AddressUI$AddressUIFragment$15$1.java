package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class AddressUI$AddressUIFragment$15$1
  implements Runnable
{
  AddressUI$AddressUIFragment$15$1(AddressUI.AddressUIFragment.15 param15) {}
  
  public final void run()
  {
    AppMethodBeat.i(224197);
    AddressUI.AddressUIFragment.d(this.OAx.KGn).setAdapter(AddressUI.AddressUIFragment.a(this.OAx.KGn));
    ae.i("MicroMsg.AddressUI", "post to first init finish");
    View localView = this.OAx.KGn.findViewById(2131301512);
    if (localView != null)
    {
      localView.setVisibility(8);
      localView.startAnimation(AnimationUtils.loadAnimation(this.OAx.KGn.getContext(), 2130772048));
    }
    AppMethodBeat.o(224197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.15.1
 * JD-Core Version:    0.7.0.1
 */