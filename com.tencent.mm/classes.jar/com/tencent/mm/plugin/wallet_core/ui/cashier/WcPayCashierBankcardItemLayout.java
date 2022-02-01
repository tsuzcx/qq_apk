package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

public class WcPayCashierBankcardItemLayout
  extends LinearLayout
{
  public TextView DBR;
  public TextView DBS;
  public RadioButton DBT;
  public FavourLayout DwP;
  public CdnImageView oTd;
  
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
    View.inflate(getContext(), 2131496053, this);
    this.oTd = ((CdnImageView)findViewById(2131307021));
    this.DBR = ((TextView)findViewById(2131307023));
    this.DBS = ((TextView)findViewById(2131307024));
    this.DBT = ((RadioButton)findViewById(2131307028));
    this.DwP = ((FavourLayout)findViewById(2131307026));
    AppMethodBeat.o(71323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierBankcardItemLayout
 * JD-Core Version:    0.7.0.1
 */