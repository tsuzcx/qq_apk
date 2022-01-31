package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.support.v4.view.n;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import java.util.ArrayList;

final class WalletPayUOpenIntroView$a
  extends n
{
  private WalletPayUOpenIntroView$a(WalletPayUOpenIntroView paramWalletPayUOpenIntroView) {}
  
  public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)WalletPayUOpenIntroView.d(this.qNp).get(paramInt));
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public final Object b(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = (View)WalletPayUOpenIntroView.d(this.qNp).get(paramInt);
    paramViewGroup.addView(localView);
    paramViewGroup = WalletPayUOpenIntroView.c(this.qNp)[paramInt];
    ImageView localImageView = (ImageView)localView.findViewById(a.f.logo);
    TextView localTextView1 = (TextView)localView.findViewById(a.f.tip);
    TextView localTextView2 = (TextView)localView.findViewById(a.f.hint);
    localImageView.setImageResource(paramViewGroup.qNj);
    localTextView1.setText(paramViewGroup.titleRes);
    localTextView2.setText(paramViewGroup.qNk);
    return localView;
  }
  
  public final int getCount()
  {
    if (WalletPayUOpenIntroView.c(this.qNp) == null) {
      return 0;
    }
    return WalletPayUOpenIntroView.c(this.qNp).length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUOpenIntroView.a
 * JD-Core Version:    0.7.0.1
 */