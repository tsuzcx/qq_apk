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
  public FavourLayout Iga;
  public TextView Ild;
  public TextView Ile;
  public RadioButton Ilf;
  public CdnImageView qgQ;
  
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
    View.inflate(getContext(), 2131497033, this);
    this.qgQ = ((CdnImageView)findViewById(2131310545));
    this.Ild = ((TextView)findViewById(2131310547));
    this.Ile = ((TextView)findViewById(2131310548));
    this.Ilf = ((RadioButton)findViewById(2131310552));
    this.Iga = ((FavourLayout)findViewById(2131310550));
    AppMethodBeat.o(71323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierBankcardItemLayout
 * JD-Core Version:    0.7.0.1
 */