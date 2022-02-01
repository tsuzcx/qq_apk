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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.ui.base.preference.Preference;

public final class h
  extends Preference
{
  public int GJL;
  private int GJM;
  private int GJN;
  public View.OnClickListener kte;
  public boolean mClickable;
  public String mContent;
  private View mView;
  private View nBk;
  
  public h(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(70676);
    this.mView = null;
    this.GJL = 2147483647;
    this.GJM = -1;
    this.GJN = -1;
    setLayoutResource(a.g.key_value_preference);
    AppMethodBeat.o(70676);
  }
  
  public final View c(View paramView, ViewGroup paramViewGroup)
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
    this.nBk = paramView;
    if (this.GJL != 2147483647) {
      localTextView.setTextColor(this.GJL);
    }
    if (this.mClickable)
    {
      if ((this.GJM >= 0) && (this.GJN > 0))
      {
        paramView = new m(this.mContext);
        localObject = new SpannableString(this.mContent);
        paramView.OYN = new m.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70675);
            if (h.a(h.this) != null) {
              h.a(h.this).onClick(paramAnonymousView);
            }
            AppMethodBeat.o(70675);
          }
        };
        localTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ((SpannableString)localObject).setSpan(paramView, this.GJM, this.GJN, 33);
        localTextView.setText((CharSequence)localObject);
        AppMethodBeat.o(70678);
        return;
      }
      if (this.GJL != 2147483647) {
        localTextView.setTextColor(this.GJL);
      }
      for (;;)
      {
        localTextView.setOnClickListener(this.kte);
        localTextView.setText(l.b(this.mContext, this.mContent, localTextView.getTextSize()));
        AppMethodBeat.o(70678);
        return;
        localTextView.setTextColor(this.mContext.getResources().getColor(a.c.mall_link_color));
      }
    }
    localTextView.setOnClickListener(null);
    localTextView.setText(l.b(this.mContext, this.mContent, localTextView.getTextSize()));
    AppMethodBeat.o(70678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.h
 * JD-Core Version:    0.7.0.1
 */