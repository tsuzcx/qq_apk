package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletWXCreditDetailHeaderPreference
  extends Preference
{
  TextView Dds;
  TextView iBN;
  private LayoutInflater mInflater;
  
  public WalletWXCreditDetailHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WalletWXCreditDetailHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(72361);
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    setLayoutResource(2131494804);
    AppMethodBeat.o(72361);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(72363);
    super.onBindView(paramView);
    this.iBN = ((TextView)paramView.findViewById(2131306853));
    this.Dds = ((TextView)paramView.findViewById(2131306860));
    AppMethodBeat.o(72363);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(72362);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    this.mInflater.inflate(2131496047, localViewGroup);
    AppMethodBeat.o(72362);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailHeaderPreference
 * JD-Core Version:    0.7.0.1
 */