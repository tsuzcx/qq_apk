package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public final class i
  extends Preference
{
  private int mRF = 2147483647;
  String mRG;
  private View mView = null;
  
  public i(Context paramContext)
  {
    super(paramContext);
    setLayoutResource(a.g.mall_order_fee_pref);
  }
  
  public final void KM(String paramString)
  {
    try
    {
      this.mRF = Color.parseColor(paramString);
      return;
    }
    catch (Exception paramString)
    {
      this.mRF = -1;
    }
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
    TextView localTextView = (TextView)paramView.findViewById(a.f.mall_order_fee_pref_title);
    paramView = (TextView)paramView.findViewById(a.f.mall_order_fee_pref_fee);
    localTextView.setText(getTitle());
    paramView.setText(this.mRG);
    if (this.mRF != 2147483647) {
      paramView.setTextColor(this.mRF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.i
 * JD-Core Version:    0.7.0.1
 */