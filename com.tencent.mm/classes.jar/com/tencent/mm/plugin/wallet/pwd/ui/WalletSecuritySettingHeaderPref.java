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
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletSecuritySettingHeaderPref
  extends Preference
{
  private TextView Avi;
  private TextView Vsb;
  TextView Vsc;
  String Vsd;
  String Vse;
  View.OnClickListener Vsf;
  View.OnClickListener Vsg;
  private MMActivity lzt;
  ImageView nkq;
  String zWm;
  
  public WalletSecuritySettingHeaderPref(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(69786);
    this.lzt = ((MMActivity)paramContext);
    AppMethodBeat.o(69786);
  }
  
  public WalletSecuritySettingHeaderPref(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69787);
    this.Vsf = null;
    this.Vsg = null;
    this.lzt = ((MMActivity)paramContext);
    setLayoutResource(a.g.wallet_security_header_pref);
    AppMethodBeat.o(69787);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69788);
    super.onBindView(paramView);
    Log.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo onBindView");
    this.Avi = ((TextView)paramView.findViewById(a.f.main_content));
    aw.a(this.Avi.getPaint(), 0.8F);
    this.Vsb = ((TextView)paramView.findViewById(a.f.desc));
    this.Vsc = ((TextView)paramView.findViewById(a.f.details_text));
    this.nkq = ((ImageView)paramView.findViewById(a.f.wallet_security_close_btn));
    updateView();
    if ((this.Vsc != null) && (this.Vsf != null)) {
      this.Vsc.setOnClickListener(this.Vsf);
    }
    if ((this.nkq != null) && (this.Vsg != null)) {
      this.nkq.setOnClickListener(this.Vsg);
    }
    AppMethodBeat.o(69788);
  }
  
  final void updateView()
  {
    AppMethodBeat.i(69789);
    if ((!Util.isNullOrNil(this.zWm)) && (this.Avi != null))
    {
      this.Avi.setText(this.zWm);
      this.Avi.setVisibility(0);
    }
    if ((!Util.isNullOrNil(this.Vsd)) && (this.Vsb != null))
    {
      this.Vsb.setText(this.Vsd);
      this.Vsb.setVisibility(0);
    }
    if ((!Util.isNullOrNil(this.Vse)) && (this.Vsc != null))
    {
      this.Vsc.setText(this.Vse);
      this.Vsc.setVisibility(0);
    }
    if ((Util.isNullOrNil(this.Vse)) && (this.Vsc != null)) {
      this.Vsc.setVisibility(8);
    }
    AppMethodBeat.o(69789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingHeaderPref
 * JD-Core Version:    0.7.0.1
 */