package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.preference.Preference;

public final class h
  extends Preference
{
  boolean hBd = true;
  boolean mRD = false;
  boolean mRE = false;
  private View mView = null;
  
  public h(Context paramContext)
  {
    super(paramContext);
    setLayoutResource(a.g.mall_order_divider_pref);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    return this.mView;
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    paramView = paramView.findViewById(a.f.mall_order_divider_pref_line);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    int i = BackwardSupportUtil.b.b(this.mContext, 10.0F);
    if (this.mRD) {}
    for (int j = i;; j = 0)
    {
      if (this.mRE) {}
      for (;;)
      {
        localLayoutParams.setMargins(0, j, 0, i);
        paramView.setLayoutParams(localLayoutParams);
        if (!this.hBd)
        {
          paramView.setVisibility(4);
          return;
        }
        paramView.setVisibility(0);
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.h
 * JD-Core Version:    0.7.0.1
 */