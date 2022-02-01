package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class g
  extends Preference
{
  private static int MGE;
  private static float MGF = 16.0F;
  String MGG;
  private String[] MGH;
  private TextUtils.TruncateAt MGI;
  private boolean MGJ;
  private View mView;
  f pkD;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66820);
    this.mView = null;
    this.MGJ = false;
    setLayoutResource(a.g.mall_order_deployable_pref);
    MGE = paramContext.getResources().getColor(a.c.mall_order_pref_content_color);
    AppMethodBeat.o(66820);
  }
  
  public final void a(String[] paramArrayOfString, TextUtils.TruncateAt paramTruncateAt)
  {
    this.MGH = paramArrayOfString;
    this.MGI = paramTruncateAt;
    this.MGJ = true;
  }
  
  public final View b(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66821);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(66821);
    return paramView;
  }
  
  public final void onBindView(final View paramView)
  {
    AppMethodBeat.i(66822);
    super.onBindView(paramView);
    TextView localTextView1 = (TextView)paramView.findViewById(a.f.mall_order_deployable_pref_title);
    final TextView localTextView2 = (TextView)paramView.findViewById(a.f.mall_order_deployable_pref_content_summary);
    paramView = (LinearLayout)paramView.findViewById(a.f.mall_order_deployable_pref_content_container);
    localTextView1.setText(getTitle());
    if ((this.MGH == null) || (this.MGH.length <= 1)) {
      localTextView2.setTextColor(MGE);
    }
    for (;;)
    {
      localTextView2.setText(this.MGG);
      AppMethodBeat.o(66822);
      return;
      localTextView2.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66819);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/order/ui/preference/MallOrderDeployablePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          localTextView2.setVisibility(8);
          int i = 0;
          while (i < g.a(g.this).length)
          {
            paramAnonymousView = g.a(g.this, g.a(g.this)[i]);
            paramView.addView(paramAnonymousView, new LinearLayout.LayoutParams(-2, -2));
            i += 1;
          }
          localTextView2.setOnClickListener(null);
          if (g.b(g.this) != null) {
            g.b(g.this).notifyDataSetChanged();
          }
          a.a(this, "com/tencent/mm/plugin/order/ui/preference/MallOrderDeployablePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66819);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.g
 * JD-Core Version:    0.7.0.1
 */