package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.utils.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public final class i
  extends Preference
{
  private int MGP;
  String MGQ;
  private View mView;
  
  public i(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66827);
    this.mView = null;
    this.MGP = 2147483647;
    setLayoutResource(a.g.mall_order_fee_pref);
    AppMethodBeat.o(66827);
  }
  
  public final void aRj(String paramString)
  {
    AppMethodBeat.i(66830);
    try
    {
      this.MGP = n.dE(paramString, true);
      AppMethodBeat.o(66830);
      return;
    }
    catch (Exception paramString)
    {
      this.MGP = -1;
      AppMethodBeat.o(66830);
    }
  }
  
  public final View b(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66828);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(66828);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(66829);
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(a.f.mall_order_fee_pref_title);
    paramView = (TextView)paramView.findViewById(a.f.mall_order_fee_pref_fee);
    localTextView.setText(getTitle());
    paramView.setText(this.MGQ);
    if (this.MGP != 2147483647) {
      paramView.setTextColor(this.MGP);
    }
    AppMethodBeat.o(66829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.i
 * JD-Core Version:    0.7.0.1
 */