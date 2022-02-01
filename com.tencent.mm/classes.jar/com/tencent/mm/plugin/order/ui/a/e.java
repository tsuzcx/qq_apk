package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public final class e
  extends Preference
{
  public String GJK;
  public View.OnClickListener mOnClickListener;
  private View mView;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66811);
    this.mView = null;
    this.mOnClickListener = null;
    setLayoutResource(a.g.mall_order_button_pref);
    AppMethodBeat.o(66811);
  }
  
  public final View c(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66812);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(66812);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(66813);
    super.onBindView(paramView);
    paramView = (TextView)paramView.findViewById(a.f.mall_order_button_pref_btn);
    paramView.setText(this.GJK);
    paramView.setOnClickListener(this.mOnClickListener);
    AppMethodBeat.o(66813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.e
 * JD-Core Version:    0.7.0.1
 */