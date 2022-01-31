package com.tencent.mm.plugin.order.ui;

import com.tencent.mm.ui.base.MMLoadMoreListView.a;

final class MallOrderRecordListUI$3
  implements MMLoadMoreListView.a
{
  MallOrderRecordListUI$3(MallOrderRecordListUI paramMallOrderRecordListUI) {}
  
  public final void yb()
  {
    if (!this.mQU.isLoading)
    {
      this.mQU.isLoading = true;
      MallOrderRecordListUI localMallOrderRecordListUI = this.mQU;
      localMallOrderRecordListUI.El += 10;
      this.mQU.brK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.3
 * JD-Core Version:    0.7.0.1
 */