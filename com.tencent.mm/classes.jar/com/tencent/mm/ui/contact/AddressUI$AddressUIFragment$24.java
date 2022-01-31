package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AddressUI$AddressUIFragment$24
  implements v.b
{
  AddressUI$AddressUIFragment$24(AddressUI.AddressUIFragment paramAddressUIFragment) {}
  
  public final void rf(boolean paramBoolean)
  {
    AppMethodBeat.i(33506);
    if (AddressUI.AddressUIFragment.e(this.AaO) == null)
    {
      AppMethodBeat.o(33506);
      return;
    }
    BizContactEntranceView localBizContactEntranceView = AddressUI.AddressUIFragment.e(this.AaO);
    if (!paramBoolean) {}
    for (int i = 1; (localBizContactEntranceView.Abq == null) || (localBizContactEntranceView.Abs == null); i = 0)
    {
      AppMethodBeat.o(33506);
      return;
    }
    if (i != 0)
    {
      i = localBizContactEntranceView.Abq.getPaddingLeft();
      localBizContactEntranceView.Abq.setBackgroundResource(2130839276);
      localBizContactEntranceView.Abq.setPadding(i, 0, 0, 0);
      localBizContactEntranceView.Abs.setBackground(null);
      AppMethodBeat.o(33506);
      return;
    }
    localBizContactEntranceView.Abq.setBackground(null);
    localBizContactEntranceView.Abs.setBackgroundResource(2130839276);
    AppMethodBeat.o(33506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.24
 * JD-Core Version:    0.7.0.1
 */