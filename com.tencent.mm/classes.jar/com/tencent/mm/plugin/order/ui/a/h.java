package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.preference.Preference;

public final class h
  extends Preference
{
  boolean jts;
  private View mView;
  boolean prQ;
  boolean prR;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(43917);
    this.mView = null;
    this.prQ = false;
    this.prR = false;
    this.jts = true;
    setLayoutResource(2130970098);
    AppMethodBeat.o(43917);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(43918);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(43918);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(43919);
    super.onBindView(paramView);
    paramView = paramView.findViewById(2131825995);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    int i = BackwardSupportUtil.b.b(this.mContext, 10.0F);
    if (this.prQ) {}
    for (int j = i;; j = 0)
    {
      if (this.prR) {}
      for (;;)
      {
        localLayoutParams.setMargins(0, j, 0, i);
        paramView.setLayoutParams(localLayoutParams);
        if (!this.jts)
        {
          paramView.setVisibility(4);
          AppMethodBeat.o(43919);
          return;
        }
        paramView.setVisibility(0);
        AppMethodBeat.o(43919);
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.h
 * JD-Core Version:    0.7.0.1
 */