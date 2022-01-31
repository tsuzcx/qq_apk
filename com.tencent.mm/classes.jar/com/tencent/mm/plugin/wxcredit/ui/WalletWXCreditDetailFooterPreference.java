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
  private LayoutInflater mInflater;
  View.OnClickListener qMg;
  private TextView vIw;
  private TextView vIx;
  
  public WalletWXCreditDetailFooterPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WalletWXCreditDetailFooterPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(48713);
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    setLayoutResource(2130970179);
    AppMethodBeat.o(48713);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(48715);
    super.onBindView(paramView);
    this.vIw = ((TextView)paramView.findViewById(2131829429));
    this.vIx = ((TextView)paramView.findViewById(2131829430));
    this.vIw.setOnClickListener(this);
    this.vIx.setOnClickListener(this);
    AppMethodBeat.o(48715);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(48716);
    if (this.qMg != null) {
      this.qMg.onClick(paramView);
    }
    AppMethodBeat.o(48716);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(48714);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    this.mInflater.inflate(2130971269, localViewGroup);
    AppMethodBeat.o(48714);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailFooterPreference
 * JD-Core Version:    0.7.0.1
 */