package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.preference.Preference;

public final class d
  extends Preference
{
  String iZG;
  String mName;
  View.OnClickListener mOnClickListener;
  private View mView = null;
  
  public d(Context paramContext)
  {
    super(paramContext);
    setLayoutResource(a.g.mall_order_biz_pref);
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
    ImageView localImageView = (ImageView)paramView.findViewById(a.f.mall_order_biz_pref_icon);
    TextView localTextView = (TextView)paramView.findViewById(a.f.mall_order_biz_pref_name);
    localImageView.setImageBitmap(null);
    if (!bk.bl(this.iZG))
    {
      Object localObject = new c.a();
      b.brv();
      ((c.a)localObject).eri = b.bfi();
      ((c.a)localObject).erf = true;
      ((c.a)localObject).erC = true;
      ((c.a)localObject).erD = true;
      localObject = ((c.a)localObject).OV();
      o.ON().a(this.iZG, localImageView, (c)localObject);
    }
    localTextView.setText(this.mName);
    paramView.findViewById(a.f.mall_order_biz_pref_container).setOnClickListener(this.mOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.d
 * JD-Core Version:    0.7.0.1
 */