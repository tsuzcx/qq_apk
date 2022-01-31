package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class MallProductReceiptUI$2
  implements AdapterView.OnItemClickListener
{
  MallProductReceiptUI$2(MallProductReceiptUI paramMallProductReceiptUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = MallProductReceiptUI.c(this.mUe);
    if ((paramAdapterView.mSh != null) && (paramInt < paramAdapterView.mSh.size())) {}
    for (paramAdapterView = (String)paramAdapterView.mSh.get(paramInt);; paramAdapterView = null)
    {
      y.d("MicroMsg.MallProductReceiptUI", "onItemClick receipt = " + paramAdapterView);
      if (!bk.bl(paramAdapterView)) {
        MallProductReceiptUI.a(this.mUe).setText(paramAdapterView);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductReceiptUI.2
 * JD-Core Version:    0.7.0.1
 */