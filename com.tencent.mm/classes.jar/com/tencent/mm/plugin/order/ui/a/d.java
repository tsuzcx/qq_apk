package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public final class d
  extends Preference
{
  String mName;
  View.OnClickListener mOnClickListener;
  private View mView;
  String xOn;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66808);
    this.mView = null;
    setLayoutResource(a.g.mall_order_biz_pref);
    AppMethodBeat.o(66808);
  }
  
  public final View b(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66809);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(66809);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(66810);
    super.onBindView(paramView);
    ImageView localImageView = (ImageView)paramView.findViewById(a.f.mall_order_biz_pref_icon);
    TextView localTextView = (TextView)paramView.findViewById(a.f.mall_order_biz_pref_name);
    localImageView.setImageBitmap(null);
    if (!Util.isNullOrNil(this.xOn))
    {
      Object localObject = new c.a();
      b.gxv();
      ((c.a)localObject).prefixPath = b.fWo();
      ((c.a)localObject).oKp = true;
      ((c.a)localObject).nqa = true;
      ((c.a)localObject).nrc = true;
      localObject = ((c.a)localObject).bKx();
      r.bKe().a(this.xOn, localImageView, (c)localObject);
    }
    localTextView.setText(this.mName);
    paramView.findViewById(a.f.mall_order_biz_pref_container).setOnClickListener(this.mOnClickListener);
    AppMethodBeat.o(66810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.d
 * JD-Core Version:    0.7.0.1
 */