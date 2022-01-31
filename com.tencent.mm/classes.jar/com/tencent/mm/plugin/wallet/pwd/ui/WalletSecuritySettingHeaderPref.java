package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletSecuritySettingHeaderPref
  extends Preference
{
  private MMActivity bER;
  TextView hJw;
  private TextView hiM;
  String jRT;
  private TextView qpJ;
  TextView qpK;
  String qpL;
  String qpM;
  View.OnClickListener qpN = null;
  View.OnClickListener qpO = null;
  
  public WalletSecuritySettingHeaderPref(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.bER = ((MMActivity)paramContext);
  }
  
  public WalletSecuritySettingHeaderPref(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.bER = ((MMActivity)paramContext);
    setLayoutResource(a.g.wallet_security_header_pref);
  }
  
  final void aZ()
  {
    if ((!bk.bl(this.jRT)) && (this.hiM != null))
    {
      this.hiM.setText(this.jRT);
      this.hiM.setVisibility(0);
    }
    if ((!bk.bl(this.qpL)) && (this.qpJ != null))
    {
      this.qpJ.setText(this.qpL);
      this.qpJ.setVisibility(0);
    }
    if ((!bk.bl(this.qpM)) && (this.qpK != null))
    {
      this.qpK.setText(this.qpM);
      this.qpK.setVisibility(0);
    }
    if ((bk.bl(this.qpM)) && (this.qpK != null)) {
      this.qpK.setVisibility(8);
    }
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    y.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo onBindView");
    this.hiM = ((TextView)paramView.findViewById(a.f.main_content));
    this.qpJ = ((TextView)paramView.findViewById(a.f.desc));
    this.qpK = ((TextView)paramView.findViewById(a.f.details_text));
    this.hJw = ((TextView)paramView.findViewById(a.f.wallet_security_close_btn));
    aZ();
    if ((this.qpK != null) && (this.qpN != null)) {
      this.qpK.setOnClickListener(this.qpN);
    }
    if ((this.hJw != null) && (this.qpO != null)) {
      this.hJw.setOnClickListener(this.qpO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingHeaderPref
 * JD-Core Version:    0.7.0.1
 */