package com.tencent.mm.ui.contact;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ch.d;

final class AddressUI$a$8
  implements AbsListView.OnScrollListener
{
  AddressUI$a$8(AddressUI.a parama) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < 2) {}
    while (AddressUI.a.n(this.vJs)) {
      return;
    }
    AddressUI.a.o(this.vJs);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 2) {
      d.cxA().dA(AddressUI.class.getName() + ".Listview", 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.a.8
 * JD-Core Version:    0.7.0.1
 */