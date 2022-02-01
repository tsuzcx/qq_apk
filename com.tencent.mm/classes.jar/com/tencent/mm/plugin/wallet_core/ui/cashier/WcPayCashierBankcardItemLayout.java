package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

public class WcPayCashierBankcardItemLayout
  extends LinearLayout
{
  public FavourLayout VOD;
  public TextView VUc;
  public TextView VUd;
  public RadioButton VUe;
  public CdnImageView wGP;
  
  public WcPayCashierBankcardItemLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(71320);
    init();
    AppMethodBeat.o(71320);
  }
  
  public WcPayCashierBankcardItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71321);
    init();
    AppMethodBeat.o(71321);
  }
  
  public WcPayCashierBankcardItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71322);
    init();
    AppMethodBeat.o(71322);
  }
  
  private void init()
  {
    AppMethodBeat.i(71323);
    View.inflate(getContext(), a.g.wc_pay_cashier_bankcard_item, this);
    this.wGP = ((CdnImageView)findViewById(a.f.wpcb_bank_logo_iv));
    this.VUc = ((TextView)findViewById(a.f.wpcb_bankname_tv));
    this.VUd = ((TextView)findViewById(a.f.wpcb_bottom_tips_tv));
    this.VUe = ((RadioButton)findViewById(a.f.wpcb_rb));
    this.VOD = ((FavourLayout)findViewById(a.f.wpcb_favour_layout));
    AppMethodBeat.o(71323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierBankcardItemLayout
 * JD-Core Version:    0.7.0.1
 */