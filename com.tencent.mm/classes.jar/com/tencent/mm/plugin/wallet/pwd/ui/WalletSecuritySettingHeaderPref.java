package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletSecuritySettingHeaderPref
  extends Preference
{
  private MMActivity imP;
  String pTa;
  private TextView snS;
  ImageView ubf;
  private TextView zUH;
  TextView zUI;
  String zUJ;
  String zUK;
  View.OnClickListener zUL;
  View.OnClickListener zUM;
  
  public WalletSecuritySettingHeaderPref(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(69786);
    this.imP = ((MMActivity)paramContext);
    AppMethodBeat.o(69786);
  }
  
  public WalletSecuritySettingHeaderPref(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69787);
    this.zUL = null;
    this.zUM = null;
    this.imP = ((MMActivity)paramContext);
    setLayoutResource(2131496023);
    AppMethodBeat.o(69787);
  }
  
  final void cE()
  {
    AppMethodBeat.i(69789);
    if ((!bt.isNullOrNil(this.pTa)) && (this.snS != null))
    {
      this.snS.setText(this.pTa);
      this.snS.setVisibility(0);
    }
    if ((!bt.isNullOrNil(this.zUJ)) && (this.zUH != null))
    {
      this.zUH.setText(this.zUJ);
      this.zUH.setVisibility(0);
    }
    if ((!bt.isNullOrNil(this.zUK)) && (this.zUI != null))
    {
      this.zUI.setText(this.zUK);
      this.zUI.setVisibility(0);
    }
    if ((bt.isNullOrNil(this.zUK)) && (this.zUI != null)) {
      this.zUI.setVisibility(8);
    }
    AppMethodBeat.o(69789);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69788);
    super.onBindView(paramView);
    ad.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo onBindView");
    this.snS = ((TextView)paramView.findViewById(2131301985));
    this.zUH = ((TextView)paramView.findViewById(2131298996));
    this.zUI = ((TextView)paramView.findViewById(2131299065));
    this.ubf = ((ImageView)paramView.findViewById(2131306831));
    cE();
    if ((this.zUI != null) && (this.zUL != null)) {
      this.zUI.setOnClickListener(this.zUL);
    }
    if ((this.ubf != null) && (this.zUM != null)) {
      this.ubf.setOnClickListener(this.zUM);
    }
    AppMethodBeat.o(69788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingHeaderPref
 * JD-Core Version:    0.7.0.1
 */