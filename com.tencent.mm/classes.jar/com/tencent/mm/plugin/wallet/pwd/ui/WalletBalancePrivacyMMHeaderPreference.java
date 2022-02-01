package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.r.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Map;

public class WalletBalancePrivacyMMHeaderPreference
  extends Preference
{
  String dEM;
  private int mdM;
  String title;
  Map<String, r.a> ylg;
  
  public WalletBalancePrivacyMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(69588);
    this.ylg = new HashMap();
    AppMethodBeat.o(69588);
  }
  
  public WalletBalancePrivacyMMHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69587);
    this.ylg = new HashMap();
    AppMethodBeat.o(69587);
  }
  
  public final void gk()
  {
    this.mdM = 2131689519;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69589);
    super.onBindView(paramView);
    paramView.findViewById(2131297104);
    paramView = (TextView)paramView.findViewById(2131297105);
    if (!bu.isNullOrNil(this.title)) {
      paramView.setText(this.title);
    }
    al.a(paramView.getPaint(), 0.8F);
    AppMethodBeat.o(69589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyMMHeaderPreference
 * JD-Core Version:    0.7.0.1
 */