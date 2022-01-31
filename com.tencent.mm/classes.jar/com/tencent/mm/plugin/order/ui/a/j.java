package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends Preference
{
  List<MallOrderDetailObject.HelpCenter> mOA = new LinkedList();
  View.OnClickListener mOnClickListener = null;
  String mRH;
  View.OnClickListener mRI = null;
  private View mView = null;
  
  public j(Context paramContext)
  {
    super(paramContext);
    setLayoutResource(a.g.mall_order_multi_button_pref);
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
    paramView = (LinearLayout)paramView.findViewById(a.f.mall_order_multi_button);
    paramView.removeAllViews();
    if (this.mOA == null) {
      return;
    }
    int i;
    if ((!bk.bl(this.mRH)) && (this.mRI != null))
    {
      i = this.mOA.size();
      if (i != 0) {
        break label449;
      }
      i = -1;
    }
    label449:
    for (;;)
    {
      int j = 0;
      int k = 0;
      for (;;)
      {
        if (j < this.mOA.size())
        {
          localObject = (MallOrderDetailObject.HelpCenter)this.mOA.get(j);
          TextView localTextView = new TextView(this.mContext);
          localTextView.setTextColor(this.mContext.getResources().getColor(a.c.black));
          localTextView.setTextSize(0, a.aa(this.mContext, a.d.NormalTextSize));
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
            paramView.addView((View)localObject, new LinearLayout.LayoutParams(a.aa(this.mContext, a.d.DividerSmallHeight), -1));
          }
          k += 1;
          j += 1;
          continue;
          i = this.mOA.size() - 1;
          break;
        }
      }
      if ((bk.bl(this.mRH)) || (this.mRI == null)) {
        break;
      }
      Object localObject = new TextView(this.mContext);
      ((TextView)localObject).setTextColor(this.mContext.getResources().getColor(a.c.black));
      ((TextView)localObject).setTextSize(0, a.aa(this.mContext, a.d.NormalTextSize));
      ((TextView)localObject).setIncludeFontPadding(false);
      ((TextView)localObject).setText(this.mRH);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setOnClickListener(this.mRI);
      if (k == i) {
        ((TextView)localObject).setTextColor(this.mContext.getResources().getColor(a.c.green_text_color));
      }
      paramView.addView((View)localObject, new LinearLayout.LayoutParams(0, -2, 1.0F));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.j
 * JD-Core Version:    0.7.0.1
 */