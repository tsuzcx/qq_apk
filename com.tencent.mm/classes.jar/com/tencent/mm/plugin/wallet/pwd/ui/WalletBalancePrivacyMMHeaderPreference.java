package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.s.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Map;

public class WalletBalancePrivacyMMHeaderPreference
  extends Preference
{
  Map<String, s.a> OfK;
  String icon;
  String title;
  private int tus;
  
  public WalletBalancePrivacyMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(69588);
    this.OfK = new HashMap();
    AppMethodBeat.o(69588);
  }
  
  public WalletBalancePrivacyMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69587);
    this.OfK = new HashMap();
    AppMethodBeat.o(69587);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69589);
    super.onBindView(paramView);
    paramView.findViewById(a.f.balance_privacy_icon_iv);
    paramView = (TextView)paramView.findViewById(a.f.balance_privacy_title_tv);
    if (!Util.isNullOrNil(this.title)) {
      paramView.setText(this.title);
    }
    aw.a(paramView.getPaint(), 0.8F);
    AppMethodBeat.o(69589);
  }
  
  public final void setIcon(int paramInt)
  {
    this.tus = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyMMHeaderPreference
 * JD-Core Version:    0.7.0.1
 */