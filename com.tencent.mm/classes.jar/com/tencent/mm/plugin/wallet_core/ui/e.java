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

public final class e
  extends Preference
{
  public View.OnClickListener lPx;
  private View ldP;
  public String mContent;
  private View mView;
  public boolean nob;
  public int prD;
  private int prE;
  private int prF;
  
  public e(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(47126);
    this.mView = null;
    this.prD = 2147483647;
    this.prE = -1;
    this.prF = -1;
    setLayoutResource(2130969951);
    AppMethodBeat.o(47126);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(47127);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(47127);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(47128);
    super.onBindView(paramView);
    Object localObject = (TextView)paramView.findViewById(2131825329);
    TextView localTextView = (TextView)paramView.findViewById(2131825330);
    ((TextView)localObject).setText(getTitle());
    this.ldP = paramView;
    if (this.prD != 2147483647) {
      localTextView.setTextColor(this.prD);
    }
    if (this.nob)
    {
      if ((this.prE >= 0) && (this.prF > 0))
      {
        paramView = new j(this.mContext);
        localObject = new SpannableString(this.mContent);
        paramView.uqj = new e.1(this);
        localTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ((SpannableString)localObject).setSpan(paramView, this.prE, this.prF, 33);
        localTextView.setText((CharSequence)localObject);
        AppMethodBeat.o(47128);
        return;
      }
      if (this.prD != 2147483647) {
        localTextView.setTextColor(this.prD);
      }
      for (;;)
      {
        localTextView.setOnClickListener(this.lPx);
        localTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, this.mContent, localTextView.getTextSize()));
        AppMethodBeat.o(47128);
        return;
        localTextView.setTextColor(this.mContext.getResources().getColor(2131690267));
      }
    }
    localTextView.setOnClickListener(null);
    localTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, this.mContent, localTextView.getTextSize()));
    AppMethodBeat.o(47128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.e
 * JD-Core Version:    0.7.0.1
 */