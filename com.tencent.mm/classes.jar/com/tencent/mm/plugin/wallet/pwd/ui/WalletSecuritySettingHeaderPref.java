package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletSecuritySettingHeaderPref
  extends Preference
{
  private TextView OCN;
  TextView OCO;
  String OCP;
  String OCQ;
  View.OnClickListener OCR;
  View.OnClickListener OCS;
  private MMActivity iXq;
  ImageView kHA;
  String wAb;
  private TextView wXS;
  
  public WalletSecuritySettingHeaderPref(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(69786);
    this.iXq = ((MMActivity)paramContext);
    AppMethodBeat.o(69786);
  }
  
  public WalletSecuritySettingHeaderPref(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69787);
    this.OCR = null;
    this.OCS = null;
    this.iXq = ((MMActivity)paramContext);
    setLayoutResource(a.g.wallet_security_header_pref);
    AppMethodBeat.o(69787);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69788);
    super.onBindView(paramView);
    Log.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo onBindView");
    this.wXS = ((TextView)paramView.findViewById(a.f.main_content));
    ar.a(this.wXS.getPaint(), 0.8F);
    this.OCN = ((TextView)paramView.findViewById(a.f.desc));
    this.OCO = ((TextView)paramView.findViewById(a.f.details_text));
    this.kHA = ((ImageView)paramView.findViewById(a.f.wallet_security_close_btn));
    updateView();
    if ((this.OCO != null) && (this.OCR != null)) {
      this.OCO.setOnClickListener(this.OCR);
    }
    if ((this.kHA != null) && (this.OCS != null)) {
      this.kHA.setOnClickListener(this.OCS);
    }
    AppMethodBeat.o(69788);
  }
  
  final void updateView()
  {
    AppMethodBeat.i(69789);
    if ((!Util.isNullOrNil(this.wAb)) && (this.wXS != null))
    {
      this.wXS.setText(this.wAb);
      this.wXS.setVisibility(0);
    }
    if ((!Util.isNullOrNil(this.OCP)) && (this.OCN != null))
    {
      this.OCN.setText(this.OCP);
      this.OCN.setVisibility(0);
    }
    if ((!Util.isNullOrNil(this.OCQ)) && (this.OCO != null))
    {
      this.OCO.setText(this.OCQ);
      this.OCO.setVisibility(0);
    }
    if ((Util.isNullOrNil(this.OCQ)) && (this.OCO != null)) {
      this.OCO.setVisibility(8);
    }
    AppMethodBeat.o(69789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingHeaderPref
 * JD-Core Version:    0.7.0.1
 */