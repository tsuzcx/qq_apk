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
import com.tencent.mm.ui.base.preference.Preference;

public final class g
  extends Preference
{
  public int AQA;
  private int AQB;
  private int AQC;
  public View.OnClickListener hEZ;
  private View kHq;
  public boolean mClickable;
  public String mContent;
  private View mView;
  
  public g(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(70676);
    this.mView = null;
    this.AQA = 2147483647;
    this.AQB = -1;
    this.AQC = -1;
    setLayoutResource(2131495127);
    AppMethodBeat.o(70676);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
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
    Object localObject = (TextView)paramView.findViewById(2131302945);
    TextView localTextView = (TextView)paramView.findViewById(2131309675);
    ((TextView)localObject).setText(getTitle());
    this.kHq = paramView;
    if (this.AQA != 2147483647) {
      localTextView.setTextColor(this.AQA);
    }
    if (this.mClickable)
    {
      if ((this.AQB >= 0) && (this.AQC > 0))
      {
        paramView = new l(this.mContext);
        localObject = new SpannableString(this.mContent);
        paramView.IgH = new l.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70675);
            if (g.a(g.this) != null) {
              g.a(g.this).onClick(paramAnonymousView);
            }
            AppMethodBeat.o(70675);
          }
        };
        localTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ((SpannableString)localObject).setSpan(paramView, this.AQB, this.AQC, 33);
        localTextView.setText((CharSequence)localObject);
        AppMethodBeat.o(70678);
        return;
      }
      if (this.AQA != 2147483647) {
        localTextView.setTextColor(this.AQA);
      }
      for (;;)
      {
        localTextView.setOnClickListener(this.hEZ);
        localTextView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, this.mContent, localTextView.getTextSize()));
        AppMethodBeat.o(70678);
        return;
        localTextView.setTextColor(this.mContext.getResources().getColor(2131100775));
      }
    }
    localTextView.setOnClickListener(null);
    localTextView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, this.mContent, localTextView.getTextSize()));
    AppMethodBeat.o(70678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.g
 * JD-Core Version:    0.7.0.1
 */