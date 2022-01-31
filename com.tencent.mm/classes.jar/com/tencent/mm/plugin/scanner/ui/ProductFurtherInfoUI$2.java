package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

final class ProductFurtherInfoUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ProductFurtherInfoUI$2(ProductFurtherInfoUI paramProductFurtherInfoUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(81045);
    paramMenuItem = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    paramMenuItem.add(this.qxs.getString(2131302931));
    localLinkedList.add(Integer.valueOf(0));
    h.a(this.qxs.getContext(), "", paramMenuItem, localLinkedList, "", false, new ProductFurtherInfoUI.2.1(this));
    AppMethodBeat.o(81045);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.2
 * JD-Core Version:    0.7.0.1
 */