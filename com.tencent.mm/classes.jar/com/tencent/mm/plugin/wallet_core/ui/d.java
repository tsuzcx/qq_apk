package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.base.preference.Preference;

public final class d
  extends Preference
{
  private View iUL;
  public View.OnClickListener jFZ;
  public String kPW;
  public boolean kQa;
  public int mRq = 2147483647;
  private int mRr = -1;
  private int mRs = -1;
  private View mView = null;
  
  public d(Context paramContext)
  {
    super(paramContext, null);
    setLayoutResource(a.g.key_value_preference);
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
    Object localObject = (TextView)paramView.findViewById(a.f.key_pref_tv);
    TextView localTextView = (TextView)paramView.findViewById(a.f.value_pref_tv);
    ((TextView)localObject).setText(getTitle());
    this.iUL = paramView;
    if (this.mRq != 2147483647) {
      localTextView.setTextColor(this.mRq);
    }
    if (this.kQa)
    {
      if ((this.mRr >= 0) && (this.mRs > 0))
      {
        paramView = new h(this.mContext);
        localObject = new SpannableString(this.kPW);
        paramView.qDo = new d.1(this);
        localTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ((SpannableString)localObject).setSpan(paramView, this.mRr, this.mRs, 33);
        localTextView.setText((CharSequence)localObject);
        return;
      }
      if (this.mRq != 2147483647) {
        localTextView.setTextColor(this.mRq);
      }
      for (;;)
      {
        localTextView.setOnClickListener(this.jFZ);
        localTextView.setText(j.a(this.mContext, this.kPW, localTextView.getTextSize()));
        return;
        localTextView.setTextColor(this.mContext.getResources().getColor(a.c.mall_link_color));
      }
    }
    localTextView.setOnClickListener(null);
    localTextView.setText(j.a(this.mContext, this.kPW, localTextView.getTextSize()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.d
 * JD-Core Version:    0.7.0.1
 */