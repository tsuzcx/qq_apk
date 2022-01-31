package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMAutoHeightViewPager;
import com.tencent.mm.ui.base.MMPageControlView;

final class WalletPayUOpenIntroView$1
  implements ViewPager.OnPageChangeListener
{
  WalletPayUOpenIntroView$1(WalletPayUOpenIntroView paramWalletPayUOpenIntroView) {}
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(48389);
    if (WalletPayUOpenIntroView.a(this.uCw).getParent() != null) {
      WalletPayUOpenIntroView.a(this.uCw).getParent().requestDisallowInterceptTouchEvent(true);
    }
    WalletPayUOpenIntroView.b(this.uCw).setPage(paramInt);
    AppMethodBeat.o(48389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUOpenIntroView.1
 * JD-Core Version:    0.7.0.1
 */