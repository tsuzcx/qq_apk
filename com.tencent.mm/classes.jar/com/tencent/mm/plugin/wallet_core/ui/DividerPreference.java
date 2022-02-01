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
  private View mView;
  private boolean mjw;
  private boolean uqQ;
  private boolean uqR;
  
  public DividerPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DividerPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(70645);
    this.mView = null;
    this.uqQ = false;
    this.uqR = false;
    this.mjw = true;
    setLayoutResource(2131493717);
    AppMethodBeat.o(70645);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(70646);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(70646);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(70647);
    super.onBindView(paramView);
    paramView = paramView.findViewById(2131299166);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    int i = BackwardSupportUtil.b.g(this.mContext, 10.0F);
    if (this.uqQ) {}
    for (int j = i;; j = 0)
    {
      if (this.uqR) {}
      for (;;)
      {
        localLayoutParams.setMargins(0, j, 0, i);
        paramView.setLayoutParams(localLayoutParams);
        if (!this.mjw)
        {
          paramView.setVisibility(4);
          AppMethodBeat.o(70647);
          return;
        }
        paramView.setVisibility(0);
        AppMethodBeat.o(70647);
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.DividerPreference
 * JD-Core Version:    0.7.0.1
 */