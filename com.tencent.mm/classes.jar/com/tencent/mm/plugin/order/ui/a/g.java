package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class g
  extends Preference
{
  private static int mRu;
  private static float mRv = 16.0F;
  f hcp;
  String mRw;
  private String[] mRx;
  private TextUtils.TruncateAt mRy;
  private boolean mRz = false;
  private View mView = null;
  
  public g(Context paramContext)
  {
    super(paramContext);
    setLayoutResource(a.g.mall_order_deployable_pref);
    mRu = paramContext.getResources().getColor(a.c.mall_order_pref_content_color);
  }
  
  public final void a(String[] paramArrayOfString, TextUtils.TruncateAt paramTruncateAt)
  {
    this.mRx = paramArrayOfString;
    this.mRy = paramTruncateAt;
    this.mRz = true;
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
    TextView localTextView1 = (TextView)paramView.findViewById(a.f.mall_order_deployable_pref_title);
    TextView localTextView2 = (TextView)paramView.findViewById(a.f.mall_order_deployable_pref_content_summary);
    paramView = (LinearLayout)paramView.findViewById(a.f.mall_order_deployable_pref_content_container);
    localTextView1.setText(getTitle());
    if ((this.mRx == null) || (this.mRx.length <= 1)) {
      localTextView2.setTextColor(mRu);
    }
    for (;;)
    {
      localTextView2.setText(this.mRw);
      return;
      localTextView2.setOnClickListener(new g.1(this, localTextView2, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.g
 * JD-Core Version:    0.7.0.1
 */