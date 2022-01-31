package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.support.v4.view.ViewPager.e;
import android.view.ViewParent;
import com.tencent.mm.ui.base.MMAutoHeightViewPager;
import com.tencent.mm.ui.base.MMPageControlView;

final class WalletPayUOpenIntroView$1
  implements ViewPager.e
{
  WalletPayUOpenIntroView$1(WalletPayUOpenIntroView paramWalletPayUOpenIntroView) {}
  
  public final void Q(int paramInt) {}
  
  public final void R(int paramInt)
  {
    if (WalletPayUOpenIntroView.a(this.qNp).getParent() != null) {
      WalletPayUOpenIntroView.a(this.qNp).getParent().requestDisallowInterceptTouchEvent(true);
    }
    WalletPayUOpenIntroView.b(this.qNp).setPage(paramInt);
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUOpenIntroView.1
 * JD-Core Version:    0.7.0.1
 */