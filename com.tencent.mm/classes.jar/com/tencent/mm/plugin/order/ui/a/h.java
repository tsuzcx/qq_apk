package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.ui.base.preference.Preference;

public final class h
  extends Preference
{
  boolean AQN;
  boolean AQO;
  private View mView;
  boolean oAJ;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66824);
    this.mView = null;
    this.AQN = false;
    this.AQO = false;
    this.oAJ = true;
    setLayoutResource(2131495441);
    AppMethodBeat.o(66824);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66825);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(66825);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(66826);
    super.onBindView(paramView);
    paramView = paramView.findViewById(2131304381);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 10.0F);
    if (this.AQN) {}
    for (int j = i;; j = 0)
    {
      if (this.AQO) {}
      for (;;)
      {
        localLayoutParams.setMargins(0, j, 0, i);
        paramView.setLayoutParams(localLayoutParams);
        if (!this.oAJ)
        {
          paramView.setVisibility(4);
          AppMethodBeat.o(66826);
          return;
        }
        paramView.setVisibility(0);
        AppMethodBeat.o(66826);
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.h
 * JD-Core Version:    0.7.0.1
 */