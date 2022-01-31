package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SummaryBelowPreference;

public class RightBelowPreference
  extends SummaryBelowPreference
{
  private CharSequence tYm;
  
  public RightBelowPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RightBelowPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void J(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(46206);
    this.tYm = paramCharSequence;
    notifyChanged();
    AppMethodBeat.o(46206);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(46205);
    super.onBindView(paramView);
    if (!bo.aa(this.tYm)) {
      ((TextView)paramView.findViewById(2131829355)).setText(this.tYm);
    }
    paramView.findViewById(2131821555).setVisibility(8);
    AppMethodBeat.o(46205);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(46204);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ((ViewGroup)((ViewGroup)paramViewGroup.findViewById(2131820946)).findViewById(16908312)).addView((ViewGroup)View.inflate(this.mContext, 2130971236, null));
    AppMethodBeat.o(46204);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.RightBelowPreference
 * JD-Core Version:    0.7.0.1
 */