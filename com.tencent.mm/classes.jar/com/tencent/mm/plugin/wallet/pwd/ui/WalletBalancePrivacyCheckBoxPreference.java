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
  private int DcV;
  private String DcW;
  private int DcX;
  private View mView;
  boolean oB;
  private MMSwitchBtn rkq;
  
  public WalletBalancePrivacyCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WalletBalancePrivacyCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(190148);
    this.oB = false;
    this.DcV = -1;
    this.DcW = "";
    this.DcX = 8;
    setLayoutResource(2131496510);
    AppMethodBeat.o(190148);
  }
  
  public final void VX(int paramInt) {}
  
  public final void fw(String paramString, int paramInt) {}
  
  public final boolean isChecked()
  {
    if (this.rkq != null) {
      return this.rkq.Lon;
    }
    return this.oB;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(190150);
    super.onBindView(paramView);
    ade(8);
    this.rkq = ((MMSwitchBtn)paramView.findViewById(2131298255));
    this.rkq.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(190147);
        WalletBalancePrivacyCheckBoxPreference.a(WalletBalancePrivacyCheckBoxPreference.this, Boolean.valueOf(paramAnonymousBoolean));
        AppMethodBeat.o(190147);
      }
    });
    this.rkq.setCheck(this.oB);
    if (!isEnabled())
    {
      this.rkq.setEnabled(false);
      ((TextView)paramView.findViewById(16908310)).setTextColor(paramView.getResources().getColor(2131100249));
      ((TextView)paramView.findViewById(16908304)).setTextColor(paramView.getResources().getColor(2131100249));
    }
    paramView = paramView.findViewById(2131306012);
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    AppMethodBeat.o(190150);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(190149);
    this.mView = super.onCreateView(paramViewGroup);
    paramViewGroup = this.mView;
    AppMethodBeat.o(190149);
    return paramViewGroup;
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    this.oB = paramBoolean;
  }
  
  public final void uo(boolean paramBoolean)
  {
    AppMethodBeat.i(190151);
    if (this.rkq != null)
    {
      this.oB = paramBoolean;
      this.rkq.setCheck(paramBoolean);
    }
    AppMethodBeat.o(190151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyCheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */