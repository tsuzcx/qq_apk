package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletSecuritySettingHeaderPref
  extends Preference
{
  private TextView HKS;
  TextView HKT;
  String HKU;
  String HKV;
  View.OnClickListener HKW;
  View.OnClickListener HKX;
  private MMActivity gte;
  ImageView hTd;
  String sUf;
  private TextView trw;
  
  public WalletSecuritySettingHeaderPref(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(69786);
    this.gte = ((MMActivity)paramContext);
    AppMethodBeat.o(69786);
  }
  
  public WalletSecuritySettingHeaderPref(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69787);
    this.HKW = null;
    this.HKX = null;
    this.gte = ((MMActivity)paramContext);
    setLayoutResource(2131497003);
    AppMethodBeat.o(69787);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69788);
    super.onBindView(paramView);
    Log.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo onBindView");
    this.trw = ((TextView)paramView.findViewById(2131304321));
    ao.a(this.trw.getPaint(), 0.8F);
    this.HKS = ((TextView)paramView.findViewById(2131299495));
    this.HKT = ((TextView)paramView.findViewById(2131299571));
    this.hTd = ((ImageView)paramView.findViewById(2131310292));
    updateView();
    if ((this.HKT != null) && (this.HKW != null)) {
      this.HKT.setOnClickListener(this.HKW);
    }
    if ((this.hTd != null) && (this.HKX != null)) {
      this.hTd.setOnClickListener(this.HKX);
    }
    AppMethodBeat.o(69788);
  }
  
  final void updateView()
  {
    AppMethodBeat.i(69789);
    if ((!Util.isNullOrNil(this.sUf)) && (this.trw != null))
    {
      this.trw.setText(this.sUf);
      this.trw.setVisibility(0);
    }
    if ((!Util.isNullOrNil(this.HKU)) && (this.HKS != null))
    {
      this.HKS.setText(this.HKU);
      this.HKS.setVisibility(0);
    }
    if ((!Util.isNullOrNil(this.HKV)) && (this.HKT != null))
    {
      this.HKT.setText(this.HKV);
      this.HKT.setVisibility(0);
    }
    if ((Util.isNullOrNil(this.HKV)) && (this.HKT != null)) {
      this.HKT.setVisibility(8);
    }
    AppMethodBeat.o(69789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingHeaderPref
 * JD-Core Version:    0.7.0.1
 */