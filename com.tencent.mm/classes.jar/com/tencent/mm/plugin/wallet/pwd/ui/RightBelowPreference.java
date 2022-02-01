package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SummaryBelowPreference;

public class RightBelowPreference
  extends SummaryBelowPreference
{
  private CharSequence HII;
  
  public RightBelowPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RightBelowPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void S(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(69585);
    this.HII = paramCharSequence;
    notifyChanged();
    AppMethodBeat.o(69585);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69584);
    super.onBindView(paramView);
    if (!Util.isNullOrNil(this.HII)) {
      ((TextView)paramView.findViewById(2131307092)).setText(this.HII);
    }
    paramView.findViewById(2131307076).setVisibility(8);
    AppMethodBeat.o(69584);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(69583);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ((ViewGroup)((ViewGroup)paramViewGroup.findViewById(2131299180)).findViewById(16908312)).addView((ViewGroup)View.inflate(this.mContext, 2131496993, null));
    AppMethodBeat.o(69583);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.RightBelowPreference
 * JD-Core Version:    0.7.0.1
 */