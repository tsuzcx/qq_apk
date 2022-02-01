package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletWXCreditDetailFooterPreference
  extends Preference
  implements View.OnClickListener
{
  private TextView Ddq;
  private TextView Ddr;
  private LayoutInflater mInflater;
  View.OnClickListener uWS;
  
  public WalletWXCreditDetailFooterPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WalletWXCreditDetailFooterPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(72357);
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    setLayoutResource(2131494804);
    AppMethodBeat.o(72357);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(72359);
    super.onBindView(paramView);
    this.Ddq = ((TextView)paramView.findViewById(2131306854));
    this.Ddr = ((TextView)paramView.findViewById(2131306852));
    this.Ddq.setOnClickListener(this);
    this.Ddr.setOnClickListener(this);
    AppMethodBeat.o(72359);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(72360);
    if (this.uWS != null) {
      this.uWS.onClick(paramView);
    }
    AppMethodBeat.o(72360);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(72358);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    this.mInflater.inflate(2131496046, localViewGroup);
    AppMethodBeat.o(72358);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailFooterPreference
 * JD-Core Version:    0.7.0.1
 */