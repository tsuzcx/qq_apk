package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.wxpay.a.h;
import java.util.Iterator;
import java.util.List;

final class SwitchPhoneItemGroupView$1
  implements View.OnClickListener
{
  SwitchPhoneItemGroupView$1(SwitchPhoneItemGroupView paramSwitchPhoneItemGroupView) {}
  
  public final void onClick(View paramView)
  {
    Iterator localIterator = this.qHQ.qHN.iterator();
    while (localIterator.hasNext()) {
      ((SwitchPhoneItemView)localIterator.next()).qHT.setImageResource(a.h.radio_off);
    }
    ((SwitchPhoneItemView)paramView).qHT.setImageResource(a.h.radio_on);
    if (SwitchPhoneItemGroupView.a(this.qHQ) != null) {
      SwitchPhoneItemGroupView.a(this.qHQ).dp(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView.1
 * JD-Core Version:    0.7.0.1
 */