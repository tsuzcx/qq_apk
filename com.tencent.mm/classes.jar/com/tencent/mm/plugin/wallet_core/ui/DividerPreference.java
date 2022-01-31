package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.preference.Preference;

public class DividerPreference
  extends Preference
{
  private boolean hBd = true;
  private boolean mRD = false;
  private boolean mRE = false;
  private View mView = null;
  
  public DividerPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DividerPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.g.divider_pref);
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
    paramView = paramView.findViewById(a.f.divider_pref_line);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.DividerPreference
 * JD-Core Version:    0.7.0.1
 */