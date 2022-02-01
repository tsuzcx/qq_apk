package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.ui.base.preference.Preference;

public final class i
  extends Preference
{
  private int AQP;
  String AQQ;
  private View mView;
  
  public i(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66827);
    this.mView = null;
    this.AQP = 2147483647;
    setLayoutResource(2131495442);
    AppMethodBeat.o(66827);
  }
  
  public final void aJH(String paramString)
  {
    AppMethodBeat.i(66830);
    try
    {
      this.AQP = g.cI(paramString, true);
      AppMethodBeat.o(66830);
      return;
    }
    catch (Exception paramString)
    {
      this.AQP = -1;
      AppMethodBeat.o(66830);
    }
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66828);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(66828);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(66829);
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(2131304383);
    paramView = (TextView)paramView.findViewById(2131304382);
    localTextView.setText(getTitle());
    paramView.setText(this.AQQ);
    if (this.AQP != 2147483647) {
      paramView.setTextColor(this.AQP);
    }
    AppMethodBeat.o(66829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.i
 * JD-Core Version:    0.7.0.1
 */