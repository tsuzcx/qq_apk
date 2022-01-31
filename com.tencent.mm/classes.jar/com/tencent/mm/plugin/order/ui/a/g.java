package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class g
  extends Preference
{
  private static int prH;
  private static float prI = 16.0F;
  f iLA;
  private View mView;
  String prJ;
  private String[] prK;
  private TextUtils.TruncateAt prL;
  private boolean prM;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(43913);
    this.mView = null;
    this.prM = false;
    setLayoutResource(2130970096);
    prH = paramContext.getResources().getColor(2131690274);
    AppMethodBeat.o(43913);
  }
  
  public final void a(String[] paramArrayOfString, TextUtils.TruncateAt paramTruncateAt)
  {
    this.prK = paramArrayOfString;
    this.prL = paramTruncateAt;
    this.prM = true;
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(43914);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(43914);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(43915);
    super.onBindView(paramView);
    TextView localTextView1 = (TextView)paramView.findViewById(2131825979);
    TextView localTextView2 = (TextView)paramView.findViewById(2131825981);
    paramView = (LinearLayout)paramView.findViewById(2131825980);
    localTextView1.setText(getTitle());
    if ((this.prK == null) || (this.prK.length <= 1)) {
      localTextView2.setTextColor(prH);
    }
    for (;;)
    {
      localTextView2.setText(this.prJ);
      AppMethodBeat.o(43915);
      return;
      localTextView2.setOnClickListener(new g.1(this, localTextView2, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.g
 * JD-Core Version:    0.7.0.1
 */