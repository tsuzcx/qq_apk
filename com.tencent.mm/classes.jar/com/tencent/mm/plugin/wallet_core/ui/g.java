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
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.ui.base.preference.Preference;

public final class g
  extends Preference
{
  public View.OnClickListener gMe;
  private View jCI;
  public boolean mClickable;
  public String mContent;
  private View mView;
  public int wET;
  private int wEU;
  private int wEV;
  
  public g(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(70676);
    this.mView = null;
    this.wET = 2147483647;
    this.wEU = -1;
    this.wEV = -1;
    setLayoutResource(2131494531);
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
    Object localObject = (TextView)paramView.findViewById(2131301249);
    TextView localTextView = (TextView)paramView.findViewById(2131306264);
    ((TextView)localObject).setText(getTitle());
    this.jCI = paramView;
    if (this.wET != 2147483647) {
      localTextView.setTextColor(this.wET);
    }
    if (this.mClickable)
    {
      if ((this.wEU >= 0) && (this.wEV > 0))
      {
        paramView = new l(this.mContext);
        localObject = new SpannableString(this.mContent);
        paramView.DfS = new l.a()
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
        ((SpannableString)localObject).setSpan(paramView, this.wEU, this.wEV, 33);
        localTextView.setText((CharSequence)localObject);
        AppMethodBeat.o(70678);
        return;
      }
      if (this.wET != 2147483647) {
        localTextView.setTextColor(this.wET);
      }
      for (;;)
      {
        localTextView.setOnClickListener(this.gMe);
        localTextView.setText(k.b(this.mContext, this.mContent, localTextView.getTextSize()));
        AppMethodBeat.o(70678);
        return;
        localTextView.setTextColor(this.mContext.getResources().getColor(2131100607));
      }
    }
    localTextView.setOnClickListener(null);
    localTextView.setText(k.b(this.mContext, this.mContent, localTextView.getTextSize()));
    AppMethodBeat.o(70678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.g
 * JD-Core Version:    0.7.0.1
 */