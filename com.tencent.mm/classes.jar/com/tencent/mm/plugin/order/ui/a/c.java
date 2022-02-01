package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public final class c
  extends Preference
{
  private TextView MAK;
  private ImageView MGx;
  String MGy;
  View.OnClickListener mOnClickListener;
  private View mView;
  Bitmap orY;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66805);
    this.mView = null;
    this.MGy = "";
    this.orY = null;
    setLayoutResource(a.g.mall_order_barcode_pref);
    AppMethodBeat.o(66805);
  }
  
  public final View b(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66806);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(66806);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(66807);
    super.onBindView(paramView);
    this.MAK = ((TextView)paramView.findViewById(a.f.mall_order_barcode_num));
    this.MGx = ((ImageView)paramView.findViewById(a.f.mall_order_barcode_iv));
    this.MAK.setText(this.MGy);
    this.MGx.setImageBitmap(this.orY);
    this.MGx.setOnClickListener(this.mOnClickListener);
    if ((this.MGy != null) && (this.MGy.length() > 48)) {
      this.MAK.setTextSize(0, a.br(this.mContext, a.d.HintTextSize));
    }
    AppMethodBeat.o(66807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.c
 * JD-Core Version:    0.7.0.1
 */