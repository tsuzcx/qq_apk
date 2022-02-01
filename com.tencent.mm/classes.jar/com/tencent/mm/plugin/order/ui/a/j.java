package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends Preference
{
  List<MallOrderDetailObject.HelpCenter> GHa;
  String GKc;
  View.OnClickListener GKd;
  View.OnClickListener mOnClickListener;
  private View mView;
  
  public j(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66831);
    this.mView = null;
    this.mOnClickListener = null;
    this.GKd = null;
    this.GHa = new LinkedList();
    setLayoutResource(a.g.mall_order_multi_button_pref);
    AppMethodBeat.o(66831);
  }
  
  public final View c(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66832);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(66832);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(66833);
    super.onBindView(paramView);
    paramView = (LinearLayout)paramView.findViewById(a.f.mall_order_multi_button);
    paramView.removeAllViews();
    if (this.GHa == null)
    {
      AppMethodBeat.o(66833);
      return;
    }
    int i;
    if ((!Util.isNullOrNil(this.GKc)) && (this.GKd != null))
    {
      i = this.GHa.size();
      if (i != 0) {
        break label464;
      }
      i = -1;
    }
    label464:
    for (;;)
    {
      int j = 0;
      int k = 0;
      Object localObject;
      for (;;)
      {
        if (j < this.GHa.size())
        {
          localObject = (MallOrderDetailObject.HelpCenter)this.GHa.get(j);
          TextView localTextView = new TextView(this.mContext);
          localTextView.setTextColor(this.mContext.getResources().getColor(a.c.normal_text_color));
          localTextView.setTextSize(0, a.aY(this.mContext, a.d.NormalTextSize));
          localTextView.setIncludeFontPadding(false);
          localTextView.setText(((MallOrderDetailObject.HelpCenter)localObject).name);
          localTextView.setTag(localObject);
          localTextView.setGravity(17);
          localTextView.setOnClickListener(this.mOnClickListener);
          if (k == i) {
            localTextView.setTextColor(this.mContext.getResources().getColor(a.c.green_text_color));
          }
          paramView.addView(localTextView, new LinearLayout.LayoutParams(0, -2, 1.0F));
          if (k < i)
          {
            localObject = new View(this.mContext);
            ((View)localObject).setBackgroundColor(this.mContext.getResources().getColor(a.c.small_line_color));
            paramView.addView((View)localObject, new LinearLayout.LayoutParams(a.aY(this.mContext, a.d.DividerSmallHeight), -1));
          }
          k += 1;
          j += 1;
          continue;
          i = this.GHa.size() - 1;
          break;
        }
      }
      if ((!Util.isNullOrNil(this.GKc)) && (this.GKd != null))
      {
        localObject = new TextView(this.mContext);
        ((TextView)localObject).setTextColor(this.mContext.getResources().getColor(a.c.normal_text_color));
        ((TextView)localObject).setTextSize(0, a.aY(this.mContext, a.d.NormalTextSize));
        ((TextView)localObject).setIncludeFontPadding(false);
        ((TextView)localObject).setText(this.GKc);
        ((TextView)localObject).setGravity(17);
        ((TextView)localObject).setOnClickListener(this.GKd);
        if (k == i) {
          ((TextView)localObject).setTextColor(this.mContext.getResources().getColor(a.c.green_text_color));
        }
        paramView.addView((View)localObject, new LinearLayout.LayoutParams(0, -2, 1.0F));
      }
      AppMethodBeat.o(66833);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.j
 * JD-Core Version:    0.7.0.1
 */