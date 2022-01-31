package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public final class e
  extends Preference
{
  public View.OnClickListener mOnClickListener = null;
  public String mRp;
  private View mView = null;
  
  public e(Context paramContext)
  {
    super(paramContext);
    setLayoutResource(a.g.mall_order_button_pref);
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
    paramView = (TextView)paramView.findViewById(a.f.mall_order_button_pref_btn);
    paramView.setText(this.mRp);
    paramView.setOnClickListener(this.mOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.e
 * JD-Core Version:    0.7.0.1
 */