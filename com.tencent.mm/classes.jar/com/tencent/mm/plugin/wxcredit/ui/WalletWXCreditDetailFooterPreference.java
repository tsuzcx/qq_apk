package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletWXCreditDetailFooterPreference
  extends Preference
  implements View.OnClickListener
{
  private LayoutInflater Lu;
  View.OnClickListener nXW;
  private TextView rRG;
  private TextView rRH;
  
  public WalletWXCreditDetailFooterPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WalletWXCreditDetailFooterPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.Lu = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    setLayoutResource(a.g.mm_preference);
  }
  
  public final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.rRG = ((TextView)paramView.findViewById(a.f.wallet_wxcredit_detail_username_tv));
    this.rRH = ((TextView)paramView.findViewById(a.f.wallet_wxcredit_detail_help_tv));
    this.rRG.setOnClickListener(this);
    this.rRH.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (this.nXW != null) {
      this.nXW.onClick(paramView);
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.f.content);
    localViewGroup.removeAllViews();
    this.Lu.inflate(a.g.wallet_wxcredit_detail_footer_pref, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailFooterPreference
 * JD-Core Version:    0.7.0.1
 */