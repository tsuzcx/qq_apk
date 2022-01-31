package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.LinkedList;
import java.util.List;

final class ProductFurtherInfoUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ProductFurtherInfoUI$2(ProductFurtherInfoUI paramProductFurtherInfoUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    paramMenuItem.add(this.nJQ.getString(R.l.scan_product_feedback_title));
    localLinkedList.add(Integer.valueOf(0));
    h.a(this.nJQ.mController.uMN, "", paramMenuItem, localLinkedList, "", false, new ProductFurtherInfoUI.2.1(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.2
 * JD-Core Version:    0.7.0.1
 */