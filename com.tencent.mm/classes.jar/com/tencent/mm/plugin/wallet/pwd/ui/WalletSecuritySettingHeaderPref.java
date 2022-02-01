package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletSecuritySettingHeaderPref
  extends Preference
{
  private TextView DeY;
  TextView DeZ;
  String Dfa;
  String Dfb;
  View.OnClickListener Dfc;
  View.OnClickListener Dfd;
  private MMActivity fNT;
  ImageView hai;
  String rtC;
  private TextView uGz;
  
  public WalletSecuritySettingHeaderPref(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(69786);
    this.fNT = ((MMActivity)paramContext);
    AppMethodBeat.o(69786);
  }
  
  public WalletSecuritySettingHeaderPref(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69787);
    this.Dfc = null;
    this.Dfd = null;
    this.fNT = ((MMActivity)paramContext);
    setLayoutResource(2131496023);
    AppMethodBeat.o(69787);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69788);
    super.onBindView(paramView);
    ae.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo onBindView");
    this.uGz = ((TextView)paramView.findViewById(2131301985));
    this.DeY = ((TextView)paramView.findViewById(2131298996));
    this.DeZ = ((TextView)paramView.findViewById(2131299065));
    this.hai = ((ImageView)paramView.findViewById(2131306831));
    updateView();
    if ((this.DeZ != null) && (this.Dfc != null)) {
      this.DeZ.setOnClickListener(this.Dfc);
    }
    if ((this.hai != null) && (this.Dfd != null)) {
      this.hai.setOnClickListener(this.Dfd);
    }
    AppMethodBeat.o(69788);
  }
  
  final void updateView()
  {
    AppMethodBeat.i(69789);
    if ((!bu.isNullOrNil(this.rtC)) && (this.uGz != null))
    {
      this.uGz.setText(this.rtC);
      this.uGz.setVisibility(0);
    }
    if ((!bu.isNullOrNil(this.Dfa)) && (this.DeY != null))
    {
      this.DeY.setText(this.Dfa);
      this.DeY.setVisibility(0);
    }
    if ((!bu.isNullOrNil(this.Dfb)) && (this.DeZ != null))
    {
      this.DeZ.setText(this.Dfb);
      this.DeZ.setVisibility(0);
    }
    if ((bu.isNullOrNil(this.Dfb)) && (this.DeZ != null)) {
      this.DeZ.setVisibility(8);
    }
    AppMethodBeat.o(69789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingHeaderPref
 * JD-Core Version:    0.7.0.1
 */