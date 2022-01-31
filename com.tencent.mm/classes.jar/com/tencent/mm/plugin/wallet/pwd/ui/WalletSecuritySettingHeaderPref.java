package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletSecuritySettingHeaderPref
  extends Preference
{
  private MMActivity cmc;
  private TextView iUs;
  String mmp;
  ImageView pdI;
  private TextView uaf;
  TextView uag;
  String uah;
  String uai;
  View.OnClickListener uaj;
  View.OnClickListener uak;
  
  public WalletSecuritySettingHeaderPref(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(46389);
    this.cmc = ((MMActivity)paramContext);
    AppMethodBeat.o(46389);
  }
  
  public WalletSecuritySettingHeaderPref(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(46390);
    this.uaj = null;
    this.uak = null;
    this.cmc = ((MMActivity)paramContext);
    setLayoutResource(2130971246);
    AppMethodBeat.o(46390);
  }
  
  final void bJ()
  {
    AppMethodBeat.i(46392);
    if ((!bo.isNullOrNil(this.mmp)) && (this.iUs != null))
    {
      this.iUs.setText(this.mmp);
      this.iUs.setVisibility(0);
    }
    if ((!bo.isNullOrNil(this.uah)) && (this.uaf != null))
    {
      this.uaf.setText(this.uah);
      this.uaf.setVisibility(0);
    }
    if ((!bo.isNullOrNil(this.uai)) && (this.uag != null))
    {
      this.uag.setText(this.uai);
      this.uag.setVisibility(0);
    }
    if ((bo.isNullOrNil(this.uai)) && (this.uag != null)) {
      this.uag.setVisibility(8);
    }
    AppMethodBeat.o(46392);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(46391);
    super.onBindView(paramView);
    ab.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo onBindView");
    this.iUs = ((TextView)paramView.findViewById(2131824647));
    this.uaf = ((TextView)paramView.findViewById(2131821115));
    this.uag = ((TextView)paramView.findViewById(2131829388));
    this.pdI = ((ImageView)paramView.findViewById(2131829387));
    bJ();
    if ((this.uag != null) && (this.uaj != null)) {
      this.uag.setOnClickListener(this.uaj);
    }
    if ((this.pdI != null) && (this.uak != null)) {
      this.pdI.setOnClickListener(this.uak);
    }
    AppMethodBeat.o(46391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingHeaderPref
 * JD-Core Version:    0.7.0.1
 */