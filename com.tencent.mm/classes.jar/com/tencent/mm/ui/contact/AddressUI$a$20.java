package com.tencent.mm.ui.contact;

import android.view.View;
import com.tencent.mm.R.g;

final class AddressUI$a$20
  implements u.b
{
  AddressUI$a$20(AddressUI.a parama) {}
  
  public final void nw(boolean paramBoolean)
  {
    if (AddressUI.a.d(this.vJs) == null) {}
    BizContactEntranceView localBizContactEntranceView;
    do
    {
      return;
      localBizContactEntranceView = AddressUI.a.d(this.vJs);
    } while (localBizContactEntranceView.vJU == null);
    if (paramBoolean)
    {
      localBizContactEntranceView.vJU.setBackgroundResource(R.g.list_item_normal);
      return;
    }
    localBizContactEntranceView.vJU.setBackground(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.a.20
 * JD-Core Version:    0.7.0.1
 */