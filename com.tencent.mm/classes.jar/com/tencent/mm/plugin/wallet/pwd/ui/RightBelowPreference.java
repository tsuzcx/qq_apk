package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SummaryBelowPreference;

public class RightBelowPreference
  extends SummaryBelowPreference
{
  private CharSequence VpN;
  
  public RightBelowPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RightBelowPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void at(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(69585);
    this.VpN = paramCharSequence;
    notifyChanged();
    AppMethodBeat.o(69585);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69584);
    super.onBindView(paramView);
    if (!Util.isNullOrNil(this.VpN)) {
      ((TextView)paramView.findViewById(a.f.right_desc_tv)).setText(this.VpN);
    }
    paramView.findViewById(a.f.right_arrow).setVisibility(8);
    AppMethodBeat.o(69584);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(69583);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ((ViewGroup)((ViewGroup)paramViewGroup.findViewById(a.f.content)).findViewById(16908312)).addView((ViewGroup)View.inflate(this.mContext, a.g.wallet_pref_right_desc_layout, null));
    AppMethodBeat.o(69583);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.RightBelowPreference
 * JD-Core Version:    0.7.0.1
 */