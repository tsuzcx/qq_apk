package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.ui.base.preference.Preference;

public final class i
  extends Preference
{
  public int MGA;
  private int MGB;
  private int MGC;
  public boolean mClickable;
  public String mContent;
  private View mView;
  public View.OnClickListener mWW;
  private View qAv;
  
  public i(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(70676);
    this.mView = null;
    this.MGA = 2147483647;
    this.MGB = -1;
    this.MGC = -1;
    setLayoutResource(a.g.key_value_preference);
    AppMethodBeat.o(70676);
  }
  
  public final View b(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(70677);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(70677);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(70678);
    super.onBindView(paramView);
    Object localObject = (TextView)paramView.findViewById(a.f.key_pref_tv);
    TextView localTextView = (TextView)paramView.findViewById(a.f.value_pref_tv);
    ((TextView)localObject).setText(getTitle());
    this.qAv = paramView;
    if (this.MGA != 2147483647) {
      localTextView.setTextColor(this.MGA);
    }
    if (this.mClickable)
    {
      if ((this.MGB >= 0) && (this.MGC > 0))
      {
        paramView = new n(this.mContext);
        localObject = new SpannableString(this.mContent);
        paramView.VPb = new n.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70675);
            if (i.a(i.this) != null) {
              i.a(i.this).onClick(paramAnonymousView);
            }
            AppMethodBeat.o(70675);
          }
        };
        localTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ((SpannableString)localObject).setSpan(paramView, this.MGB, this.MGC, 33);
        localTextView.setText((CharSequence)localObject);
        AppMethodBeat.o(70678);
        return;
      }
      if (this.MGA != 2147483647) {
        localTextView.setTextColor(this.MGA);
      }
      for (;;)
      {
        localTextView.setOnClickListener(this.mWW);
        localTextView.setText(p.b(this.mContext, this.mContent, localTextView.getTextSize()));
        AppMethodBeat.o(70678);
        return;
        localTextView.setTextColor(this.mContext.getResources().getColor(a.c.mall_link_color));
      }
    }
    localTextView.setOnClickListener(null);
    localTextView.setText(p.b(this.mContext, this.mContent, localTextView.getTextSize()));
    AppMethodBeat.o(70678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.i
 * JD-Core Version:    0.7.0.1
 */