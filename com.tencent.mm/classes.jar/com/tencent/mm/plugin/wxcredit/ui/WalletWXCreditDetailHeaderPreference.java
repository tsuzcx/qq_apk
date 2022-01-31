package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletWXCreditDetailHeaderPreference
  extends Preference
{
  private LayoutInflater Lu;
  TextView eXt;
  TextView rRI;
  
  public WalletWXCreditDetailHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WalletWXCreditDetailHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.Lu = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    setLayoutResource(a.g.mm_preference);
  }
  
  public final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.eXt = ((TextView)paramView.findViewById(a.f.wallet_wxcredit_detail_left_amount));
    this.rRI = ((TextView)paramView.findViewById(a.f.wallet_wxcredit_update_tips));
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.f.content);
    localViewGroup.removeAllViews();
    this.Lu.inflate(a.g.wallet_wxcredit_detail_header_pref, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailHeaderPreference
 * JD-Core Version:    0.7.0.1
 */