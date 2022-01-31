package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.base.preference.Preference;

public final class f
  extends Preference
{
  private View.OnClickListener jFZ;
  private String kPW;
  private boolean kQa;
  private int mRq = 2147483647;
  private int mRr = -1;
  private int mRs = -1;
  private View mView = null;
  
  public f(Context paramContext)
  {
    super(paramContext);
    setLayoutResource(a.g.mall_order_common_pref);
  }
  
  public final void KL(String paramString)
  {
    try
    {
      this.mRq = Color.parseColor(paramString);
      return;
    }
    catch (Exception paramString)
    {
      this.mRq = 2147483647;
    }
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    this.kPW = paramString;
    this.kQa = true;
    this.mRr = paramInt1;
    this.mRs = paramInt2;
    this.jFZ = paramOnClickListener;
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
    Object localObject = (TextView)paramView.findViewById(a.f.mall_order_common_pref_title);
    paramView = (TextView)paramView.findViewById(a.f.mall_order_common_pref_content);
    ((TextView)localObject).setText(getTitle());
    if (this.mRq != 2147483647) {
      paramView.setTextColor(this.mRq);
    }
    if (this.kQa)
    {
      if ((this.mRr >= 0) && (this.mRs > 0))
      {
        localObject = new a(this.mContext);
        SpannableString localSpannableString = new SpannableString(this.kPW);
        ((a)localObject).mRJ = new f.1(this);
        paramView.setMovementMethod(LinkMovementMethod.getInstance());
        localSpannableString.setSpan(localObject, this.mRr, this.mRs, 33);
        paramView.setText(localSpannableString);
        return;
      }
      paramView.setTextColor(this.mContext.getResources().getColor(a.c.mall_link_color));
      paramView.setOnClickListener(this.jFZ);
      paramView.setText(j.a(this.mContext, this.kPW, paramView.getTextSize()));
      return;
    }
    paramView.setOnClickListener(null);
    paramView.setText(j.a(this.mContext, this.kPW, paramView.getTextSize()));
  }
  
  public final void setContent(String paramString)
  {
    this.kPW = paramString;
    this.kQa = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.f
 * JD-Core Version:    0.7.0.1
 */