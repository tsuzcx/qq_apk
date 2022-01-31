package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import java.util.ArrayList;

final class WalletPayUOpenIntroView$a
  extends q
{
  private WalletPayUOpenIntroView$a(WalletPayUOpenIntroView paramWalletPayUOpenIntroView) {}
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(48392);
    paramViewGroup.removeView((View)WalletPayUOpenIntroView.d(this.uCw).get(paramInt));
    AppMethodBeat.o(48392);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(48390);
    if (WalletPayUOpenIntroView.c(this.uCw) == null)
    {
      AppMethodBeat.o(48390);
      return 0;
    }
    int i = WalletPayUOpenIntroView.c(this.uCw).length;
    AppMethodBeat.o(48390);
    return i;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(48391);
    View localView = (View)WalletPayUOpenIntroView.d(this.uCw).get(paramInt);
    paramViewGroup.addView(localView);
    paramViewGroup = WalletPayUOpenIntroView.c(this.uCw)[paramInt];
    ImageView localImageView = (ImageView)localView.findViewById(2131822294);
    TextView localTextView1 = (TextView)localView.findViewById(2131825320);
    TextView localTextView2 = (TextView)localView.findViewById(2131825352);
    localImageView.setImageResource(paramViewGroup.uCq);
    localTextView1.setText(paramViewGroup.titleRes);
    localTextView2.setText(paramViewGroup.uCr);
    AppMethodBeat.o(48391);
    return localView;
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUOpenIntroView.a
 * JD-Core Version:    0.7.0.1
 */