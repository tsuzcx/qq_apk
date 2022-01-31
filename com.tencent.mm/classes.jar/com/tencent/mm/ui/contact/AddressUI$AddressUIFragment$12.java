package com.tencent.mm.ui.contact;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.am;

final class AddressUI$AddressUIFragment$12
  implements Runnable
{
  int ePG = 0;
  
  AddressUI$AddressUIFragment$12(AddressUI.AddressUIFragment paramAddressUIFragment, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(33495);
    if (this.AaO.getView() == null)
    {
      AppMethodBeat.o(33495);
      return;
    }
    int i = am.di(this.AaO.getContext());
    int j = am.K(this.AaO.getContext(), -1);
    if (j <= 0) {
      if (this.ePG < 2)
      {
        ab.i("MicroMsg.AddressUI", "[trySetParentViewPadding] try getStatusHeight again!");
        this.AaO.getView().post(this);
        this.ePG += 1;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.AddressUI", "[trySetParentViewPadding] tryCount:%s actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(this.ePG), Integer.valueOf(j), Integer.valueOf(i) });
      AppMethodBeat.o(33495);
      return;
      ab.e("MicroMsg.AddressUI", "[trySetParentViewPadding] try getStatusHeight finally!");
      break;
      int k = AddressUI.AddressUIFragment.b(this.AaO);
      if (k != this.AaO.getView().getPaddingTop())
      {
        ab.i("MicroMsg.AddressUI", "[trySetParentViewPadding] now:%s old:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(this.AaO.getView().getPaddingTop()) });
        this.AaO.getView().setPadding(0, k, 0, this.alj.getHeight());
      }
      else
      {
        ab.i("MicroMsg.AddressUI", "[trySetParentViewPadding] has try more once! it's right! actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.12
 * JD-Core Version:    0.7.0.1
 */