package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class MallProductReceiptUI$2
  implements AdapterView.OnItemClickListener
{
  MallProductReceiptUI$2(MallProductReceiptUI paramMallProductReceiptUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(44091);
    paramAdapterView = MallProductReceiptUI.c(this.pwk);
    if ((paramAdapterView.puo != null) && (paramInt < paramAdapterView.puo.size())) {}
    for (paramAdapterView = (String)paramAdapterView.puo.get(paramInt);; paramAdapterView = null)
    {
      ab.d("MicroMsg.MallProductReceiptUI", "onItemClick receipt = ".concat(String.valueOf(paramAdapterView)));
      if (!bo.isNullOrNil(paramAdapterView)) {
        MallProductReceiptUI.a(this.pwk).setText(paramAdapterView);
      }
      AppMethodBeat.o(44091);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductReceiptUI.2
 * JD-Core Version:    0.7.0.1
 */