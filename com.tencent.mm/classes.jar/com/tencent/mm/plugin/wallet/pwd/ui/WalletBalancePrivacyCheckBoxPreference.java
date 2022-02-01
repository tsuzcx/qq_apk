package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class WalletBalancePrivacyCheckBoxPreference
  extends CheckBoxPreference
{
  private int OAB;
  private String OAC;
  private int OAD;
  boolean bBh;
  private View mView;
  private MMSwitchBtn wrR;
  
  public WalletBalancePrivacyCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WalletBalancePrivacyCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(277224);
    this.bBh = false;
    this.OAB = -1;
    this.OAC = "";
    this.OAD = 8;
    setLayoutResource(com.tencent.mm.plugin.wxpay.a.g.balance_privacy_switchbtn_layout);
    AppMethodBeat.o(277224);
  }
  
  public final void BT(boolean paramBoolean)
  {
    AppMethodBeat.i(277231);
    if (this.wrR != null)
    {
      this.bBh = paramBoolean;
      this.wrR.setCheck(paramBoolean);
    }
    AppMethodBeat.o(277231);
  }
  
  public final void amm(int paramInt) {}
  
  public final void gI(String paramString, int paramInt) {}
  
  public final boolean isChecked()
  {
    if (this.wrR != null) {
      return this.wrR.YbZ;
    }
    return this.bBh;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(277227);
    super.onBindView(paramView);
    auO(8);
    this.wrR = ((MMSwitchBtn)paramView.findViewById(com.tencent.mm.ah.a.g.checkbox));
    this.wrR.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(188825);
        WalletBalancePrivacyCheckBoxPreference.a(WalletBalancePrivacyCheckBoxPreference.this, Boolean.valueOf(paramAnonymousBoolean));
        AppMethodBeat.o(188825);
      }
    });
    this.wrR.setCheck(this.bBh);
    if (!isEnabled())
    {
      this.wrR.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(a.d.disable_text_color));
      ((TextView)paramView.findViewById(16908304)).setTextColor(paramView.getResources().getColor(a.d.disable_text_color));
    }
    paramView = paramView.findViewById(a.f.top_line);
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    AppMethodBeat.o(277227);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(277225);
    this.mView = super.onCreateView(paramViewGroup);
    paramViewGroup = this.mView;
    AppMethodBeat.o(277225);
    return paramViewGroup;
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    this.bBh = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyCheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */