package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.ui.base.preference.Preference;

public final class h
  extends Preference
{
  boolean MGN;
  boolean MGO;
  private View mView;
  boolean uOJ;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66824);
    this.mView = null;
    this.MGN = false;
    this.MGO = false;
    this.uOJ = true;
    setLayoutResource(a.g.mall_order_divider_pref);
    AppMethodBeat.o(66824);
  }
  
  public final View b(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66825);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(66825);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(66826);
    super.onBindView(paramView);
    paramView = paramView.findViewById(a.f.mall_order_divider_pref_line);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 10.0F);
    if (this.MGN) {}
    for (int j = i;; j = 0)
    {
      if (this.MGO) {}
      for (;;)
      {
        localLayoutParams.setMargins(0, j, 0, i);
        paramView.setLayoutParams(localLayoutParams);
        if (!this.uOJ)
        {
          paramView.setVisibility(4);
          AppMethodBeat.o(66826);
          return;
        }
        paramView.setVisibility(0);
        AppMethodBeat.o(66826);
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.h
 * JD-Core Version:    0.7.0.1
 */