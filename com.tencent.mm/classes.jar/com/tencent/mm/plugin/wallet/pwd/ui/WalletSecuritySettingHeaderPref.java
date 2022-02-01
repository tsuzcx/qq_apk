package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletSecuritySettingHeaderPref
  extends Preference
{
  private TextView Bnb;
  TextView Bnc;
  String Bnd;
  String Bne;
  View.OnClickListener Bnf;
  View.OnClickListener Bng;
  ImageView gDM;
  private MMActivity iMV;
  String qBH;
  private TextView tvL;
  
  public WalletSecuritySettingHeaderPref(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(69786);
    this.iMV = ((MMActivity)paramContext);
    AppMethodBeat.o(69786);
  }
  
  public WalletSecuritySettingHeaderPref(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(69787);
    this.Bnf = null;
    this.Bng = null;
    this.iMV = ((MMActivity)paramContext);
    setLayoutResource(2131496023);
    AppMethodBeat.o(69787);
  }
  
  final void cL()
  {
    AppMethodBeat.i(69789);
    if ((!bs.isNullOrNil(this.qBH)) && (this.tvL != null))
    {
      this.tvL.setText(this.qBH);
      this.tvL.setVisibility(0);
    }
    if ((!bs.isNullOrNil(this.Bnd)) && (this.Bnb != null))
    {
      this.Bnb.setText(this.Bnd);
      this.Bnb.setVisibility(0);
    }
    if ((!bs.isNullOrNil(this.Bne)) && (this.Bnc != null))
    {
      this.Bnc.setText(this.Bne);
      this.Bnc.setVisibility(0);
    }
    if ((bs.isNullOrNil(this.Bne)) && (this.Bnc != null)) {
      this.Bnc.setVisibility(8);
    }
    AppMethodBeat.o(69789);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(69788);
    super.onBindView(paramView);
    ac.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo onBindView");
    this.tvL = ((TextView)paramView.findViewById(2131301985));
    this.Bnb = ((TextView)paramView.findViewById(2131298996));
    this.Bnc = ((TextView)paramView.findViewById(2131299065));
    this.gDM = ((ImageView)paramView.findViewById(2131306831));
    cL();
    if ((this.Bnc != null) && (this.Bnf != null)) {
      this.Bnc.setOnClickListener(this.Bnf);
    }
    if ((this.gDM != null) && (this.Bng != null)) {
      this.gDM.setOnClickListener(this.Bng);
    }
    AppMethodBeat.o(69788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingHeaderPref
 * JD-Core Version:    0.7.0.1
 */