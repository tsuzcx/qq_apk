package com.tencent.mm.plugin.order.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import java.util.List;

final class MallOrderRecordListUI$2
  implements AdapterView.OnItemLongClickListener
{
  MallOrderRecordListUI$2(MallOrderRecordListUI paramMallOrderRecordListUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt >= this.mQU.mQQ.size()) {
      return true;
    }
    h.a(this.mQU, this.mQU.getResources().getString(a.i.wallet_order_list_delete_order), null, this.mQU.getResources().getString(a.i.app_delete), new MallOrderRecordListUI.2.1(this, paramInt));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.2
 * JD-Core Version:    0.7.0.1
 */