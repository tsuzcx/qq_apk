package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class WalletBalancePrivacyCheckBoxPreference
  extends CheckBoxPreference
{
  private int HIJ;
  private String HIK;
  private int HIL;
  private View mView;
  boolean oD;
  private MMSwitchBtn sLW;
  
  public WalletBalancePrivacyCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WalletBalancePrivacyCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(214071);
    this.oD = false;
    this.HIJ = -1;
    this.HIK = "";
    this.HIL = 8;
    setLayoutResource(2131493189);
    AppMethodBeat.o(214071);
  }
  
  public final void aez(int paramInt) {}
  
  public final void fZ(String paramString, int paramInt) {}
  
  public final boolean isChecked()
  {
    if (this.sLW != null) {
      return this.sLW.QDw;
    }
    return this.oD;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(214073);
    super.onBindView(paramView);
    alO(8);
    this.sLW = ((MMSwitchBtn)paramView.findViewById(2131298639));
    this.sLW.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(214070);
        WalletBalancePrivacyCheckBoxPreference.a(WalletBalancePrivacyCheckBoxPreference.this, Boolean.valueOf(paramAnonymousBoolean));
        AppMethodBeat.o(214070);
      }
    });
    this.sLW.setCheck(this.oD);
    if (!isEnabled())
    {
      this.sLW.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(2131100283));
      ((TextView)paramView.findViewById(16908304)).setTextColor(paramView.getResources().getColor(2131100283));
    }
    paramView = paramView.findViewById(2131309322);
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    AppMethodBeat.o(214073);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(214072);
    this.mView = super.onCreateView(paramViewGroup);
    paramViewGroup = this.mView;
    AppMethodBeat.o(214072);
    return paramViewGroup;
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    this.oD = paramBoolean;
  }
  
  public final void xZ(boolean paramBoolean)
  {
    AppMethodBeat.i(214074);
    if (this.sLW != null)
    {
      this.oD = paramBoolean;
      this.sLW.setCheck(paramBoolean);
    }
    AppMethodBeat.o(214074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyCheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */