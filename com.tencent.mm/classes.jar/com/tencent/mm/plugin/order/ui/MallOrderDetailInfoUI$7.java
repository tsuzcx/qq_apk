package com.tencent.mm.plugin.order.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wxpay.a.f;

final class MallOrderDetailInfoUI$7
  implements View.OnClickListener
{
  MallOrderDetailInfoUI$7(MallOrderDetailInfoUI paramMallOrderDetailInfoUI) {}
  
  public final void onClick(View paramView)
  {
    if ((MallOrderDetailInfoUI.f(this.mQG) != null) && (MallOrderDetailInfoUI.g(this.mQG) != null))
    {
      if (paramView.getId() == a.f.order_action_item_good_tv)
      {
        MallOrderDetailInfoUI.f(this.mQG).setSelected(true);
        MallOrderDetailInfoUI.g(this.mQG).setSelected(false);
        MallOrderDetailInfoUI.a(this.mQG, 100);
      }
    }
    else {
      return;
    }
    MallOrderDetailInfoUI.f(this.mQG).setSelected(false);
    MallOrderDetailInfoUI.g(this.mQG).setSelected(true);
    MallOrderDetailInfoUI.a(this.mQG, -100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI.7
 * JD-Core Version:    0.7.0.1
 */