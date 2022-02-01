package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class WalletBalancePrivacyCheckBoxPreference
  extends CheckBoxPreference
{
  private int VpO;
  private String VpP;
  private int VpQ;
  boolean duj;
  private View mView;
  private MMSwitchBtn zNX;
  
  public WalletBalancePrivacyCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WalletBalancePrivacyCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(315611);
    this.duj = false;
    this.VpO = -1;
    this.VpP = "";
    this.VpQ = 8;
    setLayoutResource(com.tencent.mm.plugin.wxpay.a.g.balance_privacy_switchbtn_layout);
    AppMethodBeat.o(315611);
  }
  
  public final void Hy(boolean paramBoolean)
  {
    AppMethodBeat.i(315626);
    if (this.zNX != null)
    {
      this.duj = paramBoolean;
      this.zNX.setCheck(paramBoolean);
    }
    AppMethodBeat.o(315626);
  }
  
  public final void arW(int paramInt) {}
  
  public final int getLayoutId()
  {
    return com.tencent.mm.plugin.wxpay.a.g.balance_privacy_switchbtn_layout;
  }
  
  public final void hF(String paramString, int paramInt) {}
  
  public final boolean isChecked()
  {
    if (this.zNX != null) {
      return this.zNX.afTT;
    }
    return this.duj;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(315621);
    super.onBindView(paramView);
    aBq(8);
    this.zNX = ((MMSwitchBtn)paramView.findViewById(com.tencent.mm.ah.a.g.checkbox));
    this.zNX.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(315675);
        WalletBalancePrivacyCheckBoxPreference.a(WalletBalancePrivacyCheckBoxPreference.this, Boolean.valueOf(paramAnonymousBoolean));
        AppMethodBeat.o(315675);
      }
    });
    this.zNX.setCheck(this.duj);
    if (!isEnabled())
    {
      this.zNX.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(a.d.disable_text_color));
      ((TextView)paramView.findViewById(16908304)).setTextColor(paramView.getResources().getColor(a.d.disable_text_color));
    }
    AppMethodBeat.o(315621);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(315618);
    this.mView = super.onCreateView(paramViewGroup);
    paramViewGroup = this.mView;
    AppMethodBeat.o(315618);
    return paramViewGroup;
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    this.duj = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyCheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */