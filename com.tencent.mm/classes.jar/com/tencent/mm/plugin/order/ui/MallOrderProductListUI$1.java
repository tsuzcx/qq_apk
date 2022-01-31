package com.tencent.mm.plugin.order.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import java.util.List;

final class MallOrderProductListUI$1
  implements AdapterView.OnItemClickListener
{
  MallOrderProductListUI$1(MallOrderProductListUI paramMallOrderProductListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ProductSectionItem)MallOrderProductListUI.a(this.mQI).get(paramInt);
    if (paramAdapterView != null)
    {
      MallOrderProductListUI.a(this.mQI, paramAdapterView);
      c.a(Boolean.valueOf(false), MallOrderProductListUI.b(this.mQI), MallOrderProductListUI.c(this.mQI), paramAdapterView.name, paramAdapterView.mQo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderProductListUI.1
 * JD-Core Version:    0.7.0.1
 */