package com.tencent.mm.plugin.order.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.a;
import java.util.List;

final class MallOrderDetailInfoUI$6
  implements AdapterView.OnItemClickListener
{
  MallOrderDetailInfoUI$6(MallOrderDetailInfoUI paramMallOrderDetailInfoUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(43801);
    paramAdapterView = (MallOrderDetailObject.a)MallOrderDetailInfoUI.e(this.pqU).get(paramInt);
    if (!TextUtils.isEmpty(paramAdapterView.jumpUrl)) {
      c.aM(this.pqU, paramAdapterView.jumpUrl);
    }
    MallOrderDetailInfoUI.a(this.pqU, paramAdapterView.name);
    AppMethodBeat.o(43801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI.6
 * JD-Core Version:    0.7.0.1
 */