package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public final class c
  extends Preference
{
  private TextView GEr;
  private ImageView GJI;
  String GJJ;
  Bitmap lAx;
  View.OnClickListener mOnClickListener;
  private View mView;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66805);
    this.mView = null;
    this.GJJ = "";
    this.lAx = null;
    setLayoutResource(a.g.mall_order_barcode_pref);
    AppMethodBeat.o(66805);
  }
  
  public final View c(View paramView, ViewGroup paramViewGroup)
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
    this.GEr = ((TextView)paramView.findViewById(a.f.mall_order_barcode_num));
    this.GJI = ((ImageView)paramView.findViewById(a.f.mall_order_barcode_iv));
    this.GEr.setText(this.GJJ);
    this.GJI.setImageBitmap(this.lAx);
    this.GJI.setOnClickListener(this.mOnClickListener);
    if ((this.GJJ != null) && (this.GJJ.length() > 48)) {
      this.GEr.setTextSize(0, a.aY(this.mContext, a.d.HintTextSize));
    }
    AppMethodBeat.o(66807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.c
 * JD-Core Version:    0.7.0.1
 */