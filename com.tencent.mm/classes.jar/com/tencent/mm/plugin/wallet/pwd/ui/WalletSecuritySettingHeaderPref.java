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
  private TextView CNq;
  TextView CNr;
  String CNs;
  String CNt;
  View.OnClickListener CNu;
  View.OnClickListener CNv;
  private MMActivity fLP;
  ImageView gXw;
  String rlx;
  private TextView uva;
  
  public WalletSecuritySettingHeaderPref(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(69786);
    this.fLP = ((MMActivity)paramContext);
    AppMethodBeat.o(69786);
  }
  
  public WalletSecuritySettingHeaderPref(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69787);
    this.CNu = null;
    this.CNv = null;
    this.fLP = ((MMActivity)paramContext);
    setLayoutResource(2131496023);
    AppMethodBeat.o(69787);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69788);
    super.onBindView(paramView);
    ad.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo onBindView");
    this.uva = ((TextView)paramView.findViewById(2131301985));
    this.CNq = ((TextView)paramView.findViewById(2131298996));
    this.CNr = ((TextView)paramView.findViewById(2131299065));
    this.gXw = ((ImageView)paramView.findViewById(2131306831));
    updateView();
    if ((this.CNr != null) && (this.CNu != null)) {
      this.CNr.setOnClickListener(this.CNu);
    }
    if ((this.gXw != null) && (this.CNv != null)) {
      this.gXw.setOnClickListener(this.CNv);
    }
    AppMethodBeat.o(69788);
  }
  
  final void updateView()
  {
    AppMethodBeat.i(69789);
    if ((!bt.isNullOrNil(this.rlx)) && (this.uva != null))
    {
      this.uva.setText(this.rlx);
      this.uva.setVisibility(0);
    }
    if ((!bt.isNullOrNil(this.CNs)) && (this.CNq != null))
    {
      this.CNq.setText(this.CNs);
      this.CNq.setVisibility(0);
    }
    if ((!bt.isNullOrNil(this.CNt)) && (this.CNr != null))
    {
      this.CNr.setText(this.CNt);
      this.CNr.setVisibility(0);
    }
    if ((bt.isNullOrNil(this.CNt)) && (this.CNr != null)) {
      this.CNr.setVisibility(8);
    }
    AppMethodBeat.o(69789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingHeaderPref
 * JD-Core Version:    0.7.0.1
 */