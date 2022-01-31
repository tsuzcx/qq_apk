package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public final class c
  extends Preference
{
  Bitmap ebo = null;
  private TextView mMy;
  View.OnClickListener mOnClickListener;
  private ImageView mRn;
  String mRo = "";
  private View mView = null;
  
  public c(Context paramContext)
  {
    super(paramContext);
    setLayoutResource(a.g.mall_order_barcode_pref);
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
    this.mMy = ((TextView)paramView.findViewById(a.f.mall_order_barcode_num));
    this.mRn = ((ImageView)paramView.findViewById(a.f.mall_order_barcode_iv));
    this.mMy.setText(this.mRo);
    this.mRn.setImageBitmap(this.ebo);
    this.mRn.setOnClickListener(this.mOnClickListener);
    if ((this.mRo != null) && (this.mRo.length() > 48)) {
      this.mMy.setTextSize(0, a.aa(this.mContext, a.d.HintTextSize));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.c
 * JD-Core Version:    0.7.0.1
 */