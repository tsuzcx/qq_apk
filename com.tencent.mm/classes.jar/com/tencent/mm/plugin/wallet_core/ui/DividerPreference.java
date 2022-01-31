package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.preference.Preference;

public class DividerPreference
  extends Preference
{
  private boolean jts;
  private View mView;
  private boolean prQ;
  private boolean prR;
  
  public DividerPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DividerPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(47095);
    this.mView = null;
    this.prQ = false;
    this.prR = false;
    this.jts = true;
    setLayoutResource(2130969328);
    AppMethodBeat.o(47095);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(47096);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(47096);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(47097);
    super.onBindView(paramView);
    paramView = paramView.findViewById(2131823425);
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
          AppMethodBeat.o(47097);
          return;
        }
        paramView.setVisibility(0);
        AppMethodBeat.o(47097);
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.DividerPreference
 * JD-Core Version:    0.7.0.1
 */