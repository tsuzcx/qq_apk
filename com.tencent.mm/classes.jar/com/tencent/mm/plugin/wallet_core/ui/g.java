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
  private View iIW;
  public boolean mClickable;
  public String mContent;
  private View mView;
  public View.OnClickListener pgj;
  public int uqD;
  private int uqE;
  private int uqF;
  
  public g(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(70676);
    this.mView = null;
    this.uqD = 2147483647;
    this.uqE = -1;
    this.uqF = -1;
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
    this.iIW = paramView;
    if (this.uqD != 2147483647) {
      localTextView.setTextColor(this.uqD);
    }
    if (this.mClickable)
    {
      if ((this.uqE >= 0) && (this.uqF > 0))
      {
        paramView = new l(this.mContext);
        localObject = new SpannableString(this.mContent);
        paramView.Anf = new l.a()
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
        ((SpannableString)localObject).setSpan(paramView, this.uqE, this.uqF, 33);
        localTextView.setText((CharSequence)localObject);
        AppMethodBeat.o(70678);
        return;
      }
      if (this.uqD != 2147483647) {
        localTextView.setTextColor(this.uqD);
      }
      for (;;)
      {
        localTextView.setOnClickListener(this.pgj);
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